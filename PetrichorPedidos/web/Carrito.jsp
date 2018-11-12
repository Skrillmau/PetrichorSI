<%-- 
    Document   : Carrito
    Created on : Nov 12, 2018, 2:44:36 AM
    Author     : JUan Camilo Posada
--%>
<%@page import="Modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<Producto> comprados = new ArrayList();%>
<% HttpSession sesion; %>
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
                <div class="col-lg-12 text-center" style="color: whitesmoke;">
                    <h1 class="mt-5">Carrito de Compras</h1>
                </div>
                <div id="formUsuario1">
                    <form action = "Compra" method="post">
                        <%  sesion = request.getSession(false);
                            if (sesion.getAttribute("carritocompras") != null) {%>
                        <table class="table table-hover"> 
                            <tr><th> Codigo </th><th> Nombre </th><th> Precio </th><th> Cantidad </th><th> Eliminar </th>

                                <% ArrayList<Producto> Lista = (ArrayList<Producto>) sesion.getAttribute("carritocompras");
                                    for (int i = 0; i < Lista.size(); i++) {%>  
                            <tr>
                                <td><%=Lista.get(i).getIdproducto()%></td>
                                <td><%=Lista.get(i).getNombre()%> </td>
                                <td><%=Lista.get(i).getPrecio()%></td>
                                <td><input type="number" class="campos" name="cantidad<%=Lista.get(i).getIdproducto()%>" placeholder="insertecantidad<%=i%>" required="required"  /></td>
                                <td><a href="eliminarproducto?productoid=<%=Lista.get(i).getIdproducto()%>"> ELIMINAR </a></td>
                            </tr>

                            <%} %>
                            <%}%>
                        </table>

                        <% ArrayList<Producto> Lista = (ArrayList<Producto>) sesion.getAttribute("carritocompras"); %>
                        <%  request.getSession().setAttribute("comprados", Lista);%>
                        <br></br><input type="submit" class="btn btn-success" value="Comprar" /><br></br>
                        <td><input type="text" name="idistric" value="${distribuidor.iddistribuidor}"  /></td>
                    </form>
                </div>
                <br>
                <div id="botones-Menu">
                    <form action="Catalogo" method="post">
                        <input type="submit" class="btn-Menu" value="Regresar" />
                    </form><br>
                    <a href="homecliente.jsp">
                        <input type="submit" class="btn-Menu" value="Home">
                    </a>
                </div>
            </div>
        </div>
    </body>
</html>
