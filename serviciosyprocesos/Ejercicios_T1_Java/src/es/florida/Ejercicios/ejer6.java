package es.florida.Ejercicios;
import java.util.Scanner;
public class ejer6 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
        int suma = 0;

        // Bucle que se repite 5 veces
        for (int i = 1; i <= 5; i++) {
            System.out.print("Introduce el número " + i + ": ");
            int numero = entrada.nextInt();
            suma += numero; // Acumulamos la suma
        }

        // Mostramos el resultado final
        System.out.println("La suma de los cinco números es: " + suma);
	}
}
