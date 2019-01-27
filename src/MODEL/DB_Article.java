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
import java.util.Vector;
import javax.swing.JOptionPane;

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
            Res = St.executeQuery("Select IDARTICLE as ID ,Designation,Prix from article where categorie='" + cat + "'");
        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete select ou ST , " + ex.getMessage());
        }
        return Res;
    }

    public ResultSet MenuCategorieAll() {
        ResultSet Res = null;
        try {
            St = Con.createStatement();
            Res = St.executeQuery("Select IDARTICLE as ID,Designation,Prix from article");
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
    
    public ResultSet MenuAll() {
        ResultSet Res = null;
        try {
            St = Con.createStatement();
            Res = St.executeQuery("Select IDARTICLE as ID,Designation,Prix,Categorie,Archivé as Invisible from article");
        } catch (SQLException ex) {
            System.out.println("Erreur dans la requete select ou ST , " + ex.getMessage());
        }
        return Res;
    }
    
    public void AddArticle(String Des , float Price , String Categorie,int Archive) 
    {
       
        String Req = "insert into article(Designation,Prix,Categorie,Archivé) values ('"+Des+"','"+Price+"','"+Categorie+"',"+Archive+")";
        try 
        {
             St = Con.createStatement();
             St.executeUpdate(Req);
             JOptionPane.showMessageDialog(null, "l'Article "+Des+" a bien été ajouté");
        }
        catch( SQLException ex)
        {
         JOptionPane.showMessageDialog(null, " Problème dans la requête d'ajout");
        }  
    }
    public void UPDATEArticle(int ID, String Des , float Price , String Categorie,int Archive) throws SQLException
    {
     String Req ; 
     Req = "update article set DESIGNATION ='"+Des+"', PRIX ="+Price+", CATEGORIE ='"+Categorie+"', Archivé="+Archive+" where  IDARTICLE ="+ID ;
     
        try
        {
            PreparedStatement pst = Con.prepareStatement(Req);
            int reponse =JOptionPane.showConfirmDialog(null, "Etes vous sûr du changement", "Mise à jour", JOptionPane.OK_CANCEL_OPTION);
            if(reponse==JOptionPane.YES_OPTION)
           {
             pst.executeUpdate();  
             JOptionPane.showMessageDialog(null, "Mise à jour effectuée avec succès " , "Mise à jour ",JOptionPane.OK_OPTION);
           }
        }
        catch (SQLException ex) 
        {
             JOptionPane.showMessageDialog(null, " Problème dans la requête de Mise à jour");      
        }
    }
    
    public Vector<String> Categories()
    {
       Vector<String> Types = new Vector<String>();
        try 
        {
            St = Con.createStatement();
            ResultSet rs= St.executeQuery("select DISTINCT CATEGORIE from article");
            while(rs.next())
                  {
                   Types.add(rs.getString(1));
                  }
        }
        catch( SQLException ex)
        {
            return null ;
        }
       
       return Types ; 
    }
}
