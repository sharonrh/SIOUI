package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import object.*;
import model.OrganisasiModel;
import object.Organisasi;
import javax.servlet.http.HttpSession;
import model.GalleryModel;
import model.StorageManager;

/**
 *
 * @author Johanes
 */
@MultipartConfig
public class Album extends HttpServlet {
<<<<<<< HEAD
=======

>>>>>>> cb4859e3c610c3164415ca83f5f03a8d90cc4637
    OrganisasiModel om = new OrganisasiModel();
    GalleryModel gm = new GalleryModel();
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
        HttpSession session = request.getSession();
<<<<<<< HEAD
        User user = (User)session.getAttribute("currentUser");
        Organisasi org = om.selectFromId(user.getUsername());
        
=======
        User user = (User) session.getAttribute("currentUser");
        Organisasi org = om.selectFromId(user.getUsername());

>>>>>>> cb4859e3c610c3164415ca83f5f03a8d90cc4637
        String userPath = request.getServletPath();
        //response.getWriter().print(userPath);

        if (userPath.equals("/album")) {
            List<object.Album> a = gm.selectAlbumByOrganization(org.getId());
            request.setAttribute("albums", (Object) a);

            RequestDispatcher view = request.getRequestDispatcher("album.jsp");
            view.forward(request, response);
        } else if (userPath.equals("/album/add")) {
            //bagian ini hanya menampilkan form
            request.setAttribute("title", (Object) "Create Album");
            request.setAttribute("formAction1", (Object) (request.getContextPath() + "/album/create"));
            request.setAttribute("formAction2", request.getContextPath() + "/album/uploadimage");
            request.setAttribute("formAction3", request.getContextPath() + "/album/editimagedesc");
            request.setAttribute("role", (Object) "create");
            request.setAttribute("notif", null);

            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/albumform.jsp");
            view.forward(request, response);

        } else if (userPath.equals("/album/edit")) {
            String id = request.getParameter("id");
            String status = request.getParameter("status");

            if (status != null && !status.equals("")) {
                request.setAttribute("notif", "Data berhasil disimpan!");
            }

            object.Album album = gm.getSingleAlbum(Integer.parseInt(id));

            request.setAttribute("album", album);
            request.setAttribute("title", "Update Album");
            request.setAttribute("role", "edit");
            request.setAttribute("formAction1", request.getContextPath() + "/album/updatealbuminfo?id=" + album.getId());
            request.setAttribute("formAction2", request.getContextPath() + "/album/uploadimage?id=" + album.getId());
            request.setAttribute("formAction3", request.getContextPath() + "/album/editimagedesc?id=" + album.getId());

            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/albumform.jsp");
            view.forward(request, response);
        } else if (userPath.equals("/album/create")) {
            object.Album a = new object.Album("" + org.getId(), request.getParameter("nama-album"), request.getParameter("deskripsi-album"));
            int lastID = gm.insertAlbum(a);
            response.sendRedirect(request.getContextPath() + "/album/edit?id=" + lastID + "&status=sukses");
        } else if (userPath.equals("/album/updatealbuminfo")) {
            object.Album a = new object.Album("" + org.getId(), request.getParameter("nama-album"), request.getParameter("deskripsi-album"));
            a.setId(request.getParameter("id"));
            gm.updateAlbum(a);
            response.sendRedirect(request.getContextPath() + "/album/edit?id=" + a.getId() + "&status=sukses");
        } else if (userPath.equals("/album/uploadimage")) {
            //dapetin dulu albumnya
            String id = request.getParameter("id");
            if (id != null && !id.equals("")) {
                object.Album a = gm.getSingleAlbum(Integer.parseInt(id));
                String fileName = storageManager.getFileName("file_gambar", request);
                
                //proses upload
                String[] expectedFileType = new String[]{"jpg", "png", "jpeg", "gif"};

                String returnValue = "false";
                try {
                    String uploadStatus = storageManager.writeFile("C:\\SIOUI_DATA\\Album\\" + a.getId_organisasi() + "\\" + a.getId() + "\\", "file_gambar", request, expectedFileType, 5 * 1024);
                    if (uploadStatus.equals(StorageManager.UPLOAD_FAILED_WRONG_FILE_TYPE)) {
                        returnValue = "wrong_file_type";
                        throw new Exception();
                    } else if (uploadStatus.equals(StorageManager.UPLOAD_FAILED_SIZE_TOO_BIG)) {
                        returnValue = "size_too_big";
                        throw new Exception();
                    }

                    returnValue = "true";
                    
                    object.Image img = new object.Image(id, fileName, request.getParameter("deskripsi"));
                    a.addImage(img);
                    gm.updateAlbum(a);
                    
                    response.sendRedirect(request.getContextPath() + "/album/edit?id=" + a.getId() + "&status=sukses");
                } catch (Exception e) {
                    response.sendRedirect(request.getContextPath() + "/album/edit?id=" + a.getId() + "&status=gagal");
                }

            } else {
                response.sendRedirect(request.getContextPath() + "/album/");
            }

        } else if (userPath.equals("/album/editimagedesc")) {

        } else if (userPath.equals("/album/delete")){
            
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
