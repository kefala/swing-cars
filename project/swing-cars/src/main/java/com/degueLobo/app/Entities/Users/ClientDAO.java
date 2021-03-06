/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Entities.Users;

import com.degueLobo.app.Entities.DAO;
import com.degueLobo.app.Managers.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author mjdegue
 */
public class ClientDAO extends DAO<ClientDTO>{

    public ClientDAO(Connection conn)
    {
        super(conn, "cliente");
    }

    @Override
    public List<ClientDTO> getAll() throws SQLException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClientDTO create(ClientDTO model) throws SQLException
    {
        UserDAO userDao = new UserDAO(ConnectionManager.GetConnection());
        UserDTO newUser = userDao.create(model.getUser());
        ClientDTO newModel = null;
        
        if(newUser != null) {
            PreparedStatement st = null;
            try
            {
                st = this.conn.prepareStatement("INSERT INTO " + TABLE_NAME + "(nombre_usuario, nombre_completo, dni, direccion, telefono) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                st.setString(1, model.getUser().getUsername());
                st.setString(2, model.getName());
                st.setString(3, model.getDni());
                st.setString(4, model.getDireccion());
                st.setString(5, model.getTelefono());
                st.executeUpdate();
                try
                {
                    ResultSet rs = st.getGeneratedKeys();
                    rs.next();//Should exists only one.
                    model.setId(rs.getInt(1));
                    newModel = model;
                } catch (SQLException e)
                {
                    System.err.println("Couldn't retrieve client's id");
                    throw e;
                }
            } catch (SQLException e)
            {
                System.err.println("Couldn't insert new Client");
                throw e;
            }
        }
        return newModel;
    }

    @Override
    public void update(ClientDTO model) throws SQLException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClientDTO find(Integer id) throws SQLException
    {
        ClientDTO client = null;
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
                    client = new ClientDTO();
                    client.setId(results.getInt(1));
                    client.setName(results.getString(3));
                    client.setDni(results.getString(4));
                    client.setDireccion(results.getString(5));
                    client.setTelefono(results.getString(6));
                }
                return client;
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
