package br.com.dtidigital.schoolManagement.service.implementation;

import br.com.dtidigital.schoolManagement.domain.dto.NoteDTO;
import br.com.dtidigital.schoolManagement.domain.dto.RequestBodyDTO;
import br.com.dtidigital.schoolManagement.domain.dto.StudentDTO;
import br.com.dtidigital.schoolManagement.domain.model.Discipline;
import br.com.dtidigital.schoolManagement.domain.model.Note;
import br.com.dtidigital.schoolManagement.domain.model.Presence;
import br.com.dtidigital.schoolManagement.domain.model.Student;
import br.com.dtidigital.schoolManagement.exception.type.NotFoundException;
import br.com.dtidigital.schoolManagement.repository.DisciplineRepository;
import br.com.dtidigital.schoolManagement.repository.NoteRepository;
import br.com.dtidigital.schoolManagement.repository.PresenceRepository;
import br.com.dtidigital.schoolManagement.repository.StudentRepository;
import br.com.dtidigital.schoolManagement.service.SchoolManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolManagementServiceImpl implements SchoolManagementService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private PresenceRepository presenceRepository;

    @Override
    public void save(RequestBodyDTO body) {
        var student = saveStudent(body.getStudentName());
        saveNote(student, body.getNotes());
        savePresence(student, body.getFrequence());
    }

    @Override
    public List<StudentDTO> getAll() {
        var students = studentRepository.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();

        students.forEach(student -> {
            var studentDTO = StudentDTO.builder()
                    .name(student.getName())
                    .notes(getNoteList(student.getNotes()))
                    .average(getAverage(student.getNotes()))
                    .frequence(student.getPresence().getFrequence())
                    .build();

            studentDTOList.add(studentDTO);
        });

        return studentDTOList;
    }

    private Student saveStudent(String studentName) {
        var student = Student.builder().name(studentName).build();
        return studentRepository.save(student);
    }

    private void saveNote(Student student, List<NoteDTO> noteList) {
        List<Note> newNotes = noteList.stream()
                .map(dto -> Note.builder()
                        .student(student)
                        .discipline(getDiscipline(dto.getDisciplineId()))
                        .note(dto.getNote())
                        .build())
                .collect(Collectors.toList());
        noteRepository.saveAllAndFlush(newNotes);
    }

    private void savePresence(Student student, double frequence) {
        var presence = Presence.builder().student(student).frequence(frequence).build();
        presenceRepository.saveAndFlush(presence);
    }

    private List<NoteDTO> getNoteList(List<Note> notes) {
        List<NoteDTO> noteDTOList = new ArrayList<>();

        notes.forEach(note -> {
            var noteDTO = NoteDTO.builder()
                    .disciplineId(note.getDiscipline().getId())
                    .note(note.getNote())
                    .build();
            noteDTOList.add(noteDTO);
        });

        return noteDTOList;
    }

    private double getAverage(List<Note> notes) {
        List<Double> noteList = new ArrayList<>();
        notes.forEach(note -> noteList.add(note.getNote()));

        var average = noteList.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .getAsDouble();

        return average;
    }

    private Discipline getDiscipline(Integer disciplineId) {
        return disciplineRepository.findDisciplineById(disciplineId).orElseThrow(() -> new NotFoundException("Discipline not found."));
    }
}
