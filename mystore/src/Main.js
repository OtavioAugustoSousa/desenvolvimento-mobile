import React, { Component } from 'react';
import { View } from 'react-native';
import firebase from 'firebase';
import Header from './ortak/Header';
import LoginForm from './LoginForm';
import Button from './ortak/Button';
import CardSection from './ortak/CardSection';
import Spinner from './ortak/Spinner';
import Textfield from "./Textfield";
import Card from './ortak/Card';

class Main extends Component {
  state = { loggedIn: null };
  componentWillMount() {
    firebase.initializeApp({
      apiKey: 'AIzaSyANJF_Wmq-yX28Q4T5ImxbnUO4QrMi33bI',
      authDomain: 'https://commerce-510cb.firebaseio.com',
      databaseURL: 'https://commerce-510cb.firebaseio.com/',
      projectId: 'commerce-510cb',
      storageBucket: 'commerce-510cb.appspot.com',
      messagingSenderId: '1093379819381'
    });

    firebase.auth().onAuthStateChanged((user) => {
      if (user) {
        this.setState({ loggedIn: true });
      } else {
        this.setState({ loggedIn: false });
      }
    });
  }

  clickLogout() {
    firebase.auth().signOut();
  }

  renderContent() {
    switch (this.state.loggedIn) {
      case true:
        return (
          <Card>
          <CardSection>
            <Textfield text="Titulo"></Textfield>
            </CardSection>
            <CardSection>
            <Textfield text= "Descricao"></Textfield>
            </CardSection>
            <CardSection>
              <Textfield text="Preco"></Textfield>
            </CardSection>
           <CardSection>
              <Button onPress={this.clickLogout.bind(this)}> Salvar </Button>
           </CardSection>
           <CardSection>
              <Button onPress={this.clickLogout.bind(this)}> LOGOUT </Button>
          </CardSection>
          </Card>
        );
      case false:
        return (
            <LoginForm />
        );
      default:
        return (
          <View>
            <Spinner size="large" />
          </View>
        );
    }
  }

  render() {
    return (
      <View>
        <Header headerText="Login Screen" />
        {this.renderContent()}
      </View>
    );
  }
}

export default Main;
