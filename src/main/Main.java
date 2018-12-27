import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
