//3.	Crea una clase denominada �Caracol� que implemente Runnable y que tenga dos atributos: 
//	velocidad (tipo double) y nombre (tipo String). La aplicaci�n deber� simular una carrera 
//	de 1 m entre 5 caracoles (con nombres y velocidades distintas), mostrando por pantalla 
//	el progreso (en porcentaje) de cada caracol hasta que recorra la distancia completa.

package es.florida.psp_ejercicios_t3;

public class Ej3_Caracol implements Runnable { 

	double distancia = 1;
	double velocidad;
	String nombre;
	
	Ej3_Caracol(String nombre, double velocidad) {
		this.nombre = nombre;
		this.velocidad = velocidad;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arrayNombres = {"Turbo","Rayo","Flash","Viento","Lightspeed"};
		double[] arrayVelocidades = {0.01,0.011,0.0099,0.00999,0.0105};  //Velocidad en metros por segundo
		Ej3_Caracol objetoCaracol;
		Thread hiloCaracol;
		for (int i = 0; i < 5; i++) {
			objetoCaracol = new Ej3_Caracol(arrayNombres[i],arrayVelocidades[i]);
			hiloCaracol = new Thread(objetoCaracol);
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
			try {
				Thread.sleep(200);  //Pausa para ver el avance
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(" -> ���" + nombre + " ha llegado a la meta!!!");
	}

}
