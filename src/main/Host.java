import java.util.List;

public class Host extends Thread {
    private List<Item> backpackHost;

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
        synchronized (this) {
            while (!Apartment.doOpenHost()) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Apartment.incHost();
            addApartmentList();
        }
        Apartment.doClose();
        synchronized (Thief.class){
            Thief.class.notifyAll();
        }
    }

    private void addApartmentList() {
        while (!(getBackpackHost().isEmpty())) {
            for (int i = getBackpackHost().size() - 1; i >= 0; i--) {
                Apartment.addList(getBackpackHost().get(i));
                System.out.println(Thread.currentThread().getName() +
                        " выложил в комнату " + getBackpackHost().get(i).getName() +
                        " стоимостью " + getBackpackHost().get(i).getPrice() +
                        " и весом " + getBackpackHost().get(i).getWeight());
                getBackpackHost().remove(getBackpackHost().get(i));
            }
        }

    }

//    public void thiefJob(){
//        synchronized (Apartment.apartament){
//            Apartment.Bool = true;
//            Apartment.apartament.notify();
//        }
//    }

    }



