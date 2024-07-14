/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ganadodietas;

import java.awt.Color;
import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

import java.util.*;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Usuario
 */
public class CTabla {

    String id;
    String desc;
    String estReg;
    String nombColumId;
    String nombColumDesc;
    String nombColumEstReg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getEstReg() {
        return estReg;
    }

    public void setEstReg(String estReg) {
        this.estReg = estReg;
    }

    public void Insertar(String nombTabla, JTextField id, JTextField desc, JTextField estReg, JTextField flagField) {
        if (!flagField.getText().equals("1")) {
            JOptionPane.showMessageDialog(null, "No se necesita actualización.");
            return;
        }

        List<String> columns = GanadoDietasData.getColumnsForTable(nombTabla.toLowerCase());
        if (columns == null) {
            JOptionPane.showMessageDialog(null, "Tabla no encontrada: " + nombTabla);
            return;
        }

        String idColumn = getIdColumn(columns);
        String estRegColumn = getEstRegColumn(columns);
        System.err.println(idColumn + "," + estRegColumn);
        // Ensure 'idColumn' is the first column and 'estRegColumn' is the last column
        // Create a copy of columns to modify
        List<String> columnsCopy = new ArrayList<>(columns);

        // Ensure 'idColumn' is the first column and 'estRegColumn' is the last column
        columnsCopy.remove(idColumn);
        columnsCopy.remove(estRegColumn);
        columnsCopy.add(0, idColumn);
        columnsCopy.add(estRegColumn);

        String columnNames = String.join(", ", columns);
        String placeholders = String.join(", ", Collections.nCopies(columnsCopy.size(), "?"));
        String query = "INSERT INTO `" + nombTabla + "` (" + columnNames + ") VALUES (" + placeholders + ");";
        System.out.println(query);

        try {
            CConection conexion = new CConection();
            CallableStatement cs = conexion.estableceConexion().prepareCall(query);

            String[] descValues = desc.getText().split(", ");
            Map<String, String> descMap = new HashMap<>();
            for (int i = 0; i < descValues.length; i++) {
                descMap.put(columns.get(i + 1), descValues[i]); // Skip the id column
            }
            // Set parameters dynamically based on column names
            int index = 1;
            for (String column : columnsCopy) {
                if (column.equals(idColumn)) {
                    cs.setString(index++, id.getText());
                } else if (descMap.containsKey(column)) {
                    cs.setString(index++, descMap.get(column));
                } else if (column.equals(estRegColumn)) {
                    cs.setString(index++, estReg.getText());
                } else {
                    // Handling any other columns as placeholders
                    cs.setString(index++, ""); // Empty string for other columns as placeholder
                }
            }
            System.out.println(cs);
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar: " + traducirError(e.toString()));
        }
    }

    //======================
    private String getIdColumn(List<String> columns) {
        // Find the column that ends with "Cod"
        for (String column : columns) {
            if (column.endsWith("Cod")) {
                return column;
            }
        }
        return null;
    }

    private String getEstRegColumn(List<String> columns) {
        // Find the column that ends with "EstReg"
        for (String column : columns) {
            if (column.endsWith("EstReg")) {
                return column;
            }
        }
        return null;
    }

    //====================== Corregir cabecera  de  tablas 
    public void Mostrar(JTable tabla, String nomTabla) {
        CConection conexion = new CConection();

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        TableRowSorter<TableModel> OrdTabla = new TableRowSorter<TableModel>(modelo);
        tabla.setRowSorter(OrdTabla);

        String consulta = "SELECT * FROM `" + nomTabla + "`;";

        Statement st;

        try {
            st = conexion.estableceConexion().createStatement();
            ResultSet rs = st.executeQuery(consulta);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                modelo.addColumn(metaData.getColumnLabel(i));
            }

            // Añadir filas
            while (rs.next()) {
                Object[] fila = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    fila[i - 1] = rs.getObject(i);
                }
                modelo.addRow(fila);
            }

