<%-- 
    Document   : index
    Created on : 10/11/2018, 05:34:32 PM
    Author     : mate_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ingreso</title>
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
                        <a href="index.jsp">Home</a>
                    </li>
                </ul>
                </li> 
                </ul>
            </div>
        </nav>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h1 style="color: whitesmoke;">
                        Portal
                    </h1>
                    <form action = "Login" method="post" id="formUsuario">
                        <h3>
                            <b>
                                <br>Ingrese sus credenciales</b>
                        </h3>
                        <p>Nombre de Usuario:
                            <br>
                            <input type="text" name="user" maxlength="30" required="required" placeholder="Nombre" />
                        </p>
                        <p>Contraseña:
                            <br>
                            <input type="password" name="pass" maxlength="30" required="required" placeholder="Contraseña" />
                        </p>

                        <br>
                        <br>
                        <p>
                            <input type="submit" class="btn btn-success" value="Log in">
                        </p>
                        <br>
                        <br>
                        <br>
                    </form>
                    <br>
                    <div id="botones-Menu">
                        <a href="index.jsp">
                            <button class="btn-Menu">home</button>
                        </a>
                    </div>
                    <br>
                </div>
            </div>
    </body>
</html>
