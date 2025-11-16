package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DescriptionsList;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
public class Cita extends BaseEntity{
    private LocalDate fecha;
    private LocalTime hora;
    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList
    private Medico medico;

    private estadoCita estado;
}
