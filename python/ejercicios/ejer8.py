#Función count(list1, x)
def count(list1, x):
    contador = 0
    for elemento in list1:
        if elemento == x:
            contador += 1
    return contador


# Función index(list1, x) retorna la posicición del primer elemento x.
def index(list1, x):
    posicion = 0
    for elemento in list1:
        if elemento == x:
            return posicion
        posicion += 1
    return None

# Función append(list1, x)
def append(list1, x):
    longitud = len(list1)

    # Creamos una nueva lista con espacio adicional
    nueva_lista = [0] * (longitud + 1)

    # Copiamos los elementos
    for i in range(longitud):
        nueva_lista[i] = list1[i]

    # Añadimos el nuevo elemento
    nueva_lista[longitud] = x

    return nueva_lista


# Función find(list1, x)

def find(list1, x):
    for elemento in list1:
        if elemento == x:
            return True
    return False

mi_lista = [3, 5, 7, 5, 9]

print(count(mi_lista, 5))     # → 2
print(index(mi_lista, 7))     # → 2
print(append(mi_lista, 10))         # → [3, 5, 7, 5, 9, 10]
print(find(mi_lista, 9))      # → True
print(find(mi_lista, 100))    # → False






