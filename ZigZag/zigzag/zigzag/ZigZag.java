package zigzag;

import java.util.*;

import javax.print.DocFlavor.STRING;
import javax.print.attribute.standard.NumberOfDocuments;

public class ZigZag {
    private static int numrows, numcols, numnodos;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> col = new ArrayList<>();
        ArrayList<ArrayList<String>> row = new ArrayList<>();

        String data = sc.nextLine();

        while (sc.hasNextLine()) {
            col.add(sc.nextLine());
            row.add(col);
        }

        numrows = row.size();
        numcols = col.size();
        numnodos = numrows * numcols;

    }

    public void zizagVueltaAtras(ArrayList<ArrayList<String>> matriz, Direccion nodo, int fila, int col, int pos) {
        if (pos == numnodos - 1) {

        }
    }

    public boolean hasWay(int fila, int col, ArrayList<ArrayList<String>> matriz) {
        Direccion flecha = new Direccion(fila, col);
        if (fila == 0 && col == 0) {
            if (!flecha.hasFlecha()) {
                if (Integer.parseInt(matriz.get(fila).get(col)) < Integer.parseInt(matriz.get(fila).get(col + 1))) {
                    flecha.setDerecha();
                    return true;
                } else if (Integer.parseInt(matriz.get(fila).get(col)) < Integer
                        .parseInt(matriz.get(fila + 1).get(col))) {
                    flecha.setVerticalAbajo();
                    return true;
                } else {
                    if (Integer.parseInt(matriz.get(fila).get(col + 1)) < Integer
                            .parseInt(matriz.get(fila + 1).get(col))) {
                        flecha.setVerticalAbajo();
                        return true;
                    } else {
                        flecha.setDerecha();
                        return true;
                    }
                }
            }
        } else if (fila == numrows - 1 && col == 0) {
            if (!flecha.hasFlecha()) {
                if (Integer.parseInt(matriz.get(fila).get(col)) < Integer.parseInt(matriz.get(fila + 1).get(col))) {
                    flecha.setVerticalArriba();
                    return true;
                } else if (Integer.parseInt(matriz.get(fila).get(col)) < Integer
                        .parseInt(matriz.get(fila).get(col + 1))) {
                    flecha.setDerecha();
                    return true;
                } else {
                    if (Integer.parseInt(matriz.get(fila + 1).get(col)) < Integer
                            .parseInt(matriz.get(fila + 1).get(col + 1))) {
                        flecha.setVerticalArriba();
                        return true;
                    } else {
                        flecha.setDerecha();
                        return true;
                    }
                }
            } else if (fila == numrows - 1 && col == numcols - 1) {
                if (!flecha.hasFlecha()) {
                    if (Integer.parseInt(matriz.get(fila).get(col)) < Integer.parseInt(matriz.get(fila + 1).get(col))) {
                        flecha.setVerticalArriba();
                        return true;
                    } else if (Integer.parseInt(matriz.get(fila).get(col)) < Integer
                            .parseInt(matriz.get(fila).get(col + 1))) {
                        flecha.setDerecha();
                        return true;
                    } else {
                        if (Integer.parseInt(matriz.get(fila + 1).get(col)) < Integer
                                .parseInt(matriz.get(fila + 1).get(col + 1))) {
                            flecha.setVerticalArriba();
                            return true;
                        } else {
                            flecha.setDerecha();
                            return true;
                        }
                    }
                }
            }

            return false;
        }
    }

}
