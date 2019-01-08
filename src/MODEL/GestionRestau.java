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
    
   public int CheckPassword(String pwd)
   {
      
       try
       {
           PreparedStatement Pst = Con.prepareStatement("Select count(*) from Employees where motdepasse='"+pwd+"'");
           ResultSet rs= Pst.executeQuery();
           if(rs.next())
               return rs.getInt(1);
       }
       catch(SQLException e)
       {
             System.out.println("Erreur dans la requete CheckPassword " + e.getMessage());

       }
       return 0;
   }
   
   public void UpdatePwd(String pwd)
   {
       try {
           PreparedStatement Pst=Con.prepareStatement("update Employees set motdepasse='"+pwd+"' where idemployee=1");
           Pst.executeUpdate();
       }
       catch(SQLException e)
       {
            System.out.println("Erreur dans la requete UpdatePwd " + e.getMessage());

       }
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

    public ResultSet commandesParDate(String jourDeb, String moisDeb, String anneeDeb,String jourFin, String moisFin, String anneeFin) {
        try {
            ResultSet Rs;
            PreparedStatement Pst = Con.prepareStatement("SELECT idcommande as Id,date as Date,montant as MontantTotal,numTable as \"Table\" FROM Commande "
                    + " where Date>='" +anneeDeb +"-"+moisDeb+"-"+jourDeb+"' and date < '"+anneeFin +"-"+moisFin+"-"+jourFin+"'" );
            System.out.println(Pst.toString());


            Rs = Pst.executeQuery();
            System.out.println("Testing ComamndesParDate");
          
            return Rs;
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requête commandesParDate " + ex.getMessage());
        }
        return null;
    }
    
    public ResultSet commandesToday() {
        try {
            ResultSet Rs;
            PreparedStatement Pst = Con.prepareStatement("SELECT idcommande as Id,date as Date,montant as MontantTotal,numTable as \"Table\" FROM Commande "
                    + " where DATE_FORMAT(Date,\"%Y %M %d\")=DATE_FORMAT(CURDATE(),\"%Y %M %d\")" );
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
                    + " where DATE_FORMAT(Date,\"%Y %M %d\")=DATE_FORMAT(DATE_SUB(CURDATE(),INTERVAL 1 DAY),\"%Y %M %d\")" );
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
                    + " where YEARWEEK(Date,1)=YEARWEEK(CURDATE(),1)" );
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
                    + " where DATE_FORMAT(Date,\"%Y %M\")=DATE_FORMAT(CURDATE(),\"%Y %M\")" );
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
                    + " where DATE_FORMAT(Date,\"%Y\")=DATE_FORMAT(CURDATE(),\"%Y\")" );
            System.out.println(Pst.toString());
            Rs = Pst.executeQuery();
            System.out.println("Testing commandesThisYear");
          
            return Rs;
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requête commandesThisYear " + ex.getMessage());
        }
        return null;
    }
    
    public ResultSet commandesShowAll() {
        try {
            ResultSet Rs;
            PreparedStatement Pst = Con.prepareStatement("SELECT idcommande as Id,date as Date,montant as MontantTotal,numTable as \"Table\" FROM Commande" );
            System.out.println(Pst.toString());
            Rs = Pst.executeQuery();
            System.out.println("Testing commandes ShowAll");
          
            return Rs;
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requête commandesShowAll " + ex.getMessage());
        }
        return null;
    }
    
    public ResultSet detailsByID(int ID) {
        try {
            ResultSet Rs;
            PreparedStatement Pst = Con.prepareStatement("SELECT article.idarticle as ID ,article.designation as Designation ,detail_commande.quantite as Quantite ,detail_commande.prixachat as Prix FROM article,detail_commande WHERE idcommande="+ID+" AND article.idarticle=detail_commande.idarticle" );
            System.out.println(Pst.toString());
            Rs = Pst.executeQuery();
            System.out.println("Testing commandes detailsByID");      
            return Rs;
        } 
        catch (SQLException ex) {
            System.err.println("Erreur dans la requête detailsByID " + ex.getMessage());
        }
        return null;
    }

       

}
