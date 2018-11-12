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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${listahistorial}" var="historial" varStatus="status">

            <p><c:out value="${historial.idhistorial}"/></p>  
            <p><c:out value="${historial.idproducto}"/></p>  
            <p><c:out value="${historial.cantidad}"/></p>  
            <p><c:out value="${historial.costo}"/></p>  
            <p><c:out value="${historial.fecha}"/></p>  

        </c:forEach>
    </body>
</html>
