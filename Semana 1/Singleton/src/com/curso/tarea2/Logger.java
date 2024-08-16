package com.curso.tarea2;

public class Logger {
    
    private static Logger instance;
    
    // Constructor privado previene la instanciación
    private Logger() {
    }
    
    // Método para obtener la instancia única
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    
    // Método para registrar un mensaje
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
