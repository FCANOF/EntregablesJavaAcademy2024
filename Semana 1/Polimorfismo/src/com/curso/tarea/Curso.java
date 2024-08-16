package com.curso.tarea;

public abstract class Curso {
    protected String nombre;
    protected String instructor;
    protected int duracion; // duración en horas

    public Curso(String nombre, String instructor, int duracion) {
        this.nombre = nombre;
        this.instructor = instructor;
        this.duracion = duracion;
    }

    public abstract void mostrarDetalles();
}
