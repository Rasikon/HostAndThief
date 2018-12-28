import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class InitThread {
    private String[] nameItemList = {"Капуста", "Картофель", "Морковь", "Сосиска",
            "Спички", "Колбаса", "Стол", "Стул", "Холодильник", "Телевизор", "Тетрадь"};
    private int[] weightItemList = {10, 20, 15, 15, 45, 40, 10, 15, 40, 70, 50};
    private int[] priceItemList = {20, 15, 15, 40, 90, 20, 43, 15, 90, 80, 50};
    private int[] sizeBackpackList = {20, 40, 60, 100, 80, 40, 40, 70, 80, 10, 20, 90};
    private int[] itemCountList = {5, 5, 3, 8, 7, 9, 6, 5, 6, 2, 1, 4};
    private List<Host> hostList = new ArrayList<>();
    private List<Thief> thiefList = new ArrayList<>();
    private List<Thread> threadList = new ArrayList<>();
    private Random random = new Random();

    InitThread(int hostAmount, int thiefAmount) {
        hostInit(hostAmount);
        thiefInit(thiefAmount);
        startThread();
    }

    private void hostInit(int hostAmount) {
        for (int i = 0; i < hostAmount; i++) {
            int itemCount = itemCountList[random.nextInt(11)];
            hostList.add(new Host(i, new ArrayList<>()));
            for (int j = 0; j < itemCount; j++) {
                hostList.get(i).addItemBackpack(new Item(nameItemList[random.nextInt(11)],
                        weightItemList[random.nextInt(11)],
                        priceItemList[random.nextInt(11)]));
            }
        }
    }

    private void thiefInit(int thiefAmount) {
        for (int i = 0; i < thiefAmount; i++) {
            int max = sizeBackpackList[random.nextInt(11)];
            thiefList.add(new Thief(i, max));
        }
    }

    private void startThread() {
        threadList.addAll(hostList);
        threadList.addAll(thiefList);
        Collections.shuffle(threadList);
        for (Thread thread : threadList) {
            thread.start();
        }
    }
}



