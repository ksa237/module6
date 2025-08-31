import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {


    public static void main(String[] args) {

        /*
        //1. StreamAPI //3:06
        long count = IntStream.of(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5)
                .filter(w -> w >= 0)
                .count();
        System.out.println(count);
        ///////////////////////////////////////
        */

        /*
        //1. StreamAPI //4:36
        int[] input = {50, 60, 70, 80, 90, 100};
        List<Integer> result = Arrays.stream(input)
                .filter(x-> x < 90)
                        .map(x-> x+=10)
                                .limit(3)
                                        .boxed()
                .collect(Collectors.toList());


//        int count = 0;
//        for (int x : input) {
//            if (x >= 90) continue;
//            x += 10;
//            count++;
//
//            if (count > 3) break;
//            result.add(x);
//        }
        System.out.println(result);
        */

        //2.промежуточные операции //2:04
        /*List<String> list = Arrays.asList("Moscow","NY","Tokio");
        list.stream()
                .filter(value -> value.length() >=3)
                .filter(value -> value.contains("M"))
                .forEach(System.out::println);

         */

        /*
        //2:25
        List<String> list = Arrays.asList("Moscow","NY","Tokio");
        list.stream()
                .map(String::toUpperCase)
                .map(value -> value + " <3")
                .forEach(System.out::println);

         */

        /*
        //2:55
        List<String> list = new ArrayList<>();
        list.add("И долго буду тем любезен я народу");
        list.add("Что чуства добрые я лирой пробуждал");
        list.add("Что в мой жестокий век восславил я Свободу");
        list.add("И милость к падшим призывал");
        */


        /*long count = list.stream()
                .flatMap(value -> Arrays.stream(value.split(" ")))
                .count();
        System.out.println(count);
        */

        /*
        // вариант
        // здесь соединенный стрим возвращается как list
        list = list.stream()
                .flatMap(value -> Arrays.stream(value.split(" ")))
                .collect(Collectors.toList());
        System.out.println(list);
        */

        /*
        //3:18 .distinct
        List<String> list = Arrays.asList("one","two","three","one","two");
        list = list.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(list);
        */

        /*
        //3:52 .limit
        List<String> list = Arrays.asList("one","two","three","one","two");

        list = list.stream()
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(list);
        */

        // 3. Терминальные операции
        // 1:19

        List<String> list = Arrays.asList("one","two","three");

        boolean anyMatch = list.stream()
                .anyMatch(value -> value.startsWith("o"));
        System.out.println(anyMatch);



    }
}



