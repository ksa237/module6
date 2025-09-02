import java.beans.Introspector;
import java.util.function.*;

public class Calculator {

    static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> x / y;

    // в реализации devide2 добавлена проверка на 0, деление на который вызывает
    // ArithmeticException
    // приходится возвращать какое-то значение (int), так как это ф. интерфейс BinaryOperator
    // поэтому возвращаем 0, но исключаем ошибку.
    BinaryOperator<Integer> devide2 = (x, y) -> {
        if (y == 0) {
            return 0;
        }
        return x / y;
    };

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;

}
