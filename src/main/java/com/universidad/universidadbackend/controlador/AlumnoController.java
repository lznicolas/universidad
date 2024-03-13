package com.universidad.universidadbackend.controlador;

import com.universidad.universidadbackend.exepcion.BadRequestExeption;
import com.universidad.universidadbackend.modelo.entidades.Alumno;
import com.universidad.universidadbackend.modelo.entidades.Carrera;
import com.universidad.universidadbackend.modelo.entidades.Persona;
import com.universidad.universidadbackend.servicios.contratos.AlumnoDAO;
import com.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import com.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController extends PersonaController{

    private final CarreraDAO carreraDAO;

   @Autowired
    public AlumnoController(@Qualifier("alumnoDAOImpl") PersonaDAO alumnoDAO, CarreraDAO carreraDAO) {
        super(alumnoDAO);
        nombreEntidad = "Alumno";
        this.carreraDAO = carreraDAO;
    }
/* 
    @GetMapping("/{id}")
    public Persona obtenerAlumnoPorId(@PathVariable(required = false) Integer id){
        Optional<Persona> oAlumno = alumnoDAO.findById(id);
        if (!oAlumno.isPresent()){
            throw new BadRequestExeption(String.format("El alumno con ID %d no existe", id));
        }
        return oAlumno.get();

    }

    @GetMapping
    public List<Persona> obtenerTodos(){
        List<Persona> alumnos = (List<Persona>) alumnoDAO.findAll();
        if (alumnos.isEmpty()){
            throw new BadRequestExeption("No existen Alumnos");
        }
        return alumnos;
    }

    @PostMapping
    public Persona altaAlumno(@RequestBody Persona alumno){
        return alumnoDAO.save(alumno);
    }*/

    @PutMapping("/{id}")
    public Persona actualizaAlumno(@PathVariable Integer id, @RequestBody Persona alumno){
        Persona alumnoUpdate = null;
        Optional<Persona> oAlumno = service.findById(id);
        if (!oAlumno.isPresent()){
            throw new BadRequestExeption(String.format("El alumno con ID %d no existe", id));
        }
        alumnoUpdate = oAlumno.get();
        alumnoUpdate.setNombre(alumno.getNombre());
        alumnoUpdate.setApellido(alumno.getApellido());
        alumnoUpdate.setDireccion(alumno.getDireccion());
        return service.save(alumnoUpdate);
    }

    /*@DeleteMapping("{id}")
    public void eliminarAlumno(@PathVariable Integer id){
        alumnoDAO.deleteById(id);
    }
*/
    @PutMapping("/{idAlumno}/carrera/{idCarrera}")
    public Persona asignarCarreraAlumno(@PathVariable Integer idAlumno, @PathVariable Integer idCarrera){
        Optional<Persona> oAlumno = service.findById(idAlumno);
        if (!oAlumno.isPresent()){
            throw new BadRequestExeption(String.format("El alumno con ID %d no existe", idAlumno));
        }

        Optional<Carrera> oCarrera = carreraDAO.findById(idCarrera);
        if (!oCarrera.isPresent()){
            throw new BadRequestExeption(String.format("La carrera con el ID %d no existe",idCarrera));
        }

        Persona alumno = oAlumno.get();
        Carrera carrera = oCarrera.get();

        ((Alumno)alumno).setCarrera(carrera);
        return service.save(alumno);
    }
}
