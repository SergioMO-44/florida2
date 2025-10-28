package es.florida.Ejercicios;

import java.util.Random;

public class ejer24 {

	public static void main(String[] args) {
        // Validar que se ha introducido un argumento
        if (args.length == 0) {
            System.out.println("Por favor, introduce un número entre 1 y 10 como argumento.");
            return;
        }

        int numeroUsuario;

        try {
            numeroUsuario = Integer.parseInt(args[0]); // Convertimos el argumento a entero
        } catch (NumberFormatException e) {
            System.out.println("El argumento debe ser un número entero.");
            return;
        }

        // Validamos que esté entre 1 y 10
        if (numeroUsuario < 1 || numeroUsuario > 10) {
            System.out.println("El número debe estar entre 1 y 10.");
            return;
        }

        // Generamos un número aleatorio entre 1 y 10
        Random random = new Random();
        int numeroAleatorio = random.nextInt(10) + 1; // nextInt(10) genera 0–9, sumamos 1

        // Mostramos ambos números
        System.out.println("Tu número: " + numeroUsuario);
        System.out.println("Número aleatorio generado: " + numeroAleatorio);

        // Comparamos y damos premio si coinciden
        if (numeroUsuario == numeroAleatorio) {
            System.out.println("🎉 ¡Felicidades! Has ganado un viaje a la Albufera de Valencia 🌅");
        } else {
            System.out.println("No coincidieron. ¡Sigue intentando!");
        }
    }


}
