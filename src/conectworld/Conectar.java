  
package conectworld;

import java.sql.*;
import javax.swing.*;
public class Conectar{
    
     Connection conect = null;
    public Connection conexion()
        {
            try {
            
                Class.forName("com.mysql.jdbc.Driver");
              
                conect = DriverManager.getConnection("jdbc:mysql://localhost/conectWorld","Omar","123");
                System.out.println("conexion establecida");
                
                
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("error de conexion");
                JOptionPane.showMessageDialog(null,"Error de conexion"+e);
            }
            return conect;
        }

    PreparedStatement preparedStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void Insertar(String tabla, String nombreCliente, String apellidoPaterno,
            String apellidoMaterno, String telefonoCliente, String domicilio, String correo, String contraseña, String estado, String paquete, String pago){
        
        try{
            String Consulta="INSERT INTO " + tabla + "(nombreCliente, apellidoPaterno, apellidoMaterno, telefonoCliente, domicilio, correo, contraseña, estado, paquete, Pago) VALUES("
                    +"\"" + nombreCliente + "\", "
                    +"\"" + apellidoPaterno + "\", "
                    +"\"" + apellidoMaterno + "\", "
                    +"\"" + telefonoCliente + "\", "
                    +"\"" + domicilio + "\", "
                    +"\"" + correo + "\", "
                    +"\"" + contraseña + "\", "
                    +"\"" + estado + "\", "
                    +"\"" + paquete + "\", "
                    +"\"" + pago + "\")";
            Statement st= conect.createStatement();
            st.executeUpdate(Consulta);
            JOptionPane.showMessageDialog(null, "Datos Almacenados");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se almaceno");
        }
    }
    
}

