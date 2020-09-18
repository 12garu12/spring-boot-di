package com.bolsadeideas.springboot.di.app;


import com.bolsadeideas.springboot.di.app.models.service.IServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicioComplejo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
}
