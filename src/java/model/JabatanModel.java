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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.*;
/**
 *
 * @author Johanes
 */
public class JabatanModel extends Model{
    final String TABLE_NAME = "jabatan";

    /**
     * untuk select organisasi dengan nama_pendek tertentu
     *
     * @param nama_pendek
     * @return
     */
    public Jabatan select(String id) {
        super.openConnection();
        String query = String.format("SELECT * FROM %s WHERE id ='%s'", TABLE_NAME, id);
        Jabatan a = null;
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            res.next();
            a = new Jabatan(res.getString("id"),
                    res.getString("id_organisasi"),
                    res.getString("nama"),
                    res.getString("jabatan"),
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
    
    public List<Jabatan> selectByIdOrganisasi(String idOrg){
        super.openConnection();
        String query = String.format("SELECT * FROM %s WHERE id_organisasi=%s", TABLE_NAME, idOrg);
        ArrayList<Jabatan> result = new ArrayList<Jabatan>();
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            // selama masih ada baris yang bisa dibaca
            while (res.next()) {
                Jabatan a = new Jabatan(res.getString("id"),
                    res.getString("id_organisasi"),
                    res.getString("nama"),
                    res.getString("jabatan"),
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
    
    public void delete(String id){
        String query="DELETE FROM "+TABLE_NAME+" WHERE id="+id;
        super.openConnection();
        try {
            super.getStatement().executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }
    
    public void insert(Jabatan jab){
        super.openConnection();
        String query;
        query = String.format("INSERT INTO %s (id_organisasi, nama, jabatan) VALUES (%s, '%s', '%s')", 
                TABLE_NAME, jab.getId_organisasi(), jab.getNama(), jab.getJabatan());
        
        try {
            super.getStatement().executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }
    
    public void update(Jabatan jab){
        String query = String.format("UPDATE %s SET "
                + "id_organisasi=%s, "
                + "nama='%s', "
                + "jabatan='%s' "
                + "WHERE id=%s", 
                this.TABLE_NAME,
                jab.getId_organisasi(),
                jab.getNama(),
                jab.getJabatan(),
                jab.getId());
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
