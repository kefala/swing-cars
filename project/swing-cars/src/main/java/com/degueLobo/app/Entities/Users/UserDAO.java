package com.degueLobo.app.Entities.Users;

import com.degueLobo.app.Entities.DAO;
import com.degueLobo.app.Entities.Utils.Roles;
import com.degueLobo.app.Managers.ErrorManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by kefala on 17/09/16.
 */
public class UserDAO extends DAO<UserDTO> {

    public UserDAO(Connection conn)
    {
        super(conn, "usuario");
    }

    @Override
    public UserDTO create(UserDTO model) throws SQLException
    {
        UserDTO newModel = null;
        PreparedStatement st = null;
        try {
            st = this.conn.prepareStatement("INSERT INTO " + TABLE_NAME + "(nombre_usuario, password, tipo_usuario) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, model.getUsername());
            st.setString(2, model.getPassword());
            st.setInt(3, model.getRol().getId());
            st.executeUpdate();
            try {
                ResultSet results = st.getGeneratedKeys();
                results.next();
                model.setId(results.getInt(1));
                newModel = model;
            }
            catch(SQLException e) {
                System.err.println("Couldn't retrieve user's id");
                throw e;
            }
        } catch (SQLException e) {
            System.err.println("Couldn't insert new user");
            throw e;
        }
        return newModel;
    }

    @Override
    public void update(UserDTO model) throws SQLException {

        PreparedStatement st = null;
        try
        {
            st = this.conn.prepareStatement("UPDATE " + TABLE_NAME + "(nombre_usuario, password, tipo_usuario) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, model.getUsername());
            st.setString(2, model.getPassword());
            st.setInt(3, model.getRol().getId());
            st.executeUpdate();
            try
            {
                ResultSet results = st.getGeneratedKeys();
                results.next();
                model.setId(results.getInt(1));
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

    public UserDTO find(Integer id) throws SQLException {
        return null;
    }
    
    public UserDTO GetUserIfValid(String userName, String password)
    {
        UserDTO user = null;
        try{
            PreparedStatement st = conn.prepareStatement("SELECT * FROM usuario WHERE nombre_usuario=(?) AND password=(?)");
            st.setString(1, userName);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if(rs.next()) //Should only retrieve one as nombre_usuario is unique
            {
                user = new UserDTO();
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setRol(Roles.getRolById(rs.getInt(4)));
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
        return user;
    }

    public List<UserDTO> getAdminAndVendedor() throws SQLException {
        PreparedStatement st = null;
        List<UserDTO> usersList = new ArrayList<UserDTO>();
        try {
            st = this.conn.prepareStatement("SELECT * FROM usuario WHERE usuario.tipo_usuario = 1 OR usuario.tipo_usuario = 2 LIMIT 200;");
            ResultSet results = st.executeQuery();
            results.next();
            while(results.next()){
                int tipo  = results.getInt("tipo_usuario");
                String nombre = results.getString("nombre_usuario");
                usersList.add(new UserDTO(nombre, Roles.getRolById(tipo)));
            }

        } catch (SQLException e) {
            System.err.println("Couldn't lists da users");
            throw e;
        }
        return usersList;
    }

    public List<UserDTO> getAll() throws SQLException {
        PreparedStatement st = null;
        List<UserDTO> usersList = new ArrayList<UserDTO>();
        try {
            st = this.conn.prepareStatement("SELECT * FROM usuario LIMIT 200;");
            ResultSet results = st.executeQuery();
            results.next();
            while(results.next()){
                int tipo  = results.getInt("tipo_usuario");
                String nombre = results.getString("nombre_usuario");
                usersList.add(new UserDTO(nombre, Roles.getRolById(tipo)));
            }
        } catch (SQLException e) {
            System.err.println("Couldn't lists da users");
            throw e;
        }
        return usersList;
    }

}
