/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ganadodietas;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.UIManager;
/**
 *
 * @author Usuario
 */
//========================LIBRERIAS TEMPORALES 


import javax.swing.UIManager;

public class GanadoDietas {

    public static void main(String[] args) {
        /*
        CConexion objetoConexion = new CConexion();
        objetoConexion.estableceConexion();
         */
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (Exception ex) {
            System.err.println("Fallo al inicializar");
        }
        InterfazDietas form = new InterfazDietas();
        InterfazControl form2 = new InterfazControl();
        form.setVisible(true);
        form2.setVisible(true);

        //============================
        
    }

}
