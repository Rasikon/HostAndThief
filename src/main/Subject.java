package main;

public class Subject {
    public String name;
    public int weight;
    public int price;

    public Subject(String name, int weight, int price) {
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
        return    " " + name + ' ' +
                " весом " + weight +
                "кг и ценой " + price +"р";

    }
}
