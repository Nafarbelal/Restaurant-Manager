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

    public int CreerCommande() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));

        try {
            PreparedStatement Pst = Con.prepareStatement("insert into Commande(date,montant,paye) values (?,?,?)");
            Pst.setString(1, dateFormat.format(date));
            Pst.setFloat(2, 0);
            Pst.setInt(3, 0);
            Pst.executeUpdate();
            PreparedStatement Pst2 = Con.prepareStatement("select max(IDCOMMANDE) from Commande");
            int id = Pst2.executeUpdate();
            return id;

        } catch (SQLException ex) {
            System.err.println("Erreur dans la requete CreerCommande" + ex.getMessage());
        }
        return -1;
    }

    
    
    public void InsererDetailCommande(int ID_Article, int ID_commande, int Qu) {

        try {

            PreparedStatement Pst = Con.prepareStatement("insert into detail_commande(IDARTICLE,IDCOMMANDE,QUANTITE) values (?,?,?)");
            Pst.setInt(1, ID_Article);
            Pst.setInt(2, ID_commande);
            Pst.setInt(3, Qu);
            Pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requete AnnulerCommande" + ex.getMessage());
        }
    }

    public void UpdateDetailCommande(int ID_Article, int ID_commande, int Qu) {
        try {

            PreparedStatement Pst = Con.prepareStatement("update detail_commande set QUANTITE=? where IDARTICLE=? and IDCOMMANDE=?");
            Pst.setInt(1, Qu);
            Pst.setInt(2, ID_Article);
            Pst.setInt(3, ID_commande);
            Pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requete UpdateDetailCommande" + ex.getMessage());
        }
    }

    
    public void AnnulerCommande(int Id_commande) 
    {
        try {
            PreparedStatement Pst = Con.prepareStatement("delete from commande where IDCOMMANDE="+Id_commande);
            Pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requete Supprimer" + ex.getMessage());
        }
    }

    public void AfficherCommande(int numTable, int IDCOM) {
        try {
            PreparedStatement Pst = Con.prepareStatement("select * from Commande where IDCOMMANDE=? AND NumTable=?");
            Pst.setInt(1, IDCOM);
            Pst.setInt(2, numTable);
            Pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requete Supprimer" + ex.getMessage());
        }

    }

    public ResultSet AfficherDetail(int numTable, int IDCOM) {
        ResultSet Res = null;
        try {
            St = Con.createStatement();
            Res = St.executeQuery("Select DC.IDARTICLE,Designation,Quantite,Prix as PU, Prix*Quantite as montant from detail_commande DC, Article A where DC.IDARTICLE=A.IDARTICLE and DC.IDCOMMANDE=" + IDCOM);

        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete select ou ST , " + ex.getMessage());
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
