package Modelo;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    String user = "root";
    String password = "";
    String base = "bd_elecciones";
    String url ="jdbc:mysql://localhost:3306/"+base;
    
    Connection conexion;

    public void Hacer_Conexion() {
        

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexion = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Ingresó a la base de datos");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No fue posible ingresar a la base de datos");
        }

    }

    public void desconectar(){
        try {
            
            this.conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion con la DB");
        }
    }
    
   /* 
    public static void main(String[] args) {
        Conexion con = new Conexion();

    }
*/
}