package com.bolsadeideas.springboot.di.app.models.domain;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope // con esta anotacion el bean va a durar lo que dura una peticion http de usuario, cada usuario que se conecte va a tener una factura distinta y propia, si se modifica un valor no se altera no se modifica al reato.
public class Cliente { // con esta anotacion cuando se hace una peticion http el objeto se reconstruye en cada request y no una sola vez como es en singleton y es atomico y unico por cada peticion

    @Value("${cliente.nombre}") // Se define en application.properties
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
