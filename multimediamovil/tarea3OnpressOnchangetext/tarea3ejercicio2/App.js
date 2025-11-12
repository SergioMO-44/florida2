import { Text, Pressable, Image, View, StyleSheet } from 'react-native';
import { useState } from 'react';


export default function App() {
  /*Sin emplear arrays en los estados y utilizando una única función para 
manejar los dos eventos, implementa las instrucciones necesarias para que 
cuando el usuario pulse sobre el componente Image, se cambie la imagen 
de ese componente y el texto del componente Text ubicado debajo. Si 
vuelve a pulsar sobre el mismo componente, ambos componentes –Image y 
Text-, volverán al valor inicial. Si vuelve a pulsar, se volverán a cambiar. Y así 
sucesivamente. NOTA: implementa a cada componente Image una foto de 
tu elección. */
  const [image, setImage] = useState({image: require('./assets/snack-icon.png'), text:'Image one'});
  const [imageTwo, setImageTwo] = useState({image: require('./assets/icon.png'), text:'Image one'});

  function handleOnImage(num) {
      if (num === 0 && image.text === 'Image one') {
        setImage({image: require('./assets/icon.png'), text:'Image two'});
      } else if (num === 0 && image.text === 'Image two') {
        setImage({image: require('./assets/snack-icon.png'), text:'Image one'});
      } else if (num === 1 && imageTwo.text === 'Image one') {
        setImageTwo({image: require('./assets/snack-icon.png'), text:'Image two'});
      } else if (num === 1 && imageTwo.text === 'Image two') {
        setImageTwo({image: require('./assets/icon.png'), text:'Image one'});
      } 
  }

  return (
    <View style={styles.containerRow}>
      <Pressable onPress={() => handleOnImage(0)}>
        <Image style={styles.image} source={image.image} />
        <Text>{image.text}</Text>
      </Pressable>
      <Pressable onPress={() => handleOnImage(1)}>
        <Image style={styles.image} source={imageTwo.image} />
        <Text>{imageTwo.text}</Text>
      </Pressable>
    </View>
  );
}

const styles = StyleSheet.create({
  containerRow: {
    flex: 1,
    backgroundColor: 'white',
    alignItems: 'center',
    justifyContent: 'center',
    flexDirection:'row',
  },
  image: { 
    width: 100, 
    height: 100 
  },
});

