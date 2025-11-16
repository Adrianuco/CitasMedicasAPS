package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DescriptionsList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalTime;

@Entity
@Getter
@Setter
public class Horario extends BaseEntity{
    private LocalTime horaInicio;
    private LocalTime horaFin;
    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList
    private Medico medico;
}
