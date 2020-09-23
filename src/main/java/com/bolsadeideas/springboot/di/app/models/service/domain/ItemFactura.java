package com.bolsadeideas.springboot.di.app.models.service.domain;

public class ItemFactura {

    private Producto producto;
    private Integer cantidad;

/**  Constructores ****************************************************************************************************************/

    public ItemFactura(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

/**  Metodos getter and setter   ***********************************************************************************************************/

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
