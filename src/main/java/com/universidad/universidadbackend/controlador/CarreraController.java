package com.universidad.universidadbackend.controlador;

import com.universidad.universidadbackend.exepcion.BadRequestExeption;
import com.universidad.universidadbackend.modelo.entidades.Carrera;
import com.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/carreras")
public class CarreraController extends GenericController<Carrera, CarreraDAO> {

    @Autowired
    public CarreraController(CarreraDAO service) {
        super(service);
        nombreEntidad = "carrera";
    }

    /*@GetMapping("/{codigo}")
    public Carrera obtenerPorId(@PathVariable(value = "codigo", required = false) Integer id){
        Optional<Carrera> oCarrera = service.findById(id);
        if (!oCarrera.isPresent()){
            throw new BadRequestExeption(String.format("La carrera con ID %d no existe", id));
        }
        return oCarrera.get();

    }

    @PostMapping
    public Carrera altaCarrera(@RequestBody Carrera carrera){
        if (carrera.getCantidadAnios()<0){
            throw new BadRequestExeption("El campo cantidad de años no puede ser negativo");
        }
        if (carrera.getCantidadMaterias()<0){
            throw new BadRequestExeption("El campo cantidad de materias no puede ser negativo");
        }
        return service.save(carrera);
    }*/

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCarrer(@PathVariable Integer id, @RequestBody Carrera carrera){
        Map<String, Object> mensaje = new HashMap<>();

        Carrera carreraUpdate = null;
        Optional<Carrera> oCarrera = service.findById(id);
        if (!oCarrera.isPresent()){
            //throw new BadRequestExeption(String.format("La carrera con ID %d no existe", id));
            mensaje.put("succes",Boolean.FALSE);
            mensaje.put("succes",String.format("%s con ID %d no existe",nombreEntidad,id));
            return ResponseEntity.badRequest().body(mensaje);
        }
        carreraUpdate = oCarrera.get();
        carreraUpdate.setCantidadAnios(carrera.getCantidadAnios());
        carreraUpdate.setCantidadMaterias(carrera.getCantidadMaterias());
        mensaje.put("datos", service.save(carreraUpdate));
        mensaje.put("success",Boolean.TRUE);
        return ResponseEntity.ok(mensaje);
    }

   /* @DeleteMapping("{id}")
    public void eliminarCarrera(@PathVariable Integer id){
        service.deleteById(id);
    }
*/
}
