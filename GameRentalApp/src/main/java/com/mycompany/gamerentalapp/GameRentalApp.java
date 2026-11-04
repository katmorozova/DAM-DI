/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gamerentalapp;

import com.mycompany.gamerentalapp.data.DataRepository;
import com.mycompany.gamerentalapp.data.SampleData;

/**
 * Clase principalde la aplicación de gestión de alquiler de videojuegos
 * 
 * Se encarga de inicializar el repositorio, cargar los datos de prueba y 
 * lanzar la interfaz gráfica
 * 
 * @author Ekaterina Morozova
 */
public class GameRentalApp {

    public static void main(String[] args) {
        
        DataRepository repository = new DataRepository();
        SampleData.cargarDatos(repository);
    }
}
