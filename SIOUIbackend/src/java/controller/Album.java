package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.GalleryModel;
import model.OrganisasiModel;
import model.StorageManager;
import object.*;
import object.Organisasi;

/**
 *
 * @author Johanes
 */
@MultipartConfig
public class Album extends HttpServlet {

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
        String user = (String) session.getAttribute("currentUser");

        String userPath = request.getServletPath();
        //response.getWriter().print(userPath);
        try {
            Organisasi org = om.selectFromId(user);
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

                if (status != null && status.equals("sukses")) {
                    request.setAttribute("notif", "Data berhasil disimpan!");
                } else if (status != null && status.equals("wrong_file_type")) {
                    request.setAttribute("notif", "Jenis File yang bisa di upload adalah: <b>jpg, jpeg, png, gif</b>");
                    request.setAttribute("status", "warning");
                } else if (status != null && status.equals("size_too_big")) {
                    request.setAttribute("notif", "Maksimum ukuran File yang bisa di upload adalah: <b>5 MB</b>");
                    request.setAttribute("status", "warning");
                } else if (status != null && status.equals("file_not_exist")) {
                    request.setAttribute("notif", "Gambar tidak ada!");
                    request.setAttribute("status", "warning");
                }
                object.Album album = gm.getSingleAlbum(Integer.parseInt(id));

                request.setAttribute("album", album);
                request.setAttribute("title", "Update Album");
                request.setAttribute("role", "edit");
                request.setAttribute("formAction1", request.getContextPath() + "/album/updatealbuminfo?id=" + album.getId());
                request.setAttribute("formAction2", request.getContextPath() + "/album/uploadimage?id=" + album.getId());
                request.setAttribute("formAction3", request.getContextPath() + "/album/editimagedesc?id=" + album.getId());
                request.setAttribute("formAction4", request.getContextPath() + "/album/deleteimage?id=" + album.getId());

                RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/albumform.jsp");
                view.forward(request, response);
            } else if (userPath.equals("/album/create")) {
                object.Album a = new object.Album("" + org.getId(), request.getParameter("nama-album"), request.getParameter("deskripsi-album"));
                gm.insertAlbum(a);
                object.Album lastInserted = gm.getLastInsertedAlbum();
                response.sendRedirect(request.getContextPath() + "/album/edit?id=" + lastInserted.getId() + "&status=sukses");
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
                    String returnValue = "";
                    try {

                        String uploadStatus = storageManager.writeFile("C:\\SIOUI_DATA\\Album\\" + a.getId_organisasi() + "\\" + a.getId() + "\\", "file_gambar", request, expectedFileType, 5 * 1024);
                        if (uploadStatus.equals(StorageManager.UPLOAD_FAILED_WRONG_FILE_TYPE)) {
                            returnValue = "wrong_file_type";
                            throw new Exception();
                        } else if (uploadStatus.equals(StorageManager.UPLOAD_FAILED_SIZE_TOO_BIG)) {
                            returnValue = "size_too_big";
                            throw new Exception();
                        } else if (uploadStatus.equals(StorageManager.UPLOAD_FAILED_FILE_NOT_FOUND)) {
                            returnValue = "file_not_exist";
                            throw new Exception();
                        }

                        object.Image img = new object.Image(id, fileName, request.getParameter("deskripsi"));
                        a.addImage(img);
                        gm.updateAlbum(a);

                        response.sendRedirect(request.getContextPath() + "/album/edit?id=" + a.getId() + "&status=sukses");
                    } catch (Exception e) {
                        response.sendRedirect(request.getContextPath() + "/album/edit?id=" + a.getId() + "&status=" + returnValue);
                    }

                } else {
                    response.sendRedirect(request.getContextPath() + "/album");
                }

            } else if (userPath.equals("/album/editimagedesc")) {
                Object objId = request.getParameter("id");
                String id = objId.toString();

                object.Album a = gm.getSingleAlbum(Integer.parseInt(id));

                for (Image img : a.getImages()) {
                    Object objDesc = request.getParameter("imgdesc_" + img.getId());
                    if (objDesc != null) {
                        img.setDescription(objDesc.toString());
                        gm.updateImage(img);
                    }
                }
                response.sendRedirect(request.getContextPath() + "/album/edit?id=" + a.getId() + "&status=sukses");
            } else if (userPath.equals("/album/deleteimage")) {
                ArrayList<String> toDelete = new ArrayList<String>();

                Object objId = request.getParameter("id");
                String id = objId.toString();
                object.Album a = gm.getSingleAlbum(Integer.parseInt(id));

                for (Image img : a.getImages()) {
                    Object objDelete = request.getParameter("imgdelete_" + img.getId());
                    if (objDelete != null) {
                        toDelete.add(img.getId());
                    }
                }

                for (String td : toDelete) {
                    gm.deleteImage(td);
                }

                response.sendRedirect(request.getContextPath() + "/album/edit?id=" + a.getId() + "&status=sukses");
            } else if (userPath.equals("/album/delete")) {
                Object objId = request.getParameter("id");
                if (objId == null) {
                    response.sendRedirect("/album");
                }
                String id = objId.toString();
                gm.deleteAlbum(id);
                response.sendRedirect(request.getContextPath() + "/album");
            }
        } catch (NullPointerException e) {
            response.sendRedirect("/SIOUIbackend/login");
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
