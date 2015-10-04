/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sci.kik;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author Luk
 */
public class Okno extends javax.swing.JFrame {

    private Gra gra;
    private javax.swing.JLabel[][] plansza;

    final private String symbol1 = "Kółko";
    final private String symbol2 = "Krzyżyk";

    /**
     * Creates new form NewJFrame
     */
    public Okno() {
        initComponents();

        plansza = new javax.swing.JLabel[3][3];
        plansza[0][0] = jLabel1;
        plansza[0][1] = jLabel2;
        plansza[0][2] = jLabel3;
        plansza[1][0] = jLabel4;
        plansza[1][1] = jLabel5;
        plansza[1][2] = jLabel6;
        plansza[2][0] = jLabel7;
        plansza[2][1] = jLabel8;
        plansza[2][2] = jLabel9;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                managerPrzycisku(plansza[i][j], i, j);
            }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2Players = new javax.swing.JPanel();
        buttonNowaGra2Players = new javax.swing.JButton();
        jLabelGracz1 = new javax.swing.JLabel();
        jTextFieldGracz1 = new javax.swing.JTextField();
        jLabelGracz2 = new javax.swing.JLabel();
        jTextFieldGracz2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jRadioButtonKolko2p = new javax.swing.JRadioButton();
        jRadioButtonKrzyzyk2p = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jLabelSymbol2P = new javax.swing.JLabel();
        jPanelAI = new javax.swing.JPanel();
        buttonNowaGraAI = new javax.swing.JButton();
        jLabelGraczAI = new javax.swing.JLabel();
        jTextFieldGraczAI = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jRadioButtonKolkoAI = new javax.swing.JRadioButton();
        jRadioButtonKrzyzykAI = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jLabelSymbolAI = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.setLayout(new java.awt.GridLayout(3, 3));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel6);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel8);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel9);

        buttonNowaGra2Players.setText("Nowa gra");
        buttonNowaGra2Players.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNowaGra2PlayersActionPerformed(evt);
            }
        });

        jLabelGracz1.setText("Imie gracza 1:");

        jTextFieldGracz1.setText("Gracz 1");

        jLabelGracz2.setText("Imie gracza 2:");

        jTextFieldGracz2.setText("Gracz 2");

        jLabel10.setText("Symbol gracza 1:");

        buttonGroup2.add(jRadioButtonKolko2p);
        jRadioButtonKolko2p.setSelected(true);
        jRadioButtonKolko2p.setText("Kółko");
        jRadioButtonKolko2p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonKolko2pActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButtonKrzyzyk2p);
        jRadioButtonKrzyzyk2p.setText("Krzyżyk");
        jRadioButtonKrzyzyk2p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonKrzyzyk2pActionPerformed(evt);
            }
        });

        jLabel11.setText("Symbol gracza 2:");

        jLabelSymbol2P.setText("Krzyżyk");

        javax.swing.GroupLayout jPanel2PlayersLayout = new javax.swing.GroupLayout(jPanel2Players);
        jPanel2Players.setLayout(jPanel2PlayersLayout);
        jPanel2PlayersLayout.setHorizontalGroup(
            jPanel2PlayersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2PlayersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2PlayersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonNowaGra2Players)
                    .addGroup(jPanel2PlayersLayout.createSequentialGroup()
                        .addGroup(jPanel2PlayersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabelGracz1)
                            .addComponent(jLabelGracz2)
                            .addComponent(jLabel11))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2PlayersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldGracz1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldGracz2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2PlayersLayout.createSequentialGroup()
                                .addComponent(jRadioButtonKolko2p)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonKrzyzyk2p))
                            .addComponent(jLabelSymbol2P))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2PlayersLayout.setVerticalGroup(
            jPanel2PlayersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2PlayersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2PlayersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGracz1)
                    .addComponent(jTextFieldGracz1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2PlayersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGracz2)
                    .addComponent(jTextFieldGracz2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2PlayersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jRadioButtonKolko2p)
                    .addComponent(jRadioButtonKrzyzyk2p))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2PlayersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabelSymbol2P))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(buttonNowaGra2Players)
                .addContainerGap())
        );

        jTabbedPane1.addTab("2 Graczy", jPanel2Players);

        buttonNowaGraAI.setText("Nowa gra");
        buttonNowaGraAI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNowaGraAIActionPerformed(evt);
            }
        });

        jLabelGraczAI.setText("Imie gracza 1:");

        jTextFieldGraczAI.setText("Gracz 1");

        jLabel13.setText("Symbol gracza 1:");

        buttonGroup1.add(jRadioButtonKolkoAI);
        jRadioButtonKolkoAI.setSelected(true);
        jRadioButtonKolkoAI.setText("Kółko");
        jRadioButtonKolkoAI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonKolkoAIActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonKrzyzykAI);
        jRadioButtonKrzyzykAI.setText("Krzyżyk");
        jRadioButtonKrzyzykAI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonKrzyzykAIActionPerformed(evt);
            }
        });

        jLabel14.setText("Symbol gracza AI:");

        jLabelSymbolAI.setText("Krzyżyk");

        javax.swing.GroupLayout jPanelAILayout = new javax.swing.GroupLayout(jPanelAI);
        jPanelAI.setLayout(jPanelAILayout);
        jPanelAILayout.setHorizontalGroup(
            jPanelAILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonNowaGraAI)
                    .addGroup(jPanelAILayout.createSequentialGroup()
                        .addGroup(jPanelAILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabelGraczAI)
                            .addComponent(jLabel14))
                        .addGap(35, 35, 35)
                        .addGroup(jPanelAILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldGraczAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelAILayout.createSequentialGroup()
                                .addComponent(jRadioButtonKolkoAI)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonKrzyzykAI))
                            .addComponent(jLabelSymbolAI))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAILayout.setVerticalGroup(
            jPanelAILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGraczAI)
                    .addComponent(jTextFieldGraczAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jRadioButtonKolkoAI)
                    .addComponent(jRadioButtonKrzyzykAI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabelSymbolAI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(buttonNowaGraAI)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Z komputerem", jPanelAI);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonNowaGra2PlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNowaGra2PlayersActionPerformed

        String imieGracza1 = jTextFieldGracz1.getText();
        String imieGracza2 = jTextFieldGracz2.getText();
        int symbolGracza1 = 1;
        int symbolGracza2 = 2;

        if (jRadioButtonKolko2p.isSelected()) {
            symbolGracza1 = 1;
            symbolGracza2 = 2;
        } else {
            symbolGracza1 = 2;
            symbolGracza2 = 1;
        }

        gra = new Gra(imieGracza1, imieGracza2, symbolGracza1, symbolGracza2);
        odswiezUI();
    }//GEN-LAST:event_buttonNowaGra2PlayersActionPerformed

    private void jRadioButtonKolko2pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonKolko2pActionPerformed
        handlerZmianySymbolu(1, jLabelSymbol2P);
    }//GEN-LAST:event_jRadioButtonKolko2pActionPerformed

    private void jRadioButtonKolkoAIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonKolkoAIActionPerformed
        handlerZmianySymbolu(1, jLabelSymbolAI);
    }//GEN-LAST:event_jRadioButtonKolkoAIActionPerformed

    private void buttonNowaGraAIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNowaGraAIActionPerformed
        String imieGracza1 = jTextFieldGraczAI.getText();
        int symbolGracza1 = 1;
        int symbolGracza2 = 2;

        if (jRadioButtonKolkoAI.isSelected()) {
            symbolGracza1 = 1;
            symbolGracza2 = 2;
        } else {
            symbolGracza1 = 2;
            symbolGracza2 = 1;
        }

        gra = new Gra(imieGracza1, symbolGracza1, symbolGracza2);
        odswiezUI();
    }//GEN-LAST:event_buttonNowaGraAIActionPerformed

    private void jRadioButtonKrzyzykAIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonKrzyzykAIActionPerformed
        handlerZmianySymbolu(2, jLabelSymbolAI);
    }//GEN-LAST:event_jRadioButtonKrzyzykAIActionPerformed

    private void jRadioButtonKrzyzyk2pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonKrzyzyk2pActionPerformed
        handlerZmianySymbolu(2, jLabelSymbol2P);
    }//GEN-LAST:event_jRadioButtonKrzyzyk2pActionPerformed

    private void handlerZmianySymbolu(int znak, final javax.swing.JLabel labelSymbol) {
        if (znak == 1) {
            labelSymbol.setText(this.symbol2);
        } else if (znak == 2) {
            labelSymbol.setText(this.symbol1);
        }
    }

    private void managerPrzycisku(final javax.swing.JLabel przycisk, final int wiersz, final int kolumna) {
        przycisk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (gra != null) {
                    gra.ruch(wiersz, kolumna);
                    odswiezUI();
                }
            }
        });
    }

    private void odswiezUI() {
        int znakNaPozycji;
        Border loweredBevel, raisedBevel;
        loweredBevel = BorderFactory.createLoweredBevelBorder();
        raisedBevel = BorderFactory.createRaisedBevelBorder();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                znakNaPozycji = gra.getZnakNaPozycji(i, j);
                if (znakNaPozycji == 0) {
                    plansza[i][j].setText(gra.znak0);
                    plansza[i][j].setBorder(raisedBevel);
                } else if (znakNaPozycji == 1) {
                    plansza[i][j].setText(gra.znak1);
                    plansza[i][j].setBorder(loweredBevel);
                } else if (znakNaPozycji == 2) {
                    plansza[i][j].setText(gra.znak2);
                    plansza[i][j].setBorder(loweredBevel);
                }
            }
        }

        if (!gra.czyAktywna()) {
            JOptionPane.showMessageDialog(rootPane, gra.getWiadomosc());
        }
    }

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
            java.util.logging.Logger.getLogger(Okno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Okno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Okno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Okno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Okno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton buttonNowaGra2Players;
    private javax.swing.JButton buttonNowaGraAI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelGracz1;
    private javax.swing.JLabel jLabelGracz2;
    private javax.swing.JLabel jLabelGraczAI;
    private javax.swing.JLabel jLabelSymbol2P;
    private javax.swing.JLabel jLabelSymbolAI;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2Players;
    private javax.swing.JPanel jPanelAI;
    private javax.swing.JRadioButton jRadioButtonKolko2p;
    private javax.swing.JRadioButton jRadioButtonKolkoAI;
    private javax.swing.JRadioButton jRadioButtonKrzyzyk2p;
    private javax.swing.JRadioButton jRadioButtonKrzyzykAI;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldGracz1;
    private javax.swing.JTextField jTextFieldGracz2;
    private javax.swing.JTextField jTextFieldGraczAI;
    // End of variables declaration//GEN-END:variables
}