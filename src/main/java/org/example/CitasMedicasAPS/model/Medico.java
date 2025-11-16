package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DescriptionsList;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Medico extends BaseEntity {
    private String nombre;
    private String apellido;

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList
    private Especialidad especialidad;

    private String email;




}
