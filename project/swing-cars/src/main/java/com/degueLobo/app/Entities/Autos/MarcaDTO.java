package com.degueLobo.app.Entities.Autos;

import com.degueLobo.app.Entities.DTO;

/**
 * Created by kefala on 23/9/16.
 */
public class MarcaDTO extends DTO {
    private String name;
    private String shortName;

    public MarcaDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
