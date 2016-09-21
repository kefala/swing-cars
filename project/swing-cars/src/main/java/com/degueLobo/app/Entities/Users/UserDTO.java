package com.degueLobo.app.Entities.Users;

import com.degueLobo.app.Entities.DTO;

/**
 * Created by kefala on 17/09/16.
 */
public class UserDTO extends DTO {
    private String username;
    private String password;
    private Integer userType;

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

    /**
     * @return the userType
     */
    public Integer getUserType()
    {
        return userType;
    }

    /**
     * @param userType the userType to set
     */
    public void setUserType(Integer userType)
    {
        this.userType = userType;
    }
    
}
