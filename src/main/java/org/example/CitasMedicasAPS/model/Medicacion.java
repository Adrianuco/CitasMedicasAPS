package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
public class Medicacion {
    private String nombreMedicamento;
    private String dosis;
    private String frecuencia;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String indicaciones;
}
