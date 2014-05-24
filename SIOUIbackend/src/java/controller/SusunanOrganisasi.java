/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.JabatanModel;
import model.OrganisasiModel;
import object.Jabatan;
import object.Organisasi;

/**
 *
 * @author Johanes
 */
public class SusunanOrganisasi extends HttpServlet {

    OrganisasiModel om = new OrganisasiModel();
    JabatanModel jm = new JabatanModel();

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
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("currentUser");
        Organisasi org = om.selectFromId(user);

        String userPath = request.getServletPath();
        //response.getWriter().print(userPath);
        if (user == null) {
            response.sendRedirect("/SIOUIbackend/login");
        } // admin nyasar 
        else if (user.equals("admin")) {
            response.sendRedirect("/SIOUIbackend/index");
        } else {
            if (userPath.equals("/susunanorganisasi")) {
                List<Jabatan> jabatans = jm.selectByIdOrganisasi("" + org.getId());

                request.setAttribute("jabatans", jabatans);

                RequestDispatcher view = request.getRequestDispatcher("jabatan.jsp");

                view.forward(request, response);
            } else if (userPath.equals("/susunanorganisasi/add")) {
                Jabatan jab = null;
                request.setAttribute("jabatan", jab);
                request.setAttribute("role", "add");
                request.setAttribute("formAction", request.getContextPath() + "/susunanorganisasi/create");
                request.setAttribute("title", "Add Jabatan");

                RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jabatanform.jsp");
                view.forward(request, response);
            } else if (userPath.equals("/susunanorganisasi/edit")) {
                String id = request.getParameter("id");
                String status = request.getParameter("status");

                if (status != null && !status.equals("")) {
                    request.setAttribute("notif", "Data berhasil disimpan!");
                }

                Jabatan jab = jm.select(id);
                request.setAttribute("jabatan", jab);
                request.setAttribute("role", "add");
                request.setAttribute("formAction", request.getContextPath() + "/susunanorganisasi/update?id=" + id);
                request.setAttribute("title", "Add Jabatan");

                RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jabatanform.jsp");
                view.forward(request, response);
            } else if (userPath.equals("/susunanorganisasi/create")) {
                Jabatan jab = new Jabatan("" + org.getId(), request.getParameter("nama"), request.getParameter("jabatan"));
                jm.insert(jab);
                response.sendRedirect(request.getContextPath() + "/susunanorganisasi");
            } else if (userPath.equals("/susunanorganisasi/update")) {
                Object objId = request.getParameter("id");
                if (objId == null) {
                    //redirect here
                }
                String id = objId.toString();
                Jabatan jab = new Jabatan("" + org.getId(), request.getParameter("nama"), request.getParameter("jabatan"));
                jab.setId(id);
                jm.update(jab);
                response.sendRedirect(request.getContextPath() + "/susunanorganisasi");
            } else if (userPath.equals("/susunanorganisasi/delete")) {
                Object objId = request.getParameter("id");
                if (objId == null) {
                    //redirect here
                }
                String id = objId.toString();
                jm.delete(id);
                response.sendRedirect(request.getContextPath() + "/susunanorganisasi");
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
