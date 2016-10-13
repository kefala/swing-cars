/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Entities.Autos;

import com.degueLobo.app.Entities.DAO;
import com.degueLobo.app.Entities.Oficinas.OficinaDAO;
import com.degueLobo.app.Entities.Oficinas.OficinaDTO;
import com.degueLobo.app.Entities.Utils.Colors;
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
public class AutoDAO extends DAO<AutoDTO>{

    public AutoDAO(Connection conn)
    {
        super(conn, "vehiculo");
    }

    @Override
    public List<AutoDTO> getAll() throws SQLException
    {
        List<AutoDTO> autoList = new ArrayList<AutoDTO>();
        PreparedStatement st = null;
        try
        {
            st = this.conn.prepareStatement("SELECT * FROM " + TABLE_NAME);
            st.executeQuery();
            try
            {
                //Should be only one
                ResultSet results = st.getResultSet();
                while(results.next()) {
                    AutoBaseDTO base = new AutoBaseDAO(conn).find(results.getInt(2));
                    //oficina can be null
                    OficinaDTO oficina = new OficinaDAO(conn).find(results.getInt(4));
                    if(base != null) {
                        AutoDTO auto = new AutoDTO();
                        auto.setId(results.getInt(1));
                        auto.setBase(base);
                        auto.setPatente(results.getString(3));
                        auto.setOficinaActual(oficina);
                        autoList.add(auto);
                    }
                }
                return autoList;
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

    @Override
    public AutoDTO create(AutoDTO model) throws SQLException
    {
        AutoDTO newModel = null;
        PreparedStatement st = null;
        try
        {
            st = this.conn.prepareStatement("INSERT INTO " + TABLE_NAME + "(base, patente, oficina_actual) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, model.getBase().getId());
            st.setString(2, model.getPatente());
            st.setInt(3, model.getOficinaActual().getId());
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
    public void update(AutoDTO model) throws SQLException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AutoDTO find(Integer id) throws SQLException
    {
        AutoDTO auto = null;
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
                    AutoBaseDTO base = new AutoBaseDAO(conn).find(results.getInt(2));
                    //oficina can be null
                    OficinaDTO oficina = new OficinaDAO(conn).find(results.getInt(4));
                    if(base != null) {
                        auto = new AutoDTO();
                        auto.setId(results.getInt(1));
                        auto.setBase(base);
                        auto.setPatente(results.getString(3));
                        auto.setOficinaActual(oficina);
                    }
                }
                return auto;
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
