<%-- 
    Document   : homeDistribuidor
    Created on : Nov 11, 2018, 9:24:20 PM
    Author     : JUan Camilo Posada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% HttpSession sesion;%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center" style="color: whitesmoke;">
                    <h1 class="mt-5">Bienvenido</h1>
                    <form id="formUsuario">
                        <h2><b>Usuario: </b> ${distribuidor.usuario} </h2>
                        <h2><b>Nombres: </b> ${distribuidor.nombre} </h2>
                        <h2><b>Direccion: </b> ${distribuidor.direccion} </h2>
                        <h2><b>Ciudad: </b> ${distribuidor.ciudad} </h2>
                        <h2><b>Pais: </b> ${distribuidor.pais} </h2>
                        <h2><b>Tipo: </b> ${distribuidor.tipo} </h2>
                    </form>
                    <form action="Producto" method="post">
                        <br><input type="submit" class="btn btn-success" value="Productos" />
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
