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
import object.Notifikasi;
import object.Pelamar;

/**
 *
 * @author Johanes
 */
public class NotifikasiModel extends Model{
    private String TABLE_NAME = "notifikasi";
    /**
     * Mengambil list Pelamar berdasarkan lowongan tertentu
     * @return 
     */
    public ArrayList<Notifikasi> selectAllNotifByUsername(String username){
        super.openConnection();
        String query = String.format("SELECT * FROM %s where username ='%s'  ", TABLE_NAME, username);
        ArrayList<Notifikasi> result = new ArrayList<Notifikasi>();
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            // selama masih ada baris yang bisa dibaca
            while (res.next()) {
                Notifikasi a = new Notifikasi(
                        res.getString("id"),
                        res.getString("username"),
                        res.getString("id_pelamar"),
                        res.getString("jenis"),
                        res.getBoolean("seen"),
                        res.getString("created_at"),
                        res.getString("seen_at")
                );
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
}
