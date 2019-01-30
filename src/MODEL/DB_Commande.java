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
public class DB_Commande {

    private Connection Con;
    private Statement St;
    private DaoBD dao;

    public DB_Commande() {
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

    public void FinaliserCommande(int idcom) {
        try {
            PreparedStatement Pst = Con.prepareStatement("update Commande set paye=1 where idcommande=" + idcom);
            Pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requete FinaliserCommande " + ex.getMessage());
        }
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

    public int getIdCommandeNonPayéFromNumTable(int idTable) {
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

    public void AnnulerCommande(int Id_commande) {
        try {
            PreparedStatement Pst = Con.prepareStatement("delete from commande where IDCOMMANDE=" + Id_commande);
            Pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requete Supprimer" + ex.getMessage());
        }
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

    public ResultSet commandesShowAll() {
        try {
            ResultSet Rs;
            PreparedStatement Pst = Con.prepareStatement("SELECT idcommande as Id,date as Date,montant as MontantTotal,numTable as \"Table\" FROM Commande");
            System.out.println(Pst.toString());
            Rs = Pst.executeQuery();
            System.out.println("Testing commandes ShowAll");

            return Rs;
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requête commandesShowAll " + ex.getMessage());
        }
        return null;
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
    public ResultSet TousLesCommandesNonPayées() {
        ResultSet Res = null;
        try {
            St = Con.createStatement();
            Res = St.executeQuery("Select idcommande as Id,date as Date,montant as MontantTotal,numTable as 'Table' from commande where paye=0 ");
        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete Select: ou ST : " + ex.getMessage());
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

    public ResultSet commandesToday() {
        try {
            ResultSet Rs;
            PreparedStatement Pst = Con.prepareStatement("SELECT idcommande as Id,date as Date,montant as MontantTotal,numTable as \"Table\" FROM Commande "
                    + " where DATE_FORMAT(Date,\"%Y %M %d\")=DATE_FORMAT(CURDATE(),\"%Y %M %d\")");
            System.out.println(Pst.toString());

            Rs = Pst.executeQuery();
            System.out.println("Testing commandesToday");

            return Rs;
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requête commandesToday " + ex.getMessage());
        }
        return null;
    }

    public ResultSet commandesYesterday() {
        try {
            ResultSet Rs;
            PreparedStatement Pst = Con.prepareStatement("SELECT idcommande as Id,date as Date,montant as MontantTotal,numTable as \"Table\" FROM Commande "
                    + " where DATE_FORMAT(Date,\"%Y %M %d\")=DATE_FORMAT(DATE_SUB(CURDATE(),INTERVAL 1 DAY),\"%Y %M %d\")");
            System.out.println(Pst.toString());

            Rs = Pst.executeQuery();
            System.out.println("Testing commandesToday");

            return Rs;
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requête commandesToday " + ex.getMessage());
        }
        return null;
    }

    public ResultSet commandesThisWeek() {
        try {
            ResultSet Rs;
            PreparedStatement Pst = Con.prepareStatement("SELECT idcommande as Id,date as Date,montant as MontantTotal,numTable as \"Table\" FROM Commande "
                    + " where YEARWEEK(Date,1)=YEARWEEK(CURDATE(),1)");
            System.out.println(Pst.toString());
            Rs = Pst.executeQuery();
            System.out.println("Testing commandesThisWeek");

            return Rs;
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requête commandesThisWeek " + ex.getMessage());
        }
        return null;
    }

    public ResultSet commandesThisMonth() {
        try {
            ResultSet Rs;
            PreparedStatement Pst = Con.prepareStatement("SELECT idcommande as Id,date as Date,montant as MontantTotal,numTable as \"Table\" FROM Commande "
                    + " where DATE_FORMAT(Date,\"%Y %M\")=DATE_FORMAT(CURDATE(),\"%Y %M\")");
            System.out.println(Pst.toString());
            Rs = Pst.executeQuery();
            System.out.println("Testing commandesThisMonth");

            return Rs;
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requête commandesThisMonth " + ex.getMessage());
        }
        return null;
    }

    public ResultSet commandesThisYear() {
        try {
            ResultSet Rs;
            PreparedStatement Pst = Con.prepareStatement("SELECT idcommande as Id,date as Date,montant as MontantTotal,numTable as \"Table\" FROM Commande "
                    + " where DATE_FORMAT(Date,\"%Y\")=DATE_FORMAT(CURDATE(),\"%Y\")");
            System.out.println(Pst.toString());
            Rs = Pst.executeQuery();
            System.out.println("Testing commandesThisYear");

            return Rs;
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requête commandesThisYear " + ex.getMessage());
        }
        return null;
    }

}
