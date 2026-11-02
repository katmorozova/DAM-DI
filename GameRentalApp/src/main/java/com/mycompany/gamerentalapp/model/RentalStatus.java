/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.gamerentalapp.model;

/**
 * Enumeración que representa los estados posibles de un alquiler en el sistema
 * 
 * @author Ekaterina Morozova
 */
public enum RentalStatus {
    ACTIVE("Active"),
    RETURNED("Returned"),
    OVERDUE("Overdue");

    private final String displayName;

    RentalStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
