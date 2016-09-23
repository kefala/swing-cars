package com.degueLobo.app.Entities.Utils;

/**
 * Created by kefala on 23/9/16.
 */
public enum Roles {
    //clase estaticamente parametrizada :P

    CLIENTE(1, "Cliente"),
    EMPLEADO(2, "Empleado"),
    ADMINISTRADOR(3, "Administrador");

    private final Integer id;
    private final String name;

    Roles(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
