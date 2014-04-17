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

    //  @XmlElement(name = "id", required = true)
    private int id;
    //  @XmlElement(name = "judul", required = true)
    private String judul;
    //  @XmlElement(name = "deskripsi", required = true)
    private String deskripsi;
    //  @XmlElement(name = "jabatan", required = true)
    private String jabatan;
    //  @XmlElement(name = "minimumTahun", required = true)
    private int minimumTahun;
    //  @XmlElement(name = "pendaftaranDimulai", required = true)
    private String pendaftaranDimulai;
    //  @XmlElement(name = "pendaftaranSelesai", required = true)
    private String pendaftaranSelesai;
    // @XmlElement(name = "minimumIPK", required = true)
    private double minimumIPK;
    //  @XmlElement(name = "kategori", required = true)
    private String kategori;
    //  @XmlElement(name = "jumlahDibutuhkan", required = true)
    private int jumlahDibutuhkan;

    public Lowongan() {
    }

    public Lowongan(int id, String judul, String deskripsi, String jabatan, int minimumTahun, String pendaftaranDimulai, String pendaftaranSelesai, double minimumIPK, String kategori, int jumlahDibutuhkan) {
        this.id = id;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.jabatan = jabatan;
        this.minimumTahun = minimumTahun;
        this.pendaftaranDimulai = pendaftaranDimulai;
        this.pendaftaranSelesai = pendaftaranSelesai;
        this.minimumIPK = minimumIPK;
        this.kategori = kategori;
        this.jumlahDibutuhkan = jumlahDibutuhkan;
    }

    public int getJumlahDibutuhkan() {
        return jumlahDibutuhkan;
    }

    public void setJumlahDibutuhkan(int jumlahDibutuhkan) {
        this.jumlahDibutuhkan = jumlahDibutuhkan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public int getMinimumTahun() {
        return minimumTahun;
    }

    public void setMinimumTahun(int minimumTahun) {
        this.minimumTahun = minimumTahun;
    }

    public String getPendaftaranDimulai() {
        return pendaftaranDimulai;
    }

    public void setPendaftaranDimulai(String pendaftaranDimulai) {
        this.pendaftaranDimulai = pendaftaranDimulai;
    }

    public String getPendaftaranSelesai() {
        return pendaftaranSelesai;
    }

    public void setPendaftaranSelesai(String pendaftaranSelesai) {
        this.pendaftaranSelesai = pendaftaranSelesai;
    }

    public double getMinimumIPK() {
        return minimumIPK;
    }

    public void setMinimumIPK(double minimumIPK) {
        this.minimumIPK = minimumIPK;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

}
