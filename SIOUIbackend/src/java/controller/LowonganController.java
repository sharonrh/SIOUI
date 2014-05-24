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
        String user = (String) session.getAttribute("currentUser");

        if (user == null) {
            response.sendRedirect("/SIOUIbackend/login");
        } // admin nyasar 
        else if (user.equals("admin")) {
            response.sendRedirect("/SIOUIbackend/index");
        } else {
            if (userPath.equals("/lowongan")) {
                if (request.getParameter("act") != null) {
                    String act = request.getParameter("act");
                    if (act.equals("del")) {
                        request.setAttribute("alertType", "alert-success");
                        request.setAttribute("alertContent", "Penghapusan organisasi berhasil dilakukan");
                    } else if (act.equals("add")) {
                        request.setAttribute("alertType", "alert-success");
                        request.setAttribute("alertContent", "Penambahan organisasi berhasil dilakukan");
                    } else {
                        request.setAttribute("alertType", "alert-success");
                        request.setAttribute("alertContent", "Pengubahan organisasi berhasil dilakukan");
                    }
                } else {
                    request.setAttribute("alertType", "hidden");
                    request.setAttribute("alertContent", "");
                }
                ArrayList<Lowongan> listLowongan = lm.selectAll(user);
                request.setAttribute("listLowongan", (Object) listLowongan);
                RequestDispatcher view = request.getRequestDispatcher("lowongan.jsp");
                view.forward(request, response);
            } else if (userPath.equals("/lowongan/add")) {
                String jabatan = request.getParameter("jabatan");
                String judul = request.getParameter("judul");
                int kapasitas = Integer.parseInt(request.getParameter("kapasitas"));
                String tanggal_buka = request.getParameter("tanggal_buka");
                String tanggal_tutup = request.getParameter("tanggal_tutup");
                String deskripsi = request.getParameter("deskripsi");
                int minimum_tahun = Integer.parseInt(request.getParameter("minimum_tahun"));
                double minimum_ipk = Double.parseDouble(request.getParameter("minimum_ipk"));
                String kategori = request.getParameter("kategori");
                lm.addLowongan(new Lowongan(1, user, jabatan,
                        judul, kapasitas, tanggal_buka,
                        tanggal_tutup, minimum_tahun, minimum_ipk, kategori, deskripsi));
                response.sendRedirect("/SIOUIbackend/lowongan?act=add");
            } else if (userPath.equals("/lowongan/edit")) {
                System.out.println(userPath);
                int id = Integer.parseInt(request.getParameter("id"));
                String jabatan = request.getParameter("jabatan");
                String judul = request.getParameter("judul");
                int kapasitas = Integer.parseInt(request.getParameter("kapasitas"));
                String tanggal_buka = request.getParameter("tanggal_buka");
                String tanggal_tutup = request.getParameter("tanggal_tutup");
                String deskripsi = request.getParameter("deskripsi");
                int minimum_tahun = Integer.parseInt(request.getParameter("minimum_tahun"));
                double minimum_ipk = Double.parseDouble(request.getParameter("minimum_ipk"));
                String kategori = request.getParameter("kategori");
                lm.update(new Lowongan(id, user, jabatan,
                        judul, kapasitas, tanggal_buka,
                        tanggal_tutup, minimum_tahun, minimum_ipk, kategori, deskripsi));
                response.sendRedirect("/SIOUIbackend/lowongan?act=edit");
            } else if (userPath.equals("/lowongan/form")) {
                String par = request.getParameter("id");

                if (par != null) {
                    int id = Integer.parseInt(par);
                    Lowongan lw = lm.select(id);
                    request.setAttribute("detailLowongan", lw);
                    request.setAttribute("status", "edit");
                } else {
                    Lowongan lw = new Lowongan();
                    request.setAttribute("detailLowongan", (Object) lw);
                    request.setAttribute("status", "add");
                }
                RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/form-lowongan.jsp");
                view.forward(request, response);
            } else if (userPath.equals("/lowongan/delete")) {
                System.out.println(userPath);
                int id = Integer.parseInt(request.getParameter("id"));
                lm.deleteLowongan(id);
                response.sendRedirect("/SIOUIbackend/lowongan?act=del");
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
