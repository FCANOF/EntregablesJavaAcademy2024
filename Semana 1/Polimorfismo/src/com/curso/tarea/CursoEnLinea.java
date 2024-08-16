package com.curso.tarea;

public class CursoEnLinea extends Curso implements Evaluable, Certificable {

    private String plataforma;

    public CursoEnLinea(String nombre, String instructor, int duracion, String plataforma) {
        super(nombre, instructor, duracion);
        this.plataforma = plataforma;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Curso en Línea: " + nombre);
        System.out.println("Instructor: " + instructor);
        System.out.println("Duración: " + duracion + " horas");
        System.out.println("Plataforma: " + plataforma);
    }

    @Override
    public void evaluar() {
        System.out.println("Evaluando a los estudiantes del curso en línea: " + nombre);
    }

    @Override
    public void certificar() {
        System.out.println("Certificando a los estudiantes del curso en línea: " + nombre);
    }
}