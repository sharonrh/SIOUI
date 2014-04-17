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

    final String TABLE_NAME = "lowongans";

    public ArrayList<Lowongan> selectAll() {
        super.openConnection();
        String query = "SELECT * FROM " + TABLE_NAME;
        ArrayList<Lowongan> result = new ArrayList<Lowongan>();
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            // selama masih ada baris yang bisa dibaca
            while (res.next()) {
                Lowongan a = new Lowongan(Integer.parseInt(res.getString("id")), res.getString("judul"), res.getString("deskripsi"), res.getString("jabatan"), Integer.parseInt(res.getString("minimum_tahun")), res.getString("pendaftaran_dimulai"), res.getString("pendaftaran_selesai"), Double.parseDouble(res.getString("minimum_ipk")), res.getString("kategori"), Integer.parseInt(res.getString("jumlah_dibutuhkan")));
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

    public Lowongan select(int id) {
        super.openConnection();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE id=" + id;
        Lowongan a = null;
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            res.next();
            a = new Lowongan(Integer.parseInt(res.getString("id")), res.getString("judul"), res.getString("deskripsi"), res.getString("jabatan"), Integer.parseInt(res.getString("minimum_tahun")), res.getString("pendaftaran_dimulai"), res.getString("pendaftaran_selesai"), Double.parseDouble(res.getString("minimum_ipk")), res.getString("kategori"), Integer.parseInt(res.getString("jumlah_dibutuhkan")));
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return a;
    }

    public ArrayList<Lowongan> getLowonganBaru(int jumlah) {
        String query = "SELECT * FROM " + TABLE_NAME + " ORDER BY pendaftaran_dimulai DESC LIMIT " + jumlah;
        openConnection();
        ArrayList<Lowongan> lowonganList = new ArrayList<Lowongan>();

        try {
            ResultSet res = super.getStatement().executeQuery(query);

            // selama masih ada baris yang bisa dibaca
            while (res.next()) {
                Lowongan l = new Lowongan(Integer.parseInt(res.getString("id")), res.getString("judul"), res.getString("deskripsi"), res.getString("jabatan"), Integer.parseInt(res.getString("minimum_tahun")), res.getString("pendaftaran_dimulai"), res.getString("pendaftaran_selesai"), Double.parseDouble(res.getString("minimum_ipk")), res.getString("kategori"), Integer.parseInt(res.getString("jumlah_dibutuhkan")));
                lowonganList.add(l);
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

        for (int i = 0; i < arr.length; i++) {
            String query = "SELECT DISTINCT * FROM " + TABLE_NAME + " WHERE kategori LIKE '%" + arr[i] + "%";

            openConnection();

            try {
                ResultSet res = super.getStatement().executeQuery(query);

                // selama masih ada baris yang bisa dibaca
                while (res.next()) {
                    Lowongan l = new Lowongan(Integer.parseInt(res.getString("id")), res.getString("judul"), res.getString("deskripsi"), res.getString("jabatan"), Integer.parseInt(res.getString("minimum_tahun")), res.getString("pendaftaran_dimulai"), res.getString("pendaftaran_selesai"), Double.parseDouble(res.getString("minimum_ipk")), res.getString("kategori"), Integer.parseInt(res.getString("jumlah_dibutuhkan")));
                    lowonganList.add(l);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                closeConnection();
            }
        }
        return lowonganList;
    }
}
