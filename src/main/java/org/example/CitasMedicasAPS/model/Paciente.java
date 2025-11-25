package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Paciente extends BaseEntity {
    private String nombre;
    private String apellido;
    private int edad;
    private String telefono;

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

}
