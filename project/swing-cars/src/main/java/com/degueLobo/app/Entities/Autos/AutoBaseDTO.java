package com.degueLobo.app.Entities.Autos;

import com.degueLobo.app.Entities.DTO;
import com.degueLobo.app.Entities.Utils.Colors;

/**
 * Created by kefala on 23/9/16.
 */
public class AutoBaseDTO extends DTO {
    private String descripcion;
    private ModelDTO model;
    private Colors color;

    public AutoBaseDTO() {
    }

    public ModelDTO getModel() {
        return model;
    }

    public void setModel(ModelDTO model) {
        this.model = model;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion()
    {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }
}
