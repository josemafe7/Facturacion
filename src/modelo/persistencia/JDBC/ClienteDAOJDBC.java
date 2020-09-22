
package modelo.persistencia.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Cliente;
import modelo.entidades.ClienteImpl;
import modelo.persistencia.ClienteDAO;

public class ClienteDAOJDBC implements ClienteDAO{

    
    public Cliente read(String pk) {
        Cliente c = null;
        
        String sql = "SELECT * FROM clientes WHERE nombre = " + pk;
        
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery(sql);

            c = new ClienteImpl(res.getString("dni"),
                    res.getString("nombre"), res.getString("direccion"));

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Persistencia.closeConnection();
        }

        return c;
    }

    
    public void create(Cliente cliente) {
        String sql = "insert into clientes(dni,nombre,direccion) values (?,?,?)";
        
        try {
            PreparedStatement pstmt = Persistencia.createConnection().prepareStatement(sql);
            pstmt.setString(1, cliente.getDNI());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getDireccion());
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Persistencia.closeConnection();
        }
    }

    
    public void update(Cliente cliente) {
        String sql = "update clientes set nombre=?, direccion=? where dni LIKE ?";
        
        try {
            PreparedStatement pstmt = Persistencia.createConnection().prepareStatement(sql);
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getDireccion());
            pstmt.setString(3, cliente.getDNI());
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Persistencia.closeConnection();
        }
    }

    
    public void delete(Cliente cliente) {
        String sql = "delete from clientes where dni = ?";
        try {
            PreparedStatement pstmt = Persistencia.createConnection().prepareStatement(sql);
            pstmt.setString(1, cliente.getDNI());
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Persistencia.closeConnection();
        }
    }
    

    
    public List<Cliente> list() {
        List <Cliente> clientes = new ArrayList<Cliente>();
        
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM clientes");

            while (res.next()) {
                clientes.add(new ClienteImpl(res.getString("dni"),
                        res.getString("nombre"),
                        res.getString("direccion")));
            }
            res.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Persistencia.closeConnection();
        }

        return clientes;
    }
    
}
