/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class NotifikasiModel extends Model {

    private String TABLE_NAME = "notifikasi";

    public void updateSeen(int idPelamar) {
        String query = String.format("UPDATE %s SET seen='%s' WHERE id=%s", this.TABLE_NAME,
                0, idPelamar);
        super.openConnection();
        try {
            super.getStatement().executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }

    public void addNotif(int id_pelamar, String username, String jenis) {
        super.openConnection();
        String query = String.format("INSERT INTO %s (id_pelamar, username, jenis, seen) VALUES ('%s','%s','%s','%s')", TABLE_NAME, id_pelamar, username, jenis, 0);
        try {
            super.getStatement().executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }

}
