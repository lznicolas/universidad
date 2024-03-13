package com.universidad.universidadbackend.servicios.implementaciones;

import com.universidad.universidadbackend.datos.DatosDummy;
import com.universidad.universidadbackend.modelo.entidades.Carrera;
import com.universidad.universidadbackend.repositorios.CarreraRepository;
import com.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static com.universidad.universidadbackend.datos.DatosDummy.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarreraDAOImplTest {

    CarreraDAO carreraDAO;

    CarreraRepository carreraRepository;
    @BeforeEach
    void setUp() {
        carreraRepository = mock(CarreraRepository.class);
        carreraDAO = new CarreraDAOImpl(carreraRepository);
    }

    @Test
    void findCarrerasByNombreContains() {
        //given - para hacer los import estaticos video 60
        String nombre = "Ingenieria";
        when(carreraRepository.findCarrerasByNombreContains(nombre)).
                thenReturn(Arrays.asList(carrera01(true),carrera03(true)));

        //when
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContains(nombre);

        //Then
        assertThat(expected.get(0)).isEqualTo(carrera01(true));
        assertThat(expected.get(1)).isEqualTo(carrera03(true));
        //validamos que nuestro repositorio llama al metodo que decimosfindCarrerasByNombreContains
        verify(carreraRepository).findCarrerasByNombreContains(nombre);
    }

    @Test
    void findCarrerasByNombreContainsIgnoreCase() {
        //given
        String nombre = "ingenieria";

        Mockito.when(carreraRepository.findCarrerasByNombreContainsIgnoreCase(nombre)).
                thenReturn(Arrays.asList(carrera01(true),carrera03(true)));

        //when
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContainsIgnoreCase(nombre);

        //Then

        assertThat(expected.get(0)).isEqualTo(carrera01(true));
        assertThat(expected.get(1)).isEqualTo(carrera03(true));

        verify(carreraRepository).findCarrerasByNombreContainsIgnoreCase(nombre);
    }

    @Test
    void findCarrerasByCantidadAniosAfter() {
        //given
        Integer cantidad = 4;

        Mockito.when(carreraRepository.findCarrerasByCantidadAniosAfter(cantidad)).
                thenReturn(Arrays.asList(carrera01(true),carrera03(true)));

        //when
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByCantidadAniosAfter(cantidad);

        //Then

        assertThat(expected.get(0)).isEqualTo(carrera01(true));
        assertThat(expected.get(1)).isEqualTo(carrera03(true));

        verify(carreraRepository).findCarrerasByCantidadAniosAfter(cantidad);
    }
}