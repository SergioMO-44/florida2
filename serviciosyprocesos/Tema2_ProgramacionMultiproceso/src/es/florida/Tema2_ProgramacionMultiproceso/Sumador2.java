package es.florida.Tema2_ProgramacionMultiproceso;

import java.io.FileWriter;
import java.io.IOException;

public class Sumador2 {
    public static void main(String[] args) {
    	System.out.println("Ejercicio 3");
		System.out.println("Crear una versión del Sumador1 (que llamarás Sumador2) que, además de sumar, escriba \r\n"
				+ "el resultado en un fichero en disco (puedes ponerle el nombre que quieras al fichero). ");
        if (args.length != 3) {
            System.out.println("Uso: java Sumador2 <inicio> <fin> <fichero>");
            return;
        }

        int inicio = Integer.parseInt(args[0]);
        int fin = Integer.parseInt(args[1]);
        String fichero = args[2];
        int suma = 0;

        for (int i = inicio; i <= fin; i++) {
            suma += i;
        }

        String resultado = "Suma de " + inicio + " a " + fin + " = " + suma;

        try (FileWriter fw = new FileWriter(fichero)) {
            fw.write(resultado);
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero.");
        }

        System.out.println(resultado);
    }
}
