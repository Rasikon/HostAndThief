import java.util.List;

public class Host extends Thread {
    private List<Item> backpackHost;
    private final Apartment apartment = Apartment.getInstance();

    Host(int name, List<Item> backpackHost) {
        this.setName(String.valueOf(name));
        this.backpackHost = backpackHost;
    }

    void addItemBackpack(Item item) {
        backpackHost.add(item);
    }

    @Override
    public void run() {
        while (backpackHost.size() != 0) {
            apartment.doOpenApartment();
            addItemToApartment();
            apartment.doCloseApartment();
        }
    }

    private void addItemToApartment() {
        Item backpackItem = backpackHost.get(backpackHost.size() - 1);
        apartment.addItemApartment(backpackItem);
        System.out.println(Thread.currentThread().getName() +
                " выложил в комнату " + backpackItem.getName() +
                " стоимостью " + backpackItem.getPrice() +
                " и весом " + backpackItem.getWeight());
        backpackHost.remove(backpackItem);
    }
}



