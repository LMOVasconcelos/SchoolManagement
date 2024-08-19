package br.com.dtidigital.schoolManagement.controller;

import br.com.dtidigital.schoolManagement.domain.dto.RequestBodyDTO;
import br.com.dtidigital.schoolManagement.domain.dto.StudentDTO;
import br.com.dtidigital.schoolManagement.service.SchoolManagementService;
import br.com.dtidigital.schoolManagement.utils.Constants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = Constants.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class SchoolManagementController {

    @Autowired
    private SchoolManagementService service;

    @CrossOrigin(origins = "*")
    @PostMapping
    void save(@Valid @RequestBody RequestBodyDTO body) {
        service.save(body);
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<StudentDTO> getAll() {
        return service.getAll();
    }
}
