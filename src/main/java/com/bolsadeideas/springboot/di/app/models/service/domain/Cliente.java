package com.bolsadeideas.springboot.di.app.models.service.domain;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Cliente {

    @Value("${cliente.nombre") // Se define en application.properties
    private String nombre;

    @Value("${cliente.apellido}") // Se define en application.properties
    private String apellido;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}