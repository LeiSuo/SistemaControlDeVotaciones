<%-- 
    Nombre del documento   : usuarios
    fecha                  : 10-may-2018
    Autor                  : Ulises
--%>

<%@page import="gov.modelo.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="gov.modelo.DaoUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
    if(sesion.getAttribute("nivel")==null){
        response.sendRedirect("../loginAdmin.jsp");
    }else{
        String nivel = sesion.getAttribute("nivel").toString();
        if (!nivel.equals("1")) {
            response.sendRedirect("../loginLocal.jsp");
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>CRUD usuarios</title>
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
        <script>
            function cargar(id, nombre, usuario, pass,nivel){
                document.frmUsuario.txtIdUsuario.value=id;
                document.frmUsuario.txtNombre.value=nombre;
                document.frmUsuario.txtUsuario.value=usuario;
                document.frmUsuario.txtPassword.value=pass;
                document.frmUsuario.cmbNivel.value=nivel;
                $('body,html').animate({
                    scrollTop:'0px'
                });
            }
        </script>
    </head>
    <%
        DaoUsuario daoUs = new DaoUsuario();
    %>
    <body>
        <nav class="navbar navbar-default">
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
                                <li><a href="ciudadano.jsp">Ciudadano</a></li>
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
                        <li><a href="#">Usuarios</a></li>
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
                        Formulario usuarios del sistema
                    </h3>
                </div>
                <div class="panel-body">
                    <center>
                    <form class="" name="frmUsuario" action="../procesarUsuarios" method="post">
                        <div class="input-group col-lg-6">
                            <span class="input-group-addon" id="basic-addon1">ID:&nbsp&nbsp&nbsp&nbsp</span>
                            <input type="text" class="form-control" name="txtIdUsuario" aria-describedby="basic-addon1" readonly="">
                        </div>
                        <br>
                        <div class="input-group col-lg-6">
                            <span class="input-group-addon" id="basic-addon1">Nombre:</span>
                            <input type="text" class="form-control" name="txtNombre" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group col-lg-6">
                            <span class="input-group-addon" id="basic-addon1">Nombre de usuario:</span>
                            <input type="text" class="form-control" name="txtUsuario" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group col-lg-6">
                            <span class="input-group-addon" id="basic-addon1">Contraseña: </span>
                            <input type="text" class="form-control" name="txtPassword" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group col-lg-6">
                            <label for="cmbNivel">Nivel:</label><br>
                            <select name="cmbNivel" class="form-control" id="cmbNivel" aria-describedby="basic-addon1">
                               <option value="1">Administrador</option>
                               <option value="2">Inscriptor</option>
                            </select>
                        </div>
                        <br>
                        <div class="input-group col-lg-6">
                            <center>
                            <div class="btn-group">
                                <button type="reset"  name="btnLimpiar"  class="btn btn-default">Limpiar</button>
                                <button type="submit" name="btnEliminar"  class="btn btn-default">Eliminar</button>
                                <button type="submit" name="btnModificar" class="btn btn-default">Modificar</button>
                                <button type="submit" name="btnRegistrar1" class="btn btn-default">Registrar</button>
                            </div>
                            </center>
                        </div>
                    </form>
                    </center>
                </div>
                <div class="panel-footer"><center><strong>Datos usuarios del sistema</strong></center></div>
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Nombre usuario</th>
                                <th>contraseña</th>
                                <th>Nivel</th>
                                <th>Seleccionar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                               List<Usuario> lst = daoUs.mostrar();
                               for(Usuario us:lst){
                            %>
                            <tr>
                                <td><%= us.getIdUsuario() %></td>
                                <td><%= us.getNombre() %></td>
                                <td><%= us.getUsuario() %></td>
                                <td><%= us.getPassword() %></td>
                                <%if(us.getNivel()==1){%>
                                <td>Administrador</td>
                                <%}else{%>
                                <td>Inscriptor</td>
                                <%}%>
                                <td><a href="javascript:cargar(<%= us.getIdUsuario()%>, '<%= us.getNombre() %>','<%= us.getUsuario()%>','<%= us.getPassword() %>',<%= us.getNivel() %>)">Seleccionar</a></td>
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
