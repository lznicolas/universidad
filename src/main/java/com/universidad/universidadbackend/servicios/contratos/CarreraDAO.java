package com.universidad.universidadbackend.servicios.contratos;

import com.universidad.universidadbackend.modelo.entidades.Carrera;

import java.util.Iterator;
import java.util.Optional;

public interface CarreraDAO extends  GenericoDAO<Carrera>{

    Iterable<Carrera> findCarrerasByNombreContains(String nombre);
    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
    Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);

}
