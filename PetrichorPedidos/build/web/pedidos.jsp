<%-- 
    Document   : pedidos
    Created on : Nov 12, 2018, 1:08:32 AM
    Author     : JUan Camilo Posada
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                    <h1 class="mt-5">Ver Pedidos</h1>
                </div>
            </div>
            <div class="container">
                <c:forEach items="${listapedidos}" var="pedido" varStatus="status">
                    <div id="formUsuario">
                        <p><c:out value="${pedido.idpedido}"/></p>  
                        <p><c:out value="${pedido.nombree}"/></p>  
                        <p><c:out value="${pedido.idproducto}"/></p>  
                        <p><c:out value="${pedido.iddistribuidor}"/></p>  
                        <p><c:out value="${pedido.cantidad}"/></p>  
                        <p><c:out value="${pedido.costo}"/></p>  
                        <p><c:out value="${pedido.estado}"/></p>  
                        <p><c:out value="${pedido.fecha}"/></p>  

                        <form action=<c:out value="Validar?id=${pedido.idpedido},${empleado.cargo}"/> method="post">
                            <input type="submit" class="btn btn-danger" value="Validar Pedido" />
                        </form>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>
