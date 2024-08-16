package com.curso.tarea;

public class CursoPresencial extends Curso implements Evaluable {

    private String ubicacion;

    public CursoPresencial(String nombre, String instructor, int duracion, String ubicacion) {
        super(nombre, instructor, duracion);
        this.ubicacion = ubicacion;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Curso Presencial: " + nombre);
        System.out.println("Instructor: " + instructor);
        System.out.println("Duración: " + duracion + " horas");
        System.out.println("Ubicación: " + ubicacion);
    }

    @Override
    public void evaluar() {
        System.out.println("Evaluando a los estudiantes del curso presencial: " + nombre);
    }
}