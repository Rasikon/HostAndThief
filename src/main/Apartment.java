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
        if (Thread.currentThread().getClass().getName().equals("Host") && sumThief==0){
            sumPeople++;
            sumHost++;
          return true;
        } else if (Thread.currentThread().getClass().getName().equals("Thief") && sumPeople==0) {
            sumPeople++;
            sumThief++;
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

}



