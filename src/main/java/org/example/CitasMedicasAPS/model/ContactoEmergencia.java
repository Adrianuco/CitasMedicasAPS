package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Getter
@Setter
public class ContactoEmergencia extends BaseEntity {
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
}
