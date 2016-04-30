/*
	Calcular las partidas a partir del jugador que tiene menos hs disponibles con el resto : del mas
	chico al mas grande (del que tiene menos hsDisp al que tiene mas) e ir actualizando la matriz
	de las hs ya ocupadas y calcular el siguiente.

*/


import java.io.*;
import java.util.Scanner;
public class Torneo {
	//public  Tablero tablero;
	//public Pair p;
	public static void main(String[] args) {
		//Hacer metodos para tomar las horas como parametros(intervalo y hsDisponibilidad) 
		//de linea de entrada para cada jugador
		//Carga de jugadores segun su fila

		Jugador j0 = new Jugador(0);
		Jugador j1 = new Jugador(1);
		Jugador j2 = new Jugador(2);
		Jugador j3 = new Jugador(3);
		Jugador j4 = new Jugador(4);
		Jugador j5 = new Jugador(5);

		System.out.println("Carga del primer jugador");
		cargaHorarios(j0);
		System.out.println("Carga del segundo jugador");
		cargaHorarios(j1);
		System.out.println("Carga del tercer jugador");
		cargaHorarios(j2);
		System.out.println("Carga del cuarto jugador");
		cargaHorarios(j3);
		System.out.println("Carga del quinto jugador");
		cargaHorarios(j4);
		System.out.println("Carga del sexto jugador");
		cargaHorarios(j5);

		//carga de los horarios de cada jugador
		int[] jugHs0 = j0.toArray();    //2 a 5 y hsDisp = 14hs 16hs
		int[] jugHs1 = j1.toArray();				//14 a 16 y 20hs,21hs
		int[] jugHs2 = j2.toArray();					//2 a 4 y 23 hs
		int[] jugHs3 = j3.toArray();	//13 a 17 y 21hs,22hs,23hs
		int[] jugHs4 = j4.toArray();				//16 a 18 y 23hs
		int[] jugHs5 = j5.toArray(); //0 a 10, y 14,15,16,17,23
		//creo una matriz
		Tablero tablero= new Tablero();
		//cargo para cada fila(jugador) sus correspondientes horas
		cargaHsDisp(tablero,j0.getId(), jugHs0);
		cargaHsDisp(tablero,j1.getId(), jugHs1);
		cargaHsDisp(tablero,j2.getId(), jugHs2);
		cargaHsDisp(tablero,j3.getId(), jugHs3);
		cargaHsDisp(tablero,j4.getId(), jugHs4);
		cargaHsDisp(tablero,j5.getId(), jugHs5);
		
		System.out.println(tablero.toString());
		Pair<Integer,Integer> par= new Pair<Integer,Integer>();
		par= minHsDisp(tablero);
		System.out.println("El menor es "+par.toString() );
	}

	//para jugador (fila) carga los valores de una lista de intervalos correspondientes a 
	//una hora
	public static void cargaHsDisp(Tablero tablero,int fila,int[] intervaloHs){
		for (int i=0; i < intervaloHs.length;i++){
			tablero.setPosition(1,fila,intervaloHs[i]);
		}		
	}
	//calcula cuantas horas ocupadas hay en la fila (cuantos valores 1 hay en esa fila)
	public static int countHs (int fila,Tablero tablero){
		int count=0;
		for (int c=0 ; c<tablero.getLengthCol(); c++){
			if (tablero.tab[fila][c] == 1){
				count++;
			}
		}
		return count;
	}
	//calcular la fila que tiene menos hs disponibles.(jugador con menos hs disponibles.)	
	//retornar la fila (el jugador) y cuantas hsDisponibles tiene.
	public static Pair<Integer,Integer> minHsDisp (Tablero tablero){
		Pair<Integer,Integer> p = new Pair<Integer,Integer>();
		//calculo las hs para el primer jugador y comparo con los demas	
		int jug= countHs(0,tablero);
		p.setPair(Integer.valueOf(0),Integer.valueOf(jug));
		int i=1;
		int aux=0;
		while( i<tablero.getLengthFil() ){
			aux=countHs(i,tablero);
			if (jug > aux){ //comparar el primero con los demas e ir guardando el minimo.
				jug=countHs(i,tablero);//actualizo el nuevo minimo
 				p.setPair(Integer.valueOf(i),Integer.valueOf(jug));//le paso el jugador y cuanto tiene
			}			
			i++;
		}
		return p;			
	}

	public static void cargaHorarios (Jugador j){
		Scanner scan = new Scanner(System.in);
		char op='s';
		int i=0;
		while (i<23 && op=='s'){
			System.out.print("Ingrese un horario: ");
			int hora = scan.nextInt();
			while (j.existeHorario(hora)||(0>hora)||(hora>23)) {
				System.out.println("Dato incorrecto");
				System.out.print("Ingrese un horario valido (0..23): ");
				hora = scan.nextInt();
			}
			j.addHorario(hora);
			if(i>=5){
				System.out.print("Otro? s/n ");
				op=scan.next().charAt(0);
			}
			i++;
		}
	}

}
