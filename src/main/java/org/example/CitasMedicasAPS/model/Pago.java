package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
public class Pago extends BaseEntity{
    private LocalDate fecha;
    private MetodoPago metodoPago;

    @ManyToOne(fetch = FetchType.LAZY)
    private Paciente paciente;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Servicio> servicios;

    public BigDecimal getTotal(){
        if (servicios == null || servicios.isEmpty()){
            return BigDecimal.ZERO;
        }
        BigDecimal total = BigDecimal.ZERO;
        for (Servicio servicio : servicios){
            if (servicio.getPrecio() != null){
                total = total.add(servicio.getPrecio());
            }
        }
        return total;
    }
}
