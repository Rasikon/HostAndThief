import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите количество хозяев");
        int hostAmount = Integer.parseInt(reader.readLine());
        System.out.println("Введите количество воров");
        int thiefAmount = Integer.parseInt(reader.readLine());
        new InitThread(hostAmount, thiefAmount);

    }
}

