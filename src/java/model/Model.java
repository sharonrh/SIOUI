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
    //UNTUK KONEKSI LOKAL
//    public static final String DATABASE_URL = "jdbc:mysql://localhost/sioui_db";
//    public static final String DATABASE_USERNAME = "root";
//    public static final String DATABASE_PASSWORD = "123qwe";
    
    //UNTUK DATABASE BENERAN
    public static final String DATABASE_URL = "jdbc:mysql://sioui.cloudapp.net:3307/sioui_db";
    public static final String DATABASE_USERNAME = "client";
    public static final String DATABASE_PASSWORD = "sioui123";

    private Connection con = null;
    private Statement state = null;
    
    public static void main(String[] arhs){
        Model m = new Model();
        Statement s = m.openConnection();
        if(m!=null){
            System.out.println("berhasil connect");
        }else{
            System.out.println("gagal");
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
