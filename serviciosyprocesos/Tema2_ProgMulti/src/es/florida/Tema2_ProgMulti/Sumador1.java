package es.florida.Tema2_ProgMulti;

import java.util.Scanner;

public class Sumador1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el primer número: ");
        int num1 = sc.nextInt();

        System.out.print("Introduce el segundo número: ");
        int num2 = sc.nextInt();

        int suma = 0;
        int inicio = Math.min(num1, num2);
        int fin = Math.max(num1, num2);

        for (int i = inicio; i <= fin; i++) {
            suma += i;
        }

        System.out.println("La suma entre " + num1 + " y " + num2 + " es: " + suma);
        sc.close();
    }
}
