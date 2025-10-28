package es.florida.psp_neo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void lanzarProbabilidad(String nombreNEO, String posicion, String velocidad) {

		File fichResultado = new File(nombreNEO);
		try {

			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			String clase = "es.florida.psp_neo.Probabilidad";

			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(clase);
			command.add(posicion);
			command.add(velocidad);

			ProcessBuilder builder = new ProcessBuilder(command);
			builder.redirectOutput(fichResultado).start();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static double getResultadoFichero(String nombreFichero) throws Exception {

		FileInputStream fichero = new FileInputStream(nombreFichero);
		InputStreamReader fir = new InputStreamReader(fichero);
		BufferedReader br = new BufferedReader(fir);
		String linea = br.readLine();
		double probabilidad = Double.parseDouble(linea);
		br.close();
		return probabilidad;

	}

	public static ArrayList<Double> getAnalisisTodos(ArrayList<String> listaNombres) throws Exception {

		ArrayList<Double> arrayProbabilidades = new ArrayList<Double>();
		for (String s : listaNombres) {
			arrayProbabilidades.add(getResultadoFichero(s));
		}
		return arrayProbabilidades;

	}

	public static double[] getBloqueAnalisis(String[] arrayNombres) throws Exception {

		double[] arrayProbabilidades = new double[arrayNombres.length];
		for (int i = 0; i < arrayNombres.length; i++) {
			arrayProbabilidades[i] = getResultadoFichero(arrayNombres[i]);
		}
		return arrayProbabilidades;

	}

	public static void main(String[] args) {

		try {

			// PROCESADO COMPLETO

//			long tiempoInicio = System.nanoTime();
//
//			ArrayList<String> listaNombresNEOs = new ArrayList<String>();
//			ArrayList<Double> listaProbabilidades = new ArrayList<Double>();
//
//			File archivoDatos = new File("NEOs.txt");
//			FileReader fr = new FileReader(archivoDatos);
//			BufferedReader br = new BufferedReader(fr);
//			String linea = br.readLine();
//			int numeroTotalNEOs = 0;
//			while (linea != null) {
//				String[] elementosLinea = linea.split(",");
//				listaNombresNEOs.add(elementosLinea[0]);
//				lanzarProbabilidad(elementosLinea[0], elementosLinea[1], elementosLinea[2]);
//				System.out.println("Analisis " + (numeroTotalNEOs + 1) + " lanzado... (NEO: " + elementosLinea[0] + ")");
//				linea = br.readLine();
//				numeroTotalNEOs++;
//			}
//			br.close();
//
//			boolean comprobarFin = false;
//			while (!comprobarFin) {
//				try {
//					listaProbabilidades = getAnalisisTodos(listaNombresNEOs);
//					comprobarFin = true;
//				} catch (Exception e) {
//					//e.printStackTrace();
//				}
//			}
//
//			for (int i = 0; i < listaNombresNEOs.size(); i++) {
//				if (listaProbabilidades.get(i) > 10) {
//					System.err.println(
//							"ALERTA!!! El NEO " + listaNombresNEOs.get(i) + " tiene una probilidad de colision del "
//									+ String.format("%.2f", listaProbabilidades.get(i)) + " %");
//				} else {
//					System.out
//							.println("El NEO " + listaNombresNEOs.get(i) + " solo tiene una probilidad de colision del "
//									+ String.format("%.2f", listaProbabilidades.get(i)) + " %");
//				}
//			}
//
//			long tiempoFin = System.nanoTime();
//			long duracion = (tiempoFin - tiempoInicio) / 1000000; // milisegundos
//			Thread.sleep(100); // Pausa para mostrar mensaje final
//			System.out.println("\nFIN - Tiempo ejecucion total: " + duracion + " ms");
//			System.out.println("    - Tiempo medio de ejecucion por NEO: " + duracion / numeroTotalNEOs + " ms");

			// PROCESADO POR BLOQUES DE 4

			long tiempoInicio = System.nanoTime();

			int tamanyoBloque = 4;

			File archivoDatos = new File("NEOs.txt");
			FileReader fr = new FileReader(archivoDatos);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();

			// Controlar cuantas lineas hay y como quedarian los bloques de analisis de NEOs
			int numeroTotalNEOs = 0;
			while (linea != null) {
				numeroTotalNEOs++;
				linea = br.readLine();
			}
			br.close();
			int bloquesCompletos = numeroTotalNEOs / tamanyoBloque;
			int tamanyoUltimoBloque = numeroTotalNEOs % tamanyoBloque;
			int[] arrayTamanyoBloques;
			if (tamanyoUltimoBloque > 0) {
				arrayTamanyoBloques = new int[bloquesCompletos + 1];
				arrayTamanyoBloques[arrayTamanyoBloques.length - 1] = tamanyoUltimoBloque;
			} else {
				arrayTamanyoBloques = new int[bloquesCompletos];
			}
			for (int i = 0; i < bloquesCompletos; i++) {
				arrayTamanyoBloques[i] = tamanyoBloque;
			}

			System.out.println("Tamanyo de bloque de NEOs: " + tamanyoBloque);
			System.out.println("No. de NEOs a calcular: " + numeroTotalNEOs);
			System.out.println(" -> El proceso se realizara en " + arrayTamanyoBloques.length + " bloques");
			for (int i = 0; i < arrayTamanyoBloques.length; i++) {
				System.out.println(" -> Bloque " + (i + 1) + ": se analizaran " + arrayTamanyoBloques[i] + " NEOs.");
			}

			fr = new FileReader(archivoDatos);
			br = new BufferedReader(fr); // Reiniciar buffer de lectura
			linea = br.readLine();

			for (int j = 0; j < arrayTamanyoBloques.length; j++) {
				int tamanyoBloqueActual = arrayTamanyoBloques[j];
				String[] arrayNombres = new String[tamanyoBloqueActual];
				double[] arrayProbabilidades = new double[tamanyoBloqueActual];

				System.out.println("\nAnalisis del bloque " + (j + 1) + " de " + arrayTamanyoBloques.length);
				for (int i = 0; i < tamanyoBloqueActual; i++) {
					String[] elementosLinea = linea.split(",");
					arrayNombres[i] = elementosLinea[0];
					lanzarProbabilidad(elementosLinea[0], elementosLinea[1], elementosLinea[2]);
					System.out.println("Analisis " + (i + 1) + " lanzado... (NEO: " + arrayNombres[i] + ")");
					linea = br.readLine();
				}

				boolean comprobarFin = false;
				while (!comprobarFin) {
					try {
						arrayProbabilidades = getBloqueAnalisis(arrayNombres);
						comprobarFin = true;
					} catch (Exception e) {
						// Nada
					}
				}

				for (int i = 0; i < tamanyoBloqueActual; i++) {
					if (arrayProbabilidades[i] > 10) {
						System.err.println(
								"ALERTA!!! El NEO " + arrayNombres[i] + " tiene una probilidad de colision del "
										+ String.format("%.2f", arrayProbabilidades[i]) + " %");
					} else {
						System.out.println("El NEO " + arrayNombres[i] + " solo tiene una probilidad de colision del "
								+ String.format("%.2f", arrayProbabilidades[i]) + " %");
					}
				}

				Thread.sleep(100);

			}

			br.close();
			fr.close();

			long tiempoFin = System.nanoTime();
			long duracion = (tiempoFin - tiempoInicio) / 1000000; // milisegundos
			Thread.sleep(100); // Pausa para mostrar mensaje final
			System.out.println("\nFIN - Tiempo ejecucion total: " + duracion + " ms");
			System.out.println("    - Tiempo medio de ejecucion por NEO: " + duracion / numeroTotalNEOs + " ms");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
