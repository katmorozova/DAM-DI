/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gamerentalapp;

import com.mycompany.gamerentalapp.model.Game;
import com.mycompany.gamerentalapp.model.Genre;
import com.mycompany.gamerentalapp.model.Platform;
import com.mycompany.gamerentalapp.model.Rental;
import com.mycompany.gamerentalapp.model.RentalStatus;
import com.mycompany.gamerentalapp.model.User;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase ede los datos iniciales obligatorios del sistema 
 * (usuarios, videojuegos con stock por plataforma y alquileres de prueba) 
 * al arrancar la aplicación
 * 
 * @author Ekaterina Morozova
 */
public class SampleData {
    
    public static void cargarDatos(DataRepository dataRepository) {
        
        User user1 = new User(
                    "U01", 
                    "Laura", 
                    "Garcia", 
                    "Martínez", 
                    "87654321B", 
                    "678901234", 
                    LocalDate.now()
        );

        User user2 = new User(
                    "U02", 
                    "Sergio", 
                    "Gonzales", 
                    "Duarte", 
                    "74254321A", 
                    "608901274", 
                    LocalDate.now()
        );

        dataRepository.getUsers().add(user1);
        dataRepository.getUsers().add(user2);

        Map<Platform, Integer> stockGame1 = new HashMap<>();
        stockGame1.put(Platform.PS5, 5);
        stockGame1.put(Platform.SWITCH_2, 3);

        Game game1 = new Game("G01", "Cyberpunk 2077", Genre.ACCIO, stockGame1);

        Map<Platform, Integer> stockGame2 = new HashMap<>();
        stockGame2.put(Platform.XBOX, 4);
        stockGame2.put(Platform.PC, 2);

        Game game2 = new Game("G02", "Minecraft", Genre.AVENTURA, stockGame2);

        dataRepository.getGames().add(game1);
        dataRepository.getGames().add(game2);

        stockGame1.put(Platform.PS5, stockGame1.get(Platform.PS5) - 1); 
        Rental rental1 = new Rental(
                "01", 
                user1, 
                game1, 
                Platform.PS5, 
                LocalDate.now().minusDays(3), 
                LocalDate.now().plusDays(4), 
                RentalStatus.ACTIVE
        );

        stockGame2.put(Platform.PC, stockGame2.get(Platform.PC) - 1); 
        Rental rental2 = new Rental(
                "02", 
                user2, 
                game2, 
                Platform.PC, 
                LocalDate.now().minusDays(5), 
                LocalDate.now().plusDays(2), 
                RentalStatus.OVERDUE 
        );

        dataRepository.getRentals().add(rental1);
        dataRepository.getRentals().add(rental2);
    }
}
