package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.OrganizationModel;
import object.Organization;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Johanes
 */
public class Profil extends HttpServlet {

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

        if (userPath.equals("/profil")) {
            Organization org = om.selectFromId("jojoeffe");
            request.setAttribute("organization", (Object) org);
            if (request.getParameter("success") != null && request.getParameter("success").equals("true")) {
                request.setAttribute("alertVisible", "visible");
            } else {
                request.setAttribute("alertVisible", "collapse");
            }

            RequestDispatcher view = request.getRequestDispatcher("profil.jsp");
            view.forward(request, response);
        } else if (userPath.equals("/profil/add")) {
            RequestDispatcher view = request.getRequestDispatcher("profil.jsp");
            view.forward(request, response);

        } else if (userPath.equals("/profil/edit")) {
            String idUser = "jojoeffe";
            int idOrganisasi = 2;
            String namaPanjang = request.getParameter("nama_panjang");
            String namaPendek = request.getParameter("nama_pendek");
            String deskripsi = request.getParameter("deskripsi");
            String visi = request.getParameter("visi");
            String jenis = request.getParameter("jenis");
            String alamat = request.getParameter("alamat");

            Organization o = new Organization(idUser, idOrganisasi, namaPanjang, namaPendek, null, deskripsi, visi, jenis, alamat);
            om.update(o);
/*
            File file;
            int maxFileSize = 5000 * 1024;
            int maxMemSize = 5000 * 1024;
            ServletContext context = getServletContext();
            String filePath = context.getInitParameter("file-upload");

            String contentType = request.getContentType();
            if ((contentType.indexOf("multipart/form-data") >= 0)) {
                
                FileItemFactory factory = new DiskFileItemFactory();
                // maximum size that will be stored in memory
                ((DiskFileItemFactory)factory).setSizeThreshold(maxMemSize);
                // Location to save data that is larger than maxMemSize.
                ((DiskFileItemFactory)factory).setRepository(new File("c:\\temp"));

                // Create a new file upload handler
                ServletFileUpload upload = new ServletFileUpload(factory);
                // maximum file size to be uploaded.
                upload.setSizeMax(maxFileSize);
                try {
                    // Parse the request to get file items.
                    List<FileItem> fileItems = upload.parseRequest(request);

                    // Process the uploaded file items
                    Iterator i = fileItems.iterator();

                    while (i.hasNext()) {
                        FileItem fi = (FileItem) i.next();
                        if (!fi.isFormField()) {
                            // Get the uploaded file parameters
                            String fieldName = fi.getFieldName();
                            String fileName = fi.getName();
                            boolean isInMemory = fi.isInMemory();
                            long sizeInBytes = fi.getSize();
                            // Write the file
                            if (fileName.lastIndexOf("\\") >= 0) {
                                file = new File(filePath
                                        + fileName.substring(fileName.lastIndexOf("\\")));
                            } else {
                                file = new File(filePath
                                        + fileName.substring(fileName.lastIndexOf("\\") + 1));
                            }
                            fi.write(file);
                        }
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } else {
            }
            */

            response.sendRedirect("/SIOUIbackend/profil?success=true");

            /*
             ServletContext context= getServletContext();
             RequestDispatcher rd= context.getRequestDispatcher("/insertServlet");
             rd.forward(request, response);
             */
        } else if (userPath.equals("/profil/success")) {
            Organization org = om.selectFromId("jojoeffe");
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
