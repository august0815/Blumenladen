package com.mario.blumenladen;

import com.mario.blumenladen.Kassenanwendung;
import com.mario.blumenladen.kunde.Kunde;
import com.mario.blumenladen.waren.Artikel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mario
 */
public class NewJFrame extends javax.swing.JFrame {
Connection con;
Statement stmt;
ResultSet rs;
    Kassenanwendung k;
    Kunde kunde;
     Rechnung r;
Artikel artikel ;
Map<Long, Artikel>  artikeldaten;

public void DoConnect( ) throws ClassNotFoundException {
    try {
    //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    String host = "jdbc:derby://localhost:1527/artikel";

    String uName = "app";
    String uPass= "app";
    con =DriverManager.getConnection(host,uName,uPass);
    } catch (SQLException ex) {
        Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
      try {
        stmt=con.createStatement();
        String sql="SELECT * FROM artikel";
        rs=stmt.executeQuery(sql);
        rs.next();
        // rs.first();
        int  id_num=0;
        String preis="";
        String besch="";
        id_num = rs.getInt("NUMMER");
        String id=Integer.toString(id_num);
        preis = rs.getString("PREIS");
        besch = rs.getString("BESCHREIBUNG");
       
   
       
        
    } catch (SQLException ex) {
        Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}


    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() throws ClassNotFoundException, InitException {
        initComponents();
        k = new Kassenanwendung();
         artikeldaten =k.leseArtikelEin();
        gebeArtikelaus();
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
        jRechnungSpeichern = new javax.swing.JButton();
        jneueRechnung = new javax.swing.JButton();
        jStück = new javax.swing.JTextField();
        Übernehmen = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AusgabeMonitor = new javax.swing.JTextArea();
        jArtikel = new javax.swing.JButton();
        jArtikelnr = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        AusgabeMonitor1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jRechnungSpeichern.setText("Rechnung Speichern");
        jRechnungSpeichern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRechnungSpeichernActionPerformed(evt);
            }
        });

        jneueRechnung.setText("Neue Rechnung");
        jneueRechnung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jneueRechnungActionPerformed(evt);
            }
        });

        jStück.setText("0");
        jStück.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStückActionPerformed(evt);
            }
        });
        jStück.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jStückInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        Übernehmen.setText("Übernehmen");
        Übernehmen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ÜbernehmenActionPerformed(evt);
            }
        });

        jLabel1.setText("Stück");

        AusgabeMonitor.setColumns(20);
        AusgabeMonitor.setRows(5);
        jScrollPane1.setViewportView(AusgabeMonitor);

        jArtikel.setText("Artikel Bearbeiten");
        jArtikel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jArtikelActionPerformed(evt);
            }
        });

        jArtikelnr.setText("NR");

        AusgabeMonitor1.setColumns(20);
        AusgabeMonitor1.setRows(5);
        jScrollPane2.setViewportView(AusgabeMonitor1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jneueRechnung)
                            .addComponent(jRechnungSpeichern)
                            .addComponent(jArtikel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jArtikelnr, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jStück, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Übernehmen))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jneueRechnung)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRechnungSpeichern)
                        .addGap(48, 48, 48)
                        .addComponent(jArtikel))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jStück, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jArtikelnr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Übernehmen)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jneueRechnungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jneueRechnungActionPerformed
                try {
        k.initialisiereRechnungsnummer();
        
    } catch (InitException ex) {
        Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
        final NewJKunde dialog = new NewJKunde(new javax.swing.JFrame(), true,this);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                  
                                dialog.setVisible(false);
                    }
                });
                 dialog.setVisible(true);
                 gebeRechnungaus();
                 r = new Rechnung(kunde);
    try {
        k.speichereRechnungsnummer();
    } catch (InitException ex) {
        Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
    }

             
        
  
    }//GEN-LAST:event_jneueRechnungActionPerformed

    private void ÜbernehmenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ÜbernehmenActionPerformed
         String eingabe;

            long    artikelnummer =Long.parseLong(jArtikelnr.getText());
            

            Artikel a =this.artikeldaten.get(artikelnummer);
System.out.println("Der Artikel mit der Nummer ");
            if (a == null) {
                System.out.println("Der Artikel mit der Nummer " + artikelnummer + " konnte nicht gefunden werden.");

            }

            int anzahl=Integer.parseInt(jStück.getText());

                    r.fuegePostenHinzu(new Rechnungsposten(anzahl, a));
 gebeRechnungaus();
                
    }//GEN-LAST:event_ÜbernehmenActionPerformed

    private void jStückInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jStückInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jStückInputMethodTextChanged

    private void jArtikelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jArtikelActionPerformed
        NewJArtikel dialog = new NewJArtikel(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                       
                    }
                });
                dialog.setVisible(true);
    }//GEN-LAST:event_jArtikelActionPerformed

    private void jStückActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStückActionPerformed
       
            
    }//GEN-LAST:event_jStückActionPerformed

    private void jRechnungSpeichernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRechnungSpeichernActionPerformed
       r.speichern();
       JOptionPane.showMessageDialog(NewJFrame.this, "Gespeichert");
    }//GEN-LAST:event_jRechnungSpeichernActionPerformed
    public void setAusgabe(String ausgabe) {
        
         
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AusgabeMonitor;
    private javax.swing.JTextArea AusgabeMonitor1;
    private javax.swing.JButton jArtikel;
    private javax.swing.JTextField jArtikelnr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jRechnungSpeichern;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jStück;
    private javax.swing.JButton jneueRechnung;
    private javax.swing.JButton Übernehmen;
    // End of variables declaration//GEN-END:variables

    private void gebeArtikelaus() {
        String ausgabe="";
        for (Map.Entry<Long, Artikel> entry : artikeldaten.entrySet()) {
            Long long1 = entry.getKey();
            Artikel artikel1 = entry.getValue();
            ausgabe +=artikel1.getArtikelnr()+"  "+artikel1.getBeschreibung()+"\n";
             AusgabeMonitor1.setText(ausgabe);
            
        }
       
    }

    private void gebeRechnungaus() {
         String ausgabe="";
          if (r!=null){
              ausgabe +=r.gebeAus();
          }else 
          { ausgabe="Rechnung \n"+kunde.getName()+"\n\n";
          }
                AusgabeMonitor.setText(ausgabe);
                
    }
}
