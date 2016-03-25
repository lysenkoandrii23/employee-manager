package com.lysenko.andrii.entity;

public class Manager extends Employee{

    public Manager() {
    }

    public Manager(long id, String firstName, String lastName, int salary) {
        super(id, firstName, lastName, salary);
    }

    @Override
    public String toString() {
        return "Manager " + this.getFirstName() + " " + this.getLastName() + " with id " + this.getId() + " and salary " + this.getSalary();
    }
}

