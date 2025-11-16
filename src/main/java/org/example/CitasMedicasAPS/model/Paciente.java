package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Paciente extends BaseEntity {
    private String nombre;
    private String apellido;
    private int edad;
    private String telefono;

    @OneToOne(cascade = CascadeType.ALL)
    private Expediente expediente;
}
