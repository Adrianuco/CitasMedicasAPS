package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
public class CondicionCronica {
    private String condicion;
    private LocalDate fechaDiagnostico;
    private String estadoActual;
    private String tratamientoActual;
    private String notas;
}
