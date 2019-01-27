/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import DAO.DaoBD;
import java.sql.Connection;
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

    public Connection getConnexion() {
        return Con;
    }
    
    

}
