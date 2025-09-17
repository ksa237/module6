import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        final String HOME_DIR = "/home/sa/Games";
        StringBuilder log = new StringBuilder();

        //src, res, savegames
        File dirSrc = new File(HOME_DIR + "/src");
        File dirRes = new File(HOME_DIR + "/res");
        File dirSavegames = new File(HOME_DIR + "/savegames");
        File dirTemp = new File(HOME_DIR + "/temp");

        boolean isExist1 = dirSrc.exists();
        boolean result1 = dirSrc.mkdir();
        writeLog(dirSrc, isExist1, result1, log);

        boolean isExist2 = dirRes.exists();
        boolean result2 = dirRes.mkdir();
        writeLog(dirRes, isExist2, result2, log);

        boolean isExist3 = dirSavegames.exists();
        boolean result3 = dirSavegames.mkdir();
        writeLog(dirSavegames, isExist3, result3, log);

        boolean isExist4 = dirTemp.exists();
        boolean result4 = dirTemp.mkdir();
        writeLog(dirTemp, isExist4, result4, log);

        //main, test
        File dirMain = new File(dirSrc.getAbsolutePath() + "/main");
        File dirTest = new File(dirSrc.getAbsolutePath() + "/test");

        boolean isExist8 = dirMain.exists();
        boolean result8 = dirMain.mkdir();
        writeLog(dirMain, isExist8, result8, log);

        boolean isExist9 = dirTest.exists();
        boolean result9 = dirTest.mkdir();
        writeLog(dirTest, isExist9, result9, log);

        File mainJava = new File(dirMain, "Main.java");
        File utilsJava = new File(dirMain, "Utils.java");

        boolean isCreated1 = false;
        boolean isExist10 = mainJava.exists();
        try {
            isCreated1 = mainJava.createNewFile();
        } catch (IOException e) {
            String addition = e.getMessage();
            writeLog(mainJava, isExist10, isCreated1, log, addition);
            throw new RuntimeException(e);
        }
        writeLog(mainJava, isExist10, isCreated1, log);

        boolean isCreated2 = false;
        boolean isExist11 = utilsJava.exists();
        try {
            isCreated2 = utilsJava.createNewFile();
        } catch (IOException e) {
            String addition = e.getMessage();
            writeLog(utilsJava, isExist11, isCreated2, log, addition);
            throw new RuntimeException(e);
        }
        writeLog(utilsJava, isExist11, isCreated2, log);

        //drawables, vectors, icons
        File dirDrawables = new File(dirRes.getAbsolutePath() + "/drawables");
        File dirVectors = new File(dirRes.getAbsolutePath() + "/vectors");
        File dirIcons = new File(dirRes.getAbsolutePath() + "/icons");

        boolean isExist12 = dirDrawables.exists();
        boolean result5 = dirDrawables.mkdir();
        writeLog(dirDrawables, isExist12, result5, log);

        boolean isExist13 = dirVectors.exists();
        boolean result6 = dirVectors.mkdir();
        writeLog(dirVectors, isExist13, result6, log);

        boolean isExist14 = dirIcons.exists();
        boolean result7 = dirIcons.mkdir();
        writeLog(dirIcons, isExist14, result7, log);


        File tempTxt = new File(dirTemp, "temp.txt");
        boolean isExist15 = tempTxt.exists();
        boolean isCreated3 = false;
        try {
            isCreated3 = tempTxt.createNewFile();
        } catch (IOException e) {
            String addition = e.getMessage();
            writeLog(tempTxt, isExist15, isCreated3, log, addition);
            throw new RuntimeException(e);
        }
        if(!(isExist15)) {
            writeLog(tempTxt, isExist15, isCreated3, log);
        } else {
            String addition = "Файл перезаписан.";
            writeLog(tempTxt, isExist15, isCreated3, log, addition);
        }


        try {
            FileWriter writer = new FileWriter(tempTxt.getAbsoluteFile(), false);
            writer.write(log.toString());
            writer.close();
        } catch (IOException e) {
            String addition = e.getMessage();
            writeLog(tempTxt, true,true, log, addition);
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }

    }

    static void writeLog(File ff, boolean ffExists, boolean result, StringBuilder sbLog) {
        writeLog(ff, ffExists, result, sbLog, null);
    }

    static void writeLog(File ff, boolean ffExists, boolean result, StringBuilder sbLog, String addMessage) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        sbLog.append(currentDateTime);
        sbLog.append(System.lineSeparator());
        if (result) {
            sbLog.append("Успешно записан объект файловой системы: ");
        } else {
            sbLog.append("Отказ записи объекта файловой системы, возможно объект уже существует: ");
        }
        sbLog.append(ff.getAbsolutePath());
        sbLog.append(" ");
        if (addMessage != null) {
            sbLog.append(addMessage);
            sbLog.append(System.lineSeparator());
        }
        if(ffExists){
            sbLog.append("доп. инфо: Уже существует.");
            sbLog.append(System.lineSeparator());
        }
        sbLog.append(System.lineSeparator());
        sbLog.append(System.lineSeparator());
    }

}
