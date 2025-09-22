numero = int(input("Introduce un número entero: "))
binario = bin(numero)[2:]  # Convertir a binario y eliminar el prefijo '0b'
print("Representación binaria:", binario)
