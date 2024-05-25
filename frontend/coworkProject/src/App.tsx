// src/App.tsx
import React from 'react';
import Landing from './components/LandingPage';
import Register from './pages/register/Register';

const App: React.FC = () => {
  return (
    <div className="App">
      <Landing />
      <Register />
    </div>
  );
};

export default App;
