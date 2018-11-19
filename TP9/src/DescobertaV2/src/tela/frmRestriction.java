/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import conexoes.ConexaoSQLLite;
import java.awt.Dimension;
import java.awt.List;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Willian
 */
public class frmRestriction extends javax.swing.JFrame {

    /**
     * Creates new form frmRestriction
     */
    public frmRestriction() {
        initComponents();

    }
    private DefaultListModel modelRestriciton = new DefaultListModel();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listClass = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listRestriction = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listClass2 = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtResult = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restrições");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Restrições");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        listClass.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listClass);

        jButton1.setText("Carregar Classes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        listRestriction.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listRestriction.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listRestrictionKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(listRestriction);

        listClass2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listClass2);

        jButton2.setText("Can");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Extend");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Salvar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtResult.setColumns(20);
        txtResult.setRows(5);
        jScrollPane4.setViewportView(txtResult);

        jButton5.setText("Validar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Implement");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Declare");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Carregar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton8)))))
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton8)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(7, 7, 7)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)))
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ConexaoSQLLite connection = new ConexaoSQLLite();
        String classes = "select distinct origem from project";
        String tipos = "select distinct destino from project";
        if (connection.conectar()) {
            try {
                DefaultListModel listModel = new DefaultListModel();
                DefaultListModel listModel2 = new DefaultListModel();
                Statement stmt = connection.criarStatement();
                PreparedStatement prepareStatement = connection.preparesStatement(classes);
                ResultSet rs = prepareStatement.executeQuery();
                while (rs.next()) {
                    listClass.removeAll();
                    listClass2.removeAll();
                    listModel.addElement(rs.getString("origem"));
                    listModel2.addElement(rs.getString("origem"));

                }
                PreparedStatement prepareStatementTipos = connection.preparesStatement(tipos);
                ResultSet rsTipo = prepareStatementTipos.executeQuery();
                while (rsTipo.next()) {
                    listModel2.addElement(rsTipo.getString("destino"));
                }
                listClass.setModel(listModel);
                listClass2.setModel(listModel2);

            } catch (SQLException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, e.getMessage());
            } finally {
                connection.desconectar();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String classe1 = listClass.getSelectedValue();
        String classe2 = listClass2.getSelectedValue();
        modelRestriciton.addElement(classe1 + " Can Access " + classe2);
        listRestriction.setModel(modelRestriciton);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String classe1 = listClass.getSelectedValue();
        String classe2 = listClass2.getSelectedValue();
        modelRestriciton.addElement(classe1 + " Can Extend " + classe2);
        listRestriction.setModel(modelRestriciton);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void listRestrictionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listRestrictionKeyPressed
        int index = listRestriction.getSelectedIndex();
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            modelRestriciton.remove(index);
            listRestriction.removeAll();
            listRestriction.setModel(modelRestriciton);
        }
    }//GEN-LAST:event_listRestrictionKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            FileWriter file = new FileWriter("restricoes.txt");
            System.out.println("Arquivo gerado.");
            PrintWriter gravaArq = new PrintWriter(file);
            JSONObject json = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            ListModel<String> model = listRestriction.getModel();
            for (int i = 0; i < model.getSize(); i++) {
                jsonArray.put(model.getElementAt(i));
                gravaArq.println(model.getElementAt(i));
            }
            json.put("restricoes", jsonArray);
            System.out.println(json.toString());
            file.close();
            JOptionPane.showMessageDialog(this, "Arquivo salvo com sucesso.");

        } catch (IOException ex) {
            Logger.getLogger(frmRestriction.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        txtResult.setText("");
        ConexaoSQLLite connection = new ConexaoSQLLite();
        String canAccess = "select count(*) as count from project where(tipo = \"access\" or tipo = \"declare\") and origem = ? and destino = ? ";
        String extend = "select count(*) as count from project where tipo = \"extend\" and origem = ? and destino = ? ";
        String declare = "select count(*) as count from project where tipo = \"declare\" and origem = ? and destino = ? ";
        String implement = "select count(*) as count from project where tipo = \"implement\" and origem = ? and destino = ? ";

        if (connection.conectar()) {
            try {

                ListModel<String> model = listRestriction.getModel();
                PreparedStatement prepareStatement = null;
                String[] parameters = null;
                for (int i = 0; i < model.getSize(); i++) {

                    if (model.getElementAt(i).contains("Can Access")) {
                        prepareStatement = connection.preparesStatement(canAccess);
                        parameters = model.getElementAt(i).split("Can Access");
                    } else if (model.getElementAt(i).contains("Can Implement")) {
                        prepareStatement = connection.preparesStatement(implement);
                        parameters = model.getElementAt(i).split("Can Declare");
                    } else if (model.getElementAt(i).contains("Can Declare")) {
                        prepareStatement = connection.preparesStatement(declare);
                        parameters = model.getElementAt(i).split("Can Declare");
                    } else if (model.getElementAt(i).contains("Can Extend")) {
                        prepareStatement = connection.preparesStatement(implement);
                        parameters = model.getElementAt(i).split("Can Extend");
                    }

                    prepareStatement.setString(1, parameters[0].trim());
                    prepareStatement.setString(2, parameters[1].trim());
                    ResultSet rs = prepareStatement.executeQuery();
                    //if (rs.getInt("count")>1) {
                    if (rs.getInt(1) > 0) {
                        txtResult.append("OK: " + model.getElementAt(i) + "\n");//txtResult.add("OK: "+model.getElementAt(i));
                        //System.out.println("OK: "+model.getElementAt(i));//txtResult.add("OK: "+model.getElementAt(i), this);                        
                    } else {
                        txtResult.append("Error: " + model.getElementAt(i) + "\n");//txtResult.add("Error: "+model.getElementAt(i));//System.out.println("Error: "+model.getElementAt(i));//txtResult.add("Error: "+model.getElementAt(i), this);
                    }
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
                connection.desconectar();
            }
                    
        }


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String classe1 = listClass.getSelectedValue();
        String classe2 = listClass2.getSelectedValue();
        modelRestriciton.addElement(classe1 + " Can Implement " + classe2);
        listRestriction.setModel(modelRestriciton);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String classe1 = listClass.getSelectedValue();
        String classe2 = listClass2.getSelectedValue();
        modelRestriciton.addElement(classe1 + " Can Declare " + classe2);
        listRestriction.setModel(modelRestriciton);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            modelRestriciton.clear();           
            BufferedReader br = new BufferedReader(new FileReader("restricoes.txt"));
            while (br.ready()) {
                String linha = br.readLine();
                modelRestriciton.addElement(linha);
            }
            br.close();
            JOptionPane.showMessageDialog(this, "Arquivo carregado com sucesso.");
            listRestriction.setModel(modelRestriciton);
            listRestriction.repaint();
        } catch (IOException ex) {
            Logger.getLogger(frmRestriction.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmRestriction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRestriction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRestriction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRestriction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRestriction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> listClass;
    private javax.swing.JList<String> listClass2;
    private javax.swing.JList<String> listRestriction;
    private javax.swing.JTextArea txtResult;
    // End of variables declaration//GEN-END:variables
}