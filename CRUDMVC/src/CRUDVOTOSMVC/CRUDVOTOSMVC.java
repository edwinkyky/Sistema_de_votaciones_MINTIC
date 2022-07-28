/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CRUDVOTOSMVC;

import Controlador.CtrlCandidatos;
import Modelo.*;
import Vista.*;



/**
 *
 * @author kygon
 */
public class CRUDVOTOSMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Candidato mod = new Candidato();
        ConsultasCandidatos modC = new ConsultasCandidatos();
        FrmCandidato frm = new FrmCandidato();
        FrmVotantes frmv = new FrmVotantes();
        
        CtrlCandidatos ctrl = new CtrlCandidatos(mod, modC, frm, frmv);    
        ctrl.iniciar();
        frm.setVisible(true);
    
    }
}
