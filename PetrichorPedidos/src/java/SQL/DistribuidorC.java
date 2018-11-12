/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import Modelo.Distribuidor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JUan Camilo Posada
 */
public class DistribuidorC {

    private Connection con;

    public DistribuidorC(Connection con) {
        this.con = con;

    }

    public Distribuidor auth(String usuario, String password) {

        try {
            String consulta = "SELECT * FROM Usuarios u INNER JOIN Distribuidores d ON d.ID_Usuario=u.ID_Usuario WHERE u.usuario = ? AND u.Pass = ?";

            PreparedStatement pst = con.prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            Distribuidor dis = new Distribuidor();
            System.out.println("Iniciando sesion distribuidor");

            if (rs.next()) {
                dis.setIddistribuidor(rs.getInt("ID_Distribuidor"));
                dis.setUsuario(rs.getString("Usuario"));
                dis.setPassword(rs.getString("Pass"));
                dis.setTipo(rs.getString("Tipo"));
                dis.setNombre(rs.getString("Nombre"));
                dis.setDireccion(rs.getString("Direccion"));
                dis.setCiudad(rs.getString("Ciudad"));
                dis.setPais(rs.getString("Pais"));
                dis.setIdusuario(rs.getInt("ID_Usuario"));
                return dis;
            }

        } catch (SQLException e) {
            System.err.println(e);
        }

        return null;

    }

}
