package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.View;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@View(name="AdminView", members="paciente, fecha, hora, medico, estado")
@View(name="MedicoView", members="paciente, fecha, hora")
@Entity
@Getter
@Setter
public class Cita extends BaseEntity{
    private LocalDate fecha;
    private LocalTime hora;

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList
    private Paciente paciente;

    private estadoCita estado;
}
