/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

/**
 *
 * @author Syl
 * source: 
 * https://www.youtube.com/watch?v=YxCm49O4zt8
 * https://www.youtube.com/watch?v=LFr06ZKIpSM
 * https://www.youtube.com/watch?v=oYs4mPvfNzU
 */
public class PageRecherche extends Header {

    /**
     * Creates new form PageRecherche
     */
    public PageRecherche() {
        initComponents();
        jLabel_groupe.setVisible(false);
        jComboBox_groupe.setVisible(false);
        jTextField_groupe.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox_prof = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField_prof = new javax.swing.JTextField();
        jComboBox_eleve = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextField_eleve = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox_salle = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jTextField_salle = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox_promo = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jTextField_promo = new javax.swing.JTextField();
        active_recherche_groupe = new javax.swing.JToggleButton();
        jButton_recherche_eleve = new javax.swing.JButton();
        jButton_recherche_salle = new javax.swing.JButton();
        jButton_recherche_promotion = new javax.swing.JButton();
        jButton_liste_promotion = new javax.swing.JButton();
        jButton_liste_salle = new javax.swing.JButton();
        jButton_liste_eleve = new javax.swing.JButton();
        jButton_liste_prof = new javax.swing.JButton();
        jLabel_groupe = new javax.swing.JLabel();
        jComboBox_groupe = new javax.swing.JComboBox<>();
        jButton_recherche_prof = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jTextField_groupe = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("professeurs");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Saisir les information pour la recherche :");

        jComboBox_prof.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nom", "id", "email" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Chercher le professeur pas son");

