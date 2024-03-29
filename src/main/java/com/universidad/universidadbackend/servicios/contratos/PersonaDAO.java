package com.universidad.universidadbackend.servicios.contratos;

import com.universidad.universidadbackend.modelo.entidades.Persona;

import java.util.Optional;

public interface PersonaDAO extends GenericoDAO<Persona>{
    Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);
    Optional<Persona> buscarPorDni(String dni);
    Iterable<Persona> buscarPersonasPorApellido(String apellido);
}
