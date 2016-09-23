package com.degueLobo.app.Entities.Autos;

import com.degueLobo.app.Entities.DTO;
import com.degueLobo.app.Entities.Oficinas.OficinaDTO;

/**
 * Created by kefala on 23/9/16.
 */
public class AutoDTO extends DTO{
    private AutoBaseDTO base;
    private String patente;
    private OficinaDTO oficinaActual;
    private Integer gasolina;

    public AutoDTO() {
    }

    public AutoBaseDTO getBase() {
        return base;
    }

    public void setBase(AutoBaseDTO base) {
        this.base = base;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public OficinaDTO getOficinaActual() {
        return oficinaActual;
    }

    public void setOficinaActual(OficinaDTO oficinaActual) {
        this.oficinaActual = oficinaActual;
    }

    public Integer getGasolina() {
        return gasolina;
    }

    public void setGasolina(Integer gasolina) {
        this.gasolina = gasolina;
    }
}
