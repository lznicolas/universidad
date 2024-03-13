package com.universidad.universidadbackend.servicios.implementaciones;

import com.universidad.universidadbackend.modelo.entidades.Carrera;
import com.universidad.universidadbackend.modelo.entidades.Persona;
import com.universidad.universidadbackend.repositorios.AlumnoRepository;
import com.universidad.universidadbackend.repositorios.PersonaRepository;
import com.universidad.universidadbackend.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
//clase 44 revisar lo del qualifiler
@Service
public class AlumnoDAOImpl extends PersonaDAOImpl implements AlumnoDAO {
    @Autowired
    public AlumnoDAOImpl(@Qualifier("RepositorioAlumnos") PersonaRepository repository) {
        super(repository);
    }


    @Override
    public Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre) {
        //Se tendra que castear el alumno video 48 min 9
        return ((AlumnoRepository)repository).buscarAlumnosPorNombreCarrera(nombre);
    }
}
