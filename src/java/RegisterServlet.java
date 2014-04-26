/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.OrganizationModel;
import object.Organization;

/**
 *
 * @author ACER
 */
@WebServlet(urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        response.setContentType("text/html;charset=UTF-8");
        
        String id_user = session.getAttribute("currentUser").toString();
        String namaPanjang = request.getParameter("nama_panjang");
        String namaPendek = request.getParameter("nama_pendek");
        String deskripsi = request.getParameter("deskripsi");
        String visi = request.getParameter("visi");
        String jenis = request.getParameter("jenis");
        String alamat = request.getParameter("alamat");
        System.out.println(namaPanjang);
        System.out.println(namaPendek);
        System.out.println(deskripsi);
        System.out.println(alamat);
        OrganizationModel om = new OrganizationModel();
        Organization temp;
        temp = om.selectFromId(id_user);
        if(temp == null){
            om.insertOrganizationModel(id_user, om.size()+1, namaPanjang, namaPendek, deskripsi, visi, jenis, alamat);
        } else{
        System.out.println(namaPanjang);
        System.out.println(namaPendek);
        System.out.println(deskripsi);
        System.out.println(alamat);
            om.editOrganizationProfile(id_user, namaPanjang, namaPendek, deskripsi, visi, jenis, alamat);
        }
        // TO-DO : send to admin email
        response.sendRedirect(request.getContextPath() + "/index.jsp");

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
