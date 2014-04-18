/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package object;

/**
 *
 * @author daniel.januar
 */
public class Album {
    private String id_user;
    private int id_organisasi;
    private int id_album;
    private String deskripsi;

    public Album(String id_user, int id_organisasi, int id_album) {
        this.id_user = id_user;
        this.id_organisasi = id_organisasi;
        this.id_album = id_album;
    }

    public Album(String id_user, int id_organisasi, int id_album, String deskripsi) {
        this.id_user = id_user;
        this.id_organisasi = id_organisasi;
        this.id_album = id_album;
        this.deskripsi = deskripsi;
    }

    public String getId_user() {
        return id_user;
    }

    public int getId_organisasi() {
        return id_organisasi;
    }

    public int getId_album() {
        return id_album;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public void setId_organisasi(int id_organisasi) {
        this.id_organisasi = id_organisasi;
    }

    public void setId_album(int id_album) {
        this.id_album = id_album;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    
    
}
