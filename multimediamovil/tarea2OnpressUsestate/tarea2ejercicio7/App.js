import { View, Pressable, Text, StyleSheet } from 'react-native';
import { useState } from 'react';

export default function Ejercicio7() {
  /*Implementa las instrucciones necesarias para que el cuadrado realice los 
mismos cambios que en el ejercicio anterior –en color y tamaño-, pero esta 
vez aumentando de tamaño en lugar de disminuyendo. Cuando llegue a un 
tamaño de tu elección –por ejemplo, el ancho de la pantalla-, dejará de 
agrandarse y se mantendrá en ese valor. */
  const [square, setSquare] = useState({
    color: 'green',
    side: 150,
  });

  function handleOnPress() {
    if (square.color === 'yellow' && square.side < 390) {
      setSquare({
        color: 'green',
        side: square.side + 10,
      });
    } else if (square.color === 'yellow' && square.side >= 390) {
      setSquare({ color: 'green', side: 150 });
    } else if (square.color === 'green' && square.side < 390) {
      setSquare({
        color: 'yellow',
        side: square.side + 20,
      });
    } else if (square.color === 'green' && square.side >= 390) {
      setSquare({ color: 'green', side: 150 });
    }
  }

  return (
    <View style={styles.container}>
      <View
        style={[
          styles.square,
          {
            width: square.side,
            height: square.side,
            backgroundColor: square.color,
          },
        ]}
      />
      <Pressable onPress={handleOnPress}>
        <Text style={styles.text}>Púlsame!</Text>
      </Pressable>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'white',
    alignItems: 'center',
    justifyContent: 'center',
  },
  square: {
    marginTop: -6,
    width: 200,
    height: 200,
    backgroundColor: 'yellow',
  },
  text: {
    height: 40,
    width: 80,
    backgroundColor: 'blue',
    borderRadius: 8,
    padding: 6,
  },
});
