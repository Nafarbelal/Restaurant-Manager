/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kikisrestaurantmanager.ContentPanels;

import MODEL.DB_Commande;
import MODEL.DB_DetailCommande;
import MODEL.MonModele;
import MODEL.TableModel;
import addons.TableHeaderRenderer;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import kikisrestaurantmanager.HomeFrame;
import addons.CustomColors;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Ilyas El Bani
 */
public class OrdersPanel extends javax.swing.JPanel implements ListSelectionListener {

    DB_DetailCommande dbDetailCommande = new DB_DetailCommande();
    DB_Commande dbCommande = new DB_Commande();

    /**
     * Creates new form OrdersPanel
     */
    public OrdersPanel() {
        initComponents();
        OrdersTable.getTableHeader().setDefaultRenderer(new TableHeaderRenderer(OrdersTable));
        OrdersTable.getTableHeader().setFont(new Font("Montserrat", Font.PLAIN, 15));
        OrdersTable.getTableHeader().setOpaque(false);
        OrdersTable.getTableHeader().setBackground(Color.WHITE);
        OrdersTable.setRowHeight(25);
        DetailsTable.getTableHeader().setDefaultRenderer(new TableHeaderRenderer(DetailsTable));
        DetailsTable.getTableHeader().setFont(new Font("Montserrat", Font.PLAIN, 15));
        DetailsTable.getTableHeader().setOpaque(false);
        DetailsTable.getTableHeader().setBackground(Color.WHITE);
        DetailsTable.setRowHeight(25);
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        jScrollPane2.getViewport().setBackground(Color.WHITE);

        /*
        OrdersTable.ExitedeHeader().setDefaultRenderer(new HeaderRenderer(OrdersTable));
        OrdersTable.ExitedHeader().setFont(new Font("Montserrat", Font.PLAIN, 15));
        OrdersTable.getTableHeader().setOpaque(false);
        OrdersTable.Exitedeader().setBackground(Color.WHITE); */
        refreshOrdersTable(dbCommande.commandesShowAll());
        refreshDetailsCommande(0);
        ListSelectionModel selectionModel = OrdersTable.getSelectionModel();
        selectionModel.addListSelectionListener(this);
        TodayPanelMouseClicked(null);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
    }

