import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, Image, ScrollView } from 'react-native';

export default function App() {
  return (
    <View style={styles.container}>
      <Text>Open up App.js to start working on your app!</Text>
      <Text>Hola mundo</Text>
      <Image style={{ width: 400, height: 400 }} source={require('./assets/paisaje.jpg')}/>
      <ScrollView style={styless.scroll}>
      <Text>Elemento 1</Text>
      <Text>Elemento 2</Text>
      <Text>Elemento 3</Text>
      {/* Puedes seguir agregando más */}
    </ScrollView>
  
      <StatusBar style="auto" />
    </View>
  );
}
const styless = StyleSheet.create({
  scroll: {
    padding: 20,
  },
});

const styles = StyleSheet.create({
  container: {
    marginTop: 100,
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
