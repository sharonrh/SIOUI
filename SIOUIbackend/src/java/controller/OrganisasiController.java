/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.OrganisasiModel;
import object.Organisasi;

/**
 *
 * @author daniel.januar
 */
public class OrganisasiController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        OrganisasiModel om = new OrganisasiModel();
        HttpSession session = request.getSession(true);
        
        if (userPath.equals("/manage")) {
            ArrayList<Organisasi> listOrganisasi = om.selectAll();
            request.setAttribute("listOrganisasi", (Object) listOrganisasi);
            RequestDispatcher view = request.getRequestDispatcher("manage.jsp");
            view.forward(request, response);
//        } else if (userPath.equals("/lowongan/details")) {
//            System.out.println(userPath);
//            Lowongan lw = om.select(3);
//            request.setAttribute("detailLowongan", (Object) lw);
//            RequestDispatcher view = request.getRequestDispatcher("form-lowongan.jsp");
//            view.forward(request, response);
//        } else if (userPath.equals("/lowongan/edit")) {
//            int id = 3;
//            System.out.println(userPath);
//            System.out.println(request.getParameter("minimum_ipk"));
//            System.out.println(request.getParameter("tanggal_buka"));
//            System.out.println(request.getParameter("tanggal_tutup"));
//            System.out.println(request.getParameter("judul"));
//            System.out.println(request.getParameter("kategori"));
//            System.out.println(request.getParameter("deskripsi"));
//            int kapasitas = Integer.parseInt(request.getParameter("kapasitas"));
//            String tanggal_buka = request.getParameter("tanggal_buka");
//            String tanggal_tutup = request.getParameter("tanggal_tutup");
//            String judul = request.getParameter("judul");
//            String jabatan = request.getParameter("jabatan");
//            String minimum_tahun = request.getParameter("minimum_tahun");
//            double minimum_ipk = Double.parseDouble(request.getParameter("minimum_ipk"));
//            String kategori = request.getParameter("kategori");
//            String deskripsi = request.getParameter("deskripsi");
//            Lowongan lw = new Lowongan(id, username, kapasitas,
//                    tanggal_buka, tanggal_tutup, judul,
//                    jabatan, kapasitas, minimum_ipk, kategori, deskripsi);
//            om.update(lw);
//            response.sendRedirect("/SIOUIbackend/");
        } else if (userPath.equals("/lowongan/success")) {

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
