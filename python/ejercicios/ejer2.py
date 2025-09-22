import random

# Creamos una lista con 25 números aleatorios
lista1 = [random.randint(1, 100) for _ in range(25)]
print("Lista original (lista1):", lista1)
lista2 = lista1  # No se copia, solo se enlaza
lista1[5] = 999
print("\nDespués de modificar lista1[5]:")
print("lista1[5] =", lista1[5])
print("lista2[5] =", lista2[5])
#Ambas listas muestran el mismo cambio. Porque comparten la misma referencia. Si modificas una, la otra también se ve afectada.
# Crea otras dos listas y repite el paso previo, pero en vez de utilizar el operador de asignación (=) copia los elementos de la primera lista en la segunda uno a uno. ¿Hay alguna diferencia? 
lista3 = [random.randint(1, 100) for _ in range(25)]
lista4 = []

# Copiamos los elementos manualmente
for elemento in lista3:
    lista4.append(elemento)

print("\nLista original (lista3):", lista3)
print("Copia manual (lista4):", lista4)
lista3[5] = 888
print("\nDespués de modificar lista3[5]:")
print("lista3[5] =", lista3[5])
print("lista4[5] =", lista4[5])
#Solo lista3 cambia. lista4 permanece igual, porque hicimos una copia independiente. Ya no comparten la misma memoria.
