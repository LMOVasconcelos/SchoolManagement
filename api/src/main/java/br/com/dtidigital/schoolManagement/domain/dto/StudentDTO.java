package br.com.dtidigital.schoolManagement.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class StudentDTO {
    private String name;
    private List<NoteDTO> notes;
    private double average;
    private double frequence;
}
