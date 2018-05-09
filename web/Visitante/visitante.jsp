<%-- 
    Nombre del Document   : visitante
    Versión               : 1.0
    Fecha de creación     : 08-may-2018, 20:37:47
    Autor                 : ulises
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%
    HttpSession sesion=request.getSession();
    if(sesion.getAttribute("nivel")==null){
        response.sendRedirect("../index.jsp");
    }else{
        String nivel = sesion.getAttribute("nivel").toString();
        if(!nivel.equals("3")){
            response.sendRedirect("../login.jsp");
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
