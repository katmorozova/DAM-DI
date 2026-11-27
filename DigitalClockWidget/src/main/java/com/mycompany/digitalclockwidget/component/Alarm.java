/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digitalclockwidget.component;

import java.util.EventObject;

/**
 * Clase de evento personalizada que hereda de EventObject para mostrar mensaje 
 * de alarma cuando es disparada por el componente DigitalClock
 * 
 * @author Ekaterina Morozova
 */
public class Alarm extends EventObject{
    
    private String message;
    
    public Alarm(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
  
}
