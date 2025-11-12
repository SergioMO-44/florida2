import { View, Pressable, Text, StyleSheet } from 'react-native';
import { useState } from 'react';

export default function Ejercicio6() {
  /*Implementa la lógica necesaria para que cuando se pulse sobre Pressable, 
se cambie el color del cuadrado a amarillo y además se reduzca su tamaño. 
Si el usuario vuelve a pulsar, volverá al color verde y se seguirá reduciendo 
el tamaño. Así sucesivamente hasta que el usuario dé tantas pulsaciones 
sobre el componente Pressable que el cuadrado desaparezca.*/
  const [square, setSquare] = useState({
    color: 'green',
    side: 150,
  });

  function handleOnPress() {
    if (square.color === 'yellow') {
      setSquare({
        color: 'green',
        side: square.side + 10,
      });
    } else {
      setSquare({
        color: 'yellow',
        side: square.side - 20,
      });
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
