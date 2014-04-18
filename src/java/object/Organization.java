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
public class Organization {

   private String id_user;
   private int id_organisasi;
   private String nama_panjang;
   private String nama_pendek;
   private String logo;
   private String deskripsi;
   private String visi;
   private String jenis;
   private String alamat;
   
   public Organization(String id_user, String nama_panjang, String nama_pendek){
       this.id_user = id_user;
       this.nama_panjang = nama_panjang;
       this.nama_pendek = nama_pendek;
   }

    public Organization(String id_user, int id_organisasi, String nama_panjang, String nama_pendek, String logo, String deskripsi, String visi, String jenis, String alamat) {
        this.id_user = id_user;
        this.id_organisasi = id_organisasi;
        this.nama_panjang = nama_panjang;
        this.nama_pendek = nama_pendek;
        this.logo = logo;
        this.deskripsi = deskripsi;
        this.visi = visi;
        this.jenis = jenis;
        this.alamat = alamat;
    }

    public String getId_user() {
        return id_user;
    }

    public int getId_organisasi() {
        return id_organisasi;
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

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public void setId_organisasi(int id_organisasi) {
        this.id_organisasi = id_organisasi;
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
