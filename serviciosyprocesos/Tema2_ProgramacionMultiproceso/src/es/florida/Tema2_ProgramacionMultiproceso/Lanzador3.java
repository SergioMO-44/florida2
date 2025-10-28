package es.florida.Tema2_ProgramacionMultiproceso;

import java.io.*;
import java.util.*;

public class Lanzador3 {
    public static void main(String[] args) {
    	System.out.println("Ejercicio 5");
		System.out.println("Crea otra versión del Lanzador2 (que llamarás Lanzador3) que llame dos veces consecutivas \r\n"
				+ "a Sumador2, lea los resultados de los ficheros generados y los muestre por pantalla (en la \r\n"
				+ "consola de Lanzador3). ");
        String clase = "es.florida.Tema2_ProgramacionMultiproceso.Sumador2";

        for (int i = 0; i < 2; i++) {
            int inicio = (i == 0) ? 1 : 51;
            int fin = (i == 0) ? 50 : 100;
            String fichero = "resultado" + (i + 1) + ".txt";

            List<String> command = new ArrayList<>();
            command.add(System.getProperty("java.home") + File.separator + "bin" + File.separator + "java");
            command.add("-cp");
            command.add(System.getProperty("java.class.path"));
            command.add(clase);
            command.add(String.valueOf(inicio));
            command.add(String.valueOf(fin));
            command.add(fichero);

            try {
                ProcessBuilder builder = new ProcessBuilder(command);
                builder.inheritIO();
                Process process = builder.start();
                process.waitFor();

                BufferedReader reader = new BufferedReader(new FileReader(fichero));
                String linea;
                System.out.println("Contenido de " + fichero + ":");
                while ((linea = reader.readLine()) != null) {
                    System.out.println(linea);
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
