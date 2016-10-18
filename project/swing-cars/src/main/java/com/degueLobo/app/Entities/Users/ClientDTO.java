package com.degueLobo.app.Entities.Users;

import com.degueLobo.app.Entities.DTO;
import com.degueLobo.app.Entities.Utils.Roles;

/**
 * Created by kefala on 23/9/16.
 */
public class ClientDTO extends DTO {
    private String name;
    private String dni;
    private String telefono;
    private String direccion;
    private UserDTO user;

    public ClientDTO() {
        user = new UserDTO();
        user.setRol(Roles.CLIENTE);
    }

    public ClientDTO(String userName, String password, String nombre, String dni, String direccion, String telefono) {
        this.name = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.user = new UserDTO(userName, password, Roles.CLIENTE);
    }

    public ClientDTO(Integer id, UserDTO user, String nombre, String dni, String direccion, String telefono) {
        this.setId(id);
        this.name = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
