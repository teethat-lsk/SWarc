package edu.parinya.softarchdesign.structural;

public abstract class HealthcareWorkerDecorator extends HealthcareWorker{
    protected HealthcareServiceable worker;

    public HealthcareWorkerDecorator(HealthcareWorker worker) {
        super(worker);
        this.worker = worker;
    }

    @Override
    public double getPrice() {
        return worker.getPrice();
    }

    @Override
    public void service(){
        worker.service();
    }
}
