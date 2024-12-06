package com.queueapp.model;

public class Person {
    private String dni;
    private String name;

    public Person(String dni, String name) {
        this.dni = dni;
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + ", Name: " + name;
    }
}