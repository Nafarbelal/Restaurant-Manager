/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kikisrestaurantmanager;

import MODEL.DB_Commande;
import MODEL.GestionRestau;
import java.awt.Dialog;
import java.sql.ResultSet;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import kikisrestaurantmanager.ContentPanels.HomePanel;
import kikisrestaurantmanager.ContentPanels.ManagerPanel;

/**
 *
 * @author Ilyas El Bani
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    GestionRestau Gr = new GestionRestau();
    DB_Commande C = new DB_Commande();

    public MainMenu() {
        //this.setUndecorated(true);
        //this.setResizable(true);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        HideAllContent();
        homePanel1.setVisible(true);
    }

    public void tableBtnIsClicked(int idTable, int isOccupied) {
        //  new accesCommandeFrame(this,idTable).setVisible(true);
        if (isOccupied == 0) {
            new accesCommandeFrame(this, idTable).setVisible(true);
        } else {
            int idCom = C.getIdCommandeNonPayéFromNumTable(idTable);
            new accesCommandeFrame(this, idTable, idCom).setVisible(true);
        }

        this.setEnabled(false);
    }

    public void tableBtnEmporterIsClicked(int idTable) {
        //  new accesCommandeFrame(this,idTable).setVisible(true);
        new accesCommandeFrame(this, idTable).setVisible(true);

        this.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundPane = new javax.swing.JPanel();
        SidePanel = new javax.swing.JPanel();
        btnHome = new javax.swing.JPanel();
        iconHome1 = new javax.swing.JLabel();
        labelHome = new javax.swing.JLabel();
        btnOrders = new javax.swing.JPanel();
        iconOrders = new javax.swing.JLabel();
        labelOrders = new javax.swing.JLabel();
        btnStats = new javax.swing.JPanel();
        iconOrders1 = new javax.swing.JLabel();
        labelOrders1 = new javax.swing.JLabel();
        btnManager = new javax.swing.JPanel();
        iconOrders3 = new javax.swing.JLabel();
        labelOrders3 = new javax.swing.JLabel();
        btnInfos = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        TitlePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CloseButton = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ContentPanel = new javax.swing.JPanel();
        homePanel1 = new kikisrestaurantmanager.ContentPanels.HomePanel(this);
        managerPanel1 = new kikisrestaurantmanager.ContentPanels.ManagerPanel();
        statsPanel1 = new kikisrestaurantmanager.ContentPanels.StatsPanel(this);
        ordersPanel1 = new kikisrestaurantmanager.ContentPanels.OrdersPanel();
        infosPanel1 = new kikisrestaurantmanager.ContentPanels.InfosPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackgroundPane.setBackground(new java.awt.Color(255, 255, 255));

        SidePanel.setBackground(new java.awt.Color(54, 33, 89));

        btnHome.setBackground(new java.awt.Color(85, 65, 118));
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHomeMousePressed(evt);
            }
        });
        btnHome.setLayout(new java.awt.BorderLayout());

        iconHome1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconHome1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Home_60px.png"))); // NOI18N
        btnHome.add(iconHome1, java.awt.BorderLayout.CENTER);

        labelHome.setFont(new java.awt.Font("Montserrat Light", 0, 18)); // NOI18N
        labelHome.setForeground(new java.awt.Color(255, 255, 255));
        labelHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHome.setText("Accueil");
        btnHome.add(labelHome, java.awt.BorderLayout.PAGE_END);

        btnOrders.setBackground(new java.awt.Color(54, 33, 89));
        btnOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnOrdersMousePressed(evt);
            }
        });
        btnOrders.setLayout(new java.awt.BorderLayout());

        iconOrders.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconOrders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Reserve_60px.png"))); // NOI18N
        btnOrders.add(iconOrders, java.awt.BorderLayout.CENTER);

        labelOrders.setFont(new java.awt.Font("Montserrat Light", 0, 18)); // NOI18N
        labelOrders.setForeground(new java.awt.Color(255, 255, 255));
        labelOrders.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelOrders.setText("Commandes");
        btnOrders.add(labelOrders, java.awt.BorderLayout.PAGE_END);

        btnStats.setBackground(new java.awt.Color(54, 33, 89));
        btnStats.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnStatsMousePressed(evt);
            }
        });
        btnStats.setLayout(new java.awt.BorderLayout());

        iconOrders1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconOrders1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Statistics_60px_1.png"))); // NOI18N
        btnStats.add(iconOrders1, java.awt.BorderLayout.CENTER);

        labelOrders1.setFont(new java.awt.Font("Montserrat Light", 0, 18)); // NOI18N
        labelOrders1.setForeground(new java.awt.Color(255, 255, 255));
        labelOrders1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelOrders1.setText("Statistiques");
        btnStats.add(labelOrders1, java.awt.BorderLayout.PAGE_END);

        btnManager.setBackground(new java.awt.Color(54, 33, 89));
        btnManager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnManagerMousePressed(evt);
            }
        });
        btnManager.setLayout(new java.awt.BorderLayout());

        iconOrders3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconOrders3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Admin_Settings_Male_60px.png"))); // NOI18N
        btnManager.add(iconOrders3, java.awt.BorderLayout.CENTER);

        labelOrders3.setFont(new java.awt.Font("Montserrat Light", 0, 18)); // NOI18N
        labelOrders3.setForeground(new java.awt.Color(255, 255, 255));
        labelOrders3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelOrders3.setText("Mode Manager");
        btnManager.add(labelOrders3, java.awt.BorderLayout.PAGE_END);

        btnInfos.setBackground(new java.awt.Color(54, 33, 89));
        btnInfos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnInfosMousePressed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Info_60px.png"))); // NOI18N

        javax.swing.GroupLayout btnInfosLayout = new javax.swing.GroupLayout(btnInfos);
        btnInfos.setLayout(btnInfosLayout);
        btnInfosLayout.setHorizontalGroup(
            btnInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnInfosLayout.setVerticalGroup(
            btnInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnInfosLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel3)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
        SidePanel.setLayout(SidePanelLayout);
        SidePanelLayout.setHorizontalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnOrders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnStats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnManager, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
            .addComponent(btnInfos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SidePanelLayout.setVerticalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnStats, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnManager, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btnInfos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        TitlePanel.setBackground(new java.awt.Color(122, 72, 221));

        jLabel1.setFont(new java.awt.Font("Open Sans ExtraBold", 1, 50)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kiki's Restaurant Manager");

        CloseButton.setFont(new java.awt.Font("Tahoma", 0, 5)); // NOI18N
        CloseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Cancel_50px_4.png"))); // NOI18N
        CloseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CloseButtonMousePressed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Restaurant_100px.png"))); // NOI18N

        javax.swing.GroupLayout TitlePanelLayout = new javax.swing.GroupLayout(TitlePanel);
        TitlePanel.setLayout(TitlePanelLayout);
        TitlePanelLayout.setHorizontalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TitlePanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 374, Short.MAX_VALUE)
                .addComponent(CloseButton)
                .addGap(88, 88, 88))
        );
        TitlePanelLayout.setVerticalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TitlePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TitlePanelLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(CloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        ContentPanel.setBackground(new java.awt.Color(255, 255, 255));
        ContentPanel.setMaximumSize(new java.awt.Dimension(1000, 1000));
        ContentPanel.setLayout(new java.awt.CardLayout());
        ContentPanel.add(homePanel1, "card2");
        ContentPanel.add(managerPanel1, "card3");
        ContentPanel.add(statsPanel1, "card4");
        ContentPanel.add(ordersPanel1, "card5");
        ContentPanel.add(infosPanel1, "card6");

        javax.swing.GroupLayout BackgroundPaneLayout = new javax.swing.GroupLayout(BackgroundPane);
        BackgroundPane.setLayout(BackgroundPaneLayout);
        BackgroundPaneLayout.setHorizontalGroup(
            BackgroundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundPaneLayout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addComponent(TitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        BackgroundPaneLayout.setVerticalGroup(
            BackgroundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundPaneLayout.createSequentialGroup()
                .addComponent(TitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(BackgroundPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void HideAllContent() {
        //this is used to hide all content Panels
        homePanel1.setVisible(false);
        managerPanel1.setVisible(false);
        ordersPanel1.setVisible(false);
        statsPanel1.setVisible(false);
        infosPanel1.setVisible(false);
    }

    public void ClickedMenu(javax.swing.JPanel SideBarItem, javax.swing.JPanel contentToSee) {
        btnHome.setBackground(new java.awt.Color(54, 33, 89));
        btnManager.setBackground(new java.awt.Color(54, 33, 89));
        btnOrders.setBackground(new java.awt.Color(54, 33, 89));
        btnStats.setBackground(new java.awt.Color(54, 33, 89));
        btnInfos.setBackground(new java.awt.Color(54, 33, 89));

        HideAllContent();
        contentToSee.setVisible(true);
        SideBarItem.setBackground(new java.awt.Color(85, 65, 118));

    }
    private void btnHomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMousePressed
        javax.swing.JPanel source = (javax.swing.JPanel) evt.getSource();
        ClickedMenu(source, homePanel1);
    }//GEN-LAST:event_btnHomeMousePressed

    private void btnOrdersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrdersMousePressed
        javax.swing.JPanel source = (javax.swing.JPanel) evt.getSource();
        ClickedMenu(source, ordersPanel1);
    }//GEN-LAST:event_btnOrdersMousePressed

    private void btnStatsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatsMousePressed
        javax.swing.JPanel source = (javax.swing.JPanel) evt.getSource();
        ClickedMenu(source, statsPanel1);
    }//GEN-LAST:event_btnStatsMousePressed

    private void btnManagerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManagerMousePressed
        javax.swing.JPanel source = (javax.swing.JPanel) evt.getSource();
             ClickedMenu(source, managerPanel1);
       /* JDialog loginDialog = new loginFrame(this);
        loginDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        loginDialog.setVisible(true);*/
    }//GEN-LAST:event_btnManagerMousePressed

    private void CloseButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseButtonMousePressed
        System.exit(0);
    }//GEN-LAST:event_CloseButtonMousePressed

    private void btnInfosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInfosMousePressed
        javax.swing.JPanel source = (javax.swing.JPanel) evt.getSource();
        ClickedMenu(source, infosPanel1);
        System.out.println("infos clicked");
    }//GEN-LAST:event_btnInfosMousePressed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackgroundPane;
    private javax.swing.JLabel CloseButton;
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JPanel btnHome;
    private javax.swing.JPanel btnInfos;
    private javax.swing.JPanel btnManager;
    private javax.swing.JPanel btnOrders;
    private javax.swing.JPanel btnStats;
    private kikisrestaurantmanager.ContentPanels.HomePanel homePanel1;
    private javax.swing.JLabel iconHome1;
    private javax.swing.JLabel iconOrders;
    private javax.swing.JLabel iconOrders1;
    private javax.swing.JLabel iconOrders3;
    private kikisrestaurantmanager.ContentPanels.InfosPanel infosPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelHome;
    private javax.swing.JLabel labelOrders;
    private javax.swing.JLabel labelOrders1;
    private javax.swing.JLabel labelOrders3;
    private kikisrestaurantmanager.ContentPanels.ManagerPanel managerPanel1;
    private kikisrestaurantmanager.ContentPanels.OrdersPanel ordersPanel1;
    private kikisrestaurantmanager.ContentPanels.StatsPanel statsPanel1;
    // End of variables declaration//GEN-END:variables

    public ManagerPanel getManagerPanel1() {
        return managerPanel1;
    }

    public JPanel getBtnManager() {
        return btnManager;
    }

    public HomePanel getHomePanel1() {
        return homePanel1;
    }

}
