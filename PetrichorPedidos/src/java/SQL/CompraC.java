/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import Modelo.Historial;
import Modelo.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author JUan Camilo Posada
 */
public class CompraC {

    private Connection con;

    public CompraC(Connection con) {
        this.con = con;

    }

    public boolean realizarVenta(Pedido registro, Historial factura) {
        boolean venta = false;
        try {
            String consulta = "INSERT INTO pedidos (ID_Producto,ID_Distribuidor,Cantidad,Costo,Estado,Fecha) values (?,?,?,?,?,GetDate())";
            String consulta2 = "Insert into HistorialPedidos(ID_Producto,ID_Distribuidor,Cantidad,Costo,Fecha) values (?,?,?,?,GetDate())";

            PreparedStatement pst = con.prepareStatement(consulta);
            PreparedStatement pstv = con.prepareStatement(consulta2);

            pst.setString(1, registro.getIdproducto() + "");
            pst.setString(2, registro.getIddistribuidor() + "");
            pst.setString(3, registro.getCantidad() + "");
            pst.setString(4, registro.getCosto() + "");
            pst.setString(5, registro.getEstado());

            pstv.setString(1, factura.getIdproducto()+ "");
            pstv.setString(2, factura.getIddistribuidor()+ "");
            pstv.setString(3, factura.getCantidad() + "");
            pstv.setString(4, factura.getCosto() + "");
            pst.executeUpdate();
            pstv.executeUpdate();

            venta = true;
        } catch (SQLException e) {
            System.out.println(e);
        }

        return venta;
    }

}
