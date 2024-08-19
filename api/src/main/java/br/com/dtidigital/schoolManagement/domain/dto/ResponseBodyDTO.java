package br.com.dtidigital.schoolManagement.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class ResponseBodyDTO {
    private List<StudentDTO> studentList;
}
