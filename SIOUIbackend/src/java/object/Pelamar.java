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
public class Pelamar {
    
    private int id;
    private int id_lowongan;
    private String username;
    private int id_cv;
    //Jenis : oprec / closerec
    private String jenis;
    //Status : wait / accept / reject
    private String status;
    private String created_at;
    private String updated_at;

    public Pelamar(int id, int id_lowongan, String username, int id_cv, String jenis, String status, String created_at, String updated_at) {
        this.id = id;
        this.id_lowongan = id_lowongan;
        this.username = username;
        this.id_cv = id_cv;
        this.jenis = jenis;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_lowongan() {
        return id_lowongan;
    }

    public void setId_lowongan(int id_lowongan) {
        this.id_lowongan = id_lowongan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId_cv() {
        return id_cv;
    }

    public void setId_cv(int id_cv) {
        this.id_cv = id_cv;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
