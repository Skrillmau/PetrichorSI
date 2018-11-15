/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

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
public class ProductoC {
     private Connection con;

    public ProductoC(Connection con) {
        this.con = con;
    }

    public ArrayList<Producto> getListaP() {
        ArrayList<Producto> lista = new ArrayList<>();
        System.out.println(" Cargando Lista productos");
        try {
            String consulta = "SELECT * FROM productos";

            PreparedStatement pst = con.prepareStatement(consulta);
            ResultSet rs = pst.executeQuery();
            Producto prod = null;

            while (rs.next()) {
                prod = new Producto();
                prod.setIdproducto(rs.getInt("ID_Producto"));
                prod.setNombre(rs.getString("Nombre"));
                prod.setDescripcion(rs.getString("Descripcion"));
                prod.setPrecio(rs.getDouble("Precio"));
                prod.setPath(rs.getString("Path"));
                lista.add(prod);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return lista;
    }    public boolean insert(Producto producto) {
        boolean creado = false;
        try {
            String consulta = "insert into productos (ID_Producto,Nombre,Descripcion,Precio,Path) values (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(consulta);
            pst.setString(1, producto.getIdproducto() + "");
            pst.setString(2, producto.getNombre());
            pst.setString(3, producto.getDescripcion());
            pst.setString(4, producto.getPrecio()+"");
            pst.setString(5, producto.getPath());
            pst.executeUpdate();
            creado = true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return creado;
    }
     public boolean delete(int id) {
        boolean creado = false;
        try {
            String consulta = "delete from productos where ID_Producto=?;";
            PreparedStatement pst = con.prepareStatement(consulta);
            pst.setString(1, id+"");
            pst.executeUpdate();
            creado = true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return creado;
    }
}
