import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Мадрид", "Париж", "Москва", "Tокио");

        Collections.sort(cities, (a,  b) -> b.compareTo(a));

//        for(String s:cities){
//            System.out.println(s);
//        }

        //cities.forEach(System.out::println);
        cities.forEach(city -> System.out.println(city));

    }

}
