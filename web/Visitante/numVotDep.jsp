<%-- 
    Nombre del documento   : numVotDep
    fecha                  : 24-may-2018
    Autor                  : Ulises
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Votos por departamento</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <img src="../img/tse.png">
        <nav class="navbar navbar-default navbar-static-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="../index.jsp">Inicio</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Estadistica de votantes<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Numero de votantes por departamento</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="numVotMun.jsp">Numero de votantes por municipio</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="votGenRan.jsp">Votantes por genero y rango de edad</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="porVot.jsp">Porcentaje de votantes</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Escrutinio<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="escDip.jsp">Escrutinio de diputado</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="escDepMun.jsp">Escrutinio por departamento y municipios</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <script src="../js/complemento.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
