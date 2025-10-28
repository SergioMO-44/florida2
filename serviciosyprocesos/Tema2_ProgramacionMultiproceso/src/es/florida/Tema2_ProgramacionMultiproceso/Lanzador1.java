package es.florida.Tema2_ProgramacionMultiproceso;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lanzador1 {
    public static void main(String[] args) {
    	System.out.println("Ejercicio 2");
		System.out.println("Realiza un programa Lanzador1 en Java que llame al programa anterior a través de una \r\n"
				+ "llamada de sistema, es decir, creando un proceso nuevo con ProcessBuilder.  ");
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
        String classpath = System.getProperty("java.class.path");
        String clase = "es.florida.Tema2_ProgramacionMultiproceso.Sumador1";

        List<String> command = new ArrayList<>();
        command.add(javaBin);
        command.add("-cp");
        command.add(classpath);
        command.add(clase);
        command.add("1");
        command.add("100");
        System.out.println("Comando que se pasa a ProcessBuilder: " + command);
		System.out.println("Comando a ejecutar en cmd.exe: " + command.toString().replace(",",""));
		ProcessBuilder builder = new ProcessBuilder(command);
		try {
			builder.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

