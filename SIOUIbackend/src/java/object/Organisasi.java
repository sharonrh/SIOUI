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
public class Organisasi {
    private int id;
    private String username;
    private String nama_panjang;
    private String nama_pendek;
    private String logo;
    private String deskripsi;
    private String visi;
    private String jenis;
    private String alamat;
    private String created_at;
    private String updated_at;

    public Organisasi(int id, String username, String nama_panjang, String nama_pendek, String logo, String deskripsi, String visi, String jenis, String alamat) {
        this.id = id;
        this.username = username;
        this.nama_panjang = nama_panjang;
        this.nama_pendek = nama_pendek;
        this.logo = logo;
        this.deskripsi = deskripsi;
        this.visi = visi;
        this.jenis = jenis;
        this.alamat = alamat;
    }

    public Organisasi(String username, String nama_panjang, String nama_pendek, String logo, String deskripsi, String visi, String jenis, String alamat) {
        this.username = username;
        this.nama_panjang = nama_panjang;
        this.nama_pendek = nama_pendek;
        this.logo = logo;
        this.deskripsi = deskripsi;
        this.visi = visi;
        this.jenis = jenis;
        this.alamat = alamat;
    }
    
    public Organisasi(int id, String username, String nama_panjang, 
            String nama_pendek, String logo, String deskripsi, 
            String visi, String jenis, String alamat, String created_at, 
            String updated_at) {
        this.id = id;
        this.username = username;
        this.nama_panjang = nama_panjang;
        this.nama_pendek = nama_pendek;
        this.logo = logo;
        this.deskripsi = deskripsi;
        this.visi = visi;
        this.jenis = jenis;
        this.alamat = alamat;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getNama_panjang() {
        return nama_panjang;
    }

    public String getNama_pendek() {
        return nama_pendek;
    }

    public String getLogo() {
        return logo;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getVisi() {
        return visi;
    }

    public String getJenis() {
        return jenis;
    }

    public String getAlamat() {
        return alamat;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNama_panjang(String nama_panjang) {
        this.nama_panjang = nama_panjang;
    }

    public void setNama_pendek(String nama_pendek) {
        this.nama_pendek = nama_pendek;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setVisi(String visi) {
        this.visi = visi;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
