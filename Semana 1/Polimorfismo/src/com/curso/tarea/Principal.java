package com.curso.tarea;

public class Principal {

    public static void main(String[] args) {
        Curso presencial = new CursoPresencial("Programación en Java", "Juan Pérez", 40, "Aula 101");
        Curso enLinea = new CursoEnLinea("Introducción a la IA", "María Gómez", 30, "Zoom");

        presencial.mostrarDetalles();
        ((Evaluable) presencial).evaluar();

        System.out.println();

        enLinea.mostrarDetalles();
        ((Evaluable) enLinea).evaluar();
        ((Certificable) enLinea).certificar();
    }
}
