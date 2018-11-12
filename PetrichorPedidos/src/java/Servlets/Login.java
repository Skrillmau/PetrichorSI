/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelo.Distribuidor;
import Modelo.Empleado;
import SQL.Conexion;
import SQL.DistribuidorC;
import SQL.EmpleadoC;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JUan Camilo Posada
 */
public class Login extends HttpServlet {

    HttpSession session;

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
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        Conexion con = new Conexion();
        Connection cn = con.connect();
        session = request.getSession(false);
        EmpleadoC emp = new EmpleadoC(cn);
        Empleado emple = new Empleado();
        emple = emp.auth(user, pass);
        RequestDispatcher rd;
        DistribuidorC dis = new DistribuidorC(cn);
        Distribuidor distri = new Distribuidor();
        distri = dis.auth(user, pass);
        if (emple != null) {
            session.setAttribute("empleado", emple);
            rd = request.getRequestDispatcher("/homeEmpleado.jsp");
            rd.forward(request, response);
        } else if (distri != null) {
            session.setAttribute("distribuidor", distri);
            rd = request.getRequestDispatcher("/homeDistribuidor.jsp");
            rd.forward(request, response);

        } else {
            rd = request.getRequestDispatcher("/indexe.jsp");
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
