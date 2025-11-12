//4.	Crea una variaci�n del programa anterior que asigne a todos los caracoles la misma velocidad, 
//pero prioridades distintas a sus hilos correspondientes.

package es.florida.psp_ejercicios_t3;

public class Ej4_Caracol2 implements Runnable {  

	double distancia = 1;
	double velocidad;
	String nombre;
	
	Ej4_Caracol2(String nombre, double velocidad) {
		this.nombre = nombre;
		this.velocidad = velocidad;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arrayNombres = {"Turbo","Rayo","Flash","Viento","Lightspeed"};
		double[] arrayVelocidades = {0.01,0.01,0.01,0.01,0.01};  //Velocidad en metros por segundo
		int[] arrayPrioridades = {1,2,3,4,10};
		Ej4_Caracol2 objetoCaracol;
		Thread hiloCaracol;
		for (int i = 0; i < 5; i++) {
			objetoCaracol = new Ej4_Caracol2(arrayNombres[i],arrayVelocidades[i]);
			hiloCaracol = new Thread(objetoCaracol);
			hiloCaracol.setPriority(arrayPrioridades[i]);
			hiloCaracol.start();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		double avance = 0;
		double porcentaje = 0;
		System.out.println(nombre + " inicia la carrera");
		while (avance < distancia) {
			avance += velocidad * 1;  //Asumir una iteraci�n por segundo
			porcentaje = 100 * avance / distancia;
			System.out.println(nombre + " > " + String.format("%.0f", porcentaje) + "%");
//			try {
//				Thread.sleep(200);  //Pausa para ver el avance
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		System.out.println(" -> ���" + nombre + " ha llegado a la meta!!!");
	}

}
