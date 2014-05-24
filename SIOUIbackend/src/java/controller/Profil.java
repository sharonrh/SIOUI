package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.OrganisasiModel;
import model.StorageManager;
import object.Organisasi;
import object.User;

/**
 *
 * @author Johanes
 */
@MultipartConfig
public class Profil extends HttpServlet {

    StorageManager storageManager = new StorageManager();

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
        OrganisasiModel om = new OrganisasiModel();
        HttpSession session = request.getSession(true);
        String user = (String) session.getAttribute("currentUser");

        if (user == null) {
            response.sendRedirect("/SIOUIbackend/login");
        } else {
            if (userPath.equals("/profil")) {
                Organisasi org = om.selectFromId(user);
                request.setAttribute("organization", (Object) org);
                if (request.getParameter("success") != null && request.getParameter("success").equals("true")) {
                    request.setAttribute("alertType", "alert-success");
                    request.setAttribute("alertContent", "Update profil organisasi berhasil dilakukan!");
                } else if (request.getParameter("success") != null && request.getParameter("success").equals("false")) {
                    request.setAttribute("alertType", "alert-danger");
                    request.setAttribute("alertContent", "Gambar tidak berhasil di-<i>upload</i>");
                } else if (request.getParameter("success") != null && request.getParameter("success").equals("wrong_file_type")) {
                    request.setAttribute("alertType", "alert-warning");
                    request.setAttribute("alertContent", "Jenis File yang bisa di upload adalah: <b>jpg, jpeg, png, gif</b>");
                } else if (request.getParameter("success") != null && request.getParameter("success").equals("size_too_big")) {
                    request.setAttribute("alertType", "alert-warning");
                    request.setAttribute("alertContent", "Maksimum ukuran File yang bisa di upload adalah: <b>5 MB</b>");
                } else {
                    request.setAttribute("alertType", "hidden");
                    request.setAttribute("alertContent", "");
                }
                RequestDispatcher view = request.getRequestDispatcher("profil.jsp");
                view.forward(request, response);
            } else if (userPath.equals("/profil/add")) {
                RequestDispatcher view = request.getRequestDispatcher("profil.jsp");
                view.forward(request, response);
            } else if (userPath.equals("/profil/edit")) {
                int idOrganisasi = om.selectFromId(user).getId();
                String namaPanjang = request.getParameter("nama_panjang");
                String namaPendek = request.getParameter("nama_pendek");
                String deskripsi = request.getParameter("deskripsi");
                String visi = request.getParameter("visi");
                String jenis = request.getParameter("jenis");
                String alamat = request.getParameter("alamat");

                //proses upload
                String[] expectedFileType = new String[]{"jpg", "png", "jpeg", "gif"};

                String returnValue = "false";
                try {
                    String uploadStatus = storageManager.writeFile("C:\\SIOUI_DATA\\Logo\\" + idOrganisasi + "\\", "file_logo", request, expectedFileType, 5 * 1024);
                    if (uploadStatus.equals(StorageManager.UPLOAD_FAILED_WRONG_FILE_TYPE)) {
                        returnValue = "wrong_file_type";
                        throw new Exception();
                    } else if (uploadStatus.equals(StorageManager.UPLOAD_FAILED_SIZE_TOO_BIG)) {
                        returnValue = "size_too_big";
                        throw new Exception();
                    } else if (uploadStatus.equals(StorageManager.UPLOAD_FAILED_FILE_NOT_FOUND)) {
                        returnValue = "empty";
                    }

                    Organisasi o = new Organisasi(idOrganisasi, user,
                            namaPanjang, namaPendek,
                            uploadStatus,
                            deskripsi, visi, jenis, alamat);
                    if (returnValue.equals("empty")) {
                        om.updateExceptLogo(o);
                    } else {
                        om.update(o);
                    }
                    
                    returnValue = "true";
                    response.sendRedirect("/SIOUIbackend/profil?success=" + returnValue);
                } catch (Exception e) {
                    response.sendRedirect("/SIOUIbackend/profil?success=" + returnValue);
                }

            } else if (userPath.equals("/profil/success")) {
                Organisasi org = om.selectFromId(user);
                request.setAttribute("organization", (Object) org);
                request.setAttribute("alertVisible", "visible");
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
