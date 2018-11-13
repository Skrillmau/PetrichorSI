<%-- 
    Document   : CrearProducto
    Created on : Nov 13, 2018, 9:23:48 AM
    Author     : JUan Camilo Posada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h1 style="color: whitesmoke;">
                        Registro Producto:
                    </h1>
                    <form action = "CrearProducto" method="post" enctype="multipart/form-data" id="formUsuario">
                        <h3>
                            <b>
                                <br>Porfavor Ingrese los Datos del Producto</b>
                        </h3>
                        <input type="number" name="idproducto" placeholder="ID producto" required="required" maxlength="4" />
                        <input type="text" name="nombre" placeholder="Nombre del producto" required="required" maxlength="50" />
                        <input type="text" name="descripcion" placeholder="Descripcion del producto" required="required" maxlength="50" />
                        <input type="number" name="precio"placeholder="Precio" required="required" />
                        <input type="file" name="imagenp">

                        <input type="submit" class="btn btn-success" value="Crear Producto" />
                    </form>
                    <div id="botones-Menu">
                        <a href="home.jsp">
                            <br><input type="submit" class="btn-Menu" value="Home">
                        </a>
                    </div>
                    <br>
                </div>
            </div>
        </div>
    </body>
</html>
