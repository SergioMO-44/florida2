package es.florida.Tema2_ProgMulti;

import java.io.*;
import java.util.*;

public class Miniproyecto {
    public static void main(String[] args) {
    	System.out.println("Miniproyecto");
		System.out.println("Se pide desarrollar una aplicación Java que calcule la probabilidad de que un objeto tipo NEO \r\n"
				+ "(Near-Earth-Object) colisione con la Tierra en los próximos 50 años. La aplicación deberá realizar \r\n"
				+ "lo siguiente: \r\n"
				+ "• Leer la información de un NEO (nombre, posicionNEO -posición relativa a la tierra- y \r\n"
				+ "velocidad NEO -velocidad en kilómetros por segundo relativa al Sol-) de un fichero de datos \r\n"
				+ "(se proporciona junto con este enunciado), en el que cada línea corresponde a un NEO, con \r\n"
				+ "los parámetros separados por comas. \r\n"
				+ "• Calcular la probabilidad de que el NEO colisione con la Tierra. \r\n"
				+ "• Guardar la probabilidad de colisión de cada NEO en un fichero independiente que se \r\n"
				+ "denomine <Nombre del NEO>. \r\n"
				+ "• Mostrar como salida las probabilidades de colisión de cada NEO (con 2 decimales) y si la \r\n"
				+ "probabilidad es mayor de un 10% lanzar una alerta mundial (vale con un System.err.println). \r\n"
				+ "Si no, lanzar un mensaje que transmita tranquilidad. \r\n"
				+ "• Mostar por pantalla el tiempo de ejecución total de la aplicación y el tiempo medio de \r\n"
				+ "ejecución por cada NEO que se ha analizado. \r\n"
				+ "Para calcular el resultado de la probabilidad de colisión se debe realizar una simulación mediante \r\n"
				+ "el siguiente código: \r\n"
				+ "double posicionTierra = 1; \r\n"
				+ "double velocidadTierra = 100; \r\n"
				+ "for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) { \r\n"
				+ "posicionNEO = posicionNEO + velocidadNEO * i; \r\n"
				+ "posicionTierra = posicionTierra + velocidadTierra * i; \r\n"
				+ "} \r\n"
				+ "double resultado = 100 * Math.random() * \r\n"
				+ "Math.pow( ((posicionNEO-posicionTierra)/(posicionNEO+posicionTierra)), 2); \r\n"
				+ "Se pide utilizar una aproximación multiproceso para aprovechar las capacidades hardware de \r\n"
				+ "los equipos, ya que existen gran cantidad de NEOs para estudiar y los cálculos son complejos y \r\n"
				+ "costosos a nivel computacional. Por tanto, se recomienda paralelizar en la medida de lo posible \r\n"
				+ "estos cálculos (es decir, simultanear el cálculo de varios NEOs). Para ello, deberás crear varios \r\n"
				+ "procesos que realicen los cálculos sin esperar a que acaben, es decir, lanzar uno sin esperar a \r\n"
				+ "que acabe el anterior. \r\n"
				+ "Como ampliación, se propone que el fichero se procese en bloques de 4 NEOs, es decir, que el \r\n"
				+ "programa principal lance 4 procesos y se espere a que acaben. Luego lance otros 4 y así, \r\n"
				+ "sucesivamente hasta completar el total de NEOs del fichero. ");
        long inicioTotal = System.currentTimeMillis();

        List<String[]> neos = new ArrayList<>();

        // Leer fichero de entrada
        try (BufferedReader br = new BufferedReader(new FileReader("neos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    neos.add(partes);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero de NEOs.");
            return;
        }

        int totalNEOs = neos.size();
        int bloque = 4;
        int procesados = 0;

        while (procesados < totalNEOs) {
            List<Process> procesos = new ArrayList<>();

            for (int i = 0; i < bloque && procesados + i < totalNEOs; i++) {
                String[] datos = neos.get(procesados + i);
                String nombre = datos[0];
                String posicion = datos[1];
                String velocidad = datos[2];

                List<String> comando = new ArrayList<>();
                comando.add(System.getProperty("java.home") + File.separator + "bin" + File.separator + "java");
                comando.add("-cp");
                comando.add(System.getProperty("java.class.path"));
                comando.add("es.florida.Tema2_ProgMulti.CalculadorNEO");
                comando.add(nombre);
                comando.add(posicion);
                comando.add(velocidad);

                try {
                    ProcessBuilder pb = new ProcessBuilder(comando);
                    pb.inheritIO();
                    procesos.add(pb.start());
                } catch (IOException e) {
                    System.err.println("Error al lanzar proceso para " + nombre);
                }
            }

            // Esperar a que terminen los 4 procesos
            for (Process p : procesos) {
                try {
                    p.waitFor();
                } catch (InterruptedException e) {
                    System.err.println("Error al esperar proceso.");
                }
            }

            procesados += bloque;
        }

        long finTotal = System.currentTimeMillis();
        double tiempoTotalSegundos = (finTotal - inicioTotal) / 1000.0;
        double tiempoMedio = tiempoTotalSegundos / totalNEOs;

        System.out.printf("⏱️ Tiempo total de ejecución: %.2f segundos%n", tiempoTotalSegundos);
        System.out.printf("⏱️ Tiempo medio por NEO: %.2f segundos%n", tiempoMedio);
    }
}
