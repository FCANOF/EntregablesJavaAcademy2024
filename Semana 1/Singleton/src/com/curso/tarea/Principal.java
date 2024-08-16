package com.curso.tarea;

public class Principal {
    public static void main(String[] args) {
        // Get the single instance of Logger
        Logger logger = Logger.getInstance();
        
        // Log some messages
        logger.log("La aplicación ha iniciado.");
        logger.log("Procesando datos...");
        logger.log("La aplicación ha finalizado.");
    }
}
