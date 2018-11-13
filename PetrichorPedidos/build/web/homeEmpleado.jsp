<%-- 
    Document   : homeBodega
    Created on : Nov 11, 2018, 6:51:15 PM
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
                        <h2><b>Usuario: </b> ${empleado.usuario} </h2>
                        <h2><b>Nombres: </b> ${empleado.nombres} </h2>
                        <h2><b>Apellido: </b> ${empleado.apellido} </h2>
                        <h2><b>Correo: </b> ${empleado.correo} </h2>
                        <h2><b>Cargo: </b> ${empleado.cargo} </h2>
                    </form>
                    <form action="Catalogo" method="post">
                        <br><input type="submit" class="btn btn-success" value="Ver Catalogo" />
                    </form>
                    <form action="Pedidos" method="post">
                        <br><input type="submit" class="btn btn-success" value="Ver Pedidos" />
                    </form>
                    <form action="CrearProducto" method="post">
                        <br><input type="submit" class="btn btn-success" value="Ver Pedidos" />
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
