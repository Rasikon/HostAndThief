import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите количество хозяев");
        InitThread.hostInit(Integer.parseInt(reader.readLine()));
        System.out.println("Введите количество воров");
        InitThread.thiefInit(Integer.parseInt(reader.readLine()));
        InitThread.startThread();

    }
}
