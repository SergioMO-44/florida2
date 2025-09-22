package es.florida.Ejercicios;
import java.util.Scanner;

public class ejer5 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
        int numero1, numero2;

        do {
            System.out.print("Introduce el primer número: ");
            numero1 = entrada.nextInt();

            System.out.print("Introduce el segundo número: ");
            numero2 = entrada.nextInt();

            if (numero1 != numero2) {
                System.out.println("Los números son diferentes. Intenta de nuevo.\n");
            }
        } while (numero1 != numero2);

        System.out.println("¡Los números son iguales! Fin del programa.");
	}
}
