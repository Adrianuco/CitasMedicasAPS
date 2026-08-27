package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
public class Vacuna {
    private String nombreVacuna;
    private LocalDate fechaAplicacion;
    private LocalDate proximaDosis;
    private String notasVacuna;
}
