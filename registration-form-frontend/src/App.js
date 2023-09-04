import logo from './logo.svg';
import React from 'react';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import Home from './components/Home';
import Register from './components/Register';
import Login from './components/Login';
import FailToAccess from './components/FailToAccess';

function App() {
  return (
    <div className="App">
      <Router>
      <header className="App-bg">
        <div className="container">
              <Switch>
                <Route exact path="/" component = {Home}></Route> 
                <Route exact path="/home" component = {Home}></Route> 
                <Route exact path="/register" component = {Register}></Route> 
                <Route exact path="/login" component = {Login}></Route> 
                <Route exact path="/fail" component = {FailToAccess}></Route> 
              </Switch>
        </div>
        </header>
      </Router>
    </div>
  );
}

export default App;
