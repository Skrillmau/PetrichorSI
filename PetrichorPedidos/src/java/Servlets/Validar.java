/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import SQL.Conexion;
import SQL.PedidoC;
import SQL.ProductoC;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JUan Camilo Posada
 */
public class Validar extends HttpServlet {

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
        String ida = request.getParameter("id");
        String[] datos = ida.split(",");
        String id = datos[0];
        String cargo = datos[1];
        Conexion con = new Conexion();
        Connection cn = con.connect();
        PedidoC pedidoc = new PedidoC(cn);
        System.out.println(cargo + " asdf " + id);
        if (cargo.equalsIgnoreCase("Encargado")) {
            pedidoc.update(Integer.parseInt(id), "Despachado");

            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/catalogoE.jsp");
            rd.forward(request, response);
        } else if (cargo.equalsIgnoreCase("GerenteGeneral")) {
            pedidoc.update(Integer.parseInt(id), "Aprobado por Gerente General");

            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/catalogoE.jsp");
            rd.forward(request, response);
        } else if (cargo.equalsIgnoreCase("GerenteVentas")) {
            pedidoc.update(Integer.parseInt(id), "Aprobado, Despachado");

            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/catalogoE.jsp");
            rd.forward(request, response);
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
