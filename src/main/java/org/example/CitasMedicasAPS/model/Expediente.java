package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Expediente extends BaseEntity{
    @OneToOne(cascade = CascadeType.ALL)
    private Paciente paciente;
    private String antecedentesPersonales;
    private String antecedentesFamiliares;
}
