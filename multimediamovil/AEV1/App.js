import { Text, View, Pressable } from 'react-native';
import React, { useState } from 'react';

export default function App() {
  const [input, setInput] = useState('');
  const [result, setResult] = useState('0');
  /*- input: almacena lo que el usuario va escribiendo (números, operadores).
- result: muestra el resultado calculado. Por defecto es '0'.
*/
  const maxDisplay = (val) => {
  // Convertimos el valor a cadena de texto
  let texto = String(val);

  // Verificamos si la longitud del texto es mayor a 11
  if (texto.length > 11) {
    // Si es mayor, recortamos el texto a los primeros 11 caracteres
    let recortado = '';
    for (let i = 0; i < 11; i++) {
      recortado += texto[i];
    }
    return recortado;
  } else {
    // Si no es mayor, devolvemos el texto original
    return texto;
  }
};
  
 const factorial = (n) => {
  // Verificamos si el número es negativo o no entero
  if (n < 0 || !Number.isInteger(n)) {
    return 'Error';
  }
  // Inicializamos la variable que almacenará el resultado
  let resultado = 1;
  // Si el número es 0 o 1, el factorial es 1
  if (n === 0 || n === 1) {
    return resultado;
  }
  // Usamos un bucle for para multiplicar desde 2 hasta n
  for (let i = 2; i <= n; i++) {
    resultado = resultado * i;
  }
  // Devolvemos el resultado final
  return resultado;
};

 // Operaciones científicas y especiales definidas como funciones separadas
const operaciones = {};

operaciones['1/X'] = function(v) {
  if (v !== 0) {
    return 1 / v;
  } else {
    return 'Error';
  }
};

operaciones['!'] = function(v) {
  return factorial(v);
};

operaciones['√'] = function(v) {
  if (v >= 0) {
    return Math.sqrt(v);
  } else {
    return 'Error';
  }
};

operaciones['ln'] = function(v) {
  if (v > 0) {
    return Math.log(v);
  } else {
    return 'Error';
  }
};

operaciones['log'] = function(v) {
  if (v > 0) {
    return Math.log10(v);
  } else {
    return 'Error';
  }
};

operaciones['&Pi;'] = function() {
  return Math.PI;
};

operaciones['rad'] = function(v) {
  return v * (Math.PI / 180);
};

operaciones['deg'] = function(v) {
  return v * (180 / Math.PI);
};

operaciones['sen'] = function(v) {
  return Math.sin(v);
};

operaciones['cos'] = function(v) {
  return Math.cos(v);
};

operaciones['tan'] = function(v) {
  return Math.tan(v);
};

// Función principal para manejar los botones
const handlePress = (value) => {
  // Si se pulsa "C", se reinicia la calculadora
  if (value === 'C') {
    setInput('');
    setResult('0');
    return;
  }

  // Si se pulsa "=", se evalúa la expresión matemática
  if (value === '=') {
    try {
      let texto = input;
      texto = texto.replace(/,/g, '.'); // Convertir coma a punto decimal
      texto = texto.replace(/x/g, '*'); // Convertir "x" a multiplicación

      let resultadoEvaluado = eval(texto); // Evaluar la expresión
      let resultadoFinal = maxDisplay(resultadoEvaluado); // Limitar a 11 caracteres

      setResult(resultadoFinal);
      setInput('');
    } catch (error) {
      setResult('Error');
    }
    return;
  }

  // Si se pulsa una operación científica
  if (operaciones[value]) {
    try {
      let texto = input;
      texto = texto.replace(/,/g, '.'); // Convertir coma a punto decimal

      let numero = parseFloat(texto); // Convertir a número
      let resultadoOperacion = operaciones[value](numero); // Ejecutar operación
      let resultadoFinal = maxDisplay(resultadoOperacion); // Limitar a 11 caracteres

      setResult(resultadoFinal);
      setInput('');
    } catch (error) {
      setResult('Error');
    }
    return;
  }

  // Validar coma decimal
  if (value === ',') {
    let cantidadComas = 0;
    for (let i = 0; i < input.length; i++) {
      if (input[i] === ',') {
        cantidadComas = cantidadComas + 1;
      }
    }
    if (cantidadComas >= 1) {
      return;
    }
  }

  // Si no es ninguna de las anteriores, se agrega el valor al input
  let nuevoTexto = input + value;
  setInput(nuevoTexto);
};

  return (
    <View style={{ justifyContent: 'center', alignSelf: "center", marginVertical: 80 }}>
      <Text style={{ fontSize: 45, fontWeight: "bold" }}>Calculadora</Text>

      <View style={{ marginTop: 5 }}>
        <View style={{ flexDirection: "row", marginBottom: 10, height: 70, width: 340, borderRadius: 4, borderWidth: 1 }}>
          <Text style={{ fontSize: 50, textAlign: "right", flex: 1 }}>{input || result}</Text>
        </View>
        <View style={{ flexDirection: "row" }}>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('sen')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'gray' }}><Text>sen</Text></Pressable>
          </View>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('cos')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'gray' }}><Text>cos</Text></Pressable>
          </View>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('tan')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'gray' }}><Text>tan</Text></Pressable>
          </View>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('deg')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'gray' }}><Text>deg</Text></Pressable>
          </View>
        </View>
        <View style={{ flexDirection: "row" }}>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('ln')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'gray' }}><Text>ln</Text></Pressable>
          </View>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('log')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'gray' }}><Text>log</Text></Pressable>
          </View>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('&Pi;')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'gray' }}><Text>&Pi;</Text></Pressable>
          </View>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('rad')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'gray' }}><Text>rad</Text></Pressable>
          </View>
        </View>
        <View style={{ flexDirection: "row" }}>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('1/X')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'gray' }}><Text>1/X</Text></Pressable>
          </View>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('!')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'gray' }}><Text>!</Text></Pressable>
          </View>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('√')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'gray' }}><Text>√</Text></Pressable>
          </View>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('/')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'gray' }}><Text>/</Text></Pressable>
          </View>
        </View>
        <View style={{ flexDirection: "row" }}>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('7')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'blue' }}><Text>7</Text></Pressable>
          </View>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('8')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'blue' }}><Text>8</Text></Pressable>
          </View>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('9')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'blue' }}><Text>9</Text></Pressable>
          </View>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('x')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'gray' }}><Text>x</Text></Pressable>
          </View>
        </View>
        <View style={{ flexDirection: "row" }}>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('4')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'blue' }}><Text>4</Text></Pressable>
          </View>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('5')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'blue' }}><Text>5</Text></Pressable>
          </View>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('6')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'blue' }}><Text>6</Text></Pressable>
          </View>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('-')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'gray' }}><Text>-</Text></Pressable>
          </View>
        </View>
        <View style={{ flexDirection: "row" }}>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('1')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'blue' }}><Text>1</Text></Pressable>
          </View>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('2')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'blue' }}><Text>2</Text></Pressable>
          </View>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('3')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'blue' }}><Text>3</Text></Pressable>
          </View>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('+')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'gray' }}><Text>+</Text></Pressable>
          </View>
        </View>
        <View style={{ flexDirection: "row" }}>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('C')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'gray' }}><Text>C</Text></Pressable>
          </View>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('0')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'blue' }}><Text>0</Text></Pressable>
          </View>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress(',')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'gray' }}><Text>,</Text></Pressable>
          </View>
          <View style={{ padding: 3 }}>
            <Pressable onPress={() => handlePress('=')} style={{ borderRadius: 8, justifyContent: 'center', alignItems: 'center', textAlignVertical: 'center', width: 80, height: 80, backgroundColor: 'gray' }}><Text>=</Text></Pressable>
          </View>
        </View>
      </View>
    </View>
  );
}

