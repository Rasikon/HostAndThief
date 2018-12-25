import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Apartment {
    private static Apartment instance;
    public static List<Item> apartmentList = Collections.synchronizedList(new ArrayList<>());
    public static volatile int sumHost =0;
    public static volatile int sumThief = 0;
    public static volatile int sumPeople = 0;

    private Apartment() {

    }

    public static Apartment getInstance() {
        if(instance == null){
            instance = new Apartment();
        }
        return instance;
    }

    public List<Item> getApartmentList() {
        return apartmentList;
    }

    public void addList(Item item) {
        apartmentList.add(item);
    }

    public  void delList(Item item) {
        apartmentList.remove(item);
    }


    public synchronized void doOpenHost() {
        while (sumThief > 0 ) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sumHost++;
        sumPeople++;
    }

    public synchronized void doOpenThief() {
        while (sumPeople > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sumThief++;
        sumPeople++;
    }


    public synchronized void doClose(){
        if (Thread.currentThread().getClass().getName().equals("Thief")){
            sumThief--;
            sumPeople--;
            notifyAll();
        }else if (Thread.currentThread().getClass().getName().equals("Host")){
            sumHost--;
            sumPeople--;
            notifyAll();
        }
    }


}



