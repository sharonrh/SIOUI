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
import object.Organisasi;
import object.Pelamar;

/**
 *
 * @author daniel.januar
 */
public class PelamarModel extends Model{
    private String TABLE_NAME = "Pelamar";
    /**
     * Mengambil list Pelamar berdasarkan lowongan tertentu
     * @return 
     */
    public ArrayList<Pelamar> selectAllPelamar(int id_lowongan){
        super.openConnection();
        String query = String.format("SELECT * FROM %s where id_lowongan ='%s' ", TABLE_NAME, id_lowongan);
        ArrayList<Pelamar> result = new ArrayList<Pelamar>();
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            // selama masih ada baris yang bisa dibaca
            while (res.next()) {
              Pelamar a = new Pelamar(res.getInt("id"), res.getInt("id_lowongan"),res.getString("username"), res.getString("jenis"), res.getString("status"), res.getString("created_at"),res.getString("updated_at"));
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
     */
    public void insertUser(int id_lowongan, String username){
        super.openConnection();
        String query = String.format("INSERT INTO %s(id_lowongan, username) VALUES ('%s', '%s')", TABLE_NAME, id_lowongan, username);
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
     * 
     */
    public void deletePelamar(int id_lowongan, String username){
        String query = String.format("DELETE FROM %s WHERE id_lowongan='%s' AND username='%s'",TABLE_NAME, id_lowongan, username);
        openConnection();
        try {
            super.getStatement().executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }
    
    public ArrayList<Pelamar> selectPelamarJenisStatus(int id_lowongan, String jenis, String status){
        super.openConnection();
        String query = String.format("SELECT * FROM %s where id_lowongan ='%s' AND jenis='%s' AND status='%s' ", TABLE_NAME, id_lowongan,jenis,status);
        ArrayList<Pelamar> result = new ArrayList<Pelamar>();
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            // selama masih ada baris yang bisa dibaca
            while (res.next()) {
              Pelamar a = new Pelamar(res.getInt("id"), res.getInt("id_lowongan"),res.getString("username"), res.getString("jenis"), res.getString("status"), res.getString("created_at"),res.getString("updated_at"));
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
    
    public Pelamar select(String id){
        super.openConnection();
        String query = String.format("SELECT * FROM %s where id=%s", TABLE_NAME, id);
        ArrayList<Pelamar> result = new ArrayList<Pelamar>();
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            // selama masih ada baris yang bisa dibaca
            Pelamar a = new Pelamar(res.getInt("id"), res.getInt("id_lowongan"),res.getString("username"), res.getString("jenis"), res.getString("status"), res.getString("created_at"),res.getString("updated_at"));
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return null;
    }
}
