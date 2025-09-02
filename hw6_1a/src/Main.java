import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {

        //>>> вариант из задачи: ссылка но на экз. общего класса библиотеки
        // а этот метод все также принимает входной параметр типа String
        //# public void println(String x)
        //#  if (getClass() == PrintStream.class) {
        //#     writeln(String.valueOf(x));
        //#  } else {
        //#    synchronized (this) {
        //#        print(x);
        //#        newLine();
        //#    }
        //#  }
        //# }
        // значит идет в метод и выполняет его как обычно
        // печатает String x
        OnTaskDoneListener listener = System.out::println;

        //>>> вариант: ссылка на метод экз. объекта
        // ссылка создается 1 раз, а потом 100 раз
        // вызывается метод по ссылке
        //
        //Main m = new Main();
        //OnTaskDoneListener listener = m::onDoneFromMain;
        //<<<

        //>>> вариант: реализация метода ф.интерфейса OnTaskDoneListener
        // в лямбда-выражении. Поэтому в этот код заходит 100 раз.
        //OnTaskDoneListener listener = (String str) -> {
        //    System.out.println(str);
        //};

        Worker woker = new Worker(listener);
        woker.start();


    }

    //>>> вариант: ссылка на метод экз. объекта. продолжение.
    //public void onDoneFromMain(String str) {
    //    System.out.println(str);
    //}
    //<<<

}
