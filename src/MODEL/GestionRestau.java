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
}
