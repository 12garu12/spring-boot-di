package com.bolsadeideas.springboot.di.app.controllers;


import com.bolsadeideas.springboot.di.app.service.IServicio;
import com.fasterxml.jackson.databind.ser.impl.IteratorSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private IServicio servicio;

    @Autowired // La anotacion para inyeccion de dependecia via constructor.
    public IndexController(IServicio servicio){
        this.servicio = servicio;
    }

    @GetMapping({"", "/", "/index"})
    public String index(Model model){
        model.addAttribute("objeto", servicio.operacion());
        return "index";
    }

}
