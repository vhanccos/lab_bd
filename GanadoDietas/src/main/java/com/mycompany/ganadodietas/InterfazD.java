/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.ganadodietas;

/**
 *
 * @author Usuario
 */
public class InterfazD extends javax.swing.JPanel {

    /**
     * Creates new form InterfazD
     */
    // int 1 = crear, 2 = editar, 3 = eliminar, 4 = reactivar, 5 = inactivar
    // default 0
    public static int flag = 0;
    // VALOR DEFAULT DE LA TABLA A MOSTRAR
    public static String tablaSelec = "ALIMENTO TIPO";

    public InterfazD() {
    
        initComponents();
        CTabla tabla = new CTabla();
        textEstReg.setEnabled(false);
        txtId.setEnabled(false);
        textDesc.setEnabled(false);
        tabla.Mostrar(tablaQ, tablaSelec);
        CConection conexion = new CConection();
        conexion.estableceConexion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        textDesc = new javax.swing.JTextField();
        textEstReg = new javax.swing.JTextField();
        borrar = new javax.swing.JButton();
        crear = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        btnInac = new javax.swing.JButton();
        btnReact = new javax.swing.JButton();
        btnActu = new javax.swing.JButton();
        BtnCancel = new javax.swing.JButton();
        BtnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaQ = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        TFlag = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Código:");

        jLabel4.setText("Descripción:");

        jLabel5.setText("Estado de Registro:");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        textEstReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEstRegActionPerformed(evt);
            }
        });

        borrar.setText("Eliminar");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        crear.setText("Adicionar");
        crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearActionPerformed(evt);
            }
        });

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        btnInac.setText("Inactivar");
        btnInac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInacActionPerformed(evt);
            }
        });

        btnReact.setText("Reactivar");
        btnReact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReactActionPerformed(evt);
            }
        });

        btnActu.setText("Actualizar");
        btnActu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActuActionPerformed(evt);
            }
        });

        BtnCancel.setText("Cancelar");
        BtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelActionPerformed(evt);
            }
        });

        BtnSalir.setText("Salir");
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });

        jLabel1.setText("Datos:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(crear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnInac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(modificar)
                                    .addComponent(btnReact, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(borrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnActu, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BtnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BtnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textEstReg, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(46, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textEstReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificar)
                    .addComponent(crear)
                    .addComponent(borrar)
                    .addComponent(BtnCancel))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInac)
                    .addComponent(btnReact)
                    .addComponent(btnActu)
                    .addComponent(BtnSalir))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, -1, -1));

        tablaQ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaQ.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tablaQ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaQMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaQMousePressed(evt);
            }
        });
        tablaQ.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tablaQComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(tablaQ);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 350, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALIMENTO TIPO", "ANIMAL TIPO", "ANIMAL UTILIDAD", "CIUDAD", "ESTADO", "MAGNITUD", "PAIS" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel2.setText("Tabla:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        TFlag.setText("0");
        TFlag.setEnabled(false);
        TFlag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFlagActionPerformed(evt);
            }
        });
        add(TFlag, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, -1, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void textEstRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEstRegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEstRegActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        int respuesta = javax.swing.JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este registro?", "Confirmar eliminación", javax.swing.JOptionPane.YES_NO_OPTION);
        CTabla tabla = new CTabla();

        if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
            flag = 3;
            textEstReg.setText("*");
            tabla.Eliminar(tablaSelec, txtId, textDesc, textEstReg, TFlag);
            TFlag.setText("0");

            inactivar();
            // Aquí puedes agregar el código para eliminar el registro de la base de datos
            javax.swing.JOptionPane.showMessageDialog(null, "El registro ha sido marcado para eliminación.");
            tabla.Mostrar(tablaQ, tablaSelec);

        } else {
            // Acción cancelada, no hacer nada
            javax.swing.JOptionPane.showMessageDialog(null, "La acción de eliminación ha sido cancelada.");

        }
        ActivarF();

        Limpiar();
        inactivar();
    }//GEN-LAST:event_borrarActionPerformed

    private void crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearActionPerformed

        flag = 1;
        TFlag.setText("1");
        textEstReg.setEnabled(false);
        txtId.setEnabled(true);
        textDesc.setEnabled(true);
        txtId.setText("");
        textDesc.setText("");
        textEstReg.setText("A");
        btnInac.setEnabled(false);
        btnReact.setEnabled(false);
        borrar.setEnabled(false);
        modificar.setEnabled(false);
    }//GEN-LAST:event_crearActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        flag = 2;

        textDesc.setEnabled(true);
        btnInac.setEnabled(false);
        btnReact.setEnabled(false);
        borrar.setEnabled(false);
        crear.setEnabled(false);
    }//GEN-LAST:event_modificarActionPerformed

    private void btnInacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInacActionPerformed
        flag = 5;

        textEstReg.setText("I");
        CTabla tabla = new CTabla();
        tabla.Inactivar(tablaSelec, txtId, textDesc, textEstReg, TFlag);
        ActivarF();

        TFlag.setText("0");
        Limpiar();
        inactivar();
    }//GEN-LAST:event_btnInacActionPerformed

    private void btnReactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReactActionPerformed
        flag = 4;

        textEstReg.setText("A");
        CTabla tabla = new CTabla();
        tabla.Reactivar(tablaSelec, txtId, textDesc, textEstReg, TFlag);
        tabla.Mostrar(tablaQ, tablaSelec);
        TFlag.setText("0");
        Limpiar();
        inactivar();
        ActivarF();
    }//GEN-LAST:event_btnReactActionPerformed

    private void btnActuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActuActionPerformed

        CTabla tabla = new CTabla();
        // int 1 = crear, 2 = editar, 3 = eliminar, 4 = reactivar, 5 = inactivar , 6 = cancelar
        switch (flag) {
            case 1:
                tabla.Insertar(tablaSelec, txtId, textDesc, textEstReg, TFlag);
                inactivar();
                TFlag.setText("0");
                inactivar();
                ActivarF();
                Limpiar();
                break;
            case 2:
                tabla.Modificar(tablaSelec, txtId, textDesc, textEstReg, TFlag);
                TFlag.setText("0");
                inactivar();
                ActivarF();
                Limpiar();
                break;
            case 3:
                tabla.Eliminar(tablaSelec, txtId, textDesc, textEstReg, TFlag);
                inactivar();
                break;
            case 4:
                tabla.Reactivar(tablaSelec, txtId, textDesc, textEstReg, TFlag);
                inactivar();
                break;
            case 5:
                tabla.Inactivar(tablaSelec, txtId, textDesc, textEstReg, TFlag);
                inactivar();
                break;
            case 6:
                inactivar();
                break;
        }
        tabla.Mostrar(tablaQ, tablaSelec);
    }//GEN-LAST:event_btnActuActionPerformed

    private void BtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelActionPerformed
        flag = 6;
        Limpiar();
        inactivar();
        ActivarF();
    }//GEN-LAST:event_BtnCancelActionPerformed

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
    }//GEN-LAST:event_BtnSalirActionPerformed

    private void tablaQMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaQMouseClicked
        CTabla tabla = new CTabla();

        if (textEstReg.getText().equals("*")) {
            javax.swing.JOptionPane.showMessageDialog(null, "La acción no es posible el elemento fue eliminado");
            Limpiar();
            inactivar();
            TFlag.setText("0");
            ActivarF();
        } else {

            tabla.Seleccionar(tablaQ, txtId, textDesc, textEstReg, TFlag);
            ActivarT2();
        }
    }//GEN-LAST:event_tablaQMouseClicked

    private void tablaQMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaQMousePressed
        // TODO add your handling code here:
        CTabla tabla = new CTabla();
        if (textEstReg.getText().equals("*")) {
            javax.swing.JOptionPane.showMessageDialog(null, "La acción no es posible el elemento fue eliminado");
            Limpiar();
            TFlag.setText("0");

            inactivar();
        } else {

            tabla.Seleccionar(tablaQ, txtId, textDesc, textEstReg, TFlag);

        }
    }//GEN-LAST:event_tablaQMousePressed

    private void tablaQComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tablaQComponentShown
        // TODO add your handling code here:

    }//GEN-LAST:event_tablaQComponentShown

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String elmSel = (String) jComboBox1.getSelectedItem();
        tablaSelec = elmSel;
        CTabla tabla = new CTabla();
        tabla.Mostrar(tablaQ, tablaSelec);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void TFlagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFlagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFlagActionPerformed
    private void inactivar() {
        textEstReg.setEnabled(false);
        txtId.setEnabled(false);
        textDesc.setEnabled(false);
    }

    private void ActivarT() {
        btnInac.setEnabled(true);
        btnReact.setEnabled(true);
        borrar.setEnabled(true);
        modificar.setEnabled(true);
        crear.setEnabled(true);

    }

    private void ActivarT2() {
        btnInac.setEnabled(true);
        btnReact.setEnabled(true);
        borrar.setEnabled(true);
        modificar.setEnabled(true);

    }

    private void ActivarF() {
        btnInac.setEnabled(false);
        btnReact.setEnabled(false);
        borrar.setEnabled(false);
        modificar.setEnabled(false);
        crear.setEnabled(true);

    }

    private void Limpiar() {
        txtId.setText("");
        textDesc.setText("");
        textEstReg.setText("");

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancel;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JTextField TFlag;
    private javax.swing.JButton borrar;
    private javax.swing.JButton btnActu;
    private javax.swing.JButton btnInac;
    private javax.swing.JButton btnReact;
    private javax.swing.JButton crear;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificar;
    private javax.swing.JTable tablaQ;
    private javax.swing.JTextField textDesc;
    private javax.swing.JTextField textEstReg;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
