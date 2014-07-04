/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mario.blumenladen;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mario
 */
public class NewJArtikel extends javax.swing.JDialog {

Connection con;
Statement stmt;
ResultSet rs;
        String host = "jdbc:mysql://localhost:3306/artikel";
        
        String uName = "artikel";
        String uPass= "123456";
int curRow = 0;
public void DoConnect( ) {
    try {

        con =DriverManager.getConnection(host,uName,uPass);
       
        stmt= con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
       
        String sql="SELECT * FROM artikel";
       
            rs= stmt.executeQuery(sql);
     
        rs.first();
        int  id_num=0;
        String preis="";
        String besch="";
        id_num = rs.getInt("NUMMER");
        String id=Integer.toString(id_num);
        preis = rs.getString("PREIS");
        besch = rs.getString("BESCHREIBUNG");
        String mwst="0.19";
        textNummer.setText(id.trim());
        TextPreis.setText(preis.trim());
        TextBeschreibung.setText(besch.trim());
        TextMwst.setText(mwst);
        jSave.setEnabled( false );
        jCancle.setEnabled( false );
        
    } catch (SQLException ex) {
        Logger.getLogger(NewJArtikel.class.getName()).log(Level.SEVERE, null, ex);
    }
           
}
    /**
     * Creates new form NewJArtikel
     */
    public NewJArtikel(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        DoConnect();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textNummer = new javax.swing.JTextField();
        TextPreis = new javax.swing.JTextField();
        TextBeschreibung = new javax.swing.JTextField();
        TextMwst = new javax.swing.JTextField();
        jFirstButton = new javax.swing.JButton();
        jPrevButton = new javax.swing.JButton();
        jNextButton = new javax.swing.JButton();
        jLastButton = new javax.swing.JButton();
        jUpdateRecord = new javax.swing.JButton();
        jDeleteRecord = new javax.swing.JButton();
        jNewRecord = new javax.swing.JButton();
        jSave = new javax.swing.JButton();
        jCancle = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(640, 480));
        setResizable(false);

        textNummer.setText("textNummer");

