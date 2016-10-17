/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Entities.Reservas;

import com.degueLobo.app.Entities.Autos.AutoDAO;
import com.degueLobo.app.Entities.Autos.AutoDTO;
import com.degueLobo.app.Entities.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mjdegue
 */
public class ItemReservaDAO extends DAO<ItemReservaDTO>{

    public ItemReservaDAO(Connection conn)
    {
        super(conn, "item_reserva");
    }

    @Override
    public List<ItemReservaDTO> getAll() throws SQLException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ItemReservaDTO create(ItemReservaDTO model) throws SQLException
    {
        ItemReservaDTO newModel = null;
        PreparedStatement st = null;
        try
        {
            st = this.conn.prepareStatement("INSERT INTO " + TABLE_NAME + "(id_reserva, id_vehiculo) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, model.getReserva().getId());
            st.setInt(2, model.getAuto().getId());
            st.executeUpdate();
            try
            {
                ResultSet results = st.getGeneratedKeys();
                results.next();
                model.setId(results.getInt(1));
                newModel = model;
            }
            catch(SQLException e)
            {
                System.err.println("Couldn't retrieve user's id");
                throw e;
            }
        } catch (SQLException e)
        {
            System.err.println("Couldn't insert new user");
            throw e;
        }
        return newModel;
    }

    @Override
    public ItemReservaDTO update(ItemReservaDTO model) throws SQLException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public ItemReservaDTO find(Integer id) throws SQLException
    {
        ItemReservaDTO itemReserva = null;
        PreparedStatement st = null;
        try
        {
            st = this.conn.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id = (?)");
            st.setInt(1, id);
            st.executeQuery();
            try
            {
                //Should be only one
                ResultSet results = st.getResultSet();
                if(results.next()) {
                    ReservaDTO reserva = new ReservaDAO(conn).find(results.getInt(2));
                    AutoDTO auto = new AutoDAO(conn).find(results.getInt(3));
                    if(auto != null && reserva != null)
                    {
                        itemReserva = new ItemReservaDTO();
                        itemReserva.setId(results.getInt(1));
                        itemReserva.setAuto(auto);
                        itemReserva.setReserva(reserva);
                    }
                }
                return itemReserva;
            }
            catch(SQLException e)
            {
                System.err.println("Couldn't retrieve user's id");
                throw e;
            }
        } catch (SQLException e)
        {
            System.err.println("Couldn't insert new user");
            throw e;
        }
    }
    
    public List<ItemReservaDTO> findByReserva(ReservaDTO reserva) throws SQLException
    {
        List<ItemReservaDTO> itemReservaList = new ArrayList<ItemReservaDTO>();
        PreparedStatement st = null;
        try
        {
            st = this.conn.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id_reserva = (?)");
            st.setInt(1, reserva.getId());
            st.executeQuery();
            try
            {
                //Should be only one
                ResultSet results = st.getResultSet();
                while(results.next()) {
                    AutoDTO auto = new AutoDAO(conn).find(results.getInt(3));
                    if(auto != null)
                    {
                        ItemReservaDTO itemReserva = new ItemReservaDTO();
                        itemReserva.setId(results.getInt(1));
                        itemReserva.setAuto(auto);
                        itemReserva.setReserva(reserva);
                        itemReservaList.add(itemReserva);
                    }
                }
                return itemReservaList;
            }
            catch(SQLException e)
            {
                System.err.println("Couldn't retrieve user's id");
                throw e;
            }
        } catch (SQLException e)
        {
            System.err.println("Couldn't insert new user");
            throw e;
        }
    }
}
