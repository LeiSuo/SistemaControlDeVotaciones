<%-- 
    Document   : login
    Created on : 08-may-2018, 16:53:23
    Author     : Ulises
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%
    HttpSession sesion=request.getSession();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login votante</title>
        <%
        if (sesion.getAttribute("msj") != null){%>
        <script>
            alert('<%= request.getSession().getAttribute("msj") %>');
        </script>
        <%  request.getSession().setAttribute("msj",null);
        }%>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="validarVotante" method="post">
            <div class="login">
                <input type="text" placeholder="Numero de DUI" name="txtDUI">  
                <input type="password" placeholder="password" name="txtPassword">
                <input type="submit" name="btnIngresar" value="Sign In">
            </div>
            <div class="shadow"></div>
        </form>
    </body>
</html>
<%
    String estado = (String) sesion.getAttribute("estado");
    if(estado != null){
        response.sendRedirect("Votante/votante.jsp");   
    }

    if(request.getParameter("cerrar")!=null){
        sesion.invalidate();
    }
%>