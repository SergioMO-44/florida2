def cuadrado(x):
	return x * x

def saludo():
	print("hola")
	return

# Una función puede también devolver varios valores (separados por comas)
def division(x, y):
 c = x // y   # cociente (división entera)
 r = x % y    # resto (módulo)
 return c, r

cociente, resto = division(10, 3)
print("Cociente:", cociente)  # 3
print("Resto:", resto)         # 1

#   Ejemplo de función que devuelve dos valores y de dos llamadas a esta función
def mi_funcion(x):
	r = x * x
	if r % 2 == 0:
		p = True
	else:
		p = False
	return r, p

resultado, par = mi_funcion(5)
print("Resultado:", resultado, "¿Par?", par)
resultado, par = mi_funcion(6)
print("Resultado:", resultado, "¿Par?", par)
 