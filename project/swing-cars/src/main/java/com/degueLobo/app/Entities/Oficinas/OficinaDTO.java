package com.degueLobo.app.Entities.Oficinas;

import com.degueLobo.app.Entities.DTO;

/**
 * Created by kefala on 23/9/16.
 */
public class OficinaDTO extends DTO {
    private String nombre;

    public OficinaDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
