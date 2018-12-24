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
        synchronized (Thief.class) {
            while (!Apartment.doOpenThief()) {
                try {
                    Thief.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Apartment.incThief();
            addBackpackThief();
        }
        Apartment.doClose();
        synchronized (Host.class){
            Host.class.notifyAll();
        }
    }



    private synchronized void addBackpackThief() {
        int mas = maxMass;
        synchronized (Thief.class) {
            for (int i = Apartment.getApartmentList().size() - 1; i >= 0; i--) {
                if (mas > 0) {
                    getBackpackThief().add(Apartment.getApartmentList().get(i));
                    System.out.println(Thread.currentThread().getName() +
                            " забрал из комнаты " + Apartment.getApartmentList().get(i).getName() +
                            " стоимостью " + Apartment.getApartmentList().get(i).getPrice() +
                            " и весом " + Apartment.getApartmentList().get(i).getWeight());
                    Apartment.delList(Apartment.getApartmentList().get(i));
                }
                mas--;
            }

        }
    }
}




