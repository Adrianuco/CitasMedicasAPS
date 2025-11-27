package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.math.BigDecimal;

@Embeddable
@Getter
@Setter
public class AntecedenteFamiliar {
    private Parentesco parentesco;
    private String condicion;
    private BigDecimal edadAparicion;
    private String notas;
}
