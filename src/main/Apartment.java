import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Apartment {
    private static Apartment instance = new Apartment();
    public List<Host> hostList = new ArrayList<>();
    public List<Thief> thiefList = new ArrayList<>();
    public static List<String> threadList = new ArrayList<>();
    public static List<Item> apartmentList = Collections.synchronizedList(new ArrayList<>());
    public static boolean Bool;

    public static Apartment getInstance() {
        return instance;
    }


    private Apartment() {

    }


    public static boolean isOpen() {
        for (String string : threadList) {
            if(string.contains("Thief")){
                return false;
            }
        }
        return true;
    }

    public static boolean isClose() {
        for (String string : threadList) {
            if ((string.contains("Thief"))|| (string.contains("Host"))) {
                return false;
            }
        }
        return true;
    }

    public void hostInit(int host) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < host; i++) {
            System.out.println("Введите имя хозяина");
            String name = reader.readLine();
            System.out.println("Введите количество вещей");
            int allItems = Integer.parseInt(reader.readLine());
            hostList.add(new Host(name,new Backpack()));
            for (int j = 0; j < allItems; j++) {
                hostList.get(i).addItem(new Item(Main.nameItem[(int) (Math.random() * 11)], Main.weightItem[(int) (Math.random() * 11)], Main.priceItem[(int) (Math.random() * 11)]));
            }
        }
    }

    public void thiefInit(int thief) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < thief; i++) {
            System.out.println("Введите имя вора");
            String name = reader.readLine();
            thiefList.add(new Thief(name, Main.sizeBackpack[(int) (Math.random() * 9)]));
        }
    }

    public void startThread(){
        for(Host host:hostList) {
            host.start();
        }
        for(Thief thief:thiefList){
            thief.start();
        }

    }
}

