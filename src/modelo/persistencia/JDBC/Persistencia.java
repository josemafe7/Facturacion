
package modelo.persistencia.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Persistencia {
    
    private static String login = "usuario";
    private static String password = "clave";
    private static String url = "jdbc:mysql://localhost:3306/facturacion?serverTimezone=UCT";
    private static Connection conn = null;

    public static Connection createConnection() {

        if (conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection(url, login, password);
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            } catch (SQLException e) {
                System.out.println(e);
            } catch (java.lang.InstantiationException e) {
                System.out.println(e);
            } catch (java.lang.IllegalAccessException e) {
                System.out.println(e);
            }
        }
        return conn;
    }
    
    public static void closeConnection() {
        try {
            if(conn!=null){
                conn.close();
                conn=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
