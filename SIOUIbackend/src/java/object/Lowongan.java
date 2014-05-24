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
public class Lowongan {

    private int id;
    private String username;
    private int kapasitas;
    private String tanggal_buka;
    private String tanggal_tutup;
    private String judul;
    private String jabatan;
    private int minimum_tahun;
    private double minimum_ipk;
    private String kategori;
    private String deskripsi;
    private String created_at;
    private String updated_at;

    public Lowongan() {

    }

    public Lowongan(int id, String username, String jabatan, String judul, int kapasitas, String tanggal_buka, String tanggal_tutup, int minimum_tahun, double minimum_ipk, String kategori, String deskripsi) {
        this.id = id;
        this.username = username;
        this.kapasitas = kapasitas;
        this.tanggal_buka = tanggal_buka;
        this.tanggal_tutup = tanggal_tutup;
        this.judul = judul;
        this.jabatan = jabatan;
        this.minimum_tahun = minimum_tahun;
        this.minimum_ipk = minimum_ipk;
        this.kategori = kategori;
        this.deskripsi = deskripsi;
    }

    public Lowongan(int id, String username, int kapasitas, String tanggal_buka, String tanggal_tutup, String judul, String jabatan, int minimum_tahun, double minimum_ipk, String kategori, String deskripsi, String created_at, String updated_at) {
        this.id = id;
        this.username = username;
        this.kapasitas = kapasitas;
        this.tanggal_buka = tanggal_buka;
        this.tanggal_tutup = tanggal_tutup;
        this.judul = judul;
        this.jabatan = jabatan;
        this.minimum_tahun = minimum_tahun;
        this.minimum_ipk = minimum_ipk;
        this.kategori = kategori;
        this.deskripsi = deskripsi;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public String getTanggal_buka() {
        return tanggal_buka;
    }

    public String getTanggal_tutup() {
        return tanggal_tutup;
    }

    public String getJudul() {
        return judul;
    }

    public String getJabatan() {
        return jabatan;
    }

    public int getMinimum_tahun() {
        return minimum_tahun;
    }

    public double getMinimum_ipk() {
        return minimum_ipk;
    }

    public String getKategori() {
        return kategori;
    }

    public String getDeskripsi() {
        return deskripsi;
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

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public void setTanggal_buka(String tanggal_buka) {
        this.tanggal_buka = tanggal_buka;
    }

    public void setTanggal_tutup(String tanggal_tutup) {
        this.tanggal_tutup = tanggal_tutup;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public void setMinimum_tahun(int minimum_tahun) {
        this.minimum_tahun = minimum_tahun;
    }

    public void setMinimum_ipk(double minimum_ipk) {
        this.minimum_ipk = minimum_ipk;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

}
