/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kikisrestaurantmanager.ContentPanels;

import MODEL.DB_Commande;
import MODEL.MonModele;
import addons.CustomColors;
import addons.TableHeaderRenderer;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import kikisrestaurantmanager.Dialogs.ConfirmSuppressionDialog;
import kikisrestaurantmanager.HomeFrame;
import kikisrestaurantmanager.GestionCommandesFrame;

/**
 *
 * @author Ilyas El Bani
 */
public class AccueilPanel extends javax.swing.JPanel implements ListSelectionListener {

    /**
     * Creates new form HomePanel
     */
    DB_Commande dbCommande = new DB_Commande();
    HomeFrame mainMenu;

    public AccueilPanel() {
        initComponents();
    }

    public AccueilPanel(HomeFrame mn) {
        initComponents();
        tableCommandeEnCours.getTableHeader().setDefaultRenderer(new TableHeaderRenderer(tableCommandeEnCours));
        tableCommandeEnCours.getTableHeader().setFont(new Font("Montserrat", Font.PLAIN, 15));
        tableCommandeEnCours.getTableHeader().setOpaque(false);
        tableCommandeEnCours.getTableHeader().setBackground(Color.WHITE);
        tableCommandeEnCours.setRowHeight(25);
        RefreshTableCommandes();
        mainMenu = mn;
        tableCommandeEnCours.setSelectionBackground(new java.awt.Color(153, 153, 255));

    }

    public void RefreshTables() {
        btnT1.setBackground(CustomColors.tableNotOccupied);
        btnT2.setBackground(CustomColors.tableNotOccupied);
        btnT3.setBackground(CustomColors.tableNotOccupied);
        btnT4.setBackground(CustomColors.tableNotOccupied);
        btnT5.setBackground(CustomColors.tableNotOccupied);
        btnT6.setBackground(CustomColors.tableNotOccupied);
        btnT7.setBackground(CustomColors.tableNotOccupied);
        btnT8.setBackground(CustomColors.tableNotOccupied);
        btnT9.setBackground(CustomColors.tableNotOccupied);
        btnT10.setBackground(CustomColors.tableNotOccupied);
        btnT11.setBackground(CustomColors.tableNotOccupied);
        btnT12.setBackground(CustomColors.tableNotOccupied);
        btnT13.setBackground(CustomColors.tableNotOccupied);
        btnT14.setBackground(CustomColors.tableNotOccupied);
        btnT15.setBackground(CustomColors.tableNotOccupied);
        btnT16.setBackground(CustomColors.tableNotOccupied);
        btnT17.setBackground(CustomColors.tableNotOccupied);
        btnEmporter.setBackground(CustomColors.tableNotOccupied);
        ArrayList<Integer> occupiedTables = dbCommande.getNumTablesOccupé();
        for (Integer table : occupiedTables) {
            switch (table) {
                case 1:
                    btnT1.setBackground(CustomColors.tableOccupied);
                    break;
                case 2:
                    btnT2.setBackground(CustomColors.tableOccupied);
                    break;
                case 3:
                    btnT3.setBackground(CustomColors.tableOccupied);
                    break;
                case 4:
                    btnT4.setBackground(CustomColors.tableOccupied);
                    break;
                case 5:
                    btnT5.setBackground(CustomColors.tableOccupied);
                    break;
                case 6:
                    btnT6.setBackground(CustomColors.tableOccupied);
                    break;
                case 7:
                    btnT7.setBackground(CustomColors.tableOccupied);
                    break;
                case 8:
                    btnT8.setBackground(CustomColors.tableOccupied);
                    break;
                case 9:
                    btnT9.setBackground(CustomColors.tableOccupied);
                    break;
                case 10:
                    btnT10.setBackground(CustomColors.tableOccupied);
                    break;
                case 11:
                    btnT11.setBackground(CustomColors.tableOccupied);
                    break;
                case 12:
                    btnT12.setBackground(CustomColors.tableOccupied);
                    break;
                case 13:
                    btnT13.setBackground(CustomColors.tableOccupied);
                    break;
                case 14:
                    btnT14.setBackground(CustomColors.tableOccupied);
                    break;
                case 15:
                    btnT15.setBackground(CustomColors.tableOccupied);
                    break;
                case 16:
                    btnT16.setBackground(CustomColors.tableOccupied);
                    break;
                case 17:
                    btnT17.setBackground(CustomColors.tableOccupied);
                    break;
            }
        }

    }

