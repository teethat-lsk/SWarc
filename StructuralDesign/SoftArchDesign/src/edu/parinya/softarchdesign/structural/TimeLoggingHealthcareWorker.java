package edu.parinya.softarchdesign.structural;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeLoggingHealthcareWorker extends HealthcareWorkerDecorator{

    public TimeLoggingHealthcareWorker(HealthcareWorker worker) {
        super(worker);
        System.out.println("Decorate "+ worker.getName()+" with TimeLogging.");
    }

    //Thu Oct 14 00:57:26 ICT 2021: Nicholas Gonzalez performs a surgery.
    @Override
    public void service() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        String timeStamp = dateFormat.format(date);
        System.out.print(timeStamp + ": ");
        super.service();
    }

}
