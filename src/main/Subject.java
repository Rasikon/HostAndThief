package main;

public class Subject {
    private String name;
    int weight;
    int price;

    Subject(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    String getName() {
        return name;
    }

    int getWeight() {
        return weight;
    }

    int getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return " " + name + ' ' +
                " весом " + weight +
                "кг и ценой " + price + "р";

    }
}
