package com.lysenko.andrii.app;

import com.lysenko.andrii.entity.Employee;
import com.lysenko.andrii.util.FileDao;

import java.util.ArrayList;
import java.util.Collections;

public class EmployeeManager {
    private ArrayList<Employee> employees;
    private FileDao fileDao;

    public EmployeeManager(String fileName) {
        this.fileDao = new FileDao(fileName);
        this.employees = new ArrayList<>();
    }

    public ArrayList<Employee> sortFirstName() {
        ArrayList<Employee> result = new ArrayList<>(employees);
        Collections.sort(result);
        return result;
    }

    public ArrayList<Employee> sortFirstLastName() {
        ArrayList<Employee> result = new ArrayList<>(employees);
        Employee employee;
        for (int n = (result.size() - 1); n > 0; n--) {
            int indexMax = 0;
            for (int j = 1; j <= n; j++) {
                if ((result.get(j).compareTo(result.get(indexMax)) > 0) ||
                        ((result.get(j).compareTo(result.get(indexMax)) == 0) && (result.get(j).getLastName().compareTo(result.get(indexMax).getLastName()) > 0))) {
                    indexMax = j;
                }
            }
            if (indexMax != n) {
                employee = result.get(n);
                result.set(n, result.get(indexMax));
                result.set(indexMax, employee);
            }
        }
        return result;
    }

    public void add(Employee newEmployee) {
        for (Employee employee : employees) {
            if (employee.getId() == newEmployee.getId()) {
                throw new RuntimeException("There is an employee with same id " + newEmployee.getId());
            }
        }
        employees.add(newEmployee);
    }

    public void remove(Employee employee) {
        employees.remove(employee);
    }

    public void edit(Employee editEmployee) {
        boolean isEdited = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == editEmployee.getId()) {
                employees.set(i, editEmployee);
                isEdited = true;
            }
        }
        if (!isEdited) {
            throw new RuntimeException("There is no employee with id " + editEmployee.getId());
        }
    }

    public ArrayList<Employee> find(String firstName, String lastName) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                result.add(employee);
            }
        }
        return result;
    }

    public void load() {
        employees = fileDao.load();
    }

    public void save() {
        fileDao.save(employees);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}