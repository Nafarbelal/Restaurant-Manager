/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import DAO.DaoBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ilyas El Bani
 */
public class DB_Article {

    private Connection Con;
    private Statement St;
    private DaoBD dao;

    public DB_Article   () {
        dao = new DaoBD();
        dao.setPilote("com.mysql.jdbc.Driver");
        dao.setUrl("jdbc:mysql://localhost:3306/projetjava");
        dao.setLogin("root");
        dao.setPassword("");
        dao.SeConnecter();
        Con = dao.getConnexion();
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
