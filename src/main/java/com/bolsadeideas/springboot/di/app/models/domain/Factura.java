package com.bolsadeideas.springboot.di.app.models.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Factura {

    @Value("${factura.descripcion}") // Se define en application.properties
    private String descripcion;

    @Autowired
    private Cliente cliente;

    @Autowired //
 //   @Qualifier("itemsFacturaOficina") // la anotacion @Qualifier para cuando existen dos @Bean para la misma funcion. si el @Bean tiene la anotacion @Primary el contenedor sabra que @Bean aplicar
    private List<ItemFactura> items;



    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemFactura> getItems() {
        return items;
    }

    public void setItems(List<ItemFactura> items) {
        this.items = items;
    }
}
