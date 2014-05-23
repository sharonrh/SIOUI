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
import model.PelamarModel;
import model.PermohonanModel;
import object.Pelamar;

/**
 *
 * @author daniel.januar
 */
public class PelamarController extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        PelamarModel pm = new PelamarModel();
        HttpSession session = request.getSession(true);
        if (userPath.equals("/daftar-pelamar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            ArrayList<Pelamar> listPelamar = new ArrayList<Pelamar>();
            String status = request.getParameter("status_recruitment");
            String jenis = request.getParameter("jenis_recruitment");
            if(status.equals("open") && jenis.equals("accept")){
                //isi list pelamar
            } else if(status.equals("open") && jenis.equals("reject")){
                // isi
            } else if(status.equals("open") && jenis.equals("wait")){
                
            } else if(status.equals("close") && jenis.equals("accept")){
                
            } else if(status.equals("close") && jenis.equals("reject")){
                
            } else if(status.equals("close") && jenis.equals("wait")){
                
            }
            request.setAttribute("listPelamar", (Object) listPelamar);
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/daftar-pelamar.jsp");
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
