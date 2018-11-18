/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelo.Empleado;
import Modelo.Historial;
import Modelo.Pedido;
import Modelo.Producto;
import SQL.CompraC;
import SQL.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JUan Camilo Posada
 */
public class Compra extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Conexion conn = new Conexion();
        int id = Integer.parseInt(request.getParameter("idistric"));
        Connection con = conn.connect();
        CompraC pd = new CompraC(con);


        ArrayList<Producto> comprados;
        comprados = (ArrayList<Producto>) request.getSession().getAttribute("comprados");
        Pedido fd = new Pedido();
        Historial f = new Historial();
        int cantidad = 0;
        for (int i = 0; i < comprados.size(); i++) {
            

            cantidad = Integer.parseInt(request.getParameter("cantidad" + comprados.get(i).getIdproducto()));
            
            //  System.out.print(cantidad);

            f.setCantidad(cantidad);
            f.setIddistribuidor(id);
            f.setIdproducto(comprados.get(i).getIdproducto());
            f.setCosto((int) comprados.get(i).getPrecio() * cantidad);
            fd.setIddistribuidor(id);
            fd.setNombree(comprados.get(i).getNombre());
            fd.setEstado("Pendiente de Aprobacion");
            fd.setCosto((int) comprados.get(i).getPrecio() * cantidad);
            fd.setIdproducto(comprados.get(i).getIdproducto());
            fd.setCantidad(cantidad);
            boolean ya = pd.realizarVenta(fd,f);
            if (ya == true) {
                try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Compra Creado correctamente</title>");
                    out.println(" <link rel=\"stylesheet\" href=\"Css/background.css\">");
                    out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
                    out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
                    out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<div id='formUsuario'>");
                    out.println("<h2>Compra registrada exitosamente</h2>");
                    out.println("<a href='homeDistribuidor.jsp'><input type='submit' class='btn btn-success' value='Volver'></a>");
                    out.println("</div>");
                    out.println("</body>");
                    out.println("</html>");
                }
            } else {
                try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Error Compra</title>");
                    out.println(" <link rel=\"stylesheet\" href=\"Css/background.css\">");
                    out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
                    out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
                    out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<div id='formUsuario'>");
                    out.println("<h2>Error</h2>");
                    out.println("<a href='homeDistribuidor.jsp'><input type='submit' class='btn btn-success' value='Volver'></a>");
                    out.println("</div>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
