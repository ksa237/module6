import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) {

//        GameProgress gameProgress =
//                new GameProgress(94, 10, 2, 254.32);
//
//        try (FileOutputStream fos = new FileOutputStream("save.dat");
//             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//
//            oos.writeObject(gameProgress);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//
//        }

        GameProgress gameProgress = null;

        try(FileInputStream fis = new FileInputStream("save.dat");
            ObjectInputStream ois =new ObjectInputStream(fis)){
            gameProgress = (GameProgress)  ois.readObject();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(gameProgress);



    }

}
