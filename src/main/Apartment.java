import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Apartment {
    private static Apartment instance = new Apartment();
    private List<Host> hostList = new ArrayList<>();
    private List<Thief> thiefList = new ArrayList<>();
    static List<Item> apartmentList = Collections.synchronizedList(new ArrayList<>());
    static List<String> threadList = Collections.synchronizedList(new ArrayList<>());
    static boolean joy = false;
    static Apartment getInstance() {
        return instance;
    }


    private Apartment() {

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
            System.out.println("Введите максимальный вес рюкзака");
            int max = Integer.parseInt(reader.readLine());
            thiefList.add(new Thief(name,max));
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



