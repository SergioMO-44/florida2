package es.florida.Tema2_ProgramacionMultiproceso;

import java.io.*;
import java.util.*;

public class Lanzador4 {
    public static void main(String[] args) {
    	System.out.println("Ejercicio 6");
		System.out.println("Crea otra versión del Lanzador1 (que deberás llamar Lanzador4) que redirija la salida de la \r\n"
				+ "ejecución del Sumador1 a su flujo de ejecución (al flujo de Lanzador4) y lo muestre por \r\n"
				+ "consola.  ");
        String clase = "es.florida.Tema2_ProgramacionMultiproceso.Sumador1";

        List<String> command = new ArrayList<>();
        command.add(System.getProperty("java.home") + File.separator + "bin" + File.separator + "java");
        command.add("-cp");
        command.add(System.getProperty("java.class.path"));
        command.add(clase);
        command.add("1");
        command.add("100");

        try {
            ProcessBuilder builder = new ProcessBuilder(command);
            builder.inheritIO();
            Process process = builder.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
