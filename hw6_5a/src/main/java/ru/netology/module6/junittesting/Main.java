package ru.netology.module6.junittesting;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    final static String PATH_SG = "/home/sa/Games/savegames";

    public static void main(String[] args) {

        ArrayList<String> listSaves = new ArrayList<>();

        GameProgress save1 = new GameProgress(94, 10, 2, 254.32);
        saveGame(PATH_SG + "/save1.dat", save1);
        listSaves.add(PATH_SG + "/save1.dat");

        GameProgress save2 = new GameProgress(87, 12, 5, 298.88);
        saveGame(PATH_SG + "/save2.dat", save2);
        listSaves.add(PATH_SG + "/save2.dat");

        GameProgress save3 = new GameProgress(54, 21, 10, 1236.72);
        saveGame(PATH_SG + "/save3.dat", save3);
        listSaves.add(PATH_SG + "/save3.dat");

        zipFiles(PATH_SG + "/saves.zip", listSaves);

        Iterator<String> iterator = listSaves.iterator();
        while (iterator.hasNext()) {
            String nameToDelete = iterator.next();
            File fToFelete = new File(nameToDelete);
            fToFelete.delete();
        }
    }


    static void saveGame(String path, GameProgress gs) {

        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(gs);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }

    static void zipFiles(String pathZip, ArrayList<String> filesToZip) {


        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(pathZip))) {

            Iterator<String> iterator = filesToZip.iterator();

            while (iterator.hasNext()) {
                String fToZipName = iterator.next();

                FileInputStream fis = new FileInputStream(fToZipName);
                ZipEntry entry = new ZipEntry(fToZipName);
                zout.putNextEntry(entry);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zout.write(buffer);
                zout.closeEntry();
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }


    }

}


