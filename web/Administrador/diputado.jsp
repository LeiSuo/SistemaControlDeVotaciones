<%-- 
    Nombre del documento   : diputado
    fecha                  : 10-may-2018
    Autor                  : Ulises
--%>

<%@page import="gov.modelo.DaoDiputado"%>
<%@page import="gov.modelo.PartidoPolitico"%>
<%@page import="gov.modelo.DaoPartidoPolitico"%>
<%@page import="gov.modelo.Diputado"%>
<%@page import="java.util.List"%>
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
        <title>CRUD diputado</title>
        <%
            if(request.getSession().getAttribute("msj")!=null){
        %>
        <script>
            alert('<%= request.getSession().getAttribute("msj") %>');
        </script>
        <%
            request.getSession().setAttribute("msj",null);
            }
        %>
        <script  >
            function cargar(id, dui , idPar){
                document.frmDiputado.txtIdDiputado.value=id;
                document.frmDiputado.txtDUI.value=dui;
                document.frmDiputado.cmbPartido.value=idPar;
                $('body,html').animate({
                    scrollTop:'0px'
                });
            }
        </script>
    </head>
    <%
        DaoPartidoPolitico daoPP  = new DaoPartidoPolitico();
        PartidoPolitico pp = new PartidoPolitico();
        DaoDiputado dao = new DaoDiputado();
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
                                <li><a href="#">Diputado</a></li>
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
                        Formulario diputado
                    </h3>
                </div>
                <div class="panel-body">
                    <center>
                    <form class="" name="frmDiputado"  action="../procesarDiputado" method="post" enctype="multipart/form-data">
                        <div class="input-group col-lg-6">
                            <span class="input-group-addon" id="basic-addon1">ID:&nbsp&nbsp&nbsp&nbsp</span>
                            <input type="text" class="form-control" name="txtIdDiputado" aria-describedby="basic-addon1" readonly>
                        </div>
                        <br>
                        <div class="input-group col-lg-6">
                            <span class="input-group-addon" id="basic-addon1">DUI:</span>
                            <input type="text" class="form-control" name="txtDUI" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group col-lg-6">
                            <label for="cmbPartido">Partido:</label><br>
                            <select class="form-control" name="cmbPartido" id="cmbPartido" aria-describedby="basic-addon1">
                                <%
                                    
                                    List<PartidoPolitico> lst2 = daoPP.mostrar();
                                    for(PartidoPolitico par:lst2){
                                %>
                                <option value="<%= par.getIdPartido() %>"><%= par.getNombre() %></option>
                                <%}%>
                            </select>
                        </div>
                        <br>
                        <div class="input-group col-lg-6">
                            <span class="input-group-addon" id="basic-addon1">Seleccionar imagen</span>                 
                            <input type="file" class="form-control" name="fichero" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group col-lg-6">
                            <center>
                            <div class="btn-group">
                                <button type="reset"  name="btnLimpiar"  class="btn btn-default">Limpiar</button>
                                <button type="submit" name="btnEliminar"  class="btn btn-default">Eliminar</button>
                                <button type="submit" name="btnModificar" class="btn btn-default">Modificar datos</button>
                                <button type="submit" name="btnModificar2" class="btn btn-default">Modificar todo</button>
                                <button type="submit" name="btnRegistrar" class="btn btn-default">Registrar</button>
                            </div><br>
                            </center>
                            <sub>*Al presionar modificar datos, modifica los datos sin modificar imagen.</sub><br>
                            <sub>*Al presionar modificar todo, si no insertar imagen para la BD, esta se borrara.</sub>
                        </div>
                    </form>
                    </center>
                </div>
                <div class="panel-footer"><center><strong>Datos diputados</strong></center></div>
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>DUI</th>
                                <th>Nombre</th>
                                <th>Apellidos</th>
                                <th>Partido</th>
                                <th>Imagen</th>
                                <th>Seleccionar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<Diputado> lst = dao.mostrar();
                                for(Diputado dip:lst){
                            %>
                            <tr>
                                <td><%= dip.getIdDiputado() %></td>
                                <td><%= dip.getCiu().getDui() %></td>
                                <td><%= dip.getCiu().getNombre() %></td>
                                <td><%= dip.getCiu().getApellidos() %></td>
                                <td><%= dip.getPartidoPolitico().getNombre() %></td>
                                <td><% if(dip.getBase64Image()!=null){ %>
                                    <img src = "data: image / jpg; base64, <%= dip.getBase64Image() %>" alt="No contiene imagen" height="100px" width="100px"/>
                                <% }else{ %>
                                    No contiene imagen
                                <% } %></td>
                                <td><a href="javascript:cargar(<%= dip.getIdDiputado()%>, <%= dip.getCiu().getDui() %>,<%= dip.getPartidoPolitico().getIdPartido() %>)">Seleccionar</a></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script src="../js/complemento.js"></script>
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>
