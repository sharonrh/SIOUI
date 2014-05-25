/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.util.List;
import javax.ejb.Local;
import object.Notifikasi;
import object.Pelamar;

/**
 *
 * @author Johanes
 */
@Local
public interface NotifBeanLocal {
    public void populateBean();
    public void emptyBean();
    public List<Notifikasi> getNotifications();
    public List<Pelamar> getPendaftaranku();
    public List<Notifikasi> getCloseRec();
}
