package zigzag;

import java.util.*;

public class Direccion {
    public int fila, col;
    public ArrayList<Direccion> direcciones = new ArrayList<>();
    public boolean visited = false;

    public Direccion(int fila, int col){
        this.fila = fila;
        this.col = col;
    }

    public void addDireccion(int fila, int col){
        Direccion nueva = new Direccion(fila, col);
        direcciones.add(nueva);
    }

    public String toString(){
        StringBuffer salida = new StringBuffer();
        for(int i = 0; i < direcciones.size()-1; i++){
            salida.append("["+fila+","+col+"]");
        }
        return salida.toString();
    }
    
}
