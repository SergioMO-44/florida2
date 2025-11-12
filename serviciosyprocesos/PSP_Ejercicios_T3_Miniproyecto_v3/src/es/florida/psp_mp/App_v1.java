package es.florida.psp_mp;

public class App_v1 {

	public static void main(String[] args) {

		int tamanyoMina = 10000;
		int numMineros = 10;
		int tamanyoBolsaInicial = 0;
		int tiempoExtraccion = 1;

		Mina mina1 = new Mina(tamanyoMina);
		Minero[] ejercitoMineros = new Minero[numMineros];
		Thread t = null;
		for (int i = 0; i < ejercitoMineros.length; i++) {
			System.out.println("Minero " + (i + 1) + " creado");
			Minero m = new Minero(String.valueOf(i + 1), tamanyoBolsaInicial, tiempoExtraccion, mina1);
			ejercitoMineros[i] = m;
			t = new Thread(m);
			t.start();
		}
		while (mina1.getStock() > 0) {  //Bucle que mantiene la ejecucion del hilo principal mientras haya recursos en la mina
			try {
				Thread.sleep(1000);
				System.out.println("AUN QUEDAN RECURSOS EN LA MINA");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("YA NO QUEDAN RECURSOS EN LA MINA");
		int sumaBolsas = 0;
		for (int i = 0; i < ejercitoMineros.length; i++) {
			System.out.println("El minero " + ejercitoMineros[i].nombre + " ha recolectado " + ejercitoMineros[i].getBolsa() + " oros.");
			sumaBolsas += ejercitoMineros[i].getBolsa();
		}
		System.out.println("TOTAL RECOLECTADO: " + sumaBolsas);
	}

}
