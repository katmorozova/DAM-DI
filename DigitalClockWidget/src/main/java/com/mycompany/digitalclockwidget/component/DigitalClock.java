/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digitalclockwidget.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * Clase que permite mostrar la hora actual en formato de 12 o 24 horas, 
 * actualizarla cada segundo mediante un Timer y configurar una alarma con hora, 
 * minuto, mensaje personalizado y un sistema de eventos para notificar cuando 
 * esta se active
 * 
 * @author Ekaterina Morozova
 */
public class DigitalClock extends JLabel implements Serializable {
    
    private boolean clockFormat24 = true; //true -> 24h, false -> 12h
    private boolean alarmIsActive = false;
    private int alarmHour = 0;
    private int alarmMinut = 0;
    private String alarmMessage = "ALARMA!";
    
    private AlertAlarm alertAlarm;
    private boolean alarmSound = false;
    
    public DigitalClock(){
        setHorizontalAlignment(JLabel.CENTER);
        updateClockDisplay();
        
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                LocalTime actualHour = LocalTime.now();
                //Cambiamos el formato de hora
                updateClockDisplay();
                // Comprobamos la alarma
                checkAlarm();  
            }     
        });   
      timer.start();
    }
    
    private void updateClockDisplay() {
        LocalTime actualHour = LocalTime.now();
        if(clockFormat24){
            setText(actualHour.format(DateTimeFormatter.ofPattern("HH:mm:ss")));   
        }else{
            setText(actualHour.format(DateTimeFormatter.ofPattern("hh:mm:ss"))); 
        }
    }
    
    private void checkAlarm(){
        if (alarmIsActive) {
            LocalTime actualHour = LocalTime.now();
            int currentHour = actualHour.getHour();
            int currentMinute = actualHour.getMinute();
            
            if (currentHour == alarmHour && currentMinute == alarmMinut){
                if(!alarmSound) {
                   alarmSound = true;
                   if(alertAlarm != null){
                       Alarm alarmEvent = new Alarm(DigitalClock.this, alarmMessage);
                       alertAlarm.suenaAlarma(alarmEvent);
                   }
                }
            }else{
                alarmSound = false;
            }
        }
    }
    
    public boolean isClockFormat24() {
        return clockFormat24;
    }

    public void setClockFormat24(boolean clockFormat24) {
        this.clockFormat24 = clockFormat24;
        updateClockDisplay();
    }

    public boolean isAlarmIsActive() {
        return alarmIsActive;
    }

    public void setAlarmIsActive(boolean alarmIsActive) {
        this.alarmIsActive = alarmIsActive;
    }

    public int getAlarmHour() {
        return alarmHour;
    }

    public void setAlarmHour(int alarmHour) {
        this.alarmHour = alarmHour;
    }

    public int getAlarmMinut() {
        return alarmMinut;
    }

    public void setAlarmMinut(int alarmMinut) {
        this.alarmMinut = alarmMinut;
    }

    public String getAlarmMessage() {
        return alarmMessage;
    }

    public void setAlarmMessage(String alarmMessage) {
        this.alarmMessage = alarmMessage;
    }  
    
    public void addAlertAlarm(AlertAlarm alert) {
    this.alertAlarm = alert;
}

    public void removeAlertAlarm(AlertAlarm alert) {
        this.alertAlarm = null;
    }
}
