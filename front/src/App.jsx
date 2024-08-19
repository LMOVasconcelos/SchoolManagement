import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css'
import Register from './pages/register/registerPage';
import Report from './pages/report/reportPage';




function App() {

  return (
    <BrowserRouter>
    <Routes>
        <Route path='/' element={<Register/>} />
        <Route path='/report' element={<Report/>} />
    </Routes>

    </BrowserRouter>
  );
}

export default App;