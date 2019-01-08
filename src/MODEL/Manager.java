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
 * @author Pc
 */
public class Manager {
    private Connection Con;
    private Statement St;
    private DaoBD dao;
    
    
    public Manager()
    {
        dao = new DaoBD();
        dao.setPilote("com.mysql.jdbc.Driver");
        dao.setUrl("jdbc:mysql://localhost:3306/KikisBD");
        dao.setLogin("root");
        dao.setPassword("");
        dao.SeConnecter();
        Con = dao.getConnexion();
    }
    public ResultSet AllArticles()
   {
        try 
        {
            St = Con.createStatement();
            ResultSet rs=St.executeQuery("select * from article");
            return rs ;
        }
        catch( SQLException ex)
        {
            return null ;
        }
   }
    public void AddArticle(int Id , String Des , float Price , String Type) 
   {
       
        String Req = "insert into article values ('"+Id+"','"+Des+"','"+Price+"','"+Type+"')";
        try 
        {
             St = Con.createStatement();
             St.executeUpdate(Req);
             JOptionPane.showMessageDialog(null, "l'Article "+Des+" a bien été ajouté");
        }
        catch( SQLException ex)
        {
         JOptionPane.showMessageDialog(null, " Pb ds la requete d'ajout");
        }  
   }
    public void DeleteArticle(int Id ) 
   {   
        String Req = "delete from  article where IDARTICLE = "+Id+"";
        try 
        {
            int reponse =JOptionPane.showConfirmDialog(null, "Etes vous sur du suppression", "Suppression", JOptionPane.OK_CANCEL_OPTION);
            if(reponse==JOptionPane.YES_OPTION)
           {
            St = Con.createStatement();
            St.executeUpdate(Req); 
            JOptionPane.showMessageDialog(null, "Suppression EFFECTUEE " , "Suppression ",JOptionPane.OK_OPTION);
           }
        }
        catch( SQLException ex)
        {
         JOptionPane.showMessageDialog(null, " Pb ds la requete Suppression");
        }  
   }
    public void UPDATEArticle(int ID, String Des , float Price , String Type) throws SQLException
    {
     String Req ; 
     Req = "update article set DESIGNATION =?, PRIX =?, CATEGORIE =? where  IDARTICLE =?" ;
     
        try
        {
            PreparedStatement pst = Con.prepareStatement(Req);
            pst.setString(1, Des);
            pst.setFloat(2, Price);
            pst.setString(3, Type);
            pst.setInt(4, ID);
            int reponse =JOptionPane.showConfirmDialog(null, "Etes vous sur du changement", "Mise à jour", JOptionPane.OK_CANCEL_OPTION);
            if(reponse==JOptionPane.YES_OPTION)
           {
             pst.executeUpdate();  
             JOptionPane.showMessageDialog(null, "MAJ EFFECTUEE " , "Mise à jour ",JOptionPane.OK_OPTION);
           }
        }
        catch (SQLException ex) 
        {
             JOptionPane.showMessageDialog(null, " Pb ds la requete de Mise à jour");      
        }
    }
    public Vector<String> Types()
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
