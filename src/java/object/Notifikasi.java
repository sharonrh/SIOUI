/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package object;

/**
 *
 * @author Johanes
 */
public class Notifikasi {
    String id;
    String username;
    String id_organisasi;
    String id_lowongan;
    String jenis;
    boolean seen;
    String created_at;
    String seen_at;

    public Notifikasi(String id, String username, String id_organisasi, String id_lowongan, String jenis, boolean seen, String created_at, String seen_at) {
        this.id = id;
        this.username = username;
        this.id_organisasi = id_organisasi;
        this.id_lowongan = id_lowongan;
        this.jenis = jenis;
        this.seen = seen;
        this.created_at = created_at;
        this.seen_at = seen_at;
    }

    public Notifikasi(String username, String id_organisasi, String id_lowongan, String jenis) {
        this.username = username;
        this.id_organisasi = id_organisasi;
        this.id_lowongan = id_lowongan;
        this.jenis = jenis;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId_organisasi() {
        return id_organisasi;
    }

    public void setId_organisasi(String id_organisasi) {
        this.id_organisasi = id_organisasi;
    }

    public String getId_lowongan() {
        return id_lowongan;
    }

    public void setId_lowongan(String id_lowongan) {
        this.id_lowongan = id_lowongan;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getSeen_at() {
        return seen_at;
    }

    public void setSeen_at(String seen_at) {
        this.seen_at = seen_at;
    }
    
    
    
}
