package main;

import java.util.ArrayList;
import java.util.List;

public class Host extends Thread {
    private List<Subject> apartmentList;

    public Host(List<Subject> apartmentList) {
        this.apartmentList = apartmentList;
    }

    @Override
    public void run() {
        synchronized (Apartment.apartment) {
            for (Subject subject : apartmentList) {
                System.out.println(Thread.currentThread().getName() + " выложил " +
                        subject.getName() + " весом " + subject.getWeight() + "кг и ценой " + subject.getPrice() + "р. в квартиру");
            }
        }
    }
}
