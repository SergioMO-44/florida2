def potencia(base, exponente=2):
	return pow(base, exponente)

print(potencia(5, 3))  # 5³ = 125
print(potencia(2, 4))  # 2⁴ = 16
print(potencia(5))      
# 5² = 25 (usa el valor por defecto exponente=2)

# Python permite cambiar el orden de los argumentos de una función especificándolos como pares
# clave = valor
def potencia(base, exponente):
	return pow(base, exponente)

print(potencia(5, 2))                  
print(potencia(exponente=2, base=5))    
# llamada normal → 5² = 25
# llamada con argumentos nombrados → 5² = 25

#  Una función puede recibir un número de argumentos indeterminado usando *args. El contenido de 
# *args es una tupla
def muestraArgumentos(*args):
	cadena = ""
	for a in args:
		cadena = cadena + str(a) + " "
	return cadena

print(muestraArgumentos("Marta", "Lopez"))
print(muestraArgumentos("Marta", "Lopez", 34, "Arquitecto", 2507.5))