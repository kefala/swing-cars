package com.degueLobo.app.Entities.Utils;

/**
 * Created by kefala on 21/09/16.
 */
public enum Colors {
    //clase estaticamente parametrizada :P

    RED(1, "Rojo"),
    BLACK(2, "Negro");

    private final Integer id;
    private final String name;

    Colors(Integer id, String name) {
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
