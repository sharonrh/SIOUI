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
import object.Album;
import object.Image;
import object.Organisasi;

/**
 *
 * @author Johanes
 */
public class GalleryModel extends Model{
    final String ALBUM_TABLE_NAME = "album";
    final String IMAGE_TABLE_NAME = "foto";
    
    public static void main(String[] arhs){
        GalleryModel gm = new GalleryModel();
        Album a = new Album("12", "asd", "asd");
        gm.insertAlbum(a);
    }
    
    public void updateAlbum(Album a){
        String query = String.format("UPDATE %s SET "
                + "id_organisasi=%s, "
                + "nama='%s', "
                + "deskripsi='%s' "
                + "WHERE id=%s", 
                this.ALBUM_TABLE_NAME,
                a.getId_organisasi(),
                a.getName(),
                a.getDescription(),
                a.getId());
        super.openConnection();
        try {
            super.getStatement().executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            cascadeImageFromAlbum(a);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }
    
    public Album getSingleAlbum(int idAlbum){
        super.openConnection();
        String query;
        query = String.format("SELECT * FROM %s WHERE id=%s", ALBUM_TABLE_NAME, idAlbum);
        
        try{
            ResultSet res = super.getStatement().executeQuery(query);
            // selama masih ada baris yang bisa dibaca
            res.next();
            Album alb = new Album(res.getString("id"), 
                    res.getString("id_organisasi"),
                    res.getString("nama"),
                    res.getString("deskripsi"),
                    res.getString("created_at"),
                    res.getString("updated_at"));
            fetchIsiAlbum(alb);
            return alb;
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        
        return null;
    }
    
    public int insertAlbum(Album alb){
        super.openConnection();
        String query;
        query = String.format("INSERT INTO %s (id_organisasi, nama, deskripsi) VALUES (%s, '%s', '%s')", ALBUM_TABLE_NAME, alb.getId_organisasi(), alb.getName(), alb.getDescription());
        
        try {
            int id = super.getStatement().executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            if(alb.getImages()!=null&&alb.getImages().size()>0){
                cascadeImageFromAlbum(alb);
            }
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return -1;
    }
    
    private void cascadeImageFromAlbum(Album alb) {
        List<Image> images = alb.getImages();
        
        for(Image img:images){
            if(img.getId()==null){
                insertImage(img);
            }
        }
    }
    
    private void insertImage(Image img){
        super.openConnection();
        String query;
        query = String.format("INSERT INTO %s (id_album, nama, deskripsi) VALUES (%s, '%s', '%s')", IMAGE_TABLE_NAME, img.getId_album(), img.getName(), img.getDescription());
        
        try {
            super.getStatement().executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }

    public List<Album> selectAlbumByOrganization(int idOrganisasi){
        super.openConnection();
        String query = "SELECT * FROM " + ALBUM_TABLE_NAME;
        List<Album> result = new ArrayList<Album>();
        try{
            ResultSet res = super.getStatement().executeQuery(query);
            // selama masih ada baris yang bisa dibaca
            while (res.next()) {
                Album alb = new Album(res.getString("id"), 
                        res.getString("id_organisasi"),
                        res.getString("nama"),
                        res.getString("deskripsi"),
                        res.getString("created_at"),
                        res.getString("updated_at"));
                fetchIsiAlbum(alb);
                result.add(alb);
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        
        return null;
    }
    
    private void fetchIsiAlbum(Album alb) {
        super.openConnection();
        String query = "SELECT * FROM " + IMAGE_TABLE_NAME + " WHERE id_album="+alb.getId();
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            // selama masih ada baris yang bisa dibaca
            while (res.next()) {
                alb.addImage(new Image(res.getString("id"), res.getString("id_album"), res.getString("nama"), res.getString("deskripsi"), res.getString("created_at"), res.getString("updated_at")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }
    
    public void deleteImage(String id){
        String query="DELETE FROM "+IMAGE_TABLE_NAME+" WHERE id="+id;
        super.openConnection();
        try {
            super.getStatement().executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }
    
    public void deleteImageByAlbumId(String idAlbum){
        String query="DELETE FROM "+IMAGE_TABLE_NAME+" WHERE id_album="+idAlbum;
        super.openConnection();
        try {
            super.getStatement().executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }
    
    public Album getLastInsertedAlbum(){
        super.openConnection();
        String query;
        query = String.format("SELECT * FROM %s ORDER BY created_at DESC", ALBUM_TABLE_NAME);
        
        try{
            ResultSet res = super.getStatement().executeQuery(query);
            // selama masih ada baris yang bisa dibaca
            res.next();
            Album alb = new Album(res.getString("id"), 
                    res.getString("id_organisasi"),
                    res.getString("nama"),
                    res.getString("deskripsi"),
                    res.getString("created_at"),
                    res.getString("updated_at"));
            fetchIsiAlbum(alb);
            return alb;
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        
        return null;
    }
    
    public void deleteAlbum(String id){
        String query="DELETE FROM "+ALBUM_TABLE_NAME+" WHERE id="+id;
        super.openConnection();
        try {
            super.getStatement().executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            deleteImageByAlbumId(id);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }
    
    public int updateImage(Image img){
        String query = String.format("UPDATE %s SET "
                + "id_album=%s, "
                + "nama='%s', "
                + "deskripsi='%s' "
                + "WHERE id=%s", 
                this.IMAGE_TABLE_NAME,
                img.getId_album(),
                img.getName(),
                img.getDescription(),
                img.getId());
        super.openConnection();
        try {
            return super.getStatement().executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return -1;
    }

    
}