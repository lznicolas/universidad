package com.universidad.universidadbackend.datos;

import com.universidad.universidadbackend.modelo.entidades.*;
import com.universidad.universidadbackend.modelo.entidades.enumeradores.TipoEmpleado;
import org.checkerframework.checker.units.qual.A;

import java.math.BigDecimal;

import static com.universidad.universidadbackend.modelo.entidades.enumeradores.TipoEmpleado.ADMINISTRATIVO;
import static com.universidad.universidadbackend.modelo.entidades.enumeradores.TipoEmpleado.MANTENIMIENTO;

public class DatosDummy {
    public static Carrera carrera01(boolean conId){
        Carrera carrera = (conId) ? new Carrera(1,"Ingenieria en Sistemas",50,5):
                new Carrera(null,"Ingenieria en Sistemas",50,5);
        return carrera;

    }
    public static Carrera carrera02(){
        return new Carrera(null,"Licenciatura en Sistemas",45,4);

    }
    public static Carrera carrera03(boolean conId){
        Carrera carrera = (conId) ? new Carrera(3,"Ingenieria Industrial",60,4) :
                new Carrera(null,"Ingenieria Industrial",60,5);
        return carrera;

    }

    public static Persona empleado01(){
        return new Empleado(null,"Lautaro","Lopez","25174036",new Direccion(),new BigDecimal("46570.70"), ADMINISTRATIVO);
    }

    public static Persona empleado02(){
        return new Empleado(null,"Leandro","Lopez","25174630",new Direccion(),new BigDecimal("46570.70"), MANTENIMIENTO);
    }

    public static Persona profesor01(){
        return new Profesor(null,"MArtin","Lugone","23456765",new Direccion(),new BigDecimal("60000.00"));

    }

    public static Persona alumno01(){
        return new Alumno(null,"Nicolas","Lamas","23443332",new Direccion());
    }
    public static Persona alumno02(){
        return new Alumno(null,"Noelea","Moyano","23444999",new Direccion());
    }
    public static Persona alumno03(){
        return new Alumno(null,"Juan","Lamas","23443456",new Direccion());
    }
}
