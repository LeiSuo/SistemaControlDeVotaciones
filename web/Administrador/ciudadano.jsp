<%-- 
    Nombre del documento   : ciudadano
    fecha                  : 10-may-2018
    Autor                  : Ulises
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%
    HttpSession sesion=request.getSession();
    if(sesion.getAttribute("nivel")==null){
        response.sendRedirect("../loginAdmin.jsp");
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
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>CRUD ciudadano</title>
    </head>
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
                    <a class="navbar-brand" href="administrador.jsp">Administrador</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Poblacion<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Ciudadano</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="votante.jsp">Votante</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">País<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="departamento.jsp">Departamento</a></li>
                                <li><a href="municipio.jsp">Municipio</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Política<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="diputado.jsp">Diputado</a></li>
                                <li><a href="partidoPolitico.jsp">Partido politico</a></li>
                            </ul>
                        </li>
                        <li><a href="tipoVoto.jsp">Tipo de voto</a></li>
                        <li><a href="usuario.jsp">Usuarios</a></li>
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
                        Formulario ciudadano
                    </h3>
                </div>
                <div class="panel-body">
                    <center>
                    <form class="" action="index.html" method="post">
                        <div class="input-group col-lg-6">
                            <span class="input-group-addon" id="basic-addon1">DUI:&nbsp&nbsp&nbsp&nbsp</span>
                            <input type="text" class="form-control" name="txtDui" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group col-lg-6">
                            <span class="input-group-addon" id="basic-addon1">Nombre:</span>
                            <input type="text" class="form-control" name="txtNombre" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group col-lg-6">
                            <span class="input-group-addon" id="basic-addon1">Apellidos:</span>
                            <input type="text" class="form-control" name="txtApellidos" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group col-lg-6">
                            <label for="cmbMunicipio">Municipio:</label><br>
                            <select class="form-control" name="cmbMunicipio" id="cmbMunicipio" aria-describedby="basic-addon1">
                                <option>1</option>
                            </select>
                        </div>
                        <br>
                        <div class="input-group col-lg-6">
                            <label for="Genero">Genero:</label><br>
                            <label class="radio-inline">
                                  <input type="radio" name="rdbGenero" value="Masculino" >Masculino
                              </label>
                              <label class="radio-inline">
                                  <input type="radio" name="rdbGenero" value="Femenino" >Femenino
                              </label>
                        </div>
                        <br>
                        <div class="input-group col-lg-6">
                            <span class="input-group-addon" id="basic-addon1">Edad:&nbsp&nbsp&nbsp&nbsp</span>
                            <input type="number" step="1" min="18" max="100" value="18" class="form-control" name="txtEdad" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group col-lg-6">
                            <span class="input-group-addon" id="basic-addon1">fecha caducidad(DUI):</span>
                            <input type="date" class="form-control" name="txtFechaCad" aria-describedby="basic-addon1">
                        </div>
                        <div class="input-group col-lg-6">
                            <button type="submit" name="btnRegistrar" class="btn btn-default">Registrar</button>
                            <button type="submit" name="btnModificar" class="btn btn-default">Modificar</button>
                            <button type="submit" name="btnEliminar"  class="btn btn-default">Eliminar</button>
                            <button type="reset"  name="btnLimpiar"  class="btn btn-default">Limpiar</button>
                        </div>
                    </form>
                    </center>
                </div>
                <table>
                    <thead>
                        <tr>
                            <td></td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
                <div class="panel-footer">Panel footer</div>
            </div>
        </div>
        <script src="../js/complemento.js"></script>
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>
