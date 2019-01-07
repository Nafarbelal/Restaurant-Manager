/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/*
    Supprimer détail_commande (par code/trigger)
    Ajouter article ds table commande

 */
import DAO.DaoBD;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nada
 */
public class Commande {

    private Connection Con;
    private Statement St;
    private DaoBD dao;

    public Commande() {
        dao = new DaoBD();
        dao.setPilote("com.mysql.jdbc.Driver");
        dao.setUrl("jdbc:mysql://localhost:3306/projetjava");
        dao.setLogin("root");
        dao.setPassword("");
        dao.SeConnecter();
        Con = dao.getConnexion();
    }

    public int CreerCommande(int idTable) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));

        try {
            int maxIdCom = 1;
            PreparedStatement Pst2 = Con.prepareStatement("select max(idCommande) from commande");
            ResultSet res = Pst2.executeQuery();
            if (res.next()) {
                maxIdCom = res.getInt(1) + 1;
            }
            PreparedStatement Pst = Con.prepareStatement("insert into Commande(IDcommande,date,montant,paye,numTable) values (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            Pst.setInt(1, maxIdCom);
            Pst.setString(2, dateFormat.format(date));
            Pst.setFloat(3, 0);
            Pst.setInt(4, 0);
            Pst.setInt(5, idTable);

            Pst.executeUpdate();
            ResultSet Rs = Pst.getGeneratedKeys();
            if (Rs.next()) {
                int id = Rs.getInt(1);
                return id;
            }

        } catch (SQLException ex) {
            System.err.println("Erreur dans la requete CreerCommande " + ex.getMessage());
        }
        return -1;
    }

    public float getMontantTotalCommande(int Idcom) {
        try {
            PreparedStatement Pst = Con.prepareStatement("select montant from commande where idcommande =" + Idcom);
            ResultSet res = Pst.executeQuery();
            if (res.next()) {
                float mnt = res.getFloat(1);
                return mnt;
            }
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requete getMontantTotalCommande " + ex.getMessage());
        }
        return 0;
    }

    public int getNumTableduneCommande(int Idcom) {
        try {
            PreparedStatement Pst = Con.prepareStatement("select numTable from commande where idcommande =" + Idcom);
            ResultSet res = Pst.executeQuery();
            if (res.next()) {
                int numTable = res.getInt(1);
                return numTable;
            }
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requete getMontantTotalCommande " + ex.getMessage());
        }
        return 0;
    }
    
        public int getIdCommandeFromNumTable(int idTable) {
        try {
            PreparedStatement Pst = Con.prepareStatement("select idCommande from commande where Paye=0 and numtable=" + idTable);
            ResultSet res = Pst.executeQuery();
            if (res.next()) {
                int idCom = res.getInt(1);
                return idCom;
            }
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requete getMontantTotalCommande " + ex.getMessage());
        }
        return 0;
    }

    public ArrayList<Integer> getNumTablesOccupé() {
        try {
            ArrayList<Integer> TablesOccupied = new ArrayList<Integer>();
            PreparedStatement Pst = Con.prepareStatement("select distinct numTable from commande where Paye =0");
            ResultSet res = Pst.executeQuery();
            while (res.next()) {
                TablesOccupied.add(res.getInt(1));
            }
            return TablesOccupied;
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requete getMontantTotalCommande " + ex.getMessage());
        }
        return null;
    }

    public int CheckCreation(int Idcom) {
        try {
            PreparedStatement Pst = Con.prepareStatement("select count(*) from detail_commande where idcommande =" + Idcom);
            ResultSet res = Pst.executeQuery();
            if (res.next()) {
                int count = res.getInt(1);
                return count;
            }
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requete CheckCreation " + ex.getMessage());
        }
        return 0;
    }

    public int CheckArticle(int IdArticle, int Idcom) {
        try {
            PreparedStatement Pst = Con.prepareStatement("select count(*) from detail_commande where idcommande =" + Idcom + " and idarticle=" + IdArticle);
            ResultSet res = Pst.executeQuery();
            if (res.next()) {
                int count = res.getInt(1);
                System.out.println("Count :" + count);
                return count;
            }
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requete CheckArticle " + ex.getMessage());
        }
        return 0;
    }

    public void InsererDetailCommande(int ID_Article, int ID_commande, int Qu, float prix) {

        try {

            PreparedStatement Pst = Con.prepareStatement("insert into detail_commande(IDARTICLE,IDCOMMANDE,QUANTITE,prixAchat) values (?,?,?,?)");
            Pst.setInt(1, ID_Article);
            Pst.setInt(2, ID_commande);
            Pst.setInt(3, Qu);
            Pst.setFloat(4, prix);
            Pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requete InsererDetailCommande " + ex.getMessage());
        }
    }

    public void UpdateDetailCommande(int ID_Article, int ID_commande, int Qu) {
        try {

            PreparedStatement Pst = Con.prepareStatement("update detail_commande set QUANTITE=QUANTITE+? where IDARTICLE=? and IDCOMMANDE=?");
            Pst.setInt(1, Qu);
            Pst.setInt(2, ID_Article);
            Pst.setInt(3, ID_commande);
            Pst.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erreur dans la requete UpdateDetailCommande" + ex.getMessage());
        }
    }

    public void AnnulerCommande(int Id_commande) {
        try {
            PreparedStatement Pst = Con.prepareStatement("delete from commande where IDCOMMANDE=" + Id_commande);
            Pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requete Supprimer" + ex.getMessage());
        }
    }

    /*  public void AfficherCommande(int numTable, int IDCOM) {
        try {
            PreparedStatement Pst = Con.prepareStatement("select * from Commande where IDCOMMANDE=? AND NumTable=?");
            Pst.setInt(1, IDCOM);
            Pst.setInt(2, numTable);
            Pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requete Supprimer" + ex.getMessage());
        }

    } */
    public ResultSet AfficherDetail(int IDCOM) {
        ResultSet Res = null;
        try {
            St = Con.createStatement();
            Res = St.executeQuery("Select DC.IDARTICLE,Designation,Quantite,prixAchat as PU, prixAchat*Quantite as montant from detail_commande DC, Article A where DC.IDARTICLE=A.IDARTICLE and DC.IDCOMMANDE=" + IDCOM);

        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete AfficherDetail  " + ex.getMessage());
        }
        return Res;
    }

    public void SupprimerCommande(int ID_Commande) {
        try {
            PreparedStatement Pst = Con.prepareStatement("delete from detail_commande where IDCOMMANDE=?");
            Pst.setInt(1, ID_Commande);
            Pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requete Supprimer" + ex.getMessage());
        }
    }

    public void SupprimerArticleCommande(int ID_Commande, int ID_Article) {
        try {
            PreparedStatement Pst = Con.prepareStatement("delete from detail_commande where IDCOMMANDE=? AND IDARTICLE=?");
            Pst.setInt(1, ID_Commande);
            Pst.setInt(2, ID_Article);
            Pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requete Supprimer" + ex.getMessage());
        }

    }

    public void UpdateMontantTotal(int ID_commande) {
        try {
            int mnt = 0;
            PreparedStatement Pst1 = Con.prepareStatement("select sum(quantite*prixAchat) from detail_commande where idcommande=" + ID_commande);
            ResultSet res = Pst1.executeQuery();
            if (res.next()) {
                mnt = res.getInt(1);
            }
            PreparedStatement Pst2 = Con.prepareStatement("update commande set MONTANT=? where IDCOMMANDE=?");
            Pst2.setInt(1, mnt);
            Pst2.setInt(2, ID_commande);
            Pst2.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erreur dans la requete UpdateMontantTotal" + ex.getMessage());
        }
    }

    public ResultSet MenuCategorie(String cat) {
        ResultSet Res = null;
        try {
            St = Con.createStatement();
            Res = St.executeQuery("Select IDARTICLE,Designation,Prix from article where categorie='" + cat + "'");
        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete select ou ST , " + ex.getMessage());
        }
        return Res;
    }
    
        public ResultSet MenuCategorieAll() {
        ResultSet Res = null;
        try {
            St = Con.createStatement();
            Res = St.executeQuery("Select IDARTICLE,Designation,Prix from article");
        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete select ou ST , " + ex.getMessage());
        }
        return Res;
    }

    public ResultSet ToutLeMenu() {
        ResultSet Res = null;
        try {
            St = Con.createStatement();
            Res = St.executeQuery("Select Designation,Prix from Article ");
        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete select ou ST , " + ex.getMessage());
        }
        return Res;
    }

    public int getID(String cat) {
        ResultSet Res;
        try {
            St = Con.createStatement();
            Res = St.executeQuery("Select IDARTICLE from Article where categorie='" + cat + "'");
            if (Res.next()) {
                return Res.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete getID, " + ex.getMessage());
        }
        return 0;
    }

}
