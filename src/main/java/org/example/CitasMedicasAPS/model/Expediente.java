package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Expediente extends BaseEntity{
    private String antecedentesPersonales;
    private String antecedentesFamiliares;
}
