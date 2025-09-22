lista = [-2, 45, 0, 11, -9, 88, -97, -202, 747]
for i in range(len(lista)):
	min_index = i
	for j in range(i + 1, len(lista)):
		# selecciona el elemento menor en cada iteración
		if lista[j] < lista[min_index]:
			min_index = j
	# intercambia los elementos para ordenar la lista
	lista[i], lista[min_index] = lista[min_index], lista[i]
print(lista)




