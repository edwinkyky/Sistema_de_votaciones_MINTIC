/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;
import Modelo.Conexion;
import static java.lang.Integer.parseInt;
/**
 *
 * @author PC-15
 */
public class RegistroVotantes {
    
     Conexion jdbc;
    
    public RegistroVotantes(){
        this.jdbc = new Conexion();
        this.jdbc.Hacer_Conexion();
    }
    
    // En esta clase se hace lo que corresponde al formulario frmVotante.java
    public boolean registrar(Votantes vot) {

        //Conexion con = getConexion();

        try{
           String sql = "INSERT INTO tbl_votante(nombre, documento, correo, ciudad_origen) VALUES (?,?,?,?)";
           PreparedStatement ps = this.jdbc.conexion.prepareStatement(sql);
           ps.setString(1, vot.getNombre());
           ps.setString(2, vot.getNumero_documento());
           ps.setString(3, vot.getCorreo());
           ps.setString(9, vot.getCiudad_origen());
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

    
    public boolean modificar(Votantes vot) {
        
        Connection con = getConexion();

        try{
        String sql = "UPDATE tbl_votante SET documento=?, nombre=?, correo=?, telefono=?, direccion=?, partido_politico=?, propuestas=?, mensaje_campaña=?, descripcion=?, ciudad_origen=?"
                + "WHERE id=?";   
           PreparedStatement ps = this.jdbc.conexion.prepareStatement(sql);
           ps.setString(1, vot.getNumero_documento());
           ps.setString(2, vot.getNombre());
           ps.setString(3, vot.getCorreo());
           ps.setString(10, vot.getCiudad_origen());
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
    
   
    public boolean eliminar(Votantes vot) {
        
        Connection con = getConexion();
        
        try{
           String sql = "DELETE FROM tbl_votante WHERE id=? ";
           PreparedStatement ps = this.jdbc.conexion.prepareStatement(sql);
           ps.setString(1, vot.getNumero_documento());
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
    
    
    public boolean buscar(Votantes vot) {

        
        Connection con = getConexion();


        try {
            String sql = "SELECT * FROM tbl_votante WHERE documento=? ";
            PreparedStatement ps = this.jdbc.conexion.prepareStatement(sql);
            ResultSet rs = null;
            ps.setString(1, vot.getNumero_documento());
            rs = ps.executeQuery();

            if (rs.next()) {
                vot.setNombre(rs.getString("Nombre"));
                vot.setNumero_documento(rs.getString("Documento"));
                vot.setCorreo(rs.getString("Correo"));
                vot.setCiudad_origen(rs.getString("Ciudad"));
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
