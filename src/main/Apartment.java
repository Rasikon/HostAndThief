import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Apartment {
    private static Apartment instance;
    private List<Item> apartmentList = Collections.synchronizedList(new ArrayList<>());
    private int thiefCount = 0;
    private int peopleCount = 0;

    static Apartment getInstance() {
        if (instance == null) {
            instance = new Apartment();
        }
        return instance;
    }

    private Apartment() {

    }

    List<Item> getApartmentList() {
        return apartmentList;
    }

    void addItemApartment(Item item) {
        apartmentList.add(item);
    }

    void delItemApartment(Item item) {
        apartmentList.remove(item);
    }

    synchronized void doOpenApartment() {
        String threadName = Thread.currentThread().getClass().getName();
        if (threadName.equals("Host")) {
            while (thiefCount > 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            peopleCount++;
        } else if (threadName.equals("Thief")) {
            while (peopleCount > 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            thiefCount++;
            peopleCount++;
        }
    }

    synchronized void doCloseApartment() {
        String threadName = Thread.currentThread().getClass().getName();
        if (threadName.equals("Thief")) {
            thiefCount--;
            peopleCount--;
            notifyAll();
        } else if (threadName.equals("Host")) {
            peopleCount--;
            notifyAll();
        }
    }
}



