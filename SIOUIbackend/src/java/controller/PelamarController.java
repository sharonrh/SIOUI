/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.LowonganModel;
import model.NotifikasiModel;
import model.PelamarModel;
import object.Pelamar;
import webservice.BasicInformation;
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
        LowonganModel lm = new LowonganModel();
        NotifikasiModel nm = new NotifikasiModel();
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
                if (request.getParameter("creg") != null && request.getParameter("creg").equals("success")) {
                    request.setAttribute("alertContent", "Recruitment sudah dikirimkan!");
                } else {
                    request.setAttribute("alertContent", null);
                }

                String status = request.getParameter("status_recruitment") == null
                        ? "wait" : request.getParameter("status_recruitment");
                String jenis = request.getParameter("jenis_recruitment") == null
                        ? "open" : request.getParameter("jenis_recruitment");

                ArrayList<Pelamar> listPelamar = pm.selectPelamarJenisStatus(id, jenis, status);
                request.setAttribute("status_recruitment", (Object) status);
                request.setAttribute("jenis_recruitment", (Object) jenis);
                request.setAttribute("listPelamar", (Object) listPelamar);

                if (jenis.equals("close")) {
                    String kategori = lm.getKategori(id);
                    List<BasicInformation> listRekomendasi = getRecommendedUser(kategori);
                    System.out.println("jumlah rekomen=" + listRekomendasi.size());
                    request.setAttribute("listRekomendasi", (Object) listRekomendasi);
                }
                RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/daftar-pelamar.jsp");
                view.forward(request, response);
            } else if (userPath.equals("/pelamar/detail")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Pelamar p = pm.getPelamarById(id);
                response.reset();
                response.setContentType("application/pdf");
                response.setHeader("Content-disposition", "attachment; filename=\"CV_" + p.getUsername() + ".pdf\"");
                OutputStream out = response.getOutputStream();
                try {
                    System.out.println("idcv=" + p.getId_cv());
                    byte[] result = getCV("" + p.getId_cv());

                    OutputStream output = response.getOutputStream();
                    output.write(result);
                    output.close();
                } catch (IOException ex) {

                } finally {
                    out.close();
                    response.sendRedirect("/SIOUIbackend/pelamar");
                }
            } else if (userPath.equals("/pelamar/status")) {
                // case approve
                if (request.getParameter("act") != null) {
                    if (request.getParameter("act").equals("accept")) {
                        pm.updateStatusLamaran(Integer.parseInt(request.getParameter("id")), true);
                    } // case reject
                    else if (request.getParameter("act") != null && request.getParameter("act").equals("reject")) {
                        pm.updateStatusLamaran(Integer.parseInt(request.getParameter("id")), false);
                    }
                    Pelamar p = pm.getPelamarById(Integer.parseInt(request.getParameter("id")));
                    nm.addNotif(Integer.parseInt(request.getParameter("id")), p.getUsername(), "open");
                }
                response.sendRedirect("/SIOUIbackend/pelamar");
            } else if (userPath.equals("/pelamar/recruit")) {
                if (request.getParameter("name") != null) {
                    int idLowongan = (int) session.getAttribute("currentLowongan");
                    String username = request.getParameter("name");
                    pm.cregPelamar(idLowongan, username);
                    //Pelamar p = pm.getPelamarByUsername(username);
                    //nm.addNotif(p.getId(), username, "close");
                    response.sendRedirect("/SIOUIbackend/pelamar?creg=success");
                }
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

    private static java.util.List<webservice.BasicInformation> getRecommendedUser(java.lang.String category) {
        webservice.SivimuWebService_Service service = new webservice.SivimuWebService_Service();
        webservice.SivimuWebService port = service.getSivimuWebServicePort();
        return port.getRecommendedUser(category);
    }

    private static byte[] getCV(java.lang.String arg0) {
        webservice.SivimuWebService_Service service = new webservice.SivimuWebService_Service();
        webservice.SivimuWebService port = service.getSivimuWebServicePort();
        return port.getCV(arg0);
    }

}
