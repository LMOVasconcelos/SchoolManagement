import './registerPage.css'
import axios from 'axios';
import  {useState, useEffect} from "react";
import { Card, CardContent, TextField, Grid, Button } from '@mui/material';
import useApi from './../../hooks/UseApi';
import { useNavigate } from 'react-router-dom';
import Report from '../report/reportPage';

const url = "http://localhost:8080/management"

function Register(){
    const [users, setUsers] = useState([]);

    const {data:  items , httpConfig , loading, error} = useApi(url);
  
    const [name, setName] = useState("");
    const [disciplineId1, setdisciplineId1] = useState();
    const [disciplineId2, setdisciplineId2] = useState();
    const [disciplineId3, setdisciplineId3] = useState();
    const [disciplineId4, setdisciplineId4] = useState();
    const [disciplineId5, setdisciplineId5] = useState();
    const [average, setAverage] = useState(0);
    const [frequence, setFrequence] = useState();
    const navigate = useNavigate();

    const goToReportPage = () =>{
      navigate('/report')
    }

    function formatDiscipline(e, setState) {
      let val = e.target.value; 
      if (val === '') {
          setState('');
      } else {
          val = parseFloat(val);
          if (val < 0) {
              setState(0);
          } else if (val > 10) {
              setState(10);
          } else {
              setState(val);
          }
      }
    }
    
    function formatFrequence(e, setState) {
      let val = e.target.value; 
      if (val === '') {
          setState('');
      } else {
          val = parseFloat(val);
          if (val < 0) {
              setState(0);
          } else if (val > 100) {
              setState(100);
          } else {
              setState(val);
          }
      }
    }
  
  // Adicionando alunos
      const handleSubmit = async(e) => {
        e.preventDefault(); 
  
        const user = {
          studentName: name,
          notes: [
            { disciplineId: 1, note: disciplineId1 },
            { disciplineId: 2, note: disciplineId2 },
            { disciplineId: 3, note: disciplineId3 },
            { disciplineId: 4, note: disciplineId4 },
            { disciplineId: 5, note: disciplineId5 },
          ],
          average: average,
          frequence: frequence
        };
  
        try {
          const response = await axios.post(url, user);
          // Handle the response
        } catch (error) {
          // Handle the error
        }
      
        setName("");
        setdisciplineId1(0);
        setdisciplineId2(0);
        setdisciplineId3(0);
        setdisciplineId4(0);
        setdisciplineId5(0);
        setFrequence(0);
      };
      
    return(
        <div className='App'>
      <h1>Registre seu aluno: </h1>
      <Grid container justifyContent="center" alignItems="center">
        <Grid item xs={6}>
          <Card>
            <CardContent>
              <Grid container spacing={2}>
                <Grid item xs={12}>
                  <TextField
                    label="Estudante"
                    type="text"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    variant="outlined"
                    fullWidth
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField    
                    label="Português"
                    type="number"    
                    value={disciplineId1}    
                    onChange={(e) => formatDiscipline(e, setdisciplineId1)}
                    variant="outlined"
                    fullWidth
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                    label="Matemática"
                    type="number"
                    value={disciplineId2}
                    onChange={(e) => formatDiscipline(e, setdisciplineId2)}
                    variant="outlined"
                    fullWidth
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                    label="Geografia"
                    type="number"
                    value={disciplineId3}
                    onChange={(e) => formatDiscipline(e, setdisciplineId3)}
                    variant="outlined"
                    fullWidth
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                    label="História"
                    type="number"
                    value={disciplineId4}
                    onChange={(e) => formatDiscipline(e, setdisciplineId4)}
                    variant="outlined"
                    fullWidth
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                    label="Inglês"
                    type="number"
                    value={disciplineId5}
                    onChange={(e) => formatDiscipline(e, setdisciplineId5)}
                    variant="outlined"
                    fullWidth
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                    label="Frequência (%)"
                    type="number"
                    value={frequence}
                    onChange={(e) => formatFrequence(e, setFrequence)}
                    variant="outlined"
                    fullWidth
                    inputProps={{ max: 100, min: 0 }}
                  />
                </Grid>
                <Grid item xs={6}>
                  <Button variant="contained" color="error" fullWidth>
                    Cancelar
                  </Button>
                </Grid>                
                <Grid item xs={6}>
                  <Button variant="contained" color="success" fullWidth type='submit' onClick={handleSubmit}>
                    Salvar
                  </Button>
                </Grid>
                <Grid item xs={12}>
                  <Button variant="contained" color="warning" fullWidth type='submit' onClick={goToReportPage}>
                    Gerar Relatório
                  </Button>
                </Grid>
              </Grid>
            </CardContent>
          </Card>
        </Grid>
      </Grid>
    </div>
    )
}

export default Register;