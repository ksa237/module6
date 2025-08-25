public class Main {

    public static void main(String[] args) {


        ISum summer = new ISum() {
            @Override
            public int sum(int a, int b) {
                return a+b;
            }
        };

        System.out.println(summer.sum(3,2));
    }
}

@FunctionalInterface
interface ISum{

    int sum(int a, int b);

}

