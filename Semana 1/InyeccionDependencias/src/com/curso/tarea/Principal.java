package com.curso.tarea;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<Transaccion> transacciones = new ArrayList<>();
        TransaccionServicio servicio = new TransaccionServicioImpl(transacciones);

        Transaccion t1 = new Transaccion("Almuerzo", 50.0);
        Transaccion t2 = new Transaccion("Café", 10.0);

        servicio.agregarTransaccion(t1);
        servicio.agregarTransaccion(t2);

        servicio.obtenerReporte().forEach(System.out::println);
    }
}
