import java.util.List;

public class Host extends Thread {
    private List<Item> backpackHost;
    private final Apartment apartment =Apartment.getInstance();

    public Host(int name, List<Item> backpackHost) {
        this.setName(String.valueOf(name));
        this.backpackHost = backpackHost;
    }

    public List<Item> getBackpackHost() {
        return backpackHost;
    }

    public void addItem(Item item) {
        backpackHost.add(item);
    }

    @Override
    public void run() {
        while (getBackpackHost().size() != 0) {
            apartment.doOpenHost();
            addApartmentList();
            apartment.doClose();
        }
    }

    private void addApartmentList() {
            apartment.addList(getBackpackHost().get(getBackpackHost().size() - 1));
            System.out.println(Thread.currentThread().getName() +
                    " выложил в комнату " + getBackpackHost().get(getBackpackHost().size() - 1).getName() +
                    " стоимостью " + getBackpackHost().get(getBackpackHost().size() - 1).getPrice() +
                    " и весом " + getBackpackHost().get(getBackpackHost().size() - 1).getWeight());
            getBackpackHost().remove(getBackpackHost().get(getBackpackHost().size() - 1));
    }


}



