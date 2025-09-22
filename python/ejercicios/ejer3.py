import time
import random
#1.  Para la primera usar el método append() 
init = time.time()

lista_append = []
for _ in range(100_000):
    lista_append.append(random.randint(1, 100))

final = time.time()
print("Tiempo con append():", final - init, "segundos")
#2.  Para la segunda usar el operador += 
init = time.time()

lista_mas_igual = []
for _ in range(100_000):
    lista_mas_igual += [random.randint(1, 100)]

final = time.time()
print("Tiempo con += :", final - init, "segundos")
#3.  Para la tercera usar el operador + 
init = time.time()

lista_mas = []
for _ in range(100_000):
    lista_mas = lista_mas + [random.randint(1, 100)]

final = time.time()
print("Tiempo con + :", final - init, "segundos")
