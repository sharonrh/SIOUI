/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.Organization;
import object.User;

/**
 *
 * @author Johanes
 */
public class OrganizationModel extends Model {

    final String TABLE_NAME = "organizations";

    public Organization select(String nama_pendek) {
        super.openConnection();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE nama_pendek='" + nama_pendek + "'";
        Organization a = null;
        try {
            ResultSet res = super.getStatement().executeQuery(query);
            res.next();
            a = new Organization(res.getString("id_organisasi"),res.getString("nama_panjang"),res.getString("nama_pendek"));
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return a;
    }
}
