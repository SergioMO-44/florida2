import { useState } from 'react';
import { Text, Pressable, TextInput, View, StyleSheet } from 'react-native';

export default function Ejercicio5() {
  /*Implementa las instrucciones necesarias para renderizar en la interfaz 
gráfica un convertidor de kilómetros a millas. Para ello, renderiza un 
componente TextInput que recoja el contenido que introduzca el usuario, y, 
debajo, un componente Pressable. Implementa la lógica necesaria para que 
cuando el usuario pulse el botón de Pressable, se renderice debajo del 
componente TextInput la cantidad de kilómetros introducida convertida a 
millas. Si el usuario no introduce ningún dato, saltará una alerta indicándolo 
y se borrará el contenido introducido en TextInput. Si introduce texto, se le 
indicará que ha introducido texto y se borrará el contenido introducido en 
TextInput. 
Nota: 1 kilómetro son 0.62 millas.*/
  const [text, setText] = useState('');
  const [miles, setMiles] = useState();

  function handleOnPress() {
    if (isNaN(text)) {
      alert('Has introducido texto');
      setMiles('');
    } else if (text === '') {
      alert('No has introducido nada');
      setMiles('');
    } else if (!isNaN(text)) {
      let result = text * 0.621371;
      setMiles(result.toFixed(2) + ' millas');
    }
    setText('');
  }

  return (
    <View style={styles.container}>
      <Text style={{ fontSize: 30 }}>Conversor de km a millas</Text>
      <TextInput
        style={{ height: 40 }}
        placeholder="Inserta kilómetros"
        onChangeText={(newText) => setText(newText)}
        defaultValue={text}
      />
      <Text style={{ padding: 10, fontSize: 42 }}>{miles}</Text>
      <Pressable onPress={handleOnPress}>
        <Text style={styles.text}>Pulsa...</Text>
      </Pressable>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  text: {
    height: 40,
    width: 80,
    backgroundColor: 'lightblue',
    borderRadius: 8,
    padding: 6,
  },
});