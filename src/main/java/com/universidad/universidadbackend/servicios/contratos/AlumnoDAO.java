package com.universidad.universidadbackend.servicios.contratos;


import com.universidad.universidadbackend.modelo.entidades.Persona;

public interface AlumnoDAO extends PersonaDAO{
    Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);

}
