package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Servicio extends BaseEntity{
    private String nombre;
    private String descripcion;
    private BigDecimal precio;

}
