package com.universidad.universidadbackend.servicios.implementaciones;

import com.universidad.universidadbackend.repositorios.AlumnoRepository;
import com.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class PersonaDAOImplTest {

    PersonaDAO personaDAO;
    @Mock
    AlumnoRepository alumnoRepository;
    @BeforeEach
    void setUp() {
        personaDAO = new PersonaDAOImpl(alumnoRepository);
    }

    @Test
    void buscarPorNombreYApellido() {

        //when
        personaDAO.buscarPorNombreYApellido(anyString(),anyString());

        ///then
        Mockito.verify(alumnoRepository).buscarPorNombreYApellido(anyString(),anyString());
    }

    @Test
    void buscarPorDni() {
        //when
        personaDAO.buscarPorDni(anyString());

        ///then
        Mockito.verify(alumnoRepository).buscarPorDni(anyString());

    }

    @Test
    void buscarPersonasPorApellido() {
        //when
        personaDAO.buscarPersonasPorApellido(anyString());

        ///then
        Mockito.verify(alumnoRepository).buscarPersonasPorApellido(anyString());

    }
}