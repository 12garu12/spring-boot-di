package com.bolsadeideas.springboot.di.app.models.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.Serializable;
import java.util.List;


/**
 * ALCANCE DE LOS COMPONENTES, EL SCOPE
 * Por defecto son del tipo Singleton mantendran una sola instancia de ese componente para toda la aplicacion
 * y se aplica a los diferentes componentes por ejemplo los controllers, components, services y se va a utilizar
 * en cada peticion  de los distintos clientes que esten usando la aplicacion.
 * Hay que tener cuidado y presente que cuando es singleton no se pueden tener atributos en el controlador que
 * sean propios del usuario ya que podrian ser modificados por otros usuarios por otras peticiones, la idea es que
 * todos estos objetos que inyectemos sean Stateless (sin estado) que no mantenga estado ni valores en los atributos
 * o informacion del usuario, como seria una sesion un carro de compras por ejemplo para eso se utiliza otro contexto
 * como del request o del tipo sesion.
 */
@Component
@RequestScope
public class Factura  implements Serializable {

    private static final long serialVersionUID = 946004357128146951L; // La interface Serializable nos pide generara un serialVersionUID siendo un identificador de la sesion

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
    public void inicializar() {
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
    public void destruir() {
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