    public void refreshOrdersTable(ResultSet arts) {
        OrdersTable.clearSelection();
        // ResultSet arts = Gr.commandesParDate("01", "01", "2019","02","01","2019");
        OrdersTable.setModel(new MonModele(arts));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        //OrdersTable.getColumnModel().getColumn(0).setMaxWidth(60);
        //OrdersTable.getColumnModel().getColumn(1).setMinWidth(150);
        for (int i = 0; i < 4; ++i) {
            OrdersTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        OrdersTable.getColumnModel().getColumn(0).setMaxWidth(60);

    }

    public void refreshDetailsCommande(int idCommande) {
        DetailsTable.setModel(new MonModele(dbDetailCommande.detailsByID(idCommande)));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        //  OrdersTable.getColumnModel().getColumn(0).setMaxWidth(60);
        //OrdersTable.getColumnModel().getColumn(1).setMinWidth(150);
        for (int i = 0; i < 4; ++i) {
            if(i!=1)
            DetailsTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        DetailsTable.getColumnModel().getColumn(0).setMaxWidth(60);
        DetailsTable.getColumnModel().getColumn(1).setMinWidth(200);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        OrdersTable = new javax.swing.JTable();
        TodayPanel = new javax.swing.JPanel();
        TodayLabel = new javax.swing.JLabel();
        YesterdayPanel = new javax.swing.JPanel();
        YesterdayLabel = new javax.swing.JLabel();
        ThisMonthPanel = new javax.swing.JPanel();
        ThisMonthLabel = new javax.swing.JLabel();
        ThisYearPanel = new javax.swing.JPanel();
        ThisYearLabel = new javax.swing.JLabel();
        ShowAllPanel = new javax.swing.JPanel();
        ShowAllLabel = new javax.swing.JLabel();
        ThisWeekPanel = new javax.swing.JPanel();
        ThisWeekLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DetailsTable = new javax.swing.JTable();

        jPanel4.setBackground(new java.awt.Color(54, 33, 89));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        OrdersTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
        OrdersTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        OrdersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                OrdersTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(OrdersTable);

        TodayPanel.setBackground(CustomColors.panelDefaultBackgroundColor);
        TodayPanel.setPreferredSize(new java.awt.Dimension(140, 55));
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
        TodayPanel.setLayout(new java.awt.BorderLayout());

        TodayLabel.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        TodayLabel.setForeground(CustomColors.ordersFilterTextUnselected);
        TodayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TodayLabel.setText("Aujourd'hui");
        TodayPanel.add(TodayLabel, java.awt.BorderLayout.CENTER);

        YesterdayPanel.setBackground(CustomColors.panelDefaultBackgroundColor);
        YesterdayPanel.setPreferredSize(new java.awt.Dimension(140, 55));
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
        YesterdayPanel.setLayout(new java.awt.BorderLayout());

        YesterdayLabel.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        YesterdayLabel.setForeground(CustomColors.ordersFilterTextUnselected);
        YesterdayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        YesterdayLabel.setText("Hier");
        YesterdayPanel.add(YesterdayLabel, java.awt.BorderLayout.CENTER);

        ThisMonthPanel.setBackground(CustomColors.panelDefaultBackgroundColor);
        ThisMonthPanel.setPreferredSize(new java.awt.Dimension(140, 55));
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
        ThisMonthPanel.setLayout(new java.awt.BorderLayout());

        ThisMonthLabel.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        ThisMonthLabel.setForeground(CustomColors.ordersFilterTextUnselected);
        ThisMonthLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ThisMonthLabel.setText("Ce Mois");
        ThisMonthLabel.setPreferredSize(new java.awt.Dimension(140, 23));
        ThisMonthPanel.add(ThisMonthLabel, java.awt.BorderLayout.CENTER);

        ThisYearPanel.setBackground(CustomColors.panelDefaultBackgroundColor);
        ThisYearPanel.setPreferredSize(new java.awt.Dimension(140, 55));
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
        ThisYearPanel.setLayout(new java.awt.BorderLayout());

        ThisYearLabel.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        ThisYearLabel.setForeground(CustomColors.ordersFilterTextUnselected);
        ThisYearLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ThisYearLabel.setText("Cette Année");
        ThisYearPanel.add(ThisYearLabel, java.awt.BorderLayout.CENTER);

        ShowAllPanel.setBackground(CustomColors.panelDefaultBackgroundColor);
        ShowAllPanel.setPreferredSize(new java.awt.Dimension(140, 55));
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
        ShowAllPanel.setLayout(new java.awt.BorderLayout());

        ShowAllLabel.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        ShowAllLabel.setForeground(CustomColors.ordersFilterTextUnselected);
        ShowAllLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ShowAllLabel.setText("Depuis Début");
        ShowAllPanel.add(ShowAllLabel, java.awt.BorderLayout.CENTER);

        ThisWeekPanel.setBackground(CustomColors.panelDefaultBackgroundColor);
        ThisWeekPanel.setPreferredSize(new java.awt.Dimension(140, 55));
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
        ThisWeekPanel.setLayout(new java.awt.BorderLayout());

        ThisWeekLabel.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        ThisWeekLabel.setForeground(CustomColors.ordersFilterTextUnselected);
        ThisWeekLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ThisWeekLabel.setText("Cette Semaine");
        ThisWeekPanel.add(ThisWeekLabel, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(CustomColors.sidesSeparator);
        jPanel1.setMaximumSize(new java.awt.Dimension(11, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(11, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(11, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 36)); // NOI18N
        jLabel3.setForeground(CustomColors.title);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Details de la commande");

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

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
        DetailsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(DetailsTable);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                        .addGap(68, 68, 68)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TodayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(48, 48, 48)
                        .addComponent(YesterdayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(48, 48, 48)
                        .addComponent(ThisWeekPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(48, 48, 48)
                        .addComponent(ThisMonthPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                        .addGap(48, 48, 48)
                        .addComponent(ThisYearPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(48, 48, 48)
                        .addComponent(ShowAllPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14)))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(YesterdayPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TodayPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThisYearPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShowAllPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThisMonthPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThisWeekPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void FilterDefaultColorAll() {
        ShowAllPanel.setBackground(CustomColors.panelDefaultBackgroundColor);
        ThisYearPanel.setBackground(CustomColors.panelDefaultBackgroundColor);
        ThisMonthPanel.setBackground(CustomColors.panelDefaultBackgroundColor);
        ThisWeekPanel.setBackground(CustomColors.panelDefaultBackgroundColor);
        YesterdayPanel.setBackground(CustomColors.panelDefaultBackgroundColor);
        TodayPanel.setBackground(CustomColors.panelDefaultBackgroundColor);

    }

    private void FilterMouseEntered(JPanel p) {
        if (p.getBackground() != CustomColors.orderFilterPanelSelected) {
            p.setBackground(CustomColors.orderFilterPanelHoveredOn);
        }
    }

    private void FilterMouseExited(JPanel p) {
        if (p.getBackground() != CustomColors.orderFilterPanelSelected) {
            p.setBackground(CustomColors.panelDefaultBackgroundColor);
        }
    }

    private void FilterSelected(JPanel p) {
        FilterDefaultColorAll();
        p.setBackground(CustomColors.orderFilterPanelSelected);
    }
    private void TodayPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TodayPanelMouseEntered
        FilterMouseEntered(TodayPanel);
    }//GEN-LAST:event_TodayPanelMouseEntered

    private void YesterdayPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YesterdayPanelMouseEntered
        FilterMouseEntered(YesterdayPanel);
    }//GEN-LAST:event_YesterdayPanelMouseEntered

    private void ThisMonthPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThisMonthPanelMouseEntered
        FilterMouseEntered(ThisMonthPanel);
    }//GEN-LAST:event_ThisMonthPanelMouseEntered

    private void ThisYearPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThisYearPanelMouseEntered
        FilterMouseEntered(ThisYearPanel);
    }//GEN-LAST:event_ThisYearPanelMouseEntered

    private void ShowAllPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShowAllPanelMouseEntered
        FilterMouseEntered(ShowAllPanel);
    }//GEN-LAST:event_ShowAllPanelMouseEntered

    private void TodayPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TodayPanelMouseExited
        FilterMouseExited(TodayPanel);
    }//GEN-LAST:event_TodayPanelMouseExited

    private void YesterdayPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YesterdayPanelMouseExited
        FilterMouseExited(YesterdayPanel);
    }//GEN-LAST:event_YesterdayPanelMouseExited

    private void ThisMonthPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThisMonthPanelMouseExited
        FilterMouseExited(ThisMonthPanel);
    }//GEN-LAST:event_ThisMonthPanelMouseExited

    private void ThisYearPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThisYearPanelMouseExited
        FilterMouseExited(ThisYearPanel);
    }//GEN-LAST:event_ThisYearPanelMouseExited

