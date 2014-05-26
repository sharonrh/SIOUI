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
                Permohonan a = new Permohonan(res.getInt("id"), res.getString("username_pendaftar"), res.getString("username"), res.getString("password"), res.getString("nama_panjang"), res.getString("deskripsi"),res.getString("created_at"), res.getString("updated_at"));
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

    public int deletePermohonan(int id, boolean accepted) {
        String query;
        int n=0;
        
        openConnection();
        // case accept permohonan, masukin ke tabel organisasi & user dulu sebelum hapus
        if (accepted) {
            query = "SELECT * FROM " + TABLE_NAME
                    + " WHERE id= '" + id + "'";
            try {
                ResultSet res = super.getStatement().executeQuery(query);
                res.next();
                Permohonan a = new Permohonan(res.getInt("id"), res.getString("username"), res.getString("password"), res.getString("nama_panjang"), res.getString("deskripsi"));

                query = String.format("INSERT INTO organisasi (username, nama_panjang, deskripsi) VALUES ('%s','%s','%s')", a.getUsername(), a.getNama_panjang(), a.getDeskripsi());
                n = super.getStatement().executeUpdate(query);

                query = String.format("INSERT INTO user (username, password) VALUES ('%s','%s')", a.getUsername(), a.getPassword());
                super.getStatement().executeUpdate(query);

            } catch (SQLException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        query = "DELETE FROM " + TABLE_NAME + " WHERE id= '" + id + "'";
        try {
            super.getStatement().executeUpdate(query);

        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return n;
    }
    
    public void addPermohonan(String username_pendaftar, String username, String password, String nama_panjang, String deskripsi) {
        super.openConnection();
        String query = String.format("INSERT INTO %s(username_pendaftar, username, password, nama_panjang, deskripsi) VALUES ('%s','%s','%s','%s','%s')", TABLE_NAME, username_pendaftar, username, password, nama_panjang, deskripsi);
        System.out.println(query);
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
