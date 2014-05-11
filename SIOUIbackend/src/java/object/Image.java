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
public class Image {
    private String id;
    private String id_album;
    private String name;
    private String description;
    private String created_at;
    private String updated_at;

    public Image(String id, String id_album, String name, String description) {
        this.id = id;
        this.id_album = id_album;
        this.name = name;
        this.description = description;
    }

    public Image(String id, String id_album, String name, String description, String created_at, String updated_at) {
        this.id = id;
        this.id_album = id_album;
        this.name = name;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_album() {
        return id_album;
    }

    public void setId_album(String id_album) {
        this.id_album = id_album;
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
