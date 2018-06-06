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
        if(!estado.equals("1")){
            response.sendRedirect("../login.jsp");
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instrucciones votante</title>
        <link href="../css/estilo4.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link href="../css/estilo4.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <center><h1 style="color: #fff">Instrucciones de tipos de votos validos</h1></center>
            <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="">
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="item active">	
                        <div class="content-img">
                            <img src="../img/PartidoPreferencia.png">
                            <div class="content-txt">
                                <h2>Voto por Preferencia a partido politico</h2>
                                <p>Marque la bandera del partido por el cual votara</p>
                            </div>
                            <div class="content-1"></div>
                            <div class="content-2"></div>
                            <div class="content-3"></div>
                            <div class="content-4"></div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="content-img">
                            <img src="../img/VotoPreferenciaPartidoElectounoomas.png">
                            <div class="content-txt">
                                <h2>Voto por Preferencia uno o mas candidatos por bandera</h2>
                                <p>Marque la bandera del partido por el cual votara y marque a los candidatos, solo se puede hacer esto una vez 
                            </div>
                            <div class="content-1"></div>
                            <div class="content-2"></div>
                            <div class="content-3"></div>
                            <div class="content-4"></div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="content-img">
                            <img src="../img/cruzado.png">
                            <div class="content-txt">
                                <h2>Voto Cruzado</h2>
                                <p>Marque por el numero maximo de marcas que tiene su departamento para la eleccion de diputados, sin marcar la bandera del partido electo
                            </div>
                            <div class="content-1"></div>
                            <div class="content-2"></div>
                            <div class="content-3"></div>
                            <div class="content-4"></div>
                        </div>
                    </div>
                </div>
              <a class="left carousel-control" href="#myCarousel" data-slide="prev">
              <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Anterior</span>
              </a>
              <a class="right carousel-control" href="#myCarousel" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                <span class="sr-only">Siguiente</span>
                </a>
            </div>
        </div>
        <center><sub style="color: #fff">Posicione el mouse sobre la imagen para ver indicaciones</sub></center>
        <center><a href="sufragio.jsp" class="btn btn-default">Ejercer voto</a></center>
        <script src="../js/complemento.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
