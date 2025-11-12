import { View, Pressable, Text, Image, StyleSheet } from 'react-native';
import { useState } from 'react';

export default function Ejercicio4() {
  /*Implementa la lógica necesaria para que en el Ejercicio 3 cada vez que el 
usuario pulse el componente Pressable, además del valor del color del 
fondo y el contenido del componente Text, también se cambie la imagen 
que se renderiza en pantalla.*/
  const [color, setColor] = useState('green');
  const [photo, setPhoto] = useState(require('./assets/snack-icon.png'));
  const [title, setTitle] = useState('My Title');

  function handleOnPress() {
    if (color === 'yellow') {
      setPhoto(require('./assets/snack-icon.png'));
      setTitle('My Title');
      setColor('green');
    } else {
      setPhoto(require('./assets/icon.png'));
      setColor('yellow');
      setTitle('My New Title');
    }
  }

  return (
    <View style={[styles.container, { backgroundColor: color }]}>
      <Text style={styles.title}>{title}</Text>
      <Image style={styles.image} source={photo} />
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


