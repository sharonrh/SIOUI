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
import object.User;

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
        String user = (String) session.getAttribute("currentUser");

        if (user == null) {
            response.sendRedirect("/SIOUIbackend/login");
        } else {
            if (userPath.equals("/manage")) {
                ArrayList<Organisasi> listOrganisasi = om.selectAll();
                request.setAttribute("listOrganisasi", (Object) listOrganisasi);
                if (request.getParameter("success") != null) {
                    request.setAttribute("alertType", "alert-success");
                    request.setAttribute("alertContent", "Penghapusan organisasi berhasil dilakukan");
                } else {
                    request.setAttribute("alertType", "hidden");
                    request.setAttribute("alertContent", "");
                }
                RequestDispatcher view = request.getRequestDispatcher("manage.jsp");
                view.forward(request, response);
            } else if (userPath.equals("/manage/delete")) {
                String id = request.getParameter("del_id");
                om.deleteOrganisasi(id);
                response.sendRedirect("/SIOUIbackend/manage?success=true");
            } else if (userPath.equals("/pending")) {
                ArrayList<Permohonan> listPermohonan = pm.selectAll();
                request.setAttribute("listPermohonan", (Object) listPermohonan);
                if (request.getParameter("stat") != null && request.getParameter("stat").equals("0")) {
                    request.setAttribute("alertType", "alert-danger");
                    request.setAttribute("alertContent", "Gagal mengabulkan permohonan, duplikasi username atau nama");
                } else if (request.getParameter("stat") != null && request.getParameter("stat").equals("1")) {
                    request.setAttribute("alertType", "alert-success");
                    request.setAttribute("alertContent", "Approve permohonan berhasil dilakukan");
                } else if (request.getParameter("stat") != null && request.getParameter("stat").equals("2")) {
                    request.setAttribute("alertType", "alert-success");
                    request.setAttribute("alertContent", "Reject permohonan berhasil dilakukan");
                } else {
                    request.setAttribute("alertType", "hidden");
                    request.setAttribute("alertContent", "");
                }
                RequestDispatcher view = request.getRequestDispatcher("pending.jsp");
                view.forward(request, response);
            } else if (userPath.equals("/pending/permit")) {
                int stat = 0;
                // case approve
                if (request.getParameter("act") != null && request.getParameter("act").equals("approve")) {
                    // ada duplikasi data
                    if (pm.deletePermohonan(Integer.parseInt(request.getParameter("id")), true) > 0) {
                        stat = 1;
                    }
                } // case reject
                else if (request.getParameter("act") != null && request.getParameter("act").equals("reject")) {
                    pm.deletePermohonan(Integer.parseInt(request.getParameter("id")), false);
                    stat = 2;
                }
                response.sendRedirect("/SIOUIbackend/pending?stat=" + stat);
            }
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
