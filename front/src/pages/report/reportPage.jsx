import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import StudentGrid from '../../../components/StudentGrid';
import './reportPage.css'
import useApi from './../../hooks/UseApi';
import { useNavigate } from 'react-router-dom';
import Register from '../register/registerPage';
import { Card, CardContent, TextField, Grid, Button } from '@mui/material';

function Report() {
  const { data: studentList, loading, error } = useApi('http://localhost:8080/management');
  const navigate = useNavigate();
  const goToRegisterPage = () =>{
    navigate('/')
  }

  if (loading) return <div>Carregando...</div>;
  if (error) return <div>Erro: {error.message}</div>;

  return (
    <>
    <Button variant="contained" color="warning" size="small" onClick={goToRegisterPage}>
      Adicionar Aluno
    </Button>
    <div style={{ marginTop: 20 }}>
      <StudentGrid studentList={studentList} />
    </div>
    

    </>
  );
}

export default Report;