        TextPreis.setText("textPreis");
        TextPreis.setMinimumSize(new java.awt.Dimension(30, 100));
        TextPreis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextPreisActionPerformed(evt);
            }
        });

        TextBeschreibung.setText("textBeschreibung");
        TextBeschreibung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextBeschreibungActionPerformed(evt);
            }
        });

        TextMwst.setText("textMwst");

        jFirstButton.setText("First");
        jFirstButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFirstButtonActionPerformed(evt);
            }
        });

        jPrevButton.setText("Prew");
        jPrevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPrevButtonActionPerformed(evt);
            }
        });

        jNextButton.setText("Next");
        jNextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNextButtonActionPerformed(evt);
            }
        });

        jLastButton.setText("Last");
        jLastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLastButtonActionPerformed(evt);
            }
        });

        jUpdateRecord.setText("Update Record");
        jUpdateRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUpdateRecordActionPerformed(evt);
            }
        });

        jDeleteRecord.setText("Delete Record");
        jDeleteRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteRecordActionPerformed(evt);
            }
        });

        jNewRecord.setText("New Record");
        jNewRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewRecordActionPerformed(evt);
            }
        });

        jSave.setText("Save New Record");
        jSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveActionPerformed(evt);
            }
        });

        jCancle.setText("Cancle New Record");
        jCancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancleActionPerformed(evt);
            }
        });

        jLabel1.setText("%");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textNummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextPreis, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextBeschreibung, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextMwst, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jUpdateRecord)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDeleteRecord))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jFirstButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPrevButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jNextButton)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLastButton)
                                    .addComponent(jNewRecord)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jSave)
                        .addGap(57, 57, 57)
                        .addComponent(jCancle)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextPreis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextBeschreibung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextMwst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFirstButton)
                    .addComponent(jPrevButton)
                    .addComponent(jNextButton)
                    .addComponent(jLastButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDeleteRecord)
                    .addComponent(jUpdateRecord)
                    .addComponent(jNewRecord))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSave)
                    .addComponent(jCancle))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextPreisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextPreisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextPreisActionPerformed

    private void TextBeschreibungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextBeschreibungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextBeschreibungActionPerformed

    private void jNextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNextButtonActionPerformed
        try {
            if ( rs.next( ) ) {
              //  rs.next();
                int  id_num=0;
                String preis="";
                String besch="";
                id_num = rs.getInt("NUMMER");
                String id=Integer.toString(id_num);
                preis = rs.getString("PREIS");
                besch = rs.getString("BESCHREIBUNG");
                String mwst="0.19";
                textNummer.setText(id.trim());
                TextPreis.setText(preis.trim());
                TextBeschreibung.setText(besch.trim());
                TextMwst.setText(mwst);
            }
            else {
                rs.previous( );
                JOptionPane.showMessageDialog(NewJArtikel.this, "End of File");
                }
            }
            catch (SQLException err) {
                JOptionPane.showMessageDialog(NewJArtikel.this, err.getMessage());
            }
    }//GEN-LAST:event_jNextButtonActionPerformed

    private void jPrevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPrevButtonActionPerformed
        try {
            if ( rs.previous()) {
               // rs.previous();
                int  id_num=0;
                String preis="";
                String besch="";
                id_num = rs.getInt("NUMMER");
                String id=Integer.toString(id_num);
                preis = rs.getString("PREIS");
                besch = rs.getString("BESCHREIBUNG");
                String mwst="0.19";
                textNummer.setText(id.trim());
                TextPreis.setText(preis.trim());
                TextBeschreibung.setText(besch.trim());
                TextMwst.setText(mwst);
            }
            else {
                rs.next( );
                JOptionPane.showMessageDialog(NewJArtikel.this, "Beginn of File");
                }
            }
            catch (SQLException err) {
                JOptionPane.showMessageDialog(NewJArtikel.this, err.getMessage());
            }
    }//GEN-LAST:event_jPrevButtonActionPerformed

    private void jLastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLastButtonActionPerformed
        try {
                rs.last();
                int  id_num=0;
                String preis="";
                String besch="";
                id_num = rs.getInt("NUMMER");
                String id=Integer.toString(id_num);
                preis = rs.getString("PREIS");
                besch = rs.getString("BESCHREIBUNG");
                String mwst="0.19";
                textNummer.setText(id.trim());
                TextPreis.setText(preis.trim());
                TextBeschreibung.setText(besch.trim());
                TextMwst.setText(mwst);
          
            }
            catch (SQLException err) {
                JOptionPane.showMessageDialog(NewJArtikel.this, err.getMessage());
            }
    }//GEN-LAST:event_jLastButtonActionPerformed

    private void jFirstButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFirstButtonActionPerformed
       try {
                rs.first();
                int  id_num=0;
                String preis="";
                String besch="";
                id_num = rs.getInt("NUMMER");
                String id=Integer.toString(id_num);
                preis = rs.getString("PREIS");
                besch = rs.getString("BESCHREIBUNG");
                String mwst="0.19";
                textNummer.setText(id.trim());
                TextPreis.setText(preis.trim());
                TextBeschreibung.setText(besch.trim());
                TextMwst.setText(mwst);
          
            }
            catch (SQLException err) {
                JOptionPane.showMessageDialog(NewJArtikel.this, err.getMessage());
            }
    }//GEN-LAST:event_jFirstButtonActionPerformed

    private void jNewRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewRecordActionPerformed
    try {
        jDeleteRecord.setEnabled( false );
        jFirstButton.setEnabled( false ) ;
        jLastButton.setEnabled( false );
        jNewRecord.setEnabled( false );
        jUpdateRecord.setEnabled( false );
        jNextButton.setEnabled( false );
        jPrevButton.setEnabled( false );

        jSave.setEnabled( true );
        jCancle.setEnabled( true );
        curRow = rs.getRow();
        textNummer.setText("");
        TextPreis.setText("");
        TextBeschreibung.setText("");
        TextMwst.setText("");
    } catch (SQLException ex) {
        Logger.getLogger(NewJArtikel.class.getName()).log(Level.SEVERE, null, ex);
    }
        
          
    }//GEN-LAST:event_jNewRecordActionPerformed

    private void jUpdateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUpdateRecordActionPerformed
            try {
                String ID="";
                String preis="";
                String besch="";
                ID=textNummer.getText().trim();
                preis=TextPreis.getText().trim();
                besch=TextBeschreibung.getText().trim();
                String mwst="0.19";
                int newID = Integer.parseInt(ID );
            
                rs.updateInt("NUMMER",newID);
                rs.updateString("PREIS", preis);
                rs.updateString("BESCHREIBUNG",besch);
                rs.updateRow();
                JOptionPane.showMessageDialog(NewJArtikel.this, "Updated");
            }
                    catch (SQLException err) {
                    System.out.println(err.getMessage() );
            }
    }//GEN-LAST:event_jUpdateRecordActionPerformed

    private void jCancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancleActionPerformed
    try {
        rs.absolute( curRow );
        jDeleteRecord.setEnabled( true );
        jFirstButton.setEnabled( true ) ;
        jLastButton.setEnabled( true );
        jNewRecord.setEnabled( true );
        jUpdateRecord.setEnabled( true );
        jNextButton.setEnabled( true );
        jPrevButton.setEnabled( true );

        jSave.setEnabled( false );
        jCancle.setEnabled( false );
         int  id_num=0;
                String preis="";
                String besch="";
                id_num = rs.getInt("NUMMER");
                String id=Integer.toString(id_num);
                preis = rs.getString("PREIS");
                besch = rs.getString("BESCHREIBUNG");
                String mwst="0.19";
                textNummer.setText(id.trim());
                TextPreis.setText(preis.trim());
                TextBeschreibung.setText(besch.trim());
                TextMwst.setText(mwst);
    } catch (SQLException ex) {
        Logger.getLogger(NewJArtikel.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jCancleActionPerformed

    private void jSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaveActionPerformed
             
    try {
        jDeleteRecord.setEnabled( true );
        jFirstButton.setEnabled( true ) ;
        jLastButton.setEnabled( true );
        jNewRecord.setEnabled( true );
        jUpdateRecord.setEnabled( true );
        jNextButton.setEnabled( true );
        jPrevButton.setEnabled( true );

        jSave.setEnabled( false );
        jCancle.setEnabled( false );
        rs.moveToInsertRow();
           String ID="";
                String preis="";
                String besch="";
                ID=textNummer.getText();
                preis=TextPreis.getText();
                besch=TextBeschreibung.getText();
                String mwst="0.19";
                int newID = Integer.parseInt(ID );
            
                rs.updateInt("NUMMER",newID);
                rs.updateString("PREIS", preis);
                rs.updateString("BESCHREIBUNG",besch);
                rs.insertRow();
                stmt.close( );
                rs.close( );
                con =DriverManager.getConnection(host,uName,uPass);
       
        stmt= con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
       
        String sql="SELECT * FROM artikel";
       
            rs= stmt.executeQuery(sql);
     
        rs.next();
        int  id_num=0;
        
        id_num = rs.getInt("NUMMER");
        String id=Integer.toString(id_num);
        preis = rs.getString("PREIS");
        besch = rs.getString("BESCHREIBUNG");
        //String mwst="0.19";
        textNummer.setText(id.trim());
        TextPreis.setText(preis.trim());
        TextBeschreibung.setText(besch.trim());
        TextMwst.setText(mwst);
        
    } catch (SQLException ex) {
        Logger.getLogger(NewJArtikel.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_jSaveActionPerformed

    private void jDeleteRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteRecordActionPerformed
        
    try {
        rs.deleteRow( );
        stmt.close( );
                rs.close( );
                con =DriverManager.getConnection(host,uName,uPass);
       
        stmt= con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
       
        String sql="SELECT * FROM artikel";
       
            rs= stmt.executeQuery(sql);
     
        rs.next();
        int  id_num=0;
         String ID="";
                String preis="";
                String besch="";
        id_num = rs.getInt("NUMMER");
        String id=Integer.toString(id_num);
        preis = rs.getString("PREIS");
        besch = rs.getString("BESCHREIBUNG");
        String mwst="0.19";
        textNummer.setText(id.trim());
        TextPreis.setText(preis.trim());
        TextBeschreibung.setText(besch.trim());
        TextMwst.setText(mwst);
        
    } catch (SQLException ex) {
        Logger.getLogger(NewJArtikel.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jDeleteRecordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextBeschreibung;
    private javax.swing.JTextField TextMwst;
    private javax.swing.JTextField TextPreis;
    private javax.swing.JButton jCancle;
    private javax.swing.JButton jDeleteRecord;
    private javax.swing.JButton jFirstButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jLastButton;
    private javax.swing.JButton jNewRecord;
    private javax.swing.JButton jNextButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jPrevButton;
    private javax.swing.JButton jSave;
    private javax.swing.JButton jUpdateRecord;
    private javax.swing.JTextField textNummer;
    // End of variables declaration//GEN-END:variables
}
