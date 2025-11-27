package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
public class AntecedenteQuirurgico {
    private String nombreProcedimiento;
    private String descripcionProcedimiento;
    private LocalDate fechaProcedimiento;
    private String notas;
}
