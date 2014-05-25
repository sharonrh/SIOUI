/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.GalleryModel;
import model.JabatanModel;
import model.LowonganModel;
import model.OrganisasiModel;
import object.Album;
import object.Jabatan;
import object.Lowongan;
import object.Organisasi;

/**
 *
 * @author Johanes
 */
public class ExploreController extends HttpServlet {

    OrganisasiModel om = new OrganisasiModel();
    LowonganModel lm = new LowonganModel();
    JabatanModel jm = new JabatanModel();
    GalleryModel gm = new GalleryModel();

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
        String userPath = request.getServletPath();
        if (userPath.equals("/explore")) {

        } else if (userPath.equals("/explore/showlistorg")) {
            Object objJenis = request.getParameter("jenis");
            if (objJenis == null) {
                response.sendRedirect("index.jsp");
            }
            String jenis = objJenis.toString();
            List<Organisasi> orgs = om.selectByJenis(jenis);
            request.setAttribute("orgs", orgs);
            String detail ="";
            String judul ="";
            if(request.getParameter("jenis").equals("ukm")){
                judul = "UKM";
                detail = "Organisasi tetap yang terbuka untuk seluruh mahasiswa Universitas Indonesia.";
            } else if(request.getParameter("jenis").equals("ukf")){
                judul = "UKF";
                detail = "Organisasi tetap yang dikhususkan untuk mahasiswa fakultas tertentu.";
            } else if(request.getParameter("jenis").equals("event")){
                judul = "Event";
                detail = "Organisasi yang dikhususkan untuk pelaksanaan suatu event tertentu.";
            }
            request.setAttribute("judul", judul);
            request.setAttribute("detail", detail);
            RequestDispatcher view = request.getRequestDispatcher("/organisasi.jsp");
            view.forward(request, response);

        } else if (userPath.equals("/explore/showdetailorg")) {
            Object objId = request.getParameter("id");
            if (objId == null) {
                //redirect here
            }
            String id = objId.toString();

            /*
             List<Lowongan> lwgs = lm.selectMultipleByOrganizationID(id);
             request.setAttribute("lwgs", lwgs);
             */
            Organisasi org = om.select(Integer.parseInt(id));
            request.setAttribute("org", org);

            List<Jabatan> jbts = jm.selectByIdOrganisasi(id);
            request.setAttribute("jbts", jbts);

            RequestDispatcher view = request.getRequestDispatcher("/organisasi-details.jsp");
            view.forward(request, response);
        } else if (userPath.equals("/explore/showlistlwg")) {
            Object objIdOrg = request.getParameter("idorg");
            if (objIdOrg == null) {
                //redirect here
            }
            String idOrg = objIdOrg.toString();
            
            Organisasi org = om.select(Integer.parseInt(idOrg));
            request.setAttribute("org", org);
            
            List<Lowongan> lwgs = lm.selectMultipleByUsername(org.getUsername());
            request.setAttribute("lwgs", lwgs);
            
            RequestDispatcher view = request.getRequestDispatcher("/list-lowongan.jsp");
            view.forward(request, response);
        } else if (userPath.equals("/explore/showdetaillwg")) {
            Object objId = request.getParameter("id");
            if (objId == null) {
                //redirect here
            }
            String id = objId.toString();
            
            Lowongan lwg = lm.select(id);
            String usernameOrg = lwg.getUsername();
            Organisasi org =  om.selectFromId(usernameOrg);
            request.setAttribute("org", org);
            request.setAttribute("lwg", lwg);
            
            RequestDispatcher view = request.getRequestDispatcher("/lowongan-details.jsp");
            view.forward(request, response);
        } else if (userPath.equals("/explore/showalbums")){
            Object objId = request.getParameter("id");
            if (objId == null) {
                //redirect here
            }
            String id = objId.toString();
            List<object.Album> a = gm.selectAlbumByOrganization(Integer.parseInt(id));
            
            Object objIdAlbum = request.getParameter("idalbum");
            String idAlbum = "";
            if (objIdAlbum == null) {
                idAlbum = a.get(0).getId();
            }else{
                idAlbum = objIdAlbum.toString();
            }
            
            Album albumDipilih = gm.getSingleAlbum(Integer.parseInt(idAlbum));
            request.setAttribute("albumDipilih", albumDipilih);
            
            Organisasi org = om.select(Integer.parseInt(id));
            request.setAttribute("org", org);
            
            request.setAttribute("albums", (Object) a);
            
            RequestDispatcher view = request.getRequestDispatcher("/album.jsp");
            view.forward(request, response);
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
