package com.curso.tarea;
import java.util.List;

public interface TransaccionServicio {
    void agregarTransaccion(Transaccion transaccion);
    List<Transaccion> obtenerReporte();
}