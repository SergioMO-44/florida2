//1.	Crea una clase llamada �MostrarASCII� que implemente Runnable y que tenga 
//como atributo un n�mero entero denominado �tipo�. Si el tipo es 1, la clase 
//mostrar� los caracteres ASCII impares y si es 2, los pares. La aplicaci�n (m�todo main) 
//deber� crear dos hilos, uno para mostrar los impares y otro para los pares. 

package es.florida.psp_ejercicios_t3;

public class Ej1_MostrarASCII implements Runnable { 

	int tipo;
	
	Ej1_MostrarASCII(int tipo) {
		this.tipo = tipo;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ej1_MostrarASCII objeto1 = new Ej1_MostrarASCII(1);
		Ej1_MostrarASCII objeto2 = new Ej1_MostrarASCII(2);
		Thread thread1 = new Thread(objeto1);
		Thread thread2 = new Thread(objeto2);
		thread1.start();
		thread2.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (tipo == 1) {
			for (int i = 1; i < 256; i += 2) {
				System.err.println("Caracter impar n�" + i + ": " + (char)i);
			}
		} else if (tipo == 2) {
			for (int i = 2; i <= 256; i += 2) {
				System.out.println("Caracter par n�" + i + ": " + (char)i);
			}
		}
	}

}
