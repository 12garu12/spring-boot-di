package com.bolsadeideas.springboot.di.app.controllers;


import com.bolsadeideas.springboot.di.app.service.IServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired // La anotacion para inyeccion de dependecia via atributo y un calificador
    @Qualifier("miServicioSimple")  /*  Cuando hay varios beans del mismo tipo, es una buena idea usar @Qualifier para evitar ambigüedades.*/
    private IServicio servicio;

    @GetMapping({"", "/", "/index"})
    public String index(Model model){
        model.addAttribute("objeto", servicio.operacion());
        return "index";
    }

}
