/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ganadodietas;

import com.sun.tools.jconsole.JConsoleContext;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLOutput;
import java.sql.*;

/**
 * @author Usuario
 */
public class CConection {

    Connection conectar = null;
    String usuario = "root";
    String contrasena = "root";
    String bd = "dietasgranjas";
    String ip = "localhost";
    String puerto = "3306";

    String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd;

    public Connection estableceConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contrasena);
            JOptionPane.showMessageDialog(null, "Se conectó a la base de datos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se conectó a la base de datos, error: " + traducirError(e.toString()));
        }
        return conectar;
    }

    public String[] obtenerNombresColumnas(String tabla) {
        String[] columNames = new String[3];
        try (Connection conexion = DriverManager.getConnection(cadena, usuario, contrasena)) {
            String consulta = "SELECT * FROM `" + tabla + "`; "; // Reemplaza 'nombre_tabla' por el nombre de tu tabla
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(consulta);
            ResultSetMetaData metaData = resultSet.getMetaData();

            int cantidadColumnas = metaData.getColumnCount();
            System.out.println("Nombres de columnas:");

            for (int i = 1; i <= cantidadColumnas; i++) {
                String nombreColumna = metaData.getColumnName(i);
                columNames[i] = nombreColumna;
                System.out.println(nombreColumna);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columNames;
    }

    private String traducirError(String mensaje) {
        // Aquí puedes agregar más traducciones específicas según el tipo de error
        if (mensaje.contains("Access denied for user")) {
            return "Acceso denegado para el usuario. Verifique el usuario y la contraseña.";
        } else if (mensaje.contains("Communications link failure")) {
            return "Fallo en la comunicación con la base de datos. Verifique la conexión a la red.";
        } else if (mensaje.contains("Unknown database")) {
            return "Base de datos desconocida. Verifique el nombre de la base de datos.";
        } else {
            return mensaje; // Retornar el mensaje original si no se reconoce
        }
    }

}
