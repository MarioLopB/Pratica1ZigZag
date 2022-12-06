package zigzag;

import java.util.*;

public class Direccion {
    public int num;
    public int fila, col;
    public int visited = 0;

    public Direccion(int fila, int col, int num){
        this.fila = fila;
        this.col = col;
        this.num = num;
    }

    public void setVisited(int visited){
        this.visited = visited;
    }
    
}
