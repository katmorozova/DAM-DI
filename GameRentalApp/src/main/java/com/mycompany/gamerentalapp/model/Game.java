/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gamerentalapp.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa un videojuego disponible en el catálogo del sistema
 * Contiene los datos principales del juego y el stock de copias disponibles
 * 
 * @author Ekaterina Morozova
 */
public class Game {
    
    private String gameId, title;
    private Genre genre;
    private Map<Platform, Integer> platformsStock;
    
    public Game(){
        this.platformsStock = new HashMap<>();
    }
    
    public Game(
            String gameId, 
            String title, 
            Genre genre, 
            Map<Platform, Integer> platformsStock
    ){
        setGameId(gameId);
        setTitle(title);
        setGenre(genre);
        setPlatformsStock(platformsStock);
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        if (gameId == null || gameId.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El ID del juego no puede estar vacío"
            );
        }
        this.gameId = gameId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El título del juego no puede estar vacío"
            );
        }
        this.title = title.trim();
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        if (genre == null) {
            throw new IllegalArgumentException(
                    "El género del juego debe estar seleccionado"
            );
        }
        this.genre = genre;
    }

    public Map<Platform, Integer> getPlatformsStock() {
        return new HashMap<>(platformsStock);
    }

    public void setPlatformsStock(Map<Platform, Integer> platformsStock) {
        if (platformsStock == null || platformsStock.isEmpty()) {
            throw new IllegalArgumentException(
                "El juego debe tener al menos una plataforma con stock"
            );
        }
        
        for (Map.Entry<Platform, Integer> entry : platformsStock.entrySet()) {
            if (entry.getValue() == null || entry.getValue() < 0) {
                throw new IllegalArgumentException(
                    "La cantidad para la plataforma no puede ser negativa"
                );
            }
        }
        this.platformsStock = new HashMap<>(platformsStock);
    }
    
    // Método para añadir o actualizar stock de una plataforma individual
    public void addPlatformStock(Platform platform, int quantity) {
        if (platform == null) {
            throw new IllegalArgumentException(
                    "La plataforma no puede ser nula"
            );
        }
        if (quantity < 0) {
            throw new IllegalArgumentException(
                    "La cantidad de copias no puede ser negativa"
            );
        }
        int currentStock = this.platformsStock.getOrDefault(platform, 0);
        this.platformsStock.put(platform, currentStock + quantity);
    }
    
    @Override
    public boolean equals(Object newGame) {
        if (this == newGame) {
            return true;
        }
        if (newGame == null || getClass() != newGame.getClass()) {
            return false;
        }
        Game game = (Game) newGame;
        return java.util.Objects.equals(gameId, game.gameId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(gameId);
    }
    
    @Override
    public String toString() {
        return "Game{"
                + "gameId=" + gameId + 
                ", title=" + title + 
                ", genre=" + genre + 
                ", platformsStock=" + platformsStock + 
                '}';
    }   
}