package org.example.CitasMedicasAPS.jobs;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class QuartzListener implements ServletContextListener {

    private Scheduler scheduler;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            JobDetail job = JobBuilder.newJob(NotificadorCitasJob.class)
                    .withIdentity("notificadorCitasJob", "grupo1")
                    .build();

            // Run daily at 8:00 AM
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("notificadorTrigger", "grupo1")
                    .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(8, 0))
                    .build();

            scheduler.scheduleJob(job, trigger);
            System.out.println("Quartz Scheduler iniciado y job programado.");

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            if (scheduler != null) {
                scheduler.shutdown();
            }
        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }
}
