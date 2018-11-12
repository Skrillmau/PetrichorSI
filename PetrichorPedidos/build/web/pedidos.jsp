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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${listapedidos}" var="pedido" varStatus="status">


            <p><c:out value="${pedido.idpedido}"/></p>  
            <p><c:out value="${pedido.nombree}"/></p>  
            <p><c:out value="${pedido.idproducto}"/></p>  
            <p><c:out value="${pedido.iddistribuidor}"/></p>  
            <p><c:out value="${pedido.cantidad}"/></p>  
            <p><c:out value="${pedido.costo}"/></p>  
            <p><c:out value="${pedido.estado}"/></p>  
            <p><c:out value="${pedido.fecha}"/></p>  


            <form action=<c:out value="Validar?id=${pedido.idpedido}"/> method="post">
                <input type="submit" class="btn btn-danger" value="Validar Pedido" />
            </form>
        </c:forEach>
    </body>
</html>
