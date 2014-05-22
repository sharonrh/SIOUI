/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.User;

public class UserModel extends Model {

    final String TABLE_NAME = "user";

    public void changePass(User user) {
        String query = String.format("UPDATE %s SET password='%s' WHERE username=%s", this.TABLE_NAME, user, user.getUsername());
        super.openConnection();
        try {
            super.getStatement().executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
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
    
    public void addUser(String username, String password) {
        super.openConnection();
        String query = String.format("INSERT INTO %s(username, nama_panjang) VALUES ('%s','%s')", TABLE_NAME, username, password);
        openConnection();
        try {
            super.getStatement().executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }
}
