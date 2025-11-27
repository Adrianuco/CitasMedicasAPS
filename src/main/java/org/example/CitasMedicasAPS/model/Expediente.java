package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
public class Expediente extends BaseEntity{
    @OneToOne(optional = true)
    private Paciente paciente;

    @OneToMany(mappedBy="expediente")
    private Collection<Vacuna> vacunas;
}
