/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import Modelo.Historial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JUan Camilo Posada
 */
public class HistorialC {
    private Connection con;

    public HistorialC(Connection con) {
        this.con = con;
    }

    public ArrayList<Historial> getListaP(int idd) {
        ArrayList<Historial> lista = new ArrayList<>();
        try {
            String consulta = "SELECT * FROM historialpedidos where ID_Distribuidor = ?";

            PreparedStatement pst = con.prepareStatement(consulta);
            pst.setString(1, idd+"");
            ResultSet rs = pst.executeQuery();
            Historial hist = null;
            while (rs.next()) {
                hist = new Historial();
                hist.setIdhistorial(rs.getInt("ID_Historial"));
                hist.setIdproducto(rs.getInt("ID_Producto"));
                hist.setIddistribuidor(rs.getInt("ID_Distribuidor"));
                hist.setCantidad(rs.getInt("Cantidad"));
                hist.setCosto(rs.getDouble("Costo"));
                hist.setFecha(rs.getString("Fecha"));
                lista.add(hist);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return lista;
    }
}
