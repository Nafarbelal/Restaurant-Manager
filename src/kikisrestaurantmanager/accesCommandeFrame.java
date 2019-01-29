/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kikisrestaurantmanager;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import MODEL.DB_Commande;
import MODEL.DB_Article;
import MODEL.DB_DetailCommande;
import MODEL.TableModel;
import addons.CustomColors;
import java.awt.Dialog;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN;
import static javax.swing.JTable.AUTO_RESIZE_OFF;
import javax.swing.UIManager;

/**
 *
 * @author Nada
 */
public class accesCommandeFrame extends javax.swing.JFrame implements ListSelectionListener {

    DB_Commande dbCommande = new DB_Commande();
    DB_DetailCommande dbDetailCommande = new DB_DetailCommande();
    DB_Article        dbArticle        = new DB_Article();
    int idCommande;
    

    /**
     * Creates new form accesCommande
     */
    public accesCommandeFrame() {
        initComponents();
        dbCommande.CreerCommande(0);
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        jScrollPane2.getViewport().setBackground(Color.WHITE);
    }
    MainMenu mainMenu;

    public accesCommandeFrame(MainMenu mn, int idTable, int idCommande) {
        //this.setUndecorated(true);
        mainMenu = mn;
        initComponents();
        
       /* Menu.getColumnModel().getColumn(0).setPreferredWidth(30);
        Menu.getColumnModel().getColumn(1).setPreferredWidth(150);
        Menu.getColumnModel().getColumn(2).setPreferredWidth(30);
        Menu.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);*/
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        jScrollPane2.getViewport().setBackground(Color.WHITE);
        this.getContentPane().setBackground(Color.white);
        if (idTable == 0) {
            TxtCurrentTable.setText("A emporter");
        } else {
            TxtCurrentTable.setText("Table " + idTable);
        }
        this.idCommande = idCommande;
        RefreshCommande();
        Refresh_Menu();
        setLocationRelativeTo(mainMenu);
    }

    public accesCommandeFrame(MainMenu mn, int idTable) {
        //this.setUndecorated(true);
        mainMenu = mn;
        initComponents();
        
        /*Menu.getColumnModel().getColumn(0).setPreferredWidth(30);
        Menu.getColumnModel().getColumn(1).setPreferredWidth(200);
        Menu.getColumnModel().getColumn(2).setPreferredWidth(30);
        Menu.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);*/
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        jScrollPane2.getViewport().setBackground(Color.WHITE);
        idCommande = dbCommande.CreerCommande(idTable);
        System.out.println("Commande créée");
        this.getContentPane().setBackground(Color.white);
        if (idTable == 0) {
            TxtCurrentTable.setText("A emporté");
        } else {
            TxtCurrentTable.setText("Table " + idTable);
        }
        RefreshCommande();
        Refresh_Menu();
        setLocationRelativeTo(mainMenu);
    }

    @Override
    public void dispose() {
        super.dispose(); //To change body of generated methods, choose Tools | Templates.
        mainMenu.setEnabled(true);
        mainMenu.setVisible(true);
        if (dbDetailCommande.CheckCreation(idCommande) == 0) {
            dbCommande.AnnulerCommande(idCommande);
        }

        mainMenu.getHomePanel1().RefreshTableCommandes();
    }

    public void disposeNormal() {
        super.dispose(); //To change body of generated methods, choose Tools | Templates.
        mainMenu.setEnabled(true);
        mainMenu.setVisible(true);

        mainMenu.getHomePanel1().RefreshTableCommandes();
    }

    public void RefreshCommande() {
        ResultSet details = dbDetailCommande.AfficherDetail(idCommande);
        TableCommande.setModel(new TableModel(details));
        dbCommande.UpdateMontantTotal(idCommande);
        TxtMontant.setText(Float.toString(dbCommande.getMontantTotalCommande(idCommande)) + " MAD");

    } // to refresh the order table 

    public void Refresh_Menu(String cat) {
        ResultSet articles = dbArticle.MenuCategorie(cat);
        Menu.setModel(new TableModel(articles));
    }

