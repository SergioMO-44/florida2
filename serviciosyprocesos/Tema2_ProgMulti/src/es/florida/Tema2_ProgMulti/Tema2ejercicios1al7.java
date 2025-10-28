package es.florida.Tema2_ProgMulti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Tema2ejercicios1al7 {

	public static void ejercicio1 () {
		System.out.println("Ejercicio 1");
		System.out.println(" Realiza un programa Sumador1 en Java que, dados dos números enteros, devuelva por \r\n"
				+ "pantalla la suma de todos los números que hay entre ellos (incluyéndolos). ");
		 // Llamamos directamente al método main de Sumador1
        Sumador1.main(new String[0]);

	}
	public static void ejercicio2 () {
		System.out.println("Ejercicio 2");
		System.out.println("Realiza un programa Lanzador1 en Java que llame al programa anterior a través de una \r\n"
				+ "llamada de sistema, es decir, creando un proceso nuevo con ProcessBuilder. ");
		 try {
	            // Crear el proceso que ejecuta Sumador1
	            ProcessBuilder pb = new ProcessBuilder("java", "es.florida.Tema2_ProgMulti.Sumador1");

	            // Establecer el directorio donde se encuentra Sumador1.class
	            pb.directory(new java.io.File("bin")); // Ajusta si usas otro directorio de compilación

	            // Redirigir la salida del proceso
	            pb.redirectErrorStream(true);

	            // Iniciar el proceso
	            Process proceso = pb.start();

	            // Leer la salida del proceso
	            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
	            String linea;
	            while ((linea = reader.readLine()) != null) {
	                System.out.println(linea);
	            }

	            // Esperar a que el proceso termine
	            int exitCode = proceso.waitFor();
	            System.out.println("Proceso finalizado con código: " + exitCode);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	}
	public static void ejercicio3 () {
		System.out.println("Ejercicio 3");
		System.out.println("Crear una versión del Sumador1 (que llamarás Sumador2) que, además de sumar, escriba \r\n"
				+ "el resultado en un fichero en disco (puedes ponerle el nombre que quieras al fichero).  ");
	}
	public static void ejercicio4 () {
		System.out.println("Ejercicio 4");
		System.out.println(" Crear una versión del Lanzador1 (que llamarás Lanzador2), que lance la aplicación \r\n"
				+ "Sumador2 como proceso y que además lea el resultado que ha escrito Sumador2 y lo \r\n"
				+ "muestre por pantalla (en la consola de Lanzador2). Deberá implementar algún \r\n"
				+ "procedimiento para controlar que el fichero esté efectivamente escrito y su contenido \r\n"
				+ "disponible. ");
	}
	public static void ejercicio5 () {
		System.out.println("Ejercicio 5");
		System.out.println("Crea otra versión del Lanzador2 (que llamarás Lanzador3) que llame dos veces consecutivas \r\n"
				+ "a Sumador2, lea los resultados de los ficheros generados y los muestre por pantalla (en la \r\n"
				+ "consola de Lanzador3). ");
	}
	public static void ejercicio6 () {
		System.out.println("Ejercicio 6");
		System.out.println("Crea otra versión del Lanzador1 (que deberás llamar Lanzador4) que redirija la salida de la \r\n"
				+ "ejecución del Sumador1 a su flujo de ejecución (al flujo de Lanzador4) y lo muestre por \r\n"
				+ "consola. ");
	}
	public static void ejercicio7 () {
		System.out.println("Ejercicio 7");
		System.out.println("Crear otra versión del Lanzador1 (que deberás llamar Lanzador5) que redirija la salida de la \r\n"
				+ "ejecución del Sumador1 a su flujo de ejecución (al flujo de Lanzador5) y lo escriba en un \r\n"
				+ "fichero.  ");
	}
	
	
	
		public static void main(String[] args) throws IOException {
			Scanner scanner = new Scanner(System.in);
	        int opcion;

	        System.out.println("📘 Bienvenido al selector de ejercicios del Tema 2");
	        System.out.println("Introduce el número de ejercicio que quieres ejecutar (1–7):");

	        opcion = scanner.nextInt();

	        switch (opcion) {
	            case 1: ejercicio1(); break;
	            case 2: ejercicio2(); break;
	            case 3: ejercicio3(); break;
	            case 4: ejercicio4(); break;
	            case 5: ejercicio5(); break;
	            case 6: ejercicio6(); break;
	            case 7: ejercicio7(); break;
	            default:
	                System.out.println("❌ Número no válido. Por favor, introduce un número entre 1 y 7.");
	        }

	        scanner.close();
	}

}
