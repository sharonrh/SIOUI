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
import object.Organization;
import object.Pelamar;

/**
 *
 * @author daniel.januar
 */
public class PelamarModel extends Model{
    private String TABLE_NAME = "Pelamar";
    /**
     * Mengambil list Pelamar berdasarkan lowongan tertentu
     * @return 
     */
    public ArrayList<Pelamar> selectPelamar(String id_user, int id_organisasi, int id_lowongan){
        super.openConnection();
        String query = "SELECT * FROM " + TABLE_NAME 
                + " WHERE id_user='" + id_user + "'"
                + " AND id_organisasi='" + id_organisasi + "'"
                + " AND id_lowongan='" + id_lowongan + "'";
        ArrayList<Pelamar> result = new ArrayList<Pelamar>();
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            // selama masih ada baris yang bisa dibaca
            while (res.next()) {
              Pelamar a = new Pelamar(res.getString("id_user"), res.getInt("id_organisasi"), res.getInt("id_lowongan"),res.getString("username"), res.getString("tgl_lamar"));
              result.add(a);
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return null;
    }
    
    /**
     * 
     */
    public void insertUser(String id_user, int id_organisasi, int id_pelamar, String username, String tgl_lamar){
        super.openConnection();
        String query = "INSERT INTO "+ TABLE_NAME+" VALUES('"+id_user+"',"+id_organisasi+","+id_pelamar+",'"+username+"','"+tgl_lamar+"')";
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
     * 
     */
    public void deletePelamar(String id_user, int id_organisasi, int id_lowongan, String username){
        String query = "DELETE FROM "+ TABLE_NAME
                + " WHERE id_user= '" + id_user + "' AND"
                + " id_organisasi= " + id_organisasi +"' AND"
                + " id_lowongan= " + id_lowongan +"' AND"
                + " username ='"+username+"'";
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
