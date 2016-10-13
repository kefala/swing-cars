package com.degueLobo.app.Entities.Autos;

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
public class MarcaDAO extends DAO<MarcaDTO>{

    public MarcaDAO(Connection conn)
    {
        super(conn, "marca");
    }

    @Override
    public List<MarcaDTO> getAll() throws SQLException
    {
        List<MarcaDTO> marcaList = new ArrayList<MarcaDTO>();
        PreparedStatement st = null;
        try
        {
            st = this.conn.prepareStatement("SELECT * FROM " + TABLE_NAME);
            st.executeQuery();
            try
            {
                //Should be only one
                ResultSet results = st.getResultSet();
                while(results.next())
                {
                    MarcaDTO marca = new MarcaDTO();
                    marca.setId(results.getInt(1));
                    marca.setName(results.getString(2));
                    marcaList.add(marca);
                }
                return marcaList;
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
    public MarcaDTO create(MarcaDTO model) throws SQLException
    {
        MarcaDTO newModel = null;
        PreparedStatement st = null;
        try
        {
            st = this.conn.prepareStatement("INSERT INTO " + TABLE_NAME + "(nombre_marca) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, model.getName());
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
    public void update(MarcaDTO model) throws SQLException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MarcaDTO find(Integer id) throws SQLException
    {
        MarcaDTO marca = null;
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
                    marca = new MarcaDTO();
                    marca.setId(results.getInt(1));
                    marca.setName(results.getString(2));
                }
                return marca;
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
