package zigzag;

 
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MainTestSergio {

private static InputStream in;
private static PrintStream out;


@Before
public void realizaAntesDeCadaTest() throws Exception {
in = System.in;
out = System.out;
}

@After
public void realizaDespuésDeCadaTest() throws Exception {
System.setIn(in);
System.setOut(out);
}


@Test
public void test01_VPL() {
	String entradaTest = "1 3 1\n"
			+ "2 2 2\n"
			+ "3 1 3\n";
	String salidaEsperadaTest = "2\n"
			+ "1 3-1\n"
			+ "|/ / \n"
			+ "2 2 2\n"
			+ " / /|\n"
			+ "3-1 3\n"
			+ "\n"
			+ "1 3-1\n"
			+ "| | |\n"
			+ "2 2 2\n"
			+ "| | |\n"
			+ "3-1 3\n";
	
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);
	
	Main.main(new String[0]);

   assertEquals(salidaEsperadaTest,salidaRealTest.toString());
}


@Test
public void test02_Matriz1x1() {
	String entradaTest = "5\n";
	String salidaEsperadaTest = "1\n"
			+ "5\n";
	
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);
	
	Main.main(new String[0]);

   assertEquals(salidaEsperadaTest,salidaRealTest.toString());
}

@Test
public void test03_Rectangular2x3() {
	String entradaTest = "3 4\n"
			+ "3 5\n"
			+ "4 5\n";
	String salidaEsperadaTest = "1\n"
			+ "3-4\n"
			+ "  |\n"
			+ "3-5\n"
			+ "|  \n"
			+ "4-5\n";
	
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);
	
	Main.main(new String[0]);

   assertEquals(salidaEsperadaTest,salidaRealTest.toString());
}

@Test
public void test04_Cruce_M3x3_9() {
	String entradaTest = "1 5 6\n"
					   + "4 2 7\n"
					   + "3 8 9\n";
	String salidaEsperadaTest = "0\n";
	
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);
	
	Main.main(new String[0]);

   assertEquals(salidaEsperadaTest,salidaRealTest.toString());
}

@Test
public void test05_M3x3_MAX5() {
	String entradaTest = "1 2 2\n"
						+"3 1 3\n"
						+"4 5 4\n";
	String salidaEsperadaTest = "1\n"
			+ "1-2 2\n"
			+ " / /|\n"
			+ "3 1 3\n"
			+ "| | |\n"
			+ "4-5 4\n";
	
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);
	
	Main.main(new String[0]);

   assertEquals(salidaEsperadaTest,salidaRealTest.toString());
}


@Test
public void test06_M2x2_MAX4() {
	String entradaTest = "3 4\n"
					   + "3 4\n";
	String salidaEsperadaTest = "1\n"
			+ "3-4\n"
			+ " / \n"
			+ "3-4\n";
	
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);
	
	Main.main(new String[0]);

   assertEquals(salidaEsperadaTest,salidaRealTest.toString());
}


@Test
public void test07_SoloUnNumero() {
	String entradaTest = "7 7\n"
			 		   + "7 7\n"
			 		   + "7 7\n"
			 		   + "7 7\n";
	String salidaEsperadaTest = "0\n";
	
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);
	
	Main.main(new String[0]);

   assertEquals(salidaEsperadaTest,salidaRealTest.toString());
}


@Test
public void test08_M4x4_Min2() {
	String entradaTest =  "5 5 6 2\n"
						+ "6 4 3 3\n"
						+ "2 3 2 4\n"
						+ "4 5 6 5\n";
	String salidaEsperadaTest = "1\n"
						+ "5 5-6-2\n"
						+ "| |   |\n"
						+ "6 4-3 3\n"
						+ "|   | |\n"
						+ "2-3 2 4\n"
						+ " /  | |\n"
						+ "4-5-6 5\n";
	
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);
	
	Main.main(new String[0]);

   assertEquals(salidaEsperadaTest,salidaRealTest.toString());
}


@Test
public void test09_M2x3_Min2() {
	String entradaTest =  "3 5 3\n"
						+ "4 2 4\n";
	String salidaEsperadaTest = "1\n"
			+ "3 5 3\n"
			+ "|/|/|\n"
			+ "4 2 4\n";
	
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);
	
	Main.main(new String[0]);

   assertEquals(salidaEsperadaTest,salidaRealTest.toString());
}



@Test
public void test10_M2x3_Min6Max7_Cruzadas() {
	String entradaTest =  "6 7 6\n"
						+ "6 7 7\n";
	String salidaEsperadaTest = "1\n"
						+ "6-7 6\n"
						+ " / /|\n"
						+ "6-7 7\n";
	
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);
	
	Main.main(new String[0]);

   assertEquals(salidaEsperadaTest,salidaRealTest.toString());
}


