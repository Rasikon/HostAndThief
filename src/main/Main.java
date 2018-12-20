import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[] nameItem = {"Капуста", "Картофель", "Морковь", "Сосиска", "Спички", "Колбаса", "Стол", "Стул", "Холодильник", "Телевизор", "Тетрадь"};
    static int[] weightItem = {10, 20, 15, 15, 45, 40, 10, 15, 40, 70, 50};
    static int[] priceItem = {20, 15, 15, 40, 90, 20, 43, 15, 90, 80, 50};
    static int[] sizeBackpack = {40, 60, 90, 100, 10, 30, 50, 20, 15};

    public static void main(String[] args) throws InterruptedException, IOException {
        Apartment apartment = Apartment.getInstance();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите количество хозяев");
        apartment.hostInit(Integer.parseInt(reader.readLine()));
        System.out.println("Введите количество воров");
        apartment.thiefInit(Integer.parseInt(reader.readLine()));
        apartment.startThread();


    }
}
