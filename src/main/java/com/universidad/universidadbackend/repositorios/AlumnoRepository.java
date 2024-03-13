package com.universidad.universidadbackend.repositorios;

import com.universidad.universidadbackend.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("RepositorioAlumnos")
public interface AlumnoRepository extends PersonaRepository{

    @Query("select a from Alumno a join fetch a.carrera c where c.nombre = ?1")
    Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);
}
