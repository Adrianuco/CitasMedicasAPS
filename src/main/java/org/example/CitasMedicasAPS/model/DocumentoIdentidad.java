package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Hidden;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
@Getter
@Setter
public class DocumentoIdentidad{
    private TipoDocumento tipoDocumento;
    private String numeroDocumento;
}
