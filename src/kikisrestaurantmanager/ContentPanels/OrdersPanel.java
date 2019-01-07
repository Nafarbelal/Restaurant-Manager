/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kikisrestaurantmanager.ContentPanels;

import MODEL.Commande;
import MODEL.GestionRestau;
import MODEL.MonModele;
import MODEL.TableModel;
import addons.HeaderRenderer;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import kikisrestaurantmanager.MainMenu;
import addons.CustomColors;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author Ilyas El Bani
 */
public class OrdersPanel extends javax.swing.JPanel implements ListSelectionListener {

    GestionRestau Gr = new GestionRestau();

    /**
     * Creates new form OrdersPanel
     */
    public OrdersPanel() {
        initComponents();
        /*
        OrdersTable.getTableHeader().setDefaultRenderer(new HeaderRenderer(OrdersTable));
        OrdersTable.getTableHeader().setFont(new Font("Montserrat", Font.PLAIN, 15));
        OrdersTable.getTableHeader().setOpaque(false);
        OrdersTable.getTableHeader().setBackground(Color.WHITE); */
        refreshOrdersTable(Gr.commandesShowAll());
        ListSelectionModel selectionModel=OrdersTable.getSelectionModel();
        selectionModel.addListSelectionListener(this);  
    }

    @Override
public void valueChanged(ListSelectionEvent e) {
    System.out.println("You clicked a row!");
    if(e.getSource()==OrdersTable.getSelectionModel() && e.getValueIsAdjusting())
    {
        TableModel model=(TableModel)OrdersTable.getModel();
        String ID=model.getValueAt(OrdersTable.getSelectedRow(),0).toString();
        DetailsTable.setModel(new MonModele(Gr.detailsByID(Integer.parseInt(ID))));
    }
}


