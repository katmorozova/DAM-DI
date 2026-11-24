package com.mycompany.digitalclockwidget.test;


import com.mycompany.digitalclockwidget.component.Alarm;
import com.mycompany.digitalclockwidget.component.AlertAlarm;
import com.mycompany.digitalclockwidget.component.DigitalClock;
import java.awt.FlowLayout;
import java.time.LocalTime;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ekaterina Morozova
 */
public class DigitalClockWidget extends JFrame{
    
    public DigitalClockWidget() {
        setTitle("Digital Clock Test Form");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        //Creamos componente del reloj digital
        DigitalClock digitalClock = new DigitalClock();
        digitalClock.setClockFormat24(false); 

        //Configumos una alarma para la hora y minuto actual 
        LocalTime rightNow = LocalTime.now();
        digitalClock.setAlarmHour(rightNow.getHour());
        digitalClock.setAlarmMinut(rightNow.getMinute());
        digitalClock.setAlarmMessage("Wake up! Wake up! Wake up!");
        digitalClock.setAlarmIsActive(true);

        //Capturamos evento y mostramos un mensaje cuando suene la alarma
        digitalClock.addAlertAlarm(new AlertAlarm() {
            @Override
            public void suenaAlarma(Alarm alarm) {
                JOptionPane.showMessageDialog(
                    DigitalClockWidget.this, 
                    alarm.getMessage(), 
                    "¡Alarma Activada!", 
                    JOptionPane.WARNING_MESSAGE
                );
            }
        });

        // Añadimos el reloj al formulario
        add(digitalClock);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DigitalClockWidget().setVisible(true);
            }
        });
    }
    
}
