<%-- 
    Nombre del documento   : votante
    fecha                  : 10-may-2018
    Autor                  : Ulises
--%>

<%@page import="gov.modelo.Votante"%>
<%@page import="java.util.List"%>
<%@page import="gov.modelo.DaoVotante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion=request.getSession();
    if(sesion.getAttribute("nivel")==null){
        response.sendRedirect("../loginAdmin.jsp");
    }else{
        String nivel = sesion.getAttribute("nivel").toString();
        if(!nivel.equals("2")){
            response.sendRedirect("../loginAdmin.jsp");
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Dao Votante</title>
        <%
        if (request.getSession().getAttribute("msj") != null) {
        %>
        <script>
            alert('<%= request.getSession().getAttribute("msj") %>');
        </script>
        <%
            request.getSession().setAttribute("msj",null);
            }
        %>
    </head>
    <%
        DaoVotante daoVot = new DaoVotante();
    %>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="inscriptor.jsp">Inscriptor</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Poblacion<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="ciudadano.jsp">Ciudadano</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#">Votante</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="../loginAdmin.jsp?cerrar=true"> Cerrar sesion</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        Formulario votantes
                    </h3>
                </div>
                <div class="panel-body">
                    <center>
                    <form name="frmVotante" class="" action="../procesarVotante" method="post">
                        <div class="input-group col-lg-6">
                            <span class="input-group-addon" id="basic-addon1">DUI:&nbsp&nbsp&nbsp&nbsp</span>
                            <input type="text" class="form-control" name="txtDui" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group col-lg-6">
                            <span class="input-group-addon" id="basic-addon1">Contraseña:</span>
                            <input type="text" class="form-control" name="txtPassword" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group col-lg-6">
                            <label for="cmbEstado">Estado:</label><br>
                            <select name="cmbEstado" class="form-control" id="cmbEstado" aria-describedby="basic-addon1">
                               <option value="Activo">Activo</option>
                            </select>
                        </div>
                        <br>
                        <div class="input-group col-lg-6">
                            <center>
                            <div class="btn-group">
                                <button type="reset"  name="btnLimpiar"  class="btn btn-default">Limpiar</button>
                                <button type="submit" name="btnRegistrar" class="btn btn-default">Registrar</button>
                            </div>
                            </center>
                        </div>
                    </form>
                    </center>
                </div>
                <div class="panel-footer"><center><strong>Datos votantes</strong></center></div>
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>DUI</th>
                                <th>Nombre</th>
                                <th>Apellidos</th>
                                <th>Genero</th>
                                <th>Municipio</th>
                                <th>Departamento</th>
                                <th>Estado</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<Votante> lst = daoVot.mostrar();
                                for(Votante vot:lst){
                            %>
                            <tr>
                                <td><%= vot.getCiudadano().getDui() %></td>
                                <td><%= vot.getCiudadano().getNombre() %></td>
                                <td><%= vot.getCiudadano().getApellidos() %></td>
                                <td><%= vot.getCiudadano().getGenero() %></td>
                                <td><%= vot.getMunicipio().getNombre() %></td>
                                <td><%= vot.getDepartamento().getNombre() %></td>
                                <td><%= vot.getEstado() %></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script src="../js/complemento.js"></script>
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>
