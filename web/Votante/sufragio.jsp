<%-- 
    Nombre del documento   : sufragio
    fecha                  : 22-may-2018
    Autor                  : Ulises
--%>

<%@page import="gov.modelo.Ciudadano"%>
<%@page import="gov.modelo.Departamento"%>
<%@page import="gov.modelo.Votante"%>
<%@page import="gov.modelo.Diputado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="gov.modelo.DaoPartidoPolitico"%>
<%@page import="gov.modelo.DaoDiputado"%>
<%@page import="gov.modelo.PartidoPolitico"%>
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
        <title>Hoja de votación</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/estilo2.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        DaoPartidoPolitico daoPart = new DaoPartidoPolitico();
        DaoDiputado daoDip = new DaoDiputado();
        Votante vot = new Votante();
        Departamento dep = new Departamento();
        Ciudadano ciu = new Ciudadano();
        Diputado di = new Diputado();
    %>
    <body>
        <div class="container-fluid">
            <div class="panel panel-info">
            <div class="panel-heading"><center><H3>ELECCIÓN DE DIPUTADOS Y DIPUTADAS DE LA ASAMBLEA LEGISLATIVA</h3></center></div>
            <form class="" name="hojaVotacion" action="" method="post">
                 <div class="table-responsive">
                    <table class="table">
                        <thead>
                            <tr>
                                <%
                                    int idDep =  (Integer) request.getSession().getAttribute("idDep");
                                    dep.setIdDepartamento(idDep);
                                    ciu.setDepartamento(dep);
                                    vot.setCiudadano(ciu);
                                    List<PartidoPolitico> lstPart = daoPart.mostrarPV(vot);
                                    for(PartidoPolitico par:lstPart){
                                %>
                                <th style="width: 500px">
                                    <div class="casilla">
                                        <center>
                                            <%if(par.getBase64Image()!=null){ %>
                                            <img src = "data: image / jpg; base64, <%= par.getBase64Image() %>" alt="Sin imagen" height="70px" width="140px"/>
                                            <% } %>
                                        </center>
                                        <div class="cajaText">
                                            <p align="center" class="texto"><%= par.getNombre() %></p>
                                        </div>
                                    </div>
                                </th>
                                <%
                                    }
                                %>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <%
                                    dep.setIdDepartamento(idDep);
                                    ciu.setDepartamento(dep);
                                    di.setCiu(ciu);
                                    for(PartidoPolitico par2:lstPart){
                                %>
                                <td>
                                    <table>
                                <%
                                    di.setPartidoPolitico(par2);
                                    List<Diputado> lstDip = daoDip.mostrarDipEl(di);
                                    for(Diputado dip:lstDip){
                                %>
                                        <tr>
                                            <td>
                                              <th style="width: 500px">
                                                <div class="casilla">
                                                    <%if(dip.getBase64Image()!=null){ %>
                                                    <div class="cajaText2"><img src = "data: image / jpg; base64, <%= dip.getBase64Image() %>" alt="Sin imagen" height="90px" width="70px"/>
                                                    </div>
                                                        <% } %>
                                                    <div class="cajaText2">
                                                        <p align="center" class="texto"><%= dip.getCiu().getNombre() %></p>
                                                        <p align="center" class="texto"><%= dip.getCiu().getApellidos()%></p>
                                                        <input type="checkbox" align="center">
                                                    </div>
                                                </div>
                                            </th>  
                                            </td>
                                        </tr>
                                <%
                                    }
                                %>
                                    </table>
                                </td>
                                <%
                                    }
                                %>
                            </tr>
                        </tbody>
                    </table>
                </div> 
            </form>
          </div>
            
            
        </div>
        
        <script src="../js/complemento.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
