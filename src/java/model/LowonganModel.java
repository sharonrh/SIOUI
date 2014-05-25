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
                Lowongan lw = new Lowongan(res.getInt("id"), res.getString("username"),
                        res.getInt("kapasitas"),
                        res.getString("tanggal_buka"), res.getString("tanggal_tutup"),
                        res.getString("judul"), res.getString("jabatan"),
                        res.getInt("minimum_tahun"), Double.parseDouble(res.getString("minimum_ipk")),
                        res.getString("kategori"), res.getString("deskripsi"),
                        res.getString("created_at"),res.getString("updated_at"));
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
    
    public ArrayList<Lowongan> selectMultipleByUsername(String idOrg) {
        super.openConnection();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE username='" + idOrg + "'";
        ArrayList<Lowongan> result = new ArrayList<Lowongan>();
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            // selama masih ada baris yang bisa dibaca
            while (res.next()) {
                Lowongan lw = new Lowongan(res.getInt("id"), res.getString("username"),
                        res.getInt("kapasitas"),
                        res.getString("tanggal_buka"), res.getString("tanggal_tutup"),
                        res.getString("judul"), res.getString("jabatan"),
                        res.getInt("minimum_tahun"), Double.parseDouble(res.getString("minimum_ipk")),
                        res.getString("kategori"), res.getString("deskripsi"),
                        res.getString("created_at"),res.getString("updated_at"));
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

    public Lowongan select(String id) {
        super.openConnection();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE id=" + id;
        Lowongan a = null;
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            res.next();
            a = new Lowongan(res.getInt("id"), res.getString("username"),
                        res.getInt("kapasitas"),
                        res.getString("tanggal_buka"), res.getString("tanggal_tutup"),
                        res.getString("judul"), res.getString("jabatan"),
                        res.getInt("minimum_tahun"), Double.parseDouble(res.getString("minimum_ipk")),
                        res.getString("kategori"), res.getString("deskripsi"),
                        res.getString("created_at"),res.getString("updated_at"));
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return a;
    }

    public ArrayList<Lowongan> getLowonganBaru(int jumlah) {
        String query = String.format("SELECT * FROM %s ORDER BY created_at DESC LIMIT 5",TABLE_NAME);
        openConnection();
        ArrayList<Lowongan> lowonganList = new ArrayList<Lowongan>();
        try {
            ResultSet res = super.getStatement().executeQuery(query);

            // selama masih ada baris yang bisa dibaca
            while (res.next()) {
                Lowongan lw = new Lowongan(res.getInt("id"), res.getString("username"),
                        res.getInt("kapasitas"),
                        res.getString("tanggal_buka"), res.getString("tanggal_tutup"),
                        res.getString("judul"), res.getString("jabatan"),
                        res.getInt("minimum_tahun"), Double.parseDouble(res.getString("minimum_ipk")),
                        res.getString("kategori"), res.getString("deskripsi"),
                        res.getString("created_at"),res.getString("updated_at"));
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
        for (int ii = 1; ii < arr.length; ii++) {
            query = query + " OR kategori LIKE '%" + arr[ii] + "%'";
        }
        openConnection();
        try {
            ResultSet res = super.getStatement().executeQuery(query);

            // selama masih ada baris yang bisa dibaca
            while (res.next()) {
                Lowongan lw = new Lowongan(res.getInt("id"), res.getString("username"),
                        res.getInt("kapasitas"),
                        res.getString("tanggal_buka"), res.getString("tanggal_tutup"),
                        res.getString("judul"), res.getString("jabatan"),
                        res.getInt("minimum_tahun"), Double.parseDouble(res.getString("minimum_ipk")),
                        res.getString("kategori"), res.getString("deskripsi"),
                        res.getString("created_at"),res.getString("updated_at"));
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
