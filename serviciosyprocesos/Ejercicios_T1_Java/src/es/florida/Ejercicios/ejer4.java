package es.florida.Ejercicios;
import java.util.Scanner;
public class ejer4 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in); // 2. Creamos el objeto Scanner

        // 3. Pedimos al usuario que introduzca dos números
        System.out.print("Introduce el primer número: ");
        int numero1 = entrada.nextInt();

        System.out.print("Introduce el segundo número: ");
        int numero2 = entrada.nextInt();

        // 4. Comparamos los números
        if (numero1 == numero2) {
            System.out.println("Ambos números son iguales: " + numero1);
        } else if (numero1 > numero2) {
            System.out.println("El mayor es: " + numero1);
            System.out.println("El menor es: " + numero2);
        } else {
            System.out.println("El mayor es: " + numero2);
            System.out.println("El menor es: " + numero1);
        }
	}
}
