package com.degueLobo.app.Entities.Users;

import com.degueLobo.app.Entities.DTO;

/**
 * Created by kefala on 17/09/16.
 */
public class UserDTO extends DTO {
    private String username;
    private String password;

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
