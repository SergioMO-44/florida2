lista = ['h', 'o', 'l', 'a', ' ', 'm', 'u', 'n', 'd', 'o']
letra = 'o'
contador = 0
for i in range(0, len(lista)):
    if letra == lista[i]:
        contador = contador + 1
print("La letra " + letra + " se repite " + str(contador) + " veces")