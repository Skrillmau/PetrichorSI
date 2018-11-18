<%-- 
    Document   : historial
    Created on : Nov 12, 2018, 1:35:49 AM
    Author     : JUan Camilo Posada
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Interfaz Empleado Admin</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="Css/background.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>

    <body>

        <nav class="navbar navbar-default fixed-top">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <div class="navbar-header">
                    <a href="index.jsp">
                        <img src="Css/imagenes/Captura.PNG" class="Banner">
                    </a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="nav-item">
                        <a href="homeDistribuidor.jsp">Informacion perfil</a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Acciones<span class="caret"></span></a>
                        <ul class="dropdown-menu">

                            <li class="nav-item">
                                <form action="Catalogo" method="post">
                                    <br><input type="submit" class="btn btn-success" value="Ver Catalogo" />
                                    <td><input type="text" name="idistri" value="${distribuidor.iddistribuidor}"  hidden/></td>
                                </form>
                            </li>       
                        </ul>
                    </li>  
                </ul>
                </li> 
                </ul>
            </div>
        </nav>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center" style="color: whitesmoke;">

                    <c:forEach items="${listahistorial}" var="historial" varStatus="status">
                        <form id="formUsuario">
                            <p>ID historial: <c:out value="${historial.idhistorial}"/></p>  
                            <p>ID producto: <c:out value="${historial.idproducto}"/></p>  
                            <p>Unidades: <c:out value="${historial.cantidad}"/></p>  
                            <p>Costo: <c:out value="${historial.costo}"/></p>  
                            <p>Fecha: <c:out value="${historial.fecha}"/></p>  
                        </form>
                    </c:forEach>

                </div>
            </div>
        </div>
    </body>
</html>
