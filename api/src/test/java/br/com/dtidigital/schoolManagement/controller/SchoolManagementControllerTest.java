package br.com.dtidigital.schoolManagement.controller;

import br.com.dtidigital.schoolManagement.domain.dto.NoteDTO;
import br.com.dtidigital.schoolManagement.domain.dto.RequestBodyDTO;
import br.com.dtidigital.schoolManagement.domain.dto.ResponseBodyDTO;
import br.com.dtidigital.schoolManagement.domain.model.Discipline;
import br.com.dtidigital.schoolManagement.repository.DisciplineRepository;
import br.com.dtidigital.schoolManagement.service.SchoolManagementService;
import br.com.dtidigital.schoolManagement.utils.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SchoolManagementControllerTest {

    @InjectMocks
    private SchoolManagementController controller;

    @Mock
    private SchoolManagementService service;

    @Mock
    private DisciplineRepository disciplineRepository;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    private final String STUDENT_TEST = "Luiz Miguel";
    private final double FREQUENCE_TEST = 76.7;
    private final int DISCIPLINE_ID_TEST = 1;
    private final double NOTE_TEST = 7.5;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void save_ShouldReturn200_WhenRequestBodyIsValid() throws Exception {
        RequestBodyDTO requestBodyDTO = createValidRequestBodyDTO();

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(requestBodyDTO);

        mockMvc.perform(post(Constants.PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void save_ShouldReturn400_WhenRequestBodyIsInvalid() throws Exception {
        RequestBodyDTO requestBodyDTO = createInvalidRequestBodyDTO();

        String json = objectMapper.writeValueAsString(requestBodyDTO);

        mockMvc.perform(post(Constants.PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getAll_ShouldReturn200_WithTheExistingData() throws Exception {
        RequestBodyDTO requestBodyDTO = createValidRequestBodyDTO();

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(requestBodyDTO);

        mockMvc.perform(post(Constants.PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());

        mockMvc.perform(get(Constants.PATH)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getAll_ShouldReturn200_DataDoesNotExist() throws Exception {
        ResponseBodyDTO responseBodyDTO = createResponseBodyDTO();

        mockMvc.perform(get(Constants.PATH)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    private ResponseBodyDTO createResponseBodyDTO() {
        return ResponseBodyDTO.builder()
                .studentList(Collections.emptyList())
                .build();
    }

    private RequestBodyDTO createValidRequestBodyDTO() {
        return RequestBodyDTO.builder()
                .studentName(STUDENT_TEST)
                .notes(createNoteList())
                .frequence(FREQUENCE_TEST)
                .build();
    }

    private List<NoteDTO> createNoteList() {
        var disciplineList = createDisciplines();
        var noteList = new ArrayList<NoteDTO>();
        var noteValue = 7;

        disciplineList.forEach(discipline -> {
            var note = NoteDTO.builder().disciplineId(discipline.getId()).note(noteValue).build();
            noteList.add(note);
        });

        return noteList;
    }

    private List<Discipline> createDisciplines() {
        var disciplineList = new ArrayList<Discipline>();
        disciplineList.add(Discipline.builder().id(1).name("Português").build());
        disciplineList.add(Discipline.builder().id(2).name("Matemática").build());
        disciplineList.add(Discipline.builder().id(3).name("Geografia").build());
        disciplineList.add(Discipline.builder().id(4).name("História").build());
        disciplineList.add(Discipline.builder().id(5).name("Inglês").build());
        return disciplineList;
    }

    private RequestBodyDTO createInvalidRequestBodyDTO() {
        return RequestBodyDTO.builder()
                .studentName("")
                .notes(Collections.emptyList())
                .frequence(-1.0)
                .build();
    }
}