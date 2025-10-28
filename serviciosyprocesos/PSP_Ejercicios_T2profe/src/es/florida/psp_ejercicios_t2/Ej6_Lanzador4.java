package es.florida.psp_ejercicios_t2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Ej6_Lanzador4 {

	// 6. 6. Crea otra versión del Lanzador1 (que deberás llamar Lanzador4) que
	// redirija la salida de la ejecución del Sumador1 a su flujo de ejecución (al
	// flujo de Lanzador4) y lo muestre por consola.

	public static void main(String[] args) {

		int numero1 = 1;
		int numero2 = 10;

		
		String javaHome = System.getProperty("java.home");
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		String classpath = System.getProperty("java.class.path");
		String clase = "es.florida.psp_ejercicios_t2.Ej1_Sumador1";
		ArrayList<String> command = new ArrayList<>();
		command.add(javaBin);
		command.add("-cp");
		command.add(classpath);
		command.add(clase);
		command.add(String.valueOf(numero1));
		command.add(String.valueOf(numero2));
		System.out.println("Comando que se pasa a ProcessBuilder: " + command);
		System.out.println("Comando a ejecutar en cmd.exe: " + command.toString().replace(",", ""));
		ProcessBuilder builder = new ProcessBuilder(command);
		try {
			Process process = builder.inheritIO().start();
			process.waitFor();
		} catch (IOException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
