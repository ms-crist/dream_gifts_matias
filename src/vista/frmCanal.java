/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Conexion.Conexion;
import static com.sun.source.tree.Tree.Kind.AND;
import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import controlador.Canal;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Usuario
 */

  /** Creates new form ingresoproductos */
   
    
    

  

public class frmCanal extends javax.swing.JFrame {
      DefaultTableModel modelo; 
 
  Conexion cone=new Conexion();
  Connection con=cone.ConexionBD();
  
  int id;
  
    DefaultTableModel model = new DefaultTableModel();  
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null; 
    


    
    /**
     * Creates new form canal
     */
    public frmCanal() {
        initComponents();
        DesplegarDatosBusca("");
         setLocationRelativeTo(null);
       //  modelo=new DefaultTableModel();
       //  modelo.addColumn("Código RRSS");
       //  modelo.addColumn("Nombre RRSS");
       //  modelo.addColumn("Estado");
       //  this.Tabla_canal.setModel(modelo);
         MostrarDatos();
        }  
    



   
  
    public void MostrarDatos(){
        
       
    
      
        String [] titulos = {"Código RRSS", "Nombre RRSS", "Estado"};
        String [] registros = new String [3];
        
       
       
      
      DefaultTableModel modelo = new DefaultTableModel(null, titulos); 
     
      


     
       
        String Sql = "select * from canal";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Sql);
          
           

            while (rs.next()) {
                registros[0] = rs.getString("CAN_ID_CANAL");
                registros[1] = rs.getString("CAN_NOMBRE");
                registros[2] = rs.getString("CAN_ESTADO");
                int tipoObt= Integer.valueOf(registros[2]);
                
                if ((tipoObt == 0)){
                    registros[2] = "Desactivado";
                } else {
                    registros[2] = "Activado";
                }

             modelo.addRow(new Object[]{registros[0],registros[1],registros[2]});
                //modelo.addRow(registros);
           
                
                
                }
              
