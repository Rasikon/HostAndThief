import java.util.LinkedList;

public class Host extends Person implements HostInterface {

    Host(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (backpack.size() != 0) {
            apartment.doOpenApartment();
            addItemToApartment();
            apartment.doCloseApartment();
        }
    }

    public void addItemToApartment() {
        Item backpackItem = ((LinkedList<Item>) backpack).getLast();
        apartment.addItemApartment(backpackItem);
        System.out.println(Thread.currentThread().getName() +
                " выложил в комнату " + backpackItem.getName() +
                " стоимостью " + backpackItem.getPrice() +
                " и весом " + backpackItem.getWeight());
        backpack.remove(backpackItem);
    }
}



