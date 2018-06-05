import React from 'react';
import Main from './src/Main';

import { StyleSheet, Text, View } from 'react-native';

export default class App extends React.Component {
  render() {
    return (
     <Main></Main>
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
});
