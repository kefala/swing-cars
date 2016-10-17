package com.degueLobo.app.Entities.Users;

import com.degueLobo.app.Entities.DTO;
import com.degueLobo.app.Entities.Utils.Roles;

/**
 * Created by kefala on 17/09/16.
 */
public class UserDTO extends DTO {
    private String username;
    private String password;
    private Roles rol;

    public UserDTO() {
    }

    public UserDTO(Integer id, String user, String pass, Roles rol) {
        this.setId(id);
        this.username = user;
        this.password = pass;
        this.rol = rol;
    }

    public UserDTO(String user, String pass, Roles rol) {
        this.username = user;
        this.password = pass;
        this.rol = rol;
    }

    public UserDTO(String user, Roles rol) {
        this.username = user;
        this.rol = rol;
    }

    public UserDTO(String user) {
        this.username = user;
    }

    /**
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }
}
