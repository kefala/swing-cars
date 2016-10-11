/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Entities.Reservas;

import com.degueLobo.app.Entities.Autos.AutoDTO;
import com.degueLobo.app.Entities.DTO;

/**
 *
 * @author mjdegue
 */
public class ItemReservaDTO extends DTO{
    private AutoDTO auto;
    private ReservaDTO reserva;
    /**
     * @return the auto
     */
    public AutoDTO getAuto()
    {
        return auto;
    }

    /**
     * @param auto the auto to set
     */
    public void setAuto(AutoDTO auto)
    {
        this.auto = auto;
    }

    /**
     * @return the reserva
     */
    public ReservaDTO getReserva()
    {
        return reserva;
    }

    /**
     * @param reserva the reserva to set
     */
    public void setReserva(ReservaDTO reserva)
    {
        this.reserva = reserva;
    }
}
