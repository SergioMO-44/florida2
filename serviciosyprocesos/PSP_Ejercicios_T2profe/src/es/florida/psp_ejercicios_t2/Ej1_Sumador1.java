package es.florida.psp_ejercicios_t2;

public class Ej1_Sumador1 {

	//1.	Realiza un programa Sumador1 en Java que dados dos numeros enteros, 
	//		devuelva por pantalla la suma de todos los numeros que hay entre ellos (incluyendolos).
	
	public static void main(String[] args) {
		int numero1 = Integer.parseInt(args[0]);
		int numero2 = Integer.parseInt(args[1]);
		int suma = 0;
		for (int i = numero1; i <= numero2; i++) {
			suma = suma + i;
		}
		System.out.println("Suma numeros entre " + numero1 + " y " + numero2 + " (inclusive): " + suma);
	}

}
