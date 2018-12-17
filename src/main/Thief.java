package main;

import static main.Apartment.apartmentList;

public class Thief extends Thread {
    private Backpack backpack;

    Thief(Backpack backpack) {
        this.backpack = backpack;

    }

    @Override
    public void run() {
        synchronized (Thief.class) {
            backpack.bustAllSet(apartmentList);
            if(backpack.getBackpackList()!= null) {
                for (int i = 0; i < backpack.getBackpackList().size(); i++) {
                    System.out.println(Thread.currentThread().getName() + " забрал" + backpack.getBackpackList().get(i));
                    apartmentList.remove(backpack.getBackpackList().get(i));
                }
            }
        }
    }
}
