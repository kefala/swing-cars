package com.degueLobo.app.Entities.Users;

import com.degueLobo.app.Entities.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by kefala on 17/09/16.
 */
public class UserDAO extends DAO<UserDTO> {
    private final String TABLE_NAME = "usuario";
    public UserDAO(Connection conn)
    {
        super(conn);
    }
    @Override
    public UserDTO create(UserDTO model) throws SQLException
    {
        PreparedStatement st = null;
        try
        {
            st = this.conn.prepareStatement("INSERT INTO " + TABLE_NAME + "(nombre_usuario, password, tipo_usuario) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, model.getUsername());
            st.setString(2, model.getPassword());
            st.setInt(3, model.getUserType());
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
        
        
        return model;
    }

    @Override
    public void delete(UserDTO model)
    {
        
    }

    @Override
    public List<UserDTO> getAll()
    {
        return null;
    }

    @Override
    public UserDTO find(Integer id)
    {
        return null;
    }

    @Override
    public void update(UserDTO model)
    {
        
    }

    @Override
    public Integer getLastId()
    {
        return null;
    }

    @Override
    public void deleteAll()
    {
        
    }


    @Override
    public String getTableName()
    {
        return TABLE_NAME;
    }
}
