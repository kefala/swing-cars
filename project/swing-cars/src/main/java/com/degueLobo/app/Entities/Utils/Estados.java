package com.degueLobo.app.Entities.Utils;

/**
 * Created by kefala on 23/9/16.
 */
public enum Estados {
    RESERVADO(1, "Reservado"),
    CANCELADO(2, "Cancelado"),
    RETIRADO(3, "Retirado"),
    DEVUELTO(4, "Devuelto"),
    BORRADOR(5, "Borrador");

    private Integer id;
    private String name;

    Estados(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return the id
     */
    public Integer getId()
    {
        return id;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }
    
    public static Estados getById(int id){
        switch(id) {
            case 1:
                return RESERVADO;
            case 2:
                return CANCELADO;
            case 3:
                return RETIRADO;
            case 4:
                return DEVUELTO;
            case 5:
                return BORRADOR;
            default:
                return null;
        }
    }
}
