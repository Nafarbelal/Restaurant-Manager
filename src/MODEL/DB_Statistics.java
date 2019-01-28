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
public class DB_Statistics {

    private Connection Con;
    private Statement St;
    private DaoBD dao;

    public DB_Statistics() {
        dao = new DaoBD();
        dao.setPilote("com.mysql.jdbc.Driver");
        dao.setUrl("jdbc:mysql://localhost:3306/projetjava");
        dao.setLogin("root");
        dao.setPassword("");
        dao.SeConnecter();
        Con = dao.getConnexion();
    }

    //select DATE_FORMAT(date,'%Y-%m-%d %H:%i:%s'),sum(MONTANT) from commande group by year(Date),month(date),day(date),hour(date);
    public ResultSet RevenusParJour() {
        try {
            ResultSet Rs;
            PreparedStatement Pst = Con.prepareStatement("select DATE_FORMAT(date,'%Y-%m-%d %H:%i:%s') DATE,sum(MONTANT) MntTotal from commande group by year(Date),month(date),day(date);");
            Rs = Pst.executeQuery();
            return Rs;
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requête commandesShowAll " + ex.getMessage());
        }
        return null;
    }

    public ResultSet RevenusParMois() {
        try {
            ResultSet Rs;
            PreparedStatement Pst = Con.prepareStatement("select DATE_FORMAT(date,'%Y-%m-%d %H:%i:%s') DATE,sum(MONTANT) MntTotal from commande group by year(Date),month(date);");
            Rs = Pst.executeQuery();
            return Rs;
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requête commandesShowAll " + ex.getMessage());
    }
        return null;
    }

    public ResultSet RevenusParSemaine() {
        try {
            ResultSet Rs;
            PreparedStatement Pst = Con.prepareStatement("select DATE_FORMAT(date,'%Y-%m-%d %H:%i:%s') DATE,sum(MONTANT) MntTotal from commande group by year(Date),week(date);");
            Rs = Pst.executeQuery();
            return Rs;
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requête commandesShowAll " + ex.getMessage());
        }
        return null;
    }
//select DATE_FORMAT(date,'%Y-%m-%d %H:%i:%s') , count(*) from commande group by hour(date);
        public ResultSet HeuresActivesDebFin(String debDate, String finDate) {
        try {
            ResultSet Rs;
            PreparedStatement Pst = Con.prepareStatement("select DATE_FORMAT(date,'%H') Hour , count(*) nb from commande where date >=\"" + debDate + "\" and date<=\"" + finDate + "\" group by hour(date);");
            Rs = Pst.executeQuery();
            return Rs;
        } catch (SQLException ex) {
            System.err.println("Erreur dans la requête commandesShowAll " + ex.getMessage());
        }
        return null;
    }
    public Connection getConnexion() {
        return Con;
    }

}
