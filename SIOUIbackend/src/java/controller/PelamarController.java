/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.PelamarModel;
import object.Pelamar;
import webservice.UserCV;

/**
 *
 * @author daniel.januar
 */
public class PelamarController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        PelamarModel pm = new PelamarModel();
        HttpSession session = request.getSession(true);
        String user = (String) session.getAttribute("currentUser");
        if (user == null) {
            response.sendRedirect("/SIOUIbackend/login");
        } // admin nyasar 
        else if (user.equals("admin")) {
            response.sendRedirect("/SIOUIbackend/index");
        } else {
            if (userPath.equals("/pelamar")) {
                int id = 0;
                if (request.getParameter("id") == null) {
                    id = (int) session.getAttribute("currentLowongan");
                } else {
                    id = Integer.parseInt(request.getParameter("id"));
                    session.setAttribute("currentLowongan", id);
                }

                String status = request.getParameter("status_recruitment") == null
                        ? "wait" : request.getParameter("status_recruitment");
                String jenis = request.getParameter("jenis_recruitment") == null
                        ? "open" : request.getParameter("jenis_recruitment");

                ArrayList<Pelamar> listPelamar = pm.selectPelamarJenisStatus(id, jenis, status);
                request.setAttribute("status_recruitment", (Object) status);
                request.setAttribute("jenis_recruitment", (Object) jenis);
                request.setAttribute("listPelamar", (Object) listPelamar);

                RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/daftar-pelamar.jsp");
                view.forward(request, response);
            } else if (userPath.equals("/pelamar/detail")) {
                int id = Integer.parseInt(request.getParameter("id"));
                // sementara, ntar ganti dari ws
              
                        UserCV cv = new UserCV();
                cv.setName("Ragen Vadascovinich");
                cv.setAddress("Kratliev 27th block, 3rd");
                cv.setEmail("ragen@gmail.com");
                cv.setInterests("Berkebun, berternak, menabung");
                cv.setPhoneNumber("532-302-11");
                cv.setObjective("Menafkahi keluarga nan bahagia. Sungguh merupakan suatu kewajiban "
                        + "bagi setiap pria yang berkeluarga. Demikian harapan saya, saudara-saudara. "
                        + "Kala malam menyapa-- hendaknya kita berjumpa lagi.");
                cv.setQualification("What qualification?");
                cv.setReference("Prof. Ibrahim Vadascovinich");
                cv.setTitle("Curriculum Vitae");
                        request.setAttribute("cv", (Object) cv);
                RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/detail-pelamar.jsp");
                view.forward(request, response);
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

    private static UserCV getCV(java.lang.String cvId) {
        webservice.SivimuWebService_Service service = new webservice.SivimuWebService_Service();
        webservice.SivimuWebService port = service.getSivimuWebServicePort();
        return port.getCV(cvId);
    }

}
