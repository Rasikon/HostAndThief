package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Apartment {
    static List<Subject> apartmentList;
    public static final Object apartmentLock = new Object();

    public static void main(String[] args) throws InterruptedException, IOException {
        apartmentList = Collections.synchronizedList(new ArrayList<>());
        System.out.println("Введите количество хозяинов");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int hosts = Integer.parseInt(reader.readLine());
        System.out.println(hosts);
        System.out.println("Введите количество воров");
        int thiefs=Integer.parseInt(reader.readLine());
        System.out.println(thiefs);
        for(int i =0; i < thiefs; i++) {
            System.out.println("Дайте имя хозяину");
            String name = reader.readLine();
            System.out.println("Введите количество вещей");
            int quantity = Integer.parseInt(reader.readLine());
            for(int i=0;i<quantity;i++) {
                System.out.println("Введите вещи их вес и цену");
                String itemName = reader.readLine();
                int weight = Integer.parseInt(reader.readLine());
                int price = Integer.parseInt(reader.readLine());
            }
        }



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
        Host host2 = new Host(hostList2);
        host2.setName("Хозяин Виктор");
        Thief thief = new Thief(new Backpack(10));
        thief.setName("Вор Анатолий");
        Thief thief2 = new Thief(new Backpack(40));
        thief2.setName("Вор Андрей");
        List<Subject> hostList3 = new ArrayList<>();
        hostList3.add(new Subject("Булка", 20, 500));
        hostList3.add(new Subject("Ноутбук", 15, 150));
        hostList3.add(new Subject("Стол", 10, 100));
        hostList3.add(new Subject("Стул", 15, 80));
        Host host3 = new Host(hostList3);
        host3.setName("Хозяин Григорий");
        host1.start();
        host2.start();
        host1.join();
        host2.join();
        thief.start();
        thief2.start();

    }
}
