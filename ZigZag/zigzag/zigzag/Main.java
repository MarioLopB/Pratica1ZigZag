package zigzag;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        StringTokenizer data;
        int min = 1;
        int max = 0;
        int numrows, numcols = 0;

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

        ZigZag partida = new ZigZag(min, max, numrows, numcols);

        for (int i = 0; i < numrows; i++) {
            for (int j = 0; j < numcols; j++) {
                Direccion elem = new Direccion(i, j, Integer.parseInt(row.get(i).get(j)));
                partida.addElem(elem);
            }
        }

        partida.zizagVueltaAtras();
        
        partida.imprimeSoluciones();

    }
}