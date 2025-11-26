package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
public class Alergia extends BaseEntity {
    private String alergeno;
    private String reaccion;
    private Severidad severidad;
    private LocalDate fechaDiagnostico;
    private String notas;
}
