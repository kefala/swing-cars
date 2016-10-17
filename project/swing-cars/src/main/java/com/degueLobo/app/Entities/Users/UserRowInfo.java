/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Entities.Users;

import com.degueLobo.app.Entities.RowInfo;

/**
 *
 * @author mjdegue
 */
public class UserRowInfo extends RowInfo<UserDTO> {
    
    public UserRowInfo(UserDTO user) {
        super(user, null);
        //dos columnas vacias que seran boton de edicion y borrado. Pueden tener titulo igual.
        columnNames = new String[] {"Id", "Usuario", "rol", "", ""};
    }
    
    public Object[] getRowInfo()
    {
        return new Object[]{model.getId(), model.getUsername(), model.getRol().getName(), "", ""};
    }

    @Override
    public int getRowInfoSize() {
        return 5;
    }
    
}
