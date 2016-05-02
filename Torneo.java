/*
	Calcular las partidas a partir del jugador que tiene menos hs disponibles con el resto : del mas
	chico al mas grande (del que tiene menos hsDisp al que tiene mas) e ir actualizando la matriz
	de las hs ya ocupadas y calcular el siguiente.
	
	El conteo de jugadores comienza desde el numero 0 ; Jugador 0, jug 1, jug 2, jug 3, jug 4, jug 5.
	Hacen un total de 6 jugadores.

*/


import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.util.InputMismatchException;

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
		try{
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
		}catch (InputMismatchException e) {
            throw new IllegalArgumentException();
        } 

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
		
	
		// int jug0,jug1,jug2,jug3,jug4,jug5;
		// jug0=0;
		// jug1=1;
		// jug2=2;
		// jug3=3;
		// jug4=4;
		// jug5=5;
		// //carga de los horarios de cada jugador
		// int[] jugHs0 = {0,1,2,3,4,5,6,7,8,9,10}; //{2,3,4,5,14,16};              //2 a 5 y hsDisp = 14hs 16hs --6
		// int[] jugHs1 = {5,6,7,8,9,10,11,12,13,14,15};//{14,15,16,20,21,3};				//14 a 16 y 20hs,21hs --5
		// int[] jugHs2 = {5,6,7,8,9,10,11,12,13,14,15};							//{2,3,4,23};					//2 a 4 y 23 hs  ---4
		// int[] jugHs3 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};							//{13,14,15,16,17,21,22,23};	//13 a 17 y 21hs,22hs,23hs ---8
		// int[] jugHs4 = {9,10,11,12,13,14,15,16,17,18,19,20,21,22};							//{16,17,18,23};				//16 a 18 y 23hs ---4
		// int[] jugHs5 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};		//{0,1,2,3,4,5,6,7,8,9,10,14,15,16,17,23}; //0 a 10, y 14,15,16,17,23 --16
		// //creo una matriz
		// Tablero tablero= new Tablero();
		// //cargo para cada fila(jugador) sus correspondientes horas
		// cargaHsDisp(tablero,jug0, jugHs0);
		// cargaHsDisp(tablero,jug1, jugHs1);
		// cargaHsDisp(tablero,jug2, jugHs2);
		// cargaHsDisp(tablero,jug3, jugHs3);
		// cargaHsDisp(tablero,jug4, jugHs4);
		// cargaHsDisp(tablero,jug5, jugHs5);


		System.out.println(tablero.toString());
		
		//--------------- Fin de carga de datos ---------------------
		//Creo un conjunto vacio, donde guardar los jugadores q ya van jugando
		LinkedList<Integer> setMinJugando= new LinkedList<Integer>();
		//Un "conjunto" donde esten los jugadores que ya jugaron
		LinkedList<Integer> setMinJugaron= new LinkedList<Integer>();
		//representa una partida
		Tern<Integer,Integer,Integer> partida = new Tern<Integer,Integer,Integer>();
		//va a guardar la lista de partidas
		LinkedList<String> fixture= new LinkedList<String>();
		//representa el jugador con menos hs y la cantidad que tiene.
		Pair<Integer,Integer> minJugHs = new Pair<Integer,Integer>();
		//el segundo jugador con menos hs y la cantidad que tiene
		Pair<Integer,Integer> nextMinJugHs = new Pair<Integer,Integer>();
		
		//mientras el tamaño de la lista sea menor a la cantidad de jugadores del campeonato.
		//mientras no sean las 15 partidas para armar.
		
		Integer intersecc = new Integer(0);
		int i=0;
		while( !fullList(setMinJugando)  ){
			minJugHs = minNotSet(tablero,setMinJugando); //saco el minimo distinto de cero.
			setMinJugando.add( minJugHs.getFirst() ); //meto el jugador con menos HsDisponibles
			//ahora comparo con el resto de los jugadores
			//saco el prox minimo que no pertenezca al conjunto
			//mientras el minimo que estoy tratando no sea cero

			while( !fullList(setMinJugando)  ) {
				nextMinJugHs= minNotSet(tablero,setMinJugando);
				//saco la hora que tienen en comun los jugadores que menos Hs Disponibles tienen
				
				intersecc = interseccionHs(minJugHs.getFirst(),nextMinJugHs.getFirst(),tablero);		
				if ( !(intersecc.intValue()==300)){ 
				//Si la interseccion es 0, entonces no pueden enfrentarse ambos jugadores
				//porque no hay horarios en comun.
				//entonces, no se puede armar el fixture.
					//guardo la partida y a que hora
					partida.setTern(minJugHs.getFirst(),nextMinJugHs.getFirst(),intersecc);		
					fixture.add(partida.toString());
					//actualizo a ambos que ya no pueden jugar a esa hora con nadie mas
					     		//hs      jug1                  jug2                  tablero
					actualizaHs(intersecc,minJugHs.getFirst(),nextMinJugHs.getFirst(),tablero);
					
					//meto al conjunto de jugando al nextMinJugHs
					setMinJugando.add( nextMinJugHs.getFirst() );
				}
				else {
					String msg = " NO TIENEN HORAS EN COMUN O YA SE ENCUENTRAN OCUPADAS ";
					throw new IllegalArgumentException("Jug "+minJugHs.getFirst()+" Y Jug "+nextMinJugHs.getFirst()+msg);
				}
			}
			setMinJugando.clear(); //Limpio la lista de los que estan jugando (1 contra todos).
			setMinJugaron.add(minJugHs.getFirst() ); //lista de jugadores que ya esta armado sus encuentros
			setMinJugando = (LinkedList<Integer>) setMinJugaron.clone(); //Recuerdo cuales jugadores ya van jugando para no volver a analizarlos
			// a tratarlos nuevamente.
		
		}
		//Muestro el resultado del fixture armado.
		String result = toStringTern(fixture);
		System.out.println(result);

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
	

	public static void cargaHorarios (Jugador j){
			Scanner scan = new Scanner(System.in);
			char op='s';
			int i=0;
			int hora =0;
			while (i<24 && op=='s'){
				System.out.print("Ingrese un horario: ");
				hora = scan.nextInt();
				while (j.existeHorario(hora)||(0>hora)||(hora>23)) {
					System.out.println("Dato incorrecto");
					System.out.print("Ingrese un horario valido (0..23): ");
					hora = scan.nextInt();
				}
				j.addHorario(hora);
				if(i>=5 && i<23){
					System.out.print("Otro? s/n ");
					op=scan.next().charAt(0);
				}
				i++;
			}
	}

	//Dado un conjunto y un tablero visto como una lista de jugadores, saco el jugador
	//con menos hsDisponibles que no pertenezca al conjunto
	// Return Min PAR = (Jug,CantidadHsDisp)
	public static Pair<Integer,Integer> minNotSet(Tablero tablero, LinkedList<Integer> set){
		Pair<Integer,Integer> p = new Pair<Integer,Integer>();
		int jug=0;
		if (set.size()==5){
			//tamaño del set es 5, entonces hay que buscar solo el q queda.
			//el unico que no este en el conjunto
			for (int i=0;i<tablero.getLengthFil();i++){
				if (!set.contains(Integer.valueOf(i))){
					jug=countHs(i,tablero);
					p.setPair(Integer.valueOf(i),Integer.valueOf(jug));
				}
			}
		}
		else {
			//Hay mas de un elemento a buscar.
			int i=0;
			while(i<tablero.getLengthFil()-1){
				if (! set.contains(Integer.valueOf(i)) && !(countHs(i,tablero)==0) ){ 
				    //agarro el primer que no este en el conjunto, y que no sea 0 la cantidad de hs.
					//y lo comparo con los demas que no este en conjunto
					jug= countHs(i,tablero);
					int j=i+1;
					while (j<tablero.getLengthFil()){ 
						//si j no esta en el Set, y las horas de j no son cero
						if (! set.contains(Integer.valueOf(j) )	&& !(countHs(j,tablero)==0) ){
							//si el prox tampoco esta, comparo
							if (jug<=countHs(j,tablero)){
								//guardo el minimo y sigo comparando con el resto
								p.setPair(Integer.valueOf(i),Integer.valueOf(jug));
							}
							else{
								//se calcula el nuevo minimo y se compara con el resto desde el hacia los demas
								jug=countHs(j,tablero);
								i=j;
							}	
						}
						j++;
					}
					//Si j ya recorrio todos, que no salte a buscar desde el proximo
					//que corte con el minimo q ya encontro, que es el correcto.
					if (j==tablero.getLengthFil()){
						i=j;
					}				
				}
				i++;	
			}
			//caso si el ultimo es el minimo, no controlado en el ciclo porq se va de rango "i".
			if (p.getSecond() > countHs(tablero.getLengthFil()-1,tablero) ){
				jug=countHs(tablero.getLengthFil()-1,tablero);
				p.setPair(Integer.valueOf(tablero.getLengthFil()-1),Integer.valueOf(jug ) );
			}
		}	
			return p;
	}
	//Dados 2 jugadores, buscar la interseccion (la primer o unica hs disponible que tienen
	//en comun, si es 0 "vacio" ,entonces no tienen interseccion en comun)
	//El primer parametro va a ser el que menos hs tiene
	public static Integer interseccionHs(Integer jug1,Integer jug2,Tablero tablero){
		Integer intersec= new Integer(300);//Si no comparten hs, retorna 0.
		for (int c=0;c<tablero.getLengthCol();c++){
			if (tablero.tab[jug1][c]==1){ //si el jugador1 en esa col==1
				//System.out.println("Valor Tablero Jug1 "+tablero.tab[jug1][c]);
				//System.out.println("Posicion "+c);
				
				if(tablero.tab[jug2][c]==1){//si el jugador2 en esa col==1
				
				//System.out.println("valor tablero jug2 "+tablero.tab[jug1][c]);	//entonces comparten hs

					intersec=Integer.valueOf(c); //y es la hora "c"
					return intersec;
					//para agarrar la primer interseccion entre ambos.
					//c=tablero.getLengthCol();
				}
			}
		}
		return intersec;
				
	}
	//Dada una hora y dos jugadores, setea en 0 la hora que comparten los jugadores
	//en el tablero.
	public static void actualizaHs (Integer hora,Integer jug1,Integer jug2,Tablero tablero){
		tablero.setPosition(0,jug1.intValue(),hora.intValue()); //no hay mas interseccion en esta hora.
		tablero.setPosition(0,jug2.intValue(),hora.intValue());
	} 
	//Si una lista esta llena de jugadores, entonces o jugo 1 con todos, o todos con todos.
	public static boolean fullList(LinkedList l){
		return (l.size() == 6 ); //si el tamaño de la lista es la cantidad de jugadores
	}
	//Mostrar el contenido de la lista de ternas
	public static String toStringTern(LinkedList fixt){
		String str ="";
		int i=0;	
		while (i < fixt.size()){
			str += fixt.get(i);
			i++;
		}
		return str;
	}


}
