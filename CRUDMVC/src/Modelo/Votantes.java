/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author PC-15
 */
public class Votantes {

    /**
     * @return the numero_documento
     */
    public String getNumero_documento() {
        return numero_documento;
    }

    /**
     * @param numero_documento the numero_documento to set
     */
    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the ciudad_origen
     */
    public String getCiudad_origen() {
        return ciudad_origen;
    }

    /**
     * @param ciudad_origen the ciudad_origen to set
     */
    public void setCiudad_origen(String ciudad_origen) {
        this.ciudad_origen = ciudad_origen;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    private String numero_documento;
    private String nombre;
    private String ciudad_origen;
    private String correo;
 }
