package com.universidad.universidadbackend.repositorios;

import com.universidad.universidadbackend.modelo.entidades.Alumno;
import com.universidad.universidadbackend.modelo.entidades.Carrera;
import com.universidad.universidadbackend.modelo.entidades.Persona;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import static com.universidad.universidadbackend.datos.DatosDummy.*;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class AlumnoRepositoryTest {
    @Autowired
    @Qualifier("RepositorioAlumnos")
    PersonaRepository alumnoRepository;
    @Autowired
    CarreraRepository carreraRepository;
    @Test
    void buscarAlumnosPorNombreCarrera() {
        //given
        Iterable<Persona> personas = alumnoRepository.saveAll(Arrays.asList(
                alumno01(),
                alumno02(),
                alumno03())
        );

        Carrera save = carreraRepository.save(carrera01(false));

        personas.forEach(alumno ->((Alumno)alumno).setCarrera(save));

        alumnoRepository.saveAll(personas);

        //when
        String carrera = "Ingenieria en Sistemas";
        List<Persona> expected = (List<Persona>) ((AlumnoRepository) alumnoRepository).buscarAlumnosPorNombreCarrera(carrera);

        //then
        assertThat(expected.size() == 3).isTrue();
    }

    @Test
    void buscarAlumnosPorNombreCarreraSinValores() {
        //given
        Iterable<Persona> personas = alumnoRepository.saveAll(Arrays.asList(
                alumno01(),
                alumno02(),
                alumno03())
        );

        Carrera save = carreraRepository.save(carrera01(false));

        personas.forEach(alumno ->((Alumno)alumno).setCarrera(save));

        alumnoRepository.saveAll(personas);

        //when
        String carrera = "Ingenieria en Alimentos";
        List<Persona> expected = (List<Persona>) ((AlumnoRepository) alumnoRepository).buscarAlumnosPorNombreCarrera(carrera);

        //then
        assertThat(expected.isEmpty()).isTrue();
    }
}