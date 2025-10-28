package es.florida.Tema2_ProgMulti;

import java.io.FileWriter;
import java.io.IOException;

public class CalculadorNEO {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Uso: java CalculadorNEO <nombre> <posicionNEO> <velocidadNEO>");
            return;
        }

        String nombre = args[0];
        double posicionNEO = Double.parseDouble(args[1]);
        double velocidadNEO = Double.parseDouble(args[2]);

        double posicionTierra = 1;
        double velocidadTierra = 100;

        for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) {
            posicionNEO += velocidadNEO * i;
            posicionTierra += velocidadTierra * i;
        }

        double resultado = 100 * Math.random() *
                Math.pow(((posicionNEO - posicionTierra) / (posicionNEO + posicionTierra)), 2);

        String mensaje = String.format("Probabilidad de colisión de %s: %.2f%%", nombre, resultado);

        try (FileWriter fw = new FileWriter(nombre + ".txt")) {
            fw.write(mensaje);
        } catch (IOException e) {
            System.err.println("Error al escribir el fichero de " + nombre);
        }

        System.out.println(mensaje);

        if (resultado > 10.0) {
            System.err.println("⚠️ ALERTA MUNDIAL: " + nombre + " tiene una probabilidad alta de colisión.");
        } else {
            System.out.println("✅ Tranquilidad: " + nombre + " no representa una amenaza significativa.");
        }
    }
}
