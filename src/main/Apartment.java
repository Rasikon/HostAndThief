package main;

import java.util.ArrayList;
import java.util.List;

public class Apartment {
    public static final Apartment apartment = new Apartment();

    public static void main(String[] args) throws InterruptedException {
        List<Subject> apartmentList = new ArrayList<>();
        apartmentList.add(new Subject("Конфеты",2,20));
        apartmentList.add(new Subject("Спички",8,60));
        apartmentList.add(new Subject("Окорок",10,50));
        apartmentList.add(new Subject("Кошелек",15,90));
        Host host = new Host(apartmentList);
        host.setName("Хозяин Василий");
        host.start();
        host.join();
        Thief thief = new Thief(apartmentList,new Backpack(10));
        thief.setName("Вор Анатолий");
        thief.start();
        Thief thief2 = new Thief(apartmentList,new Backpack(20));
        thief2.setName("Вор Андрей");
        thief2.start();
    }
}
