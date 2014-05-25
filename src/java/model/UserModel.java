/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.User;
import ws.UserCV;

/**
 *
 * @author Johanes
 */
public class UserModel extends Model {

    private final String TABLE_NAME = "user";

    
    public boolean doLogin(String username, String password){
        return tryLogin(username, password);
    }
    
    public List<UserCV> getMultipleCVByUsername(String username){
        return getAllCV(username);
    }
    
    /**
     * Untuk ambil user dengan id tertentu
     *
     * @param username
     * @return
     */
    public User select(String username) {
        super.openConnection();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE username='" + username + "'";
        User a = null;
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            while (res.next()) {
                a = new User(res.getString("username"), res.getString("password"));
            }
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return a;
    }

    /**
     * menambahkan user baru
     *
     * @param username
     * @param password
     */
    public void insertUser(String username, String password) {
        super.openConnection();
        String query = String.format("INSERT INTO %s(username, password) VALUES ('%s', '%s')", TABLE_NAME, username, password);
        openConnection();
        try {
            super.getStatement().executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }

    /**
     * untuk edit user password
     *
     * @param username
     * @param password
     */
    public void editUser(String username, String password) {
        super.openConnection();
        String query = "UPDATE " + TABLE_NAME + " SET password='" + password + "' WHERE username='" + username + "'";
        openConnection();
        try {
            super.getStatement().executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }

    public boolean validateUser(String username, String password) {
        User res = this.select(username);
        if (res != null) {
            if (password.equals(res.getPassword())) {
                return true;
            }
        }
        return false;
    }

    private static boolean tryLogin(java.lang.String username, java.lang.String password) {
        ws.SivimuWebService_Service service = new ws.SivimuWebService_Service();
        ws.SivimuWebService port = service.getSivimuWebServicePort();
        return port.tryLogin(username, password);
    }

    private static UserCV getCV(java.lang.String cvId) {
        ws.SivimuWebService_Service service = new ws.SivimuWebService_Service();
        ws.SivimuWebService port = service.getSivimuWebServicePort();
        return port.getCV(cvId);
    }

    private static java.util.List<ws.UserCV> getAllCV(java.lang.String username) {
        ws.SivimuWebService_Service service = new ws.SivimuWebService_Service();
        ws.SivimuWebService port = service.getSivimuWebServicePort();
        return port.getAllCV(username);
    }
}
