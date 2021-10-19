package edu.parinya.softarchdesign.structural;

import java.util.*;

public class HealthcareWorkerTeam implements HealthcareServiceable{


    private Set<HealthcareServiceable> members = new LinkedHashSet<HealthcareServiceable>();

    public void addMember(HealthcareServiceable worker){
        members.add(worker);
    }

    public void removeMember(HealthcareServiceable worker){
        members.remove(worker);
    }

    // from interface HealthcareServiceable
    @Override
    public void service() {
        for (HealthcareServiceable member : members) {
            member.service();
        }
    }

    @Override
    public double getPrice() {
        double totalPrice = 0;
        for (HealthcareServiceable member : members){
            totalPrice += member.getPrice();
        }
        return totalPrice;
    }


}
