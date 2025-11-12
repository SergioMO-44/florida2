import { View, Pressable, Text, StyleSheet } from 'react-native';
import { useState } from 'react';

export default function Ejercicio5() {
  /*Implementa la lógica necesaria para que cuando se pulse sobre el 
componente Pressable, se cambie el color del fondo a amarillo y el color del 
cuadrado a verde. Además, el cuadrado pasará a ser un rectángulo. Si el 
usuario vuelve a pulsar el componente Pressable, el color del fondo volverá 
a ser verde, el rectángulo pasará a ser un cuadrado y el color del cuadrado 
será amarillo. Y así sucesivamente a cada pulsación que el usuario dé sobre 
el componente Pressable.*/

  const [color, setColor] = useState('green');
  const [square, setSquare] = useState({ color: 'yellow', width: 200 });

  function handleOnPress() {
    if (color === 'yellow') {
      setColor('green');
      setSquare({ color: 'yellow', width: 200 });
    } else {
      setColor('yellow');
      setSquare({ color: 'green', width: 400 });
    }
  }

  return (
    <View style={[styles.container, { backgroundColor: color }]}>
      <View
        style={[
          styles.square,
          { backgroundColor: square.color, width: square.width },
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
    backgroundColor: 'green',
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
