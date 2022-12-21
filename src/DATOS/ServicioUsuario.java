
package DATOS;

import static DATOS.CONEXION.conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ServicioUsuario {
    ResultSet rs;

    public void ListarUsuario(JTable tabla) {
        try {
            Connection cn = (Connection) conectar();
            DefaultTableModel m = new DefaultTableModel();
            m.addColumn("Codigo");
            m.addColumn("Nombre");
            m.addColumn("Apellido");
            m.addColumn("Dni");
            m.addColumn("Direccion");
            m.addColumn("Telefono");
            m.addColumn("Correo");
            m.addColumn("Sueldo");
            m.addColumn("Fecha de ingreso");

            tabla.setModel(m);

            PreparedStatement sql = cn.prepareStatement("select * from empleado");
            rs=sql.executeQuery();
            
            while (rs.next()) {                
                Object vector[]=new Object[9];
                vector[0]=rs.getObject(1);
                vector[1]=rs.getObject(2);
                vector[2]=rs.getObject(3);
                vector[3]=rs.getObject(4);
                vector[4]=rs.getObject(5);
                vector[5]=rs.getObject(6);
                vector[6]=rs.getObject(7);
                vector[7]=rs.getObject(8);
                vector[8]=rs.getObject(9);
                
                m.addRow(vector);
            }
                       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
}
