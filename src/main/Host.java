import java.util.List;

public class Host extends Thread {
    private Backpack backpackHost;

    public Host(String name, Backpack backpackHost) {
        this.setName(name);
        this.backpackHost = backpackHost;
    }


    public List<Item> getBackpackList() {
        return backpackHost.getItems();
    }

    public void addItem(Item item) {
        backpackHost.setItems(item);
    }

    @Override
    public void run() {
        notifyJob();
        addApartmentList();

    }

    private synchronized void addApartmentList() {
        for (int i = this.getBackpackList().size() - 1; i >= 0; i--) {
            Apartment.apartmentList.add(this.getBackpackList().get(i));
            System.out.println(Thread.currentThread().getName() + " выложил в комнату " + this.getBackpackList().get(i).getName() +
                    " стоимостью " + this.getBackpackList().get(i).getPrice() + " и весом " + this.getBackpackList().get(i).getWeight());
            this.getBackpackList().remove(this.getBackpackList().get(i));
        }

    }

    public synchronized void notifyJob() {
        Apartment.joy = true;
        notify();
    }
}

