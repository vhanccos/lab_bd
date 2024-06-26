/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ganadodietas;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
        if (flagField.getText().equals("1")) { // Consultar el valor del flag

            setEstReg(id.getText());
            setDesc(desc.getText());
            setDesc(estReg.getText());
            CConection conexion = new CConection();
            if (nombTabla.equals("FECHA INICIO")) {
                //INSERT INTO tabla_paises (PaiCod, PaiDes, PaiEstReg) VALUES (21, 'Portugal', 'A');
                String consulta = "INSERT INTO `" + nombTabla + "` VALUES (?,?,?,?,?);";//cambios de tablas
                try {
                    String[] fecha = new String[3];
                    fecha[0] = desc.getText().substring(0, 2);
                    fecha[1] = desc.getText().substring(3, 5);
                    fecha[2] = desc.getText().substring(6, 8);
                    CallableStatement cs = conexion.estableceConexion().prepareCall(consulta);
                    cs.setString(1, id.getText());
                    cs.setString(2, fecha[0]);
                    cs.setString(3, fecha[1]);
                    cs.setString(4, fecha[2]);
                    cs.setString(5, estReg.getText());
                    cs.execute();

                    JOptionPane.showMessageDialog(null, "Se insertó correctamente");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese la fecha en el formato dd-mm-aa (ejemplo: 03-12-16)");
                }
            } else {
                String consulta = "INSERT INTO `" + nombTabla + "` VALUES (?, ?, ?);";

                try {
                    CallableStatement cs = conexion.estableceConexion().prepareCall(consulta);
                    cs.setString(1, id.getText());
                    cs.setString(2, desc.getText());
                    cs.setString(3, estReg.getText());
                    cs.execute();

                    JOptionPane.showMessageDialog(null, "Se insertó correctamente");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se pudo mostrar correctamente: " + traducirError(e.toString()));
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "No se necesita actualización.");
        }

    }

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

        modelo.addColumn("Codigo");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Estado");

        String[] datos = new String[3];
        Statement st;

        try {
            st = conexion.estableceConexion().createStatement();
            ResultSet rs = st.executeQuery(consulta);

            if (nomTabla.equals("FECHA INICIO")) {
                while (rs.next()) {
                    System.out.println("pasando");
                    // se crea un arreglo para poder guardar la fecha y despues juntarla para mostrarla
                    String[] fecha = new String[3];
                    fecha[0] = rs.getString(2);
                    fecha[1] = rs.getString(3);
                    fecha[2] = rs.getString(4);
                    // se ingresan los datos
                    datos[0] = rs.getString(1);
                    datos[1] = fecha[0] + "-" + fecha[1] + "-" + fecha[2];
                    datos[2] = rs.getString(5);
                    modelo.addRow(datos);
                }
            } else {
                while (rs.next()) {
                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                    datos[2] = rs.getString(3);
                    modelo.addRow(datos);
                }
            }
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar correctamente: " + traducirError(e.toString()));
        }
    }

    public void Seleccionar(JTable tabla, JTextField id, JTextField desc, JTextField estReg, JTextField flagField) {
        try {
            int fila = tabla.getSelectedRow();
            flagField.setText("1");
            if (fila >= 0) {
                id.setText((tabla.getValueAt(fila, 0).toString()));
                desc.setText((tabla.getValueAt(fila, 1).toString()));
                estReg.setText((tabla.getValueAt(fila, 2).toString()));
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
                String consulta = "UPDATE `" + nomTabla + "` SET " + datos[4] + " = '*' WHERE " + datos[0] + " = ?;";
                try {
                    CallableStatement cs = conexion.estableceConexion().prepareCall(consulta);
                    cs.setString(1, id.getText());
                    cs.execute();
                    JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se elimino correctamente: " + traducirError(e.toString()));
                }

            } else {
                String consulta = "UPDATE `" + nomTabla + "` SET " + datos[2] + " = '*' WHERE " + datos[0] + " = ?;";
                try {
                    CallableStatement cs = conexion.estableceConexion().prepareCall(consulta);
                    cs.setString(1, id.getText());
                    cs.execute();
                    JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se elimino correctamente: " + traducirError(e.toString()));
                }

            }

        } else {
            JOptionPane.showMessageDialog(null, "No se necesita actualización.");
        }

    }

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
        } else {
            JOptionPane.showMessageDialog(null, "No se necesita actualización.");
        }

    }

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
