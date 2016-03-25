package com.lysenko.andrii.test;

import com.lysenko.andrii.app.EmployeeManager;
import com.lysenko.andrii.entity.Developer;
import com.lysenko.andrii.entity.Employee;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        try {
            ArrayList<Employee> arrayList;
            EmployeeManager employeeManager = new EmployeeManager("c:\\temp\\employees.txt");
            System.out.println("-------------load from file-----------------------");
            employeeManager.load();
            for (Employee employee : employeeManager.getEmployees()) {
                System.out.println(employee);
            }
            System.out.println("-------------sortFirstName-------------------------");
            arrayList = employeeManager.sortFirstName();
            for (Employee employee : arrayList) {
                System.out.println(employee);
            }
            System.out.println("-------------sortFirstLastName----------------------");
            arrayList = employeeManager.sortFirstLastName();
            for (Employee employee : arrayList) {
                System.out.println(employee);
            }
            System.out.println("-------------add employee---------------------------");
            employeeManager.add(new Developer(1, "Andrii", "Lysenko", 2000));
            for (Employee employee : employeeManager.getEmployees()) {
                System.out.println(employee);
            }
            System.out.println("-------------remove employee------------------------");
            employeeManager.remove(new Developer(3, "Kolia", "Trubin", 10000));
            for (Employee employee : employeeManager.getEmployees()) {
                System.out.println(employee);
            }
            System.out.println("-------------edit employee--------------------------");
            employeeManager.edit(new Developer(1, "Andrii", "Lysenko", 3000));
            for (Employee employee : employeeManager.getEmployees()) {
                System.out.println(employee);
            }
            System.out.println("-------------find employee-------------------------");
            arrayList = employeeManager.find("Andrii", "Lysenko");
            for (Employee employee : arrayList) {
                System.out.println(employee);
            }

            //employeeManager.save();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
