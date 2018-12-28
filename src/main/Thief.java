import java.util.ArrayList;
import java.util.List;

public class Thief extends Thread {
    private List<Item> backpackThief;
    private final Apartment apartment = Apartment.getInstance();
    private int maxMass;

    Thief(int name, int maxMass) {
        this.setName(String.valueOf(name));
        this.maxMass = maxMass;
        backpackThief = new ArrayList<>();
    }

    @Override
    public void run() {
        apartment.doOpenApartment();
        addItemToBackpack();
        apartment.doCloseApartment();
    }

    private void addItemToBackpack() {
        if (apartment.getApartmentList().isEmpty()) {
            System.out.println("В комнате пусто");
        }
        apartment.getApartmentList().sort(new Item.CompByPrice());
        for (int i = apartment.getApartmentList().size() - 1; i >= 0; i--) {
            Item apartmentItem = apartment.getApartmentList().get(i);
            if (maxMass > apartmentItem.getWeight()) {
                maxMass = maxMass - apartmentItem.getWeight();
                backpackThief.add(apartmentItem);
                System.out.println(Thread.currentThread().getName() +
                        " забрал из комнаты " + apartmentItem.getName() +
                        " стоимостью " + apartmentItem.getPrice() +
                        " и весом " + apartmentItem.getWeight());
                apartment.delItemApartment(apartmentItem);
            }
        }
    }
}






