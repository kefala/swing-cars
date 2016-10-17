/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Entities.Reservas;

import com.degueLobo.app.Entities.DAO;
import com.degueLobo.app.Entities.Oficinas.OficinaDAO;
import com.degueLobo.app.Entities.Oficinas.OficinaDTO;
import com.degueLobo.app.Entities.Users.ClientDAO;
import com.degueLobo.app.Entities.Users.ClientDTO;
import com.degueLobo.app.Entities.Utils.Estados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mjdegue
 */
public class ReservaDAO extends DAO<ReservaDTO>{

    public ReservaDAO(Connection conn)
    {
        super(conn, "reserva");
    }

    @Override
    public List<ReservaDTO> getAll() throws SQLException
    {
        List<ReservaDTO> reservaList = new ArrayList<ReservaDTO>();
        PreparedStatement st = null;
        try
        {
            st = this.conn.prepareStatement("SELECT * FROM " + TABLE_NAME);
            st.executeQuery();
            try
            {
                //Should be only one
                ResultSet results = st.getResultSet();
                while(results.next()) {
                    ClientDTO client = new ClientDAO(conn).find(results.getInt(2));
                    OficinaDTO oficina = new OficinaDAO(conn).find(results.getInt(3));
                    if(oficina != null && client != null) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                        ReservaDTO reserva = new ReservaDTO();
                        reserva.setId(results.getInt(1));
                        reserva.setCliente(client);
                        reserva.setOficina(oficina);
                        reserva.setInicio(sdf.parse(results.getString(4)));
                        reserva.setFin(sdf.parse(results.getString(5)));
                        reserva.setEstado(Estados.getById(results.getInt(6)));
                        reserva.setComentarios(results.getString(7));
                        reserva.setDescripcion(results.getString(8));
                        reservaList.add(reserva);
                    }
                }
                return reservaList;
            }
            catch(SQLException e)
            {
                System.err.println("Couldn't retrieve user's id");
                throw e;
            }
            catch(ParseException pe)
            {
                System.err.println("No se pudo convertir la fecha de inicio o fin.");
            }
        } catch (SQLException e)
        {
            System.err.println("Couldn't insert new user");
            throw e;
        }
        return null;
    }

    @Override
    public ReservaDTO create(ReservaDTO model) throws SQLException
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        ReservaDTO newModel = null;
        PreparedStatement st = null;
        try
        {
            st = this.conn.prepareStatement("INSERT INTO " + TABLE_NAME + "(id_cliente, id_oficina, inicio, final, estado_reserva, descripcion, comentarios) VALUES (?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, model.getCliente().getId());
            st.setInt(2, model.getOficina().getId());
            st.setString(3, dateFormat.format(model.getInicio()));
            st.setString(4, dateFormat.format(model.getFin()));
            st.setInt(5, model.getEstado().getId());
            st.setString(6, model.getDescripcion());
            st.setString(7, model.getComentarios());
            st.executeUpdate();
            try
            {
                ResultSet results = st.getGeneratedKeys();
                results.next();
                model.setId(results.getInt(1));
                newModel = model;
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
        return newModel;
    }

    @Override
    public ReservaDTO update(ReservaDTO model) throws SQLException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReservaDTO find(Integer id) throws SQLException
    {
        ReservaDTO reserva = null;
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
                    ClientDTO client = new ClientDAO(conn).find(results.getInt(2));
                    OficinaDTO oficina = new OficinaDAO(conn).find(results.getInt(3));
                    if(oficina != null && client != null) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                        reserva = new ReservaDTO();
                        reserva.setId(results.getInt(1));
                        reserva.setCliente(client);
                        reserva.setOficina(oficina);
                        reserva.setInicio(sdf.parse(results.getString(4)));
                        reserva.setFin(sdf.parse(results.getString(5)));
                        reserva.setEstado(Estados.getById(results.getInt(6)));
                        reserva.setComentarios(results.getString(7));
                        reserva.setDescripcion(results.getString(8));
                    }
                }
                return reserva;
            }
            catch(SQLException e)
            {
                System.err.println("Couldn't retrieve user's id");
                throw e;
            }
            catch(ParseException pe)
            {
                System.err.println("No se pudo convertir la fecha de inicio o fin.");
            }
        } catch (SQLException e)
        {
            System.err.println("Couldn't insert new user");
            throw e;
        }
        return null;
    }

}