    public void RefreshTableCommandes() {
        ResultSet arts = dbCommande.TousLesCommandesNonPayées();
        tableCommandeEnCours.setModel(new MonModele(arts));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tableCommandeEnCours.getColumnModel().getColumn(0).setMaxWidth(60);
        tableCommandeEnCours.getColumnModel().getColumn(1).setMinWidth(150);

        for (int i = 0; i < 4; ++i) {
            tableCommandeEnCours.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        RefreshTables();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LayoutRestaurant = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnT1 = new javax.swing.JButton();
        btnT2 = new javax.swing.JButton();
        btnT3 = new javax.swing.JButton();
        btnT4 = new javax.swing.JButton();
        btnT5 = new javax.swing.JButton();
        btnT6 = new javax.swing.JButton();
        btnT7 = new javax.swing.JButton();
        btnT8 = new javax.swing.JButton();
        btnT9 = new javax.swing.JButton();
        btnT13 = new javax.swing.JButton();
        btnT14 = new javax.swing.JButton();
        btnT15 = new javax.swing.JButton();
        btnT16 = new javax.swing.JButton();
        btnT17 = new javax.swing.JButton();
        btnT10 = new javax.swing.JButton();
        btnT11 = new javax.swing.JButton();
        btnT12 = new javax.swing.JButton();
        btnEmporter = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCommandeEnCours = new javax.swing.JTable();
        BtnFinaliser = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnEditCommande = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnTrashCommande = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1214, 710));

