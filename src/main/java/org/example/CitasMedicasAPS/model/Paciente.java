package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DefaultValueCalculator;
import org.openxava.annotations.ReadOnly;
import org.openxava.calculators.CurrentDateCalculator;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Paciente extends Persona{
    private EstadoCivil estadoCivil;
    private String ocupacion;
    private BigDecimal peso;
    private BigDecimal altura;
    private Nacionalidad nacionalidad;

    @Embedded
    private ContactoEmergencia contactoEmergencia;

    @ReadOnly
    @DefaultValueCalculator(CurrentDateCalculator.class)
    private LocalDate fechaRegistro;
}
