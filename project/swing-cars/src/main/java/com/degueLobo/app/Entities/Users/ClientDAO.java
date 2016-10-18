/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Entities.Users;

import com.degueLobo.app.Entities.DAO;
import com.degueLobo.app.Entities.Utils.Roles;
import com.degueLobo.app.Managers.ConnectionManager;
import com.degueLobo.app.Managers.ErrorManager;

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
public class ClientDAO extends DAO<ClientDTO>{

    public ClientDAO(Connection conn)
    {
        super(conn, "cliente");
    }

    public List<ClientDTO> getAll() throws SQLException {
        List<ClientDTO> clientList = new ArrayList<ClientDTO>();
        try{
            PreparedStatement st = conn.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = st.executeQuery();
            while(rs.next()) //Should only retrieve one as nombre_usuario is unique
            {
                UserDAO userDao = new UserDAO(this.conn);
                UserDTO user = userDao.find(rs.getInt("id_usuario"));

                ClientDTO cliente = new ClientDTO();
                cliente.setId(rs.getInt(1));
                cliente.setDireccion(rs.getString("dirección"));
                cliente.setDni(rs.getString("dni"));
                cliente.setName(rs.getString("nombre_completo"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setUser(user);
                clientList.add(cliente);
            }
        }
        catch(SQLException e)
        {
            ErrorManager.PopupException(e);
        }
        finally
        {
            if(conn != null)
            {
                try
                {
                    conn.close();
                } catch (SQLException e)
                {
                    ErrorManager.PopupException(e);
                }
            }
        }
        return clientList;
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
                st = this.conn.prepareStatement("INSERT INTO " + TABLE_NAME + "(id_usuario, nombre_completo, dni, dirección, telefono) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                st.setInt(1, newUser.getId());
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
    public ClientDTO update(ClientDTO model) throws SQLException
    {
        PreparedStatement st = null;
        try
        {
            UserDAO userDao = new UserDAO(this.conn);
            UserDTO user = userDao.find(model.getUser().getId());
            model.setUser(user);

            st = this.conn.prepareStatement("UPDATE " + TABLE_NAME + " SET nombre_completo = (?), dni = (?), dirección = (?), telefono = (?) WHERE id = (?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, model.getName());
            st.setString(2, model.getDni());
            st.setString(3, model.getDireccion());
            st.setString(4, model.getTelefono());
            st.setInt(5, model.getId());


            int affectedRows = st.executeUpdate();
            if (affectedRows == 1) {
                return model;
            }
        } catch (SQLException e)
        {
            System.err.println("Couldn't insert new user");
            throw e;
        }
        return null;
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
