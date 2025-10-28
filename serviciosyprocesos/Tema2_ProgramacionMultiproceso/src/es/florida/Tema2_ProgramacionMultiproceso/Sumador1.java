package es.florida.Tema2_ProgramacionMultiproceso;

public class Sumador1 {
    public static void main(String[] args) {
    	System.out.println("Ejercicio 1");
		System.out.println("Realiza un programa Sumador1 en Java que, dados dos números enteros, devuelva por \r\n"
				+ "pantalla la suma de todos los números que hay entre ellos (incluyéndolos). ");
    	if (args.length != 2) {
            System.out.println("Uso: java Sumador1 <inicio> <fin>");
            return;
        }

        int inicio = Integer.parseInt(args[0]);
        int fin = Integer.parseInt(args[1]);
         
        int suma = 0;
        for (int i = inicio; i <= fin; i++) {
            suma += i;
        }
       System.out.println("Suma de " + inicio + " a " + fin + " = " + suma);
    }
}
