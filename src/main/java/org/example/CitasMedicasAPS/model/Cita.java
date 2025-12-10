package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;
import org.example.CitasMedicasAPS.calculators.CalcularEstado;
import org.openxava.annotations.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.ws.rs.DefaultValue;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Tab(properties = "fecha, hora, medico.nombre, paciente.nombre, paciente.apellido, estado")
public class Cita extends BaseEntity {
    private LocalDate fecha;
    private LocalTime hora;

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "nombre, apellido")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "nombre, apellido")
    private Paciente paciente;

    @ReadOnly
    @DefaultValueCalculator(CalcularEstado.class)
    private estadoCita estado;
}
