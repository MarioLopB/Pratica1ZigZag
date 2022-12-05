package zigzag;

import java.util.*;

import javax.print.DocFlavor.STRING;
import javax.print.attribute.standard.NumberOfDocuments;
import javax.swing.plaf.TextUI;

public class ZigZag {
    public static int numrows, numcols, min, max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        StringTokenizer data;

        ArrayList<String> col;
        ArrayList<ArrayList<String>> row = new ArrayList<>();

        while (sc.hasNextLine()) {
            line = sc.nextLine();
            data = new StringTokenizer(line);
            col = new ArrayList<>();
            while (data.hasMoreTokens()) {
                int num = Integer.parseInt(data.nextToken());
                if (num < min) {
                    min = num;
                } else if (num > max) {
                    max = num;
                }

                col.add(String.valueOf(num));
            }
            numcols = col.size();
            row.add(col);
        }

        numrows = row.size();

        int matriz[][] = new int[numrows][numcols];

        for (int i = 0; i < numrows; i++) {
            for (int j = 0; j < numcols; j++) {
                matriz[i][j] = Integer.parseInt(row.get(i).get(j));
            }
        }

        int valor = 0;

    }

    public void zizagVueltaAtras(int[][] matriz, Direccion nodo, int fila, int col, int pos) {
        Direccion flecha = new Direccion(fila, col);
        addWays(fila, col, matriz, flecha);
    }

    public void makePath(int[][] matriz){
        for(int i = 0; i < numrows-1; i++){
            for(int j = 0; j < numcols-1; j++){
                Direccion flecha = new Direccion(i, j);
                addWays(i, j, matriz, flecha);
            }
        }
    }

    public void addWays(int fila, int col, int[][] matriz, Direccion flecha) {
        if (fila == 0 && col == 0) {
            if (matriz[fila][col] == max) {
                if (min == matriz[fila][col + 1]) {
                    flecha.addDireccion(fila, col + 1);
                }
                if (min == matriz[fila + 1][col]) {
                    flecha.addDireccion(fila + 1, col);
                }
                if (min == matriz[fila + 1][col + 1]) {
                    flecha.addDireccion(fila + 1, col + 1);
                }
            } else {
                if (matriz[fila][col] < matriz[fila][col + 1]) {
                    flecha.addDireccion(fila, col + 1);
                } if(matriz[fila][col] < matriz[fila+1][col]) {
                    flecha.addDireccion(fila+1, col);
                }
                if (matriz[fila][col] < matriz[fila + 1][col+1]) {
                    flecha.addDireccion(fila + 1, col+1);
                } 
            }
        } else if(col == 0){
            if (matriz[fila][col] == max) {
                if (min == matriz[fila+1][col]) {
                    flecha.addDireccion(fila+1, col);
                }
                if (min == matriz[fila-1][col]) {
                    flecha.addDireccion(fila-1, col);
                    ;
                } 
                if (min == matriz[fila][col+1]) {
                    flecha.addDireccion(fila, col+1);
                }
                if (min == matriz[fila + 1][col + 1]) {
                    flecha.addDireccion(fila + 1, col + 1);
                }
                if (min == matriz[fila - 1][col + 1]) {
                    flecha.addDireccion(fila - 1, col + 1);
                }
            } else{
                if (matriz[fila][col] < matriz[fila+1][col]) {
                    flecha.addDireccion(fila+1, col);
                }
                if (matriz[fila][col] < matriz[fila-1][col]) {
                    flecha.addDireccion(fila-1, col);
                } 
                if (matriz[fila][col] < matriz[fila][col+1]) {
                    flecha.addDireccion(fila, col+1);
                }
                if (matriz[fila][col] < matriz[fila + 1][col + 1]) {
                    flecha.addDireccion(fila + 1, col + 1);
                }
                if (matriz[fila][col] < matriz[fila - 1][col + 1]) {
                    flecha.addDireccion(fila - 1, col + 1);
                }
            }
        } else if(col == numrows-1){
            if (matriz[fila][col] == max) {
                if (min == matriz[fila+1][col]) {
                    flecha.addDireccion(fila+1, col);
                }
                if (min == matriz[fila-1][col]) {
                    flecha.addDireccion(fila-1, col);
                    ;
                } 
                if (min == matriz[fila][col-1]) {
                    flecha.addDireccion(fila, col-1);
                }
                if (min == matriz[fila + 1][col - 1]) {
                    flecha.addDireccion(fila + 1, col - 1);
                }
                if (min == matriz[fila - 1][col + 1]) {
                    flecha.addDireccion(fila - 1, col - 1);
                }
            } else{
                if (matriz[fila][col] < matriz[fila+1][col]) {
                    flecha.addDireccion(fila+1, col);
                }
                if (matriz[fila][col] < matriz[fila-1][col]) {
                    flecha.addDireccion(fila-1, col);
                } 
                if (matriz[fila][col] < matriz[fila][col-1]) {
                    flecha.addDireccion(fila, col-1);
                }
                if (matriz[fila][col] < matriz[fila + 1][col - 1]) {
                    flecha.addDireccion(fila + 1, col - 1);
                }
                if (matriz[fila][col] < matriz[fila - 1][col - 1]) {
                    flecha.addDireccion(fila - 1, col - 1);
                }
            }
        } else if(fila == 0){
            if (matriz[fila][col] == max) {
                if (min == matriz[fila+1][col]) {
                    flecha.addDireccion(fila+1, col);
                }
                if (min == matriz[fila][col-1]) {
                    flecha.addDireccion(fila, col-1);
                } 
                if (min == matriz[fila][col+1]) {
                    flecha.addDireccion(fila, col+1);
                }
                if (min == matriz[fila + 1][col - 1]) {
                    flecha.addDireccion(fila + 1, col - 1);
                }
                if (min == matriz[fila + 1][col + 1]) {
                    flecha.addDireccion(fila + 1, col + 1);
                }
            } else{
                if (matriz[fila][col] < matriz[fila+1][col]) {
                    flecha.addDireccion(fila+1, col);
                }
                if (matriz[fila][col] < matriz[fila][col-1]) {
                    flecha.addDireccion(fila, col-1);
                }
                if (matriz[fila][col] < matriz[fila][col+1]) {
                    flecha.addDireccion(fila, col+1);
                }
                if (matriz[fila][col] < matriz[fila + 1][col - 1]) {
                    flecha.addDireccion(fila + 1, col - 1);
                }
                if (matriz[fila][col] < matriz[fila + 1][col + 1]) {
                    flecha.addDireccion(fila + 1, col + 1);
                }
            }
        }else if(fila == numrows-1){
            if (matriz[fila][col] == max) {
                if (min == matriz[fila-1][col]) {
                    flecha.addDireccion(fila-1, col);
                }
                if (min == matriz[fila][col-1]) {
                    flecha.addDireccion(fila, col-1);
                } 
                if (min == matriz[fila][col+1]) {
                    flecha.addDireccion(fila, col+1);
                }
                if (min == matriz[fila + 1][col - 1]) {
                    flecha.addDireccion(fila - 1, col - 1);
                }
                if (min == matriz[fila + 1][col + 1]) {
                    flecha.addDireccion(fila - 1, col + 1);
                }
            } else{
                if (matriz[fila][col] < matriz[fila-1][col]) {
                    flecha.addDireccion(fila-1, col);
                }
                if (matriz[fila][col] < matriz[fila][col-1]) {
                    flecha.addDireccion(fila, col-1);
                }
                if (matriz[fila][col] < matriz[fila][col+1]) {
                    flecha.addDireccion(fila, col+1);
                }
                if (matriz[fila][col] < matriz[fila - 1][col - 1]) {
                    flecha.addDireccion(fila - 1, col - 1);
                }
                if (matriz[fila][col] < matriz[fila - 1][col + 1]) {
                    flecha.addDireccion(fila - 1, col + 1);
                }
            }
        } else if (fila == numrows - 1 && col == 0) {
            if (matriz[fila][col] == max) {
                if (min == matriz[fila - 1][col]) {
                    flecha.addDireccion(fila - 1, col);
                } 
                if (min == matriz[fila - 1][col + 1]) {
                    flecha.addDireccion(fila - 1, col + 1);
                    ;
                } 
                if (min == matriz[fila][col + 1]) {
                    flecha.addDireccion(fila, col + 1);
                }

            } else{
                if (matriz[fila][col] < matriz[fila - 1][col]) {
                    flecha.addDireccion(fila - 1, col);
                } 
                if (matriz[fila][col] < matriz[fila - 1][col + 1]) {
                    flecha.addDireccion(fila - 1, col + 1);
                } 
                if (matriz[fila][col] < matriz[fila][col + 1]) {
                    flecha.addDireccion(fila, col + 1);
                } 
            }
        } else if (fila == 0 && col == numcols - 1) {
            if (matriz[fila][col] == max) {
                if (min == matriz[fila][col - 1]) {
                    flecha.addDireccion(fila, col - 1);
                } 
                if (min == matriz[fila + 1][col - 1]) {
                    flecha.addDireccion(fila + 1, col - 1);
                } 
                if (min == matriz[fila + 1][col]) {
                    flecha.addDireccion(fila + 1, col);
                }

            } else{
                if (matriz[fila][col] < matriz[fila][col - 1]) {
                    flecha.addDireccion(fila, col - 1);
                } 
                if (matriz[fila][col] < matriz[fila + 1][col - 1]) {
                    flecha.addDireccion(fila + 1, col - 1);
                } 
                if (matriz[fila][col] < matriz[fila + 1][col]) {
                    flecha.addDireccion(fila + 1, col + 1);
                }
            }

        } else if (fila == numrows - 1 && col == numcols - 1) {
            if (matriz[fila][col] == max) {
                if (min == matriz[fila][col - 1]) {
                    flecha.addDireccion(fila, col - 1);
                } 
                if (min == matriz[fila - 1][col - 1]) {
                    flecha.addDireccion(fila - 1, col - 1);
                } 
                if (min == matriz[fila - 1][col]) {
                    flecha.addDireccion(fila - 1, col);
                }

            } else{
                if (matriz[fila][col] < matriz[fila][col - 1]) {
                    flecha.addDireccion(fila, col - 1);
                } 
                if (matriz[fila][col] < matriz[fila - 1][col - 1]) {
                    flecha.addDireccion(fila - 1, col - 1);
                } 
                if (matriz[fila][col] < matriz[fila - 1][col]) {
                    flecha.addDireccion(fila - 1, col);
                } 
            }
        } else {
            if (matriz[fila][col] == max) {
                if (min == matriz[fila][col - 1]) {
                    flecha.addDireccion(fila, col - 1);
                } 
                if (min == matriz[fila][col + 1]) {
                    flecha.addDireccion(fila, col + 1);
                } 
                if (min == matriz[fila - 1][col]) {
                    flecha.addDireccion(fila - 1, col);
                } 
                if (min == matriz[fila + 1][col]) {
                    flecha.addDireccion(fila + 1, col);
                } 
                if (min == matriz[fila - 1][col + 1]) {
                    flecha.addDireccion(fila - 1, col + 1);
                } 
                if (min == matriz[fila + 1][col + 1]) {
                    flecha.addDireccion(fila + 1, col + 1);
                } 
                if (min == matriz[fila - 1][col - 1]) {
                    flecha.addDireccion(fila - 1, col - 1);
                } 
                if (min == matriz[fila + 1][col - 1]) {
                    flecha.addDireccion(fila + 1, col - 1);
                }

            } else{
                if (matriz[fila][col] < matriz[fila][col - 1]) {
                    flecha.addDireccion(fila, col - 1);
                } 
                if (matriz[fila][col] < matriz[fila][col + 1]) {
                    flecha.addDireccion(fila, col + 1);
                } 
                if (matriz[fila][col] < matriz[fila - 1][col]) {
                    flecha.addDireccion(fila - 1, col);
                } 
                if (matriz[fila][col] < matriz[fila + 1][col]) {
                    flecha.addDireccion(fila + 1, col);
                } 
                if (matriz[fila][col] < matriz[fila - 1][col + 1]) {
                    flecha.addDireccion(fila - 1, col + 1);
                } 
                if (matriz[fila][col] < matriz[fila + 1][col + 1]) {
                    flecha.addDireccion(fila + 1, col + 1);
                } 
                if (matriz[fila][col] < matriz[fila - 1][col - 1]) {
                    flecha.addDireccion(fila - 1, col - 1);
                } if (matriz[fila][col] < matriz[fila + 1][col - 1]) {
                    flecha.addDireccion(fila + 1, col - 1);
                } 
            }
            
        }
    }
}
