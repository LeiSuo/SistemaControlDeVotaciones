<%-- 
    Nombre del documento   : votante
    fecha                  : 22-may-2018
    Autor                  : Ulises
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%
    HttpSession sesion=request.getSession();
    if(sesion.getAttribute("estado")==null){
        response.sendRedirect("../login.jsp");
    }else{
        String estado = sesion.getAttribute("estado").toString();
        if(!estado.equals("Activo")){
            response.sendRedirect("../login.jsp");
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instrucciones votante</title>
    </head>
    <body>
        
    </body>
</html>