    public void Refresh_Menu() {
        ResultSet articles = dbArticle.MenuCategorieAll();
        Menu.setModel(new TableModel(articles));
    }
    private void DefaultColorAll() {
        PanelBoisson.setBackground(CustomColors.darkViolet);
        PanelBurger.setBackground(CustomColors.darkViolet);
        PanelDessert.setBackground(CustomColors.darkViolet);
        PanelPanini.setBackground(CustomColors.darkViolet);
        PanelPizza.setBackground(CustomColors.darkViolet);
        PanelPlat.setBackground(CustomColors.darkViolet);
        PanelSalade.setBackground(CustomColors.darkViolet);
        PanelSandwich.setBackground(CustomColors.darkViolet);
        PanelShawarma.setBackground(CustomColors.darkViolet);
        PanelTacos.setBackground(CustomColors.darkViolet);
       
    }
    private void MouseExited(JPanel p) {
        if (p.getBackground() != CustomColors.betweenViolet) {
            p.setBackground(CustomColors.darkViolet);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        TableCommande = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        Menu = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        PanelSandwich = new javax.swing.JPanel();
        TxtSandwich = new javax.swing.JLabel();
        PanelBurger = new javax.swing.JPanel();
        TxtBurger = new javax.swing.JLabel();
        PanelPizza = new javax.swing.JPanel();
        TxtPizza = new javax.swing.JLabel();
        PanelShawarma = new javax.swing.JPanel();
        TxtShawarma = new javax.swing.JLabel();
        PanelPlat = new javax.swing.JPanel();
        TxtPlat = new javax.swing.JLabel();
        PanelBoisson = new javax.swing.JPanel();
        TxtBoisson = new javax.swing.JLabel();
        PanelPanini = new javax.swing.JPanel();
        TxtPanini = new javax.swing.JLabel();
        PanelTacos = new javax.swing.JPanel();
        TxtTacos = new javax.swing.JLabel();
        PanelSalade = new javax.swing.JPanel();
        TxtSalade = new javax.swing.JLabel();
        PanelDessert = new javax.swing.JPanel();
        TxtDessert2 = new javax.swing.JLabel();
        TxtCurrentTable = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        BtnAnnuler = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        BtnConfirmer = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        Compteur = new javax.swing.JSpinner();
        MontantPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtMontant = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        LabelAdd = new javax.swing.JLabel();
        LabelDelete = new javax.swing.JLabel();
        btnTrash = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        TableCommande.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "null", "null", "null", "null", "null"
            }
        ));
        TableCommande.setGridColor(new java.awt.Color(153, 153, 255));
        TableCommande.setSelectionBackground(new java.awt.Color(153, 153, 255));
        TableCommande.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(TableCommande);
        if (TableCommande.getColumnModel().getColumnCount() > 0) {
            TableCommande.getColumnModel().getColumn(0).setResizable(false);
            TableCommande.getColumnModel().getColumn(1).setResizable(false);
            TableCommande.getColumnModel().getColumn(1).setPreferredWidth(10);
        }

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        Menu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Description", "Prix"
            }
        ));
        Menu.setSelectionBackground(new java.awt.Color(153, 153, 255));
        Menu.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Menu.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Menu);
        if (Menu.getColumnModel().getColumnCount() > 0) {
            Menu.getColumnModel().getColumn(0).setResizable(false);
            Menu.getColumnModel().getColumn(1).setResizable(false);
            Menu.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.setBackground(new java.awt.Color(54, 33, 89));

        PanelSandwich.setBackground(new java.awt.Color(54, 33, 89));
        PanelSandwich.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelSandwichMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelSandwichMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelSandwichMousePressed(evt);
            }
        });

        TxtSandwich.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        TxtSandwich.setForeground(new java.awt.Color(255, 255, 255));
        TxtSandwich.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtSandwich.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Bread_25px_1.png"))); // NOI18N
        TxtSandwich.setText("Sandwich");

        javax.swing.GroupLayout PanelSandwichLayout = new javax.swing.GroupLayout(PanelSandwich);
        PanelSandwich.setLayout(PanelSandwichLayout);
        PanelSandwichLayout.setHorizontalGroup(
            PanelSandwichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSandwichLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(TxtSandwich)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSandwichLayout.setVerticalGroup(
            PanelSandwichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TxtSandwich, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        PanelBurger.setBackground(new java.awt.Color(54, 33, 89));
        PanelBurger.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelBurgerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelBurgerMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelBurgerMousePressed(evt);
            }
        });

        TxtBurger.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        TxtBurger.setForeground(new java.awt.Color(255, 255, 255));
        TxtBurger.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtBurger.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Hamburger_25px_1.png"))); // NOI18N
        TxtBurger.setText("Burger");

        javax.swing.GroupLayout PanelBurgerLayout = new javax.swing.GroupLayout(PanelBurger);
        PanelBurger.setLayout(PanelBurgerLayout);
        PanelBurgerLayout.setHorizontalGroup(
            PanelBurgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBurgerLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(TxtBurger)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelBurgerLayout.setVerticalGroup(
            PanelBurgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TxtBurger, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        PanelPizza.setBackground(new java.awt.Color(54, 33, 89));
        PanelPizza.setForeground(new java.awt.Color(255, 255, 255));
        PanelPizza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelPizzaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelPizzaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelPizzaMousePressed(evt);
            }
        });

        TxtPizza.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        TxtPizza.setForeground(new java.awt.Color(255, 255, 255));
        TxtPizza.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtPizza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Pizza_25px.png"))); // NOI18N
        TxtPizza.setText("Pizza");

        javax.swing.GroupLayout PanelPizzaLayout = new javax.swing.GroupLayout(PanelPizza);
        PanelPizza.setLayout(PanelPizzaLayout);
        PanelPizzaLayout.setHorizontalGroup(
            PanelPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPizzaLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(TxtPizza)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelPizzaLayout.setVerticalGroup(
            PanelPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TxtPizza, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        PanelShawarma.setBackground(new java.awt.Color(54, 33, 89));
        PanelShawarma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelShawarmaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelShawarmaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelShawarmaMousePressed(evt);
            }
        });

        TxtShawarma.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        TxtShawarma.setForeground(new java.awt.Color(255, 255, 255));
        TxtShawarma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtShawarma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Wrap_25px.png"))); // NOI18N
        TxtShawarma.setText("Shawarma");

        javax.swing.GroupLayout PanelShawarmaLayout = new javax.swing.GroupLayout(PanelShawarma);
        PanelShawarma.setLayout(PanelShawarmaLayout);
        PanelShawarmaLayout.setHorizontalGroup(
            PanelShawarmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelShawarmaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(TxtShawarma)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelShawarmaLayout.setVerticalGroup(
            PanelShawarmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelShawarmaLayout.createSequentialGroup()
                .addComponent(TxtShawarma)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        PanelPlat.setBackground(new java.awt.Color(54, 33, 89));
        PanelPlat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelPlatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelPlatMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelPlatMousePressed(evt);
            }
        });

        TxtPlat.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        TxtPlat.setForeground(new java.awt.Color(255, 255, 255));
        TxtPlat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtPlat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Meal_25px.png"))); // NOI18N
        TxtPlat.setText("Plat");

        javax.swing.GroupLayout PanelPlatLayout = new javax.swing.GroupLayout(PanelPlat);
        PanelPlat.setLayout(PanelPlatLayout);
        PanelPlatLayout.setHorizontalGroup(
            PanelPlatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPlatLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(TxtPlat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelPlatLayout.setVerticalGroup(
            PanelPlatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TxtPlat, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        PanelBoisson.setBackground(new java.awt.Color(54, 33, 89));
        PanelBoisson.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelBoissonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelBoissonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelBoissonMousePressed(evt);
            }
        });

        TxtBoisson.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        TxtBoisson.setForeground(new java.awt.Color(255, 255, 255));
        TxtBoisson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Cocktail_25px_1.png"))); // NOI18N
        TxtBoisson.setText("Boisson");

        javax.swing.GroupLayout PanelBoissonLayout = new javax.swing.GroupLayout(PanelBoisson);
        PanelBoisson.setLayout(PanelBoissonLayout);
        PanelBoissonLayout.setHorizontalGroup(
            PanelBoissonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBoissonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TxtBoisson, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        PanelBoissonLayout.setVerticalGroup(
            PanelBoissonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBoissonLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(TxtBoisson, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PanelPanini.setBackground(new java.awt.Color(54, 33, 89));
        PanelPanini.setForeground(new java.awt.Color(255, 255, 255));
        PanelPanini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelPaniniMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelPaniniMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelPaniniMousePressed(evt);
            }
        });

        TxtPanini.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        TxtPanini.setForeground(new java.awt.Color(255, 255, 255));
        TxtPanini.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtPanini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Hot_Dog_25px.png"))); // NOI18N
        TxtPanini.setText("Panini");

        javax.swing.GroupLayout PanelPaniniLayout = new javax.swing.GroupLayout(PanelPanini);
        PanelPanini.setLayout(PanelPaniniLayout);
        PanelPaniniLayout.setHorizontalGroup(
            PanelPaniniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPaniniLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(TxtPanini)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelPaniniLayout.setVerticalGroup(
            PanelPaniniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TxtPanini, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        PanelTacos.setBackground(new java.awt.Color(54, 33, 89));
        PanelTacos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelTacosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelTacosMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelTacosMousePressed(evt);
            }
        });

        TxtTacos.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        TxtTacos.setForeground(new java.awt.Color(255, 255, 255));
        TxtTacos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtTacos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsAccesCommande/icons8_Taco_25px.png"))); // NOI18N
        TxtTacos.setText("Tacos");

        javax.swing.GroupLayout PanelTacosLayout = new javax.swing.GroupLayout(PanelTacos);
        PanelTacos.setLayout(PanelTacosLayout);
        PanelTacosLayout.setHorizontalGroup(
            PanelTacosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTacosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(TxtTacos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTacosLayout.setVerticalGroup(
            PanelTacosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TxtTacos, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        PanelSalade.setBackground(new java.awt.Color(54, 33, 89));
        PanelSalade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelSaladeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelSaladeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelSaladeMousePressed(evt);
            }
        });

        TxtSalade.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        TxtSalade.setForeground(new java.awt.Color(255, 255, 255));
        TxtSalade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtSalade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsAccesCommande/icons8_Salad_25px.png"))); // NOI18N
        TxtSalade.setText("Salade");

        javax.swing.GroupLayout PanelSaladeLayout = new javax.swing.GroupLayout(PanelSalade);
        PanelSalade.setLayout(PanelSaladeLayout);
        PanelSaladeLayout.setHorizontalGroup(
            PanelSaladeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSaladeLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(TxtSalade)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSaladeLayout.setVerticalGroup(
            PanelSaladeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TxtSalade, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        PanelDessert.setBackground(new java.awt.Color(54, 33, 89));
        PanelDessert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelDessertMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelDessertMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelDessertMousePressed(evt);
            }
        });

        TxtDessert2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        TxtDessert2.setForeground(new java.awt.Color(255, 255, 255));
        TxtDessert2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtDessert2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Confectionery_25px_3.png"))); // NOI18N
        TxtDessert2.setText("Dessert");

        javax.swing.GroupLayout PanelDessertLayout = new javax.swing.GroupLayout(PanelDessert);
        PanelDessert.setLayout(PanelDessertLayout);
        PanelDessertLayout.setHorizontalGroup(
            PanelDessertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDessertLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(TxtDessert2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelDessertLayout.setVerticalGroup(
            PanelDessertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TxtDessert2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        TxtCurrentTable.setBackground(new java.awt.Color(255, 255, 255));
        TxtCurrentTable.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        TxtCurrentTable.setForeground(new java.awt.Color(255, 255, 255));
        TxtCurrentTable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtCurrentTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsAccesCommande/icons8_Service_Bell_32px.png"))); // NOI18N
        TxtCurrentTable.setText("Current Table");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBoisson, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelPanini, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelSandwich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelBurger, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelPizza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelShawarma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelPlat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelTacos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelSalade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelDessert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(TxtCurrentTable, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(TxtCurrentTable, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(PanelBoisson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelPanini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelSandwich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelBurger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelPizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelShawarma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelPlat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelTacos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelSalade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelDessert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );

        BtnAnnuler.setBackground(new java.awt.Color(204, 204, 204));
        BtnAnnuler.setText("Annuler");
        BtnAnnuler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAnnulerMouseClicked(evt);
            }
        });
        BtnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnnulerActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Commande");

        BtnConfirmer.setBackground(new java.awt.Color(204, 204, 204));
        BtnConfirmer.setText("Confirmer");
        BtnConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConfirmerActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Menu");

        Compteur.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        Compteur.setValue(1);

        MontantPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 204, 255));
        jLabel1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Bill_25px.png"))); // NOI18N
        jLabel1.setText("TOTAL :");

        TxtMontant.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        TxtMontant.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TxtMontant.setText("0 ");

        javax.swing.GroupLayout MontantPanelLayout = new javax.swing.GroupLayout(MontantPanel);
        MontantPanel.setLayout(MontantPanelLayout);
        MontantPanelLayout.setHorizontalGroup(
            MontantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MontantPanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(TxtMontant, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        MontantPanelLayout.setVerticalGroup(
            MontantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(TxtMontant, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jLabel17.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel17.setText("Quantité");

        LabelAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Add_32px_2.png"))); // NOI18N
        LabelAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LabelAddMousePressed(evt);
            }
        });

        LabelDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Minus_32px_1.png"))); // NOI18N
        LabelDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LabelDeleteMousePressed(evt);
            }
        });

        btnTrash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Trash_32px_1.png"))); // NOI18N
        btnTrash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnTrashMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addGap(18, 18, 18)
                            .addComponent(Compteur, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(172, 172, 172)
                            .addComponent(LabelAdd)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MontantPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(BtnAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnConfirmer, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTrash)))
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTrash))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Compteur, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(LabelAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addComponent(MontantPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnAnnuler)
                            .addComponent(BtnConfirmer))
                        .addGap(27, 27, 27))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LabelAddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelAddMousePressed
        // Ajout de l'article dans detail_commande 
        int row = Menu.getSelectedRow();
        if (row != -1) {
            int id_article = Integer.parseInt(Menu.getValueAt(row, 0).toString());
            // found this (below) for spinners ( compteur dial quantité) 
            try {
                Compteur.commitEdit();
            } catch (java.text.ParseException e) {
                System.err.println("Prob de compteur " + e.getMessage());
            }
            int qu = (Integer) Compteur.getValue();
            if (dbDetailCommande.CheckArticle(id_article, idCommande) == 1) {
                dbDetailCommande.UpdateDetailCommande(id_article, idCommande, qu);
            } else {
                float prix = Float.parseFloat(Menu.getValueAt(row, 2).toString());
                dbDetailCommande.InsererDetailCommande(id_article, idCommande, qu, prix);
            }
            // Affichage depuis la base de données dans la table TableCommande
            RefreshCommande();
            Compteur.setValue(1);
        }
    }//GEN-LAST:event_LabelAddMousePressed


    private void LabelDeleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelDeleteMousePressed
        int row = TableCommande.getSelectedRow();
        if (row != -1) {
            int qu = Integer.parseInt(TableCommande.getValueAt(row, 2).toString());
            int id_article = Integer.parseInt(TableCommande.getValueAt(row, 0).toString());
            if (qu == 1) {
                dbDetailCommande.SupprimerArticleCommande(idCommande, id_article);
            } else {
                dbDetailCommande.UpdateDetailCommande(id_article, idCommande, -1);
            }
            RefreshCommande();
            if (qu > 1) {
                TableCommande.setRowSelectionInterval(row, row);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_LabelDeleteMousePressed

    private void BtnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnnulerActionPerformed
        int answer = 0;
        ConfirmationFrame confirmDialog = new ConfirmationFrame();
        confirmDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        confirmDialog.setLocationRelativeTo(this);
        
        if (dbDetailCommande.CheckCreation(this.idCommande) == 0) {
            this.disposeNormal();
            answer=1;
        } else {
            answer = confirmDialog.getAnswer();
        }
        
        if (answer == 1) {
            dbCommande.AnnulerCommande(idCommande);
            this.disposeNormal();
        }
    }//GEN-LAST:event_BtnAnnulerActionPerformed

    private void BtnAnnulerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAnnulerMouseClicked

    }//GEN-LAST:event_BtnAnnulerMouseClicked

    private void BtnConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfirmerActionPerformed
        if (dbDetailCommande.CheckCreation(idCommande) == 0) {
            dbCommande.AnnulerCommande(idCommande);
        }
        this.disposeNormal();
    }//GEN-LAST:event_BtnConfirmerActionPerformed

    private void btnTrashMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrashMousePressed
        int row = TableCommande.getSelectedRow();
        if (row != -1) {
            int id_article = Integer.parseInt(TableCommande.getValueAt(row, 0).toString());
            dbDetailCommande.SupprimerArticleCommande(idCommande, id_article);
            RefreshCommande();
        }
    }//GEN-LAST:event_btnTrashMousePressed

    private void PanelDessertMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelDessertMousePressed
        // TODO add your handling code here:
        String cat = "Dessert";
        Refresh_Menu(cat);
        PanelDessert.setBackground(CustomColors.betweenViolet);
    }//GEN-LAST:event_PanelDessertMousePressed

    private void PanelDessertMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelDessertMouseExited
        DefaultColorAll();// TODO add your handling code here:
        JPanel src = (JPanel) evt.getSource();
        src.setBackground(CustomColors.betweenViolet);
        MouseExited(src);
    }//GEN-LAST:event_PanelDessertMouseExited

    private void PanelDessertMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelDessertMouseEntered
        // TODO add your handling code here:
        JPanel src = (JPanel) evt.getSource();
        src.setBackground(CustomColors.orderFilterPanelHoveredOn);
    }//GEN-LAST:event_PanelDessertMouseEntered

    private void PanelSaladeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSaladeMousePressed
        // TODO add your handling code here:
        String cat = "Salade";
        Refresh_Menu(cat);
        PanelSalade.setBackground(CustomColors.betweenViolet);
    }//GEN-LAST:event_PanelSaladeMousePressed

    private void PanelSaladeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSaladeMouseExited
        DefaultColorAll();// TODO add your handling code here:
         JPanel src = (JPanel) evt.getSource();
        src.setBackground(CustomColors.betweenViolet);
        MouseExited(src);
    }//GEN-LAST:event_PanelSaladeMouseExited

    private void PanelSaladeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSaladeMouseEntered
        // TODO add your handling code here:
        JPanel src = (JPanel) evt.getSource();
        src.setBackground(CustomColors.orderFilterPanelHoveredOn);
    }//GEN-LAST:event_PanelSaladeMouseEntered

    private void PanelTacosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelTacosMousePressed
        String cat = "Tacos";
        Refresh_Menu(cat);
        PanelTacos.setBackground(CustomColors.betweenViolet);
    }//GEN-LAST:event_PanelTacosMousePressed

    private void PanelTacosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelTacosMouseExited
        DefaultColorAll();
        JPanel src = (JPanel) evt.getSource();
        src.setBackground(CustomColors.betweenViolet);
        MouseExited(src);// TODO add your handling code here:
    }//GEN-LAST:event_PanelTacosMouseExited

    private void PanelTacosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelTacosMouseEntered
        JPanel src = (JPanel) evt.getSource();
        src.setBackground(CustomColors.orderFilterPanelHoveredOn); // TODO add your handling code here:
    }//GEN-LAST:event_PanelTacosMouseEntered

    private void PanelPlatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelPlatMousePressed
        String cat = "Plat";
        Refresh_Menu(cat);
        PanelPlat.setBackground(CustomColors.betweenViolet);
    }//GEN-LAST:event_PanelPlatMousePressed

    private void PanelPlatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelPlatMouseExited
        DefaultColorAll();
        JPanel src = (JPanel) evt.getSource();
        src.setBackground(CustomColors.betweenViolet);
        MouseExited(src);        // TODO add your handling code here:
    }//GEN-LAST:event_PanelPlatMouseExited

    private void PanelPlatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelPlatMouseEntered
        JPanel src = (JPanel) evt.getSource();
        src.setBackground(CustomColors.orderFilterPanelHoveredOn);        // TODO add your handling code here:
    }//GEN-LAST:event_PanelPlatMouseEntered

    private void PanelShawarmaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelShawarmaMousePressed
        String cat = "Chawarma";
        Refresh_Menu(cat);
        PanelShawarma.setBackground(CustomColors.betweenViolet);
    }//GEN-LAST:event_PanelShawarmaMousePressed

    private void PanelShawarmaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelShawarmaMouseExited
        DefaultColorAll();;
        JPanel src = (JPanel) evt.getSource();
        src.setBackground(CustomColors.betweenViolet);
        MouseExited(src);        // TODO add your handling code here:
    }//GEN-LAST:event_PanelShawarmaMouseExited

    private void PanelShawarmaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelShawarmaMouseEntered
        JPanel src = (JPanel) evt.getSource();
        src.setBackground(CustomColors.orderFilterPanelHoveredOn);       // TODO add your handling code here:
    }//GEN-LAST:event_PanelShawarmaMouseEntered

    private void PanelPizzaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelPizzaMousePressed
        String cat = "Pizza";
        Refresh_Menu(cat);
        PanelPizza.setBackground(CustomColors.betweenViolet);
    }//GEN-LAST:event_PanelPizzaMousePressed

    private void PanelPizzaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelPizzaMouseExited
        DefaultColorAll();
        JPanel src = (JPanel) evt.getSource();
        src.setBackground(CustomColors.betweenViolet);
        MouseExited(src);// TODO add your handling code here:
    }//GEN-LAST:event_PanelPizzaMouseExited

    private void PanelPizzaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelPizzaMouseEntered
        JPanel src = (JPanel) evt.getSource();
        src.setBackground(CustomColors.orderFilterPanelHoveredOn);        // TODO add your handling code here:
    }//GEN-LAST:event_PanelPizzaMouseEntered

    private void PanelBurgerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelBurgerMousePressed
        String cat = "Burgers";
        Refresh_Menu(cat);
        PanelBurger.setBackground(CustomColors.betweenViolet);
    }//GEN-LAST:event_PanelBurgerMousePressed

    private void PanelBurgerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelBurgerMouseExited
        DefaultColorAll();
        JPanel src = (JPanel) evt.getSource();
        src.setBackground(CustomColors.betweenViolet);
        MouseExited(src);        // TODO add your handling code here:
    }//GEN-LAST:event_PanelBurgerMouseExited

    private void PanelBurgerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelBurgerMouseEntered
        JPanel src = (JPanel) evt.getSource();
        src.setBackground(CustomColors.orderFilterPanelHoveredOn);
        // TODO add your handling code here:
    }//GEN-LAST:event_PanelBurgerMouseEntered

    private void PanelSandwichMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSandwichMousePressed
        String cat = "Sandwich";
        Refresh_Menu(cat);
        PanelSandwich.setBackground(CustomColors.betweenViolet);
    }//GEN-LAST:event_PanelSandwichMousePressed

    private void PanelSandwichMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSandwichMouseExited
         DefaultColorAll();
         JPanel src = (JPanel) evt.getSource();
        src.setBackground(CustomColors.betweenViolet);
        MouseExited(src);
        // TODO add your handling code here:
    }//GEN-LAST:event_PanelSandwichMouseExited

    private void PanelSandwichMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSandwichMouseEntered
      
        // PanelSandwich.setBackground(CustomColors.orderFilterPanelHoveredOn);
        JPanel src = (JPanel) evt.getSource();
        src.setBackground(CustomColors.orderFilterPanelHoveredOn);// TODO add your handling code here:
    }//GEN-LAST:event_PanelSandwichMouseEntered

    private void PanelBoissonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelBoissonMousePressed
        String cat = "Boissons";
        Refresh_Menu(cat);
        PanelBoisson.setBackground(CustomColors.betweenViolet);
    }//GEN-LAST:event_PanelBoissonMousePressed

    private void PanelBoissonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelBoissonMouseExited
        DefaultColorAll();
        JPanel src = (JPanel) evt.getSource();
        src.setBackground(CustomColors.betweenViolet);
        MouseExited(src);
        // TODO add your handling code here:
    }//GEN-LAST:event_PanelBoissonMouseExited

    private void PanelBoissonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelBoissonMouseEntered
        JPanel src = (JPanel) evt.getSource();
        src.setBackground(CustomColors.betweenViolet);

        // TODO add your handling code here:
    }//GEN-LAST:event_PanelBoissonMouseEntered

    private void PanelPaniniMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelPaniniMousePressed
        String cat = "Panini";
        Refresh_Menu(cat);
        PanelPanini.setBackground(CustomColors.betweenViolet);
        // TODO add your handling code here:
    }//GEN-LAST:event_PanelPaniniMousePressed

    private void PanelPaniniMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelPaniniMouseExited
        DefaultColorAll();
        JPanel src = (JPanel) evt.getSource();
        src.setBackground(CustomColors.betweenViolet);
        MouseExited(src);// TODO add your handling code here:
    }//GEN-LAST:event_PanelPaniniMouseExited

    private void PanelPaniniMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelPaniniMouseEntered

        JPanel src = (JPanel) evt.getSource();
        src.setBackground(CustomColors.orderFilterPanelHoveredOn);// TODO add your handling code here:
    }//GEN-LAST:event_PanelPaniniMouseEntered

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
            java.util.logging.Logger.getLogger(accesCommandeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(accesCommandeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(accesCommandeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(accesCommandeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new accesCommandeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAnnuler;
    private javax.swing.JButton BtnConfirmer;
    private javax.swing.JSpinner Compteur;
    private javax.swing.JLabel LabelAdd;
    private javax.swing.JLabel LabelDelete;
    private javax.swing.JTable Menu;
    private javax.swing.JPanel MontantPanel;
    private javax.swing.JPanel PanelBoisson;
    private javax.swing.JPanel PanelBurger;
    private javax.swing.JPanel PanelDessert;
    private javax.swing.JPanel PanelPanini;
    private javax.swing.JPanel PanelPizza;
    private javax.swing.JPanel PanelPlat;
    private javax.swing.JPanel PanelSalade;
    private javax.swing.JPanel PanelSandwich;
    private javax.swing.JPanel PanelShawarma;
    private javax.swing.JPanel PanelTacos;
    private javax.swing.JTable TableCommande;
    private javax.swing.JLabel TxtBoisson;
    private javax.swing.JLabel TxtBurger;
    private javax.swing.JLabel TxtCurrentTable;
    private javax.swing.JLabel TxtDessert2;
    private javax.swing.JLabel TxtMontant;
    private javax.swing.JLabel TxtPanini;
    private javax.swing.JLabel TxtPizza;
    private javax.swing.JLabel TxtPlat;
    private javax.swing.JLabel TxtSalade;
    private javax.swing.JLabel TxtSandwich;
    private javax.swing.JLabel TxtShawarma;
    private javax.swing.JLabel TxtTacos;
    private javax.swing.JLabel btnTrash;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
