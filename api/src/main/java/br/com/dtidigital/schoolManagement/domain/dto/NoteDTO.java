package br.com.dtidigital.schoolManagement.domain.dto;

import br.com.dtidigital.schoolManagement.utils.Constants;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class NoteDTO {
    @NotNull(message = Constants.DISCIPLINE_IS_NULL)
    private Integer disciplineId;

    @NotNull
    @DecimalMin(value = Constants.ZERO, message = Constants.INVALID_NOTE_VALUE)
    @DecimalMax(value = Constants.TEN, message = Constants.INVALID_NOTE_VALUE)
    private double note;
}
