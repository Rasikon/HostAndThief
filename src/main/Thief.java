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
            if (Apartment.isClose()) {
                Apartment.threadList.add("Thief");
                addBackpackThief();
            }
        Apartment.threadList.remove("Thief");
    }

    private void addBackpackThief() {
        synchronized (Thief.class) {
            for (int i = Apartment.apartmentList.size() - 1; i >= 0; i--) {
                addItem(Apartment.apartmentList.get(i));
//                System.out.println(Thread.currentThread().getName() + " забрал из комнаты " + this.getBackpackThief().get(i).getName() +
//                        " стоимостью " + this.getBackpackThief().get(i).getPrice() + " и весом " + this.getBackpackThief().get(i).getWeight());
                Apartment.apartmentList.remove(i);
            }
        }
    }
}
