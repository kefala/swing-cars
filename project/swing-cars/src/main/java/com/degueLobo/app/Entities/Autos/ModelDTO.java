package com.degueLobo.app.Entities.Autos;

import com.degueLobo.app.Entities.DTO;

/**
 * Created by kefala on 23/9/16.
 */
public class ModelDTO extends DTO {
    private String name;
    private MarcaDTO marca;

    public ModelDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the marca
     */
    public MarcaDTO getMarca()
    {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(MarcaDTO marca)
    {
        this.marca = marca;
    }
}
