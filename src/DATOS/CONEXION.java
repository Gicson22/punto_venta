
package DATOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CONEXION {
    public static Connection conectar()throws ClassNotFoundException,SQLException
    {
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/edusistem","root","");
            return con;
        
    }
}
