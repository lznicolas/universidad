package com.universidad.universidadbackend.repositorios;

import com.universidad.universidadbackend.datos.DatosDummy;
import com.universidad.universidadbackend.modelo.entidades.Empleado;
import com.universidad.universidadbackend.modelo.entidades.Persona;
import com.universidad.universidadbackend.modelo.entidades.Profesor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static com.universidad.universidadbackend.datos.DatosDummy.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class PersonaRepositoryTest {
    @Autowired
    @Qualifier("RepositorioAlumnos")
    PersonaRepository alumnoRepository;
    @Autowired
    @Qualifier("empleadoRepository")
    PersonaRepository empleadoRepository;
    @Autowired
    @Qualifier("profesorRepository")
    PersonaRepository profesorRepository;


    @Test
    void buscarPorNombreYApellido() {
        //given
        Persona save = empleadoRepository.save(empleado01());

        //when
        Optional<Persona> expected = empleadoRepository.buscarPorNombreYApellido(empleado01().getNombre(),
                empleado01().getApellido());

        //then
        assertThat(expected.get()).isInstanceOf(Empleado.class);
        assertThat(expected.get()).isEqualTo(save);


    }

    @Test
    void buscarPorDni() {
        //given
        Persona save = profesorRepository.save(profesor01());

        //when
        Optional<Persona> expected = profesorRepository.buscarPorDni(profesor01().getDni());

        //Then
        assertThat(expected.get()).isInstanceOf(Profesor.class);
        assertThat(expected.get()).isEqualTo(save);
        assertThat(expected.get().getDni()).isEqualTo(save.getDni());

    }

    @Test
    void buscarPersonasPorApellido() {

        //given
        Iterable<Persona> personas = alumnoRepository.saveAll(Arrays.asList(
                alumno01(),
                alumno02(),
                alumno03())
        );

        //when
        String apellido = "Lamas";
        List<Persona> expected = (List<Persona>) alumnoRepository.buscarPersonasPorApellido(apellido);

        //then
        assertThat(expected.size() == 2 ).isTrue();

    }
}