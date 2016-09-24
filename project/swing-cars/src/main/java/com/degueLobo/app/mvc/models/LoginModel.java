/*Avis
Lobo/Degue*/

package com.degueLobo.app.mvc.models;

import com.degueLobo.app.Entities.Users.UserDAO;
import com.degueLobo.app.Entities.Users.UserDTO;
import com.degueLobo.app.Managers.ConnectionManager;
import com.degueLobo.app.mvc.Model;
import java.net.ConnectException;

/**
 *
 * @author mjdegue
 */
public class LoginModel extends Model{
    
    
    public boolean ConfirmLogin(String userName, String password){
        UserDTO user = null;
        try
        {
            UserDAO dao = new UserDAO(ConnectionManager.GetConnection());   
            user = dao.GetUserIfValid(userName, password);
        } catch (Exception e)
        {
        }
        return user != null;
    }
}
