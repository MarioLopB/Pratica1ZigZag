package zigzag;

import java.util.*;
/*
 * Opciones: casillas a elegir
 * Selecionados: casillas elegidas. Solucion parcial.
 * Soluciones: todas las soluciones.
 * 
 * Crear buscar casilla.
 * Crear metodo para comprobar cruces.
 * 
 */

import javax.lang.model.element.Element;
import javax.print.DocFlavor.STRING;
import javax.print.attribute.PrintRequestAttribute;
import javax.print.attribute.standard.NumberOfDocuments;
import javax.swing.plaf.TextUI;
import javax.swing.text.TabableView;

public class ZigZag {
    private int numrows, numcols = 0;
    public int min, max = 0;
    private ArrayList<Direccion> opciones, elegidos;
    private ArrayList<ArrayList<Direccion>> soluciones;

    public ZigZag(int numrows, int numcols) {
        this.opciones = new ArrayList<>();
        this.elegidos = new ArrayList<>();
        this.soluciones = new ArrayList<>();
        this.numrows = numrows;
        this.numcols = numcols;
    }

    public void zizagVueltaAtras() {
        // Solucion total
        if (elegidos.size() == opciones.size() && elegidos.size() == numrows * numcols
                && opciones.get(opciones.size() - 1).fila == elegidos.get(opciones.size() - 1).fila
                && opciones.get(opciones.size() - 1).col == elegidos.get(opciones.size() - 1).col) {
            ArrayList<Direccion> newsol = new ArrayList<>();

            for (int i = 0; i < elegidos.size(); i++) {
                newsol.add(new Direccion(elegidos.get(i).fila, elegidos.get(i).col, elegidos.get(i).num));
                newsol.get(i).setVisited(elegidos.get(i).visited);
            }

            soluciones.add(newsol);
            // Solucion parcial
        } else {
            for (int i = 1; i < opciones.size(); i++) {
                Direccion current = opciones.get(i);
                // Si no ha sido visitado lo relaciona con un nodo
                if (current.visited == 0) {
                    Relacionar(current);
                    // Si ha encontrado relacion, se añade a la solucion parcial y continua con ese
                    // camino
                    // Luego, independientemente de si ha encontrado solución o no, lo elimina de la
                    // parcial y resetea su variable de visitado a 0
                    if (current.visited != 0) {
                        elegidos.add(current);
                        zizagVueltaAtras();
                        elegidos.remove(elegidos.size() - 1);
                        current.visited = 0;
                    }
                }

            }
        }
    }

    // Crea una relacion con la anterior casilla.
    public void Relacionar(Direccion current) {
        Direccion previous = elegidos.get(elegidos.size() - 1);
        int num = previous.num;

        if (current.visited == 0) {
            if (num == max) {
                num = min;
            } else {
                num++;
            }

            if (current.num == num) {
                if (current.fila - 1 == previous.fila && current.col - 1 == previous.col) {
                    // Diagonal Arriba Izquierda
                    if (search(opciones, current.fila, current.col - 1).visited != 3
                            && search(opciones, current.fila - 1, current.col).visited != 6) {
                        current.setVisited(1);
                    }
                } else if (current.fila - 1 == previous.fila && current.col == previous.col) {
                    // Arriba
                    current.setVisited(2);
                } else if (current.fila - 1 == previous.fila && current.col + 1 == previous.col) {
                    // Diagonal Arriba Derecha
                    if (search(opciones, current.fila, current.col + 1).visited != 1
                            && search(opciones, current.fila - 1, current.col).visited != 8) {
                        current.setVisited(3);
                    }
                } else if (current.fila == previous.fila && current.col == previous.col + 1) {
                    // Izquierda
                    current.setVisited(4);
                } else if (current.fila == previous.fila && current.col + 1 == previous.col) {
                    // Derecha
                    current.setVisited(5);
                } else if (current.fila + 1 == previous.fila && current.col - 1 == previous.col) {
                    // Diagonal Abajo Izquierda
                    if (search(opciones, current.fila, current.col - 1).visited != 8
                            && search(opciones, current.fila + 1, current.col).visited != 1) {
                        current.setVisited(6);
                    }
                } else if (current.fila + 1 == previous.fila && current.col == previous.col) {
                    // Abajo
                    current.setVisited(7);
                } else if (current.fila + 1 == previous.fila && current.col + 1 == previous.col) {
                    // Diagonal Abajo Derecha
                    if (search(opciones, current.fila, current.col + 1).visited != 6
                            && search(opciones, current.fila + 1, current.col).visited != 3) {
                        current.setVisited(8);
                    }
                }
            }
        }
    }

    public Direccion search(ArrayList<Direccion> list, int fila, int col) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).fila == fila && list.get(i).col == col) {
                return list.get(i);
            }
        }

        return null;
    }

    public void addElem(Direccion elem) {
        opciones.add(elem);
        if (elegidos.size() == 0) {
            elegidos.add(elem);
        }
    }

    public void imprimeSolucion(ArrayList<Direccion> sol) {
        char[][] tabla = new char[(numrows * 2) - 1][(numcols * 2) - 1];
        int counter = 0;
        for (int i = 0; i < ((numrows * 2) - 1); i++) {
            for (int j = 0; j < ((numcols * 2) - 1); j++) {
                tabla[i][j] = ' ';
            }
        }

        for (int i = 0; i < (numrows * 2) - 1; i++) {
            for (int j = 0; j < (numcols * 2) - 1; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    tabla[i][j] = (char) (opciones.get(counter).num + 48);
                    int n = opciones.get(counter).fila;
                    int m = opciones.get(counter).col;

                    switch (search(sol, n, m).visited) {
                        case 1:
                            tabla[i-1][j - 1] = '\\';
                            break;
                        case 2:
                            tabla[i-1][j] = '|';
                            break;
                        case 3:
                            tabla[i-1][j+1] = '/';
                            break;
                        case 4:
                            tabla[i][j-1] = '-';
                            break;
                        case 5:
                            tabla[i][j+1] = '-';
                            break;
                        case 6:
                            tabla[i+1][j-1] = '/';
                            break;
                        case 7:
                            tabla[i+1][j] = '|';
                            break;
                        case 8:
                            tabla[i+1][j+1] = '\\';
                            break;
                    }

                    counter++;
                }
            }
        }

        for (int i = 0; i < (numrows * 2) - 1; i++) {
            for (int j = 0; j < (numcols * 2) - 1; j++) {
                System.out.print(tabla[i][j]);
            }
            System.out.println("");
        }
    }

    public void imprimeSoluciones() {
        System.out.println(soluciones.size());

        if(max!=min){
            for (int i = 0; i < soluciones.size(); i++) {
                imprimeSolucion(soluciones.get(i));
                if (i != soluciones.size() - 1) {
                    System.out.println("");
                }
            }
        }
    }

    public int Max() {
        for (int i = 0; i < opciones.size(); i++) {
            if (opciones.get(i).num > this.max) {
                this.max = opciones.get(i).num;
            }
        }

        return max;
    }

    public void Min() {
        this.min = opciones.get(0).num;
        for (int i = 0; i < opciones.size(); i++) {
            if (opciones.get(i).num < this.min) {
                this.min = opciones.get(i).num;
            }
        }
    }
}
