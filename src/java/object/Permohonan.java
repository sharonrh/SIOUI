/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

/**
 *
 * @author ACER
 */
public class Permohonan {
    private int id;
    private String username;
    private String password;
    private String nama_panjang;
    private String deskripsi;

    public Permohonan(int id, String username, String password, String nama_panjang, String deskripsi) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nama_panjang = nama_panjang;
        this.deskripsi = deskripsi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama_panjang() {
        return nama_panjang;
    }

    public void setNama_panjang(String nama_panjang) {
        this.nama_panjang = nama_panjang;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

  
    
    
}
