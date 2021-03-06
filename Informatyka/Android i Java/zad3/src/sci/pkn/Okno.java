/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sci.pkn;

import javax.swing.JOptionPane;

public class Okno extends javax.swing.JFrame {
    private Gra gra;
    
    /**
     * Creates new form Okno
     */
    public Okno() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        liczbaTurSlider = new javax.swing.JSlider();
        ScoreInfoPanel = new javax.swing.JPanel();
        punktyKomputeraLabel = new javax.swing.JLabel();
        wyborKomputeraLabel = new javax.swing.JLabel();
        punktyZawodnikaLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        wyborZawodnikaLabel = new javax.swing.JLabel();
        ImiePanel = new javax.swing.JPanel();
        imieLabel = new javax.swing.JLabel();
        imieTextField = new javax.swing.JTextField();
        ButtonsPanel = new javax.swing.JPanel();
        papierButton = new javax.swing.JButton();
        kamienButton = new javax.swing.JButton();
        nozyceButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        StatystykiGracza = new javax.swing.JPanel();
        StatystykiTitle = new javax.swing.JLabel();
        StatystykiPapier = new javax.swing.JLabel();
        StatystykiKamien = new javax.swing.JLabel();
        StatystykiNozyce = new javax.swing.JLabel();
        GraczStatystykiPapier = new javax.swing.JLabel();
        GraczStatystykiKamien = new javax.swing.JLabel();
        GraczStatystykiNozyce = new javax.swing.JLabel();
        StatystykiGracza1 = new javax.swing.JPanel();
        StatystykiTitle1 = new javax.swing.JLabel();
        StatystykiPapier1 = new javax.swing.JLabel();
        StatystykiKamien1 = new javax.swing.JLabel();
        StatystykiNozyce1 = new javax.swing.JLabel();
        KomputerStatystykiPapier = new javax.swing.JLabel();
        KomputerStatystykiKamien = new javax.swing.JLabel();
        KomputerStatystykiNozyce = new javax.swing.JLabel();
        jProgressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Papier - Kamień - Nożyce");

        liczbaTurSlider.setMajorTickSpacing(10);
        liczbaTurSlider.setMinimum(1);
        liczbaTurSlider.setMinorTickSpacing(1);
        liczbaTurSlider.setPaintLabels(true);
        liczbaTurSlider.setPaintTicks(true);
        liczbaTurSlider.setSnapToTicks(true);
        liczbaTurSlider.setValue(10);

        punktyKomputeraLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        punktyKomputeraLabel.setText("???");

        wyborKomputeraLabel.setText("???");

        punktyZawodnikaLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        punktyZawodnikaLabel.setText("???");

        jLabel3.setText("Punkty komputera:");

        jLabel2.setText("Punkty zawodnika:");

        jLabel1.setText("Wybór komputera:");

        jLabel4.setText("Wybór zawodnika:");

        wyborZawodnikaLabel.setText("???");

