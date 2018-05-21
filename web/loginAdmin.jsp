<%--
    Document   : loginAdmin
    Created on : 08-may-2018, 16:53:32
    Author     : Ulises
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login administrador</title>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="procesarUsuario" method="post">
            <div class="login">
                <input type="text" placeholder="Username" name="txtUsuario">  
                <input type="password" placeholder="password" name="txtPassword">
                <input type="submit" name="btnIngresar" value="Sign In">
            </div>
            <div class="shadow"></div>
        </form>
    </body>
</html>
<%
    HttpSession sesion=request.getSession();
    int nivel=0;
    if(request.getAttribute("nivel")!=null){
        nivel=(Integer) request.getAttribute("nivel");
        if(nivel==1){
            sesion.setAttribute("nombre",request.getAttribute("nombre"));
            sesion.setAttribute("nivel", request.getAttribute("nivel"));
            response.sendRedirect("Administrador/administrador.jsp");
        }else if(nivel==2){
            sesion.setAttribute("nombre", request.getAttribute("nombre"));
            sesion.setAttribute("nivel", request.getAttribute("nivel"));
            response.sendRedirect("Inscriptor/inscriptor.jsp");
        }
    }
    if(request.getParameter("cerrar")!=null){
        sesion.invalidate();
    }
%>
