/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gamerentalapp.data;

import com.mycompany.gamerentalapp.model.Game;
import com.mycompany.gamerentalapp.model.Rental;
import com.mycompany.gamerentalapp.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que almacena y gestiona las listas globales de usuarios, videojuegos y 
 * alquileres, garantizando la sincronización de datos entre todas las ventanas 
 * de la aplicación
 * 
 * @author Ekaterina Morozova
 */
public class DataRepository {
    
    List<User> users = new ArrayList<>();
    List<Game> games = new ArrayList<>();
    List<Rental> rentals = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    @Override
    public String toString() {
        return "DataRepository{"
                + "" + "users=" + users + 
                ", games=" + games + 
                ", rentals=" + rentals + 
        '}';
    }      
}