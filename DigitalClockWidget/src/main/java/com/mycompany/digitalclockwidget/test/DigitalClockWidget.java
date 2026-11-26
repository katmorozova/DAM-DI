package com.mycompany.digitalclockwidget.test;


import com.mycompany.digitalclockwidget.component.Alarm;
import com.mycompany.digitalclockwidget.component.AlertAlarm;
import com.mycompany.digitalclockwidget.component.DigitalClock;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Clase principal de pruebas que integra el componente de reloj digital y permite 
 * alternar entre formato de 12 y 24 horas, abrir un diálogo modal con spinners 
 * para configurar la hora, los minutos y la activación de la alarma, y captura 
 * los eventos de la alarma para mostrar una alerta visual de aviso
 * 
 * @author Ekaterina Morozova
 */
public class DigitalClockWidget extends JFrame{
    
    private DigitalClock digitalClock;
    
    public DigitalClockWidget() {
        setTitle("Reloj Digital");
        setSize(450, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));

        //Creamos componente del reloj digital
        digitalClock = new DigitalClock();
        digitalClock.setAlarmMessage("ALARMA!"); 

        //Check-boxes para elegir formato de hora
        JCheckBox format24 = new JCheckBox("Formato 24 horas", true);
        format24.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evento) {
                digitalClock.setClockFormat24(format24.isSelected());
            }      
        });

        //Boton para abrir nueva ventana para configurar la alarma
        JButton setAlarmButton = new JButton("Configurar alarma");
        setAlarmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                openAlarmDialog();
            }    
        });
        
        //Configumos una alarma para la hora y minuto actual 
        LocalTime rightNow = LocalTime.now();
        digitalClock.setAlarmHour(rightNow.getHour());
        digitalClock.setAlarmMinut(rightNow.getMinute());
        digitalClock.setAlarmMessage("¡Alarma!");
        digitalClock.setAlarmIsActive(true);

        //Capturamos evento y mostramos un mensaje cuando suene la alarma
        digitalClock.addAlertAlarm(new AlertAlarm() {
            @Override
            public void suenaAlarma(Alarm alarm) {
                Object[] options = {"Aceptar"};
                JOptionPane.showOptionDialog(
                    DigitalClockWidget.this, 
                    alarm.getMessage(), 
                    "¡Alarma Activada!", 
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
                );
            }
        });

    //Añadimos el reloj al formulario con check-box de formato de hora y botón para alarma
        add(digitalClock);
        add(format24);
        add(setAlarmButton);
    }

    private void openAlarmDialog(){
        JDialog dialog = new JDialog(this, "Configuración de Alarma", true);
        dialog.setSize(320, 180);
        dialog.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
        dialog.setLocationRelativeTo(this);
    
        //Spinners para horas y minutos
        JSpinner hourSpinner = new JSpinner(
                new SpinnerNumberModel(digitalClock.getAlarmHour(), 0, 23, 1)
        );
        JSpinner minuteSpinner = new JSpinner(
                new SpinnerNumberModel(digitalClock.getAlarmMinut(), 0, 59, 1)
        );
    
        //Check-box para activar alarma
        JCheckBox activeAlarmCheckBox = new JCheckBox(
                "Activar alarma", 
                digitalClock.isAlarmIsActive()
        );
    
        //Boton para aceptar alarma
        JButton acceptAlarmButton = new JButton("Aceptar");
        acceptAlarmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
               //Guardamos datos en componente del reloj
                digitalClock.setAlarmHour((int) hourSpinner.getValue());
                digitalClock.setAlarmMinut((int) minuteSpinner.getValue());
                digitalClock.setAlarmIsActive(activeAlarmCheckBox.isSelected());

                dialog.dispose();
            }
            
        });
        
        //Añadimos elementos en panel principal del reloj digital
        dialog.add(new JLabel("Hora: "));
        dialog.add(hourSpinner);
        dialog.add(new JLabel("Minutos: "));
        dialog.add(minuteSpinner);
        dialog.add(activeAlarmCheckBox);
        dialog.add(acceptAlarmButton);
        
        dialog.setVisible(true);
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
