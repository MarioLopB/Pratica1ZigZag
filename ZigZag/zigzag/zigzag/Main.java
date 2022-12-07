package zigzag;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        StringTokenizer data;
        int min = 0;
        int max = 0;
        int numrows, numcols = 0;
        boolean inputok = true;

        ArrayList<String> col;
        ArrayList<ArrayList<String>> row = new ArrayList<>();

        try {
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                data = new StringTokenizer(line);
                col = new ArrayList<>();

                int space = 0;
                for(int i = 0; i < line.length() && inputok; i++){
                    if(line.charAt(i) == ' '){
                        if(i == 0 || i == line.length()-1){
                            inputok = false;
                        }
                        space++;
                    } else if(space == 1){
                            space = 0;
                    } else if(space == 2){
                        inputok = false;
                    }
                }

                while (data.hasMoreTokens()) {
                    int num = Integer.parseInt(data.nextToken());

                    col.add(String.valueOf(num));
                }
                numcols = col.size();
                row.add(col);
            }

            numrows = row.size();

            ZigZag partida = new ZigZag(numrows, numcols);

            if (partida.isNumColEqual(row)) {
                for (int i = 0; i < numrows; i++) {
                    for (int j = 0; j < numcols; j++) {
                        Direccion elem = new Direccion(i, j, Integer.parseInt(row.get(i).get(j)));
                        partida.addElem(elem);
                    }
                }

                if (partida.isInputOk() && inputok) {
                    partida.Max();
                    partida.Min();

                    if (partida.max != partida.min || partida.getSizeOptions() != 1) {
                        partida.zizagVueltaAtras();

                        partida.imprimeSoluciones();
                    } else {
                        System.out.println("1\n"+partida.max);
                    }

                } else {
                    System.out.println("Entrada incorrecta.");
                }
            } else {
                System.out.println("Entrada incorrecta.");
            }
        } catch (Exception e) {
            System.out.println("Entrada incorrecta.");
        }
    }
}
