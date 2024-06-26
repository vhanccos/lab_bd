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
public class GanadoDietas {

    public static void main(String[] args) {
        /*
        CConexion objetoConexion = new CConexion();
        objetoConexion.estableceConexion();
        */
        try {
            UIManager.setLookAndFeel( new FlatMacLightLaf());
        } catch( Exception ex ) {
            System.err.println( "Fallo al inicializar" );
        }
        InterfazDietas form = new InterfazDietas();
        form.setVisible(true);
        
    }
    
    
}
