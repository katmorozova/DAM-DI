/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.gamerentalapp.model;

/**
 * Enumeración que representa los géneros disponibles para los videojuegos del catálogo
 * 
 * @author Ekaterina Morozova
 */
public enum Genre {
    
    ACCIO("Acció"),
    AVENTURA("Aventura"),
    ESPORTS("Esports"),
    RPG("RPG"),
    ESTRATEGIA("Estratègia");

    private final String displayName;

    Genre(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
