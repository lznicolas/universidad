package com.universidad.universidadbackend.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.universidad.universidadbackend.modelo.entidades.Carrera;
import org.springframework.stereotype.Repository;


public interface CarreraRepository extends CrudRepository<Carrera,Integer> {

    //@Query("select c from Carrera c where c.nombre like %?1%")
    Iterable<Carrera> findCarrerasByNombreContains(String nombre);
    //@Query("select c from Carrera c where upper (c.nombre) like upper(%?1%)")
    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
    //@Query("select c from Carrera c where upper (c.cantidadAnios) > ?1")
    Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);
}
