/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import DAO.DaoBD;
import DB_Objects.Employee;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ilyas El Bani
 */
public class GestionRestau {

    private Connection Con;
    private Statement St;
    private DaoBD dao;

    public GestionRestau() {
        dao = new DaoBD();
        dao.setPilote("com.mysql.jdbc.Driver");
        dao.setUrl("jdbc:mysql://localhost:3306/projetjava");
        dao.setLogin("root");
        dao.setPassword("");
        dao.SeConnecter();
        Con = dao.getConnexion();
    }

    public Employee getLoginInfos(String login) {
        ResultSet Res;
        //System.out.println("No Errors");

        try {
            St = Con.createStatement();
            Res = St.executeQuery("select * from employees where login = '" + login + "'");
            if (Res.next()) {
                int id = Res.getInt("IDEMPLOYEE");
                String lg = Res.getString("LOGIN");
                String pw = Res.getString("MOTDEPASSE");
                String nom = Res.getString("NOM");
                System.out.println(nom);
                String prenom = Res.getString("PRENOM");

                Employee emp = new Employee(id, lg, pw, nom, prenom);
                return emp;
            }
            return null;
        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete Select: ou ST :;; " + ex.getMessage());
        }
        return null;
    }

    public ResultSet TousLesCommandesNonPayées() {
        ResultSet Res = null;
        try {
            St = Con.createStatement();
            Res = St.executeQuery("Select idcommande as Id,date as Date,montant as MontantTotal,numTable as 'Table' from commande ");
        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete Select: ou ST : " + ex.getMessage());
        }
        return Res;
    }

    public void Create(int apogee, int cne, String Nom, String Prenom,
            String cin, String villeNaissance, int idFil) {
        String Req;
        Req = "insert into Eleve values ('"
                + apogee + "','" + cne + "','" + Nom + "','"
                + Prenom + "'"
                + ",'2000-12-30'," //date
                + "'" + cin + "','" + villeNaissance + "','" + idFil + "')";
        System.out.println("insert into Eleve values ('"
                + apogee + "','" + cne + "','" + Nom + "','"
                + Prenom + "'"
                + ",'2000-12-30'," //date
                + "'" + cin + "','" + villeNaissance + "','" + idFil + "')");
        try {
            if (Con != null) {
                St = Con.createStatement();
                St.executeUpdate(Req);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete Create: " + ex.getMessage());
        }
    }

    public void update(int apogee, int cne, String Nom, String Prenom,
            String cin, String villeNaissance, String Fil, String Niv) {
        String Req;

        Req = "update Eleve set cne=?, Nom=?, Prenom=?, cin=?, villeNaissance=?, Id_Filiere= ? where Apogee = ?  ";

        try {
            PreparedStatement Pst = Con.prepareStatement(Req);
            Pst.setInt(1, cne);
            Pst.setString(2, Nom);
            Pst.setString(3, Prenom);
            Pst.setString(4, cin);
            Pst.setString(5, villeNaissance);
            Pst.setInt(6, getIdDeFiliere(Fil, Niv));
            Pst.setInt(7, apogee);

            int nb = Pst.executeUpdate();
            System.out.println("MAJ Reussi: Nbre de lignes affectés est : " + nb);
        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete préparé: " + ex.getMessage());
        }
    }

    public void delete(int apogee) {
        String Req;
        Req = "delete from Eleve where Apogee = ? ";
        try {
            PreparedStatement Pst = Con.prepareStatement(Req);
            Pst.setInt(1, apogee);
            int nb = Pst.executeUpdate();
            System.out.println("Suppression Reussi: Nbre de lignes affectés est : " + nb);
        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete préparé: " + ex.getMessage());
        }
    }

    public ResultSet EleveFiliere(int idFiliere) {
        ResultSet Res = null;
        try {
            St = Con.createStatement();
            Res = St.executeQuery("Select * from Eleve where Id_Filiere=" + idFiliere);;
        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete Select: ou ST : " + ex.getMessage());
        }
        return Res;
    }

    public int getIdDeFiliere(String Fil, String Niveau) {
        ResultSet Res;
        try {
            St = Con.createStatement();
            System.out.println(Fil + " " + Niveau);
            Res = St.executeQuery("select Id_filiere from Filiere where NomFiliere='" + Fil + "' AND Niveau=" + Niveau);
            if (Res.next()) {
                return Res.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete Select: ou ST :;; " + ex.getMessage());
        }
        return 0;
    }

    public String getFiliereFromID(int ID) {
        ResultSet Res;
        try {
            St = Con.createStatement();
            Res = St.executeQuery("select NomFiliere from Filiere where Id_filiere=" + ID);
            if (Res.next()) {
                return Res.getString(1);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete Select: ou ST :;; " + ex.getMessage());
        }
        return "";
    }

    public String getNiveauFromID(int ID) {
        ResultSet Res;
        try {
            St = Con.createStatement();
            Res = St.executeQuery("select Niveau from Filiere where Id_filiere=" + ID);
            if (Res.next()) {
                return Res.getString(1);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete Select: ou ST :;; " + ex.getMessage());
        }
        return "";
    }
    
    public ResultSet commandesParDate(String Jour, String Mois, String Annee)
    {
        try
        {
            PreparedStatement Pst=Con.prepareStatement("SELECT idcommande as Id,date as Date,montant as MontantTotal,numTable as Table FROM Commande WHERE date>=SELECT STR_TO_DATE(\"? ? ? 00 00 00\", \"%d %M %Y %H %i %S\") AND date<=SELECT STR_TO_DATE(\"? ? ? 23 59 59\", \"%d %M %Y %H %i %S\");");
            Pst.setString(1, Annee);
            Pst.setString(2, Mois);
            Pst.setString(3,Jour);
            Pst.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.err.println("Erreur dans la requête SELECT "+ex.getMessage());
        }
    }
    
}
