package com.lysenko.andrii.util;

import com.lysenko.andrii.entity.Developer;
import com.lysenko.andrii.entity.Employee;
import com.lysenko.andrii.entity.Manager;

public class EmployeeParser {
    private static final String MANAGER = "Manager";
    private static final String DEVELOPER = "Developer";

    static Employee parseEmployee(String str) {
        String [] array = str.split(":");
        if (array.length != 5) {
            throw new RuntimeException("Not parsed");
        } else {
            if (!MANAGER.equals(array[0]) && !DEVELOPER.equals(array[0])) {
                throw new RuntimeException("Not parsed");
            } else {
                try {
                    String role = array[0];
                    long id = Long.parseLong(array[1]);
                    int salary = Integer.parseInt(array[4]);
                    String firstName = array[2];
                    String lastName = array[3];
                    if (MANAGER.equals(role)) {
                        return new Manager(id, firstName, lastName, salary);
                    } else {
                        return new Developer(id, firstName, lastName, salary);
                    }
                } catch (NumberFormatException e){
                    throw new RuntimeException("Not parsed");
                }
            }
        }
    }

    static String encodeEmployee(Employee employee) {
        if (employee instanceof Developer) {
            return DEVELOPER + ":" + employee.getId() + ":" + employee.getFirstName()
                    + ":" + employee.getLastName() + ":" + employee.getSalary();
        } else if (employee instanceof Manager) {
            return MANAGER + ":" + employee.getId() + ":" + employee.getFirstName()
                    + ":" + employee.getLastName() + ":" + employee.getSalary();
        } else {
            throw new RuntimeException("Not Manager or Developer");
        }
    }
}