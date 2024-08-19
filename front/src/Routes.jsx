import { BrowserRouter, Routes, Route } from 'react-router-dom';
import App from './App';
import AppR from './AppR';

const RoutesComponent = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<App />} />
        <Route path="/appR" element={<AppR />} />
      </Routes>
    </BrowserRouter>
  );
};

export default RoutesComponent;