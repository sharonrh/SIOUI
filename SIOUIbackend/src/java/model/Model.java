/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Johanes
 */
public class Model {
    public static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/sioui_joef";
    public static final String DATABASE_USERNAME = "root";
    public static final String DATABASE_PASSWORD = "";

    private Connection con = null;
    private Statement state = null;
    
    public static void main(String[] args){
        Model pm = new Model();
        if(pm.openConnection()!=null){
            System.out.println("berhasil connect!");
        }
    }
    
    protected Statement openConnection() {
        try {
            Class.forName(DATABASE_DRIVER);
            con = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            state = con.createStatement();
            return state;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    protected void closeConnection() {
        if (state != null) {
            try {
                state.close();
            } catch (SQLException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Connection getConnection() {
        return con;
    }

    public Statement getStatement() {
        return state;
    }
}
