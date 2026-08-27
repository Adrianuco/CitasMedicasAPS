package org.example.CitasMedicasAPS.model;

import lombok.Getter;
import lombok.Setter;
import org.example.CitasMedicasAPS.calculators.CalcularEstado;
import org.openxava.annotations.*;
import org.openxava.annotations.Hidden;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.PostPersist;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Tab(properties = "fecha, hora, medico.nombre, medico.apellido, paciente.nombre, paciente.apellido, estado")
public class Cita extends BaseEntity {
    private LocalDate fecha;
    private LocalTime hora;

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "nombre, apellido")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "nombre, apellido")
    private Paciente paciente;

    @ReadOnly
    @DefaultValueCalculator(CalcularEstado.class)
    private estadoCita estado;

    @Hidden
    private boolean recordatorioEnviado;

    @PostPersist
    private void notificarPaciente() {
        if (paciente != null && paciente.getEmail() != null) {
            String asunto = "Confirmación de Cita Médica";
            String contenido = "Estimado " + paciente.getNombre() + " " + paciente.getApellido() + ",\n\n" +
                    "Su cita ha sido agendada para el día " + fecha + " a las " + hora + ".\n\n" +
                    "Atentamente,\nClínica Médica";
            try {
                org.openxava.util.Emails.send(paciente.getEmail(), asunto, contenido);
            } catch (Exception e) {
                System.out.println("Error enviando correo a " + paciente.getEmail());
                e.printStackTrace();
            }
        }
    }
}
