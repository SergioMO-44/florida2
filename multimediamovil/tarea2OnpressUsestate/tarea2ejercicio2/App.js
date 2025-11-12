import { View, Pressable, Text, Image, StyleSheet } from 'react-native';
import { useState } from 'react';

export default function Ejercicio2() {
  /*Implementa la lógica necesaria para que, sin tocar los estilos contenidos en 
la constante styles, cuando se renderice la interfaz, el color del fondo de 
pantalla sea el verde. Si el usuario pulsa el componente Pressable, el color 
del fondo de la pantalla se cambiará a azul. Si vuelve a pulsar se cambiará a 
verde. Y así sucesivamente irá intercambiándose el valor del color del fondo 
de la pantalla entre azul y verde, cada vez que el usuario vaya pulsando el 
botón.*/
 const [color, setColor] = useState('green');

  function handleOnPress() {
    color === 'green' ? setColor('blue') : setColor('green');
  }

  return (
    <View style={[styles.container, { backgroundColor: color }]}>
      <Text style={styles.title}>My Title</Text>
      <Image
        style={styles.image}
        source={require('./assets/snack-icon.png')}
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
    backgroundColor: 'yellow',
    alignItems: 'center',
    justifyContent: 'center',
  },
  title: {
    fontSize: 25,
    fontWeight: 'bold',
    fontStyle: 'italic',
    textDecorationLine: 'underline',
  },
  image: {
    width: 200,
    height: 200,
  },
  text: {
    height: 40,
    width: 80,
    backgroundColor: 'blue',
    borderRadius: 8,
    padding: 6,
  },
});
 

