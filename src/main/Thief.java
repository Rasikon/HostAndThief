import java.util.ArrayList;
import java.util.List;

public class Thief extends Thread {
    private Backpack backpackThief;
    private int maxMass;
    private int bestPrice;
    private List<Item> bestItem = new ArrayList<>();

    public Thief(String name, int maxMass) {
        this.setName(name);
        this.maxMass = maxMass;
        this.backpackThief = new Backpack();
    }

    public List<Item> getBackpackThief() {
        return backpackThief.getItems();
    }


    @Override
    public void run() {
        addBackpackThief();
        System.out.println(getBackpackThief());
    }

    private synchronized void addBackpackThief() {
        while (!Apartment.joy) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (Thief.class) {
            for (int i = 0; i < Apartment.apartmentList.size() - 1; i++) {
                if (Apartment.apartmentList.get(i).getWeight() > 20) {
                    getBackpackThief().add(Apartment.apartmentList.get(i));
                    System.out.println(Thread.currentThread().getName() + " забрал из комнаты " + Apartment.apartmentList.get(i).getName() +
                            " стоимостью " + Apartment.apartmentList.get(i).getPrice() + " и весом " + Apartment.apartmentList.get(i).getWeight());
                    Apartment.apartmentList.remove(Apartment.apartmentList.get(i));
                }
            }
        }
    }


}

//    private void checkSet(List<Item> items) {
//        int sumM = 0;
//        int sumP = 0;
//        for(Item item:items){
//            sumM += item.getWeight();
//            sumP += item.getPrice();
//        }
//        if (backpackThief == null) {
//            if (sumM <= maxMass) {
//                getBackpackThief().addAll(items);
//                bestPrice = sumP;
//            }
//        } else {
//            if (sumM <= maxMass && sumP > bestPrice) {
//                getBackpackThief().addAll(items);
//                bestPrice = sumP;
//            }
//        }
//    }

//     private synchronized  void  bustAllSet(List<Item> items) {
//        if(items.size()>0){
//            checkSet(items);
//        }
//        for(int i=0;i<items.size();i++){
//            List<Item> newItem = new ArrayList<>(items);
//            newItem.remove(i);
//            bustAllSet(newItem);
//        }
//    }


