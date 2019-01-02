/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;

/**
 *
 * @author Ilyas El Bani
 */
public class DaoBD {

    private String Pilote;
    private String Url;
    private String Login;
    private String Password;
    private Connection Connexion;

    public void SeConnecter() {
        try {
            Class.forName(Pilote);
            Connexion = DriverManager.getConnection(Url, Login, Password);
        } catch (ClassNotFoundException ex) {
            System.err.println("Pb de pilote!!");
        } catch (SQLException ex) {
            System.err.println("Pb de connexion !!");
        }
    }
    
    public String getPilote() {
        return Pilote;
    }

    public void setPilote(String Pilote) {
        this.Pilote = Pilote;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Connection getConnexion() {
        return Connexion;
    }

    public void setConnexion(Connection Connexion) {
        this.Connexion = Connexion;
    }
}
