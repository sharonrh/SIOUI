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
import object.Lowongan;
import object.User;

/**
 *
 * @author Johanes
 */
public class LowonganModel extends Model {

    final String TABLE_NAME = "lowongan";

    public ArrayList<Lowongan> selectAll() {
        super.openConnection();
        String query = "SELECT * FROM " + TABLE_NAME;
        ArrayList<Lowongan> result = new ArrayList<Lowongan>();
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            // selama masih ada baris yang bisa dibaca
            while (res.next()) {
                Lowongan lw = new Lowongan(res.getString("id_user"), res.getInt("id_organisasi"), 
                        res.getInt("id_lowongan"), res.getInt("kapasitas"),
                        res.getString("tanggal_buka"), res.getString("tanggal_tutup"),
                        res.getString("judul"), res.getString("jabatan"), 
                        res.getInt("minimum_tahun"), Double.parseDouble(res.getString("minimum_ipk")),
                        res.getString("kategori"),res.getString("deskripsi"));
                result.add(lw);
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return null;
    }

    public Lowongan select(String id_user, int id_organisasi, int id_lowongan) {
        super.openConnection();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE id_user='" + id_user +"' AND id_organisasi="+ id_organisasi +" AND id_lowongan="+ id_lowongan;
        Lowongan a = null;
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            res.next();
             Lowongan lw = new Lowongan(res.getString("id_user"), res.getInt("id_organisasi"), 
                        res.getInt("id_lowongan"), res.getInt("kapasitas"),
                        res.getString("tanggal_buka"), res.getString("tanggal_tutup"),
                        res.getString("judul"), res.getString("jabatan"), 
                        res.getInt("minimum_tahun"), Double.parseDouble(res.getString("minimum_ipk")),
                        res.getString("kategori"),res.getString("deskripsi"));
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return a;
    }
    
    public ArrayList<Lowongan> getLowonganBaru(int jumlah) {
        String query = "SELECT * FROM " + TABLE_NAME;
        openConnection();
        ArrayList<Lowongan> lowonganList = new ArrayList<Lowongan>();

        try {
            ResultSet res = super.getStatement().executeQuery(query);

            // selama masih ada baris yang bisa dibaca
            while (res.next()) {
                 Lowongan lw = new Lowongan(res.getString("id_user"), res.getInt("id_organisasi"), 
                        res.getInt("id_lowongan"), res.getInt("kapasitas"),
                        res.getString("tanggal_buka"), res.getString("tanggal_tutup"),
                        res.getString("judul"), res.getString("jabatan"), 
                        res.getInt("minimum_tahun"), Double.parseDouble(res.getString("minimum_ipk")),
                        res.getString("kategori"),res.getString("deskripsi"));
                lowonganList.add(lw);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }

        return lowonganList;
    }

    public ArrayList<Lowongan> getLowonganRekomendasi(String kategori) {
        ArrayList<Lowongan> lowonganList = new ArrayList<Lowongan>();
        String[] arr = kategori.split(",");
        String query = "SELECT DISTINCT * FROM " + TABLE_NAME + " WHERE kategori LIKE '%" + arr[0] + "%'";
        for(int ii=1;ii<arr.length;ii++){
            query = query + " OR kategori LIKE '%" + arr[ii] + "%'";
        }
        openConnection();
            try {
                ResultSet res = super.getStatement().executeQuery(query);

                // selama masih ada baris yang bisa dibaca
                while (res.next()) {
                     Lowongan lw = new Lowongan(res.getString("id_user"), res.getInt("id_organisasi"), 
                        res.getInt("id_lowongan"), res.getInt("kapasitas"),
                        res.getString("tanggal_buka"), res.getString("tanggal_tutup"),
                        res.getString("judul"), res.getString("jabatan"), 
                        res.getInt("minimum_tahun"), Double.parseDouble(res.getString("minimum_ipk")),
                        res.getString("kategori"),res.getString("deskripsi"));
                    lowonganList.add(lw);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                closeConnection();
            }
        return lowonganList;
    }
}
