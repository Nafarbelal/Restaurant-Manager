/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

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
    
    
    public Commande()
    {
        dao = new DaoBD();
        dao.setPilote("com.mysql.jdbc.Driver");
        dao.setUrl("jdbc:mysql://localhost:3306/projetjava");
        dao.setLogin("root");
        dao.setPassword("");
        dao.SeConnecter();
        Con = dao.getConnexion();
    }
   
    public int CreerCommande()
    {
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         Date date = new Date();
         System.out.println(dateFormat.format(date));
        try {  
            PreparedStatement Pst = Con.prepareStatement("insert into Commande(date) values (?)", Statement.RETURN_GENERATED_KEYS);
        
            Pst.setString(1,dateFormat.format(date));
            Pst.executeUpdate();
            ResultSet Rs = Pst.getGeneratedKeys();
            if(Rs.next()){
                int id = Rs.getInt(1);
                return id ;
            }
        } catch (SQLException ex) {
             System.err.println("Erreur dans la requete CreerCommande" +ex.getMessage());
        }
        return -1;
    }
    public void AjouterArticle()
    {
      // PreparedStatement Pst = Con.prepareStatement("insert into Commande() values ()");
     // Pst.setString(1, x);
    }
    public void AnnulerCommande()
    {
        try
        {
            PreparedStatement Pst = Con.prepareStatement("delete from detail_commande where IDCOMMANDE=?");
            
        }
        catch(SQLException ex)
        {
            System.err.println("Erreur dans la requete Supprimer" +ex.getMessage());
        }
    }        
    public void SupprimerCommande(int ID)
    {
        
    }
    public void SupprimerArticleCommande(int ID_Commande, int ID_Article) 
    {
        try
        {
            PreparedStatement Pst = Con.prepareStatement("delete from detail_commande where IDCOMMANDE=? AND IDARTICLE=?");
            Pst.setInt(1,ID_Commande);
            Pst.setInt(2, ID_Article);
        }
        catch(SQLException ex)
        {
            System.err.println("Erreur dans la requete Supprimer" +ex.getMessage());
        }
       
    }
    public ResultSet MenuCategorie(String cat) {
        ResultSet Res = null;
        try {
            St = Con.createStatement();
            Res = St.executeQuery("Select IDARTICLE,Designation,Prix from article where categorie='"+cat+"'");
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
     public int getID(String cat) 
     {
        ResultSet Res;
        try {
            St = Con.createStatement();
            Res = St.executeQuery("Select IDARTICLE from Article where categorie='"+cat+"'");
            if (Res.next()) 
            {
                return Res.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete getID, " + ex.getMessage());
        }
        return 0;
    }
     
}
