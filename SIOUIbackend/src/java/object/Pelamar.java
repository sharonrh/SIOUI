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
    //Jenis : oprec / closerec
    private String jenis;
    //Status : wait / accept / reject
    private String status;
    private String created_at;
    private String updated_at;

    public Pelamar(int id, int id_lowongan, String username, String jenis, String status, String created_at, String updated_at) {
        this.id = id;
        this.id_lowongan = id_lowongan;
        this.username = username;
        this.jenis = jenis;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public int getId_lowongan() {
        return id_lowongan;
    }

    public String getUsername() {
        return username;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_lowongan(int id_lowongan) {
        this.id_lowongan = id_lowongan;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
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
    
    
}
