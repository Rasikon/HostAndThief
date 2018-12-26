import java.util.Comparator;

public class Item {
    private String name;
    private int weight;
    private int price;

    public Item(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }

//    @Override
//    public int compareTo(Item o) {
//        return (this.getPrice()-o.getPrice());
//    }

    public static class CompByPrice implements Comparator<Item>{

        @Override
        public int compare(Item o1, Item o2) {
            int i = o1.getPrice() - o2.getPrice();
            int b = o2.getWeight() - o1.getWeight();
            if(i==0) {
                if(b==0) {
                    return o2.getName().compareTo(o1.getName());
                } else {
                    return b;
                }
            }
            return i;
        }
    }

}