            /*if (nomTabla.equals("FECHA INICIO")) {
                while (rs.next()) {
                    System.out.println("pasando");
                    // se crea un arreglo para poder guardar la fecha y despues juntarla para mostrarla
                    String[] fecha = new String[3];
                    fecha[0] = rs.getString(2);
                    fecha[1] = rs.getString(3);
                    fecha[2] = rs.getString(4);
                    // se ingresan los datos

                }
            } else {
                while (rs.next()) {
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                    datos[2] = rs.getString(3);
                    modelo.addRow(datos);
                }
            }**/
            // Crear y asignar un renderizador personalizado
            tabla.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar correctamente: " + traducirError(e.toString()));
        }
    }

    class CustomTableCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            String estado = (String) table.getValueAt(row, table.getColumnCount() - 1); // Asume que la última columna es "Estado"
            if (isSelected) {
                c.setBackground(Color.cyan);
                c.setForeground(Color.WHITE);
            } else {
                if (estado.equals("*")) {
                    c.setForeground(Color.GRAY);
                } else {
                    c.setForeground(table.getForeground());
                }

                if (estado.equals("I")) {
                    c.setBackground(Color.YELLOW);
                } else {
                    c.setBackground(table.getBackground());
                }
            }

            return c;
        }
    }

    public void Seleccionar(JTable tabla, JTextField id, JTextField desc, JTextField estReg, JTextField flagField) {
        try {
            int fila = tabla.getSelectedRow();
            flagField.setText("1");
            if (fila >= 0) {

                if (tabla.getColumnCount() - 1 > 4) {

                    id.setText((tabla.getValueAt(fila, 0).toString()));
                    desc.setText((tabla.getValueAt(fila, 1).toString()) + "-" + (tabla.getValueAt(fila, 2).toString()) + "-" + (tabla.getValueAt(fila, 3).toString()));
                    estReg.setText((tabla.getValueAt(fila, tabla.getColumnCount() - 1).toString()));
                } else {

                    id.setText((tabla.getValueAt(fila, 0).toString()));
                    desc.setText((tabla.getValueAt(fila, 1).toString()));
                    estReg.setText((tabla.getValueAt(fila, tabla.getColumnCount() - 1).toString()));
                }

            } else {
                JOptionPane.showMessageDialog(null, "No se pudo seleccionar la fila ");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo seleccionar la fila: " + traducirError(e.toString()));
        }

    }

    public void Modificar(String nomTabla, JTextField id, JTextField desc, JTextField estReg, JTextField flagField) {
        if (flagField.getText().equals("1")) {
            CConection conexion = new CConection();

            setEstReg(id.getText());
            setDesc(desc.getText());
            setDesc(estReg.getText());
            // UPDATE PAIS SET PaiDes = ? WHERE PaiCod = ?;
            String getTablas = "SELECT GROUP_CONCAT(COLUMN_NAME) AS columnas\n"
                    + "FROM information_schema.COLUMNS\n"
                    + "WHERE TABLE_SCHEMA = 'dietasgranjas'\n"
                    + "AND TABLE_NAME = '" + nomTabla + "';";
            String datos[] = new String[5];
            Statement st;
            try {
                st = conexion.estableceConexion().createStatement();
                ResultSet rs = st.executeQuery(getTablas);
                String colums = "";
                while (rs.next()) {
                    colums = rs.getString(1);
                }
                datos = colums.split(",");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se encontro correctamente: " + traducirError(e.toString()));

            }
            //String consulta = "UPDATE PAIS SET PaiDes = ? WHERE PaiCod = ?;";

            if (nomTabla.equals("FECHA INICIO")) {
                String consulta = "UPDATE `" + nomTabla + "` SET " + datos[1] + " = ?," + datos[2] + " = ?," + datos[3] + " = ? WHERE " + datos[0] + " = ?;";
                System.out.println(consulta);

                try {
                    String dia, mes, anyo;
                    desc.setText(desc.getText().trim());
                    System.out.println("hola");
                    if (desc.getText().length() == 8) {
                        System.out.println("8");
                        dia = desc.getText().substring(0, 2);
                        mes = desc.getText().substring(3, 5);
                        anyo = desc.getText().substring(6, 8);

                    } else if (desc.getText().length() == 7) {
                        System.out.println("7");
                        if (desc.getText().charAt(1) == '-') {
                            dia = desc.getText().substring(0, 1);
                            mes = desc.getText().substring(2, 4);
                            anyo = desc.getText().substring(5, 7);
                        } else {
                            dia = desc.getText().substring(0, 2);
                            mes = desc.getText().substring(3, 4);
                            anyo = desc.getText().substring(5, 7);
                        }
                    } else {
                        System.out.println("6");
                        dia = desc.getText().substring(0, 1);
                        mes = desc.getText().substring(2, 3);
                        anyo = desc.getText().substring(4, 6);
                    }

                    System.out.println(desc.getText());
                    CallableStatement cs = conexion.estableceConexion().prepareCall(consulta);
                    cs.setString(1, dia);
                    cs.setString(2, mes);
                    cs.setString(3, anyo);
                    cs.setString(4, id.getText());
                    cs.execute();
                    JOptionPane.showMessageDialog(null, "Se modificó correctamente");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se elimino correctamente: " + traducirError(e.toString()));
                }

            } else {
                String consulta = "UPDATE `" + nomTabla + "` SET " + datos[1] + " = ? WHERE " + datos[0] + " = ?;";
                System.out.println(consulta);
                try {
                    CallableStatement cs = conexion.estableceConexion().prepareCall(consulta);
                    cs.setString(1, desc.getText());
                    cs.setString(2, id.getText());
                    cs.execute();
                    JOptionPane.showMessageDialog(null, "Se modificó correctamente");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se elimino correctamente: " + traducirError(e.toString()));
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se necesita actualización.");
        }

    }

    public void Eliminar(String nomTabla, JTextField id, JTextField desc, JTextField estReg, JTextField flagField) {
        if (flagField.getText().equals("1")) {

            setEstReg(id.getText());
            setDesc(desc.getText());
            setDesc(estReg.getText());
            CConection conexion = new CConection();
            // UPDATE PAIS SET PaiDes = ? WHERE PaiCod = ?;

            //OBTENER TABLAS
            String getTablas = "SELECT GROUP_CONCAT(COLUMN_NAME) AS columnas\n"
                    + "FROM information_schema.COLUMNS\n"
                    + "WHERE TABLE_SCHEMA = 'dietasgranjas'\n"
                    + "AND TABLE_NAME = '" + nomTabla + "';";
            String datos[] = new String[3];
            Statement st;
            try {
                st = conexion.estableceConexion().createStatement();
                ResultSet rs = st.executeQuery(getTablas);
                String colums = "";
                while (rs.next()) {
                    colums = rs.getString(1);
                }
                datos = colums.split(",");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se encontro correctamente: " + traducirError(e.toString()));
            }

            // Actualización lógica del registro en la tabla principal
            String consulta = "UPDATE `" + nomTabla + "` SET " + datos[datos.length - 1] + " = '*' WHERE " + datos[0] + " = ?;";
            try {
                CallableStatement cs = conexion.estableceConexion().prepareCall(consulta);
                cs.setString(1, id.getText());
                cs.execute();
                JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
                actualizarEnCascada(conexion, nomTabla, id.getText(), datos[0]);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se elimino correctamente: " + traducirError(e.toString()));
            }

        } else {
            JOptionPane.showMessageDialog(null, "No se necesita actualización.");
        }

    }

    //--------------------------------------------
    private void actualizarEnCascada(CConection conexion, String nomTabla, String id, String primaryKey) {
        // Obtener las tablas relacionadas
        String getRelacionadas = "SELECT TABLE_NAME, COLUMN_NAME "
                + "FROM information_schema.KEY_COLUMN_USAGE "
                + "WHERE REFERENCED_TABLE_SCHEMA = 'dietasgranjas' "
                + "AND REFERENCED_TABLE_NAME = '" + nomTabla + "';";

        try {
            Statement st = conexion.estableceConexion().createStatement();
            ResultSet rs = st.executeQuery(getRelacionadas);
            while (rs.next()) {
                String tablaRelacionada = rs.getString("TABLE_NAME");
                String columnaRelacionada = rs.getString("COLUMN_NAME");

                // Obtener el nombre de la última columna (asumiendo que es el estado)
                String getLastColumn = "SELECT COLUMN_NAME FROM information_schema.COLUMNS "
                        + "WHERE TABLE_SCHEMA = 'dietasgranjas' AND TABLE_NAME = '" + tablaRelacionada + "' "
                        + "ORDER BY ORDINAL_POSITION DESC LIMIT 1;";

                Statement stLastColumn = conexion.estableceConexion().createStatement();
                ResultSet rsLastColumn = stLastColumn.executeQuery(getLastColumn);
                if (rsLastColumn.next()) {
                    String estadoColumn = rsLastColumn.getString("COLUMN_NAME");

                    // Actualización lógica en la tabla relacionada
                    String consultaRelacionada = "UPDATE `" + tablaRelacionada + "` SET `" + estadoColumn + "` = '*' WHERE " + columnaRelacionada + " = ?;";

                    try {
                        CallableStatement cs = conexion.estableceConexion().prepareCall(consultaRelacionada);
                        cs.setString(1, id);
                        cs.execute();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "No se actualizó correctamente en la tabla relacionada " + tablaRelacionada + ": " + traducirError(e.toString()));
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo obtener las tablas relacionadas: " + traducirError(e.toString()));
        }
    }

    //--------------------------------------------------------
    public void Reactivar(String nomTabla, JTextField id, JTextField desc, JTextField estReg, JTextField flagField) {
        if (flagField.getText().equals("1")) {

            setEstReg(id.getText());
            setDesc(desc.getText());
            setDesc(estReg.getText());
            CConection conexion = new CConection();
            // UPDATE PAIS SET PaiDes = ? WHERE PaiCod = ?;
            String getTablas = "SELECT GROUP_CONCAT(COLUMN_NAME) AS columnas\n"
                    + "FROM information_schema.COLUMNS\n"
                    + "WHERE TABLE_SCHEMA = 'dietasgranjas'\n"
                    + "AND TABLE_NAME = '" + nomTabla + "';";
            String datos[] = new String[3];
            Statement st;
            try {
                st = conexion.estableceConexion().createStatement();
                ResultSet rs = st.executeQuery(getTablas);
                String colums = "";
                while (rs.next()) {
                    colums = rs.getString(1);
                }
                datos = colums.split(",");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se encontro correctamente: " + traducirError(e.toString()));
            }
            if (nomTabla.equals("FECHA INICIO")) {
                String consulta = "UPDATE `" + nomTabla + "` SET " + datos[4] + " = 'A' WHERE " + datos[0] + " = ?;";
                try {
                    CallableStatement cs = conexion.estableceConexion().prepareCall(consulta);
                    cs.setString(1, id.getText());
                    cs.execute();
                    JOptionPane.showMessageDialog(null, "Se reactivó correctamente");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se reactivo correctamente: " + traducirError(e.toString()));
                }

            } else {
                String consulta = "UPDATE `" + nomTabla + "` SET " + datos[2] + " = 'A' WHERE " + datos[0] + " = ?;";
                try {
                    CallableStatement cs = conexion.estableceConexion().prepareCall(consulta);
                    cs.setString(1, id.getText());
                    cs.execute();
                    JOptionPane.showMessageDialog(null, "Se reactivó correctamente");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se reactivo correctamente: " + traducirError(e.toString()));
                }

            }
            actualizarEnCascada2(conexion, nomTabla, id.getText(), datos[0]);

        } else {
            JOptionPane.showMessageDialog(null, "No se necesita actualización.");
        }

    }

    public void Inactivar(String nomTabla, JTextField id, JTextField desc, JTextField estReg, JTextField flagField) {
        if (flagField.getText().equals("1")) {

            setEstReg(id.getText());
            setDesc(desc.getText());
            setEstReg(estReg.getText());
            CConection conexion = new CConection();
            String getTablas = "SELECT GROUP_CONCAT(COLUMN_NAME) AS columnas\n"
                    + "FROM information_schema.COLUMNS\n"
                    + "WHERE TABLE_SCHEMA = 'dietasgranjas'\n"
                    + "AND TABLE_NAME = '" + nomTabla + "';";
            System.out.println(getTablas);
            String datos[] = new String[3];
            Statement st;
            try {
                st = conexion.estableceConexion().createStatement();
                ResultSet rs = st.executeQuery(getTablas);
                String colums = "";
                while (rs.next()) {
                    colums = rs.getString(1);
                }
                datos = colums.split(",");

            } catch (Exception e) {
                e.printStackTrace();
            }
            if (nomTabla.equals("FECHA INICIO")) {
                String consulta = "UPDATE `" + nomTabla + "` SET " + datos[4] + " = 'I' WHERE " + datos[0] + " = ?;";
                try {
                    CallableStatement cs = conexion.estableceConexion().prepareCall(consulta);
                    cs.setString(1, id.getText());
                    cs.execute();
                    JOptionPane.showMessageDialog(null, "Se inactivó correctamente");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se inactivó correctamente: " + e.toString());
                }

            } else {
                String consulta = "UPDATE `" + nomTabla + "` SET " + datos[2] + " = 'I' WHERE " + datos[0] + " = ?;";
                try {
                    CallableStatement cs = conexion.estableceConexion().prepareCall(consulta);
                    cs.setString(1, id.getText());
                    cs.execute();
                    JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se eliminó correctamente: " + e.toString());
                }

            }
            actualizarEnCascada1(conexion, nomTabla, id.getText(), datos[0]);

        } else {
            JOptionPane.showMessageDialog(null, "No se necesita actualización.");
        }

    }

    //--------------------------------------------
    private void actualizarEnCascada1(CConection conexion, String nomTabla, String id, String primaryKey) {
        // Obtener las tablas relacionadas
        String getRelacionadas = "SELECT TABLE_NAME, COLUMN_NAME "
                + "FROM information_schema.KEY_COLUMN_USAGE "
                + "WHERE REFERENCED_TABLE_SCHEMA = 'dietasgranjas' "
                + "AND REFERENCED_TABLE_NAME = '" + nomTabla + "';";

        try {
            Statement st = conexion.estableceConexion().createStatement();
            ResultSet rs = st.executeQuery(getRelacionadas);
            while (rs.next()) {
                String tablaRelacionada = rs.getString("TABLE_NAME");
                String columnaRelacionada = rs.getString("COLUMN_NAME");

                // Obtener el nombre de la última columna (asumiendo que es el estado)
                String getLastColumn = "SELECT COLUMN_NAME FROM information_schema.COLUMNS "
                        + "WHERE TABLE_SCHEMA = 'dietasgranjas' AND TABLE_NAME = '" + tablaRelacionada + "' "
                        + "ORDER BY ORDINAL_POSITION DESC LIMIT 1;";

                Statement stLastColumn = conexion.estableceConexion().createStatement();
                ResultSet rsLastColumn = stLastColumn.executeQuery(getLastColumn);
                if (rsLastColumn.next()) {
                    String estadoColumn = rsLastColumn.getString("COLUMN_NAME");

                    // Actualización lógica en la tabla relacionada
                    String consultaRelacionada = "UPDATE `" + tablaRelacionada + "` SET `" + estadoColumn + "` = 'I' WHERE " + columnaRelacionada + " = ?;";

                    try {
                        CallableStatement cs = conexion.estableceConexion().prepareCall(consultaRelacionada);
                        cs.setString(1, id);
                        cs.execute();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "No se actualizó correctamente en la tabla relacionada " + tablaRelacionada + ": " + traducirError(e.toString()));
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo obtener las tablas relacionadas: " + traducirError(e.toString()));
        }
    }

    private void actualizarEnCascada2(CConection conexion, String nomTabla, String id, String primaryKey) {
        // Obtener las tablas relacionadas
        String getRelacionadas = "SELECT TABLE_NAME, COLUMN_NAME "
                + "FROM information_schema.KEY_COLUMN_USAGE "
                + "WHERE REFERENCED_TABLE_SCHEMA = 'dietasgranjas' "
                + "AND REFERENCED_TABLE_NAME = '" + nomTabla + "';";

        try {
            Statement st = conexion.estableceConexion().createStatement();
            ResultSet rs = st.executeQuery(getRelacionadas);
            while (rs.next()) {
                String tablaRelacionada = rs.getString("TABLE_NAME");
                String columnaRelacionada = rs.getString("COLUMN_NAME");

                // Obtener el nombre de la última columna (asumiendo que es el estado)
                String getLastColumn = "SELECT COLUMN_NAME FROM information_schema.COLUMNS "
                        + "WHERE TABLE_SCHEMA = 'dietasgranjas' AND TABLE_NAME = '" + tablaRelacionada + "' "
                        + "ORDER BY ORDINAL_POSITION DESC LIMIT 1;";

                Statement stLastColumn = conexion.estableceConexion().createStatement();
                ResultSet rsLastColumn = stLastColumn.executeQuery(getLastColumn);
                if (rsLastColumn.next()) {
                    String estadoColumn = rsLastColumn.getString("COLUMN_NAME");

                    // Actualización lógica en la tabla relacionada
                    String consultaRelacionada = "UPDATE `" + tablaRelacionada + "` SET `" + estadoColumn + "` = 'A' WHERE " + columnaRelacionada + " = ?;";

                    try {
                        CallableStatement cs = conexion.estableceConexion().prepareCall(consultaRelacionada);
                        cs.setString(1, id);
                        cs.execute();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "No se actualizó correctamente en la tabla relacionada " + tablaRelacionada + ": " + traducirError(e.toString()));
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo obtener las tablas relacionadas: " + traducirError(e.toString()));
        }
    }

    //=------------------------------------------------------------------------
    private String traducirError(String mensaje) {
        if (mensaje.contains("Duplicate entry")) {
            return "Entrada duplicada. El código del país ya existe.";
        } else if (mensaje.contains("Data too long")) {
            return "Dato demasiado largo. Verifique que la descripción del no exceda los ?? caracteres.";
        } else if (mensaje.contains("Incorrect integer value")) {
            return "Dato no es de tipo entero verifique la entrada.";
        } else if (mensaje.contains("Cannot add or update a child row")) {
            return "No se puede agregar o actualizar una fila secundaria. Verifique las claves foráneas.";
        } else if (mensaje.contains("Communications link failure")) {
            return "Fallo en la comunicación con la base de datos. Verifique la conexión a la red.";
        } else if (mensaje.contains("Cannot add or update a child row")) {
            return "No se puede agregar o actualizar una fila secundaria. Verifique las claves foráneas.";
        } else if (mensaje.contains("Access denied for user")) {
            return "Acceso denegado para el usuario. Verifique el usuario y la contraseña.";
        } else if (mensaje.contains("Unknown database")) {
            return "Base de datos desconocida. Verifique el nombre de la base de datos.";
        } else {
            return "Error desconocido: " + mensaje; // Retornar el mensaje original si no se reconoce
        }
    }
}
