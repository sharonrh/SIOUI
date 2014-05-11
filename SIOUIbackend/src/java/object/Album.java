/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package object;

import java.util.List;

/**
 *
 * @author Johanes
 */
public class Album {
    private String id;
    private String id_organisasi;
    private String name;
    private String description;
    private String created_at;
    private String updated_at;
    private List<Image> images;

    public Album(String id, String id_organisasi, String name, String description, String created_at, String updated_at) {
        this.id = id;
        this.id_organisasi = id_organisasi;
        this.name = name;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
    
    public void addImage(Image img){
        images.add(img);
    }
    
    public List<Image> getImages(){
        return images;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_organisasi() {
        return id_organisasi;
    }

    public void setId_organisasi(String id_organisasi) {
        this.id_organisasi = id_organisasi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
    
    
}
