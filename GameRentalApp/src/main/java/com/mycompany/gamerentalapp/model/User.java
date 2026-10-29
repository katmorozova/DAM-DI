/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gamerentalapp.model;

import java.util.Date;

/**
 * Clase que representa un usuario o cliente del sistema de alquiler de videojuegos
 * Almacena la información personal básica y de contacto del usuario
 * 
 * @author Ekaterina Morozova
 */
public class User {
    
    private String userId, name, firstName, lastName, dni, phoneNumber;
    private Date dateOfRegister;
    
    public User() {}
    
    public User(
            String userId, 
            String name,
            String firstName,
            String lastName,
            String dni,
            String phoneNumber,
            Date dateOfRegister
    ){
        setUserId(userId);
        setName(name);
        setFirstName(firstName);
        setLastName(lastName);
        setDni(dni);
        setPhoneNumber(phoneNumber);
        setDateOfRegister(dateOfRegister);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El ID del usuario no puede estar vacío"
            );
        }
        this.userId = userId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre del usuario no puede estar vacío"
            );
        }
        this.name = name.trim();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
        throw new IllegalArgumentException(
                "El primer apellido no puede estar vacío"
        );
    }
        this.firstName = firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El segundo apellido no puede estar vacío"
            );
        }
        this.lastName = lastName.trim();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (dni == null || dni.trim().isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede estar vacío");
        }
        if (!dni.trim().matches("^[0-9]{8}[A-Za-z]$")) {
            throw new IllegalArgumentException(
                    "El DNI debe tener 8 números y una letra (ej. 12345678X)"
            );
        }
        this.dni = dni.trim().toUpperCase();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El teléfono no puede estar vacío"
            );
        }
        if (!phoneNumber.trim().matches("^[0-9]{9}$")) {
            throw new IllegalArgumentException(
                    "El número de teléfono debe contener exactamente 9 dígitos"
            );
        }
        this.phoneNumber = phoneNumber.trim();
    }

    public Date getDateOfRegister() {
        return dateOfRegister;
    }

    public void setDateOfRegister(Date dateOfRegister) {
        if (dateOfRegister == null) {
            throw new IllegalArgumentException(
                    "La fecha de registro no puede ser nula"
            );
        }
        this.dateOfRegister = dateOfRegister;
    }

    @Override
    public String toString() {
        return "User{" + 
                "userId=" + userId + 
                ", name=" + name + 
                ", firstName=" + firstName + 
                ", lastName=" + lastName + 
                ", dni=" + dni + 
                ", phoneNumber=" + phoneNumber + 
                ", dateOfRegister=" + dateOfRegister + 
        '}';
    }
 
}
