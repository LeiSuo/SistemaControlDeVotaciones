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
         <%
        DaoPartidoPolitico daoPart = new DaoPartidoPolitico();
        DaoDiputado daoDip = new DaoDiputado();
        Votante vot = new Votante();
        Departamento dep = new Departamento();
        Ciudadano ciu = new Ciudadano();
        Diputado di = new Diputado();
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hoja de votación</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/estilo2.css" rel="stylesheet" type="text/css"/>
        <link href="../css/sufragio.css" rel="stylesheet" type="text/css"/>
        <script>
            function sendForm() {
                var valido = true;
                var conteoCruzado=0; //Contador de politicos seleccionados
                var conteoPartido=0; //Contador de banderas seleccionadas
                var votoNulo=0; //Verfica si hay voto nulo
                var txError="";
                //Inserccion dinamica de validacion de seleccion de checkbox para partido politico
                <%
                    int idDep =  (Integer) request.getSession().getAttribute("idDep");
                    dep.setIdDepartamento(idDep);
                    ciu.setDepartamento(dep);
                    vot.setCiudadano(ciu);
                    List<PartidoPolitico> lstPart = daoPart.mostrarPV(vot);
                    for(PartidoPolitico par:lstPart){
                %>
                if(document.getElementById('<%= par.getIdPartido() %>').checked){
                    conteoPartido++;
                }
                <% }
                    //Inserccion dinamica de validacion de seleccion de checkbox para diputados
                    dep.setIdDepartamento(idDep);
                    ciu.setDepartamento(dep);
                    di.setCiu(ciu);
                    for(PartidoPolitico par2:lstPart){
                        di.setPartidoPolitico(par2);
                        List<Diputado> lstDip = daoDip.mostrarDipEl(di);
                        for(Diputado dip:lstDip){
                %>
                if(document.getElementById('<%= dip.getCiu().getDui() %>').checked){
                    conteoCruzado++;
                }
                <%
                        }
                    }
                %>    
                //conteo de votos por diputado
                if(conteoCruzado>25){
                    votoNulo++;
                    txError="<div class='alert alert-danger' role='alert'>El total de diputados seleccionados sobrepasa el limite permitido</div>";
                }
                //Conteo de votos por partido
                if(conteoPartido>2){
                    votoNulo++;
                    txError="<div class='alert alert-danger' role='alert'>Se han marcado dos o más banderas de partidos</div>";
                }
                //conteo de votos para partido  y diputados
                if(conteoPartido>2 && conteoCruzado>1){
                    txError="<div class='alert alert-danger' role='alert'>Se ha marcado la bandera de un partido y además una o más candidaturas de otros partidos</div>";
                }
                
                $("#resultado").html(""); //limpieza del elemento para posteriormente agregar o no notificación
                
                //Verificacion de error
                if(votoNulo==1){
                    console.log("Votos por bandera:"+conteoPartido);
                    console.log("votos por diputado:"+conteoCruzado);
                    $("#resultado").html("<h4 class='color-white'>Error: Voto nulo</h4>\n\
                    <br><h3>"+txError+"</h3>");
                    valido=false;
                }
                //Verificacion si el voto esta vacio
                if(votoNulo<1 && conteoPartido<1 && conteoCruzado<1){
                    $("#resultado").html("<div class='alert alert-info'>No ha efectuado su voto</div>");
                    valido=false;
                }
                //Validacion de envio o correccion de voto    
                if (valido) {
                    console.log("Validacion aceptada");
                  //document.getElementById("hojaVotacion").submit();
                } else {
                    document.getElementById("hojaVotacion").reset();
                    $('#modalMuestrate').modal('show');
                }
            }
        </script>
    </head>
    <body>
        <div class="container-fluid">
            <div class="modal fade" id="modalMuestrate" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Resultado</h4>
                        </div>
                        <div class="modal-body">
                            <p id="resultado">
                                
                            </p>
                        </div>
                        <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel panel-info">
            <div class="panel-heading"><center><H3>ELECCIÓN DE DIPUTADOS Y DIPUTADAS DE LA ASAMBLEA LEGISLATIVA</h3></center></div>
            <form class="" name="hojaVotacion" action="" method="post" id="hojaVotacion">
                 <div class="table-responsive">
                    <table class="table">
                        <thead>
                            <tr>
                                <%
                                    dep.setIdDepartamento(idDep);
                                    ciu.setDepartamento(dep);
                                    vot.setCiudadano(ciu);
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
                                            <div align="center" class="texto"><%= par.getNombre() %></div>
                                            <center><input type="checkbox" align="center" id="<%= par.getIdPartido() %>"></center>
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
                                                        <input type="checkbox" align="center" id="<%= dip.getCiu().getDui() %>">
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
            <center>
                <button onclick="javascript:sendForm();" class="btn btn-second" data-toggle="modal" data-target="#myModal">votar</button>
            </center><br>
            </div>
        </div>
        <script src="../js/complemento.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
