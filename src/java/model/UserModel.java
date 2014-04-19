/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.User;

/**
 *
 * @author Johanes
 */
public class UserModel extends Model {

    private final String TABLE_NAME = "user";

    public static void main(String[] ar) {
        UserModel u = new UserModel();
        User n = u.select("daniel24jan");
        System.out.println(n.getUsername());
        System.out.println(n.getPassword());
    }

    /**
     * Untuk ambil user dengan id tertentu
     *
     * @param id_user
     * @return
     */
    public User select(String id_user) {
        super.openConnection();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE id_user='" + id_user + "'";
        User a = null;
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            while (res.next()) {
                a = new User(res.getString("id_user"), res.getString("password"));
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
     * @param id_user
     * @param password
     */
    public void insertUser(String id_user, String password) {
        super.openConnection();
        String query = "INSERT INTO " + TABLE_NAME + " VALUES('" + id_user + "','" + password + "')";
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
     * @param id_user
     * @param password
     */
    public void editUser(String id_user, String password) {
        super.openConnection();
        String query = "UPDATE " + TABLE_NAME + " SET password='" + password + "' WHERE id_user='" + id_user + "'";
        openConnection();
        try {
            super.getStatement().executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }

    public boolean validateUser(String id_user, String password) {
        User res = this.select(id_user);
        if (res != null) {
            if (password.equals(res.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
