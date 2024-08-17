package com.curso.tarea;

import java.util.List;

public class TransaccionServicioImpl implements TransaccionServicio {

    private final List<Transaccion> transacciones;

    public TransaccionServicioImpl(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    @Override
    public void agregarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
    }

    @Override
    public List<Transaccion> obtenerReporte() {
        return transacciones;
    }
}
