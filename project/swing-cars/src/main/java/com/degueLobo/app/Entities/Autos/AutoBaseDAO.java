/*Avis
Lobo/Degue*/

package com.degueLobo.app.Entities.Autos;

import com.degueLobo.app.Entities.DAO;
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
public class AutoBaseDAO extends DAO<AutoBaseDTO>{

    public AutoBaseDAO(Connection conn)
    {
        super(conn, "vehiculo_base");
    }

    @Override
    public List<AutoBaseDTO> getAll() throws SQLException
    {
        List<AutoBaseDTO> baseList = new ArrayList<AutoBaseDTO>();
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
                    ModelDTO model = new ModelDAO(conn).find(results.getInt(3));
                    if(model != null) {
                        AutoBaseDTO base = new AutoBaseDTO();
                        base.setId(results.getInt(1));
                        base.setDescripcion(results.getString(2));
                        base.setModel(model);
                        base.setColor(Colors.getById(results.getInt(4)));
                        baseList.add(base);
                    }
                }
                return baseList;
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
    public AutoBaseDTO create(AutoBaseDTO model) throws SQLException
    {
        AutoBaseDTO newModel = null;
        PreparedStatement st = null;
        try
        {
            st = this.conn.prepareStatement("INSERT INTO " + TABLE_NAME + "(descripcion, modelo, color) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, model.getDescripcion());
            st.setInt(2, model.getModel().getId());
            st.setInt(3, model.getColor().getId());
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
    public void update(AutoBaseDTO model) throws SQLException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AutoBaseDTO find(Integer id) throws SQLException
    {
        AutoBaseDTO base = null;
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
                    ModelDTO model = new ModelDAO(conn).find(results.getInt(3));
                    if(model != null) {
                        base = new AutoBaseDTO();
                        base.setId(results.getInt(1));
                        base.setDescripcion(results.getString(2));
                        base.setModel(model);
                        base.setColor(Colors.getById(results.getInt(4)));
                    }
                }
                return base;
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
