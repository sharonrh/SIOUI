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
import object.Permohonan;

/**
 *
 * @author Johanes
 */
public class PermohonanModel extends Model {

    final String TABLE_NAME = "permohonan";

    /**
     * untuk select organisasi dengan nama_pendek tertentu
     *
     * @param nama_pendek
     * @return
     */
    /**
     * Untuk ambil organisasi dengan jenis tertentu (UKF,UKM,event)
     *
     * @param id_organisasi
     * @param jenis
     * @return
     */
    public ArrayList<Permohonan> selectAll() {
        super.openConnection();
        String query = String.format("SELECT * FROM %s", TABLE_NAME);
        ArrayList<Permohonan> result = new ArrayList<Permohonan>();
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            // selama masih ada baris yang bisa dibaca
            while (res.next()) {
                Permohonan a = new Permohonan(res.getInt("id"), res.getString("username"), res.getString("password"), res.getString("nama_panjang"), res.getString("deskripsi"));
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

    public void deletePermohonan(int id) {
        String query = "DELETE FROM " + TABLE_NAME
                + " WHERE id= '" + id + "'";
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
