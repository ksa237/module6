import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        //File file = new File(".", "readme.txt");
        //file.createNewFile();

        /*
        // запись потока байтов в файл
        String text = "Hello world!\n";

        try(FileOutputStream fos = new FileOutputStream("notes.txt")){
            byte[] bytes = text.getBytes();
            fos.write(bytes);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        //чтение потока байтов из файла
        try (FileInputStream fin = new FileInputStream("notes.txt")) {
            int i;
            while ((i=fin.read()) !=-1){
                System.out.print((char) i);
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        */

        String text = "Hello world!";
        byte[] buffer = text.getBytes();

        try(ByteArrayInputStream in = new ByteArrayInputStream(buffer);
        BufferedInputStream bis = new BufferedInputStream(in)) {
            int c;

            while ((c=bis.read()) != -1){
                System.out.print((char) c);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    }

}
