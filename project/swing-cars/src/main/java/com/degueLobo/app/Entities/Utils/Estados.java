package com.degueLobo.app.Entities.Utils;

/**
 * Created by kefala on 23/9/16.
 */
public enum Estados {
    RESERVADO(1, "Reservado"),
    EFECTUADO(2, "Efectuado"),
    CANCELADO(3, "Cancelado");

    private Integer id;
    private String name;

    Estados(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
