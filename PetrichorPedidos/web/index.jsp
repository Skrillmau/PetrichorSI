<%-- 
    Document   : index
    Created on : 10/11/2018, 05:34:32 PM
    Author     : mate_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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
                        <p>
                            <input type="submit" class="btn btn-success" value="Log in">
                        </p>
                        <br>
        </form>
    </body>
</html>
