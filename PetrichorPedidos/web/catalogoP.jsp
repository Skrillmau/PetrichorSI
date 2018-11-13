<%-- 
    Document   : catalogoP
    Created on : Nov 11, 2018, 11:53:45 PM
    Author     : JUan Camilo Posada
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${listaproductos}" var="producto" varStatus="status">
            <div class="producto_img">
                                
                <img src="Productos/${producto.path}"/>
            </div>

            <p>${producto.nombre}"</p>  
            <p><c:out value="${producto.descripcion}"/></p>  
            <p><c:out value="${producto.precio}"/></p>  
            <p><c:out value="${producto.idproducto}"/></p>  

            <form action=<c:out value= "Carrito?precio=${producto.precio}&nombre=${producto.nombre}&id=${producto.idproducto}"/> method="post">
                <input type="submit" class="btn btn-success" value="Comprar" />
            </form>

            <form action=<c:out value="Eliminar?id=${producto.idproducto}"/> method="post">
                <input type="submit" class="btn btn-danger" value="Eliminar" />
            </form>
        </c:forEach>

    </body>
</html>
