/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import DAO.DaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ilyas El Bani
 */
public class DB_DetailCommande {

    private Connection Con;
    private Statement St;
    private DaoBD dao;

    public DB_DetailCommande() {
        dao = new DaoBD();
        dao.setPilote("com.mysql.jdbc.Driver");
        dao.setUrl("jdbc:mysql://localhost:3306/projetjava");
        dao.setLogin("root");
        dao.setPassword("");
        dao.SeConnecter();
        Con = dao.getConnexion();
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

    public ResultSet AfficherDetail(int IDCOM) {
        ResultSet Res = null;
        try {
            St = Con.createStatement();
            Res = St.executeQuery("Select DC.IDARTICLE as ID,Designation,Quantite,prixAchat as PU, prixAchat*Quantite as montant from detail_commande DC, Article A where DC.IDARTICLE=A.IDARTICLE and DC.IDCOMMANDE=" + IDCOM);

        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete AfficherDetail  " + ex.getMessage());
        }
        return Res;
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

    public ResultSet detailsByID(int ID) {
        try {
            ResultSet Rs;
            PreparedStatement Pst = Con.prepareStatement("SELECT article.idarticle as ID ,article.designation as Designation ,detail_commande.quantite as Quantite ,detail_commande.prixachat as Prix FROM article,detail_commande WHERE idcommande=" + ID + " AND article.idarticle=detail_commande.idarticle");
            System.out.println(Pst.toString());
            Rs = Pst.executeQuery();
            System.out.println("Testing commandes detailsByID");
            return Rs;
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requête detailsByID " + ex.getMessage());
        }
        return null;
    }

}
