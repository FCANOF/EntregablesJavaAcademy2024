package com.curso.tarea2;

public class Principal {
    public static void main(String[] args) {
        // Obtener instancias del Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        
        // Comprobar si las instancias son iguales
        if (logger1 == logger2) {
            System.out.println("Ambas instancias son iguales, confirmando el patrón Singleton.");
        } else {
            System.out.println("Las instancias son diferentes, lo cual indica un problema en el Singleton.");
        }
    }
}
