package com.degueLobo.app.Entities.Reservas;

import com.degueLobo.app.Entities.DTO;
import com.degueLobo.app.Entities.Oficinas.OficinaDTO;
import com.degueLobo.app.Entities.Users.ClientDTO;
import com.degueLobo.app.Entities.Utils.Estados;
import com.degueLobo.app.Managers.ApplicationManager;
import com.degueLobo.app.Managers.ConnectionManager;
import java.sql.SQLException;

import java.util.Date;
import java.util.List;
import javafx.application.Application;

/**
 * Created by kefala on 23/9/16.
 */
public class ReservaDTO extends DTO {
    private ClientDTO cliente;
    private OficinaDTO oficina;
    private Date inicio;
    private Date fin;
    private Estados estado;
    private List<ItemReservaDTO> itemsReserva;
    private String descripcion;
    private String comentarios;
    
    public ReservaDTO() {
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

    public List<ItemReservaDTO> getItemsReserva()
    {
        //Lazy load
        if(itemsReserva == null) {
            try{
                itemsReserva = new ItemReservaDAO(ConnectionManager.GetConnection()).findByReserva(this);
            }
            catch(SQLException e)
            {
                System.err.println("No se pudieron adquirir los items de la reserva.\n" + e.toString());
            }
        }
        return itemsReserva;
    }

    public void setItemsReserva(List<ItemReservaDTO> itemsReserva)
    {
        this.itemsReserva = itemsReserva;
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

    /**
     * @return the comentarios
     */
    public String getComentarios()
    {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(String comentarios)
    {
        this.comentarios = comentarios;
    }
}
