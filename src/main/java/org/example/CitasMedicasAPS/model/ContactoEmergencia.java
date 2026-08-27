package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Getter
@Setter
public class ContactoEmergencia {
    private String nombreContacto;
    private String apellidoContacto;
    private String telefonoContacto;
    private String direccionContacto;
}
