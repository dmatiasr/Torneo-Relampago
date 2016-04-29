/*
	Calcular las partidas a partir del jugador que tiene menos hs disponibles con el resto : del mas
	chico al mas grande (del que tiene menos hsDisp al que tiene mas) e ir actualizando la matriz
	de las hs ya ocupadas y calcular el siguiente.

*/


import java.io.*;
public class Torneo {
	//public  Tablero tablero;
	//public Pair p;
	public static void main(String[] args) {
		//Hacer metodos para tomar las horas como parametros(intervalo y hsDisponibilidad) 
		//de linea de entrada para cada jugador
		//Carga de jugadores segun su fila
		int jug0,jug1,jug2,jug3,jug4,jug5;
		jug0=0;
		jug1=1;
		jug2=2;
		jug3=3;
		jug4=4;
		jug5=5;
		//carga de los horarios de cada jugador
		int[] jugHs0 = {2,3,4,5,14,16};              //2 a 5 y hsDisp = 14hs 16hs
		int[] jugHs1 = {14,15,16,20,21};				//14 a 16 y 20hs,21hs
		int[] jugHs2 = {2,3,4,23};					//2 a 4 y 23 hs
		int[] jugHs3 = {13,14,15,16,17,21,22,23};	//13 a 17 y 21hs,22hs,23hs
		int[] jugHs4 = {16,17,18,23};				//16 a 18 y 23hs
		int[] jugHs5 = {0,1,2,3,4,5,6,7,8,9,10,14,15,16,17,23}; //0 a 10, y 14,15,16,17,23
		//creo una matriz
		Tablero tablero= new Tablero();
		//cargo para cada fila(jugador) sus correspondientes horas
		cargaHsDisp(tablero,jug0, jugHs0);
		cargaHsDisp(tablero,jug1, jugHs1);
		cargaHsDisp(tablero,jug2, jugHs2);
		cargaHsDisp(tablero,jug3, jugHs3);
		cargaHsDisp(tablero,jug4, jugHs4);
		cargaHsDisp(tablero,jug5, jugHs5);
		
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
			System.out.println("jugador "+i);
			System.out.println(""+i+" < "+tablero.getLengthFil());
			aux=countHs(i,tablero);
			if (jug > aux){ //comparar el primero con los demas e ir guardando el minimo.
				jug=countHs(i,tablero);//actualizo el nuevo minimo
 				p.setPair(Integer.valueOf(i),Integer.valueOf(jug));//le paso el jugador y cuanto tiene
			}			
			i++;
		}
		return p;			
	}

}
