/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package compagniaaereahtml;

/*
//
//@Author: Andrea Contardi
//LogIN: la prima scherma visualizzata del programma 
//Funzioni principali: autenticare gli utenti autorizzati all'interno del file "utenti.txt" per accedere al programma
//e dare l'accesso alla pagina di registrazione per permettere a nuovi utenti di accedere al programma
//utente default: nome utente: master password: master
//con la password di questo utente si possono creare nuovi utenti di tipo Admin o Pilot, per creare utenti di 
//tipo passeggero non è necessaria nessuna password
*/

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class LogIN extends javax.swing.JFrame {

    
    public LogIN() {
        initComponents();
        
        //impostazione dello sfondo e logo
        sfondo.setIcon(new ImageIcon(getClass().getResource("sfondo.png")));
        sfondosfocato.setIcon(new ImageIcon(getClass().getResource("sfondosfocato.png")));
        logo.setIcon(new ImageIcon(getClass().getResource("logo.png")));

        jPanel2.setOpaque(false);
        jPanel3.setOpaque(false);
        login.setOpaque(false);
        
        
        login.setFocusPainted(false);
        login.setBorderPainted(false);
        
        login.setForeground(Color.BLUE);

        
        
        
    }
    
    
    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        uname = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        pwd = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        login = new javax.swing.JButton();
        sfondosfocato = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        sfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(880, 560));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        logo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Username", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 355, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        pwd.setEchoChar('\u25cf');

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 350, -1));

        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Non hai un account? registrati");
        jButton1.setContentAreaFilled(false);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 270, -1));

        login.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel1.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 350, 40));

        sfondosfocato.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(sfondosfocato, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 350));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Questo programma non è associato in alcun modo a Ita Airways / Italia Trasporto Aereo S.p.A.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 520, -1, -1));
        getContentPane().add(sfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //pulsante login -> legge gli utenti dal file "utenti.txt" e confronta se i dati inseriti sono all'interno del file, se presenti allora viene determinato il tipo dell'utente sempre in base al file
    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handleing code here:
        boolean trovato = true;
        String nomeutente = uname.getText();
        String password = pwd.getText();
        String stringa = nomeutente + " " +password;
        
            try {
                
          File myObj = new File("utenti.txt");
          Scanner myReader = new Scanner(myObj);  
          while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            
            int index = data.indexOf(' ');
            index = data.indexOf(' ', index + 1); 
            String dati = data.substring(0, index);
            String tipo = data.substring(index + 1);

       
            
            
            if (stringa.equals(dati)) {
                

                if (tipo.equals(" admin")) {
                    this.setVisible(false);
                    new AdminDashboard().setVisible(true);

                } else if (tipo.equals(" user")) {                    
                    this.setVisible(false);
                    new UserDashboard().setVisible(true);

                } else if (tipo.equals(" pilot")) {
                    
                    this.setVisible(false);
                    new PilotDashboard().setVisible(true);
                } else if (tipo.equals(" root")) {
                    this.setVisible(false);
                    new SimulateUser().setVisible(true);
                }
                System.out.println("LOGIN: Utente " + dati + "(" + tipo + " )" + " autenticato con successo");
                
                
                trovato = true;
                
                break;
                

            } else {
                trovato = false;
            }
          }
          
          if(trovato==false) {
                    JOptionPane.showMessageDialog(null, "Login non riuscito. Riprova.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    System.out.println("LOGIN: tentativo di login errato");
                }
          
          myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        } 
    }//GEN-LAST:event_loginActionPerformed

    //pulsante per la registrazione di un nuovo utente
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false);
        new Registrazione().setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    //metodo per contare le righe di un file
    public static long countLineBufferedReader(String fileName) {

      long lines = 0;
      try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
          while (reader.readLine() != null) lines++;
      } catch (IOException e) {
          e.printStackTrace();
      }
      return lines;

  }
    
    
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
            java.util.logging.Logger.getLogger(LogIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton login;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JLabel sfondo;
    private javax.swing.JLabel sfondosfocato;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}

