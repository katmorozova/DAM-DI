/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digitalclockwidget.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.time.LocalTime;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Ekaterina Morozova
 */
public class DigitalClock extends JLabel implements Serializable {
    
    private boolean clockFormat24 = true; //true -> 24h, false -> 12h
    private boolean alarmIsActive = false;
    private int alarmHour = 0;
    private int alarmMinut = 0;
    private String alarmMessage = "ALARM!";
    
    private AlertAlarm alertAlarm;
    
    public DigitalClock(){
        
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                LocalTime actualHour = LocalTime.now();
                //Cambiamos el formato de hora
                if (clockFormat24) {
                    setText(actualHour.format(java
                                    .time
                                    .format
                                    .DateTimeFormatter.
                                    ofPattern("HH:mm:ss")
                    ));
                } else {
                    setText(actualHour.format(java
                            .time
                            .format
                            .DateTimeFormatter
                            .ofPattern("hh:mm:ss a")
                    ));
                }
                
                // Comprobamos la alarma
                if (alarmIsActive) {
                    if (
                            actualHour.getHour() == alarmHour && 
                            actualHour.getMinute() == alarmMinut
                        ) {
                        if (alertAlarm != null) {
                            Alarm evento = new Alarm(this, alarmMessage);
                            alertAlarm.suenaAlarma(evento);
                        }
                    }
                }
            }     
        });
        
      timer.start();
    }
    

    public boolean isClockFormat24() {
        return clockFormat24;
    }

    public void setClockFormat24(boolean clockFormat24) {
        this.clockFormat24 = clockFormat24;
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
