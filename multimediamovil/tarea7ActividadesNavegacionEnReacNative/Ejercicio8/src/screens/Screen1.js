import { useState } from 'react';
import {
  View,
  Pressable,
  ScrollView,
  Text,
  TextInput,
  StyleSheet,
  Image,
} from 'react-native';
import getData from '../services/services';

export default function Screen2() {
  const [searchTerm, setSearchTerm] = useState('');
  const [characters, setCharacters] = useState([
    {
      name: '',
      image: '',
      episodes: [],
    },
  ]);


  const getCharacters = async (name) => {
    const response = await getData(`https://rickandmortyapi.com/api/character/?name=${name}`);
    setCharacters(response.results);
  };

  


  return (
    <View style={styles.page}>
      <ScrollView>
        <View style={styles.container2}>
          <TextInput
            style={{ height: 40 }}
            placeholder="Inserta término de búsqueda"
            onChangeText={(newText) => setSearchTerm(newText)}
            defaultValue={searchTerm}
          />
          <Pressable onPress={() => getCharacters(searchTerm)} style={styles.button}>
            <Text style={styles.buttonText}>Buscar personajes</Text>
          </Pressable>
        </View>
        <View style={styles.container}>
          {characters.map((element, index) => (
            <View styel={{ width: '33%' }}>
              <Image
                style={{
                  width: 120,
                  height: 120,
                }}
                source={{
                  uri: element.image,
                }}
              />
              <Text style={styles.text}>{element.name}</Text>
            </View>
          ))}
        </View>
      </ScrollView>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: 'row',
    flexWrap: 'wrap',
    alignItems: 'flex-start',
  },
  page: {
    marginTop: 35,
    position: 'relative',
    justifyContent: 'center',
  },
  text: {
    fontSize: 10,
    textAlign: 'center',
  },
  button: {
    backgroundColor: 'black',
    width: '70%',
    padding: 15,
    borderRadius: 10,
    alignItems: 'center',
    marginTop: 40,
  },
  buttonText: {
    color: 'white',
    fontWeight: '700',
    fontSize: 16,
  },
  container2: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
});
