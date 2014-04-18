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
    private String id_user;
    private int id_organisasi;
    private int id_lowongan;
    private String username;
    private String tgl_lamar;

    public Pelamar(String id_user, int id_organisasi, int id_lowongan, String username, String tgl_lamar) {
        this.id_user = id_user;
        this.id_organisasi = id_organisasi;
        this.id_lowongan = id_lowongan;
        this.username = username;
        this.tgl_lamar = tgl_lamar;
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

    public String getUsername() {
        return username;
    }

    public String getTgl_lamar() {
        return tgl_lamar;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTgl_lamar(String tgl_lamar) {
        this.tgl_lamar = tgl_lamar;
    }
    
    
}
