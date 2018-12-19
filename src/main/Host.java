import java.util.List;

public class Host extends Thread {
    private Backpack backpackHost;

    public Host(String name,Backpack backpackHost){
        this.setName(name);
        this.backpackHost =backpackHost;
    }


    public List<Item> getBackpackList() {
        return backpackHost.getItems();
    }

    public void addItem(Item item){
        backpackHost.setItems(item);
    }

    @Override
    public void run() {
//            if (Apartment.isOpen()) {
//                Apartment.threadList.add("Host");
        while (!Apartment.Bool) {
            addApartmentList();
        }

    }
//        Apartment.threadList.remove("Host");
//    }

    private void addApartmentList() {
        int size = this.getBackpackList().size()-1;
            Apartment.apartmentList.add(this.getBackpackList().get(size));
            System.out.println(Thread.currentThread().getName() + " выложил в комнату " + this.getBackpackList().get(size).getName() +
                    " стоимостью " + this.getBackpackList().get(size).getPrice() + " и весом " + this.getBackpackList().get(size).getWeight());
            this.getBackpackList().remove(this.getBackpackList().get(size));


}
}
