public class InitClass {

    public static Host hostInit(String name) {
        Host host = new Host(name);
        return host;
    }

    public static Thief thiefInit(String name, int maxMass) {
        Thief thief = new Thief(name, maxMass);
        return thief;
    }

    public static Item initItem(String name, int weight, int price) {
        return new Item(name, weight, price);
    }


}
