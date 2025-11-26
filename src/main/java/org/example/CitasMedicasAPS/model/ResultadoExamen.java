package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Stereotype;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
public class ResultadoExamen extends BaseEntity {
    private String examen;
    private LocalDate fechaRealizacion;

    @Stereotype("FILE")
    private String resultadoExamen;
    private String interpretacion;
}
