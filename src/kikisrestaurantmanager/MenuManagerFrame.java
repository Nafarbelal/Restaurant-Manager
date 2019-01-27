/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kikisrestaurantmanager;

import MODEL.DB_Article;
import MODEL.MonModele;
import java.awt.Dialog;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author HP
 */
public class MenuManagerFrame extends javax.swing.JDialog {
    
    DB_Article dbArticle=new DB_Article();

    /**
     * Creates new form MenuManagerFrame
     */
    public MenuManagerFrame() {
        initComponents();
        refreshMenuTable(dbArticle.MenuAll());
        remplirCMB();
        EditButton.setEnabled(false);
    }
    
    public void refreshMenuTable(ResultSet arts) {
        MenuTable.clearSelection();
        // ResultSet arts = Gr.commandesParDate("01", "01", "2019","02","01","2019");
        MenuTable.setModel(new MonModele(arts));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        //OrdersTable.getColumnModel().getColumn(0).setMaxWidth(60);
        //OrdersTable.getColumnModel().getColumn(1).setMinWidth(150);
        for (int i = 0; i < 5; ++i) {
            MenuTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    
    private void emptyAllTextFields() 
    {
        DesignationTxt.setText(null);
        PrixTxt.setText(null);
    }
    
    public void remplirCMB(){
        Vector<String> C=dbArticle.Categories();
        DefaultComboBoxModel CBM=new DefaultComboBoxModel(C);
        CategoriesComboBox.setModel(CBM);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        MenuTable = new javax.swing.JTable();
        AddButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        DesignationTxt = new javax.swing.JTextField();
        PrixTxt = new javax.swing.JTextField();
        CategoriesComboBox = new javax.swing.JComboBox<>();
        ArchiveCheckBox = new javax.swing.JCheckBox();
        CancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        MenuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        MenuTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(MenuTable);

        AddButton.setText("Ajouter");
        AddButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddButtonMousePressed(evt);
            }
        });

        EditButton.setText("Modifier");
        EditButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EditButtonMousePressed(evt);
            }
        });

        DesignationTxt.setText("jTextField1");

        PrixTxt.setText("jTextField2");

        CategoriesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CancelButton.setText("Annuler");
        CancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CancelButtonMousePressed(evt);
            }
        });

        jLabel1.setText("Designation");

        jLabel2.setText("Prix");

        jLabel3.setText("Categorie");

        jLabel4.setText("Archivé");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PrixTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(52, 52, 52)
                        .addComponent(DesignationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ArchiveCheckBox)
                            .addComponent(CategoriesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DesignationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PrixTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CategoriesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(ArchiveCheckBox))
                        .addGap(123, 123, 123)
                        .addComponent(AddButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EditButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CancelButton)))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButtonMousePressed
        // TODO add your handling code here:
        /*
        AjoutArticle c=new AjoutArticle();
        c.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        c.setLocationRelativeTo(this);
        c.setVisible(true);
        this.setEnabled(false); */
        int i;
        String type = CategoriesComboBox.getSelectedItem().toString();
        String des = DesignationTxt.getText();
        float prix = Float.parseFloat(PrixTxt.getText());
        boolean archive=ArchiveCheckBox.isSelected();
        if(archive==true)
            i=1;
        else
            i=0;
        dbArticle.AddArticle(des, prix, type,i);
        refreshMenuTable(dbArticle.MenuAll());
        emptyAllTextFields();
    }//GEN-LAST:event_AddButtonMousePressed

    private void EditButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditButtonMousePressed
        // TODO add your handling code here:
        /*
        ModificationArticle c=new ModificationArticle();
        c.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        c.setLocationRelativeTo(this);
        c.setVisible(true);
        this.setEnabled(false); */
        int i;
        int lig=MenuTable.getSelectedRow();
        int id;
        id = Integer.parseInt(MenuTable.getValueAt(lig, 0).toString());
        String type = CategoriesComboBox.getSelectedItem().toString();
        String des = DesignationTxt.getText();
        float prix = Float.parseFloat(PrixTxt.getText());
        boolean archive=ArchiveCheckBox.isSelected();
        if(archive==true)
            i=1;
        else
            i=0;
        try 
        {  
            dbArticle.UPDATEArticle(id , des , prix , type, i);
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(MenuManagerFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        EditButton.setEnabled(false);
        //btnDelete.setEnabled(false);
        AddButton.setEnabled(true);
        //txtID.setEnabled(true);
        MenuTable.clearSelection();
        refreshMenuTable(dbArticle.MenuAll());
        emptyAllTextFields();
        
    }//GEN-LAST:event_EditButtonMousePressed

    private void MenuTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuTableMouseClicked
        // TODO add your handling code here:
        int lig = MenuTable.getSelectedRow();
        //txtID.setText(MenuTable.getValueAt(lig, 0).toString());
        CategoriesComboBox.setSelectedItem(MenuTable.getValueAt(lig, 3).toString());
        DesignationTxt.setText(MenuTable.getValueAt(lig, 1).toString());
        PrixTxt.setText(MenuTable.getValueAt(lig, 2).toString());
        if("false".equals(MenuTable.getValueAt(lig,4).toString()))
            ArchiveCheckBox.setSelected(false);
        else
            ArchiveCheckBox.setSelected(true);
        EditButton.setEnabled(true);
        AddButton.setEnabled(false);
    }//GEN-LAST:event_MenuTableMouseClicked

    private void CancelButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButtonMousePressed
        // TODO add your handling code here:
        emptyAllTextFields();
        MenuTable.clearSelection();
        EditButton.setEnabled(false);
        AddButton.setEnabled(true);
    }//GEN-LAST:event_CancelButtonMousePressed

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
            java.util.logging.Logger.getLogger(MenuManagerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuManagerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuManagerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuManagerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuManagerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JCheckBox ArchiveCheckBox;
    private javax.swing.JButton CancelButton;
    private javax.swing.JComboBox<String> CategoriesComboBox;
    private javax.swing.JTextField DesignationTxt;
    private javax.swing.JButton EditButton;
    private javax.swing.JTable MenuTable;
    private javax.swing.JTextField PrixTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
