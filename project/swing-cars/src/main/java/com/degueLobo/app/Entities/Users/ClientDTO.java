package com.degueLobo.app.Entities.Users;

import com.degueLobo.app.Entities.DTO;
import com.degueLobo.app.Entities.Utils.Roles;

/**
 * Created by kefala on 23/9/16.
 */
public class ClientDTO extends DTO {
    private String name;
    private Integer dni;
    private Integer telefono;
    private Integer direccion;
    private UserDTO user;

    public ClientDTO() {
        user = new UserDTO();
        user.setRol(Roles.CLIENTE);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getDireccion() {
        return direccion;
    }

    public void setDireccion(Integer direccion) {
        this.direccion = direccion;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
