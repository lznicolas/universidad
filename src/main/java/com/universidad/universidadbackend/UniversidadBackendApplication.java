package com.universidad.universidadbackend;

import com.universidad.universidadbackend.modelo.entidades.Alumno;
import com.universidad.universidadbackend.modelo.entidades.Direccion;
import com.universidad.universidadbackend.modelo.entidades.Persona;
import com.universidad.universidadbackend.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class UniversidadBackendApplication {

	/*@Autowired
	private AlumnoDAO servicio;
*/
	public static void main(String[] args) {
		SpringApplication.run(UniversidadBackendApplication.class, args);
		/*for (String str : beanDefinitionNames){
			System.out.println(str);
		}*/

	}
	/*@Bean
	public CommandLineRunner runner(){
		return args -> {
			*//*Direccion direccion = new Direccion("Calle Falsa", "200", "4000", "", "", "San Juan");
			Persona alumno = new Alumno(null, "Martin","Romero","2222222222", direccion);

			Persona save = servicio.save(alumno);
			System.out.println(save.toString());*//*
			*//*List<Persona> alumnos = (List<Persona>) servicio.findAll();
			alumnos.forEach(System.out::println);*//*
		};
	}*/

}
