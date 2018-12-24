import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Apartment {
    public static List<Item> apartmentList = Collections.synchronizedList(new ArrayList<>());
    public static final Object apartment = new Object();
    public static volatile int sumHost =0;
    public static volatile int sumThief = 0;
    public static volatile int sumPeople = 0;

    public static List<Item> getApartmentList() {
        return apartmentList;
    }

    public static void addList(Item item) {
        apartmentList.add(item);
    }

    public static void delList(Item item) {
        apartmentList.remove(item);
    }


    public synchronized static boolean doOpenHost() {
        if (sumThief == 0) {
            return true;
        } else return false;
    }

    public synchronized static boolean doOpenThief() {
        if (sumHost == 0 && sumPeople == 0) {
            return true;
        } else return false;
    }

    public synchronized static void doClose(){
        if (Thread.currentThread().getClass().getName().equals("Thief")){
            sumThief--;
            sumPeople--;
        }else if (Thread.currentThread().getClass().getName().equals("Host")){
            sumHost--;
            sumPeople--;
        }
    }

    public synchronized static void incHost(){
        sumHost++;
        sumPeople++;
    }

    public synchronized static void incThief(){
        sumThief++;
        sumPeople++;
    }

}



