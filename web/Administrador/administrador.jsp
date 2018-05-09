<%-- 
    Nombre del Document   : administrador
    Versión               : 1.0
    Fecha de creación     : 08-may-2018, 20:26:07
    Autor                 : ulises
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%
    HttpSession sesion=request.getSession();
    if(sesion.getAttribute("nivel")==null){
        response.sendRedirect("../index.jsp");
    }else{
        String nivel = sesion.getAttribute("nivel").toString();
        if(!nivel.equals("1")){
            response.sendRedirect("../loginAdmin.jsp");
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Administrador</a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href=".jsp">Ciudadano</a></li>
                    <li><a href=".jsp">Votante</a></li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#"><%= sesion.getAttribute("nombre") %>
                        <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="../index.jsp?cerrar=true">Cerrar sesion</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
        <script src="../js/complemento.js"></script>
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>
