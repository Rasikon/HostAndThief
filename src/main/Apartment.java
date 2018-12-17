package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Apartment {
    static List<Subject> apartmentList;
    public static final Object apartmentLock = new Object();

    public static void main(String[] args) throws InterruptedException {
        apartmentList = Collections.synchronizedList(new ArrayList<>());
        List<Subject> hostList = new ArrayList<>();
        hostList.add(new Subject("Конфеты", 10, 100));
        hostList.add(new Subject("Спички", 8, 60));
        hostList.add(new Subject("Окорок", 10, 50));
        hostList.add(new Subject("Кошелек", 15, 90));
        List<Subject> hostList2 = new ArrayList<>();
        hostList2.add(new Subject("Шоколад", 10, 200));
        hostList2.add(new Subject("Компьютер", 8, 60));
        hostList2.add(new Subject("Редиску", 10, 300));
        hostList2.add(new Subject("Сосиску", 15, 90));
        Host host1 = new Host(hostList);
        host1.setName("Хозяин Василий");
        host1.start();
        Host host2 = new Host(hostList2);
        host2.setName("Хозяин Виктор");
        host2.start();
        Thief thief = new Thief(new Backpack(10));
        thief.setName("Вор Анатолий");
        thief.start();
        Thief thief2 = new Thief(new Backpack(40));
        thief2.setName("Вор Андрей");
        thief2.start();
        List<Subject> hostList3 = new ArrayList<>();
        hostList3.add(new Subject("Булка", 20, 500));
        hostList3.add(new Subject("Ноутбук", 15, 150));
        hostList3.add(new Subject("Стол", 10, 100));
        hostList3.add(new Subject("Стул", 15, 80));
        Host host3 = new Host(hostList3);
        host3.setName("Хозяин Григорий");
        host3.start();
    }
}
