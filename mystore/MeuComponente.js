import React from 'react';
import { StyleSheet, Text, View } from 'react-native';

export default class MeuComponente extends React.Component {
  render() {
    return (
      <View style={styles.container}>
         <View style={styles.meuStyle}>
            <Text>Meu Componente</Text>
            <Text>{this.props.msg}</Text>
        </View>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  meuStyle:{
      backgroundColor: '#0f0',
      flex:0.5,

  }
});
