/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.Lowongan;
import object.Organisasi;

/**
 *
 * @author Johanes
 */
public class LowonganModel extends Model {

    final String TABLE_NAME = "lowongan";

    public ArrayList<Lowongan> selectAll(String username) {
        super.openConnection();
        String query = String.format("Select * FROM %s WHERE username ='%s'",TABLE_NAME,username);
        System.out.println(query);
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

    public Lowongan select(int id) {
        super.openConnection();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE id='" + id +"'";
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
    
    public void update(Lowongan lw){
        String query = String.format("UPDATE %s SET kapasitas='%s', tanggal_buka='%s', tanggal_tutup='%s', "
                + "judul='%s', jabatan='%s', minimum_tahun='%s', "
                + "minimum_ipk='%s',kategori='%s', deskripsi='%s' WHERE id=%s", this.TABLE_NAME, lw.getKapasitas(), lw.getTanggal_buka(), 
                lw.getTanggal_tutup(), lw.getJudul(), lw.getJabatan(), 
                lw.getMinimum_tahun(), lw.getMinimum_ipk(), lw.getKategori(), lw.getDeskripsi(), lw.getId());
        super.openConnection();
        try {
            super.getStatement().executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }
}
