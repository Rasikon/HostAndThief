package main;

import java.util.List;

public class Thief extends Thread {
    public Backpack backpack;
    public List<Subject> apartmentList;

    public Thief(List<Subject> apartmentList,Backpack backpack){
        this.apartmentList = apartmentList;
        this.backpack = backpack;

    }

    @Override
    public void run() {
        synchronized (Apartment.apartment) {
            backpack.bustAllSet(apartmentList);
            for (int i = 0; i < backpack.getBackpackList().size(); i++) {
                System.out.println(Thread.currentThread().getName() + " забрал" + backpack.getBackpackList().get(i));
            }
        }
    }
}
