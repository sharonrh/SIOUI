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

   private String idUser;
   private int idOrganisasi;
   private String namaPanjang;
   private String namaPendek;
   private String logo;
   private String deskripsi;
   private String visi;
   private String jenis;
   private String alamat;
   
   public Organization(String id_user, String nama_panjang, String nama_pendek){
       this.idUser = id_user;
       this.namaPanjang = nama_panjang;
       this.namaPendek = nama_pendek;
   }

    public Organization(String idUser, int idOrganisasi, String namaPanjang, String namaPendek, String logo, String deskripsi, String visi, String jenis, String alamat) {
        this.idUser = idUser;
        this.idOrganisasi = idOrganisasi;
        this.namaPanjang = namaPanjang;
        this.namaPendek = namaPendek;
        this.logo = logo;
        this.deskripsi = deskripsi;
        this.visi = visi;
        this.jenis = jenis;
        this.alamat = alamat;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public int getIdOrganisasi() {
        return idOrganisasi;
    }

    public void setIdOrganisasi(int idOrganisasi) {
        this.idOrganisasi = idOrganisasi;
    }

    public String getNamaPanjang() {
        return namaPanjang;
    }

    public void setNamaPanjang(String namaPanjang) {
        this.namaPanjang = namaPanjang;
    }

    public String getNamaPendek() {
        return namaPendek;
    }

    public void setNamaPendek(String namaPendek) {
        this.namaPendek = namaPendek;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getVisi() {
        return visi;
    }

    public void setVisi(String visi) {
        this.visi = visi;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    
}
