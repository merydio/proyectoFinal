package com.queueapp.util;

import com.queueapp.model.Person;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserValidator {
    private static Map<String, String> validUsers = new HashMap<>();

    static {
        // Initialize with some sample users
        validUsers.put("12345678", "Juan Pérez");
        validUsers.put("87654321", "María González");
        validUsers.put("11223344", "Carlos Rodríguez");
        validUsers.put("22334455", "Ana López");
        validUsers.put("33445566", "Luis Martínez");
        validUsers.put("44556677", "Sofía García");
        validUsers.put("55667788", "Pedro Fernández");
        validUsers.put("66778899", "Laura Sánchez");
        validUsers.put("77889900", "José Díaz");
        validUsers.put("88990011", "Carmen Torres");
    }

    public static Person validateUser(String dni) {
        String name = validUsers.get(dni);
        return name != null ? new Person(dni, name) : null;
    }
}