        javax.swing.GroupLayout ScoreInfoPanelLayout = new javax.swing.GroupLayout(ScoreInfoPanel);
        ScoreInfoPanel.setLayout(ScoreInfoPanelLayout);
        ScoreInfoPanelLayout.setHorizontalGroup(
            ScoreInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ScoreInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ScoreInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ScoreInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wyborKomputeraLabel)
                    .addComponent(punktyZawodnikaLabel)
                    .addComponent(punktyKomputeraLabel)
                    .addComponent(wyborZawodnikaLabel))
                .addGap(11, 11, 11))
        );
        ScoreInfoPanelLayout.setVerticalGroup(
            ScoreInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ScoreInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ScoreInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(wyborKomputeraLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ScoreInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(wyborZawodnikaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ScoreInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(punktyZawodnikaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ScoreInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(punktyKomputeraLabel))
                .addGap(31, 31, 31))
        );

        imieLabel.setText("Twoje imie:");

        imieTextField.setText("Zawodnik");

        javax.swing.GroupLayout ImiePanelLayout = new javax.swing.GroupLayout(ImiePanel);
        ImiePanel.setLayout(ImiePanelLayout);
        ImiePanelLayout.setHorizontalGroup(
            ImiePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImiePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imieLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imieTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        ImiePanelLayout.setVerticalGroup(
            ImiePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImiePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ImiePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imieTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imieLabel))
                .addContainerGap())
        );

        papierButton.setText("Papier");
        papierButton.setEnabled(false);
        papierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                papierButtonActionPerformed(evt);
            }
        });

        kamienButton.setText("Kamień");
        kamienButton.setEnabled(false);
        kamienButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kamienButtonActionPerformed(evt);
            }
        });

        nozyceButton.setText("Nożyce");
        nozyceButton.setEnabled(false);
        nozyceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nozyceButtonActionPerformed(evt);
            }
        });

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ButtonsPanelLayout = new javax.swing.GroupLayout(ButtonsPanel);
        ButtonsPanel.setLayout(ButtonsPanelLayout);
        ButtonsPanelLayout.setHorizontalGroup(
            ButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ButtonsPanelLayout.createSequentialGroup()
                        .addComponent(papierButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kamienButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nozyceButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ButtonsPanelLayout.setVerticalGroup(
            ButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(startButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(papierButton)
                    .addComponent(kamienButton)
                    .addComponent(nozyceButton))
                .addContainerGap())
        );

        StatystykiTitle.setText("Gracz");

        StatystykiPapier.setText("Papier:");

        StatystykiKamien.setText("Kamień:");

        StatystykiNozyce.setText("Nożyce");

        GraczStatystykiPapier.setText("???");
        GraczStatystykiPapier.setToolTipText("");
        GraczStatystykiPapier.setAlignmentY(0.3F);

        GraczStatystykiKamien.setText("???");
        GraczStatystykiKamien.setToolTipText("");
        GraczStatystykiKamien.setAlignmentY(0.3F);

        GraczStatystykiNozyce.setText("???");
        GraczStatystykiNozyce.setToolTipText("");
        GraczStatystykiNozyce.setAlignmentY(0.3F);

        javax.swing.GroupLayout StatystykiGraczaLayout = new javax.swing.GroupLayout(StatystykiGracza);
        StatystykiGracza.setLayout(StatystykiGraczaLayout);
        StatystykiGraczaLayout.setHorizontalGroup(
            StatystykiGraczaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StatystykiGraczaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(StatystykiGraczaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StatystykiTitle)
                    .addGroup(StatystykiGraczaLayout.createSequentialGroup()
                        .addComponent(StatystykiPapier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GraczStatystykiPapier))
                    .addGroup(StatystykiGraczaLayout.createSequentialGroup()
                        .addComponent(StatystykiKamien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GraczStatystykiKamien))
                    .addGroup(StatystykiGraczaLayout.createSequentialGroup()
                        .addComponent(StatystykiNozyce)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GraczStatystykiNozyce)))
                .addContainerGap())
        );
        StatystykiGraczaLayout.setVerticalGroup(
            StatystykiGraczaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StatystykiGraczaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(StatystykiTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(StatystykiGraczaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StatystykiPapier)
                    .addComponent(GraczStatystykiPapier))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(StatystykiGraczaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StatystykiKamien)
                    .addComponent(GraczStatystykiKamien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(StatystykiGraczaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StatystykiNozyce)
                    .addComponent(GraczStatystykiNozyce))
                .addContainerGap())
        );

        StatystykiTitle1.setText("Gracz");

        StatystykiPapier1.setText("Papier:");

        StatystykiKamien1.setText("Kamień:");

        StatystykiNozyce1.setText("Nożyce");

        KomputerStatystykiPapier.setText("???");
        KomputerStatystykiPapier.setToolTipText("");
        KomputerStatystykiPapier.setAlignmentY(0.3F);

        KomputerStatystykiKamien.setText("???");
        KomputerStatystykiKamien.setToolTipText("");
        KomputerStatystykiKamien.setAlignmentY(0.3F);

        KomputerStatystykiNozyce.setText("???");
        KomputerStatystykiNozyce.setToolTipText("");
        KomputerStatystykiNozyce.setAlignmentY(0.3F);

        javax.swing.GroupLayout StatystykiGracza1Layout = new javax.swing.GroupLayout(StatystykiGracza1);
        StatystykiGracza1.setLayout(StatystykiGracza1Layout);
        StatystykiGracza1Layout.setHorizontalGroup(
            StatystykiGracza1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StatystykiGracza1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(StatystykiGracza1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StatystykiTitle1)
                    .addGroup(StatystykiGracza1Layout.createSequentialGroup()
                        .addComponent(StatystykiPapier1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(KomputerStatystykiPapier))
                    .addGroup(StatystykiGracza1Layout.createSequentialGroup()
                        .addComponent(StatystykiKamien1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(KomputerStatystykiKamien))
                    .addGroup(StatystykiGracza1Layout.createSequentialGroup()
                        .addComponent(StatystykiNozyce1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(KomputerStatystykiNozyce)))
                .addContainerGap())
        );
        StatystykiGracza1Layout.setVerticalGroup(
            StatystykiGracza1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StatystykiGracza1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(StatystykiTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(StatystykiGracza1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StatystykiPapier1)
                    .addComponent(KomputerStatystykiPapier))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(StatystykiGracza1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StatystykiKamien1)
                    .addComponent(KomputerStatystykiKamien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(StatystykiGracza1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StatystykiNozyce1)
                    .addComponent(KomputerStatystykiNozyce))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(liczbaTurSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ImiePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ScoreInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(StatystykiGracza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(StatystykiGracza1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ImiePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(liczbaTurSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScoreInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StatystykiGracza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StatystykiGracza1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void odswiezIU() {
       
        jProgressBar.setValue(gra.liczbaPozostalychRund);
        
        wyborKomputeraLabel.setText(gra.ruchKomputera);
        wyborZawodnikaLabel.setText(gra.ruchZawodnika);
        punktyZawodnikaLabel.setText(String.valueOf(gra.punktyZawodnika));
        punktyKomputeraLabel.setText(String.valueOf(gra.punktyKomputera));
        
        odswiezStatystyki();
        
        if (!gra.czyAktywna) {
            changeButtonsEnabledStatus();
            wyswietlZwyciezce();
            
            wyborKomputeraLabel.setText("???");
            wyborZawodnikaLabel.setText("???");
            punktyZawodnikaLabel.setText("???");
            punktyKomputeraLabel.setText("???");
            
            GraczStatystykiKamien.setText("???");
            KomputerStatystykiKamien.setText("???");
            GraczStatystykiPapier.setText("???");
            KomputerStatystykiPapier.setText("???");
            GraczStatystykiNozyce.setText("???");
            KomputerStatystykiNozyce.setText("???");
        }
       
    }
    
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        //rozpoczęcie nowej gry
        gra = new Gra(liczbaTurSlider.getValue(), imieTextField.getText());
        jProgressBar.setMaximum(liczbaTurSlider.getValue());
        changeButtonsEnabledStatus();
        odswiezIU();
        StatystykiTitle.setText(gra.imieZawodnika);
    }//GEN-LAST:event_startButtonActionPerformed

    private void papierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_papierButtonActionPerformed
        gra.rozegrajRunde(gra.PAPIER);
        odswiezIU();
    }//GEN-LAST:event_papierButtonActionPerformed

    private void kamienButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kamienButtonActionPerformed
        gra.rozegrajRunde(gra.KAMIEN);
        odswiezIU();
    }//GEN-LAST:event_kamienButtonActionPerformed

    private void nozyceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nozyceButtonActionPerformed
        gra.rozegrajRunde(gra.NOZYCE);
        odswiezIU();
    }//GEN-LAST:event_nozyceButtonActionPerformed

    /**
     * Zmienia status Enabled w buttonach
     */
    private void changeButtonsEnabledStatus() {
        if (papierButton.isEnabled()) {
            papierButton.setEnabled(false);
            kamienButton.setEnabled(false);
            nozyceButton.setEnabled(false);
            imieTextField.setEnabled(true);
        } else {
            papierButton.setEnabled(true);
            kamienButton.setEnabled(true);
            nozyceButton.setEnabled(true);
            imieTextField.setEnabled(false);
        }
    }
    
    private void wyswietlZwyciezce() {       
        JOptionPane.showMessageDialog(rootPane, gra.podsumowanieGry());
    }
    
    private void odswiezStatystyki() {
        GraczStatystykiPapier.setText(String.valueOf(gra.statystykiGracza[0]));
        GraczStatystykiKamien.setText(String.valueOf(gra.statystykiGracza[1]));
        GraczStatystykiNozyce.setText(String.valueOf(gra.statystykiGracza[2]));
        
        KomputerStatystykiPapier.setText(String.valueOf(gra.statystykiKomputera[0]));
        KomputerStatystykiKamien.setText(String.valueOf(gra.statystykiKomputera[1]));
        KomputerStatystykiNozyce.setText(String.valueOf(gra.statystykiKomputera[2]));
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
            public void run() {
                new Okno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonsPanel;
    private javax.swing.JLabel GraczStatystykiKamien;
    private javax.swing.JLabel GraczStatystykiNozyce;
    private javax.swing.JLabel GraczStatystykiPapier;
    private javax.swing.JPanel ImiePanel;
    private javax.swing.JLabel KomputerStatystykiKamien;
    private javax.swing.JLabel KomputerStatystykiNozyce;
    private javax.swing.JLabel KomputerStatystykiPapier;
    private javax.swing.JPanel ScoreInfoPanel;
    private javax.swing.JPanel StatystykiGracza;
    private javax.swing.JPanel StatystykiGracza1;
    private javax.swing.JLabel StatystykiKamien;
    private javax.swing.JLabel StatystykiKamien1;
    private javax.swing.JLabel StatystykiNozyce;
    private javax.swing.JLabel StatystykiNozyce1;
    private javax.swing.JLabel StatystykiPapier;
    private javax.swing.JLabel StatystykiPapier1;
    private javax.swing.JLabel StatystykiTitle;
    private javax.swing.JLabel StatystykiTitle1;
    private javax.swing.JLabel imieLabel;
    private javax.swing.JTextField imieTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JProgressBar jProgressBar;
    private javax.swing.JButton kamienButton;
    private javax.swing.JSlider liczbaTurSlider;
    private javax.swing.JButton nozyceButton;
    private javax.swing.JButton papierButton;
    private javax.swing.JLabel punktyKomputeraLabel;
    private javax.swing.JLabel punktyZawodnikaLabel;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel wyborKomputeraLabel;
    private javax.swing.JLabel wyborZawodnikaLabel;
    // End of variables declaration//GEN-END:variables
}
