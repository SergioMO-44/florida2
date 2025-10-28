package es.florida.Tema2_ProgramacionMultiproceso;

import java.io.*;
import java.util.*;

public class Lanzador2 {
    public static void main(String[] args) {
    	System.out.println("Ejercicio 4");
		System.out.println("Crear una versión del Lanzador1 (que llamarás Lanzador2), que lance la aplicación \r\n"
				+ "Sumador2 como proceso y que además lea el resultado que ha escrito Sumador2 y lo \r\n"
				+ "muestre por pantalla (en la consola de Lanzador2). Deberá implementar algún \r\n"
				+ "procedimiento para controlar que el fichero esté efectivamente escrito y su contenido \r\n"
				+ "disponible. ");
        String fichero = "resultado.txt";
        String clase = "es.florida.Tema2_ProgramacionMultiproceso.Sumador2";

        List<String> command = new ArrayList<>();
        command.add(System.getProperty("java.home") + File.separator + "bin" + File.separator + "java");
        command.add("-cp");
        command.add(System.getProperty("java.class.path"));
        command.add(clase);
        command.add("1");
        command.add("50");
        command.add(fichero);

        try {
            ProcessBuilder builder = new ProcessBuilder(command);
            builder.inheritIO();
            Process process = builder.start();
            process.waitFor();

            File file = new File(fichero);
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println("Contenido del fichero: " + linea);
                }
                reader.close();
            } else {
                System.out.println("El fichero no se ha generado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
