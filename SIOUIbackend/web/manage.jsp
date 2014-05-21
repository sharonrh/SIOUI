<%-- 
    Document   : manage
    Created on : May 21, 2014, 6:59:05 PM
    Author     : ACER
--%>

<%@page import="object.Organisasi"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="col-md-6 col-md-offset-3"> 
                <table class="table table-hover table-striped table-condensed" width="200">
                    <tr>    
                        <th> authorId </th>
                        <th> firstName </th>
                        <th> lastName </th>
                        <th> Action </th>
                    </tr>      

                    <% ArrayList<Organisasi> listOrganisasi = (ArrayList<Organisasi>) request.getAttribute("listOrganisasi");
                        for (Organisasi a : listOrganisasi) {
                    %>

                    <tr>
                        <td> <%= a.getUsername()%> </td>
                        <td> <%= a.getNama_panjang() %> </td>
                        <td> 
                            <form method="post" action="listAuthor.jsp">
                                <button type="submit">delete</button>
                                <input type="hidden" name="act" value="del">
                                <input type="hidden" name="del_id" value="">                                
                            </form>
                        </td>
                    </tr>
                    <%}%>

                </table>
                <p><a href='addAuthor.jsp'><button class="btn btn-success ">Add Author</button></a></p>
                <a href='index.jsp'><button class="btn btn-success">Find Author</button></a>
            </div>
        </div>
    </body>
</html>
