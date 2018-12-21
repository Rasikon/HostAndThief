import java.util.ArrayList;
import java.util.List;

public class Thief extends Thread {
    private List<Item> backpackThief = new ArrayList<>();
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
        try {
            Apartment.host.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addBackpackThief();
        System.out.println(getBackpackThief());
    }

    private void addBackpackThief() {
        synchronized (Thief.class) {
            for(int i =0;i<10;i++) {
//                for (int i = Apartment.getApartmentList().size() - 1; i >= 0; i++) {
                        getBackpackThief().add(Apartment.getApartmentList().get(i));
                        Apartment.delList(Apartment.getApartmentList().get(i));
                        System.out.println(Thread.currentThread().getName() +
                                " забрал из комнаты " + Apartment.getApartmentList().get(i).getName() +
                                " стоимостью " + Apartment.getApartmentList().get(i).getPrice() +
                                " и весом " + Apartment.getApartmentList().get(i).getWeight());

//                }
            }
        }
    }

}

