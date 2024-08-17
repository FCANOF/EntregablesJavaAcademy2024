package com.curso.tarea;

public class Transaccion {
    private String descripcion;
    private double monto;

    public Transaccion(String descripcion, double monto) {
        this.descripcion = descripcion;
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "descripcion='" + descripcion + '\'' +
                ", monto=" + monto +
                '}';
    }
}
