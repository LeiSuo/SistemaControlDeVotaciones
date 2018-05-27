<%-- 
    Document   : index
    Created on : 08-may-2018, 16:54:24
    Author     : SCOR64
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Elecciones</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilo3.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <img src="img/tse.png">
            <nav class="navbar navbar-default navbar-static-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Inicio</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Estadistica de votantes<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="Visitante/numVotDep.jsp">Numero de votantes por departamento</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="Visitante/numVotMun.jsp">Numero de votantes por municipio</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="Visitante/votGenRan.jsp">Votantes por genero y rango de edad</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="Visitante/porVot.jsp">Porcentaje de votantes</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Escrutinio<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="Visitante/escDip.jsp">Escrutinio de diputado</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="Visitante/escDepMun.jsp">Escrutinio por departamento y municipios</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h1 class="panel-title">Elecciones</h1>
                </div>
                <div class="panel-body">
                    <p align="justify">Bienvenido a la nueva plataforma de informacion sobre el escrutinio de diputados y diputadas de El Salvador.</p>
                    <p align="justify">
                    La plataforma esta dirigida a  mostrar los resultados de las elecciones actualizadas,
                    mostrando diferentes datos estadisticos importantes para la observacion del proceso electoral.
                    Si desea informarse más acerca de información de la institución, documentos importantes y noticias,
                    ponemos a su disposición diferentes enlaces hacia la página principal del TSE y su documentación intitucional.
                    </p>
                </div>  
            </div>
        </div>
        <div class="u-full-width" style="margin-bottom: 30px;">
            <div style="width: 25%; margin: 0; padding: 0; display: inline-block;" id="menu-boton-23">
                <a class="tse-color" href="https://www.tse.gob.sv/TSE/Instituci%C3%B3n">
                <img src="img/icono-institucion-blanco.png" style="width: 50%;">
                <h3>Institución</h3>
                </a>
            </div><div style="width: 25%; margin: 0; padding: 0; display: inline-block;" id="menu-boton-24">
                <a class="tse-color" href="https://www.tse.gob.sv/TSE/Documentos">
                <img src="img/icono-documento-blanco.png" style="width: 50%;">
                <h3>Documentos</h3>
                </a>
            </div><div style="width: 25%; margin: 0; padding: 0; display: inline-block;" id="menu-boton-25">
                <a class="tse-color" href="https://www.tse.gob.sv/TSE/Elecciones">
                <img src="img/icono-eleccion-blanco.png" style="width: 50%;">
                <h3>Elecciones</h3>
                </a>
            </div><div style="width: 25%; margin: 0; padding: 0; display: inline-block;" id="menu-boton-26">
                <a class="tse-color" href="https://www.tse.gob.sv/noticia/2017/inicio">
                <img src="img/icono-noticia-blanco.png" style="width: 50%;">
                <h3>Noticias</h3>
                </a>
            </div></div>
        <script src="js/complemento.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
