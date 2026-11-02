/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gamerentalapp.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase que representa la transacción de alquiler de un videojuego por parte de un usuario
 * Vincula al cliente con el juego alquilado y gestiona las fechas de préstamo y devolución
 * 
 * @author Ekaterina Morozova
 */
public class Rental {
    
    private String rentalId;
    private User user;
    private Game game;
    private Platform platform;
    private LocalDate startDate;
    private LocalDate expectedReturn;
    private RentalStatus rentalStatus;
    
    public Rental() {
        this.startDate = LocalDate.now();
        this.expectedReturn = this.startDate.plusDays(7); 
        this.rentalStatus = RentalStatus.ACTIVE;
    }
    
    public Rental(
            String rentalId,
            User user,
            Game game,
            Platform platform,
            LocalDate startDate,
            LocalDate expectedReturn,
            RentalStatus rentalStatus
    ){
        setRentalId(rentalId);
        setUser(user);
        setGame(game);
        setPlatform(platform);
        setStartDate(startDate);
        setExpectedReturn(expectedReturn);
        setRentalStatus(rentalStatus);
    }

    public String getRentalId() {
        return rentalId;
    }

    public void setRentalId(String rentalId) {
        if (rentalId == null || rentalId.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El ID del alquiler no puede estar vacío"
            );
        }
        this.rentalId = rentalId.trim();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        if (game == null) {
            throw new IllegalArgumentException("El juego no puede ser nulo");
        }
        this.game = game;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        if (platform == null) {
            throw new IllegalArgumentException(
                    "La plataforma no puede ser nula"
            );
        }
        this.platform = platform;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        if (startDate == null) {
            throw new IllegalArgumentException(
                    "La fecha de inicio no puede ser nula"
            );
        }
        this.startDate = startDate;
    }

    public LocalDate getExpectedReturn() {
        return expectedReturn;
    }

    public void setExpectedReturn(LocalDate expectedReturn) {
        if (expectedReturn == null) {
            throw new IllegalArgumentException(
                    "La fecha de finalización no puede ser nula"
            );
        }
        if(this.startDate != null && expectedReturn.isBefore(this.startDate)){
            throw new IllegalArgumentException(
                "La fecha de devolución no puede ser anterior a "
                        + "la fecha de inicio"
            );
        }
        this.expectedReturn = expectedReturn;
    }

    public RentalStatus getRentalStatus() {
        return rentalStatus;
    }

    public void setRentalStatus(RentalStatus rentalStatus) {
        if (rentalStatus == null) {
            throw new IllegalArgumentException(
                    "El estado del alquiler no puede ser nulo"
            );
        }
        this.rentalStatus = rentalStatus;
    }
    
    @Override
    public boolean equals(Object object) {
        if (this == object){
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Rental rental = (Rental) object;
        return Objects.equals(rentalId, rental.rentalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentalId);
    }

    @Override
    public String toString() {
        return "Rental{" + 
                "rentalId=" + rentalId + 
                ", user=" + user + 
                ", game=" + game + 
                ", platform=" + platform + 
                ", startDate=" + startDate + 
                ", expectedReturn=" + expectedReturn + 
                ", rentalStatus=" + rentalStatus + 
        '}';
    }      
}
