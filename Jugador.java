import java.util.*;

public class Jugador {
    private int id; //Identificador del jugador
    private LinkedList<Integer> horarios=new LinkedList<Integer>(); //lista con los horarios 

    public Jugador(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void addHorario(int hora){
        horarios.add(hora);
    }

    public boolean existeHorario(int hora){
        return horarios.contains(hora);
    }

    public int[] toArray(){
        int max=23;
        int[] h = new int[horarios.size()];
        for(int i=0;!horarios.isEmpty();i++){
            h[i]=horarios.poll();
        }
        return h;
    }
}