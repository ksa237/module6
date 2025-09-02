public class Main {

    public static void main(String[] args) {

        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);

        //int c = calc.devide.apply(a, b);
        // здесь возникнет ошибка деления на ноль
        // возникает в классе Calculator в реализации ф. интерфейса
        // в объекте devide который реализует ф.интерфейс BinaryOperator
        // способ решения данной проблемы - учет в логике объекта devide
        // условия b<>0

        // вторая реализация метода, при передаче некорректного параметра №2
        // возвращает 0.
        int c = calc.devide2.apply(a, b);

        calc.println.accept(c);


    }

}
