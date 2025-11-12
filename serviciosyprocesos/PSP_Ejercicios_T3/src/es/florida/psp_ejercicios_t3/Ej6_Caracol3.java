//7. Crea una ampliaci�n del programa de los caracoles (del 3 o del 4, es indiferente) para que se 
// controle el momento en que el primer caracol termina la carrera 
// (pista: utilizar un fichero que escribir� en disco el primero que acabe). 
// Cuando esto suceda, el programa deber� realizar dos acciones: 
//	� Hacer que el resto de participantes se detengan (en realidad, cada participante deber� 
//    �controlar por su cuenta� si alguien ha acabado ya y, si es el caso, 
//    finalizar� autom�ticamente la carrera, mostrando por pantalla un mensaje indicando que 
//	  abandona y en qu� punto de la carrera -en porcentaje- se encontraba al abandonar).
//	� Mostrar un mensaje final indicando qui�n es el ganador.


package es.florida.psp_ejercicios_t3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ej6_Caracol3 implements Runnable {   
	
	double distancia = 1;
	double velocidad;
	String nombre;
	static String nombreFicheroLlegada = "ficheroLlegada.txt";
	
	Ej6_Caracol3(String nombre, double velocidad) {
		this.nombre = nombre;
		this.velocidad = velocidad;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File ficheroLlegada = new File(nombreFicheroLlegada);
		ficheroLlegada.delete();  //Borrar si existe para empezar carrera nueva
		
		String[] arrayNombres = {"Turbo","Rayo","Flash","Viento","Lightspeed"};
		double[] arrayVelocidades = {0.01,0.01,0.01,0.01,0.01};  //Velocidad en metros por segundo
		int[] arrayPrioridades = {1,2,3,4,10};
		Ej6_Caracol3 objetoCaracol;
		Thread hiloCaracol;
		for (int i = 0; i < 5; i++) {
			objetoCaracol = new Ej6_Caracol3(arrayNombres[i],arrayVelocidades[i]);
			hiloCaracol = new Thread(objetoCaracol);
			hiloCaracol.setPriority(arrayPrioridades[i]);
			hiloCaracol.start();
		}
		boolean ficheroExiste = false;
		FileReader fr;
		while(!ficheroExiste) {
			try {
				fr = new FileReader(ficheroLlegada);
				BufferedReader br = new BufferedReader(fr);
				String nombre = br.readLine();
				System.err.println("CARRERA FINALIZADA: ha ganado " + nombre);
				br.close();
				fr.close();
				ficheroExiste = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		File ficheroLlegada = new File(nombreFicheroLlegada);
		double avance = 0;
		double porcentaje = 0;
		System.out.println(nombre + " inicia la carrera");
		while (avance < distancia) {
			if (ficheroLlegada.exists()) {  //Algun hilo ha acabado la carrera y ha creado ya el fichero de llegada
				System.out.println(nombre + "> Alguien ha ganado la carrera... abandono en el " + String.format("%.0f", porcentaje) + "%  :(");
				avance = distancia;  //Abandonar el while haciendole creer que ha acabado la carrera
			} else {
				avance += velocidad * 1;  //Asumir una iteraci�n por segundo
				porcentaje = 100 * avance / distancia;
				System.out.println(nombre + " > " + String.format("%.0f", porcentaje) + "%");				
			}
		}
		if (!ficheroLlegada.exists()) {  //Comprobar que ningun hilo ha escrito aun el fichero de llegada
			FileWriter fw;
			try {
				fw = new FileWriter(ficheroLlegada);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(nombre);
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.err.println(nombre + " > ���HE LLEGADO A LA META!!! ��� HE GANADO LA CARRERA !!!");
		}
	}

}
