package com.bolsadeideas.springboot.di.app.models.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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

    /**
     * Se ejecuta despues de crear el objeto y de inyectar la dependencia de esta manera se pueden
     * modificar datos del componente o hacer algun proceso, inicializar recursos objetos, es parecido
     * a un constructor de un manera mas elegante todo esto despues de que se construye el
     * objeto por el contenedor de spring.
     */
    @PostConstruct
    public void inicializar(){
        cliente.setNombre(cliente.getNombre().concat(" ").concat("Jose"));
        descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre()).concat(" ").concat(cliente.getApellido());
    }

    /**
     * Segun el contexto el ciclo de vida del componente en el contenedor de spring por
     * defecto es Singleton una sola instancia y durara toda la aplicacion es decir hasta
     * que se baje la aplicacion del contenedor se haga un and deploy que es el por defecto
     * pero tambien se puede cambiar el contexto o el alcance de la entidad y el mensaje del
     * metodo con la anotacion @PostConstruct se mostrara en la consola cuando se pare o se baje
     * la aplicación del servidor, por ejemplo se pueden cerrar recursos que tenemos con esta anotacion.
     */
    @PreDestroy
    public void destruir(){
        System.out.println("Factura destruida: ".concat(descripcion));
    }

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
