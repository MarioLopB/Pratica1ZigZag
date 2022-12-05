package puzleZigzag;

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MainTestsDavid {
    private static InputStream in;
    private static PrintStream out;

    /**
     * Este método se ejecuta antes de la ejecución de cada test.
     * Permite almacenar los flujos que tiene la máquina java
     * para la entrada y salida estándar
     * 
     * @throws Exception
     */
    @Before
    public void realizaAntesDeCadaTest() throws Exception {
        in = System.in;
        out = System.out;
    }

    /**
     * Este método se ejecuta después de cada test. Permite restaurar
     * los flujos de entrada y salida estándar
     * 
     * @throws Exception
     */
    @After
    public void realizaDespuésDeCadaTest() throws Exception {
        System.setIn(in);
        System.setOut(out);
    }

    @Test
    public void testProfe() {

        String entradaTest = "1 3 1\n" +
                "2 2 2\n" +
                "3 1 3";
        String salidaEsperadaTest = "2\n" +
                "1 3-1\n" +
                "|/ / \n" +
                "2 2 2\n" +
                " / /|\n" +
                "3-1 3\n" +
                "\n" +
                "1 3-1\n" +
                "| | |\n" +
                "2 2 2\n" +
                "| | |\n" +
                "3-1 3\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());

    }
    
    @Test
    public void test3x3() {
            String entradaTest = "3 1 2\n" +
                            "2 1 3\n" +
                            "3 1 2\n";
            String salidaEsperadaTest = "2\n"
            		+ "3-1-2\n"
            		+ "    |\n"
            		+ "2-1-3\n"
            		+ "|    \n"
            		+ "3-1-2\n"
            		+ "\n"
            		+ "3-1 2\n"
            		+ " / /|\n"
            		+ "2 1 3\n"
            		+ "|/ / \n"
            		+ "3 1-2\n";

            InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
            System.setIn(nuevo_in);
            ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
            PrintStream nuevo_out = new PrintStream(salidaRealTest);
            System.setOut(nuevo_out);

            String[] args = { "" };
            Main.main(args);

            assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void test4x4() {
            String entradaTest = "1 2 3 4\n" +
                            "4 3 2 1\n" +
                            "1 4 1 3\n" +
                            "2 3 2 4\n";
            String salidaEsperadaTest = "1\n"
            		+ "1-2-3-4\n"
            		+ "      |\n"
            		+ "4-3-2-1\n"
            		+ "|      \n"
            		+ "1 4-1 3\n"
            		+ "| | |/|\n"
            		+ "2-3 2 4\n";

            InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
            System.setIn(nuevo_in);
            ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
            PrintStream nuevo_out = new PrintStream(salidaRealTest);
            System.setOut(nuevo_out);

            String[] args = { "" };
            Main.main(args);

            assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void test5x5() {
            String entradaTest = "1 2 3 4 5\n" +
                            "5 4 3 2 1\n" +
                            "1 2 3 4 5\n" +
                            "5 4 3 2 1\n" +
                            "1 2 3 4 5\n";
            String salidaEsperadaTest = "5\n"
            		+ "1-2-3-4-5\n"
            		+ "        |\n"
            		+ "5-4-3-2-1\n"
            		+ "|        \n"
            		+ "1-2-3-4-5\n"
            		+ "        |\n"
            		+ "5-4-3-2-1\n"
            		+ "|        \n"
            		+ "1-2-3-4-5\n"
            		+ "\n"
            		+ "1-2-3-4-5\n"
            		+ "        |\n"
            		+ "5-4-3-2-1\n"
            		+ "|        \n"
            		+ "1-2-3 4-5\n"
            		+ "   / /  |\n"
            		+ "5-4 3 2-1\n"
            		+ "|  / /   \n"
            		+ "1-2 3-4-5\n"
            		+ "\n"
            		+ "1-2-3-4-5\n"
            		+ "        |\n"
            		+ "5-4 3-2-1\n"
            		+ "|  \\ \\   \n"
            		+ "1-2 3 4-5\n"
            		+ "   \\ \\  |\n"
            		+ "5-4-3 2-1\n"
            		+ "|        \n"
            		+ "1-2-3-4-5\n"
            		+ "\n"
            		+ "1-2-3 4-5\n"
            		+ "   / /  |\n"
            		+ "5-4 3 2-1\n"
            		+ "|  / /   \n"
            		+ "1-2 3-4-5\n"
            		+ "        |\n"
            		+ "5-4-3-2-1\n"
            		+ "|        \n"
            		+ "1-2-3-4-5\n"
            		+ "\n"
            		+ "1-2-3 4-5\n"
            		+ "   / /  |\n"
            		+ "5-4 3 2-1\n"
            		+ "|  / /   \n"
            		+ "1-2 3 4-5\n"
            		+ "   / /  |\n"
            		+ "5-4 3 2-1\n"
            		+ "|  / /   \n"
            		+ "1-2 3-4-5\n";

            InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
            System.setIn(nuevo_in);
            ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
            PrintStream nuevo_out = new PrintStream(salidaRealTest);
            System.setOut(nuevo_out);

            String[] args = { "" };
            Main.main(args);

            assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }

    @Test
    public void decimales() {

        String entradaTest = "1 2 3.4 4 5\n" +
                "5 4 3 2 1.3\n" +
                "1 2 3 4.7 5\n" +
                "5 4 3 2 1\n" +
                "1 2 3 4 5\n";
        String salidaEsperadaTest = "Entrada incorrecta.\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void comas() {

        String entradaTest = "1 3 1\n" +
                "2 2,2\n" +
                "3,5 1 3";
        String salidaEsperadaTest = "Entrada incorrecta.\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void entradaVacia() {

        String entradaTest = "";
        String salidaEsperadaTest = "Entrada incorrecta.\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());

    }
    
    @Test
    public void entradaLetras() {

        String entradaTest = "o v o\n" +
                "x y x\n" +
                "u w u\n";

        String salidaEsperadaTest = "Entrada incorrecta.\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());

    }
    
    @Test
    public void letrasConNumeros() {

        String entradaTest = "1 u 1\n" +
                "2 b 2\n" +
                "3 c 3\n";

        String salidaEsperadaTest = "Entrada incorrecta.\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());

    }
    
    @Test
    public void orden1_1() {

        String entradaTest = "5";
        String salidaEsperadaTest = "1\n" +
                "5\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void orden1_2() {

        String entradaTest = "3";
        String salidaEsperadaTest = "1\n" +
                "3\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void orden1Letra() {

        String entradaTest = "w";
        String salidaEsperadaTest = "Entrada incorrecta.\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void orden1Decimal() {

        String entradaTest = "7.7";
        String salidaEsperadaTest = "Entrada incorrecta.\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void orden1Negativa() {

        String entradaTest = "-7";
        String salidaEsperadaTest = "Entrada incorrecta.\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void matrizNumerosNegativos() {

        String entradaTest = "-7 3 2\n" +
                "-2 2 2\n" +
                "3 -2 3\n";
        String salidaEsperadaTest = "Entrada incorrecta.\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void orden1Cero() {

        String entradaTest = "0";
        String salidaEsperadaTest = "Entrada incorrecta.\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void conCeros() {

        String entradaTest = "1 0 1\n" +
                "2 0 2\n" +
                "3 1 0";
        String salidaEsperadaTest = "Entrada incorrecta.\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void NumerosGrandes() {

        String entradaTest = "1 3 1\n" +
                "220 2 2\n" +
                "3 100 3";
        String salidaEsperadaTest = "Entrada incorrecta.\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void multiplesFallos() {

        String entradaTest = "U w U\n" +
                "c 3 p0\n" +
                "3 1.6 -3";
        String salidaEsperadaTest = "Entrada incorrecta.\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void filasIncoherentes() {

        String entradaTest = "1 0 1 0 1\n" +
                "2 2 2\n" +
                "3 1 3 3 3";
        String salidaEsperadaTest = "Entrada incorrecta.\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void unaFilaVacia() {

        String entradaTest = "1 3 1\n" +
                "\n" +
                "2 2 2\n" +
                "3 1 3";
        String salidaEsperadaTest = "Entrada incorrecta.\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void espaciosDeMas() {

        String entradaTest = "1  3  1\n" +
                "2 2 2\n" +
                "3  1  3";
        String salidaEsperadaTest = "Entrada incorrecta.\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void separadoresRaros1() {

        String entradaTest = "1 3 1\n" +
                "2 2?2\n" +
                "3 1 3";
        String salidaEsperadaTest = "Entrada incorrecta.\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void separadoresRaros2() {

        String entradaTest = "1 3 1\n" +
                "2-2+2\n" +
                "3?1 3";
        String salidaEsperadaTest = "Entrada incorrecta.\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void separadoresRaros3() {

        String entradaTest = "1¿3¡1\n" +
                "2 2 2\n" +
                "3 1¬3";
        String salidaEsperadaTest = "Entrada incorrecta.\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void ejemploSinSolucion() {
        String entradaTest = "1 3 1 4 6\n";
        String salidaEsperadaTest = "0\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void cruce3x2() {
        String entradaTest = "3 5\n" +
                "6 4\n" +
                "7 8\n";
        String salidaEsperadaTest = "0\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void testCruceSolo1Numero() {
        String entradaTest = "7 7 7 7 7\n" +
                "7 7 7 7 7\n" +
                "7 7 7 7 7\n" +
                "7 7 7 7 7\n" +
                "7 7 7 7 7\n" +
                "7 7 7 7 7\n" +
                "7 7 7 7 7\n" +
                "7 7 7 7 7\n" +
                "7 7 7 7 7\n" +
                "7 7 7 7 7\n";
        String salidaEsperadaTest = "0\n";

        InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
        System.setIn(nuevo_in);
        ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
        PrintStream nuevo_out = new PrintStream(salidaRealTest);
        System.setOut(nuevo_out);

        String[] args = { "" };
        Main.main(args);

        assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void testUnaFila() {
            String entradaTest = "1 2 3 4 5 6 7\n";
            String salidaEsperadaTest = "1\n" +
                            "1-2-3-4-5-6-7\n";

            InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
            System.setIn(nuevo_in);
            ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
            PrintStream nuevo_out = new PrintStream(salidaRealTest);
            System.setOut(nuevo_out);

            String[] args = { "" };
            Main.main(args);

            assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void testDosFilas() {
            String entradaTest = "1 4 5\n" +
            					 "2 3 6";
            String salidaEsperadaTest = "1\n"
            		+ "1 4-5\n"
            		+ "| | |\n"
            		+ "2-3 6\n";

            InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
            System.setIn(nuevo_in);
            ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
            PrintStream nuevo_out = new PrintStream(salidaRealTest);
            System.setOut(nuevo_out);

            String[] args = { "" };
            Main.main(args);

            assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void testMatrizGrande() {
            String entradaTest = "1 2 3 1 2 3 1 2 3 1\n"+
            					 "2 3 1 2 3 1 2 3 1 2\n" +
            					 "3 1 2 3 1 2 3 1 2 3";
            String salidaEsperadaTest = "1\n"
            		+ "1 2-3-1 2-3-1 2-3-1\n"
            		+ "|  \\  |  \\  |  \\  |\n"
            		+ "2 3-1 2 3-1 2 3-1 2\n"
            		+ "|  \\  |  \\  |  \\  |\n"
            		+ "3-1-2 3-1-2 3-1-2 3\n";

            InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
            System.setIn(nuevo_in);
            ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
            PrintStream nuevo_out = new PrintStream(salidaRealTest);
            System.setOut(nuevo_out);

            String[] args = { "" };
            Main.main(args);

            assertEquals(salidaEsperadaTest, salidaRealTest.toString());
    }
    
    @Test
    public void solo1Columna() {
    	String entradaTest = "1\n"
    			+ "2\n"
    			+ "3\n"
    			+ "4\n"
    			+ "5\n"
    			+ "1\n"
    			+ "2\n"
    			+ "3\n"
    			+ "4\n"
    			+ "5\n";
    	String salidaEsperadaTest = "1\n"
    			+ "1\n"
    			+ "|\n"
    			+ "2\n"
    			+ "|\n"
    			+ "3\n"
    			+ "|\n"
    			+ "4\n"
    			+ "|\n"
    			+ "5\n"
    			+ "|\n"
    			+ "1\n"
    			+ "|\n"
    			+ "2\n"
    			+ "|\n"
    			+ "3\n"
    			+ "|\n"
    			+ "4\n"
    			+ "|\n"
    			+ "5\n";
    	
    	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
    	System.setIn(nuevo_in);
    	
    	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
    	PrintStream nuevo_out = new PrintStream(salidaRealTest);
    	System.setOut(nuevo_out);
    	
    	Main.main(new String[0]);

       assertEquals(salidaEsperadaTest,salidaRealTest.toString());
    }
    
    
    
}
    
    
    