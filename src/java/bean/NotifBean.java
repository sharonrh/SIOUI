/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;
import model.NotifikasiModel;
import model.PendaftaranModel;
import object.Notifikasi;
import object.Pelamar;

/**
 *
 * @author Johanes
 */
@Stateless
public class NotifBean implements NotifBeanLocal {
    NotifikasiModel nm = new NotifikasiModel();
    PendaftaranModel pm = new PendaftaranModel();
    
    ArrayList<Pelamar> pendaftaranku = new ArrayList<Pelamar>();
    ArrayList<Notifikasi> notifs = new ArrayList<Notifikasi>();
    ArrayList<Notifikasi> closerec = new ArrayList<Notifikasi>();
    
    String username = "";
    
    public NotifBean(){}
    
    public NotifBean(String username){
        this.username = username;
        populateBean();
    }
    
    @Override
    public void populateBean() {
        notifs = nm.selectAllNotifByUsername(username);
        closerec = nm.selectAllNotifByUsername(username);
        //pendaftaranku = pm.selectPendaftaranByUsername(username);
    }

    @Override
    public void emptyBean() {
        notifs = new ArrayList<Notifikasi>();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public ArrayList<Notifikasi> getNotifications() {
        return notifs;
    }
    
    public ArrayList<Pelamar> getPendaftaranku() {
        return pendaftaranku;
    }
    
    public ArrayList<Notifikasi> getCloseRec() {
        return closerec;
    }
}
