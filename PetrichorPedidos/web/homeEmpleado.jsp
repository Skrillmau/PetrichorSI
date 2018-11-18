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
        <title>Interfaz Usuario</title>
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
                        <a href="homeEmpleado.jsp">Informacion perfil</a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Acciones<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li class="nav-item">
                                <form action="Catalogo" method="post">
                                    <br><input type="submit" class="btn btn-success" value="Ver Catalogo" />
                                </form>
                            </li>
                            <li role="separator" class="divider"></li>
                            <li class="nav-item">
                                <form action="Pedidos" method="post">
                                    <br><input type="submit" class="btn btn-success" value="Ver Pedidos" />
                                </form>
                            </li>
                            <li role="separator" class="divider"></li>
                            <li class="nav-item">
                                <a href="CrearProducto.jsp">Crear Producto</a>
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
                    <h1 class="mt-5">Bienvenido</h1>
                    <form id="formUsuario">
                        <h2><b>Usuario: </b> ${empleado.usuario} </h2>
                        <h2><b>Nombres: </b> ${empleado.nombres} </h2>
                        <h2><b>Apellido: </b> ${empleado.apellido} </h2>
                        <h2><b>Correo: </b> ${empleado.correo} </h2>
                        <h2><b>Cargo: </b> ${empleado.cargo} </h2>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
