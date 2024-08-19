import React from 'react';
import {
  Table,
  TableHead,
  TableRow,
  TableCell,
  TableBody,
  Typography,
  Paper,
} from '@mui/material';

const StudentGrid = ({ studentList }) => {
  const classAverage = studentList.reduce((acc, student) => acc + student.average, 0) / studentList.length;
  const sortedStudents = [...studentList].sort((a, b) => b.frequence - a.frequence);

  const subjectAverages = {
    portuguese: { sum: 0, count: 0 },
    mathematics: { sum: 0, count: 0 },
    geography: { sum: 0, count: 0 },
    history: { sum: 0, count: 0 },
    english: { sum: 0, count: 0 },
  };

  studentList.forEach((student) => {
    const portugueseNote = getNote(student.notes, 1);
    const mathematicsNote = getNote(student.notes, 2);
    const geographyNote = getNote(student.notes, 3);
    const historyNote = getNote(student.notes, 4);
    const englishNote = getNote(student.notes, 5);

    if (portugueseNote !== '-') {
      subjectAverages.portuguese.sum += parseFloat(portugueseNote);
      subjectAverages.portuguese.count++;
    }

    if (mathematicsNote !== '-') {
      subjectAverages.mathematics.sum += parseFloat(mathematicsNote);
      subjectAverages.mathematics.count++;
    }

    if (geographyNote !== '-') {
      subjectAverages.geography.sum += parseFloat(geographyNote);
      subjectAverages.geography.count++;
    }

    if (historyNote !== '-') {
      subjectAverages.history.sum += parseFloat(historyNote);
      subjectAverages.history.count++;
    }

    if (englishNote !== '-') {
      subjectAverages.english.sum += parseFloat(englishNote);
      subjectAverages.english.count++;
    }
  });

  Object.keys(subjectAverages).forEach((subject) => {
    const sum = subjectAverages[subject].sum;
    const count = subjectAverages[subject].count;
    subjectAverages[subject] = count > 0 ? sum / count : 0;
  });

  const aboveAverageStudents = studentList.filter((student) => student.average > classAverage);
  const belowAttendanceStudents = studentList.filter((student) => student.frequence < 75);

  return (
    <div>
  <Paper elevation={2}>
    <Typography variant="h5" gutterBottom style={{ marginTop: 20 }}>
      Notas dos Estudantes
    </Typography>

    <Table size="small">
      <TableHead>
        <TableRow>
          <TableCell>Estudantes</TableCell>
          <TableCell>Português</TableCell>
          <TableCell>Matemática</TableCell>
          <TableCell>Geografia</TableCell>
          <TableCell>História</TableCell>
          <TableCell>Inglês</TableCell>
          <TableCell>Média</TableCell>
          <TableCell>Frequência</TableCell>
        </TableRow>
      </TableHead>
      <TableBody>
        {studentList.map((student, index) => (
          <TableRow key={index}>
            <TableCell>{student.name}</TableCell>
            <TableCell>{getNote(student.notes, 1)}</TableCell>
            <TableCell>{getNote(student.notes, 2)}</TableCell>
            <TableCell>{getNote(student.notes, 3)}</TableCell>
            <TableCell>{getNote(student.notes, 4)}</TableCell>
            <TableCell>{getNote(student.notes, 5)}</TableCell>
            <TableCell>{student.average.toFixed(2)}</TableCell>
            <TableCell>{student.frequence}%</TableCell>
          </TableRow>
        ))}
        <TableRow style={{ backgroundColor: 'lightgray' }}>
          <TableCell>Média da classe</TableCell>
          <TableCell>{subjectAverages.portuguese.toFixed(2)}</TableCell>
          <TableCell>{subjectAverages.mathematics.toFixed(2)}</TableCell>
          <TableCell>{subjectAverages.geography.toFixed(2)}</TableCell>
          <TableCell>{subjectAverages.history.toFixed(2)}</TableCell>
          <TableCell>{subjectAverages.english.toFixed(2)}</TableCell>
          <TableCell>{classAverage.toFixed(2)}</TableCell>
          <TableCell />
          <TableCell />
        </TableRow>
      </TableBody>
    </Table>
 
    <hr />
 
    <Typography variant="h5" gutterBottom style={{ marginTop: 20 }}>
      Alunos com média superior a média da turma:
    </Typography>

    <Table size="small">
      <TableHead>
        <TableRow>
          <TableCell>Estudantes</TableCell>
          <TableCell>Média</TableCell>
        </TableRow>
      </TableHead>
      <TableBody>
        {aboveAverageStudents.map((student, index) => (
          <TableRow key={index}>
            <TableCell>{student.name}</TableCell>
            <TableCell>{student.average.toFixed(2)}</TableCell>
          </TableRow>
        ))}
      </TableBody>
    </Table>
    <hr />
 
    <Typography variant="h5" gutterBottom style={{ marginTop: 20 }}>
      Alunos com frequência inferior a 75%:
    </Typography>

    <Table size="small">
      <TableHead>
        <TableRow>
          <TableCell>Estudantes</TableCell>
          <TableCell>Frequência</TableCell>
        </TableRow>
      </TableHead>
      <TableBody>
        {belowAttendanceStudents.map((student, index) => (
          <TableRow key={index}>
            <TableCell>{student.name}</TableCell>
            <TableCell>{student.frequence}%</TableCell>
          </TableRow>
        ))}
      </TableBody>
    </Table>
  </Paper>
    </div>
  );
};

const getNote = (notes, disciplineId) => {
  const note = notes.find((note) => note.disciplineId === disciplineId);
  return note ? note.note.toFixed(1) : '-';
};

export default StudentGrid;