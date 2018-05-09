<%--
    Document   : loginAdmin
    Created on : 08-may-2018, 16:53:32
    Author     : SCOR64
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login administrador</title>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <script src="js/login.js" type="text/javascript"></script>
    </head>
    <body>
        <form action="procesarLogin" method="post">
            <div class="login">
                <input type="text" placeholder="Username" id="username">  
                <input type="password" placeholder="password" id="password">
                <input type="submit" value="Sign In">
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
        }
    }
    if(request.getParameter("cerrar")!=null){
        sesion.invalidate();
    }
%>
