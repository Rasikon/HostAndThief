import java.util.List;

public class Thief extends Thread {
    private Backpack backpackThief;
    private int maxMass;
    private String name;

    public Thief(String name, int maxMass) {
        this.setName(name);
        this.maxMass = maxMass;
        this.backpackThief = new Backpack();
    }

    public List<Item> getBackpackThief() {
        return backpackThief.getItems();
    }

    public void addItem(Item item) {
        backpackThief.setItems(item);
    }

    public void deleteItem(Item item) {
        backpackThief.getItems().remove(item);
    }

    public int getMaxMass() {
        return maxMass;
    }

    public void setMaxMass(int maxMass) {
        this.maxMass = maxMass;
    }

    @Override
    public void run() {
            while (Apartment.apartmentList.size()>0 && !Apartment.Bool) {
//                Apartment.threadList.add("Thief");
                addBackpackThief();
            }
//        Apartment.threadList.remove("Thief");
    }

    private synchronized void addBackpackThief() {
             int size = Apartment.apartmentList.size() - 1;
                addItem(Apartment.apartmentList.get(size));
                System.out.println(Thread.currentThread().getName() + " забрал из комнаты " + Apartment.apartmentList.get(size).getName() +
                        " стоимостью " + Apartment.apartmentList.get(size).getPrice() + " и весом " + Apartment.apartmentList.get(size).getWeight());
                Apartment.apartmentList.remove(size);
//            System.out.println(getBackpackThief());
        }

    }
