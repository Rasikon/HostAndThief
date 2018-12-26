import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Thief extends Thread {
    private List<Item> backpackThief = new ArrayList<>();
    private final Apartment apartment =Apartment.getInstance();
    private int maxMass;

    public Thief(int name, int maxMass) {
        this.setName(String.valueOf(name));
        this.maxMass = maxMass;
    }

    public List<Item> getBackpackThief() {
        return backpackThief;
    }

    @Override
    public void run() {
            apartment.doOpenThief();
            addBackpackThief();
            apartment.doClose();
    }



    private synchronized void addBackpackThief() {
        if(apartment.getApartmentList().isEmpty()){
            System.out.println("В комнате пусто");
        }
        Collections.sort(apartment.getApartmentList(),new Item.CompByPrice());
            for (int i = apartment.getApartmentList().size() - 1; i >= 0; i--) {
                if(maxMass>apartment.getApartmentList().get(i).getWeight()) {
                    maxMass = maxMass-apartment.getApartmentList().get(i).getWeight();
                    getBackpackThief().add(apartment.getApartmentList().get(i));
                    System.out.println(Thread.currentThread().getName() +
                            " забрал из комнаты " + apartment.getApartmentList().get(i).getName() +
                            " стоимостью " + apartment.getApartmentList().get(i).getPrice() +
                            " и весом " + apartment.getApartmentList().get(i).getWeight());
                    apartment.delList(apartment.getApartmentList().get(i));
                }else System.out.println("Вещь не помещается");
            }
        }
}






