package com.degueLobo.app.Entities.Utils;

/**
 * Created by kefala on 23/9/16.
 */
public enum Roles {
    //clase estaticamente parametrizada :P

    ADMINISTRADOR(1, "Administrador"),
    EMPLEADO(2, "Empleado"),
    CLIENTE(3, "Cliente");

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
    
    public static Roles getRolById(Integer i)
    {
        switch(i)
        {
            case 1:
                return ADMINISTRADOR;
            case 2:
                return EMPLEADO;
            case 3: 
                return CLIENTE;
            default:
                return null;
        }
    }
}
