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
import object.Organization;
import object.User;

/**
 *
 * @author Johanes
 */
public class OrganizationModel extends Model {

    final String TABLE_NAME = "organizations";

    /**
     * untuk select organisasi dengan nama_pendek tertentu
     * @param nama_pendek
     * @return 
     */
    public Organization select(String nama_pendek) {
        super.openConnection();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE nama_pendek='" + nama_pendek + "'";
        Organization a = null;
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            res.next();
            a = new Organization(res.getString("id_organisasi"),res.getString("nama_panjang"),res.getString("nama_pendek"));
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return a;
    }
    
    /**
     * Untuk ambil organisasi dengan jenis tertentu (UKF,UKM,event)
     * @param id_organisasi
     * @param jenis
     * @return 
     */
    public ArrayList<Organization> selectByJenis(int id_organisasi, String jenis) {
        super.openConnection();
        String query = "SELECT * FROM " + TABLE_NAME 
                + " WHERE id_organisasi='" + id_organisasi + "'"
                + " AND jenis='" + jenis + "'";
        ArrayList<Organization> result = new ArrayList<Organization>();
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            // selama masih ada baris yang bisa dibaca
            while (res.next()) {
              Organization a = new Organization(res.getString("id_organisasi"),
                      res.getString("nama_panjang"),
                      res.getString("nama_pendek"));
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
     * Untuk search berdasarkan fakultas
     * @param id_organisasi
     * @param alamat
     * @return 
     */
    public ArrayList<Organization> selectByAlamat(int id_organisasi, String alamat) {
        super.openConnection();
        String query = "SELECT * FROM " + TABLE_NAME 
                + " WHERE id_organisasi='" + id_organisasi + "'"
                + " AND alamat='" + alamat + "'";
        ArrayList<Organization> result = new ArrayList<Organization>();
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            // selama masih ada baris yang bisa dibaca
            while (res.next()) {
              Organization a = new Organization(res.getString("id_organisasi"),
                      res.getString("nama_panjang"),
                      res.getString("nama_pendek"));
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
     * @param id_organisasi
     * @param nama
     * @return 
     */
    public ArrayList<Organization> selectByNama(int id_organisasi, String nama) {
        super.openConnection();
        String query = "SELECT * FROM " + TABLE_NAME 
                + " WHERE id_organisasi='" + id_organisasi + "'"
                + " AND jenis LIKE '%" + nama + "%'";
        ArrayList<Organization> result = new ArrayList<Organization>();
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            // selama masih ada baris yang bisa dibaca
            while (res.next()) {
              Organization a = new Organization(res.getString("id_organisasi"),
                      res.getString("nama_panjang"),
                      res.getString("nama_pendek"));
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
     * Untuk edit organisasi dipakai di form
     * @param id_user
     * @param id_organisasi
     * @param nama_panjang
     * @param nama_pendek
     * @param deskripsi
     * @param visi
     * @param jenis
     * @param alamat 
     */
    public void editOrganizationProfile(String id_user, int id_organisasi, String nama_panjang, 
            String nama_pendek, String deskripsi, String visi, String jenis, String alamat){
        String query = "UPDATE "+ TABLE_NAME +
                " SET nama_panjang='" + nama_panjang + "',"
                + " nama_pendek='" + nama_pendek + "',"
                + " deskripsi='" + deskripsi + "',"
                + " visi='" + deskripsi + "',"
                + " jenis='" + deskripsi + "',"
                + " alamat='" + alamat + "'"
                + " WHERE id_user= '" + id_user + "' AND"
                + " id_organisasi= " + id_organisasi;
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
     * @param id_user
     * @param id_organisasi
     * @param logo
     */
    public void editOrganizationLogo(String id_user, int id_organisasi, String logo){
        String query = "UPDATE "+ TABLE_NAME +
                " SET logo='" + logo + "',"
                + " WHERE id_user= '" + id_user + "' AND"
                + " id_organisasi= " + id_organisasi;
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
