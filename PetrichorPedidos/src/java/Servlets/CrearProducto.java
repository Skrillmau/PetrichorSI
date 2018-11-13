/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelo.Producto;
import SQL.Conexion;
import SQL.ProductoC;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author JUan Camilo Posada
 */


@WebServlet("/upload")
@MultipartConfig
public class CrearProducto extends HttpServlet {

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
        
            String nombre = request.getParameter("nombre");
            int idproducto = Integer.parseInt(request.getParameter("idproducto"));
            String descripcion = request.getParameter("descripcion");
            String precio = request.getParameter("precio");
            Part filePart = request.getPart("imagenp");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String path = "C:\\Users\\JUan Camilo Posada\\Documents\\GitHub\\PetrichorSI\\web\\Productos";
            File uploads = new File(path);
            uploads.mkdirs();
            File file = File.createTempFile("cod" + "1203" + "XX", "XX" + fileName, uploads);
            try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }

            String[] Parts = (file.getPath().split("XX"));
            String ruta = ("cod1203XX" + Parts[1] + "XX" + fileName);
            Conexion con = new Conexion();
            Connection cn = con.connect();
            ProductoC productoc = new ProductoC(cn);
            Producto producto = new Producto();
            producto.setIdproducto(idproducto);
            producto.setPath(ruta);
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPrecio(Integer.parseInt(precio));
            boolean ya = productoc.insert(producto);
            if (ya == true) {
                try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Usuario Creado correctamente</title>");
                    out.println(" <link rel=\"stylesheet\" href=\"Css/background.css\">");
                    out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
                    out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
                    out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<div id='formUsuario'>");
                    out.println("<h2>Producto Creado Correctamente</h2>");
                    out.println("<a href='index.jsp'><input type='submit' class='btn btn-success' value='Volver'></a>");
                    out.println("</div>");
                    out.println("</body>");
                    out.println("</html>");
                }
            } else {
                try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Usuario Creado correctamente</title>");
                    out.println(" <link rel=\"stylesheet\" href=\"Css/background.css\">");
                    out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
                    out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
                    out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<div id='formUsuario'>");
                    out.println("<h2>Error</h2>");
                    out.println("<a href='index.jsp'><input type='submit' class='btn btn-success' value='Volver'></a>");
                    out.println("</div>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
        
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