    public void refreshOrdersTable(ResultSet arts) {

        
        // ResultSet arts = Gr.commandesParDate("01", "01", "2019","02","01","2019");
        OrdersTable.setModel(new MonModele(arts));
        /*
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        OrdersTable.getColumnModel().getColumn(0).setMaxWidth(60);
        OrdersTable.getColumnModel().getColumn(1).setMinWidth(150);

        for (int i = 0; i < 4; ++i) {
            OrdersTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        };
         */
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
        OrdersTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        TodayPanel = new javax.swing.JPanel();
        TodayLabel = new javax.swing.JLabel();
        YesterdayPanel = new javax.swing.JPanel();
        YesterdayLabel = new javax.swing.JLabel();
        ThisWeekPanel = new javax.swing.JPanel();
        ThisWeekLabel = new javax.swing.JLabel();
        ThisMonthPanel = new javax.swing.JPanel();
        ThisMonthLabel = new javax.swing.JLabel();
        ThisYearPanel = new javax.swing.JPanel();
        ThisYearLabel = new javax.swing.JLabel();
        ShowAllPanel = new javax.swing.JPanel();
        ShowAllLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DetailsTable = new javax.swing.JTable();

        OrdersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(OrdersTable);

        jPanel1.setBackground(CustomColors.darkViolet);

        TodayPanel.setBackground(CustomColors.panelDefault);
        TodayPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TodayPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TodayPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TodayPanelMouseExited(evt);
            }
        });

        TodayLabel.setForeground(CustomColors.ordersFilterText);
        TodayLabel.setText("Today");

        javax.swing.GroupLayout TodayPanelLayout = new javax.swing.GroupLayout(TodayPanel);
        TodayPanel.setLayout(TodayPanelLayout);
        TodayPanelLayout.setHorizontalGroup(
            TodayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TodayPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TodayLabel)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        TodayPanelLayout.setVerticalGroup(
            TodayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TodayPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(TodayLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        YesterdayPanel.setBackground(CustomColors.panelDefault);
        YesterdayPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YesterdayPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                YesterdayPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                YesterdayPanelMouseExited(evt);
            }
        });

        YesterdayLabel.setForeground(CustomColors.ordersFilterText);
        YesterdayLabel.setText("Yesterday");

        javax.swing.GroupLayout YesterdayPanelLayout = new javax.swing.GroupLayout(YesterdayPanel);
        YesterdayPanel.setLayout(YesterdayPanelLayout);
        YesterdayPanelLayout.setHorizontalGroup(
            YesterdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(YesterdayPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(YesterdayLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        YesterdayPanelLayout.setVerticalGroup(
            YesterdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(YesterdayPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(YesterdayLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ThisWeekPanel.setBackground(CustomColors.panelDefault);
        ThisWeekPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThisWeekPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ThisWeekPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ThisWeekPanelMouseExited(evt);
            }
        });

        ThisWeekLabel.setForeground(CustomColors.ordersFilterText);
        ThisWeekLabel.setText("This Week");

        javax.swing.GroupLayout ThisWeekPanelLayout = new javax.swing.GroupLayout(ThisWeekPanel);
        ThisWeekPanel.setLayout(ThisWeekPanelLayout);
        ThisWeekPanelLayout.setHorizontalGroup(
            ThisWeekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThisWeekPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ThisWeekLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ThisWeekPanelLayout.setVerticalGroup(
            ThisWeekPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThisWeekPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(ThisWeekLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ThisMonthPanel.setBackground(CustomColors.panelDefault);
        ThisMonthPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThisMonthPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ThisMonthPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ThisMonthPanelMouseExited(evt);
            }
        });

        ThisMonthLabel.setForeground(CustomColors.ordersFilterText);
        ThisMonthLabel.setText("This Month");

        javax.swing.GroupLayout ThisMonthPanelLayout = new javax.swing.GroupLayout(ThisMonthPanel);
        ThisMonthPanel.setLayout(ThisMonthPanelLayout);
        ThisMonthPanelLayout.setHorizontalGroup(
            ThisMonthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThisMonthPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ThisMonthLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ThisMonthPanelLayout.setVerticalGroup(
            ThisMonthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThisMonthPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(ThisMonthLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ThisYearPanel.setBackground(CustomColors.panelDefault);
        ThisYearPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThisYearPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ThisYearPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ThisYearPanelMouseExited(evt);
            }
        });

        ThisYearLabel.setForeground(CustomColors.ordersFilterText);
        ThisYearLabel.setText("This Year");

        javax.swing.GroupLayout ThisYearPanelLayout = new javax.swing.GroupLayout(ThisYearPanel);
        ThisYearPanel.setLayout(ThisYearPanelLayout);
        ThisYearPanelLayout.setHorizontalGroup(
            ThisYearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThisYearPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ThisYearLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ThisYearPanelLayout.setVerticalGroup(
            ThisYearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThisYearPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(ThisYearLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ShowAllPanel.setBackground(CustomColors.panelDefault);
        ShowAllPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ShowAllPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ShowAllPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ShowAllPanelMouseExited(evt);
            }
        });

        ShowAllLabel.setForeground(CustomColors.ordersFilterText);
        ShowAllLabel.setText("Show All");

        javax.swing.GroupLayout ShowAllPanelLayout = new javax.swing.GroupLayout(ShowAllPanel);
        ShowAllPanel.setLayout(ShowAllPanelLayout);
        ShowAllPanelLayout.setHorizontalGroup(
            ShowAllPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ShowAllPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ShowAllLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ShowAllPanelLayout.setVerticalGroup(
            ShowAllPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ShowAllPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(ShowAllLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(TodayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(YesterdayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ThisWeekPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ThisMonthPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ThisYearPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ShowAllPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ShowAllPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThisYearPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TodayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThisWeekPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(YesterdayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThisMonthPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        DetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(DetailsTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TodayPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TodayPanelMouseEntered
        // TODO add your handling code here:
        TodayPanel.setBackground(CustomColors.panelHoveredOn);
    }//GEN-LAST:event_TodayPanelMouseEntered

    private void YesterdayPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YesterdayPanelMouseEntered
        // TODO add your handling code here:
        YesterdayPanel.setBackground(CustomColors.panelHoveredOn);
    }//GEN-LAST:event_YesterdayPanelMouseEntered

    private void ThisWeekPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThisWeekPanelMouseEntered
        // TODO add your handling code here:
        ThisWeekPanel.setBackground(CustomColors.panelHoveredOn);
    }//GEN-LAST:event_ThisWeekPanelMouseEntered

    private void ThisMonthPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThisMonthPanelMouseEntered
        // TODO add your handling code here:
        ThisMonthPanel.setBackground(CustomColors.panelHoveredOn);
    }//GEN-LAST:event_ThisMonthPanelMouseEntered

    private void ThisYearPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThisYearPanelMouseEntered
        // TODO add your handling code here:
        ThisYearPanel.setBackground(CustomColors.panelHoveredOn);
    }//GEN-LAST:event_ThisYearPanelMouseEntered

    private void ShowAllPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShowAllPanelMouseEntered
        // TODO add your handling code here:
        ShowAllPanel.setBackground(CustomColors.panelHoveredOn);
    }//GEN-LAST:event_ShowAllPanelMouseEntered

    private void TodayPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TodayPanelMouseExited
        // TODO add your handling code here:
        TodayPanel.setBackground(CustomColors.panelDefault);
    }//GEN-LAST:event_TodayPanelMouseExited

    private void YesterdayPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YesterdayPanelMouseExited
        // TODO add your handling code here:
        YesterdayPanel.setBackground(CustomColors.panelDefault);
    }//GEN-LAST:event_YesterdayPanelMouseExited

    private void ThisWeekPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThisWeekPanelMouseExited
        // TODO add your handling code here:
        ThisWeekPanel.setBackground(CustomColors.panelDefault);
    }//GEN-LAST:event_ThisWeekPanelMouseExited

    private void ThisMonthPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThisMonthPanelMouseExited
        // TODO add your handling code here:
        ThisMonthPanel.setBackground(CustomColors.panelDefault);
    }//GEN-LAST:event_ThisMonthPanelMouseExited

    private void ThisYearPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThisYearPanelMouseExited
        // TODO add your handling code here:
        ThisYearPanel.setBackground(CustomColors.panelDefault);
    }//GEN-LAST:event_ThisYearPanelMouseExited

    private void ShowAllPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShowAllPanelMouseExited
        // TODO add your handling code here:
        ShowAllPanel.setBackground(CustomColors.panelDefault);
    }//GEN-LAST:event_ShowAllPanelMouseExited

    private void TodayPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TodayPanelMouseClicked
        // TODO add your handling code here:
        refreshOrdersTable(Gr.commandesToday());
    }//GEN-LAST:event_TodayPanelMouseClicked

    private void YesterdayPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YesterdayPanelMouseClicked
        // TODO add your handling code here:
        refreshOrdersTable(Gr.commandesYesterday());
    }//GEN-LAST:event_YesterdayPanelMouseClicked

    private void ThisWeekPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThisWeekPanelMouseClicked
        // TODO add your handling code here:
        refreshOrdersTable(Gr.commandesThisWeek());
    }//GEN-LAST:event_ThisWeekPanelMouseClicked

    private void ThisMonthPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThisMonthPanelMouseClicked
        // TODO add your handling code here:
        refreshOrdersTable(Gr.commandesThisMonth());
    }//GEN-LAST:event_ThisMonthPanelMouseClicked

    private void ThisYearPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThisYearPanelMouseClicked
        // TODO add your handling code here:
        refreshOrdersTable(Gr.commandesThisYear());
    }//GEN-LAST:event_ThisYearPanelMouseClicked

    private void ShowAllPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShowAllPanelMouseClicked
        // TODO add your handling code here:
        refreshOrdersTable(Gr.commandesShowAll());
    }//GEN-LAST:event_ShowAllPanelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DetailsTable;
    private javax.swing.JTable OrdersTable;
    private javax.swing.JLabel ShowAllLabel;
    private javax.swing.JPanel ShowAllPanel;
    private javax.swing.JLabel ThisMonthLabel;
    private javax.swing.JPanel ThisMonthPanel;
    private javax.swing.JLabel ThisWeekLabel;
    private javax.swing.JPanel ThisWeekPanel;
    private javax.swing.JLabel ThisYearLabel;
    private javax.swing.JPanel ThisYearPanel;
    private javax.swing.JLabel TodayLabel;
    private javax.swing.JPanel TodayPanel;
    private javax.swing.JLabel YesterdayLabel;
    private javax.swing.JPanel YesterdayPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
