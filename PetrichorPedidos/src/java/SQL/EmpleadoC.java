/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import Modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JUan Camilo Posada
 */
public class EmpleadoC {

    private Connection con;

    public EmpleadoC(Connection con) {
        this.con = con;

    }

    public Empleado auth(String usuario, String password) {

        try {
            String consulta = "SELECT * FROM Usuarios u INNER JOIN Empleados e ON e.ID_Usuario=u.ID_Usuario WHERE u.usuario = ? AND u.Pass = ?";
            String consulta2 = "Select Nombre_Cargo from Cargos Where ID_Cargo in (Select ID_Cargo from Empleados where Cedula=?)";
            PreparedStatement pst = con.prepareStatement(consulta);
            PreparedStatement pst1 = con.prepareStatement(consulta2);
            pst.setString(1, usuario);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            Empleado emp = new Empleado();
            System.out.println("Iniciando sesion Empleado");

            if (rs.next()) {
                emp.setID_Usuario(rs.getInt("ID_Usuario"));
                emp.setUsuario(rs.getString("Usuario"));
                emp.setPassword(rs.getString("Pass"));
                emp.setTipo(rs.getString("Tipo"));
                emp.setCedula(rs.getInt("Cedula"));
                emp.setNombres(rs.getString("Nombre"));
                emp.setApellido(rs.getString("Apellido"));
                emp.setCorreo(rs.getString("Correo"));
                emp.setID_Cargo(rs.getInt("ID_Cargo"));
                pst1.setInt(1, emp.getCedula());
                rs= pst1.executeQuery();
                rs.next();
                emp.setCargo(rs.getString("Nombre_Cargo"));
                System.out.println("Empleado");

                return emp;
            }

        } catch (SQLException e) {
            System.err.println(e);
        }

        return null;
    }
}
