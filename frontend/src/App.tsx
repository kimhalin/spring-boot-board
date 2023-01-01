import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Header from './components/Header';
import BoardPage from './pages/BoardPage';

function App() {
  return (
    <React.Fragment>
      <BrowserRouter>
      <Header/>
        <Routes>
          <Route path="/" element={<BoardPage/>} />
        </Routes>
      </BrowserRouter>
    </React.Fragment>


  );
}

export default App;
