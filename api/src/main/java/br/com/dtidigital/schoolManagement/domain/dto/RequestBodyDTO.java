package br.com.dtidigital.schoolManagement.domain.dto;

import br.com.dtidigital.schoolManagement.utils.Constants;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class RequestBodyDTO {
    @NotNull(message = Constants.STUDENT_IS_NULL_OR_EMPTY)
    @NotEmpty(message = Constants.STUDENT_IS_NULL_OR_EMPTY)
    private String studentName;

    @NotNull(message = Constants.NOTE_LIST_IS_NULL_OR_EMPTY)
    @NotEmpty(message = Constants.NOTE_LIST_IS_NULL_OR_EMPTY)
    private List<NoteDTO> notes;

    @NotNull(message = Constants.INVALID_FREQUENCE_VALUE)
    @DecimalMin(value = Constants.ZERO, message = Constants.INVALID_FREQUENCE_VALUE)
    @DecimalMax(value = Constants.HUNDRED, message = Constants.INVALID_FREQUENCE_VALUE)
    private Double frequence;
}
