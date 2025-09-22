def funcion_saludo3(nombres):
	cadena = ""
	for n in nombres:
		cadena =  cadena + "Hola " + n + "\n"
	return cadena

clientes = ["Marta", "Pedro", "Raquel"]
print(funcion_saludo3(clientes))