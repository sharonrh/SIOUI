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
public class Jabatan {
    String id;
    String id_organisasi;
    String nama;
    String jabatan;
    String created_at;
    String updated_at;

    public Jabatan(String id, String id_organisasi, String nama, String jabatan, String created_at, String updated_at) {
        this.id = id;
        this.id_organisasi = id_organisasi;
        this.nama = nama;
        this.jabatan = jabatan;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Jabatan(String id_organisasi, String nama, String jabatan) {
        this.id_organisasi = id_organisasi;
        this.nama = nama;
        this.jabatan = jabatan;
    }

    public Jabatan(){}
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_organisasi() {
        return id_organisasi;
    }

    public void setId_organisasi(String id_organisasi) {
        this.id_organisasi = id_organisasi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
    
    
}
