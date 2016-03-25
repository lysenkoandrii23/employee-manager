package com.lysenko.andrii.entity;

public class Developer extends Employee {

    public Developer() {
    }

    public Developer(long id, String firstName, String lastName, int salary) {
        super(id, firstName, lastName, salary);
    }

    @Override
    public String toString() {
        return "Developer " + this.getFirstName() + " " + this.getLastName() + " with id " + this.getId() + " and salary " + this.getSalary();
    }
}