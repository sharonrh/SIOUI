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
import model.PermohonanModel;
import object.Organisasi;
import object.Permohonan;

/**
 *
 * @author daniel.januar
 */
public class OrganisasiController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        OrganisasiModel om = new OrganisasiModel();
        PermohonanModel pm = new PermohonanModel();
        HttpSession session = request.getSession(true);

        if (userPath.equals("/manage")) {
            ArrayList<Organisasi> listOrganisasi = om.selectAll();
            request.setAttribute("listOrganisasi", (Object) listOrganisasi);

            RequestDispatcher view = request.getRequestDispatcher("manage.jsp");
            view.forward(request, response);
        } else if (userPath.equals("/manage/delete")) {
            String id = request.getParameter("del_id");
            om.deleteOrganisasi(id);
            response.sendRedirect("/SIOUIbackend/manage");
        } else if (userPath.equals("/pending")) {
            ArrayList<Permohonan> listPermohonan = pm.selectAll();
            request.setAttribute("listPermohonan", (Object) listPermohonan);
            RequestDispatcher view = request.getRequestDispatcher("pending.jsp");
            view.forward(request, response);
        } else if (userPath.equals("/pending/permit")) {
            if (request.getParameter("act") != null && request.getParameter("act").equals("approve")) {

            } else if (request.getParameter("act") != null && request.getParameter("act").equals("reject")) {
                pm.deletePermohonan(Integer.parseInt(request.getParameter("id")));
            }
            response.sendRedirect("/SIOUIbackend/pending");
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
