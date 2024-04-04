/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package compagniaaereahtml;

import javax.swing.ImageIcon;

/**
 *
 * @author Andrea Contardi
 * Funzioni Principali: Simulare il volo con 6 funzioni:
 * 1. Primary Flight Display: display di volo principali con anemometro (velocità), altimetro, orientamento bussila, orizzonte artificiale, FMA (Flight Mode Anounciator)
 *    parte del pannello che annuncia gli automatismi in uso come il numero dell'autopilot attivo, le modalità di volo orizzontale e verticale
 *    Orizzontale: Lnav (in questa versione eè solo un pulsante che si illumina e l'informazione sull'FMA), VOR (permette di effettuare un orbita intorno ad un VOR (VHF omnidirectional range)
 *    in questo simulatore fa un orbita verso destra facendo aumentare ciclicamente l'orientamente bussola, APP (Approach, in questo simulatore serve a frenare l'aereo una volta che l'altimetro
 *    mostra 0: passa le manette da TOGA/CLB a prima REV e poi IDLE (spiegazioni nel codice). 
 *    Verticali: Altitude: modalità basica (default) è una modalità in cui l'aereo mantiene una cuota preimpostata, ALT/HLD: mantenimento della cuota attuale, V/S: vertical speed salita con una 
 *    velocità costante.
 * 2. Autopilot Control Panel: in questo pannello sono presenti tutti i controlli dell'autopilota inclusi i controlli delle modalita descritte sopra, è in oltre presente il pulsante 
 *    dell'automanette che controlla automaticamente la velocita dei motori impedendo lo stallo, e i 3 pulsante per l'attivazione dell'autopilot (sono tre per ridondanza)
 * 3. Radio Panel: utilizzato per le comunicazioni radio: permette di impostare una frequenza di standby e scambiarla con la frequenza attiva con l'apposito tasto, è inoltre possibile
 *    scegliere la modalità di trasmissione radio (VHF, HF, AM)
 * 4. Engine Panel: pagine da cui si controllano i motori: sono presenti degli indicatori di stato (accensione e spegnimento), gli interruttori principali (per accendere i propulsori è necessario 
 *    avviare prima l'APU), controllo: scelta della potenza dei moti, Display delle informazioni attuali dei motori come velocità di rotazione del compresso a bassa pressione (N1) e 
 *    temperatura dei gas di scarico (EGT)
 *5. Landing Gear: pannello da cui è possibile controllare il carrello d'atterraggio
 * 6. controllo di flap e spoiler: i flap o ipersostentatori in italiano sono delle superfici che fuoriescono dall'ala per aumentarne la portanza e la resistenza -> si potrà andare più
 *    lenti, ma consumando più carburante, ci sono 6 gradazioni di flap: 1,5,10,15,25,40 gradi. Gli spoiler al contrario hanno la funzione di ridurre la portanza una volta effettuato l'atterraggio
 *    in modo da fermare l'aereo, questi ultimi possono essere armati con l'apposito pulsante "ARM" per far in modo che si attivino automaticamente non appena avviene il contatto con il suolo
 */
public class PilotFly extends javax.swing.JFrame {

    //variabili autopilot
    private boolean ap1 = false;
    private boolean ap2 = false;
    private boolean ap3 = false;
    private boolean vs = false;
    private int verticalspeed=0;
    private boolean althld;
    private int althold;
    private boolean approach = false;
    private boolean vorloc = false;
    private boolean lnavigation = false;
    private boolean autothrottle = false;
    
    //variabili carrello atterraggio
    private boolean landinggear = false;
    
    //variabili spoiler e flap
    private int spoiler = 0;
    private int flap = 0;
    
    //variabili moroti
    private boolean eng1master = false;
    private boolean eng2master = false;
    private boolean apumaster = false;
    private int manette = 0;
    
    //variabili radio
    private int radio = 0;
    
    //variabili anemometro e altimetro
    private int speed = 0;
    private int altitude = 0 ;
    
    //variabile velocita di stallo base
    private int stallspeed = 104;
    
    //variabile bussole
    private int compass = 0;
    
    
   
