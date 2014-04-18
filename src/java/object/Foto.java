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
public class Foto {
    private String id_user;
    private int id_organisasi;
    private int id_album;
    private int id_foto;
    private String file_foto;
    private String deksripsi;

    public Foto(String id_user, int id_organisasi, int id_album, int id_foto, String file_foto) {
        this.id_user = id_user;
        this.id_organisasi = id_organisasi;
        this.id_album = id_album;
        this.id_foto = id_foto;
        this.file_foto = file_foto;
    }

    public Foto(String id_user, int id_organisasi, int id_album, int id_foto, String file_foto, String deksripsi) {
        this.id_user = id_user;
        this.id_organisasi = id_organisasi;
        this.id_album = id_album;
        this.id_foto = id_foto;
        this.file_foto = file_foto;
        this.deksripsi = deksripsi;
    }

    public String getId_user() {
        return id_user;
    }

    public int getId_organisasi() {
        return id_organisasi;
    }

    public int getId_album() {
        return id_album;
    }

    public int getId_foto() {
        return id_foto;
    }

    public String getFile_foto() {
        return file_foto;
    }

    public String getDeksripsi() {
        return deksripsi;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public void setId_organisasi(int id_organisasi) {
        this.id_organisasi = id_organisasi;
    }

    public void setId_album(int id_album) {
        this.id_album = id_album;
    }

    public void setId_foto(int id_foto) {
        this.id_foto = id_foto;
    }

    public void setFile_foto(String file_foto) {
        this.file_foto = file_foto;
    }

    public void setDeksripsi(String deksripsi) {
        this.deksripsi = deksripsi;
    }
    
    
}