    private void ShowAllPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShowAllPanelMouseExited
        FilterMouseExited(ShowAllPanel);
    }//GEN-LAST:event_ShowAllPanelMouseExited

    private void TodayPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TodayPanelMouseClicked
        // TODO add your handling code here:
        refreshOrdersTable(dbCommande.commandesToday());
        FilterSelected(TodayPanel);
    }//GEN-LAST:event_TodayPanelMouseClicked

    private void YesterdayPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YesterdayPanelMouseClicked
        // TODO add your handling code here:
        refreshOrdersTable(dbCommande.commandesYesterday());
        FilterSelected(YesterdayPanel);
    }//GEN-LAST:event_YesterdayPanelMouseClicked

    private void ThisMonthPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThisMonthPanelMouseClicked
        // TODO add your handling code here:
        refreshOrdersTable(dbCommande.commandesThisMonth());
        FilterSelected(ThisMonthPanel);
    }//GEN-LAST:event_ThisMonthPanelMouseClicked

    private void ThisYearPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThisYearPanelMouseClicked
        // TODO add your handling code here:
        refreshOrdersTable(dbCommande.commandesThisYear());
        FilterSelected(ThisYearPanel);

    }//GEN-LAST:event_ThisYearPanelMouseClicked

    private void ShowAllPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShowAllPanelMouseClicked
        // TODO add your handling code here:
        refreshOrdersTable(dbCommande.commandesShowAll());
        FilterSelected(ShowAllPanel);
    }//GEN-LAST:event_ShowAllPanelMouseClicked

    private void OrdersTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrdersTableMousePressed
        int row = OrdersTable.getSelectedRow();
        if (row != -1) {
            String ID = OrdersTable.getValueAt(OrdersTable.getSelectedRow(), 0).toString();
            refreshDetailsCommande(Integer.parseInt(ID));
        }
    }//GEN-LAST:event_OrdersTableMousePressed

    private void ThisWeekPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThisWeekPanelMouseExited
        FilterMouseExited(ThisWeekPanel);

    }//GEN-LAST:event_ThisWeekPanelMouseExited

    private void ThisWeekPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThisWeekPanelMouseEntered
        FilterMouseEntered(ThisWeekPanel);
    }//GEN-LAST:event_ThisWeekPanelMouseEntered

    private void ThisWeekPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThisWeekPanelMouseClicked
        refreshOrdersTable(dbCommande.commandesThisWeek());
        FilterSelected(ThisWeekPanel);
    }//GEN-LAST:event_ThisWeekPanelMouseClicked


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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
