import { Text, View, StyleSheet } from 'react-native';
import { useState } from 'react';

export default function App() {
  /*Sin emplear arrays en los estados y utilizando una única función para 
manejar los cuatro eventos, implementa las instrucciones necesarias para 
que cuando el usuario pulse sobre cualquier componente Text, se cambie el 
texto contenido en ese componente. Si vuelve a pulsar sobre el mismo 
componente, volverá al valor inicial. Si vuelve a pulsar, se volverá a cambiar. 
Y así sucesivamente.*/
  const [textOne, setTextOne] = useState('text');
  const [textTwo, setTextTwo] = useState('text');
  const [textThree, setTextThree] = useState('text');
  const [textFour, setTextFour] = useState('text');

  function handleOnPress(num) {
    if (num === 0 && textOne === 'text') {
      setTextOne('changed text');
    } else if (num === 0 && textOne === 'changed text') {
      setTextOne('text');
    } else if (num === 1 && textTwo === 'text') {
      setTextTwo('changed text');
    } else if (num === 1 && textTwo === 'changed text') {
      setTextTwo('text');
    } else if (num === 2 && textThree === 'text') {
      setTextThree('changed text');
    } else if (num === 2 && textThree === 'changed text') {
      setTextThree('text');
    } else if (num === 3 && textFour === 'text') {
      setTextFour('changed text');
    } else if (num === 3 && textFour === 'changed text') {
      setTextFour('text');
    }
  }

  return (
    <View style={styles.container}>
      <Text style={styles.text} onPress={() => handleOnPress(0)}>
        {textOne}
      </Text>
      <Text style={styles.text} onPress={() => handleOnPress(1)}>
        {textTwo}
      </Text>
      <Text style={styles.text} onPress={() => handleOnPress(2)}>
        {textThree}
      </Text>
      <Text style={styles.text} onPress={() => handleOnPress(3)}>
        {textFour}
      </Text>
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
  text: {
    fontSize: 30,
    marginBottom: 20,
  },
});

