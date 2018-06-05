import React, { Component } from 'react';
import { AppRegistry, TextInput } from 'react-native';

export default class Textfild extends Component {
  constructor(props) {
    super(props);
    this.state = { text: props.text};
  }

  render() {
    return (
      <TextInput
        style={{height: 40, borderColor: 'gray', borderWidth: 1}}
        onChangeText={(text) => this.setState({text})}
        value={this.state.text}
      />
    );
  }
}