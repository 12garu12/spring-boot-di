package com.bolsadeideas.springboot.di.app;


import com.bolsadeideas.springboot.di.app.models.service.IServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicioComplejo;
import com.bolsadeideas.springboot.di.app.models.service.domain.ItemFactura;
import com.bolsadeideas.springboot.di.app.models.service.domain.Producto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.List;

/**
 * Es importante que las clases con la anotacion @Configuration esten dentro
 * del package base o principal en este caso package com.bolsadeideas.springboot.di.app
 * tambien puede estar en un subpackage pero siempre dentro del contexto de spring.
 */
@Configuration
public class AppConfig {

    /**
     * Bean que registra en el contenedor de spring una instancia de la clase MiServicio.
     * @return una instancia de la clase MiServicio.
     */
    @Bean(name = "miServicioComplejo") // Con nombre para la anotacion @Qualifier en la inyeccion de dependencia en este caso en el controlador
    @Primary // Si en la inyección de dependencia no se especifica ninguna Anotacion @Qualifier la instancia de la inyección escogera el Bean anotado con la anotacion @Primary por defecto.
    public IServicio registrarMiServicio(){
        return new MiServicio();
    }

    /**
     * Bean que registra en el contenedor de spring una instancia de la clase MiServicioComplejo.
     * @return una instancia de la clase MiServicioComplejo.
     */
    @Bean(name = "miServicioComplejo")
    public IServicio regitrarMiServicioComplejo(){
        return new MiServicioComplejo();
    }

    @Bean("itemsFactura")
    public List<ItemFactura> registrarItems(){
        Producto producto1 = new Producto("Camara Sony", 100);
        Producto producto2 = new Producto("Bicicleta Bianchi aro 26", 200);

        ItemFactura linea1 = new ItemFactura(producto1, 2);
        ItemFactura linea2 = new ItemFactura(producto2, 4);

        return Arrays.asList(linea1, linea2);
    }

}
