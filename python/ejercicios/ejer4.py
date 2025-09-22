dias_semana = ("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
while True:
    numero = int(input("Introduce un número del 1 al 7 (0 para salir): "))
    if numero == 0:
        print("Programa finalizado.")
        break
    elif 1 <= numero <= len(dias_semana):
        print("Día correspondiente:", dias_semana[numero - 1])
    else:
        print("Número inválido. Intenta de nuevo.")
