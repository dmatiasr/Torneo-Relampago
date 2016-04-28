import java.io.*;
public class Torneo {

	public static void main(String[] args) {
		//Hacer metodos para tomar las horas como parametros(intervalo y hsDisponibilidad) 
		//de linea de entrada para cada jugador
		//Carga de jugadores segun su fila
		int jug1,jug2,jug3,jug4,jug5,jug6;
		jug1=0;
		jug2=1;
		jug3=2;
		jug4=3;
		jug5=4;
		jug6=5;
		//carga de los horarios de cada jugador
		int[] jugHs1 = {2,3,4,5,14,15};              //2 a 5 y hsDisp = 14hs 16hs
		int[] jugHs2 = {14,15,16,20,21};				//14 a 16 y 20hs,21hs
		int[] jugHs3 = {2,3,4,23};					//2 a 4 y 23 hs
		int[] jugHs4 = {13,14,15,16,17,21,22,23};	//13 a 17 y 21hs,22hs,23hs
		int[] jugHs5 = {16,17,18,23};				//16 a 18 y 23hs
		int[] jugHs6 = {0,1,2,3,4,5,6,7,8,9,10,14,15,16,17,23}; //0 a 10, y 14,15,16,17,23
		//creo una matriz
		Tablero tab= new Tablero();
		//cargo para cada fila(jugador) sus correspondientes horas
		cargaHsDisp(tab,jug1, jugHs1);
		cargaHsDisp(tab,jug2, jugHs2);
		cargaHsDisp(tab,jug3, jugHs3);
		cargaHsDisp(tab,jug4, jugHs4);
		cargaHsDisp(tab,jug5, jugHs5);
		cargaHsDisp(tab,jug6, jugHs6);

		System.out.println(tab.toString());

	}

	//para jugador (fila) carga los valores de una lista de intervalos correspondientes a 
	//una hora


	public static void cargaHsDisp(Tablero tab,int fila,int[] intervaloHs){
		for (int i=0; i < intervaloHs.length;i++){
			tab.setPosition(1,fila,intervaloHs[i]);
		}		
	}



}