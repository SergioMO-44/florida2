def contar(elemento, lista):
	contador = 0
	for i in range(len(lista)):
		if elemento == lista[i]:
			contador = contador + 1
	return contador
#  un buen programador no utiliza variables
#  creadas fuera de esa función
def factorial(n):
	fact = 1
	for i in range(1, n + 1):
		fact = fact * i
	return fact
# Función para calcular el factorial de un entero positivo. El ámbito de las variables fact e i se limita al interior 
# de la función factorial(n).
def fibonacci(n):
	fibs = [0, 1]  # primera y segunda posición
	for i in range(2, n + 1):
		fibs.append(fibs[i - 1] + fibs[i - 2])
	return fibs[n]

print(fibonacci(6))  # 8
#  Ejemplo de función para calcular el nthtermino de la sucesión de Fibonacci y de una llamada a esa
#  función. El ámbito de las variables fibs y f se limita al interior de la función fibonacci(n)
