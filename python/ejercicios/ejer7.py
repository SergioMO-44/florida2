import random

# Paso 1: Crear los diccionarios iniciales
maria = {
    "nombre": "María",
    "ejerciciosSemanales": [random.randint(0, 10) for _ in range(10)],
    "pruebasSemanales": [random.randint(0, 10) for _ in range(10)],
    "examen": random.randint(0, 10)
}

pedro = {
    "nombre": "Pedro",
    "ejerciciosSemanales": [random.randint(0, 10) for _ in range(10)],
    "pruebasSemanales": [random.randint(0, 10) for _ in range(10)],
    "examen": random.randint(0, 10)
}

miguel = {
    "nombre": "Miguel",
    "ejerciciosSemanales": [random.randint(0, 10) for _ in range(10)],
    "pruebasSemanales": [random.randint(0, 10) for _ in range(10)],
    "examen": random.randint(0, 10)
}

# Paso 2: Crear la lista de estudiantes
estudiantes = [maria, pedro, miguel]

# Paso 3: Procesar cada estudiante
for estudiante in estudiantes:
    # Calcular medias
    media_ejercicios = sum(estudiante["ejerciciosSemanales"]) / len(estudiante["ejerciciosSemanales"])
    media_pruebas = sum(estudiante["pruebasSemanales"]) / len(estudiante["pruebasSemanales"])

    # Reemplazar listas por listas con notas y media
    estudiante["ejerciciosSemanales"] = [estudiante["ejerciciosSemanales"], media_ejercicios]
    estudiante["pruebasSemanales"] = [estudiante["pruebasSemanales"], media_pruebas]

    # Calcular nota final ponderada
    nota_final = (media_ejercicios * 0.1) + (media_pruebas * 0.3) + (estudiante["examen"] * 0.6)
    estudiante["nota"] = round(nota_final, 2)

    # Asignar nota literal
    if nota_final >= 9:
        estudiante["notaLiteral"] = "A"
    elif nota_final >= 8:
        estudiante["notaLiteral"] = "B"
    elif nota_final >= 7:
        estudiante["notaLiteral"] = "C"
    elif nota_final >= 6:
        estudiante["notaLiteral"] = "D"
    elif nota_final >= 5:
        estudiante["notaLiteral"] = "E"
    else:
        estudiante["notaLiteral"] = "F"

# Paso 4: Imprimir los datos de cada estudiante
print("\nDatos de los estudiantes:")
for estudiante in estudiantes:
    print(estudiante)

# Paso 5: Calcular e imprimir la nota media de la clase
nota_media_clase = sum(e["nota"] for e in estudiantes) / len(estudiantes)
print(f"\nNota media de la clase: {round(nota_media_clase, 2)}")
