package com.universidad.universidadbackend.modelo.entidades;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "carreras")
public class Carrera implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(nullable = false, unique = true, length = 80)
    private String nombre;
    @Column(name = "cantidad_materias")
    private Integer cantidadMaterias;
    @Column(name = "cantidad_anios")
    private Integer cantidadAnios;
    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;
    @Column(name = "fecha_modificaion")
    private LocalDateTime fechaModificacion;
    @OneToMany(
            mappedBy = "carrera",
            fetch = FetchType.LAZY
    )
    @JsonIgnoreProperties({"carrera"})
    private Set<Alumno> alumnos;
    @OneToMany(
            mappedBy = "carreras",
            fetch = FetchType.LAZY
    )
    @JsonIgnoreProperties({"carreras"})
    private Set<Profesor> profesores;
    public Carrera() {
    }

    public Carrera(Integer id, String nombre, Integer cantidadMaterias, Integer cantidadAnios) {
        Id = id;
        this.nombre = nombre;
        this.cantidadMaterias = cantidadMaterias;
        this.cantidadAnios = cantidadAnios;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadMaterias() {
        return cantidadMaterias;
    }

    public void setCantidadMaterias(Integer cantidadMaterias) {
        this.cantidadMaterias = cantidadMaterias;
    }

    public Integer getCantidadAnios() {
        return cantidadAnios;
    }

    public void setCantidadAnios(Integer cantidadAnios) {
        this.cantidadAnios = cantidadAnios;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Set<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }

    @PrePersist
    private void antesDePersistir(){
        this.fechaAlta = LocalDateTime.now();
    }

    @PreUpdate
    private void antesDeUpdate(){
        fechaModificacion = LocalDateTime.now();
    }


    @Override
    public String toString() {
        return "Carrera{" +
                "Id=" + Id +
                ", nombre='" + nombre + '\'' +
                ", cantidadMaterias=" + cantidadMaterias +
                ", cantidadAnios=" + cantidadAnios +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrera carrera = (Carrera) o;
        return Id.equals(carrera.Id) && nombre.equals(carrera.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, nombre);
    }
}
