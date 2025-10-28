package es.florida.ejercicios_t1;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class PSP_Ejercicios1 {
	
	public static void ejercicio1() {
		System.out.println("Ejercicio 1");
		System.out.println("Realiza un programa que a partir de dos numeros (introducidos en el codigo) muestre su suma por pantalla.");
		int a = 1;
		int b = 2;
		
		System.out.println("Suma de a (1) + b (2) = 1 + 2 = " + (a + b));
		
	}
	
	public static void ejercicio2() throws IOException {
		System.out.println("Ejercicio 2");
		System.out.println("Programa Java que lea un nombre desde teclado y muestre por pantalla un mensaje tipo Hola xxxxx.");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Dime tu nombre: ");
		String nombre = br.readLine();	
		System.out.println("Hola " + nombre);
		isr.close();
		br.close();
	}
	
	public static void ejercicio3() throws IOException {
		System.out.println("Ejercicio 3");
		System.out.println("Realiza un programa que lea dos numeros desde teclado y muestre la suma por pantalla.");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Numero 1: ");
		String numero1string = br.readLine();
		System.out.print("Numero 2: ");
		String numero2string = br.readLine();
		System.out.println("Suma de " + numero1string + " y " + numero2string + " = " + (Integer.parseInt(numero1string) + Integer.parseInt(numero2string)));
		isr.close();
		br.close();
	}
	
	public static void ejercicio4() throws IOException {
		System.out.println("Ejercicio 4");
		System.out.println("Programa que lea dos numeros desde teclado y muestre el menor y el mayor en pantalla. "
				+ "Si son iguales debera mostrar un mensaje indicandolo.");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Numero 1: ");
		String numero1string = br.readLine();
		int numero1 = Integer.parseInt(numero1string);
		System.out.print("Numero 2: ");
		String numero2string = br.readLine();
		int numero2 = Integer.parseInt(numero2string);
		if (numero1 > numero2) {
			System.out.println("Numero mayor: " + numero1 + " Numero menor: " + numero2);
		} else if (numero1 < numero2) {
			System.out.println("Numero mayor: " + numero2 + " Numero menor: " + numero1);
		} else {
			System.out.println("Los numeros son iguales");
		}
		isr.close();
		br.close();
	}
	
	public static void ejercicio5() throws IOException {
		System.out.println("Ejercicio 5");
		System.out.println("Realiza un programa que lea dos numeros desde teclado en un bucle repetitivo. "
				+ "El bucle debera finalizar cuando los numeros leidos sean iguales.");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int numero1 = 1;
		int numero2 = 2;
		while (numero1 != numero2) {
			System.out.print("Numero 1: ");
			String numero1string = br.readLine();
			numero1 = Integer.parseInt(numero1string);
			System.out.print("Numero 2: ");
			String numero2string = br.readLine();
			numero2 = Integer.parseInt(numero2string);
			if (numero1 == numero2) {
				System.out.println("Los numeros son iguales - Termina programa");
			} 	
		}
		isr.close();
		br.close();
	}
	
	public static void ejercicio6() throws IOException {
		System.out.println("Ejercicio 6");
		System.out.println("Realiza un programa que lea cinco numeros desde teclado y muestre la suma por pantalla. "
				+ "Sugerencia: utilizar una estructura de bucle.");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int numero;
		int suma = 0;
		for (int i = 0; i < 5; i++) {
			System.out.print("Numero " + (i+1) + ": ");
			String numerostring = br.readLine();
			numero = Integer.parseInt(numerostring);
			suma = suma + numero;
		}
		System.out.println("Suma: " + suma);
		isr.close();
		br.close();
	}
	
	public static void ejercicio7() throws IOException {
		System.out.println("Ejercicio 7");
		System.out.println("Resolver el ejercicio anterior empleando otra estructura de bucle.");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int numero;
		int suma = 0;
		int contador = 0;
		while (contador < 5) {
			System.out.print("Numero " + (contador+1) + ": ");
			String numerostring = br.readLine();
			numero = Integer.parseInt(numerostring);
			suma = suma + numero;
			contador++;
		}
		System.out.println("Suma: " + suma);
		isr.close();
		br.close();
	}
	
	public static void ejercicio8() throws IOException {
		System.out.println("Ejercicio 8");
		System.out.println("Desarrolla un programa que lea por teclado un numero del 1 al 12 e indique por pantalla a que mes del anyo en texto corresponde. "
				+ "Sugerencia: utilizar una estructura de programacion if - else.");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Numero mes: ");
		String numeromes = br.readLine();
		if (numeromes.equals("1")) {
			System.out.println("Enero");
		} else if (numeromes.equals("2")) {
			System.out.println("Febrero");
		} else if (numeromes.equals("3")) {
			System.out.println("Marzo");
		} else if (numeromes.equals("4")) {
			System.out.println("Abril");
		} else if (numeromes.equals("5")) {
			System.out.println("Mayo");
		} else if (numeromes.equals("6")) {
			System.out.println("Junio");
		} else if (numeromes.equals("7")) {
			System.out.println("Julio");
		} else if (numeromes.equals("8")) {
			System.out.println("Agosto");
		} else if (numeromes.equals("9")) {
			System.out.println("Septiembre");
		} else if (numeromes.equals("10")) {
			System.out.println("Octubre");
		} else if (numeromes.equals("11")) {
			System.out.println("Noviembre");
		} else if (numeromes.equals("12")) {
			System.out.println("Diciembre");
		}
		isr.close();
		br.close();
	}
	
	public static void ejercicio9() throws IOException {
		System.out.println("Ejercicio 9");
		System.out.println("Resolver el ejercicio anterior empleando otra estructura condicional.");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Numero mes: ");
		String numeromes = br.readLine();
		switch (numeromes) {
			case "1":
				System.out.println("Enero");
				break;
			case "2":
				System.out.println("Febrero");
				break;
			case "3":
				System.out.println("Marzo");
				break;
			case "4":
				System.out.println("Abril");
				break;
			case "5":
				System.out.println("Mayo");
				break;
			case "6":
				System.out.println("Junio");
				break;
			case "7":
				System.out.println("Julio");
				break;
			case "8":
				System.out.println("Agosto");
				break;
			case "9":
				System.out.println("Septiembre");
				break;
			case "10":
				System.out.println("Octubre");
				break;
			case "11":
				System.out.println("Noviembre");
				break;
			case "12":
				System.out.println("Diciembre");
				break;
			default:
				break;
		}
		isr.close();
		br.close();
	}
	
	public static void ejercicio10() throws IOException {
		System.out.println("Ejercicio 10");
		System.out.println("Realiza una modificaci�n del ejercicio anterior para que implemente "
				+ "un control de la entrada por teclado (admitir solo numeros del 1 al 12).");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Numero mes: ");
		String numeromesstring = br.readLine();
		int numeromes = Integer.parseInt(numeromesstring);
		if (numeromes < 1 || numeromes > 12) {
			System.out.println("Solo validos numeros de 1 a 12");
		}
		switch (numeromes) {
			case 1:
				System.out.println("Enero");
				break;
			case 2:
				System.out.println("Febrero");
				break;
			case 3:
				System.out.println("Marzo");
				break;
			case 4:
				System.out.println("Abril");
				break;
			case 5:
				System.out.println("Mayo");
				break;
			case 6:
				System.out.println("Junio");
				break;
			case 7:
				System.out.println("Julio");
				break;
			case 8:
				System.out.println("Agosto");
				break;
			case 9:
				System.out.println("Septiembre");
				break;
			case 10:
				System.out.println("Octubre");
				break;
			case 11:
				System.out.println("Noviembre");
				break;
			case 12:
				System.out.println("Diciembre");
				break;
			default:
				break;
		}
		isr.close();
		br.close();
	}
	
	public static void ejercicio11() {
		System.out.println("Ejercicio 11");
		System.out.println("Implementa un programa que dado un DNI (sin letra) por teclado devuelva el DNI con la letra correcta.");
		char[] arrayletras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce numero DNI: ");
		int numeroDNI = teclado.nextInt();
		int resto = numeroDNI % 23;
        System.out.println("DNI con letra: " + numeroDNI + arrayletras[resto]);
        teclado.close();
	}
	
	public static void ejercicio12() {
		System.out.println("Ejercicio 12");
		System.out.println("Realiza un programa en Java que dadas 10 notas introducidas por teclado (valores de 0 a 10), "
				+ "las agrupe en suspensos, aprobados, notables, sobresalientes y matr�cula, "
				+ "y muestre por pantalla cuantas notas hay en cada grupo.");
		Scanner teclado = new Scanner(System.in);
		//teclado.useLocale(Locale.US);  //Usar el . para indicar decimales
		int suspensos = 0;
		int aprobados = 0;
		int notables = 0;
		int sobresalientes = 0;
		int matriculas = 0;
		double nota;
		for (int i = 0; i < 10; i++) {
			System.out.print("Introduce nota " + (i+1) + ": ");
			nota = teclado.nextDouble();
			if (nota < 5) {
				suspensos++;
			} else if (nota >= 5 && nota < 7) {
				aprobados++;
			} else if (nota >= 7 && nota < 9) {
				notables++;
			} else if (nota >= 9 && nota < 10) {
				sobresalientes++;
			} else if (nota == 10) {
				matriculas++;
			}
		}
		System.out.println("Suspensos: " + suspensos);
		System.out.println("Aprobados: " + aprobados);
		System.out.println("Notables: " + notables);
		System.out.println("Sobresalientes: " + sobresalientes);
		System.out.println("Matriculas: " + matriculas);
		teclado.close();
	}
	
	public static void ejercicio13() {
		System.out.println("Ejercicio 13");
		System.out.println("Programa que lea un valor de grados centigrados desde teclado "
				+ "y lo muestre en grados Fahrenheit con una precision de 1 decimal.");
		Scanner teclado = new Scanner(System.in);
		//teclado.useLocale(Locale.US);  //Usar el . para indicar decimales
		System.out.print("Introduce temperatura (oC): ");
		double temperaturaC = teclado.nextDouble();
		double temperaturaF = (9.0 / 5.0) * temperaturaC  + 32;
		System.out.println("Temperatura (oF): " + String.format("%.f", temperaturaF));
		teclado.close();
	}
	
	public static void ejercicio14() {
		System.out.println("Ejercicio 14");
		System.out.println("Desarrolla un programa que lea el valor del radio de una circunferencia "
				+ "y devuelva por pantalla el diametro y el area con una precision de 3 decimales.");
		Scanner teclado = new Scanner(System.in);
		//teclado.useLocale(Locale.US);  //Usar el . para indicar decimales
		System.out.print("Introduce radio de la circunferencia: ");
		double radio = teclado.nextDouble();
		double diametro = radio * 2;
		double area = Math.PI * Math.pow(radio, 2);
		System.out.println("Diametro: " + String.format("%.3f", diametro));
		System.out.println("Area: " + String.format("%.3f", area));
		teclado.close();
	}
	
	public static void ejercicio15() {
		System.out.println("Ejercicio 15");
		System.out.println("Amplia el programa anterior para que devuelve el volumen de una esfera definida por el mismo radio.");
		Scanner teclado = new Scanner(System.in);
		//teclado.useLocale(Locale.US);  //Usar el . para indicar decimales
		System.out.print("Introduce radio de la circunferencia: ");
		double radio = teclado.nextDouble();
		double diametro = radio * 2;
		double area = Math.PI * Math.pow(radio, 2);
		double volumen = 4.0 / 3.0 * Math.PI * Math.pow(radio, 3);
		System.out.println("Diametro: " + String.format("%.3f", diametro));
		System.out.println("Area: " + String.format("%.3f", area));
		System.out.println("Volumen: " + String.format("%.3f", volumen));
		teclado.close();
	}
	
	public static void ejercicio16() {
		System.out.println("Ejercicio 16");
		System.out.println("Escribe un programa que dada la fecha de nacimiento de una persona devuelva "
				+ "su numero de la suerte (utiliza el algoritmo de calculo que prefieras).");
		// Numero magico: ejemplo 4 octubre 1993 -> 4 + 10 + 1 + 9 + 9 + 3 -> 36 -> 3 + 6 = 9
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce tu fecha de nacimiento (DD/MM/AAAA): ");
		String fechanacimiento = teclado.nextLine();
		int dia = Integer.parseInt(fechanacimiento.substring(0,2));
		int mes = Integer.parseInt(fechanacimiento.substring(3,5));
		int anyomillares = Integer.parseInt(fechanacimiento.substring(6,7));
		int anyocentenas = Integer.parseInt(fechanacimiento.substring(7,8));
		int anyodecenas = Integer.parseInt(fechanacimiento.substring(8,9));
		int anyounidades = Integer.parseInt(fechanacimiento.substring(9,10));
		int sumaaux = dia + mes + anyomillares + anyocentenas + anyodecenas + anyounidades;
		int suma = 0;
		if (sumaaux > 9) {
			int decenas = sumaaux / 10;
			int unidades = sumaaux % 10;
			suma = decenas + unidades; 
		} else {
			suma = sumaaux;
		}
		System.out.println("Numero magico (" + dia + "," +  mes + "," + anyomillares + "," + anyocentenas + "," + anyodecenas + "," + anyounidades + "): " + suma);
		teclado.close();
	}
	
	public static void ejercicio17() throws IOException {
		System.out.println("Ejercicio 17");
		System.out.println("Realiza un programa que controle los requisitos de una contrasenya introducida "
				+ "por teclado (minimo 5 caracteres, 1 numero y 1 letra mayuscula).");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Introduce una contrasenya: ");
		String contrasenya = br.readLine();	
		while (contrasenya.length() < 5) {
			System.out.print("Minimo 5 caracteres, introduce contrasenya: ");
			contrasenya = br.readLine();	
		}
		boolean checkmayus = false;
		boolean checknumero = false;
		char ch;
		for (int i = 0; i < contrasenya.length(); i++) {
			ch = contrasenya.charAt(i);
			if (Character.isDigit(ch)) {
				checknumero = true;
			}
			if (Character.isUpperCase(ch)) {
				checkmayus = true;
			}
		}		
		if (checknumero == true && checkmayus == true) {
			System.out.println("Contrasenya correcta");
		} else {
			System.out.println("Contrasenya incorrecta (minimo 5 caracteres, 1 mayuscula y 1 numero)");
		}
	}
	
	public static void ejercicio18() {
		//Version que oculta la contrase�a mientras se escribe
		//OJO: no funciona en Eclipse, ejectuar como java externamente desde el cmd de Windows
		System.out.println("Ejercicio 18");
		System.out.println("Amplia el programa anterior haciendo que el usuario "
				+ "repita la contrasenya y comprobando que lo ha hecho correctamente.");
		Console cons = System.console();
		String passwd = null;
		String passwd2 = null;
		if (cons != null) {
		  char[] p = cons.readPassword("%s", "Contrasenya: ");
		  passwd = String.valueOf(p);
		}
		if (cons != null) {
		  char[] p = cons.readPassword("%s", "Repite contrasenya: ");
		  passwd2 = String.valueOf(p);
		}
		if (passwd.equals(passwd2)) {
			System.out.println("Ok");
		} else {
			System.out.println("Las contrasenyas no coinciden.");
		}
		
	}
	
	public static void ejercicio19() {
		System.out.println("Ejercicio 19");
		System.out.println("Realizar un programa que muestre por pantalla los caracteres ASCII (codigo y caracter).");
		for (int i = 0; i < 128; i++) {
			System.out.println("Caracter ASCII basico no. " + (i + 1) + ": " + (char)i);
		}
		
	}
	
	public static void ejercicio20() {
		System.out.println("Ejercicio 20");
		System.out.println("Ampliar el programa anterior incluyendo tambien los caracteres de ASCII extendido.");
		System.out.println("Realizar un programa que muestre por pantalla los caracteres ASCII (codigo y caracter).");
		for (int i = 0; i < 256; i++) {
			System.out.println("Caracter ASCII extendido no. " + (i + 1) + ": " + (char)i);
		}
	}
	
	public static void ejercicio21() {
		System.out.println("Ejercicio 21");
		System.out.println("Crea un programa que almacene en una estructura el nombre de 5 personas "
				+ "que se iran introduciendo por teclado de uno en uno.");
		String[] arrayPersonas = new String[5];
		Scanner teclado = new Scanner(System.in);
		String nuevoNombre;
		for (int i = 0; i < 5; i++) {
			System.out.print("Nombre " + (i + 1) + "? ");
			nuevoNombre = teclado.nextLine();
			arrayPersonas[i] = nuevoNombre;
		}
		for (String nombre : arrayPersonas) {
			System.out.print(nombre + " ");
		}
		teclado.close();
	}
	
	public static void ejercicio22() {
		System.out.println("Ejercicio 22");
		System.out.println("Modifica el programa anterior para que almacene en una estructura el nombre de un numero cualquiera de personas, "
				+ "introducidos por teclado de uno en uno. La condicion de finalizacion es introducir un 0 por teclado.");
		ArrayList<String> listaPersonas = new ArrayList<String>();
		Scanner teclado = new Scanner(System.in);
		String nuevoNombre = "";
		while (!nuevoNombre.equals("0")) {
			System.out.print("Introducir nuevo nombre (termina con 0): ");
			nuevoNombre = teclado.nextLine();
			if (!nuevoNombre.equals("0")) {
				listaPersonas.add(nuevoNombre);
			}
		}
		System.out.println(listaPersonas.toString());
		teclado.close();
	}
	
	public static void ejercicio23() {
		System.out.println("Ejercicio 23");
		System.out.println("Amplia el programa anterior para que, una vez tenga almacenados los nombres en una variable, los muestre por pantalla "
				+ "de uno en uno de la siguiente forma: primera linea: 1. Primer nombre, segunda linea: 2. Segundo nombre,...");
		ArrayList<String> listaPersonas = new ArrayList<String>();
		Scanner teclado = new Scanner(System.in);
		String nuevoNombre = "";
		while (!nuevoNombre.equals("0")) {
			System.out.print("Introducir nuevo nombre (termina con 0): ");
			nuevoNombre = teclado.nextLine();
			if (!nuevoNombre.equals("0")) {
				listaPersonas.add(nuevoNombre);
			}
		}
		int contador = 0;
		for (String nombre : listaPersonas) {
			System.out.println(++contador + ". " + nombre);
		}
		Iterator<String> iter = listaPersonas.iterator();
		while (iter.hasNext()) {
			System.out.println(++contador + ". " + iter.next());
		}
		teclado.close();
	}
	
	public static void ejercicio24(String[] args) {
		System.out.println("Ejercicio 24");
		System.out.println("Escribe un programa que tome como parametro de entrada (en la llamada al programa) un numero entre 1 y 10, "
				+ "obtenga de forma aleatorio un numero (tambien entre 1 y 10), "
				+ "compare ambos numeros, los muestre por pantalla y de un premio (a elegir) si coinciden.");
		String strNumeroEntrada = args[0];
		
		int numeroEntrada = Integer.parseInt(strNumeroEntrada);
		int numeroAleatorio = (int) Math.round(Math.random() * 10 + 1); //OJO al '+ 1' final para que el numero este entre 1 y 10 
		System.out.println("Numero jugado: " + numeroEntrada + " - Numero premiado: " + numeroAleatorio);
		if (numeroEntrada == numeroAleatorio) {
			System.out.println("Has ganado! Elige un premio...");
			System.out.println("1. Exprimidor\n2. Licuadora\n3. Sobre sorpresa");
			System.out.print(">> ");
			Scanner teclado = new Scanner(System.in);
			int seleccion = teclado.nextInt();
			switch (seleccion) {
				case 1:
					System.out.println("Has elegido el exprimidor");
					break;
				case 2:
					System.out.println("Has elegido la licuadora");
					break;
				case 3:
					System.out.println("Has elegido el sobre sorpresa... un coche!");
					break;
				default:
					System.out.println("Gracias, tu premio se donara a una ONG");
					break;
			}
			teclado.close();
		} else {
			System.out.println("Has estado cerca, sigue intentandolo.");
		}
		
	}
	
	public static void ejercicio25(String[] args) {
		System.out.println("Ejercicio 25");
		System.out.println("Ampliar el programa anterior para que permita apostar 3 numeros a la vez.");
		
		String strNumeroEntrada1 = args[0];
		String strNumeroEntrada2 = args[1];
		String strNumeroEntrada3 = args[2];
		int numeroEntrada1 = Integer.parseInt(strNumeroEntrada1);
		int numeroEntrada2 = Integer.parseInt(strNumeroEntrada2);
		int numeroEntrada3 = Integer.parseInt(strNumeroEntrada3);
		int numeroAleatorio = (int) Math.round(Math.random() * 10 + 1); //OJO al '+ 1' final para que el numero este entre 1 y 10 
		System.out.println("Numeros jugados: " + numeroEntrada1 + " " + numeroEntrada2 + " " + numeroEntrada3
				+ " - Numero premiado: " + numeroAleatorio);
		if (numeroEntrada1 == numeroAleatorio || numeroEntrada2 == numeroAleatorio || numeroEntrada3 == numeroAleatorio) {
			System.out.println("Has ganado! Elige un premio...");
			System.out.println("1. Exprimidor\n2. Licuadora\n3. Sobre sorpresa");
			System.out.print(">> ");
			Scanner teclado = new Scanner(System.in);
			int seleccion = teclado.nextInt();
			switch (seleccion) {
				case 1:
					System.out.println("Has elegido el exprimidor");
					break;
				case 2:
					System.out.println("Has elegido la licuadora");
					break;
				case 3:
					System.out.println("Has elegido el sobre sorpresa... un coche!");
					break;
				default:
					System.out.println("Gracias, tu premio se donara a una ONG");
					break;
			}
			teclado.close();
		} else {
			System.out.println("Has estado cerca, sigue intentandolo.");
		}
		
	}
	
	
	
	
	
	
	static int suspensos = 0;
	static int aprobados = 0;
	static int notables = 0;
	static int sobresalientes = 0;
	static int matriculas = 0;
	
	public static void comprobarNota(double nota) {
		if (nota < 5) {
			suspensos++;
		} else if (nota >= 5 && nota < 7) {
			aprobados++;
		} else if (nota >= 7 && nota < 9) {
			notables++;
		} else if (nota >= 9 && nota < 10) {
			sobresalientes++;
		} else if (nota == 10) {
			matriculas++;
		}
	}
	
	public static void ejercicio26() {
		System.out.println("Ejercicio 26");
		System.out.println("Realiza una modificacion sobre el programa de las notas (ejercicio 12) implemente la funcionalidad "
				+ "de determinar la calificacion (suspenso, aprobado,...) en un metodo aparte (fuera del metodo main).");
		Scanner teclado = new Scanner(System.in);
		//teclado.useLocale(Locale.US);  //Usar el . para indicar decimales
		double nota;
		for (int i = 0; i < 10; i++) {
			System.out.print("Introduce nota " + (i+1) + ": ");
			nota = teclado.nextDouble();
			comprobarNota(nota);
		}
		System.out.println("Suspensos: " + suspensos);
		System.out.println("Aprobados: " + aprobados);
		System.out.println("Notables: " + notables);
		System.out.println("Sobresalientes: " + sobresalientes);
		System.out.println("Matriculas: " + matriculas);
		teclado.close();
		
//		Scanner teclado = new Scanner(System.in);
//		//teclado.useLocale(Locale.US);  //Usar el . para indicar decimales
//		int suspensos = 0;
//		int aprobados = 0;
//		int notables = 0;
//		int sobresalientes = 0;
//		int matriculas = 0;
//		double nota;
//		for (int i = 0; i < 10; i++) {
//			System.out.print("Introduce nota " + (i+1) + ": ");
//			nota = teclado.nextDouble();
//			if (nota < 5) {
//				suspensos++;
//			} else if (nota >= 5 && nota < 7) {
//				aprobados++;
//			} else if (nota >= 7 && nota < 9) {
//				notables++;
//			} else if (nota >= 9 && nota < 10) {
//				sobresalientes++;
//			} else if (nota == 10) {
//				matriculas++;
//			}
//		}
//		System.out.println("Suspensos: " + suspensos);
//		System.out.println("Aprobados: " + aprobados);
//		System.out.println("Notables: " + notables);
//		System.out.println("Sobresalientes: " + sobresalientes);
//		System.out.println("Matriculas: " + matriculas);
//		teclado.close();
	}
	
	
	
	
	
	
	
	public static char obtenerLetra(int numeroDNI) {
		char[] arrayletras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		char letraDNI = ' ';
		int resto = numeroDNI % 23;
		letraDNI = arrayletras[resto];
		return letraDNI;
	}
	
	public static void ejercicio27() {
		System.out.println("Ejercicio 27");
		System.out.println("De la misma forma que en el ejercicio anterior, "
				+ "implementar en un metodo adicional el calculo de la letra del DNI (ejercicio 11) para que sea llamado desde main.");
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce numero DNI: ");
		int numeroDNI = teclado.nextInt();
		System.out.println("DNI con letra: " + numeroDNI + obtenerLetra(numeroDNI));
		teclado.close();
		
//		char[] arrayletras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
//		Scanner teclado = new Scanner(System.in);
//		System.out.print("Introduce numero DNI: ");
//		int numeroDNI = teclado.nextInt();
//		int resto = numeroDNI % 23;
//      System.out.println("DNI con letra: " + numeroDNI + arrayletras[resto]);
//      teclado.close();
	}
	
	public static void ejercicio28() {
		System.out.println("Ejercicio 28");
		System.out.println("Crea un programa que permita generar 5 objetos de clase Vehiculo. Cada vehiculo tendra tres atributos: "
				+ "tipo (coche, motocicleta,...), marca y modelo. Una vez creados, el programa los mostrara por pantalla.");
		String tipo, marca, modelo;
		Scanner teclado = new Scanner(System.in);
		Vehiculo[] arrayVehiculos = new Vehiculo[5];
		for (int i = 0; i < 5; i++) {
			System.out.println("Caracteristicas vehiculo " + (i + 1));
			System.out.print("  Tipo: ");
			tipo = teclado.nextLine();
			System.out.print("  Marca: ");
			marca = teclado.nextLine();
			System.out.print("  Modelo: ");
			modelo = teclado.nextLine();
			Vehiculo vehiculoActual = new Vehiculo(tipo,marca,modelo);
			arrayVehiculos[i] = vehiculoActual;
		}
		System.out.println("Lista de vehiculos: ");
		for (Vehiculo vehiculoActual : arrayVehiculos) {
			System.out.println(vehiculoActual.toString());
		}
		teclado.close();
	}
	
	public static void ejercicio29() {
		System.out.println("Ejercicio 29");
		System.out.println("Modifica el programa anterior para que el programa admita una lista de longitud indeterminada de vehiculos.");
		String tipo, marca, modelo;
		Scanner teclado = new Scanner(System.in);
		ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
		String valorFinalizar = "1";
		int contador = 0;
		while (!valorFinalizar.equals("0")) {
			System.out.println("Caracteristicas vehiculo " + (contador + 1) + " (termina introduciendo 0 en todos los campos):");
			System.out.print("  Tipo: ");
			tipo = teclado.nextLine();
			System.out.print("  Marca: ");
			marca = teclado.nextLine();
			System.out.print("  Modelo: ");
			modelo = teclado.nextLine();
			valorFinalizar = modelo;
			if (!valorFinalizar.equals("0")) {
				Vehiculo vehiculoActual = new Vehiculo(tipo,marca,modelo);
				listaVehiculos.add(vehiculoActual);
			} else {
				valorFinalizar = "0";
			}
		}
		System.out.println("Lista de vehiculos: ");
		for (Vehiculo vehiculoActual : listaVehiculos) {
			System.out.println(vehiculoActual.toString());
		}
		teclado.close();
	}
	
	public static void ejercicio30() {
		System.out.println("Ejercicio 30");
		System.out.println("Genera archivos ejecutables (.JAR) de algunos ejercicios y ejec�talos por linea de comandos.");
		
	}
	
	
	
	
	public static void ejercicio31() {
		System.out.println("Ejercicio 31");
		System.out.println("Crea una aplicación de consola en que se utilice una clase que tenga un método “sayHello”"
				+ " que saque por consola “Hola Mundo”. La clase puede tener el nombre que consideres.");
		sayHello();
	}
	
	public static void sayHello() {
		System.out.println("Hola mundo");
	}
	
	public static void ejercicio32() {
		System.out.println("Ejercicio 32");
		System.out.println("Crea un array de elementos que contenga el nombre de 6 compañeros de clase y "
				+ "haz que se escriban por la consola en líneas consecutivas. "
				+ "Ahora haz lo mismo, pero empleando un objeto de tipo lista.");
		
		
		String arrayNombres[] = {"nombre1","nombre2","nombre3","nombre4","nombre5","nombre6"};
		System.out.println("Array de nombres: ");
		for (String nombre : arrayNombres)
			System.out.println(nombre);
		
		
		
		ArrayList<String> listaNombres = new ArrayList<String>()
			{{add("nombre1");add("nombre2");add("nombre3");add("nombre4");add("nombre5");add("nombre6");}};
		System.out.println("\nLista de nombres: ");
		for (String nombre : listaNombres)
			System.out.println(nombre);
	}
	
	public static void ejercicio33() {
		System.out.println("Ejercicio 33");
		System.out.println("Escribe un método que sume los números pares hasta el número que acepta "
				+ "como parámetro y devuelva el resultado de la suma.");
		Scanner teclado = new Scanner(System.in);
		System.out.print("Indicar numero: ");
		int numeroFin = Integer.parseInt(teclado.nextLine());
		int suma = 0;
		for (int i = 0; i <= numeroFin; i++) {
			if (i%2 == 0) {
				suma = suma + i;
			}
		}
		System.out.println("Suma de pares de 0 a " + numeroFin + ": " + suma);
	}
	
	public static void ejercicio34() {
		System.out.println("Ejercicio 34");
		System.out.println("Escribe el código necesario para calcular el factorial del número 15, "
				+ "en menos de 5 instrucciones.");
		int factorial = 1;
		int numeroFin = 15;
		for (int i = numeroFin; i >= 1; i--) {
			factorial = factorial * i;
		}
		System.out.println("Factorial de " + numeroFin + ": "+ factorial);
	}
	
	public static void ejercicio35() {
		System.out.println("Ejercicio 35");
		System.out.println("Escribe un método que acepte un array o una lista de elementos "
				+ "y devuelva el mayor de ellos.");
		int arrayInt[] = {3, 4, 7, 8, 9, 10, 1, 5, 2, 6};
		int numMayor = 0;
//		for (int i = 0; i < arrayInt.length; i++) {
//			System.out.print(arrayInt[i] + " ");
//			if (arrayInt[i] > numMayor) {
//				numMayor = arrayInt[i];
//			}
//		}
		//Tambien esta la posibilidad de utilizar el metodo sort de Arrays o Collections:
		Arrays.sort(arrayInt);
		numMayor = arrayInt[arrayInt.length-1];
		System.out.println("\nMayor: " + numMayor);
	}
	
	public static void ejercicio36() {
		System.out.println("Ejercicio 36");
		System.out.println("Escribe un método que pida 5 números enteros (sin validación de momento), "
				+ "los muestre por consola en orden inverso y devuelva la suma de todos los números proporcionados.");
		Scanner teclado = new Scanner(System.in);
		int arrayInt[] = new int[5];
		int numeroActual = 0;
		int suma = 0;
		for (int i = 0; i < 5; i++) {
			System.out.print("Numero " + (i + 1) + " de 5: ");
			numeroActual = teclado.nextInt();
			arrayInt[i] = numeroActual;
			suma = suma + numeroActual;
		}
		//Arrays.sort(arrayInt);  //Ordeno primero los numeros de menor a mayor, aunque esto no era necesario
		for (int i = 4; i >= 0; i--) {
			System.out.println(arrayInt[i]);
		}
		System.out.println("Suma: " + suma);
	}
	
	public static void ejercicio37() {
		System.out.println("Ejercicio 37");
		System.out.println("Escribe un método que pida por teclado el nombre y los años de experiencia "
				+ "como desarrollador de software y muestre el nivel y el salario");
		Scanner teclado = new Scanner(System.in);
		System.out.print("Nombre: ");
		String nombre = teclado.nextLine();
		System.out.print("Experiencia: ");
		int anyosExperiencia = Integer.parseInt(teclado.nextLine());
		if (anyosExperiencia < 1)
			System.out.println(nombre + " Desarrollador Junior L1 : 15000-18000");
		else if (anyosExperiencia >= 1 && anyosExperiencia < 3)
			System.out.println(nombre + " Desarrollador Junior L2 : 18000-22000");
		else if (anyosExperiencia >= 3 && anyosExperiencia < 5)
			System.out.println(nombre + " Desarrollador Senior L1 : 22000-28000");
		else if (anyosExperiencia >= 5 && anyosExperiencia <= 8)
			System.out.println(nombre + " Desarrollador Senior L2 : 28000-36000");
		else
			System.out.println(nombre + " Analista / Arquitecto. Salario a convenir en base a rol");
	}
	
	public static void ejercicio38() {
		System.out.println("Ejercicio 38");
		System.out.println("Escribe un método que pida por teclado 2 números como extremos de un intervalo. "
				+ "Luego imprime por pantalla todos los números entre ese intervalo, "
				+ "indicando junto al número si es un número primo o no. "
				+ "Al terminar de mostrar los números por pantalla, debe mostrar un mensaje indicando "
				+ "el tiempo consumido en la ejecución del método.");
		Scanner teclado = new Scanner(System.in);
		System.out.print("Numero 1: ");
		int numero1 = teclado.nextInt();
		System.out.print("Numero 2: ");
		int numero2 = teclado.nextInt();
		boolean esPrimo;
		long tiempoInicio = System.nanoTime();
		for (int i = numero1; i <= numero2; i++) {
			if (i == 0 || i == 1) {
				esPrimo = false;
			} else {
				esPrimo = true;
				for (int j = 2; j <= i/2; j++) {
					if ((i % j) == 0) {
						esPrimo = false;
						break;
					}
				}	
			}
			if (!esPrimo)
				System.out.println("Numero " + i + " -> NO es primo");
			else
				System.err.println("Numero " + i + " -> ES primo");
		}
		long tiempoFin = System.nanoTime();
		long duracion = (tiempoFin - tiempoInicio)/1000000;  //milisegundos
		System.out.println("Tiempo ejecucion: " + duracion + " ms");
	}
	

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Numero de ejercicio: ");
		String numerostring = br.readLine();
		int numero = Integer.parseInt(numerostring);
		switch(numero) {
			case 1:
				ejercicio1();
				break;
			case 2:
				ejercicio2();
				break;
			case 3:
				ejercicio3();
				break;
			case 4:
				ejercicio4();
				break;
			case 5:
				ejercicio5();
				break;
			case 6:
				ejercicio6();
				break;
			case 7:
				ejercicio7();
				break;
			case 8:
				ejercicio8();
				break;
			case 9:
				ejercicio9();
				break;
			case 10:
				ejercicio10();
				break;
			case 11:
				ejercicio11();
				break;
			case 12:
				ejercicio12();
				break;
			case 13:
				ejercicio13();
				break;
			case 14:
				ejercicio14();
				break;
			case 15:
				ejercicio15();
				break;
			case 16:
				ejercicio16();
				break;
			case 17:
				ejercicio17();
				break;
			case 18:
				ejercicio18();
				break;
			case 19:
				ejercicio19();
				break;
			case 20:
				ejercicio20();
				break;
			case 21:
				ejercicio21();
				break;
			case 22:
				ejercicio22();
				break;
			case 23:
				ejercicio23();
				break;
			case 24:
				ejercicio24(args);
				break;
			case 25:
				ejercicio25(args);
				break;
			case 26:
				ejercicio26();
				break;
			case 27:
				ejercicio27();
				break;
			case 28:
				ejercicio28();
				break;
			case 29:
				ejercicio29();
				break;
			case 30:
				ejercicio30();
				break;
			case 31:
				ejercicio31();
				break;
			case 32:
				ejercicio32();
				break;
			case 33:
				ejercicio33();
				break;
			case 34:
				ejercicio34();
				break;
			case 35:
				ejercicio35();
				break;
			case 36:
				ejercicio36();
				break;
			case 37:
				ejercicio37();
				break;
			case 38:
				ejercicio38();
				break;
			default:
				System.out.println("Fin");
		}
		try {
			String sistemaOperativo = System.getProperty("os.name");
			ProcessBuilder p;
			if (sistemaOperativo.contains("Windows")) {
				p = new ProcessBuilder("cmd", "/c", "cls");
			} else {
				p = new ProcessBuilder("clear");
			}
			p.inheritIO().start().waitFor();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		System.out.println("FIN");

	}

}
