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
    private int id;
    private int id_album;
    private String deksripsi;
    private String created_at;
    private String updated_at;

    public Foto(int id, int id_album, String deksripsi, String created_at, String updated_at) {
        this.id = id;
        this.id_album = id_album;
        this.deksripsi = deksripsi;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public int getId_album() {
        return id_album;
    }

    public String getDeksripsi() {
        return deksripsi;
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

    public void setId_album(int id_album) {
        this.id_album = id_album;
    }

    public void setDeksripsi(String deksripsi) {
        this.deksripsi = deksripsi;
    }
}
