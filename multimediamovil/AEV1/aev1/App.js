import { Text, View, Pressable } from 'react-native';
import React, { useState } from 'react';

export default function App() {
  const [input, setInput] = useState('');
  const [result, setResult] = useState('0');

  const maxDisplay = (val) => {
    const str = String(val);
    return str.length > 11 ? str.slice(0, 11) : str;
  };

  const isValidDecimal = (val) => (val.match(/,/g) || []).length < 1;

  const factorial = (n) => {
    if (n < 0 || !Number.isInteger(n)) return 'Error';
    let f = 1;
    for (let i = 2; i <= n; i++) f *= i;
    return f;
  };

  const operations = {
    '1/X': (v) => v !== 0 ? 1 / v : 'Error',
    '!': (v) => factorial(v),
    '√': (v) => v >= 0 ? Math.sqrt(v) : 'Error',
    'ln': (v) => v > 0 ? Math.log(v) : 'Error',
    'log': (v) => v > 0 ? Math.log10(v) : 'Error',
    '&Pi;': () => Math.PI,
    'rad': (v) => v * (Math.PI / 180),
    'deg': (v) => v * (180 / Math.PI),
    'sen': (v) => Math.sin(v),
    'cos': (v) => Math.cos(v),
    'tan': (v) => Math.tan(v),
  };

  const handlePress = (value) => {
    if (value === 'C') {
      setInput('');
      setResult('0');
      return;
    }

    if (value === '=') {
      try {
        const evalInput = input.replace(/,/g, '.').replace(/x/g, '*');
        const res = eval(evalInput);
        setResult(maxDisplay(res));
        setInput('');
      } catch {
        setResult('Error');
      }
      return;
    }

    if (operations[value]) {
      try {
        const val = parseFloat(input.replace(/,/g, '.'));
        const res = operations[value](val);
        setResult(maxDisplay(res));
        setInput('');
      } catch {
        setResult('Error');
      }
      return;
    }

    if (value === ',' && !isValidDecimal(input)) return;

    setInput(input + value);
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

