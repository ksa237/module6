package ru.netology.module6;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
    static String fileName = "data.csv";

    public static void main(String[] args) {

        List<Employee> list = parseCSV(columnMapping, fileName);
        String json = listToJson(list);
        writeString(json);

    }

    private static void writeString(String json) {

        try (FileWriter file = new FileWriter("data.json")) {
            file.write(json);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String listToJson(List<Employee> list) {

        Type listType = new TypeToken<List<Employee>>() {
        }.getType();

        GsonBuilder bilder = new GsonBuilder();
        bilder.setPrettyPrinting();
        Gson gson = bilder.create();
        return gson.toJson(list, listType);

    }

    private static List<Employee> parseCSV(String[] columnMapping, String fileName) {

        List<Employee> emptyList = new ArrayList<Employee>();

        //настройка стратегии
        ColumnPositionMappingStrategy<Employee> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Employee.class);
        strategy.setColumnMapping("id", "firstName", "lastName", "country", "age");

        // чтение из файла и преобразоввание к "объекту" - bean, к списку объектов Employee
        try (CSVReader reader = new CSVReader(new FileReader("data.csv"))) {

            CsvToBean<Employee> csv = new CsvToBeanBuilder<Employee>(reader)
                    .withMappingStrategy(strategy)
                    .build();

            List<Employee> staff = csv.parse();
            return staff;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return emptyList;

    }

}
