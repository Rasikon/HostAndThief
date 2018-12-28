import java.util.LinkedList;
import java.util.List;

abstract class Person extends Thread {
    List<Item> backpack;
    int maxMass;
    final Apartment apartment = Apartment.getInstance();

    public Person(String name) {
        setName(name);
        this.backpack = new LinkedList<>();
    }

    public Person(String name, int maxMass) {
        setName(name);
        this.maxMass = maxMass;
        this.backpack = new LinkedList<>();
    }

    void addItemBackpack(Item item) {
        backpack.add(item);
    }

}
