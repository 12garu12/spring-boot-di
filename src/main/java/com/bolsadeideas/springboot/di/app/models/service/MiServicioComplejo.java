package com.bolsadeideas.springboot.di.app.models.service;


//@Component("miServicioComplejo") // 1. Anotacion con un calificador para indicar el metodo a usar segun su calificador.
public class MiServicioComplejo implements IServicio {

    @Override // Anotacion que indica que es una implementacion o de un padre ya sea interface o clase
    public String operacion(){
        return "Ejecutando algún proceso importante complicado...";
    }

}
