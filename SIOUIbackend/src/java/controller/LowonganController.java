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
import model.LowonganModel;
import object.Lowongan;
import object.User;

/**
 *
 * @author daniel.januar
 */
public class LowonganController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        LowonganModel lm = new LowonganModel();
        HttpSession session = request.getSession(true);
        String username = ((User)session.getAttribute("currentUser")).getUsername();
        System.out.println(username);

        if (userPath.equals("/lowongan")) {
            ArrayList<Lowongan> listLowongan = lm.selectAll(username);
            request.setAttribute("listLowongan", (Object) listLowongan);
            RequestDispatcher view = request.getRequestDispatcher("lowongan.jsp");
            view.forward(request, response);
        } else if (userPath.equals("/lowongan/add")) {
            System.out.println(userPath);
            Lowongan lw = new Lowongan();
            request.setAttribute("detailLowongan", (Object) lw);
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/form-lowongan.jsp?alert=success");
            view.forward(request, response);
        } else if (userPath.equals("/lowongan/edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);
            Lowongan lw = lm.select(id);
            lm.update(lw);
            request.setAttribute("detailLowongan", lw);
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/form-lowongan.jsp");
            view.forward(request, response);
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
