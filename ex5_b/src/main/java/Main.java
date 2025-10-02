public class Main {


    public static void main(String[] args) {



    }



    public String concat(String str) {
        int otherLen = str.length();
        if (otherLen == 0) {
            return this;
        }
        int len = value.length;
        char buf[] = Arrays.copyOf(value, len +
                otherLen); str.getChars(buf, len);
        return new String(buf, true);
    }

    

}
