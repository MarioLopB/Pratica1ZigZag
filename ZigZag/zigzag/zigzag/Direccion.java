package zigzag;

import java.util.*;

public class Direccion {
    public int[] coordenada = new int[2];
    String flecha = "";

    public Direccion(int fila, int col){
        this.coordenada[0] = fila;
        this.coordenada[1] = col;
    }

    public void setVerticalArriba(){
        flecha = "Arriba";
    }

    public void setVerticalAbajo(){
        flecha = "Abajo";
    }

    public void setDiagonalDerechaArriba(){
        flecha = "Diagonal Dercha Arriba";
    }

    public void setDiagonalIzquierdaAbajo(){
        flecha = "Diagonoal Izquierda Abajo";
    }

    public void setDerecha(){
        flecha = "Derecha";
    }

    public void setIzquierda(){
        flecha = "Iquierda";
    }

    public boolean hasFlecha(){
        return flecha == "";
    }
    
}
