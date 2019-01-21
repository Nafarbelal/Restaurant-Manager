/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import DAO.DaoBD;
import DB_Objects.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ilyas El Bani
 */
public class DB_Manager {
      private Connection Con;
    private Statement St;
    private DaoBD dao;
    

       
    public DB_Manager() {
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
}
