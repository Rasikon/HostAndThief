import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Apartment {
    private static List<Item> apartmentList = Collections.synchronizedList(new ArrayList<>());
    public static CountDownLatch host;

    public static List<Item> getApartmentList() {
        return apartmentList;
    }

    public static void addList(Item item) {
        apartmentList.add(item);
    }

    public static void delList(Item item) {
        apartmentList.remove(item);
    }


}