        jTextField_prof.setText("information pour la recherche");
        jTextField_prof.setToolTipText("");
        jTextField_prof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_profActionPerformed(evt);
            }
        });

        jComboBox_eleve.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nom", "ID", "Email", "numero d'eleve" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Chercher l'éleves pas son");

        jTextField_eleve.setText("information pour la recherche");
        jTextField_eleve.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("éleves");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Saisir les information pour la recherche :");

        jComboBox_salle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nom", "ID", "numero d'eleve" }));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Chercher une salle pas son");

        jTextField_salle.setText("information pour la recherche");
        jTextField_salle.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("salles");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Saisir les information pour la recherche :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("promotion");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Saisir les information pour la recherche :");

        jComboBox_promo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nom", "ID" }));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Chercher une promotion pas son");

        jTextField_promo.setText("information pour la recherche");
        jTextField_promo.setToolTipText("");

        active_recherche_groupe.setText("choisire un groupe d'une promotion");
        active_recherche_groupe.setActionCommand("jToggleButton9_test1");
        active_recherche_groupe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                active_recherche_groupe_ActionPerformed_test(evt);
            }
        });

        jButton_recherche_eleve.setText("rechercher");
        jButton_recherche_eleve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_recherche_eleve_ActionPerformed(evt);
            }
        });

        jButton_recherche_salle.setText("rechercher");
        jButton_recherche_salle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_recherche_salle_ActionPerformed(evt);
            }
        });

        jButton_recherche_promotion.setText("rechercher");
        jButton_recherche_promotion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_recherche_promotion_ActionPerformed(evt);
            }
        });

        jButton_liste_promotion.setBackground(new java.awt.Color(0, 122, 123));
        jButton_liste_promotion.setForeground(new java.awt.Color(240, 240, 240));
        jButton_liste_promotion.setText("liest des promotions et groupes");
        jButton_liste_promotion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_liste_promotion_ActionPerformed(evt);
            }
        });

        jButton_liste_salle.setBackground(new java.awt.Color(0, 122, 123));
        jButton_liste_salle.setForeground(new java.awt.Color(240, 240, 240));
        jButton_liste_salle.setText("liest des salles");
        jButton_liste_salle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_liste_salle_ActionPerformed(evt);
            }
        });

        jButton_liste_eleve.setBackground(new java.awt.Color(0, 122, 123));
        jButton_liste_eleve.setForeground(new java.awt.Color(240, 240, 240));
        jButton_liste_eleve.setText("liest des eleves");
        jButton_liste_eleve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_liste_eleve_ActionPerformed(evt);
            }
        });

        jButton_liste_prof.setBackground(new java.awt.Color(0, 122, 123));
        jButton_liste_prof.setForeground(new java.awt.Color(240, 240, 240));
        jButton_liste_prof.setText("liest des professeurs");
        jButton_liste_prof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_liste_prof_ActionPerformed(evt);
            }
        });

        jLabel_groupe.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_groupe.setText("Chercher une groupe pas son");

        jComboBox_groupe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nom", "ID" }));
        jComboBox_groupe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_groupechoix_recherche_promotion(evt);
            }
        });

        jButton_recherche_prof.setText("rechercher");
        jButton_recherche_prof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_recherche_prof_ActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jTextField_groupe.setText("information pour la recherche");
        jTextField_groupe.setToolTipText("");
        jTextField_groupe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_groupeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton_liste_promotion, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton_liste_salle, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton_liste_eleve, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBox_promo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(active_recherche_groupe))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel_groupe)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jComboBox_groupe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField_groupe, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addGap(26, 26, 26)
                                    .addComponent(jTextField_promo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addComponent(jButton_recherche_promotion))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_prof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(42, 42, 42)
                                .addComponent(jTextField_prof, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_recherche_prof)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox_eleve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField_eleve, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton_recherche_eleve))
                        .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox_salle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField_salle, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton_recherche_salle)))
                    .addComponent(jButton_liste_prof))
                .addContainerGap(492, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox_prof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_prof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_recherche_prof))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_liste_prof)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox_eleve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_eleve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_recherche_eleve))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_liste_eleve)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox_salle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField_salle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_recherche_salle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_liste_salle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBox_promo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField_promo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_recherche_promotion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_groupe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_groupe)
                    .addComponent(active_recherche_groupe)
                    .addComponent(jTextField_groupe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_liste_promotion)
                .addGap(45, 45, 45))
        );

        active_recherche_groupe.getAccessibleContext().setAccessibleName("jToggleButton9_test3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void active_recherche_groupe_ActionPerformed_test(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_active_recherche_groupe_ActionPerformed_test
        // TODO add your handling code here:
        if(active_recherche_groupe.isSelected())
        {
            jLabel_groupe.setVisible(true);
            jComboBox_groupe.setVisible(true);
            jTextField_groupe.setVisible(true);
        }
        else
        {
            jLabel_groupe.setVisible(false);
            jComboBox_groupe.setVisible(false);
            jTextField_groupe.setVisible(false);
        }
    }//GEN-LAST:event_active_recherche_groupe_ActionPerformed_test

    private void jButton_recherche_eleve_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_recherche_eleve_ActionPerformed
        String typeRecherche = this.jComboBox_eleve.getSelectedItem().toString();
        String infoRecherche = this.jTextField_eleve.getText();
        
        if(("" == infoRecherche) || ("information pour la recherche" == infoRecherche))
        {
            //ça marche pas je sais pas pourquoi
            System.out.println("erreur, information de recherche saisie invalide");
        }
        else
        {
            System.out.println(typeRecherche + " " + infoRecherche);
        }
    }//GEN-LAST:event_jButton_recherche_eleve_ActionPerformed

    private void jButton_recherche_salle_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_recherche_salle_ActionPerformed
        String typeRecherche = this.jComboBox_salle.getSelectedItem().toString();
        String infoRecherche = this.jTextField_salle.getText();
        
        if(("" == infoRecherche) || ("information pour la recherche" == infoRecherche))
        {
            //ça marche pas je sais pas pourquoi
            System.out.println("erreur, information de recherche saisie invalide");
        }
        else
        {
            System.out.println(typeRecherche + " " + infoRecherche);
        }
    }//GEN-LAST:event_jButton_recherche_salle_ActionPerformed

    private void jButton_recherche_promotion_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_recherche_promotion_ActionPerformed
        String typeRecherchePromo = this.jComboBox_promo.getSelectedItem().toString();
        String infoRecherchePromo = this.jTextField_eleve.getText();
        
        if(this.active_recherche_groupe.isSelected())
        {
            String typeRechercheGroupe = this.jComboBox_groupe.getSelectedItem().toString();
            String infoRechercheGroupe = this.jTextField_groupe.getText();
            
            if(("" == infoRecherchePromo) || ("information pour la recherche" == infoRecherchePromo)
             ||("" == infoRechercheGroupe) || ("information pour la recherche" == infoRechercheGroupe))
            {
                //ça marche pas je sais pas pourquoi
                System.out.println("erreur, information de recherche saisie invalide");
            }
            else
            {
                System.out.println(typeRecherchePromo + " " + infoRecherchePromo + " ; " + typeRechercheGroupe + " " + infoRechercheGroupe);
            }
        }
        else
        {
            if(("" == infoRecherchePromo) || ("information pour la recherche" == infoRecherchePromo))
            {
                //ça marche pas je sais pas pourquoi
                System.out.println("erreur, information de recherche saisie invalide");
            }
            else
            {
                System.out.println(typeRecherchePromo + " " + infoRecherchePromo);
            }
        }
        
    }//GEN-LAST:event_jButton_recherche_promotion_ActionPerformed

    private void jButton_liste_promotion_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_liste_promotion_ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton_liste_promotion_ActionPerformed

    private void jButton_liste_salle_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_liste_salle_ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton_liste_salle_ActionPerformed

    private void jButton_liste_eleve_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_liste_eleve_ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton_liste_eleve_ActionPerformed

    private void jButton_liste_prof_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_liste_prof_ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton_liste_prof_ActionPerformed

    private void jComboBox_groupechoix_recherche_promotion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_groupechoix_recherche_promotion
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox_groupechoix_recherche_promotion

    private void jButton_recherche_prof_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_recherche_prof_ActionPerformed
        String typeRecherche = this.jComboBox_prof.getSelectedItem().toString();
        String infoRecherche = this.jTextField_prof.getText();
        
        if(("" == infoRecherche) || ("information pour la recherche" == infoRecherche))
        {
            //ça marche pas je sais pas pourquoi
            System.out.println("erreur, information de recherche saisie invalide");
        }
        else
        {
            System.out.println(typeRecherche + " " + infoRecherche);
        }
        
        
    }//GEN-LAST:event_jButton_recherche_prof_ActionPerformed

    private void jTextField_groupeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_groupeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_groupeActionPerformed

    private void jTextField_profActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_profActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_profActionPerformed

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
            java.util.logging.Logger.getLogger(PageRecherche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PageRecherche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PageRecherche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PageRecherche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PageRecherche().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton active_recherche_groupe;
    private javax.swing.JButton jButton_liste_eleve;
    private javax.swing.JButton jButton_liste_prof;
    private javax.swing.JButton jButton_liste_promotion;
    private javax.swing.JButton jButton_liste_salle;
    private javax.swing.JButton jButton_recherche_eleve;
    private javax.swing.JButton jButton_recherche_prof;
    private javax.swing.JButton jButton_recherche_promotion;
    private javax.swing.JButton jButton_recherche_salle;
    private javax.swing.JComboBox<String> jComboBox_eleve;
    private javax.swing.JComboBox<String> jComboBox_groupe;
    private javax.swing.JComboBox<String> jComboBox_prof;
    private javax.swing.JComboBox<String> jComboBox_promo;
    private javax.swing.JComboBox<String> jComboBox_salle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_groupe;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField_eleve;
    private javax.swing.JTextField jTextField_groupe;
    private javax.swing.JTextField jTextField_prof;
    private javax.swing.JTextField jTextField_promo;
    private javax.swing.JTextField jTextField_salle;
    // End of variables declaration//GEN-END:variables
}