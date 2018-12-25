import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class InitThread {
    private static String[] nameItem = {"Капуста", "Картофель", "Морковь", "Сосиска",
            "Спички", "Колбаса", "Стол", "Стул", "Холодильник", "Телевизор", "Тетрадь"};
    private static int[] weightItem = {10, 20, 15, 15, 45, 40, 10, 15, 40, 70, 50};
    private static int[] priceItem = {20, 15, 15, 40, 90, 20, 43, 15, 90, 80, 50};
    private static int[] sizeBackpack = {5, 3, 6, 1, 8, 4, 4, 7, 8, 1, 2, 9};
    private static int[] numItem = {5, 5, 3, 8, 7, 9, 6, 5, 6, 2, 1, 4};
    private static List<Host> hostList = new ArrayList<>();
    private static List<Thief> thiefList = new ArrayList<>();


    public static void hostInit(int host) {
        for (int i = 0; i < host; i++) {
            int allItems = InitThread.numItem[(int) (Math.random() * 11)];
            hostList.add(new Host(i, new ArrayList<>()));
            for (int j = 0; j < allItems; j++) {
                hostList.get(i).addItem(new Item(InitThread.nameItem[(int) (Math.random() * 11)],
                        InitThread.weightItem[(int) (Math.random() * 11)],
                        InitThread.priceItem[(int) (Math.random() * 11)]));
            }
        }
    }

    public static void thiefInit(int thief) {
        for (int i = 0; i < thief; i++) {
            int max = InitThread.sizeBackpack[(int) (Math.random() * 11)];
            thiefList.add(new Thief(i, max));
        }
    }

    public static void startThread() {
        for (Host host : hostList) {
            host.start();
        }
        for (Thief thief : thiefList) {
            thief.start();
        }
    }
}
