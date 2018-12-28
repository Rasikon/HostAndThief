public class Thief extends Person implements ThiefInterface {

    Thief(String name, int maxMass) {
        super(name, maxMass);
    }

    @Override
    public void run() {
        apartment.doOpenApartment();
        addItemToBackpack();
        apartment.doCloseApartment();
    }

    public void addItemToBackpack() {
        if (apartment.getApartmentList().isEmpty()) {
            System.out.println("В комнате пусто");
        }
        apartment.getApartmentList().sort(new Item.CompByPrice());
        for (int i = apartment.getApartmentList().size() - 1; i >= 0; i--) {
            Item apartmentItem = apartment.getApartmentList().get(i);
            if (maxMass > apartmentItem.getWeight()) {
                maxMass = maxMass - apartmentItem.getWeight();
                addItemBackpack(apartmentItem);
                System.out.println(Thread.currentThread().getName() +
                        " забрал из комнаты " + apartmentItem.getName() +
                        " стоимостью " + apartmentItem.getPrice() +
                        " и весом " + apartmentItem.getWeight());
                apartment.delItemApartment(apartmentItem);
            }
        }
    }

}






