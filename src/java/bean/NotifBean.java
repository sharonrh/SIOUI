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
import model.PelamarModel;
import object.Notifikasi;
import object.Pelamar;

/**
 *
 * @author Johanes
 */
@Stateless
public class NotifBean implements NotifBeanLocal {
    NotifikasiModel nm = new NotifikasiModel();
    PelamarModel pm = new PelamarModel();
    
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
        notifs = nm.selectAllUnread(username);
        closerec = nm.selectAllCloseRec(username);
        pendaftaranku = pm.selectAllPelamar(username);
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
    
    public void sortPendaftaranku(){
        ArrayList<Pelamar> baru = new ArrayList<Pelamar>();
        for(int i=0;i<pendaftaranku.size();i++){
            if(pendaftaranku.get(i).getStatus().equals("wait")){
                baru.add(pendaftaranku.get(i));
            }
        }
        for(int i=0;i<pendaftaranku.size();i++){
            if(!pendaftaranku.get(i).getStatus().equals("wait")){
                baru.add(pendaftaranku.get(i));
            }
        }
        pendaftaranku = baru;
    }
}
