/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.PermohonanModel;
import model.UserModel;
import object.User;

/**
 *
 * @author Johanes
 */
public class RegisterController extends HttpServlet {

    UserModel um = new UserModel();

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
        HttpSession session = request.getSession(true);
        String user = (String) session.getAttribute("currentUser");
        System.out.println("username: " + user);
        if (user == null) {
            response.sendRedirect(request.getContextPath());
        } else if (userPath.equals("/daftar-organisasi")) {
            if (request.getParameter("success") != null && request.getParameter("success").equals("true")) {
                request.setAttribute("alertType", "alert-success");
                request.setAttribute("alertContent", "Request Organisasi telah berhasil dilakukan. Mohon menunggu konfirmasi admin.");
            }
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/daftar-sekarang.jsp");
            view.forward(request, response);
        } else if (userPath.equals("/daftar-organisasi/add")) {
            String username = request.getParameter("username_organisasi");
            String password = request.getParameter("password");
            String deskripsi = request.getParameter("deskripsi");
            String nama_panjang = request.getParameter("nama_panjang");
            PermohonanModel pm = new PermohonanModel();
            pm.addPermohonan(user, username, password, nama_panjang, deskripsi);
            String returnValue = "true";
            response.sendRedirect("/daftar-organisasi?success=" + returnValue);
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
