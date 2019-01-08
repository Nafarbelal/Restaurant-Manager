/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kikisrestaurantmanager;

import MODEL.GestionRestau;
import java.awt.Dialog;
import addons.CustomColors;

/**
 *
 * @author Nada
 */
public class ChangerMdp extends javax.swing.JDialog {

    GestionRestau Gr = new GestionRestau();

    /**
     * Creates new form ChangerMdp
     */
    public ChangerMdp() {
        //setUndecorated(true);
        initComponents();
        LabelWrongOldPassword.setVisible(false);
        LabelWrongNewPassword.setVisible(false);

    }

    public void ResetFields() {
        txtOldPassword.setText("");
        txtNewPassword.setText("");
        txtConfirmNewPassword.setText("");
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtOldPassword = new javax.swing.JPasswordField();
        txtNewPassword = new javax.swing.JPasswordField();
        txtConfirmNewPassword = new javax.swing.JPasswordField();
        btnAnnuler = new javax.swing.JButton();
        btnConfirmer = new javax.swing.JButton();
        LabelWrongOldPassword = new javax.swing.JLabel();
        LabelWrongNewPassword = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Changer mot de passe");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        setForeground(new java.awt.Color(51, 0, 51));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel1.setText("Ancien mot de passe:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 42, -1, 20));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel2.setText("Nouveau mot de passe:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 83, -1, -1));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel3.setText("Confirmer nouveau mot de passe:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 124, -1, -1));

        txtOldPassword.setBackground(new java.awt.Color(229, 229, 237));
        txtOldPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtOldPasswordMouseClicked(evt);
            }
        });
        jPanel1.add(txtOldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 153, -1));

        txtNewPassword.setBackground(new java.awt.Color(229, 229, 237));
        txtNewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(txtNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 153, -1));

        txtConfirmNewPassword.setBackground(new java.awt.Color(229, 229, 237));
        txtConfirmNewPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtConfirmNewPasswordMouseClicked(evt);
            }
        });
        txtConfirmNewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmNewPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(txtConfirmNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 153, -1));

        btnAnnuler.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        btnAnnuler.setText("Annuler");
        btnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnnuler, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 102, -1));

        btnConfirmer.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        btnConfirmer.setText("Confirmer");
        btnConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmerActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirmer, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 99, -1));

        LabelWrongOldPassword.setForeground(new java.awt.Color(204, 0, 0));
        LabelWrongOldPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Error_15px.png"))); // NOI18N
        jPanel1.add(LabelWrongOldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, 20));

        LabelWrongNewPassword.setForeground(new java.awt.Color(204, 0, 0));
        LabelWrongNewPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Error_15px.png"))); // NOI18N
        jPanel1.add(LabelWrongNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewPasswordActionPerformed

    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnAnnulerActionPerformed

    private void txtConfirmNewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmNewPasswordActionPerformed
    }//GEN-LAST:event_txtConfirmNewPasswordActionPerformed

    private void btnConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmerActionPerformed
        String old = txtOldPassword.getText();
        String nw1 = txtNewPassword.getText();
        String nw2 = txtConfirmNewPassword.getText();

        if (Gr.CheckPassword(old) == 1) {
            if (nw1.equals(nw2)) {
                Gr.UpdatePwd(nw2);
                MotDePasseChangé mdp= new MotDePasseChangé();
                mdp.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                mdp.setLocationRelativeTo(this);
                mdp.setVisible(true);
                this.dispose();
            } else {
                LabelWrongNewPassword.setVisible(true);
                ResetFields();
            }

        } else {
            LabelWrongOldPassword.setVisible(true);
            ResetFields();
        }

    }//GEN-LAST:event_btnConfirmerActionPerformed

    private void txtOldPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtOldPasswordMouseClicked
        LabelWrongOldPassword.setVisible(false);
        LabelWrongNewPassword.setVisible(false);

    }//GEN-LAST:event_txtOldPasswordMouseClicked

    private void txtConfirmNewPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtConfirmNewPasswordMouseClicked
        LabelWrongOldPassword.setVisible(false);
        LabelWrongNewPassword.setVisible(false);

    }//GEN-LAST:event_txtConfirmNewPasswordMouseClicked

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
            java.util.logging.Logger.getLogger(ChangerMdp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangerMdp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangerMdp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangerMdp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangerMdp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelWrongNewPassword;
    private javax.swing.JLabel LabelWrongOldPassword;
    private javax.swing.JButton btnAnnuler;
    private javax.swing.JButton btnConfirmer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtConfirmNewPassword;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JPasswordField txtOldPassword;
    // End of variables declaration//GEN-END:variables
}
