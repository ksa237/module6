package ru.netology.module6;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Employee> list = parseXML("data.xml");
        String json = listToJson(list);
        writeString(json);

    }

    private static List<Employee> parseXML(String s) {

        List<Employee> listEmployees = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }

        Document doc = null;
        try {
            doc = builder.parse(new File(s));
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Node root = doc.getDocumentElement();
        NodeList rootNodes = root.getChildNodes();

        //цикл по employee
        for (int i = 0; i < rootNodes.getLength(); i++) {
            Node employeeNode = rootNodes.item(i);
            if (employeeNode.getParentNode() != root) {
                continue;
            }
            if (Node.ELEMENT_NODE != employeeNode.getNodeType()) {
                continue;
            }
            Element employeeElement = (Element) employeeNode;

            NodeList nlID = employeeElement.getElementsByTagName("id");
            Node itID = nlID.item(0);
            Element elID = (Element) itID;
            long idValue = Long.parseLong(elID.getTextContent());

            NodeList nlFirstName = employeeElement.getElementsByTagName("firstName");
            Node itFirstName = nlFirstName.item(0);
            Element elFirstName = (Element) itFirstName;
            String fnValue = elFirstName.getTextContent();

            NodeList nlLastName = employeeElement.getElementsByTagName("lastName");
            Node itLastName = nlLastName.item(0);
            Element elLastName = (Element) itLastName;
            String lnValue = elLastName.getTextContent();

            NodeList nlCountry = employeeElement.getElementsByTagName("country");
            Node itCountry = nlCountry.item(0);
            Element elCountry = (Element) itCountry;
            String countryValue = elCountry.getTextContent();

            NodeList nlAge = employeeElement.getElementsByTagName("age");
            Node itAge = nlAge.item(0);
            Element elAge = (Element) itAge;
            int ageValue = Integer.parseInt(elAge.getTextContent());

            Employee employee = new Employee(idValue, fnValue, lnValue, countryValue, ageValue);
            listEmployees.add(employee);

        }

        return listEmployees;

    }


    private static String listToJson(List<Employee> list) {

        Type listType = new TypeToken<List<Employee>>() {
        }.getType();

        GsonBuilder bilder = new GsonBuilder();
        bilder.setPrettyPrinting();
        Gson gson = bilder.create();
        return gson.toJson(list, listType);

    }

    private static void writeString(String json) {

        try (FileWriter file = new FileWriter("data.json")) {
            file.write(json);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

     }

}
