lista = [-2, 45, 0, 11, -9, 88, -97, -202, 747]
for i in range(len(lista)):
	min_index = i
	for j in range(i + 1, len(lista)):
		# selecciona el elemento menor en cada iteración
		if lista[j] < lista[min_index]:
			min_index = j
	# intercambia los elementos para ordenar la lista
	#- Compara el elemento en lista[j] con el actual mínimo (lista[min_index]).
    #- Si encuentra uno menor, actualiza min_index.
	aux = lista[i]
	lista[i] = lista[min_index]
	lista[min_index] = aux
	#- Se intercambia el valor en la posición i con el valor más pequeño encontrado (min_index).
    # Así, el menor valor se coloca en su posición correcta.

print(lista)
#- Se imprime la lista después de cada iteración externa, mostrando cómo se va ordenando paso a paso.
#- Finalmente, se imprime la lista ordenada.