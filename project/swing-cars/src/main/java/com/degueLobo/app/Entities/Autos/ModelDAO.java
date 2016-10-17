/*Avis
 Lobo/Degue*/

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
public class ModelDAO extends DAO<ModelDTO>{

    public ModelDAO(Connection conn)
    {
        super(conn, "modelo");
    }

    @Override
    public List<ModelDTO> getAll() throws SQLException
    {
        List<ModelDTO> modelList = new ArrayList<ModelDTO>();
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
                    MarcaDTO marca = new MarcaDAO(conn).find(results.getInt(3));
                    if(marca != null) {
                        ModelDTO model = new ModelDTO();
                        model.setId(results.getInt(1));
                        model.setName(results.getString(2));
                        model.setMarca(marca);
                        modelList.add(model);
                    }
                }
                return modelList;
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
    public ModelDTO create(ModelDTO model) throws SQLException
    {
        ModelDTO newModel = null;
        PreparedStatement st = null;
        try
        {
            st = this.conn.prepareStatement("INSERT INTO " + TABLE_NAME + "(nombre_modelo, marca) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, model.getName());
            st.setInt(2, model.getMarca().getId());
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
    public ModelDTO update(ModelDTO model) throws SQLException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModelDTO find(Integer id) throws SQLException
    {
        ModelDTO model = null;
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
                    MarcaDTO marca = new MarcaDAO(conn).find(results.getInt(3));
                    if(marca != null) {
                        model = new ModelDTO();
                        model.setId(results.getInt(1));
                        model.setName(results.getString(2));
                        model.setMarca(marca);
                    }
                }
                return model;
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
