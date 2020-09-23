package com.bolsadeideas.springboot.di.app.models.domain;

public class Producto {

    private String nombre;
    private Integer precio;

    /**  Constructores ****************************************************************************************************************/

    public Producto(String nombre, Integer precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    /**  Metodos getter and setter   ***********************************************************************************************************/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
}
