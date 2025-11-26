package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
public abstract class Persona extends BaseEntity{
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private Sexo sexo;
    private String email;
    private String telefono;
    private String direccion;

    @Embedded
    private DocumentoIdentidad documentoIdentidad;
}
