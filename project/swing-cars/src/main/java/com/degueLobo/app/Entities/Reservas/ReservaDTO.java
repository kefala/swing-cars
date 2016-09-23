package com.degueLobo.app.Entities.Reservas;

import com.degueLobo.app.Entities.Autos.AutoDTO;
import com.degueLobo.app.Entities.DTO;
import com.degueLobo.app.Entities.Oficinas.OficinaDTO;
import com.degueLobo.app.Entities.Users.ClientDTO;
import com.degueLobo.app.Entities.Utils.Estados;

import java.util.Date;

/**
 * Created by kefala on 23/9/16.
 */
public class ReservaDTO extends DTO{
    private AutoDTO auto;
    private ClientDTO cliente;
    private OficinaDTO oficina;
    private Date inicio;
    private Date fin;
    private Estados estado;

    public ReservaDTO() {
    }

    public AutoDTO getAuto() {
        return auto;
    }

    public void setAuto(AutoDTO auto) {
        this.auto = auto;
    }

    public ClientDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClientDTO cliente) {
        this.cliente = cliente;
    }

    public OficinaDTO getOficina() {
        return oficina;
    }

    public void setOficina(OficinaDTO oficina) {
        this.oficina = oficina;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }
}
