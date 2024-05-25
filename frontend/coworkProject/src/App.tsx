// src/App.tsx
import React from 'react';
import Landing from './components/LandingPage';
import Register from './pages/register/Register';
import { Login } from './pages/login/Login';

const App: React.FC = () => {
  return (
    <div className="App">
      <Landing />
      <Register />
      <Login />
    </div>
  );
};

export default App;
