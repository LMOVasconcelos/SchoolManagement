package br.com.dtidigital.schoolManagement.service;

import br.com.dtidigital.schoolManagement.domain.dto.RequestBodyDTO;
import br.com.dtidigital.schoolManagement.domain.dto.StudentDTO;

import java.util.List;

public interface SchoolManagementService {
    void save(RequestBodyDTO body);
    List<StudentDTO> getAll();
}
