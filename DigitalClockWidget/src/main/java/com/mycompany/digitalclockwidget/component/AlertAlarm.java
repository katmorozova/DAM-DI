/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.digitalclockwidget.component;

import java.util.EventListener;

/**
 * Interfaz para el sistema de alarmas del reloj digital
 * 
 * Especifica el método que se ejecutará automáticamente cuando el evento de 
 * la alarma sea desencadenado
 * 
 * @author Ekaterina Morozova
 */
public interface AlertAlarm extends EventListener{
    
    void suenaAlarma(Alarm alarm);
}
