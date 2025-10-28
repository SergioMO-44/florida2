package es.florida.Tema2_ProgramacionMultiproceso;

import java.io.*;
import java.util.*;

public class Lanzador5 {
    public static void main(String[] args) {
    	System.out.println("Ejercicio 7");
		System.out.println(" Crear otra versión del Lanzador1 (que deberás llamar Lanzador5) que redirija la salida de la \r\n"
				+ "ejecución del Sumador1 a su flujo de ejecución (al flujo de Lanzador5) y lo escriba en un \r\n"
				+ "fichero.  ");
        String clase = "es.florida.Tema2_ProgramacionMultiproceso.Sumador1";
        File salida = new File("salidaSumador1.txt");

        List<String> command = new ArrayList<>();
        command.add(System.getProperty("java.home") + File.separator + "bin" + File.separator + "java");
        command.add("-cp");
        command.add(System.getProperty("java.class.path"));
        command.add(clase);
        command.add("1");
        command.add("100");

        try {
            ProcessBuilder builder = new ProcessBuilder(command);
            builder.redirectOutput(salida);
            Process process = builder.start();
            process.waitFor();
            System.out.println("Salida guardada en " + salida.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

