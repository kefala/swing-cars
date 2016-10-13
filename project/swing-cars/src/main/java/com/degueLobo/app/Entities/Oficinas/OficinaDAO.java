/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Entities.Oficinas;

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
public class OficinaDAO extends DAO<OficinaDTO>{

    public OficinaDAO(Connection conn)
    {
        super(conn, "oficina");
    }

    @Override
    public List<OficinaDTO> getAll() throws SQLException
    {
        List<OficinaDTO> ofiList = new ArrayList<OficinaDTO>();
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
                    OficinaDTO ofi = new OficinaDTO();
                    ofi.setId(results.getInt(1));
                    ofi.setNombre(results.getString(2));
                    ofiList.add(ofi);
                }
                return ofiList;
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
    public OficinaDTO create(OficinaDTO model) throws SQLException
    {
        OficinaDTO newModel = null;
        PreparedStatement st = null;
        try
        {
            st = this.conn.prepareStatement("INSERT INTO " + TABLE_NAME + "(nombre_oficina) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, model.getNombre());
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
    public void update(OficinaDTO model) throws SQLException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OficinaDTO find(Integer id) throws SQLException
    {
        OficinaDTO ofi = null;
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
                    ofi = new OficinaDTO();
                    ofi.setId(results.getInt(1));
                    ofi.setNombre(results.getString(2));
                }
                return ofi;
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
