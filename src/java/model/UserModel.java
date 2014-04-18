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
public class UserModel extends Model{
    final String TABLE_NAME = "user";
    
    public User select(String id_user){
        super.openConnection();
        String query = "SELECT * FROM "+ TABLE_NAME+" WHERE id_user='"+id_user+"'";
        User a = null;
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            res.next();
            a = new User(res.getString("id_user"), res.getString("password"));
            return a;            
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return a;
    }
    
    public boolean validateUser(String id_user, String password){
        User res = this.select(id_user);
        if(res!=null){
            if(password.equals(res.getPassword())){
                return true;
            }
        }
        return false;
    }
}
