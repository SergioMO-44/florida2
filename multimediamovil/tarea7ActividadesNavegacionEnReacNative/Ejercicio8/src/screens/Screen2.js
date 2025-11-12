import { useState } from 'react';
import {
  View,
  Pressable,
  ScrollView,
  Text,
  TextInput,
  StyleSheet,
} from 'react-native';
import getData from '../services/services';

export default function Screen2() {
  const [searchTerm, setSearchTerm] = useState('');
  const [episode, setEpisode] = useState([
    {
      episodeName: '',
      airDate: '',
      episode: '',
    },
  ]);

  const getEpisodes = async (name) => {
     const response = await getData(
      `https://rickandmortyapi.com/api/episode/?episode=${name}`
    );
    response.results.map(item => {
      setEpisode([{
        episodeName: item.name,
        airDate: item.air_date,
        episode: item.episode,
      }])
    })
  };

  return (
    <View style={styles.page}>
      <ScrollView>
        <View style={styles.container2}>
          <TextInput
            style={{ height: 40 }}
            placeholder="Inserta episodio (Ej: S01E10)"
            onChangeText={(newText) => setSearchTerm(newText)}
            defaultValue={searchTerm}
          />
          <Pressable
            onPress={() => getEpisodes(searchTerm)}
            style={styles.button}>
            <Text style={styles.buttonText}>Buscar capítulos</Text>
          </Pressable>
        </View>
        <View style={styles.container2}>
          {episode.map((element) => (
            <View style={{ marginTop: 40, width: '80%' }}>
              <Text style={styles.text}>{element.episodeName}</Text>
              <Text style={styles.text}>{element.airDate}</Text>
              <Text style={styles.text}>{element.episode}</Text>
            </View>
          ))}
        </View>
      </ScrollView>
    </View>
  );
}

const styles = StyleSheet.create({
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
