/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Johanes
 */
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "lowongan", propOrder = {"id", "judul", "deskripsi", "jabatan", "minimumTahun", "pendaftaranDimulai", "pendaftaranSelesai", "minimumIPK", "kategori", "jumlahDibutuhkan"})
public class Lowongan {
    private String id_user;
    private int id_organisasi;
    private int id_lowongan;
    private int kapasitas;
    private String tanggal_buka;
    private String tanggal_tutup;
    private String judul;
    private String jabatan;
    private int minimum_tahun;
    private double minimum_ipk;
    private String kategori;
    private String deskripsi;
    
    public Lowongan() {
    }

    public Lowongan(String id_user, int id_organisasi, int id_lowongan, int kapasitas, String tanggal_buka, String tanggal_tutup, String judul, String jabatan, int minimum_tahun, double minimum_ipk, String kategori, String deskripsi) {
        this.id_user = id_user;
        this.id_organisasi = id_organisasi;
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

    public String getId_user() {
        return id_user;
    }

    public int getId_organisasi() {
        return id_organisasi;
    }

    public int getId_lowongan() {
        return id_lowongan;
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

    public int getMinimumTahun() {
        return minimum_tahun;
    }

    public double getMinimumIpk() {
        return minimum_ipk;
    }

    public String getKategori() {
        return kategori;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public void setId_organisasi(int id_organisasi) {
        this.id_organisasi = id_organisasi;
    }

    public void setId_lowongan(int id_lowongan) {
        this.id_lowongan = id_lowongan;
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
