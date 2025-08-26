import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {


        /*ISum summer = new ISum() {
            @Override
            public int sum(int a, int b) {
                return a+b;
            }
        };

        System.out.println(summer.sum(3,2));
        */


        //++ лямбда-выражения
        // развернутое использование ф. интерфейса Predicate<T>
        /*Predicate<Integer> isPositive1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x > 0;
            }
        };*/
        //--

        // сокращенное использование через лямбда-выражение
        //Predicate<Integer> isPositive2 = x -> x > 0;
        // isPositive2 - переменная типа ф.интерфейс
        // x - параметр лямбда выражения
        // x > 0 -тело лямбда выражения, по сути заменяет единственную функцию, которая возвращает x>0
        // по сути isPositive2 принимает в качестве значения лямбда выражение "x -> x > 0"
        //System.out.println(isPositive2.test(5));
        //System.out.println(isPositive2.test(-2));

        OnDoneListener listener = (v) -> System.out.println(v);
        Test test = new Test(listener);
        test.execute();

    }
}

@FunctionalInterface
interface ISum{

    int sum(int a, int b);

}

@FunctionalInterface
interface OnDoneListener<T>{
    void onDone(T v);
}

