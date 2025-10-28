package es.florida.psp_ejercicios_t2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ej3_Sumador2 {

	// 3. 3. Crear una versión del Sumador1 (que llamarás Sumador2) que, además de
	// sumar, escriba el resultado en un fichero en disco (puedes ponerle el nombre
	// que quieras al fichero).

	public static void main(String[] args) {
		int numero1 = Integer.parseInt(args[0]);
		int numero2 = Integer.parseInt(args[1]);
		String nombreFichero = args[2];
		int suma = 0;
		for (int i = numero1; i <= numero2; i++) {
			suma = suma + i;
		}
		System.out.println("Suma numeros entre " + numero1 + " y " + numero2 + " (inclusive): " + suma);
		File fichero = new File(nombreFichero);
		FileWriter fw;
		BufferedWriter bw;
		System.out.println("Iniciar escritura en fichero...");
		try {
			fw = new FileWriter(fichero);
			bw = new BufferedWriter(fw);
			bw.write(String.valueOf(suma));
			bw.close();
			fw.close();
			System.out.println("Fichero escrito con �xito.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
