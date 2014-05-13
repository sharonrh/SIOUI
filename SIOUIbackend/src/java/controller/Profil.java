package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.OrganizationModel;
import model.StorageManager;
import object.Organization;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Johanes
 */
@MultipartConfig
public class Profil extends HttpServlet {

    StorageManager storageManager = new StorageManager();
    /*
     @Override
     public void init() throws ServletException{
     DiskFileItemFactory fileFactory = new DiskFileItemFactory();
     File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
     fileFactory.setRepository(filesDir);
     this.uploader = new ServletFileUpload(fileFactory);
     }
     */

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
        OrganizationModel om = new OrganizationModel();
        HttpSession session = request.getSession(true);
        String username = session.getAttribute("currentUser").toString();

        if (userPath.equals("/profil")) {
            Organization org = om.selectFromId(username);
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
            int idOrganisasi = 1;
            System.out.println(userPath);
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
                }

                Organization o = new Organization(idOrganisasi, username,
                        namaPanjang, namaPendek,
                        storageManager.getFileName("file_logo", request),
                        deskripsi, visi, jenis, alamat);
                om.update(o);

                returnValue = "true";
                response.sendRedirect("/SIOUIbackend/profil?success=" + returnValue);
            } catch (Exception e) {
                response.sendRedirect("/SIOUIbackend/profil?success=" + returnValue);
            }

            /*
             ServletContext context= getServletContext();
             RequestDispatcher rd= context.getRequestDispatcher("/insertServlet");
             rd.forward(request, response);
             */
        } else if (userPath.equals("/profil/success")) {
            Organization org = om.selectFromId(username);
            request.setAttribute("organization", (Object) org);
            request.setAttribute("alertVisible", "visible");

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