        LayoutRestaurant.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(122, 72, 221));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tables Du Restaurant");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnT1.setBackground(new java.awt.Color(204, 204, 255));
        btnT1.setText("T1");
        btnT1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnT1MousePressed(evt);
            }
        });

        btnT2.setBackground(new java.awt.Color(204, 204, 255));
        btnT2.setText("T2");
        btnT2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnT2MousePressed(evt);
            }
        });

        btnT3.setBackground(new java.awt.Color(204, 204, 255));
        btnT3.setText("T3");
        btnT3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnT3MousePressed(evt);
            }
        });

        btnT4.setBackground(new java.awt.Color(204, 204, 255));
        btnT4.setText("T4");
        btnT4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnT4MousePressed(evt);
            }
        });

        btnT5.setBackground(new java.awt.Color(204, 204, 255));
        btnT5.setText("T5");
        btnT5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnT5MousePressed(evt);
            }
        });

        btnT6.setBackground(new java.awt.Color(204, 204, 255));
        btnT6.setText("T6");
        btnT6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnT6MousePressed(evt);
            }
        });

        btnT7.setBackground(new java.awt.Color(204, 204, 255));
        btnT7.setText("T7");
        btnT7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnT7MousePressed(evt);
            }
        });

        btnT8.setBackground(new java.awt.Color(204, 204, 255));
        btnT8.setText("T8");
        btnT8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnT8MousePressed(evt);
            }
        });
        btnT8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnT8ActionPerformed(evt);
            }
        });

        btnT9.setBackground(new java.awt.Color(204, 204, 255));
        btnT9.setText("T9");
        btnT9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnT9MousePressed(evt);
            }
        });

        btnT13.setBackground(new java.awt.Color(204, 204, 255));
        btnT13.setText("T13");
        btnT13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnT13MousePressed(evt);
            }
        });

        btnT14.setBackground(new java.awt.Color(204, 204, 255));
        btnT14.setText("T14");
        btnT14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnT14MousePressed(evt);
            }
        });

        btnT15.setBackground(new java.awt.Color(204, 204, 255));
        btnT15.setText("T15");
        btnT15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnT15MousePressed(evt);
            }
        });

        btnT16.setBackground(new java.awt.Color(204, 204, 255));
        btnT16.setText("T16");
        btnT16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnT16MousePressed(evt);
            }
        });

        btnT17.setBackground(new java.awt.Color(204, 204, 255));
        btnT17.setText("T17");
        btnT17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnT17MousePressed(evt);
            }
        });

        btnT10.setBackground(new java.awt.Color(204, 204, 255));
        btnT10.setText("T10");
        btnT10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnT10MousePressed(evt);
            }
        });

        btnT11.setBackground(new java.awt.Color(204, 204, 255));
        btnT11.setText("T11");
        btnT11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnT11MousePressed(evt);
            }
        });

        btnT12.setBackground(new java.awt.Color(204, 204, 255));
        btnT12.setText("T12");
        btnT12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnT12MousePressed(evt);
            }
        });

        btnEmporter.setBackground(new java.awt.Color(204, 255, 204));
        btnEmporter.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        btnEmporter.setText("A emporter");
        btnEmporter.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmporter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEmporterMousePressed(evt);
            }
        });
        btnEmporter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmporterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnT1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btnT2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(btnT3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btnT4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btnT5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnT6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btnT7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(btnT8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btnT9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnT10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btnT11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(btnT12, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btnT13, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnEmporter, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(btnT16, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnT14, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnT15, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnT17, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnT1, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(btnT2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnT3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnT4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnT5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnT6, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(btnT7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnT8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnT9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnT10, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(btnT11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnT12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnT13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(btnT16, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnT14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5)
                        .addComponent(btnT15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5)
                        .addComponent(btnT17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnEmporter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout LayoutRestaurantLayout = new javax.swing.GroupLayout(LayoutRestaurant);
        LayoutRestaurant.setLayout(LayoutRestaurantLayout);
        LayoutRestaurantLayout.setHorizontalGroup(
            LayoutRestaurantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LayoutRestaurantLayout.createSequentialGroup()
                .addGroup(LayoutRestaurantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        LayoutRestaurantLayout.setVerticalGroup(
            LayoutRestaurantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LayoutRestaurantLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tableCommandeEnCours.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableCommandeEnCours.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "10-22-2015",  new Float(102.0)},
                { new Integer(2), "10-21-2015",  new Float(1033.0)},
                { new Integer(3), "10-17-2015",  new Float(105.0)},
                { new Integer(4), "10-18-2015",  new Float(108.0)},
                { new Integer(5), "10-19-2015",  new Float(19.99)},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Comm", "Date", "Montant"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCommandeEnCours.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableCommandeEnCours.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableCommandeEnCours);
        tableCommandeEnCours.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.getViewport().setBackground(Color.WHITE);

        BtnFinaliser.setBackground(new java.awt.Color(54, 33, 89));
        BtnFinaliser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BtnFinaliserMousePressed(evt);
            }
        });
        BtnFinaliser.setLayout(new java.awt.BorderLayout());

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Finaliser La Commande");
        BtnFinaliser.add(jLabel4, java.awt.BorderLayout.CENTER);

        btnEditCommande.setBackground(new java.awt.Color(122, 72, 221));
        btnEditCommande.setPreferredSize(new java.awt.Dimension(175, 50));
        btnEditCommande.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEditCommandeMousePressed(evt);
            }
        });
        btnEditCommande.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Edit_30px_2.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(175, 50));
        jLabel1.setMinimumSize(new java.awt.Dimension(175, 50));
        jLabel1.setPreferredSize(new java.awt.Dimension(175, 50));
        btnEditCommande.add(jLabel1, java.awt.BorderLayout.CENTER);

        btnTrashCommande.setBackground(new java.awt.Color(255, 99, 71));
        btnTrashCommande.setPreferredSize(new java.awt.Dimension(175, 50));
        btnTrashCommande.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnTrashCommandeMousePressed(evt);
            }
        });
        btnTrashCommande.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Trash_30px_2.png"))); // NOI18N
        btnTrashCommande.add(jLabel5, java.awt.BorderLayout.CENTER);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(122, 72, 221));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Commandes En Cours");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(btnTrashCommande, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnEditCommande, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                            .addComponent(BtnFinaliser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(36, 36, 36))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTrashCommande, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditCommande, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnFinaliser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LayoutRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LayoutRestaurant, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmporterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmporterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEmporterActionPerformed

    private void btnT8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnT8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnT8ActionPerformed


    private void btnT1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnT1MousePressed
        //System.out.println("hello");
        int isOccupied = 0;
        if (btnT1.getBackground() == CustomColors.tableOccupied) {
            isOccupied = 1;
        }
        mainMenu.tableBtnIsClicked(1, isOccupied);
    }//GEN-LAST:event_btnT1MousePressed

    private void btnT2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnT2MousePressed
        int isOccupied = 0;
        if (btnT2.getBackground() == CustomColors.tableOccupied) {
            isOccupied = 1;
        }
        mainMenu.tableBtnIsClicked(2, isOccupied);
    }//GEN-LAST:event_btnT2MousePressed

    private void btnT3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnT3MousePressed
        int isOccupied = 0;
        if (btnT3.getBackground() == CustomColors.tableOccupied) {
            isOccupied = 1;
        }
        mainMenu.tableBtnIsClicked(3, isOccupied);
    }//GEN-LAST:event_btnT3MousePressed

    private void btnT4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnT4MousePressed
        int isOccupied = 0;
        if (btnT4.getBackground() == CustomColors.tableOccupied) {
            isOccupied = 1;
        }
        mainMenu.tableBtnIsClicked(4, isOccupied);
    }//GEN-LAST:event_btnT4MousePressed

    private void btnT5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnT5MousePressed
        int isOccupied = 0;
        if (btnT5.getBackground() == CustomColors.tableOccupied) {
            isOccupied = 1;
        }
        mainMenu.tableBtnIsClicked(5, isOccupied);
    }//GEN-LAST:event_btnT5MousePressed

    private void btnT6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnT6MousePressed
        int isOccupied = 0;
        if (btnT6.getBackground() == CustomColors.tableOccupied) {
            isOccupied = 1;
        }
        mainMenu.tableBtnIsClicked(6, isOccupied);
    }//GEN-LAST:event_btnT6MousePressed

    private void btnT7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnT7MousePressed
        int isOccupied = 0;
        if (btnT7.getBackground() == CustomColors.tableOccupied) {
            isOccupied = 1;
        }
        mainMenu.tableBtnIsClicked(7, isOccupied);
    }//GEN-LAST:event_btnT7MousePressed

    private void btnT8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnT8MousePressed
        int isOccupied = 0;
        if (btnT8.getBackground() == CustomColors.tableOccupied) {
            isOccupied = 1;
        }
        mainMenu.tableBtnIsClicked(8, isOccupied);
    }//GEN-LAST:event_btnT8MousePressed

    private void btnT9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnT9MousePressed
        int isOccupied = 0;
        if (btnT9.getBackground() == CustomColors.tableOccupied) {
            isOccupied = 1;
        }
        mainMenu.tableBtnIsClicked(9, isOccupied);
    }//GEN-LAST:event_btnT9MousePressed

    private void btnT10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnT10MousePressed
        int isOccupied = 0;
        if (btnT10.getBackground() == CustomColors.tableOccupied) {
            isOccupied = 1;
        }
        mainMenu.tableBtnIsClicked(10, isOccupied);
    }//GEN-LAST:event_btnT10MousePressed

    private void btnT11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnT11MousePressed
        int isOccupied = 0;
        if (btnT11.getBackground() == CustomColors.tableOccupied) {
            isOccupied = 1;
        }
        mainMenu.tableBtnIsClicked(11, isOccupied);
    }//GEN-LAST:event_btnT11MousePressed

    private void btnT12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnT12MousePressed
        int isOccupied = 0;
        if (btnT12.getBackground() == CustomColors.tableOccupied) {
            isOccupied = 1;
        }
        mainMenu.tableBtnIsClicked(12, isOccupied);
    }//GEN-LAST:event_btnT12MousePressed

    private void btnT13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnT13MousePressed
        int isOccupied = 0;
        if (btnT13.getBackground() == CustomColors.tableOccupied) {
            isOccupied = 1;
        }
        mainMenu.tableBtnIsClicked(13, isOccupied);
    }//GEN-LAST:event_btnT13MousePressed

    private void btnT14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnT14MousePressed
        int isOccupied = 0;
        if (btnT14.getBackground() == CustomColors.tableOccupied) {
            isOccupied = 1;
        }
        mainMenu.tableBtnIsClicked(14, isOccupied);
    }//GEN-LAST:event_btnT14MousePressed

    private void btnT15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnT15MousePressed
        int isOccupied = 0;
        if (btnT15.getBackground() == CustomColors.tableOccupied) {
            isOccupied = 1;
        }
        mainMenu.tableBtnIsClicked(15, isOccupied);
    }//GEN-LAST:event_btnT15MousePressed

    private void btnT16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnT16MousePressed
        int isOccupied = 0;
        if (btnT16.getBackground() == CustomColors.tableOccupied) {
            isOccupied = 1;
        }
        mainMenu.tableBtnIsClicked(16, isOccupied);
    }//GEN-LAST:event_btnT16MousePressed

    private void btnT17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnT17MousePressed
        int isOccupied = 0;
        if (btnT17.getBackground() == CustomColors.tableOccupied) {
            isOccupied = 1;
        }
        mainMenu.tableBtnIsClicked(17, isOccupied);
    }//GEN-LAST:event_btnT17MousePressed

    private void btnEmporterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmporterMousePressed
        mainMenu.tableBtnEmporterIsClicked(0);
    }//GEN-LAST:event_btnEmporterMousePressed

    private void btnEditCommandeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditCommandeMousePressed
        int row = tableCommandeEnCours.getSelectedRow();
        if (row != -1) {
            int idCom = Integer.parseInt(tableCommandeEnCours.getValueAt(row, 0).toString());
            int numTable = dbCommande.getNumTableduneCommande(idCom);
            
            GestionCommandesFrame c = new GestionCommandesFrame(mainMenu, numTable,idCom);
            c.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            c.setLocationRelativeTo(this);
            c.setVisible(true);
        }
    }//GEN-LAST:event_btnEditCommandeMousePressed

    private void btnTrashCommandeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrashCommandeMousePressed
        int row = tableCommandeEnCours.getSelectedRow();
        if (row != -1) {
            int idCom = Integer.parseInt(tableCommandeEnCours.getValueAt(row, 0).toString());
            int answer = 0;
            ConfirmSuppressionDialog confirmDialog = new ConfirmSuppressionDialog();
            confirmDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            confirmDialog.setLocationRelativeTo(this);

            answer = confirmDialog.getAnswer();
            if (answer == 1) {
                dbCommande.AnnulerCommande(idCom);
                RefreshTableCommandes();
            }
        }
    }//GEN-LAST:event_btnTrashCommandeMousePressed

    private void BtnFinaliserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnFinaliserMousePressed
        int row = tableCommandeEnCours.getSelectedRow();
        if (row != -1) {
            int idcom = Integer.parseInt(tableCommandeEnCours.getValueAt(row, 0).toString());
            dbCommande.FinaliserCommande(idcom);
            RefreshTableCommandes();
        }


    }//GEN-LAST:event_BtnFinaliserMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BtnFinaliser;
    private javax.swing.JPanel LayoutRestaurant;
    private javax.swing.JPanel btnEditCommande;
    private javax.swing.JButton btnEmporter;
    private javax.swing.JButton btnT1;
    private javax.swing.JButton btnT10;
    private javax.swing.JButton btnT11;
    private javax.swing.JButton btnT12;
    private javax.swing.JButton btnT13;
    private javax.swing.JButton btnT14;
    private javax.swing.JButton btnT15;
    private javax.swing.JButton btnT16;
    private javax.swing.JButton btnT17;
    private javax.swing.JButton btnT2;
    private javax.swing.JButton btnT3;
    private javax.swing.JButton btnT4;
    private javax.swing.JButton btnT5;
    private javax.swing.JButton btnT6;
    private javax.swing.JButton btnT7;
    private javax.swing.JButton btnT8;
    private javax.swing.JButton btnT9;
    private javax.swing.JPanel btnTrashCommande;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCommandeEnCours;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
