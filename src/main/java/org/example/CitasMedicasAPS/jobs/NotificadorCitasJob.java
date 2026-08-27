package org.example.CitasMedicasAPS.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.openxava.util.Emails;
import org.example.CitasMedicasAPS.model.Cita;
import org.example.CitasMedicasAPS.model.estadoCita;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;
import org.openxava.jpa.XPersistence;

public class NotificadorCitasJob implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            LocalDate manana = LocalDate.now().plusDays(1);

            String jpql = "SELECT c FROM Cita c WHERE c.fecha = :manana " +
                    "AND c.estado = :pendiente " +
                    "AND c.recordatorioEnviado = false";

            TypedQuery<Cita> query = XPersistence.getManager().createQuery(jpql, Cita.class);
            query.setParameter("manana", manana);
            query.setParameter("pendiente", estadoCita.PENDIENTE);

            List<Cita> citas = query.getResultList();

            for (Cita cita : citas) {
                if (cita.getPaciente() != null && cita.getPaciente().getEmail() != null) {
                    String asunto = "Recordatorio: Su Cita Médica es Mañana";
                    String contenido = "Estimado/a " + cita.getPaciente().getNombre() + ",\n\n" +
                            "Le recordamos que tiene una cita médica programada para mañana " + cita.getFecha() +
                            " a las " + cita.getHora() + ".\n\n" +
                            "Atentamente,\nClínica Médica";
                    try {
                        Emails.send(cita.getPaciente().getEmail(), asunto, contenido);
                        System.out.println("Recordatorio enviado a: " + cita.getPaciente().getEmail());

                        cita.setRecordatorioEnviado(true);
                        XPersistence.getManager().merge(cita);

                    } catch (Exception e) {
                        System.err.println("Error enviando recordatorio a " + cita.getPaciente().getEmail());
                        e.printStackTrace();
                    }
                }
            }

            XPersistence.commit();

        } catch (Exception e) {
            System.err.println("Error en NotificadorCitasJob");
            e.printStackTrace();
            throw new JobExecutionException(e);
        }
    }
}
