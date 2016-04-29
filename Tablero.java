public class Tablero {
	public int[][] tab;
	private int fila=6;
	private int col=24;
	//Inicializa el tablero con posiciones False = 0
	public Tablero (){
		tab = new int[fila][col];
		for (int i=0; i < fila; i++){
			for (int j=0 ; j < col ; j++){
				tab[i][j]= 0;
			}
		}
	}
	//Devuelve el tamaño de la columna
	public int getLengthCol (){
		return col;
	}
	public int getLengthFil(){
		return fila;
	}


	//setea el valor de verdad de la posicion
	public void setPosition (int v, int f, int c){
		tab[f][c]=v;
	}

	//to string del tablero.
	public String toString() {
        String s = "\n\t  ------------------------------------------------------------------------------------------------ \n\t";
        for (int f = 0; f < fila; f++) {
            for (int c = 0; c < col; c++) {
               s = s + " | "+tab[f][c];
            }
            s = s + " | \n\t  ------------------------------------------------------------------------------------------------ \n\t";
        }
        s = s + "   0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18  19  20  21  22  23  \n";
        return s;
    }
    

}