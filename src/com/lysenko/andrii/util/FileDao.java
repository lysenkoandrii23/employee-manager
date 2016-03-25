package com.lysenko.andrii.util;

import com.lysenko.andrii.entity.Employee;

import java.io.*;
import java.util.ArrayList;

public class FileDao {
    private String fileName;

    public FileDao(String fileName) {
        this.fileName = fileName;
    }

    public void save(ArrayList<Employee> employees) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            for (Employee employee : employees) {
                fileWriter.write(EmployeeParser.encodeEmployee(employee));
                fileWriter.write(System.lineSeparator());
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(fileName + " error during writing");
        }
    }

    public ArrayList<Employee> load() {

        ArrayList<Employee> arrayList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);
            String str;
            while ((str = reader.readLine()) != null) {
                arrayList.add(EmployeeParser.parseEmployee(str));
            }
            reader.close();
            return arrayList;
        } catch (IOException e) {
            throw new RuntimeException(fileName + " error during reading");
        }
    }
}