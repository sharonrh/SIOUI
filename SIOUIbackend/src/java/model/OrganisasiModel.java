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
import object.Organisasi;

/**
 *
 * @author Johanes
 */
public class OrganisasiModel extends Model {

    final String TABLE_NAME = "organisasi";

    /**
     * untuk select organisasi dengan nama_pendek tertentu
     *
     * @param nama_pendek
     * @return
     */
    public Organisasi select(int id) {
        super.openConnection();
        String query = String.format("SELECT * FROM %s WHERE id ='%s'", TABLE_NAME, id);
        Organisasi a = null;
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            res.next();
            a = new Organisasi(res.getInt("id"), res.getString("id_user"),
                    res.getString("nama_panjang"), res.getString("nama_pendek"),
                    res.getString("logo"), res.getString("deskripsi"),
                    res.getString("visi"),
                    res.getString("jenis"),
                    res.getString("alamat"),
                    res.getString("created_at"),
                    res.getString("updated_at"));
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return a;
    }

    public Organisasi selectFromId(String username) {
        super.openConnection();
        String query = String.format("SELECT * FROM %s WHERE username='%s'", TABLE_NAME, username);
        System.out.println(query);
        Organisasi a = null;
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            res.next();
            a = new Organisasi(res.getInt("id"), res.getString("username"),
                    res.getString("nama_panjang"), res.getString("nama_pendek"),
                    res.getString("logo"), res.getString("deskripsi"),
                    res.getString("visi"),
                    res.getString("jenis"),
                    res.getString("alamat"),
                    res.getString("created_at"),
                    res.getString("updated_at"));
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return a;
    }

    public int size() {
        super.openConnection();
        String query = "SELECT COUNT(*) FROM " + TABLE_NAME;
        int a = 0;
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            res.next();
            a = res.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return a;
    }

    /**
     * Untuk ambil organisasi dengan jenis tertentu (UKF,UKM,event)
     *
     * @param id_organisasi
     * @param jenis
     * @return
     */
    public ArrayList<Organisasi> selectByJenis(String jenis) {
        super.openConnection();
        String query = String.format("SELECT * FROM %s WHERE jenis='%s'", TABLE_NAME, jenis);
        ArrayList<Organisasi> result = new ArrayList<Organisasi>();
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            // selama masih ada baris yang bisa dibaca
            while (res.next()) {
                Organisasi a = new Organisasi(res.getInt("id"), res.getString("username"),
                        res.getString("nama_panjang"), res.getString("nama_pendek"),
                        res.getString("logo"), res.getString("deskripsi"),
                        res.getString("visi"),
                        res.getString("jenis"),
                        res.getString("alamat"),
                        res.getString("created_at"),
                        res.getString("updated_at"));
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
     * Untuk ambil organisasi dengan jenis tertentu (UKF,UKM,event)
     *
     * @param id_organisasi
     * @param jenis
     * @return
     */
    public ArrayList<Organisasi> selectAll() {
        super.openConnection();
        String query = String.format("SELECT * FROM %s", TABLE_NAME);
        ArrayList<Organisasi> result = new ArrayList<Organisasi>();
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            // selama masih ada baris yang bisa dibaca
            while (res.next()) {
                Organisasi a = new Organisasi(res.getInt("id"), res.getString("username"),
                        res.getString("nama_panjang"), res.getString("nama_pendek"),
                        res.getString("logo"), res.getString("deskripsi"),
                        res.getString("visi"),
                        res.getString("jenis"),
                        res.getString("alamat"),
                        res.getString("created_at"),
                        res.getString("updated_at"));
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

    public void insertOrganizationModel(String username, String nama_panjang,
            String nama_pendek) {
        super.openConnection();
        String query = String.format("INSERT INTO %s(username, nama_panjang, nama_pendek) VALUES ('%s','%s','%s')", TABLE_NAME, username, nama_panjang, nama_pendek);
        openConnection();
        try {
            super.getStatement().executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }

    public void update(Organisasi org) {
        String query = String.format("UPDATE %s SET nama_panjang='%s', nama_pendek='%s', deskripsi='%s', "
                + "visi='%s', jenis='%s', alamat='%s', "
                + "logo='%s' WHERE id=%s", this.TABLE_NAME,
                org.getNama_panjang(), org.getNama_pendek(),
                org.getDeskripsi(), org.getVisi(), org.getJenis(),
                org.getAlamat(), org.getLogo(), org.getId());
        super.openConnection();
        try {
            super.getStatement().executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }

    /**
     * Untuk edit organisasi dipakai di form
     *
     * @param id_user
     * @param id_organisasi
     * @param nama_panjang
     * @param nama_pendek
     * @param deskripsi
     * @param visi
     * @param jenis
     * @param alamat
     */
    public void editOrganizationProfile(String username, String nama_panjang,
            String nama_pendek, String deskripsi, String visi, String jenis, String alamat) {
        String query = "UPDATE " + TABLE_NAME
                + " SET nama_panjang='" + nama_panjang + "',"
                + " nama_pendek='" + nama_pendek + "',"
                + " deskripsi='" + deskripsi + "',"
                + " visi='" + visi + "',"
                + " jenis='" + jenis + "',"
                + " alamat='" + alamat + "'"
                + " WHERE username= '" + username + "'";
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

    /**
     * Untuk ubah ato masukkin logo organisasi
     *
     * @param id_user
     * @param id_organisasi
     * @param logo
     */
    public void editOrganizationLogo(String username, String logo) {
        String query = "UPDATE " + TABLE_NAME
                + " SET logo='" + logo + "',"
                + " WHERE username= '" + username + "'";
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
