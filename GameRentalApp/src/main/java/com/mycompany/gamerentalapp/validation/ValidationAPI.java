/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gamerentalapp.validation;

/**
 * Utility validation class to enforce business rules and input constraints
 * across the game rental application 
 * 
 * @author Ekaterina Morozova
 */
public class ValidationAPI {
    
    /**
     * Validates that a user's name is not empty and starts with an uppercase letter
     * Throws an IllegalArgumentException with a Catalan error message if validation fails
     * 
     * @param name the user name string to validate
     * @return true if valid
     */
    public static boolean validateUserName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nom del usuari no pot estar buit"
            );
        }
        
        char firstChar = name.trim().charAt(0);
        if (!Character.isUpperCase(firstChar)) {
            throw new IllegalArgumentException(
                "Error de validació: El nom del usuari ha de començar "
                        + "obligatòriament per una lletra majúscula"
            );
        }
        return true;
    }

    /**
     * Validates that a game title is not empty or null
     * 
     * @param title the game title string to validate
     * @return true if valid
     */
    public static boolean validateGameTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El títol del joc no pot estar buit"
            );
        }
        return true;
    }

    /**
     * Validates that a given stock number is non-negative
     * 
     * @param stock the stock integer value
     * @return true if valid
     */
    public static boolean validateStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("L'estoc no pot ser negatiu");
        }
        return true;
    }
}
