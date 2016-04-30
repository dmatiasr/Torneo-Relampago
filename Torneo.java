/*
	Calcular las partidas a partir del jugador que tiene menos hs disponibles con el resto : del mas
	chico al mas grande (del que tiene menos hsDisp al que tiene mas) e ir actualizando la matriz
	de las hs ya ocupadas y calcular el siguiente.

*/
import java.io.*;
import java.util.*;

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
		int[] jugHs0 = {2,3,4,5,14,16};              //2 a 5 y hsDisp = 14hs 16hs --6
		int[] jugHs1 = {14,15,16,20,21};				//14 a 16 y 20hs,21hs --5
		int[] jugHs2 = {2,3,4,23};					//2 a 4 y 23 hs  ---4
		int[] jugHs3 = {13,14,15,16,17,21,22,23};	//13 a 17 y 21hs,22hs,23hs ---8
		int[] jugHs4 = {16,17,18,23};				//16 a 18 y 23hs ---4
		int[] jugHs5 = {0,1,2,3,4,5,6,7,8,9,10,14,15,16,17,23}; //0 a 10, y 14,15,16,17,23 --16
		//creo una matriz
		Tablero tablero= new Tablero();
		//cargo para cada fila(jugador) sus correspondientes horas
		cargaHsDisp(tablero,jug0, jugHs0);
		cargaHsDisp(tablero,jug1, jugHs1);
		cargaHsDisp(tablero,jug2, jugHs2);
		cargaHsDisp(tablero,jug3, jugHs3);
		cargaHsDisp(tablero,jug4, jugHs4);
		cargaHsDisp(tablero,jug5, jugHs5);
		
		//--------------- Fin de carga de datos ---------------------
		//Creo un conjunto vacio, donde guardar los jugadores q ya van jugando
		LinkedList<Integer> set= new LinkedList<Integer>();
		//representa una partida
		Tern<Integer,Integer,Integer> partida = new Tern<Integer,Integer,Integer>();
		//va a guardar la lista de partidas
		LinkedList<Tern> fixture= new LinkedList<Tern>();
		//representa el jugador con menos hs y la cantidad que tiene.
		Pair<Integer,Integer> minJugHs = new Pair<Integer,Integer>();
		Pair<Integer,Integer> sndMinJugHs = new Pair<Integer,Integer>();
		//PROBAR QUE, DADO UN CONJUNTO(LISTA DE JUG) Y TABLERO, SACO EL MINIMO QUE 
		//NO ESTE EN EL CONJUNTO
		set.add(Integer.valueOf(2));
		set.add(Integer.valueOf(4));
		set.add(Integer.valueOf(1));
		set.add(Integer.valueOf(0));
		//set.add(Integer.valueOf(3));
		sndMinJugHs= minNotSet(tablero,set);
		System.out.println("minimo q no esta en el conjunto "+sndMinJugHs.toString());

		//mientras el tamaño de la lista sea menor a la cantidad de jugadores del campeonato.
	/*	for(int i=0;i<tablero.getLengthFil();i++){
			minJugHs = minHsDisp(tablero);
			set.add(Integer.valueOf(minJugHs.getFirst())) //meto el jugador con menos HsDisponibles
			//ahora comparo con el resto de los jugadores
			for(int j=0;j<tablero.getLengthFil()){
				//saco el prox minimo que no pertenezca al conjunto
				

			}

		}
	*/

		//minHsDisp Funciona correcto!
		//System.out.println(tablero.toString());
		//Pair<Integer,Integer> par= new Pair<Integer,Integer>();
		//par= minHsDisp(tablero);
		//System.out.println("El menor es "+par.toString() );
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
		//y lo meto en el par.
		int jug= countHs(0,tablero);
		p.setPair(Integer.valueOf(0),Integer.valueOf(jug));
		int i=1;
		int aux=0;
		while( i<tablero.getLengthFil() ){
			if (jug >= countHs(i,tablero)){ //comparar el primero con los demas e ir guardando el minimo.
				jug=countHs(i,tablero);//actualizo el nuevo minimo
 				p.setPair(Integer.valueOf(i),Integer.valueOf(jug));//le paso el jugador y cuanto tiene
			}			
			i++;
		}
		return p;			
	}
	//CORRREGIRRR SACAR EL SEGUNDO MINIMO QUE NO PERTENEZCA AL CONJUNTO
	//Dado un conjunto y un tablero visto como una lista de jugadores, saco el jugador
	//con menos hsDisponibles que no pertenezca al conjunto
	
	//REHACER MIN CON UN SET

	//PROBAR HACER TENIENDO EN CUENTA EL CONJUNTO
	//PARA 1 ELEM DE TABLERO si la lenght.set == 5 ; queda solo un elem por ver
	//PARA 2 elem si length.set==4 quedan dos elem por ver
	//PARA EL RESTO ()

	public static Pair<Integer,Integer> minNotSet(Tablero tablero, LinkedList set){
		Pair<Integer,Integer> p = new Pair<Integer,Integer>();
		int jug=0;
		
		//jug= countHs(0,tablero);
		//p.setPair(Integer.valueOf(0),Integer.valueOf(jug));
		int i=0;
		while(i<tablero.getLengthFil()-1){
			if (! set.contains(Integer.valueOf(i)) ){ //agarro el primer que no este en el conjunto
				//y lo comparo con los demas que no este en conjunto
				jug= countHs(i,tablero);
				System.out.println("JUGADOR "+i);
				int j=i+1;
				while (j<tablero.getLengthFil()){ 
					if (! set.contains(Integer.valueOf(j) )	){//si el prox tampoco esta, comparo
						if (jug<=countHs(j,tablero)){
							p.setPair(Integer.valueOf(i),Integer.valueOf(jug));
						}
						else{
							jug=countHs(j,tablero);
							i=j;
						}

					}
					j++;
				}
				if (j==tablero.getLengthFil()){
					i=j;
				}				
			}
			i++;	
		}
		if (i==tablero.getLengthFil()-1){ //para agregar al ultimo
			jug= countHs(i,tablero);
			p.setPair(Integer.valueOf(i),Integer.valueOf(jug));
		}

		return p;
	}


}
/* dentro del for interno
System.out.println(" j "+j);	
						if (jug>countHs(j,tablero)){
							jug=countHs(j,tablero);
							p.setPair(Integer.valueOf(j),Integer.valueOf(jug));
							//System.out.println("IF GUARDO "+j);
							i=j;	
						}
						else{
							System.out.println(""+i+"jug "+jug);
							p.setPair(Integer.valueOf(i),Integer.valueOf(jug));
							i=j;						
						}


*/