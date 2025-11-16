package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Especialidad extends BaseEntity{
    private String nombre;
    private String descripcion;
}
