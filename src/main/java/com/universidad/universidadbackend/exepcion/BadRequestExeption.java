package com.universidad.universidadbackend.exepcion;


public class BadRequestExeption extends RuntimeException{

    public BadRequestExeption(String message) {
        super(message);
    }
}
