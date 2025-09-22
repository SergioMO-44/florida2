package es.florida.Ejercicios;
import java.util.Scanner;
public class ejer3 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in); // 2. Creamos el objeto Scanner

        // 3. Pedimos al usuario que introduzca dos números
        System.out.print("Introduce el primer número: ");
        int numero1 = entrada.nextInt(); // 4. Leemos el primer número

        System.out.print("Introduce el segundo número: ");
        int numero2 = entrada.nextInt(); // 5. Leemos el segundo número

        int suma = numero1 + numero2; // 6. Calculamos la suma

        // 7. Mostramos el resultado
        System.out.println("La suma de los dos números es: " + suma);


	}

}
