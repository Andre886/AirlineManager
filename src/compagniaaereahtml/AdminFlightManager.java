/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package compagniaaereahtml;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Andrea Contardi
 * Funzioni Principali: gestione dei voli: aggiunta, modifica e cancellazione di quest'ultimi all'interno della tabella e del file "voli.txt"
 */
public class AdminFlightManager extends javax.swing.JFrame {

    /**
     * Creates new form AdminFlightManager
     */
    
    public static void makeTableTransparent(JTable table) {
        // Imposta la tabella come trasparente
        table.setOpaque(false);

        // Imposta il renderizzatore delle celle come trasparente
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);

        // Imposta lo sfondo delle righe come trasparente
        table.setBackground(new Color(0, 0, 0, 0));

        // Imposta lo sfondo delle celle selezionate come trasparente
        table.setSelectionBackground(new Color(0, 0, 0, 0));

        // Imposta lo sfondo del pannello di visualizzazione come trasparente
        JScrollPane scrollPane = (JScrollPane) table.getParent().getParent();
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        // Aggiorna la tabella per riflettere le modifiche
        table.repaint();
    }
    
    //!!! TESTATO SOLO SU MAC OS!!!
    public static int getWiFiSignalStrength() {
        try {
            Process process = Runtime.getRuntime().exec("/System/Library/PrivateFrameworks/Apple80211.framework/Versions/Current/Resources/airport -I");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                // Cerca la riga contenente il segnale RSSI
                if (line.contains("agrCtlRSSI")) {
                    // Estrai il valore RSSI e restituiscilo
                    String[] parts = line.split(":");
                    return Integer.parseInt(parts[1].trim());
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return -1; // Restituisci -1 in caso di errore
    }
    
    private void leggifile () {
        
        try {
      File myObj = new File("voli.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
                String[] riga = myReader.nextLine().split(" ");
                
                String flightcode = riga[0];
                String source = riga[1];
                String destination = riga[2];
                String orariodecollo = riga[3];
                String nomeaereo = riga[4];
                
                
                
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.addRow(new Object[]{flightcode, source,destination,orariodecollo,nomeaereo});


            }
            
           
            myReader.close();
            
        } catch (FileNotFoundException e) {
            System.err.println("File non trovato: " + e.getMessage());
        }
    }
    
    
    public static boolean cancellariga(int lineNumberToDelete) {
        try {
            File inputFile = new File("voli.txt");
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            int lineNumber = 1;

            while ((currentLine = reader.readLine()) != null) {
                if (lineNumber != lineNumberToDelete) {
                    writer.write(currentLine);
                    writer.newLine();
                }
                lineNumber++;
            }

            reader.close();
            writer.close();

            if (!inputFile.delete()) {
                System.out.println("Impossibile eliminare");
                return false;
            }
            if (!tempFile.renameTo(inputFile)) {
                System.out.println("Impossibile rinominare");
                return false;
            }

            return true;
        } 
         catch (IOException e) {
            System.out.println("Errore");
        }
        return false;
    }
    
    
    
    public AdminFlightManager() {
        initComponents();
        //logo.setIcon(new ImageIcon(getClass().getResource("logo3.png")));
        
        Calendar calendar = GregorianCalendar.getInstance(); 
        String orologiov = calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH)+1) + "/" + calendar.get(Calendar.YEAR);        // gets hour in 12h format
        orologio.setText(orologiov);
        jPanel2.setOpaque(false);
        jPanel1.setOpaque(false);
        jPanel4.setOpaque(false);
        jPanel5.setOpaque(false);
        jPanel6.setOpaque(false);
        jPanel7.setOpaque(false);
        jPanel9.setOpaque(false);
        

        jPanel3.setOpaque(false);
        jLabel6.setIcon(new ImageIcon(getClass().getResource("original2.png")));
        
        int signalStrength = getWiFiSignalStrength();
        
        if (signalStrength== 0) {
            wifi.setIcon(new ImageIcon(getClass().getResource("nessunaconnessione.png")));

        } else 
        
        if (signalStrength != -1) {
            System.out.println("potenza segnale WiFi: " + signalStrength + " dBm");
            if (signalStrength>-60) {
                System.out.println("Segnale Forte");
                wifi.setIcon(new ImageIcon(getClass().getResource("alto.png")));
            } else if (signalStrength>-70 ) {
                System.out.println("segnale medio");
                wifi.setIcon(new ImageIcon(getClass().getResource("medio.png")));
            } else if (signalStrength<-80) {
                System.out.println("segnale debole");
                wifi.setIcon(new ImageIcon(getClass().getResource("basso.png")));
            } 
        } else {
            System.out.println("Unable to retrieve WiFi signal strength.");
            wifi.setIcon(new ImageIcon(getClass().getResource("spento.png")));


        } 
        
        leggifile();
        makeTableTransparent(jTable1);

        
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
        jToggleButton1 = new javax.swing.JToggleButton();
        logo = new javax.swing.JLabel();
        orologio = new javax.swing.JLabel();
        wifi = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fcode = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        src = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        dest = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        orario = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        aereo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1073, 661));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/uscita.png"))); // NOI18N
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/logo3.png"))); // NOI18N
        logo.setMaximumSize(new java.awt.Dimension(0, 0));

        orologio.setForeground(new java.awt.Color(255, 255, 255));
        orologio.setText("orologio");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(429, 429, 429)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 436, Short.MAX_VALUE)
                .addComponent(wifi)
                .addGap(18, 18, 18)
                .addComponent(orologio)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wifi)
                    .addComponent(orologio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1073, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flight Code", "Source", "Destination", "Slot", "Aereo"
            }
        ));
        jTable1.setOpaque(false);
        jTable1.setSelectionBackground(new java.awt.Color(255, 0, 51));
        jTable1.setSelectionForeground(new java.awt.Color(255, 0, 0));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/modifica.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/cerca.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/bin.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 56, -1, 590));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Flight Code");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(fcode, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Source");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(src, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(src, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Destination");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(dest, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Slot");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(orario, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Aereo");

        aereo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boeing 737", "Boeing 787", "Airbus A320", "Airbus A380" }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(aereo, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aereo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/add2.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(732, 53, -1, -1));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -53, 1080, 850));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        System.out.println("DASHBOARD: Uscita in corso");
        this.setVisible(false);
        new AdminDashboard().setVisible(true);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
         DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String flightcode = fcode.getText();
        String source = src.getText();
        String destination = dest.getText();
        String orariodecollo = orario.getText();
        int naereo = aereo.getSelectedIndex();
        String aereo = null;
        
        if (naereo == 0) {
            aereo = "Boeing737-800";
        } else if (naereo == 1) {
            aereo = "Boeing787";
        } else if (naereo == 2) {
            aereo = "AirbusA320";
        } else if (naereo == 3) {
            aereo = "AirbusA380";
        }

        if (fcode.getText().isEmpty() || src.getText().isEmpty() || dest.getText().isEmpty() || orario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Compila tutti i campi", "ERRORE", JOptionPane.ERROR_MESSAGE);
            System.out.println("FLIGHT MANAGER: Impossibile aggiungere il volo");
            System.out.println("FLIGHT MANAGER: compila tutti i campi");

        } else {
            model.addRow(new Object[]{flightcode, source,destination,orariodecollo,aereo});
            try (FileWriter scrivi = new FileWriter("voli.txt",true)) {
            scrivi.write(flightcode+" "+source+ " " + destination+ " " + orariodecollo+ " " + aereo + "\n");
        } catch (IOException e) {
            
        }
            fcode.setText("");
            src.setText("");
            dest.setText("");
            orario.setText(""); 
            System.out.println("FLIGHT MANAGER: volo aggiunto con successo");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        int row = jTable1.getSelectedRow();
        if (row>=0) {
            String flightcode = (String) model.getValueAt(row, 0);
            String source = (String) model.getValueAt(row, 1);
            String destination = (String) model.getValueAt(row, 2);
            String takeoff = (String) model.getValueAt(row, 3);
            fcode.setText(flightcode);
            src.setText(source);
            dest.setText(destination);
            orario.setText(takeoff); 
            model.removeRow(row);
            cancellariga(row+1);
            System.out.println("FLIGHT MANAGER: modifica volo");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleziona una riga", "ERRORE", JOptionPane.ERROR_MESSAGE);
            System.out.println("FLIGHT MANAGER: impossibile modificare il volo");
            System.out.println("FLIGHT MANAGER: nessuna riga selezionata");

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        boolean trovato = false;
        int i;
        System.out.println("FLIGHT MANAGER: inserire il codice del volo");
        String codice = JOptionPane.showInputDialog("Inserisci il codice del volo");
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    for ( i = 0; i < model.getRowCount(); i++) {
        if (model.getValueAt(i, 0).equals(codice)) {
            System.out.println("FLIGHT MANAGER: volo trovato");
            trovato = true;
            String source = (String) model.getValueAt(i, 1);
            String destination = (String) model.getValueAt(i, 2);
            String decollo = (String) model.getValueAt(i, 3);
            String aereo = (String) model.getValueAt(i, 4);
            JOptionPane.showMessageDialog(null, "HO TROVATO IL VOLO CON CODICE:" + codice + "\nDecollo: " + source + "\nDestinazione:" + destination + "\nOrario Decollo:" + decollo + "\nAereo: " + aereo, "RICERCA VOLO" , JOptionPane.INFORMATION_MESSAGE);
        }
}

        if (trovato==false) {
            JOptionPane.showMessageDialog(null, "Nessun volo trovato con il codice: " + codice, "NOTICE", HEIGHT);
            System.out.println("FLIGHT MANAGER: nessun volo trovato");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         int row = jTable1.getSelectedRow();
        if (row>=0) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
         int input = JOptionPane.showConfirmDialog(null, "Vuoi eliminare il volo? (l'azione è IRREVERSIBILE)", "ELIMINA VOLO", HEIGHT);
        System.out.println(input);
        if (input == 0) {
             model.removeRow(row);
                System.out.println("FLIGHT MANAGER: volo eliminato con successo");

        cancellariga(row+1);
            JOptionPane.showMessageDialog(null, "Volo Cancellato", "NOTICE", JOptionPane.INFORMATION_MESSAGE);

        }
            
            
           
        
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleziona una riga", "ERRORE", JOptionPane.ERROR_MESSAGE);
            System.out.println("FLIGHT MANAGER: impossibile eliminare il volo");
            System.out.println("FLIGHT MANAGER: nessun volo selezionato");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(AdminFlightManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminFlightManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminFlightManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminFlightManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminFlightManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> aereo;
    private javax.swing.JTextField dest;
    private javax.swing.JTextField fcode;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField orario;
    private javax.swing.JLabel orologio;
    private javax.swing.JTextField src;
    private javax.swing.JLabel wifi;
    // End of variables declaration//GEN-END:variables
}
