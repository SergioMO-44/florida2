package es.florida.Ejercicios;

import java.util.Random;

public class ejer25 {

		public static void main(String[] args) {
	        // Validar que se han introducido 3 argumentos
	        if (args.length < 3) {
	            System.out.println("Por favor, introduce 3 números entre 1 y 10 como argumentos.");
	            return;
	        }

	        int[] apuestas = new int[3];

	        // Convertir y validar cada número
	        for (int i = 0; i < 3; i++) {
	            try {
	                apuestas[i] = Integer.parseInt(args[i]);
	            } catch (NumberFormatException e) {
	                System.out.println("El argumento " + args[i] + " no es un número válido.");
	                return;
	            }

	            if (apuestas[i] < 1 || apuestas[i] > 10) {
	                System.out.println("El número " + apuestas[i] + " debe estar entre 1 y 10.");
	                return;
	            }
	        }

	        // Generar número aleatorio entre 1 y 10
	        Random random = new Random();
	        int numeroGanador = random.nextInt(10) + 1;

	        // Mostrar apuestas y número generado
	        System.out.println("Números apostados: " + apuestas[0] + ", " + apuestas[1] + ", " + apuestas[2]);
	        System.out.println("Número ganador: " + numeroGanador);

	        // Comprobar si hay coincidencia
	        boolean acierto = false;
	        for (int apuesta : apuestas) {
	            if (apuesta == numeroGanador) {
	                acierto = true;
	                break;
	            }
	        }

	        // Mostrar resultado
	        if (acierto) {
	            System.out.println("¡Enhorabuena! Has ganado una cena en la playa de la Malvarrosa");
	        } else {
	            System.out.println("No acertaste. ¡Sigue probando tu suerte!");
	        }
	    }
// en powershell ponemos dentro de la carpeta del archivo ejer25.java
		// javac -d . ejer25.java
      //   java es.florida.Ejercicios.ejer25 3 7 9
		//Números apostados: 3, 7, 9 Número ganador: 7 ¡Enhorabuena! Has ganado una cena en la playa de la Malvarrosa

	}

