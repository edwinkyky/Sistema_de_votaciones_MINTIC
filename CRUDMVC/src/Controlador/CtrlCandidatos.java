
package Controlador;

import Modelo.Candidato;
import Modelo.ConsultasCandidatos;
import Vista.FrmCandidato;
import Vista.FrmVotantes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class CtrlCandidatos implements ActionListener{
    
    private Candidato mod;
    private ConsultasCandidatos modC;
    private FrmCandidato frm;

    
    //Constructo
    
    public CtrlCandidatos(Candidato mod, ConsultasCandidatos modC, FrmCandidato frm){
        this.mod=mod;
        this.modC=modC;
        this.frm=frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.comboCiudad.addActionListener(this);
        this.frm.comboPartido.addActionListener(this);
    
    }

    public CtrlCandidatos(Candidato mod, ConsultasCandidatos modC, FrmCandidato frm, FrmVotantes frmv) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /*Iniciar la vista*/
    
    public void iniciar(){
        frm.setTitle("Candidatos");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if (e.getSource() == frm.btnGuardar) {
            mod.setNombre(frm.txtNombre.getText());
            mod.setDireccion(frm.txtDireccion.getText());
            mod.setCorreo(frm.txtEmail.getText());
            mod.setMensaje_campania(frm.txtMensaje.getText());
            mod.setPropuestas(frm.txtPropuesta.getText());
            mod.setTelefono(frm.txtTelefono.getText());
            mod.setPartido_politico(frm.comboPartido.getActionCommand());
            mod.setCiudad_origen(frm.comboCiudad.getActionCommand());
            mod.setDocumento(frm.txtIdentificacion.getText());

            if (modC.registrar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar(); //Llama al método limpiar()
            } else {
                JOptionPane.showMessageDialog(null, "Registro NO Guardado");
                limpiar(); //Llama al método limpiar()
            }
        }
        
        if (e.getSource() == frm.btnModificar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            mod.setNombre(frm.txtNombre.getText());
            mod.setDireccion(frm.txtDireccion.getText());
            mod.setCorreo(frm.txtEmail.getText());
            mod.setMensaje_campania(frm.txtMensaje.getText());
            mod.setPropuestas(frm.txtPropuesta.getText());
            mod.setTelefono(frm.txtTelefono.getText());
            mod.setPartido_politico(frm.comboPartido.getActionCommand());
            mod.setCiudad_origen(frm.comboCiudad.getActionCommand());
            mod.setDocumento(frm.txtIdentificacion.getText());

            if (modC.modificar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar(); //Llama al método limpiar()
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar(); //Llama al método limpiar()
            }
        }
        
        if (e.getSource() == frm.btnEliminar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            

            if (modC.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar(); //Llama al método limpiar()
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar(); //Llama al método limpiar()
            }

    }

        
   if (e.getSource() == frm.btnBuscar) {
            mod.setDocumento(frm.txtIdentificacion.getText());

            if (modC.buscar(mod)) {
                frm.txtId.setText(String.valueOf(mod.getId()));
                frm.txtNombre.setText(mod.getNombre());
                frm.txtTelefono.setText(mod.getTelefono());
                frm.txtEmail.setText(mod.getCorreo());
                frm.txtIdentificacion.setText(mod.getDocumento());
                
            }
                               
            else {
                JOptionPane.showMessageDialog(null, "Error al buscar");
                limpiar();
                
            }
        }
   
   if (e.getSource() == frm.btnLimpiar) {
       limpiar();
   }
    
    }
    public void limpiar(){ 
        frm.txtIdentificacion.setText(null);
        frm.txtNombre.setText(null);
        frm.txtDireccion.setText(null);
        frm.txtEmail.setText(null);
        frm.txtMensaje.setText(null);
        frm.txtPropuesta.setText(null);
        frm.txtTelefono.setText(null);
    }
 
    
}
