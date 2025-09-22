import random
maria = {
    "nombre": "María",
    "ejerciciosSemanales": [],
    "pruebasSemanales": []
}

pedro = {
    "nombre": "Pedro",
    "ejerciciosSemanales": [],
    "pruebasSemanales": []
}

miguel = {
    "nombre": "Miguel",
    "ejerciciosSemanales": [],
    "pruebasSemanales": []
}
print("Datos iniciales:")
print(maria)
print(pedro)
print(miguel)
for estudiante in [maria, pedro, miguel]:
    estudiante["ejerciciosSemanales"] = [random.randint(0, 10) for _ in range(10)]
    estudiante["pruebasSemanales"] = [random.randint(0, 10) for _ in range(10)]
for estudiante in [maria, pedro, miguel]:
    estudiante["examen"] = random.randint(0, 10) 
print("\nDatos finales:")
print(maria)
print(pedro)
print(miguel)
