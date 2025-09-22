 # Definimos la función que calcula los gastos de envío
def calcular_envio(num_articulos):
    if num_articulos <= 0:
        return 0.0  # No hay artículos, no hay gastos
    else:
        return 10.95 + (num_articulos - 1) * 2.95
# Programa principal
try:
    # Pedimos al usuario que introduzca el número de artículos
    cantidad = int(input("Introduce el número de artículos comprados: "))

    # Llamamos a la función para calcular el coste
    gastos = calcular_envio(cantidad)

    # Mostramos el resultado con dos decimales
    print(f"Los gastos de envío son: {gastos:.2f} €")

except ValueError:
    print("Por favor, introduce un número entero válido.")
