package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;
import Modelo.Conexion;
import static java.lang.Integer.parseInt;


/**
 *
 * @author kygon
 */
public class ConsultasCandidatos{
    
    Conexion jdbc;
    
    public ConsultasCandidatos(){
        this.jdbc = new Conexion();
        this.jdbc.Hacer_Conexion();
    }
    
    // En esta clase se hace lo que corresponde al formulario frmCandidato.java
    public boolean registrar(Candidato can) {

        //Conexion con = getConexion();

        try{
           String sql = "INSERT INTO tbl_candidatos(nombre, documento, correo, telefono, direccion, partido_politico, propuestas, mensaje_campania, ciudad_origen) VALUES (?,?,?,?,?,?,?,?,?)";
           PreparedStatement ps = this.jdbc.conexion.prepareStatement(sql);
           ps.setString(1, can.getNombre());
           ps.setString(2, can.getDocumento());
           ps.setString(3, can.getCorreo());
           ps.setString(4, can.getTelefono());
           ps.setString(5, can.getDireccion());
           ps.setString(6, can.getPartido_politico());
           ps.setString(7, can.getPropuestas());
           ps.setString(8, can.getMensaje_campania());
           ps.setString(9, can.getCiudad_origen());
           ps.execute();
           return true;
        }catch(SQLException e){
           //System.err.println(e);
           JOptionPane.showMessageDialog(null,"Ocurrió un error en la base de datos");
           return false;
        
        } finally{
            try{
            jdbc.desconectar();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error en la conexión");
            }
        
        }

    }

    
    public boolean modificar(Candidato can) {
        
        Connection con = getConexion();

        try{
        String sql = "UPDATE tbl_candidatos SET documento=?, nombre=?, correo=?, telefono=?, direccion=?, partido_politico=?, propuestas=?, mensaje_campaña=?, descripcion=?, ciudad_origen=?"
                + "WHERE id=?";   
           PreparedStatement ps = this.jdbc.conexion.prepareStatement(sql);
           ps.setString(1, can.getDocumento());
           ps.setString(2, can.getNombre());
           ps.setString(3, can.getCorreo());
           ps.setString(4, can.getTelefono());
           ps.setString(5, can.getDireccion());
           ps.setString(6, can.getPartido_politico());
           ps.setString(7, can.getPropuestas());
           ps.setString(8, can.getMensaje_campania());
           ps.setString(9, can.getDescripcion());
           ps.setString(10, can.getCiudad_origen());
           ps.setInt(11, can.getId());
           ps.execute();
           return true;
        }catch(SQLException e){
           //System.err.println(e);
           JOptionPane.showMessageDialog(null, "Ocurrio un error en la BD");
           return false;
        
        } finally{
            try{
            con.close();
            }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error en la salida");
            }
        
        }

    }
    
   
    public boolean eliminar(Candidato can) {
        
        Connection con = getConexion();
        
        try{
           String sql = "DELETE FROM tbl_candidatos WHERE id=? ";
           PreparedStatement ps = this.jdbc.conexion.prepareStatement(sql);
           ps.setInt(1, can.getId());
           ps.execute();
           return true;
        }catch(SQLException e){
           //System.err.println(e);
           JOptionPane.showMessageDialog(null, "Ocurrió un error");
           return false;
        
        } finally{
            try{
            con.close();
            }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
            }
        
        }

    }
    
    
    public boolean buscar(Candidato can) {

        
        Connection con = getConexion();


        try {
            String sql = "SELECT * FROM tbl_candidatos WHERE documento=? ";
            PreparedStatement ps = this.jdbc.conexion.prepareStatement(sql);
            ResultSet rs = null;
            ps.setString(1, can.getDocumento());
            rs = ps.executeQuery();

            if (rs.next()) {
                can.setNombre(rs.getString("Nombre"));
                can.setTelefono(rs.getString("Telefono"));
                can.setDocumento(rs.getString("Documento"));
                can.setCorreo(rs.getString("Correo"));
                can.setCiudad_origen(rs.getString("Ciudad"));
                return true;
            }

            return false;

        } catch (SQLException e) {
            //System.err.println(e);
            JOptionPane.showMessageDialog(null, e);
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }

    }

    private Connection getConexion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
   
}
