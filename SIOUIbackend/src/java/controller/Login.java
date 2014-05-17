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
import model.UserModel;
import object.User;

/**
 *
 * @author ACER
 */
public class Login extends HttpServlet {

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
        UserModel um = new UserModel();
        System.out.println("path: " + userPath);
        if (userPath.equals("") || userPath.equals("/index")) {
            System.out.println("masuk atas");
            if (request.getParameter("success") != null && request.getParameter("success").equals("true")) {
                request.setAttribute("alertType", "alert-success");
                request.setAttribute("alertContent", "Anda berhasil login!");
            } else if (request.getParameter("success") != null && request.getParameter("success").equals("false")) {
                request.setAttribute("alertType", "alert-danger");
                request.setAttribute("alertContent", "Username atau password yang dimasukkan salah");
            } else if (request.getParameter("logout") != null) {
                request.setAttribute("alertType", "alert-success");
                request.setAttribute("alertContent", "Anda sudah logout.");
            } else {
                request.setAttribute("alertType", "hidden");
                request.setAttribute("alertContent", "");
            }
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        } else if (userPath.equals("/index/login")) {
            //System.out.println("masuk bawah");

            String username = (String) request.getParameter("id_user");
            String password = (String) request.getParameter("pass");
            //System.out.println("username= " + username + "," + password);
            boolean isValidUser = um.validateUser(username, password);
            if (isValidUser) {            
                HttpSession session = request.getSession(true);
                session.setAttribute("currentUser", um.select(username));
            }
            response.sendRedirect("/SIOUIbackend/index?success=" + isValidUser);
        } else if (userPath.equals("/index/logout")) {
            HttpSession session = request.getSession(true);
            session.setAttribute("currentUser", null);
            response.sendRedirect("/SIOUIbackend/index?logout=true");
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