@Test
public void test11_0_Soluciones() {
	String entradaTest =  "9 5 2\n"
						+ "9 4 5\n";
	String salidaEsperadaTest = "0\n";
	
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);
	
	Main.main(new String[0]);

   assertEquals(salidaEsperadaTest,salidaRealTest.toString());
}


@Test
public void test12_M4x4_Min3Max6() {
	String entradaTest =  "4 5 3 4\n"
						+ "6 5 6 5\n"
						+ "3 4 3 6\n"
						+ "4 5 6 3\n";
	String salidaEsperadaTest =  "2\n"
								+ "4-5 3-4\n"
								+ " /  | |\n"
								+ "6 5-6 5\n"
								+ "| |   |\n"
								+ "3 4-3 6\n"
								+ "|   | |\n"
								+ "4-5-6 3\n"
								+ "\n"
								+ "4-5 3-4\n"
								+ "   \\| |\n"
								+ "6-5 6 5\n"
								+ "| |   |\n"
								+ "3 4-3-6\n"
								+ "|      \n"
								+ "4-5-6-3\n";
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);
	
	Main.main(new String[0]);

   assertEquals(salidaEsperadaTest,salidaRealTest.toString());
}


@Test
public void testIncorrecto_01_ConCero() {
	String entradaTest = "8 0\n"
			+ "3 9\n";
	String salidaEsperadaTest = "Entrada incorrecta.\n";
	
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);
	
	Main.main(new String[0]);

   assertEquals(salidaEsperadaTest,salidaRealTest.toString());
}


@Test
public void testIncorrecto_02_ConNumeroNegativo() {
	String entradaTest = "9 -8\n"
			+ "7 2\n";
	String salidaEsperadaTest = "Entrada incorrecta.\n";
	
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);
	
	Main.main(new String[0]);

   assertEquals(salidaEsperadaTest,salidaRealTest.toString());
}


@Test
public void testIncorrecto_03_MasDe9() {
	String entradaTest = "100 8\n"
			+ "2 9\n";
	String salidaEsperadaTest = "Entrada incorrecta.\n";
	
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);
	
	Main.main(new String[0]);

   assertEquals(salidaEsperadaTest,salidaRealTest.toString());
}


@Test
public void testIncorrecto_04_ConNumeroMuyMuyGrande() {
	String entradaTest = "9 4\n"
			+ "6 49322247732\n";
	String salidaEsperadaTest = "Entrada incorrecta.\n";
	
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);
	
	Main.main(new String[0]);

   assertEquals(salidaEsperadaTest,salidaRealTest.toString());
}


@Test
public void testIncorrecto_05_ConLetras() {
	String entradaTest = "1 8\n"
			+ "H 6\n";
	String salidaEsperadaTest = "Entrada incorrecta.\n";
	
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);
	
	Main.main(new String[0]);

   assertEquals(salidaEsperadaTest,salidaRealTest.toString());
}


@Test
public void testIncorrecto_06_filasConDiferntesColumnas() {
	String entradaTest = "7 8 9\n"
					   + "8 7 9\n"
					   + "9 7\n";
	String salidaEsperadaTest = "Entrada incorrecta.\n";
	
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);
	
	Main.main(new String[0]);

   assertEquals(salidaEsperadaTest,salidaRealTest.toString());
}


@Test
public void testIncorrecto_07_SaltoSinValores() {
	String entradaTest = "1 2 3\n"
			+ "\n"
			+ "3 1 2\n";
	String salidaEsperadaTest = "Entrada incorrecta.\n";
	
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);
	
	Main.main(new String[0]);

   assertEquals(salidaEsperadaTest,salidaRealTest.toString());
}


@Test
public void testIncorrecto_08_ConEspaciosDeMas() {
	String entradaTest = "1 2 3\n"
			+ " 9  8  7\n"
			+ "3 1 2\n";
	String salidaEsperadaTest = "Entrada incorrecta.\n";
	
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);
	
	Main.main(new String[0]);

   assertEquals(salidaEsperadaTest,salidaRealTest.toString());
}


@Test
public void testIncorrecto_09_MasDe_9_Filas() {
	String entradaTest = "1\n"
			+ "1\n"
			+ "2\n"
			+ "3\n"
			+ "4\n"
			+ "5\n"
			+ "6\n"
			+ "7\n"
			+ "8\n"
			+ "9\n"
			+ "1\n";
	String salidaEsperadaTest = "Entrada incorrecta.\n";
	
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);
	
	Main.main(new String[0]);

   assertEquals(salidaEsperadaTest,salidaRealTest.toString());
}


@Test
public void testIncorrecto_1_MasDe_10_Columnas() {
	String entradaTest = "9 1 8 2 7 3 6 4 5 5 4\n";
	String salidaEsperadaTest = "Entrada incorrecta.\n";
	
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);
	
	Main.main(new String[0]);

   assertEquals(salidaEsperadaTest,salidaRealTest.toString());
}

}