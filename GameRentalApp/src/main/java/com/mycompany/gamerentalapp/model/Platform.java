/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.gamerentalapp.model;

/**
 * Enumeración que representa las plataformas de videojuegos disponibles en el sistema
 * 
 * @author Ekaterina Morozova
 */
public enum Platform {
    
    PS5("PS5"),
    SWITCH_2("Switch 2"),
    XBOX("Xbox"),
    PC("PC");

    private final String displayName;

    Platform(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
