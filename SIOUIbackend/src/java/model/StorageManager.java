/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.EnumSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author Johanes
 */
public class StorageManager {

    enum UploadStatus {

        SUCCESS, FAILED, FAILED_SIZE_TOO_BIG, FAILED_FILE_NOT_FOUND, FAILED_WRONG_FILE_TYPE
    }

    public static String UPLOAD_SUCCESS = UploadStatus.SUCCESS.name();
    public static String UPLOAD_FAILED = UploadStatus.FAILED.name();
    public static String UPLOAD_FAILED_SIZE_TOO_BIG = UploadStatus.FAILED_SIZE_TOO_BIG.name();
    public static String UPLOAD_FAILED_FILE_NOT_FOUND = UploadStatus.FAILED_FILE_NOT_FOUND.name();
    public static String UPLOAD_FAILED_WRONG_FILE_TYPE = UploadStatus.FAILED_WRONG_FILE_TYPE.name();

    public String getFileName(String namaElemenForm, HttpServletRequest request) throws IOException, IllegalStateException, ServletException {
        return getFileName(request.getPart(namaElemenForm));
    }

    /**
     * Menulis sebuah file ke harddisk server
     *
     * @param path path ke file tersebut (tidak termasuk filenya)
     * @param namaElemenForm name dari elemen <input type="file"> di form
     * @param request HTTPServletRequest yang didapat dari servlet
     * @param expectedFileType list ekstensi yang diperbolehkan, tanpa titik
     * @param maxFileSize maksimum ukuran file dalam kilobyte
     * @return status upload file.
     * @throws IOException
     * @throws IllegalStateException
     * @throws ServletException
     */
    public String writeFile(final String path, final String namaElemenForm, HttpServletRequest request, String[] expectedFileType, long maxFileSize) throws IOException, IllegalStateException, ServletException {
        // Create path components to save the file
        final Part filePart = request.getPart(namaElemenForm);
        final String fileName = getFileName(filePart);
        if (fileName.equals("")) {
            return UPLOAD_FAILED_FILE_NOT_FOUND;
        }

        if (filePart.getSize() > maxFileSize * 1024) {
            return UPLOAD_FAILED_SIZE_TOO_BIG;
        }

        OutputStream out = null;
        InputStream filecontent = null;
        //cek file type
        String fileType = fileName.split("\\.")[fileName.split("\\.").length - 1];
        System.out.println("tipe:"+fileType);
        boolean ada = false;
        for (String s : expectedFileType) {
            if (s.equalsIgnoreCase(fileType)) {
                ada = true;
            }
        }
        if (!ada) {
            return UPLOAD_FAILED_WRONG_FILE_TYPE;
        }

        try {
            File file = new File(path);
            file.mkdirs();
            System.out.println("path:"+ path);
            String newName = file.listFiles().length + "." + fileType;
            out = new FileOutputStream(new File(path + File.separator + newName));
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            //jika sampai sini, upload berhasil
            return newName;
        } catch (FileNotFoundException fne) {
            //tidak ada file yang mau di upload
            //lokasi file ditaruh tidak ada
            return StorageManager.UPLOAD_FAILED_FILE_NOT_FOUND;
        } catch (Exception e) {
            //something bad happens here
            return StorageManager.UPLOAD_FAILED;
        } finally {
            //close semua stream
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
        }
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