    public PilotFly() {
        initComponents();
        
        //stato iniziale motori
        eng1ledon.setVisible(false);
        eng1ledoff.setVisible(true);
        eng1oil.setVisible(true);
        eng2ledon.setVisible(false);
        eng2ledoff.setVisible(true);
        eng2oil.setVisible(true);
        
        //stato iniziale carrello
        gearup.setVisible(false);
        land.setVisible(false);
        
        //avvisatore di stallo
        stall.setVisible(false);
             
             
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton14 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        bussola = new javax.swing.JLabel();
        orizonte = new javax.swing.JLabel();
        nav = new javax.swing.JLabel();
        altmode = new javax.swing.JLabel();
        stall = new javax.swing.JLabel();
        land = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        alt = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        vel = new javax.swing.JLabel();
        altimetro = new javax.swing.JLabel();
        variometro = new javax.swing.JLabel();
        apstate = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        vertical = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        gearup = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lnav = new javax.swing.JButton();
        vor = new javax.swing.JButton();
        app = new javax.swing.JButton();
        active = new javax.swing.JTextField();
        standby = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        at = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        eng1oil = new javax.swing.JLabel();
        eng1ledoff = new javax.swing.JLabel();
        eng1ledon = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        eng2oil = new javax.swing.JLabel();
        eng2ledoff = new javax.swing.JLabel();
        eng2ledon = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        eng1sw = new javax.swing.JButton();
        apusw = new javax.swing.JButton();
        eng2sw = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        eng1perc = new javax.swing.JLabel();
        eng2perc = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        eng2egt = new javax.swing.JLabel();
        eng1egt = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        togab = new javax.swing.JButton();
        clbb = new javax.swing.JButton();
        idleb = new javax.swing.JButton();
        revb = new javax.swing.JButton();
        lnd = new javax.swing.JButton();
        flp = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1920, 1080));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/uscita.png"))); // NOI18N
        jButton14.setToolTipText("");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, 20));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/bussola.png"))); // NOI18N
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1040, -1, -1));

        bussola.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        bussola.setForeground(new java.awt.Color(255, 255, 255));
        bussola.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bussola.setText("0");
        getContentPane().add(bussola, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 1050, 60, -1));

        orizonte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/piano.png"))); // NOI18N
        getContentPane().add(orizonte, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 530, 350, 350));

        nav.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        nav.setForeground(new java.awt.Color(51, 255, 0));
        nav.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nav.setText("NAV OFF");
        getContentPane().add(nav, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 120, -1));

        altmode.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        altmode.setForeground(new java.awt.Color(51, 255, 0));
        altmode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        altmode.setText("ALT");
        getContentPane().add(altmode, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 120, -1));

        stall.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        stall.setForeground(new java.awt.Color(255, 51, 0));
        stall.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stall.setText("STALL");
        getContentPane().add(stall, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, -1, -1));

        land.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        land.setForeground(new java.awt.Color(255, 51, 0));
        land.setText("LANDING GEAR");
        getContentPane().add(land, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 1010, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel11.setText("ALTITUDE");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 7, -1, -1));

        alt.setEditable(false);
        alt.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        alt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        alt.setText("0");
        jPanel3.add(alt, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 31, 108, 34));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/dw.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 83, 48, 49));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/up.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 83, 48, 49));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/althldoff.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 150, 48, 47));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 150, 220));

        vel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        vel.setForeground(new java.awt.Color(255, 255, 255));
        vel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vel.setText("0");
        getContentPane().add(vel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 693, 70, 30));

        altimetro.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        altimetro.setForeground(new java.awt.Color(255, 255, 255));
        altimetro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        altimetro.setText("0");
        getContentPane().add(altimetro, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 690, 90, 30));

        variometro.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        variometro.setForeground(new java.awt.Color(255, 255, 255));
        variometro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        variometro.setText("0");
        getContentPane().add(variometro, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 640, 70, 30));

        apstate.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        apstate.setForeground(new java.awt.Color(51, 255, 0));
        apstate.setText("A/P OFF");
        getContentPane().add(apstate, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel8.setText("A/P ENGAGE");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/Ap1off.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/ap2off.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/ap3off.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/disengage.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel9.setText("DISENGAGE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(61, 61, 61))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 240, 220));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setOpaque(false);

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel10.setText("VERT SPEED");

        vertical.setEditable(false);
        vertical.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        vertical.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        vertical.setText("0");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/dw.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/up.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/vsoff.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addComponent(jLabel10))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(25, 25, 25)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(vertical, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vertical, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 160, 220));

        gearup.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        gearup.setForeground(new java.awt.Color(255, 255, 0));
        gearup.setText("POSITIVE CLIMB - GEAR UP");
        getContentPane().add(gearup, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 980, -1, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setOpaque(false);

        lnav.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/lnavoff.png"))); // NOI18N
        lnav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnavActionPerformed(evt);
            }
        });

        vor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/voroff.png"))); // NOI18N
        vor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vorActionPerformed(evt);
            }
        });

        app.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/appoff.png"))); // NOI18N
        app.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(app, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vor, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lnav, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lnav, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(vor, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(app, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 110, 220));

        active.setEditable(false);
        active.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        active.setForeground(new java.awt.Color(255, 204, 0));
        active.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        active.setText("000.00");
        active.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activeActionPerformed(evt);
            }
        });
        getContentPane().add(active, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 110, 170, 50));

        standby.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        standby.setForeground(new java.awt.Color(255, 204, 0));
        standby.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        standby.setText("000.00");
        getContentPane().add(standby, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 110, 170, 50));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel5.setOpaque(false);

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/vhf1off.png"))); // NOI18N
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/vhf2off.png"))); // NOI18N
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/vhf3off.png"))); // NOI18N
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/hf1off.png"))); // NOI18N
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/hf2off.png"))); // NOI18N
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/amoff.png"))); // NOI18N
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton13.setText("OFF");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton13))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 170, 240, 160));

        at.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/atoff.png"))); // NOI18N
        at.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atActionPerformed(evt);
            }
        });
        getContentPane().add(at, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 50, 50));

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/scambia.png"))); // NOI18N
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 120, 60, 30));

        jPanel6.setOpaque(false);

        jLabel14.setForeground(new java.awt.Color(0, 255, 255));
        jLabel14.setText("ENG 1");

        jLabel15.setForeground(new java.awt.Color(0, 255, 255));
        jLabel15.setText("ENG 2");

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eng1oil.setForeground(new java.awt.Color(255, 255, 0));
        eng1oil.setText("LOW OIL PRESSURE");
        jPanel7.add(eng1oil, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 37));

        eng1ledoff.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        eng1ledoff.setForeground(new java.awt.Color(255, 0, 51));
        eng1ledoff.setText("OFF");
        jPanel7.add(eng1ledoff, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 67, -1, -1));

        eng1ledon.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        eng1ledon.setForeground(new java.awt.Color(0, 255, 51));
        eng1ledon.setText("ON");
        jPanel7.add(eng1ledon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eng2oil.setForeground(new java.awt.Color(255, 255, 0));
        eng2oil.setText("LOW OIL PRESSURE");
        jPanel8.add(eng2oil, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 37));

        eng2ledoff.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        eng2ledoff.setForeground(new java.awt.Color(255, 0, 51));
        eng2ledoff.setText("OFF");
        jPanel8.add(eng2ledoff, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        eng2ledon.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        eng2ledon.setForeground(new java.awt.Color(0, 255, 51));
        eng2ledon.setText("ON");
        jPanel8.add(eng2ledon, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel9.setOpaque(false);

        jLabel22.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 255, 255));
        jLabel22.setText("MASTER SW");

        eng1sw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/eng1off.png"))); // NOI18N
        eng1sw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eng1swActionPerformed(evt);
            }
        });

        apusw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/apuoff.png"))); // NOI18N
        apusw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apuswActionPerformed(evt);
            }
        });

        eng2sw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/eng2off.png"))); // NOI18N
        eng2sw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eng2swActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(eng1sw, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(apusw, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(eng2sw, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eng2sw, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(apusw, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(eng1sw, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel23.setForeground(new java.awt.Color(0, 255, 255));
        jLabel23.setText("N1");

        eng1perc.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        eng1perc.setForeground(new java.awt.Color(255, 255, 255));
        eng1perc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eng1perc.setText("0.0");

        eng2perc.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        eng2perc.setForeground(new java.awt.Color(255, 255, 255));
        eng2perc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eng2perc.setText("0.0");

        jLabel26.setForeground(new java.awt.Color(0, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("EGT");

        eng2egt.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        eng2egt.setForeground(new java.awt.Color(255, 255, 255));
        eng2egt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eng2egt.setText("0");

        eng1egt.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        eng1egt.setForeground(new java.awt.Color(255, 255, 255));
        eng1egt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eng1egt.setText("0");

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel10.setOpaque(false);

        jLabel29.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 255, 255));
        jLabel29.setText("CONTROL");

        togab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/togaoff.png"))); // NOI18N
        togab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                togabActionPerformed(evt);
            }
        });

        clbb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/climboff.png"))); // NOI18N
        clbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clbbActionPerformed(evt);
            }
        });

        idleb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/idleon.png"))); // NOI18N
        idleb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idlebActionPerformed(evt);
            }
        });

        revb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/revoff.png"))); // NOI18N
        revb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revbActionPerformed(evt);
            }
        });

        lnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/lndoff.png"))); // NOI18N
        lnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lndActionPerformed(evt);
            }
        });

        flp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/flpoff.png"))); // NOI18N
        flp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel29)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lnd, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(togab, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idleb, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clbb, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(flp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(revb, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(clbb, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(togab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(flp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lnd, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idleb, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(revb, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(eng1perc, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel23)
                                .addGap(42, 42, 42))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(eng1egt, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(eng2egt, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(eng2perc, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(112, 112, 112)
                        .addComponent(jLabel15)
                        .addGap(65, 65, 65))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23)
                                    .addComponent(eng1perc))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eng1egt)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(eng2perc)
                                .addGap(10, 10, 10)
                                .addComponent(eng2egt)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 380, 720, 390));

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel12.setText("ACTIVE");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 70, -1, -1));

        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel13.setText("STANDBY");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Engine Panel");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 340, -1, -1));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel5.setText("Radio Panel");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel6.setText("AutoPilot Control Panel");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/radiosf.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 20, 630, 310));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/sfondoap.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 910, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/pfd.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 324, -1, 780));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/enginesf.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(922, 334, -1, 450));

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/lndgdown.png"))); // NOI18N
        jButton11.setContentAreaFilled(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 160, 260));

        jLabel33.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel33.setText("LANDING GEAR");
        jLabel33.setToolTipText("");
        jPanel11.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 7, -1, -1));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/radiosf.png"))); // NOI18N
        jPanel11.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 380, 300));

        getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 790, 380, 300));

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel34.setText("FLAP & SPOILER");
        jPanel12.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 7, -1, -1));

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FLAP", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 18))); // NOI18N
        jPanel13.setOpaque(false);

        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/1off.png"))); // NOI18N
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/5off.png"))); // NOI18N
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/10off.png"))); // NOI18N
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/15off.png"))); // NOI18N
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/25off.png"))); // NOI18N
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jButton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/40off.png"))); // NOI18N
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jButton12.setText("RETRACT");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jButton12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jButton12))
        );

        jPanel12.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 19, 303, 180));

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SPOILER", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 18))); // NOI18N
        jPanel14.setOpaque(false);

        jButton35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/offon.png"))); // NOI18N
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jButton36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/armoff.png"))); // NOI18N
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jButton37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/onoff.png"))); // NOI18N
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jPanel12.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 201, -1, -1));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/radiosf.png"))); // NOI18N
        jPanel12.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 350, 300));

        getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 790, 350, 300));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compagniaaereahtml/bg.png"))); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1740, 1100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Down Altitudine
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if(althold>0) {
            althold -= 5;
        }
        
        String tmp = althold + "";
        alt.setText(tmp);
    }//GEN-LAST:event_jButton8ActionPerformed

    
    private void activeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_activeActionPerformed

    //pulsante autothrottle
    private void atActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atActionPerformed
        // TODO add your handling code here:
         if (autothrottle==false) {
             at.setIcon(new ImageIcon(getClass().getResource("aton.png")));
             autothrottle= true;
             
        } else {
             at.setIcon(new ImageIcon(getClass().getResource("atoff.png")));
             autothrottle=false;
        }
    }//GEN-LAST:event_atActionPerformed

    //pulsante lnav
    private void lnavActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnavActionPerformed
        // TODO add your handling code here:
         if (lnavigation==false) {
             lnav.setIcon(new ImageIcon(getClass().getResource("lnavon.png")));
             approach=false;
             vorloc = false;
             lnavigation = true;
             app.setIcon(new ImageIcon(getClass().getResource("appoff.png")));
             vor.setIcon(new ImageIcon(getClass().getResource("voroff.png")));

             
        } else {
             lnav.setIcon(new ImageIcon(getClass().getResource("lnavoff.png")));
             lnavigation=false;
        }
    }//GEN-LAST:event_lnavActionPerformed

    //pulsante vor/loc
    private void vorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vorActionPerformed
        // TODO add your handling code here:
        if (vorloc==false) {
             vor.setIcon(new ImageIcon(getClass().getResource("voron.png")));
             approach=false;
             vorloc = true;
             lnavigation = false;
             app.setIcon(new ImageIcon(getClass().getResource("appoff.png")));
             lnav.setIcon(new ImageIcon(getClass().getResource("lnavoff.png")));
             if (altitude>0) {
                 orizonte.setIcon(new ImageIcon(getClass().getResource("vordestra.png")));
             }
             
            

             
        } else {
             vor.setIcon(new ImageIcon(getClass().getResource("voroff.png")));
             vorloc=false;
        }
    }//GEN-LAST:event_vorActionPerformed
    
    //pulsante Approach
    private void appActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appActionPerformed
        // TODO add your handling code here:
        if (approach==false) {
             app.setIcon(new ImageIcon(getClass().getResource("appon.png")));
             approach=true;
             vorloc = false;
             lnavigation = false;
             vor.setIcon(new ImageIcon(getClass().getResource("voroff.png")));
             lnav.setIcon(new ImageIcon(getClass().getResource("lnavoff.png")));

             
        } else {
             app.setIcon(new ImageIcon(getClass().getResource("appoff.png")));
             approach=false;
        }
    }//GEN-LAST:event_appActionPerformed

    //pulsante UP Altitudine
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
         althold += 5;
        String tmp = althold + "";
        alt.setText(tmp);
    }//GEN-LAST:event_jButton9ActionPerformed
    
    //pulsante altitude hold -> imposta l'altitudine attuale come obiettivo e disabilita i pulsanti per modifica 
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        int temp=0;
        if (althld==false) {
             jButton10.setIcon(new ImageIcon(getClass().getResource("althldon.png")));
             althld=true;
             vs = false;
             jButton7.setIcon(new ImageIcon(getClass().getResource("vsoff.png")));
             temp = althold;
             
             alt.setText(altimetro.getText());
             jButton8.setVisible(false);
             jButton9.setVisible(false);

             
        } else {
             jButton10.setIcon(new ImageIcon(getClass().getResource("althldoff.png")));
             althld=false;
             jButton8.setVisible(true);
             jButton9.setVisible(true);
             althold=temp;
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    //Pulsante Down Vertical Speed
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        verticalspeed -= 5;
        String tmp = verticalspeed + "";
        vertical.setText(tmp);
    }//GEN-LAST:event_jButton5ActionPerformed

    //Pulsante UP vertical speed
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         verticalspeed += 5;
        String tmp = verticalspeed + "";
        vertical.setText(tmp);
    }//GEN-LAST:event_jButton6ActionPerformed

    //pulsante attivazione vertical speed
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if (vs==false) {
             jButton7.setIcon(new ImageIcon(getClass().getResource("vson.png")));
             vs=true;
             althld = false;
             jButton10.setIcon(new ImageIcon(getClass().getResource("althldoff.png")));
             jButton8.setVisible(true);
             jButton9.setVisible(true);
             
        } else {
             jButton7.setIcon(new ImageIcon(getClass().getResource("vsoff.png")));
             vs=false;
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    //pulsante attivazione autopilot 1
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (ap1==false) {
             jButton1.setIcon(new ImageIcon(getClass().getResource("Ap1on.png")));
             ap1=true;
        } else {
             jButton1.setIcon(new ImageIcon(getClass().getResource("Ap1off.png")));
             ap1=false;
        }
        
        
            jButton2.setIcon(new ImageIcon(getClass().getResource("ap2off.png")));
            ap2=false;
            jButton3.setIcon(new ImageIcon(getClass().getResource("ap3off.png")));
            ap3=false;
    }//GEN-LAST:event_jButton1ActionPerformed

    //pulsante attivazione autopilot 2
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (ap2==false) {
             jButton2.setIcon(new ImageIcon(getClass().getResource("ap2on.png")));
             ap2=true;
        } else {
             jButton2.setIcon(new ImageIcon(getClass().getResource("ap2off.png")));
             ap2=false;
        }
        
            jButton1.setIcon(new ImageIcon(getClass().getResource("Ap1off.png")));
            ap1=false;
            jButton3.setIcon(new ImageIcon(getClass().getResource("ap3off.png")));
            ap3=false;
    }//GEN-LAST:event_jButton2ActionPerformed

    //pulsante attivazione autopilot 3
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if (ap3==false) {
             jButton3.setIcon(new ImageIcon(getClass().getResource("ap3on.png")));
             ap3=true;
        } else {
             jButton3.setIcon(new ImageIcon(getClass().getResource("ap3off.png")));
             ap3=false;
        }
        
            jButton1.setIcon(new ImageIcon(getClass().getResource("Ap1off.png")));
            ap1=false;
            jButton2.setIcon(new ImageIcon(getClass().getResource("ap2off.png")));
            ap2=false;
    }//GEN-LAST:event_jButton3ActionPerformed

    //pulsante disengage autopilot
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        ap1 = false;
        ap2= false;
        ap3=false;
        jButton1.setIcon(new ImageIcon(getClass().getResource("Ap1off.png")));
        jButton2.setIcon(new ImageIcon(getClass().getResource("Ap2off.png")));
        jButton3.setIcon(new ImageIcon(getClass().getResource("Ap3off.png")));
        apstate.setText("A/P OFF");
    }//GEN-LAST:event_jButton4ActionPerformed

    //controllo carrello d'atterraggio
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:

        if (landinggear==false) {
             jButton11.setIcon(new ImageIcon(getClass().getResource("lndgup.png")));
             landinggear= true;
             
        } else {
             jButton11.setIcon(new ImageIcon(getClass().getResource("lndgdown.png")));
             landinggear=false;
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    
    //pulsante spegnimento spoiler
    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        // TODO add your handling code here:
        spoiler = 0;
        spoilercontrol();
    }//GEN-LAST:event_jButton35ActionPerformed

    //pulsante "ARM" degli spoiler -> quando si tocca terra gli spoiler si aprono automaticamente (Spoiler o aerofreni servono a rallentare l'aereo una volta a terra)
    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        // TODO add your handling code here:
        spoiler = 1;
        spoilercontrol();
         
    }//GEN-LAST:event_jButton36ActionPerformed

    // pulsante attuvazione manuale spoiler
    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        // TODO add your handling code here:
        
        spoiler = 2;
        spoilercontrol();
    }//GEN-LAST:event_jButton37ActionPerformed

    //pulsante flap a 1 grado
    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
        flap = 1;
        flapcontrol();
        stallspeed=95;
    }//GEN-LAST:event_jButton29ActionPerformed
    
    //pulsante flap a 5 gradi
    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
        flap = 5;
        flapcontrol();
        stallspeed=88;
    }//GEN-LAST:event_jButton30ActionPerformed

    //pulsante flap a 10 gradi
    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        // TODO add your handling code here:
        flap = 10;
        flapcontrol();
        stallspeed=80;
    }//GEN-LAST:event_jButton31ActionPerformed

    //pulsante flap a 15 gradi
    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        // TODO add your handling code here:
        flap = 15;
        flapcontrol();
        stallspeed=70;
    }//GEN-LAST:event_jButton32ActionPerformed

    //pulsante flap a 25 gradi
    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        // TODO add your handling code here:
        flap = 25;
        flapcontrol();
        stallspeed=60;
    }//GEN-LAST:event_jButton33ActionPerformed

    //pulsante flap a 40 gradi (estensione massima)
    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        // TODO add your handling code here:
        flap = 40;
        flapcontrol();
        stallspeed=50;
    }//GEN-LAST:event_jButton34ActionPerformed

    //pulsante ritrazione dei flap
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        flap = 0;
        flapcontrol();
        stallspeed=104;
    }//GEN-LAST:event_jButton12ActionPerformed

    //interruttore principale motore 1
    private void eng1swActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eng1swActionPerformed
        // TODO add your handling code here:
        if ( apumaster == true) {
            if (eng1master==false) {
             eng1sw.setIcon(new ImageIcon(getClass().getResource("eng1on.png")));
             eng1master= true;
             eng1perc.setText("2.2");
             eng1egt.setText("320");
             eng1ledon.setVisible(true);
             eng1ledoff.setVisible(false);
             eng1oil.setVisible(false);
             
        } else {
                if (eng1master == true) {
             eng1sw.setIcon(new ImageIcon(getClass().getResource("eng1off.png")));
             eng1master=false;
             eng1perc.setText("0.0");
             eng1egt.setText("0");
             eng1ledon.setVisible(false);
             eng1ledoff.setVisible(true);
             eng1oil.setVisible(true);
            }
        }  
        }
        
    }//GEN-LAST:event_eng1swActionPerformed
    
    //interrutore principale APU (motore ausiliario che non spinge l'aereo ma offre vari servizi come pressione idraulica, elettricità... è utilizzato per mettere in rotazione il compressore d'alta pressione dei motori per avviarli)
    private void apuswActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apuswActionPerformed
        // TODO add your handling code here:
        if (apumaster==false) {
             apusw.setIcon(new ImageIcon(getClass().getResource("apuon.png")));
             apumaster= true;
             manette = 0;
             manettecontrol();
             eng1control();
             eng2control();
             
        } else {
             apusw.setIcon(new ImageIcon(getClass().getResource("apuoff.png")));
             apumaster=false;
             
        }
    }//GEN-LAST:event_apuswActionPerformed

    //interruttore principale motore 2
    private void eng2swActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eng2swActionPerformed
        // TODO add your handling code here:
        if ( apumaster == true) {
            if (eng2master==false) {
             eng2sw.setIcon(new ImageIcon(getClass().getResource("eng2on.png")));
             eng2master= true;
             eng2perc.setText("2.2");
             eng2egt.setText("320");
             eng2ledon.setVisible(true);
             eng2ledoff.setVisible(false);
             eng2oil.setVisible(false);
             
        } else {
                if (eng2master == true) {
             eng2sw.setIcon(new ImageIcon(getClass().getResource("eng2off.png")));
             eng2master=false;
             eng2perc.setText("0.0");
             eng2egt.setText("0");
             eng2ledon.setVisible(false);
             eng2ledoff.setVisible(true);
             eng2oil.setVisible(true);
            }
        }  
        }
    }//GEN-LAST:event_eng2swActionPerformed

    //pulsante IDLE manette (potenza minima dei motori)
    private void idlebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idlebActionPerformed
        // TODO add your handling code here:
        manette = 0;
        manettecontrol();
        eng1control();
        eng2control();
        
    }//GEN-LAST:event_idlebActionPerformed

    //pulsante CLB (CLIMB) manette (poco meno del massimo della potenza, utilizzata durante la salita)
    private void clbbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clbbActionPerformed
        // TODO add your handling code here:
        manette=1;
        manettecontrol();
        eng1control();
        eng2control();
    }//GEN-LAST:event_clbbActionPerformed

    //pulsante TOGA (TakeOff GoArounf) manette (offre la potenza massima possibili durante il decollo ed il go around o riattaccata quando un atterraggio non convincie si preme toga e si risale per tentare un nuovo atterraggio piu tardi)
    private void togabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_togabActionPerformed
        // TODO add your handling code here:
        manette=2;
        manettecontrol();
        eng1control();
        eng2control();
    }//GEN-LAST:event_togabActionPerformed

    //pulsante REV (REVerse) della manetta (inversori di spinta usati per frenare dopo l'atterraggio insieme agli spoiler)
    private void revbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revbActionPerformed
        // TODO add your handling code here:
        manette=-1;
        manettecontrol();
        eng1control();
        eng2control();
    }//GEN-LAST:event_revbActionPerformed

    //pulsannte scambio frequenze radio (un è quella attiva non modificabile, l'altra è la standby modificabile, alla pressione del pulsante si scambiano)
    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        
        String standbyv = standby.getText();
        String activev = active.getText();
        
        active.setText(standbyv);
        standby.setText(activev);
    }//GEN-LAST:event_jButton15ActionPerformed

    //pulsante Off radio
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        radio = 0;
        radiocontrol();
    }//GEN-LAST:event_jButton13ActionPerformed

    //pulsante VHF1
    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        radio=1;
        radiocontrol();
    }//GEN-LAST:event_jButton16ActionPerformed

    //pulsante VHF2
    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        radio = 2;
        radiocontrol();
        
    }//GEN-LAST:event_jButton17ActionPerformed

    //pulsante VHF3
    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
       radio = 3;
       radiocontrol();
    }//GEN-LAST:event_jButton18ActionPerformed

    //pulsante HF1
    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        radio = 4;
        radiocontrol();
    }//GEN-LAST:event_jButton19ActionPerformed

    //pulsante AM
    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        radio = 5;
        radiocontrol();
    }//GEN-LAST:event_jButton21ActionPerformed

    //pulsante HF2
    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        radio = 6;
        radiocontrol();
    }//GEN-LAST:event_jButton20ActionPerformed

    //metodo principale: al movimento del mouse vengono effettuate tutte le azioni
    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
        
        String speeds = speed + "";
        String alts = altitude + "";
        vel.setText(speeds);
        altimetro.setText(alts);
        String vv = "";
        int vert=0;
        
        
        String altitudes;
        int altit=0;
        
        if (vorloc == false || ap1== false && ap2 == false && ap3 == false || altitude == 0) {
            orizonte.setIcon(new ImageIcon(getClass().getResource("piano.png")));
        } else {
            orizonte.setIcon(new ImageIcon(getClass().getResource("vordestra.png")));
        }
        
        
        if (eng1master == true || eng2master == true) {
            if (manette == 2) {
                if (altitude == 0) {
                    if (speed<104) {
                        speed++;
                    }
                } else if (altitude>0 && altitude < 5000) {
                    if(speed<300) {
                        speed+=5;
                    }
                } else if (altitude>=5000) {
                    if (speed<800) {
                        speed+=5;
                    }
                    
                }
            } else if (manette == 0) {
                if (speed > 0) {
                   speed--; 
                }
                
            } else if (manette == -1) {
                if (speed > -40) {
                    speed -= 5;
                }
                
            } else if (manette == 3) {
                if (speed>60) {
                    speed--;
                } else if (speed<60) {
                    speed++;
                }
            } else if (manette == 4) {
                if (altitude != 0) {
                    if (speed>104) {
                    speed--;
                } else if (speed<104) {
                    speed++;
                }
                } else {
                    if (speed>80) {
                    speed--;
                } else if (speed<80) {
                    speed++;
                }
                }
                
            } else if (manette == 1) {
                if (altitude == 0) {
                    if (speed<90) {
                        speed++;
                    } else if (speed >90) {
                        speed--;
                    }
                } else if (altitude>0 && altitude < 5000) {
                    if(speed<300) {
                        speed++;
                    } 
                } else if (altitude>=5000) {
                    if (speed<800) {
                        speed++;
                    }
                    
                }
            }
        } else {
            if (speed>0) {
                speed--;
            }
           
        }
        
        if (ap1 == true || ap2 == true || ap3 == true) {
            
            if (vs==true && altitude >100 && speed >= stallspeed) {
                vv = vertical.getText();
                vert = Integer.parseInt(vv);
                variometro.setText(vv);
                
                if (altitude >0) {
                   altitude += vert; 
                   
                   if (vert == 0) {
                       orizonte.setIcon(new ImageIcon(getClass().getResource("piano.png")));
                   } else
                   if (vert==5) {
                       orizonte.setIcon(new ImageIcon(getClass().getResource("salita5.png")));
                   } else if (vert ==10) {
                       orizonte.setIcon(new ImageIcon(getClass().getResource("salita10.png")));
                   } else if (vert == 15) {
                       orizonte.setIcon(new ImageIcon(getClass().getResource("salita15.png")));
                   } else if (vert >= 20) {
                       orizonte.setIcon(new ImageIcon(getClass().getResource("salita20.png")));
                   } else if (vert == -5) {
                       orizonte.setIcon(new ImageIcon(getClass().getResource("discesa5.png")));
                   } else if (vert == -10) {
                       orizonte.setIcon(new ImageIcon(getClass().getResource("discesa10.png")));
                   } else if (vert == -15) {
                       orizonte.setIcon(new ImageIcon(getClass().getResource("discesa15.png")));
                   } else if (vert<= -20) {
                       orizonte.setIcon(new ImageIcon(getClass().getResource("discesa20.png")));
                   }
                   
                   
                   
                }
                
                
            } else {
                vs =false;
                jButton7.setIcon(new ImageIcon(getClass().getResource("vsoff.png")));
                variometro.setText("?");
                 altitudes = alt.getText();
                altit = Integer.parseInt(altitudes);
                if(speed>=stallspeed) {
                
                if (altitude < altit) {
                    altitude++;
                    orizonte.setIcon(new ImageIcon(getClass().getResource("salita5.png")));
                } else if (altitude > altit) {
                    altitude--;
                    orizonte.setIcon(new ImageIcon(getClass().getResource("discesa5.png")));
                }
            }
            }
            
            if (ap1 == true) {
                apstate.setText("A/P ON:1");
            } else if (ap2 == true) {
                apstate.setText("A/P ON:2");
            } else if (ap3 = true) {
                apstate.setText("A/P ON:3");
            } 
            
            if (autothrottle == true ) {
                
                if (altitude > 0) {
                 if(speed<stallspeed) {
                    manette=2;
                    manettecontrol();
                    eng1control();
                    eng2control();
                } else if(altitude>5000) {
                    manette=1;
                    manettecontrol();
                    eng1control();
                    eng2control();
                }   
                } else if (approach == true){
                    if (speed>50) {
                        manette=-1 ;
                        manettecontrol();
                        eng1control();
                        eng2control();
                    } else {
                        manette=0;
                        manettecontrol();
                        eng1control();
                        eng2control();
                        speed = 0;
                    }
                    
                }
                
            }
            
            
            if (vorloc == true && altitude>0) {
            String temp = bussola.getText();
            compass = Integer.parseInt(temp);
            if (compass<=360) {
                compass++;
            } else {
                compass = 0;
            }
            
            temp = compass + "";
            bussola.setText(temp);
            
        }
           
        }
        
        if (altitude > 100 ) {
                if (landinggear == false) {
                    gearup.setVisible(true);
                } else {
                   gearup.setVisible(false); 
                }
                    
                
                
            } else {
                gearup.setVisible(false);
            }
            
            if (altitude<100 && landinggear == true) {
                land.setVisible(true);
            } else {
                land.setVisible(false);
            }
        
            if (speed <stallspeed && altitude >0) {
                stall.setVisible(true);
                altitude--;
                orizonte.setIcon(new ImageIcon(getClass().getResource("discesa20.png")));
            } else {
                stall.setVisible(false);
            }
            
            
        if (spoiler == 1 && altitude == 0) {
            spoiler = 2;
            spoilercontrol();
            
        }
        
        if (speed>200) {
            flap=0;
            stallspeed=104;
            flapcontrol();
        }
        
        
        if (vs==false && althld ==false) {
            altmode.setText("ALT");
        } else if (althld == true) {
            altmode.setText("ALT/HLD");
        } else if (vs == true) {
            altmode.setText("V/S");
        }
        
        if (approach == true) {
            nav.setText("APP");
        } else if (vorloc == true) {
             nav.setText("VOR/LOC");
        } else if (lnavigation == true) {
            nav.setText("LNAV");
        } else {
            nav.setText("NAV OFF");
        }
        
        
        
        
    }//GEN-LAST:event_formMouseMoved
    
    //pulsante exit
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
         
        this.setVisible(false);
        new PilotDashboard().setVisible(true);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void lndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lndActionPerformed
        // TODO add your handling code here:
        manette = 3;
        manettecontrol();
        eng1control();
        eng2control();
    }//GEN-LAST:event_lndActionPerformed

    private void flpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flpActionPerformed
        // TODO add your handling code here:
        manette = 4;
        manettecontrol();
        eng1control();
        eng2control();
    }//GEN-LAST:event_flpActionPerformed

    //metodo per cambiare i tasti degli spoiler
    private void spoilercontrol () {
        if (spoiler == 0 ) {
             jButton35.setIcon(new ImageIcon(getClass().getResource("offon.png")));
             jButton36.setIcon(new ImageIcon(getClass().getResource("armoff.png")));
             jButton37.setIcon(new ImageIcon(getClass().getResource("onoff.png")));
             
         } else if (spoiler==1) {
             jButton35.setIcon(new ImageIcon(getClass().getResource("offoff.png")));
             jButton36.setIcon(new ImageIcon(getClass().getResource("armon.png")));
             jButton37.setIcon(new ImageIcon(getClass().getResource("onoff.png")));
             
         } else if (spoiler == 2) {
             jButton35.setIcon(new ImageIcon(getClass().getResource("offoff.png")));
             jButton36.setIcon(new ImageIcon(getClass().getResource("armoff.png")));
             jButton37.setIcon(new ImageIcon(getClass().getResource("onon.png")));
         }
    }
    
    //metodo per cambiare i tasti dei flap
    private void flapcontrol () {
        if (flap==0) {
            jButton29.setIcon(new ImageIcon(getClass().getResource("1off.png")));
            jButton30.setIcon(new ImageIcon(getClass().getResource("5off.png")));
            jButton31.setIcon(new ImageIcon(getClass().getResource("10off.png")));
            jButton32.setIcon(new ImageIcon(getClass().getResource("15off.png")));
            jButton33.setIcon(new ImageIcon(getClass().getResource("25off.png")));
            jButton34.setIcon(new ImageIcon(getClass().getResource("40off.png")));
                    
        } else if (flap == 1) {
            jButton29.setIcon(new ImageIcon(getClass().getResource("1on.png")));
            jButton30.setIcon(new ImageIcon(getClass().getResource("5off.png")));
            jButton31.setIcon(new ImageIcon(getClass().getResource("10off.png")));
            jButton32.setIcon(new ImageIcon(getClass().getResource("15off.png")));
            jButton33.setIcon(new ImageIcon(getClass().getResource("25off.png")));
            jButton34.setIcon(new ImageIcon(getClass().getResource("40off.png")));
        } else if (flap == 5) {
            jButton29.setIcon(new ImageIcon(getClass().getResource("1off.png")));
            jButton30.setIcon(new ImageIcon(getClass().getResource("5on.png")));
            jButton31.setIcon(new ImageIcon(getClass().getResource("10off.png")));
            jButton32.setIcon(new ImageIcon(getClass().getResource("15off.png")));
            jButton33.setIcon(new ImageIcon(getClass().getResource("25off.png")));
            jButton34.setIcon(new ImageIcon(getClass().getResource("40off.png")));
        } else if (flap == 10) {
            jButton29.setIcon(new ImageIcon(getClass().getResource("1off.png")));
            jButton30.setIcon(new ImageIcon(getClass().getResource("5off.png")));
            jButton31.setIcon(new ImageIcon(getClass().getResource("10on.png")));
            jButton32.setIcon(new ImageIcon(getClass().getResource("15off.png")));
            jButton33.setIcon(new ImageIcon(getClass().getResource("25off.png")));
            jButton34.setIcon(new ImageIcon(getClass().getResource("40off.png")));
        } else if (flap == 15) {
            jButton29.setIcon(new ImageIcon(getClass().getResource("1off.png")));
            jButton30.setIcon(new ImageIcon(getClass().getResource("5off.png")));
            jButton31.setIcon(new ImageIcon(getClass().getResource("10off.png")));
            jButton32.setIcon(new ImageIcon(getClass().getResource("15on.png")));
            jButton33.setIcon(new ImageIcon(getClass().getResource("25off.png")));
            jButton34.setIcon(new ImageIcon(getClass().getResource("40off.png")));
        } else if (flap == 25) {
            jButton29.setIcon(new ImageIcon(getClass().getResource("1off.png")));
            jButton30.setIcon(new ImageIcon(getClass().getResource("5off.png")));
            jButton31.setIcon(new ImageIcon(getClass().getResource("10off.png")));
            jButton32.setIcon(new ImageIcon(getClass().getResource("15off.png")));
            jButton33.setIcon(new ImageIcon(getClass().getResource("25on.png")));
            jButton34.setIcon(new ImageIcon(getClass().getResource("40off.png")));
        } else if (flap == 40) {
            jButton29.setIcon(new ImageIcon(getClass().getResource("1off.png")));
            jButton30.setIcon(new ImageIcon(getClass().getResource("5off.png")));
            jButton31.setIcon(new ImageIcon(getClass().getResource("10off.png")));
            jButton32.setIcon(new ImageIcon(getClass().getResource("15off.png")));
            jButton33.setIcon(new ImageIcon(getClass().getResource("25off.png")));
            jButton34.setIcon(new ImageIcon(getClass().getResource("40on.png")));
        }
    }
    
    //metodo per cambiare i tasti delle manette
    private void manettecontrol () {
        if (manette == 0) {
            idleb.setIcon(new ImageIcon(getClass().getResource("idleon.png")));
            clbb.setIcon(new ImageIcon(getClass().getResource("climboff.png")));
            togab.setIcon(new ImageIcon(getClass().getResource("togaoff.png")));
            revb.setIcon(new ImageIcon(getClass().getResource("revoff.png")));
            lnd.setIcon(new ImageIcon(getClass().getResource("lndoff.png")));
            flp.setIcon(new ImageIcon(getClass().getResource("flpoff.png")));
        } else if (manette == 1) {
            idleb.setIcon(new ImageIcon(getClass().getResource("idleoff.png")));
            clbb.setIcon(new ImageIcon(getClass().getResource("climbon.png")));
            togab.setIcon(new ImageIcon(getClass().getResource("togaoff.png")));
            revb.setIcon(new ImageIcon(getClass().getResource("revoff.png")));
            lnd.setIcon(new ImageIcon(getClass().getResource("lndoff.png")));
            flp.setIcon(new ImageIcon(getClass().getResource("flpoff.png")));
        } else if (manette == 2) {
            idleb.setIcon(new ImageIcon(getClass().getResource("idleoff.png")));
            clbb.setIcon(new ImageIcon(getClass().getResource("climboff.png")));
            togab.setIcon(new ImageIcon(getClass().getResource("togaon.png")));
            revb.setIcon(new ImageIcon(getClass().getResource("revoff.png")));
            lnd.setIcon(new ImageIcon(getClass().getResource("lndoff.png")));
            flp.setIcon(new ImageIcon(getClass().getResource("flpoff.png")));
        } else if (manette == -1) {
            idleb.setIcon(new ImageIcon(getClass().getResource("idleoff.png")));
            clbb.setIcon(new ImageIcon(getClass().getResource("climboff.png")));
            togab.setIcon(new ImageIcon(getClass().getResource("togaoff.png")));
            revb.setIcon(new ImageIcon(getClass().getResource("revon.png")));
            lnd.setIcon(new ImageIcon(getClass().getResource("lndoff.png")));
            flp.setIcon(new ImageIcon(getClass().getResource("flpoff.png")));
        } else if (manette == 3) {
            idleb.setIcon(new ImageIcon(getClass().getResource("idleoff.png")));
            clbb.setIcon(new ImageIcon(getClass().getResource("climboff.png")));
            togab.setIcon(new ImageIcon(getClass().getResource("togaoff.png")));
            revb.setIcon(new ImageIcon(getClass().getResource("revoff.png")));
            lnd.setIcon(new ImageIcon(getClass().getResource("lndon.png")));
            flp.setIcon(new ImageIcon(getClass().getResource("flpoff.png")));
        } else if (manette == 4) {
            idleb.setIcon(new ImageIcon(getClass().getResource("idleoff.png")));
            clbb.setIcon(new ImageIcon(getClass().getResource("climboff.png")));
            togab.setIcon(new ImageIcon(getClass().getResource("togaoff.png")));
            revb.setIcon(new ImageIcon(getClass().getResource("revoff.png")));
            lnd.setIcon(new ImageIcon(getClass().getResource("lndoff.png")));
            flp.setIcon(new ImageIcon(getClass().getResource("flpon.png")));
        }
    }
    
    //metodo che controlla il motore 1
    private void eng1control () {
        if (eng1master == true) {
            if (manette==0) {
                eng1perc.setText("2.2");
                eng1egt.setText("320");
            } else if (manette == 1) {
                eng1perc.setText("84.7");
                eng1egt.setText("490");
            } else if (manette == 2) {
                eng1perc.setText("100.0");
                eng1egt.setText("520");
            } else if (manette == -1) {
                eng1perc.setText("23.6");
                eng1egt.setText("380");
            } else if (manette == 3) {
                eng1perc.setText("12.2");
                eng1egt.setText("340");
            } else if (manette == 4) {
                eng1perc.setText("24.6");
                eng1egt.setText("390");
            }
        }
        
    }
    
    //metodo che controlla il motore 2
     private void eng2control () {
        if (eng2master == true) {
            if (manette==0) {
                eng2perc.setText("2.2");
                eng2egt.setText("320");
            } else if (manette == 1) {
                eng2perc.setText("84.7");
                eng2egt.setText("490");
            } else if (manette == 2) {
                eng2perc.setText("100.0");
                eng2egt.setText("520");
            } else if (manette == -1) {
                eng2perc.setText("23.6");
                eng2egt.setText("380");
            } else if (manette == 3) {
                eng2perc.setText("12.2");
                eng2egt.setText("340");
            } else if (manette == 4) {
                eng2perc.setText("24.6");
                eng2egt.setText("390");
            }
        }
        
    }
    
     //metodo che controlla la radio
     private void radiocontrol () {
         if (radio == 0 ) {
             jButton16.setIcon(new ImageIcon(getClass().getResource("vhf1off.png")));
             jButton17.setIcon(new ImageIcon(getClass().getResource("vhf2off.png")));
             jButton18.setIcon(new ImageIcon(getClass().getResource("vhf3off.png")));
             jButton19.setIcon(new ImageIcon(getClass().getResource("hf1off.png")));
             jButton21.setIcon(new ImageIcon(getClass().getResource("amoff.png"))); // am
             jButton20.setIcon(new ImageIcon(getClass().getResource("hf2off.png")));
         } else if (radio == 1) {
             jButton16.setIcon(new ImageIcon(getClass().getResource("vhf1on.png")));
             jButton17.setIcon(new ImageIcon(getClass().getResource("vhf2off.png")));
             jButton18.setIcon(new ImageIcon(getClass().getResource("vhf3off.png")));
             jButton19.setIcon(new ImageIcon(getClass().getResource("hf1off.png")));
             jButton21.setIcon(new ImageIcon(getClass().getResource("amoff.png"))); // am
             jButton20.setIcon(new ImageIcon(getClass().getResource("hf2off.png")));
         } else if (radio == 2) {
             jButton16.setIcon(new ImageIcon(getClass().getResource("vhf1off.png")));
             jButton17.setIcon(new ImageIcon(getClass().getResource("vhf2on.png")));
             jButton18.setIcon(new ImageIcon(getClass().getResource("vhf3off.png")));
             jButton19.setIcon(new ImageIcon(getClass().getResource("hf1off.png")));
             jButton21.setIcon(new ImageIcon(getClass().getResource("amoff.png"))); // am
             jButton20.setIcon(new ImageIcon(getClass().getResource("hf2off.png")));
         } else if (radio == 3) {
             jButton16.setIcon(new ImageIcon(getClass().getResource("vhf1off.png")));
             jButton17.setIcon(new ImageIcon(getClass().getResource("vhf2off.png")));
             jButton18.setIcon(new ImageIcon(getClass().getResource("vhf3on.png")));
             jButton19.setIcon(new ImageIcon(getClass().getResource("hf1off.png")));
             jButton21.setIcon(new ImageIcon(getClass().getResource("amoff.png"))); // am
             jButton20.setIcon(new ImageIcon(getClass().getResource("hf2off.png")));
         } else if (radio == 4) {
             jButton16.setIcon(new ImageIcon(getClass().getResource("vhf1off.png")));
             jButton17.setIcon(new ImageIcon(getClass().getResource("vhf2off.png")));
             jButton18.setIcon(new ImageIcon(getClass().getResource("vhf3off.png")));
             jButton19.setIcon(new ImageIcon(getClass().getResource("hf1on.png")));
             jButton21.setIcon(new ImageIcon(getClass().getResource("amoff.png"))); // am
             jButton20.setIcon(new ImageIcon(getClass().getResource("hf2off.png")));
         } else if (radio == 5) {
             jButton16.setIcon(new ImageIcon(getClass().getResource("vhf1off.png")));
             jButton17.setIcon(new ImageIcon(getClass().getResource("vhf2off.png")));
             jButton18.setIcon(new ImageIcon(getClass().getResource("vhf3off.png")));
             jButton19.setIcon(new ImageIcon(getClass().getResource("hf1off.png")));
             jButton21.setIcon(new ImageIcon(getClass().getResource("amon.png"))); // am
             jButton20.setIcon(new ImageIcon(getClass().getResource("hf2off.png")));
         } else if (radio == 6) {
             jButton16.setIcon(new ImageIcon(getClass().getResource("vhf1off.png")));
             jButton17.setIcon(new ImageIcon(getClass().getResource("vhf2off.png")));
             jButton18.setIcon(new ImageIcon(getClass().getResource("vhf3off.png")));
             jButton19.setIcon(new ImageIcon(getClass().getResource("hf1off.png")));
             jButton21.setIcon(new ImageIcon(getClass().getResource("amoff.png"))); // am
             jButton20.setIcon(new ImageIcon(getClass().getResource("hf2on.png")));
         }
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
            java.util.logging.Logger.getLogger(PilotFly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PilotFly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PilotFly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PilotFly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PilotFly().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField active;
    private javax.swing.JTextField alt;
    private javax.swing.JLabel altimetro;
    private javax.swing.JLabel altmode;
    private javax.swing.JButton app;
    private javax.swing.JLabel apstate;
    private javax.swing.JButton apusw;
    private javax.swing.JButton at;
    private javax.swing.JLabel bussola;
    private javax.swing.JButton clbb;
    private javax.swing.JLabel eng1egt;
    private javax.swing.JLabel eng1ledoff;
    private javax.swing.JLabel eng1ledon;
    private javax.swing.JLabel eng1oil;
    private javax.swing.JLabel eng1perc;
    private javax.swing.JButton eng1sw;
    private javax.swing.JLabel eng2egt;
    private javax.swing.JLabel eng2ledoff;
    private javax.swing.JLabel eng2ledon;
    private javax.swing.JLabel eng2oil;
    private javax.swing.JLabel eng2perc;
    private javax.swing.JButton eng2sw;
    private javax.swing.JButton flp;
    private javax.swing.JLabel gearup;
    private javax.swing.JButton idleb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel land;
    private javax.swing.JButton lnav;
    private javax.swing.JButton lnd;
    private javax.swing.JLabel nav;
    private javax.swing.JLabel orizonte;
    private javax.swing.JButton revb;
    private javax.swing.JLabel stall;
    private javax.swing.JTextField standby;
    private javax.swing.JButton togab;
    private javax.swing.JLabel variometro;
    private javax.swing.JLabel vel;
    private javax.swing.JTextField vertical;
    private javax.swing.JButton vor;
    // End of variables declaration//GEN-END:variables
}
