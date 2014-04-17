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

    private int id;
    private String namePanjang;
    private String namePendek;
    private String tanggalBerdiri;
    private String jenis;
    private String alamat;
    private String deskripsi;
    private String visi;

    public Organization(String namePendek, String deskripsi) {
        this.namePendek = namePendek;
        this.deskripsi = deskripsi;
    }

    public Organization(String namePanjang, String namePendek, String tanggalBerdiri, String jenis, String alamat, String deskripsi, String visi) {
        this.namePanjang = namePanjang;
        this.namePendek = namePendek;
        this.tanggalBerdiri = tanggalBerdiri;
        this.jenis = jenis;
        this.alamat = alamat;
        this.deskripsi = deskripsi;
        this.visi = visi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamePanjang() {
        return namePanjang;
    }

    public void setNamePanjang(String namePanjang) {
        this.namePanjang = namePanjang;
    }

    public String getNamePendek() {
        return namePendek;
    }

    public void setNamePendek(String namePendek) {
        this.namePendek = namePendek;
    }

    public String getTanggalBerdiri() {
        return tanggalBerdiri;
    }

    public void setTanggalBerdiri(String tanggalBerdiri) {
        this.tanggalBerdiri = tanggalBerdiri;
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

}
