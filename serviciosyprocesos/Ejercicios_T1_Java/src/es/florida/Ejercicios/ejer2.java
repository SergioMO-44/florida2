package es.florida.Ejercicios;
import java.util.Scanner;
public class ejer2 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in); // 2. Creamos el objeto Scanner

        System.out.print("Introduce tu nombre: "); // 3. Pedimos al usuario que escriba su nombre
        String nombre = entrada.nextLine();        // 4. Leemos el nombre como texto

        System.out.println("Hola " + nombre);      // 5. Mostramos el saludo personalizado
	}

}
