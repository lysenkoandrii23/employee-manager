package com.lysenko.andrii.entity;

public abstract class Employee implements Comparable<Employee>{
    private long id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee() {}

    public Employee(long id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int compareTo(Employee employee) {
        return this.firstName.compareTo(employee.firstName);
    }

    @Override
    public boolean equals(Object employee) {
        if (this == employee) {
            return true;
        }
        if (this.getClass() == employee.getClass()) {
            Employee emp = (Employee) employee;
            if ((this.id == emp.id) && (this.salary == emp.salary) && (this.firstName.equals(emp.firstName)) && (this.lastName.equals(emp.lastName))) {
                return true;
            }
        }
        return false;
    }
}
