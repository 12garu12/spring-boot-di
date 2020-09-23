package com.bolsadeideas.springboot.di.app.controllers;

import com.bolsadeideas.springboot.di.app.models.domain.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    private Factura factura;

    /**
     * Metodo que pasa una factura a una vista llamada ver.html.
     * @param model objeto el cual pasa la factura por medio de clave valor.
     * @return una vista ver.html.
     */
    @GetMapping("/ver")
    public String ver(Model model){
        model.addAttribute("factura", factura);
        model.addAttribute("titulo", "Ejemplo Factura con inyección de dependencia");
        return "factura/ver";
    }
}
