# insert(list1, x, index): inserta el elemento x en la posición index de list1. 
def insert(list1, x, index):
    longitud = len(list1)

    # Validamos que el índice esté dentro del rango
    if index < 0 or index > longitud:
        print("Índice fuera de rango")
        return list1

    nueva_lista = [0] * (longitud + 1)

    for i in range(index):
        nueva_lista[i] = list1[i]

    nueva_lista[index] = x

    for i in range(index, longitud):
        nueva_lista[i + 1] = list1[i]

    return nueva_lista

# remove(list1, x): elimina el primer valor que coincide con x de list1. 
def remove(list1, x):
    nueva_lista = []
    encontrado = False

    for elemento in list1:
        if elemento == x and not encontrado:
            encontrado = True  # Saltamos el primer elemento que coincide
            continue
        nueva_lista += [elemento]  # Añadimos el resto

    return nueva_lista


# removeAll(list1, x): elimina todos los elementos que coinciden con x de list1.
def removeAll(list1, x):
    nueva_lista = []

    for elemento in list1:
        if elemento != x:
            nueva_lista += [elemento]

    return nueva_lista

# clear(list1): elimina todos los elementos de list1.
def clear(list1):
      return []

# pop(list1): elimina el último valor de la lista y lo devuelve.
def pop(list1):
    longitud = len(list1)

    if longitud == 0:
        print("La lista está vacía")
        return None

    ultimo = list1[longitud - 1]

    nueva_lista = [0] * (longitud - 1)
    for i in range(longitud - 1):
        nueva_lista[i] = list1[i]

    return ultimo, nueva_lista

lista = [10, 20, 30, 20]

print(insert(lista, 99, 2))       # → [10, 20, 99, 30, 20]
print(remove(lista, 20))          # → [10, 30, 20]
print(removeAll(lista, 20))       # → [10, 30]
print(clear(lista))               # → []
print(pop(lista))                 # → (20, [10, 20, 30])
