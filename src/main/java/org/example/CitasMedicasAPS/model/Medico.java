package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.ListProperties;
import org.openxava.annotations.Stereotype;
import org.openxava.annotations.Tab;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Tab(properties="nombre, apellido, especialidad.nombre, email")
public class Medico extends BaseEntity {
    private String nombre;
    private String apellido;

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList
    private Especialidad especialidad;

    private String email;

    public String nombreCompleto = nombre + " " + apellido;

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }


}
