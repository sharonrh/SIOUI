/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.LowonganModel;
import model.OrganisasiModel;
import model.PelamarModel;
import model.UserModel;
import object.Lowongan;
import object.Organisasi;
import object.Pelamar;
import ws.UserCV;

/**
 *
 * @author Johanes
 */
public class UserController extends HttpServlet {

    UserModel um = new UserModel();
    OrganisasiModel om = new OrganisasiModel();
    LowonganModel lm = new LowonganModel();
    PelamarModel pm = new PelamarModel();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("currentUser");
        
        String userPath = request.getServletPath();
        if (userPath.equals("/user/dashboard")) {
            ArrayList<Organisasi> orgs = om.selectAll();
            Hashtable<Integer, Organisasi> tableOrgs = new Hashtable<Integer, Organisasi>();
            for(Organisasi org:orgs){
                tableOrgs.put(org.getId(), org);
            }
            ArrayList<Lowongan> lwgs = lm.selectAll();
            Hashtable<Integer, Lowongan> tableLwgs = new Hashtable<Integer, Lowongan>();
            for(Lowongan lwg:lwgs){
                tableLwgs.put(lwg.getId(), lwg);
            }
            ArrayList<Pelamar> pelamar = pm.selectAll();
            Hashtable<Integer, Pelamar> tablePelamar = new Hashtable<Integer, Pelamar>();
//            for(Pelamar plm:pelamar){
//                tablePelamar.put(plm.getId(), plm);
//            }
            request.setAttribute("tableOrgs", tableOrgs);
            request.setAttribute("tableLwgs", tableLwgs);
            request.setAttribute("tablePelamar", tablePelamar);
            RequestDispatcher view = request.getRequestDispatcher("/dashboard.jsp");
            view.forward(request, response);
            
        } else if (userPath.equals("/user/pendaftaranku")) {

        } else if (userPath.equals("/user/closerec")) {

        } else if (userPath.equals("/user/notifikasi")) {

        } else if (userPath.equals("/user/listcv")) {

        } else if (userPath.equals("/user/profil")) {

        } else if (userPath.equals("/user/daftar")) {
            Object objId = request.getParameter("id");
            if (objId == null) {
                //redirect here
            }
            String id = objId.toString();

            //cek udah login apa belom
            if(session==null||user==null){
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }
            
            request.setAttribute("formAction", request.getContextPath()+"/user/dodaftar");
            request.setAttribute("idlw", id);

            List<UserCV> cvs = um.getMultipleCVByUsername(user);
            request.setAttribute("cvs", cvs);
            RequestDispatcher view = request.getRequestDispatcher("/daftar-pilihcv.jsp");
            view.forward(request, response);
        } else if (userPath.equals("/user/dodaftar")) {
            String idcv = request.getParameter("cvs");
            String idlw = request.getParameter("idlw");
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
