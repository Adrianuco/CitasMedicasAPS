package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.Tab;
import org.openxava.annotations.View;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Tab(properties = "fecha, hora, medico.nombreCompleto, paciente.nombre, paciente.apellido, estado")
public class Cita extends BaseEntity{
    private LocalDate fecha;
    private LocalTime hora;

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "nombre, apellido")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "nombre, apellido")
    private Paciente paciente;

    private estadoCita estado;
}
