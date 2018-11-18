/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import Modelo.Pedido;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JUan Camilo Posada
 */
public class PedidoC {
    private Connection con;

    public PedidoC(Connection con) {
        this.con = con;
    }

    public ArrayList<Pedido> getListaP() {
        ArrayList<Pedido> lista = new ArrayList<>();
        try {
            String consulta = "SELECT * FROM pedidos";

            PreparedStatement pst = con.prepareStatement(consulta);
            ResultSet rs = pst.executeQuery();
            Pedido prod = null;

            while (rs.next()) {
                prod = new Pedido();
                prod.setIdpedido(rs.getInt("ID_Pedido"));
                prod.setIdproducto(rs.getInt("ID_Producto"));
                prod.setIddistribuidor(rs.getInt("ID_Distribuidor"));
                prod.setCantidad(rs.getInt("Cantidad"));
                prod.setCosto(rs.getDouble("Costo"));
                prod.setEstado(rs.getString("Estado"));
                prod.setFecha("Fecha");
                lista.add(prod);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return lista;
    }
    
         public boolean update (int id,String pedido){
         boolean creado = false;
        try {
            String consulta = "UPDATE Pedidos SET Estado = ? WHERE ID_Pedido=?;";
            PreparedStatement pst = con.prepareStatement(consulta);
            pst.setString(1, pedido);
            pst.setString(2, id+"");
            pst.executeUpdate();
            creado = true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return creado;
     }
}