            Tabla_canal.setModel(modelo);
         
           
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar datos" + e.getMessage());
        }
        
        } 
     
    public void DesplegarDatosBusca(String valor){
    DefaultTableModel modelo= new DefaultTableModel();
    modelo.addColumn("Código RRSS");
    modelo.addColumn("Nombre RRSS");
    modelo.addColumn("Estado");
    String sql="";
    if(valor.equals(""))
    {
        sql="SELECT * FROM canal";
    }
    else{
        sql="SELECT * FROM canal WHERE CAN_NOMBRE='"+valor+"'";
        //sql="SELECT * FROM canal WHERE CAN_ID_CANAL='"+valor+"'";
    }
 
    String []datos = new String [3];
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
   
                modelo.addRow(datos);
            }
            Tabla_canal.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(frmCanal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_canal = new javax.swing.JTable();
        btn_editar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jtxt_buscar = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtxt_CAN_NOMBRE = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxt_CAN_ID_CANAL = new javax.swing.JTextField();
        btn_cancelar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        btn_reestalecer = new javax.swing.JButton();
        btn_desactivar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tabla_canal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código RRSS", "Nombre RRSS", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla_canal.getTableHeader().setReorderingAllowed(false);
        Tabla_canal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_canalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_canal);
        Tabla_canal.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (Tabla_canal.getColumnModel().getColumnCount() > 0) {
            Tabla_canal.getColumnModel().getColumn(0).setResizable(false);
            Tabla_canal.getColumnModel().getColumn(1).setResizable(false);
            Tabla_canal.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 650, 107));

        btn_editar.setText("Actualizar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 100, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Redes Sociales");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, -1));

        jtxt_buscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtxt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_buscarActionPerformed(evt);
            }
        });
        jtxt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxt_buscarKeyPressed(evt);
            }
        });
        jPanel1.add(jtxt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 80, -1));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Canales", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel2.setText("Nombre Canal");

        jLabel3.setText("Código canal");

        jtxt_CAN_ID_CANAL.setEditable(false);
        jtxt_CAN_ID_CANAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_CAN_ID_CANALActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jtxt_CAN_NOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jtxt_CAN_ID_CANAL, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxt_CAN_NOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtxt_CAN_ID_CANAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_guardar))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 650, -1));

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 80, -1));

        btn_reestalecer.setText("Reestablecer");
        btn_reestalecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reestalecerActionPerformed(evt);
            }
        });
        jPanel1.add(btn_reestalecer, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 110, -1));

        btn_desactivar.setText("Desactivar");
        btn_desactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_desactivarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_desactivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, 110, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
      // TODO add your handling code here:
      
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
    
         if((jtxt_CAN_NOMBRE.getText().length() == 0)){
                      JOptionPane.showMessageDialog(null, "No puede estar el campo de nombre vacío", "ERROR", JOptionPane.ERROR_MESSAGE);  
                 } else {
                    try {
                String URL_bd = "jdbc:mysql://localhost/dreamgifts";
                String usuario = "root";// este usuario es por default de mysql
                String contraseña = "";// depende de como entre a la consola de mysql
                Connection cn = DriverManager.getConnection(URL_bd, usuario, contraseña);
                PreparedStatement pst = cn.prepareStatement("insert into canal values(?,?,?)");
                
                int est = 0;
          
               
                        
                        
                
                 pst.setString(1, "0");
                 pst.setString(2, jtxt_CAN_NOMBRE.getText().trim());
                 pst.setBoolean(3, true);
                 
                 
                 
               
               

                pst.executeUpdate();
                MostrarDatos();

                JOptionPane.showMessageDialog(null, "Se Guardo el Canal Correctamente", "AVISO", JOptionPane.INFORMATION_MESSAGE);
               

            }// cierre del bloque try
            catch (Exception ex) {

                // mensaje error al grabar
                JOptionPane.showMessageDialog(null, "Error al intentar guardar la Canal" + ex, "AVISO", JOptionPane.ERROR_MESSAGE);
                
               

                ex.printStackTrace();
            }// cierre del catch
  
                 }
         
       String est= "";
       
        

   
      /*   
         String[]info = new String[3];
         info[0]= jtxt_CAN_ID_CANAL.getText();
         info[1]= jtxt_CAN_NOMBRE.getText();
         info[2]= "";
         modelo.addRow(info);
         
        
        jtxt_CAN_NOMBRE.setText("");
       
    */

         
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void jtxt_CAN_ID_CANALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_CAN_ID_CANALActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_CAN_ID_CANALActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed

        
         try {
        PreparedStatement pst = con.prepareStatement("UPDATE canal SET CAN_NOMBRE='"+jtxt_CAN_NOMBRE.getText()+"' WHERE CAN_ID_CANAL='"+jtxt_CAN_ID_CANAL.getText()+"'");
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Nombre de canal actualizado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        MostrarDatos();
    } catch (Exception e) {
        System.out.print(e.getMessage());
          JOptionPane.showMessageDialog(null, "Error al intentar guardar el Canal", "AVISO", JOptionPane.ERROR_MESSAGE);
    }
        
        /*
        try {

            //int CAN_ID_CANAL = Integer.parseInt(jtxt_CAN_ID_CANAL.getText());
            String URL_bd = "jdbc:mysql://localhost/dreamgifts";
            String usuario = "root";// este usuario es por default de mysql
            String contraseña = "";// depende de como entre a la consola de mysql
            Connection cn = DriverManager.getConnection(URL_bd, usuario, contraseña);
            PreparedStatement pst = cn.prepareStatement("update canal set CAN_NOMBRE=?, CAN_ID_CANAL=? where CAN_ID_CANAL=?"); //CAN_ID_CANAL);

            pst.setString(1, jtxt_CAN_ID_CANAL.getText());
            pst.setString(2, jtxt_CAN_NOMBRE.getText());
            pst.setBoolean(3, true);


            pst.executeUpdate();
          

            JOptionPane.showMessageDialog(null, "Datos del usuario actualizados", "Aviso", JOptionPane.INFORMATION_MESSAGE);
          
        }
         catch (Exception ex) {

                // mensaje error al grabar
                JOptionPane.showMessageDialog(null, "Error al intentar guardar la Canal" + ex, "AVISO", JOptionPane.ERROR_MESSAGE);
                
               

                ex.printStackTrace();
            }// 
*/
        
        
        
    
           
   

       
    }//GEN-LAST:event_btn_editarActionPerformed

    private void Tabla_canalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_canalMouseClicked
       
        int cor = Tabla_canal.getSelectedRow();
        jtxt_CAN_ID_CANAL.setText(Tabla_canal.getValueAt(cor, 0).toString());
        jtxt_CAN_NOMBRE.setText(Tabla_canal.getValueAt(cor, 1).toString()); 
       
    }//GEN-LAST:event_Tabla_canalMouseClicked

    private void jtxt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_buscarActionPerformed

    private void jtxt_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxt_buscarKeyPressed
    
        
      
       
       
        
         
        
        
          
       
      
       
    }//GEN-LAST:event_jtxt_buscarKeyPressed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
         DesplegarDatosBusca(jtxt_buscar.getText());
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_reestalecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reestalecerActionPerformed
       MostrarDatos();
       this.jtxt_buscar.setText("");
    }//GEN-LAST:event_btn_reestalecerActionPerformed

    private void btn_desactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desactivarActionPerformed


        try {
        PreparedStatement pst = con.prepareStatement("UPDATE canal SET CAN_ESTADO=0 WHERE CAN_ESTADO=1 AND CAN_ID_CANAL='"+jtxt_CAN_ID_CANAL.getText()+"'");
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Canal desactivado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        MostrarDatos();
    } catch (Exception e) {
        System.out.print(e.getMessage());
          JOptionPane.showMessageDialog(null, "Error al intentar desactivar Canal", "AVISO", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btn_desactivarActionPerformed

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
            java.util.logging.Logger.getLogger(frmCanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCanal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_canal;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_desactivar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_reestalecer;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jtxt_CAN_ID_CANAL;
    private javax.swing.JTextField jtxt_CAN_NOMBRE;
    private javax.swing.JTextField jtxt_buscar;
    // End of variables declaration//GEN-END:variables

  
        } 
