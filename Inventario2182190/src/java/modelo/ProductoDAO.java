/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexionBD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dani0
 */
public class ProductoDAO {

    ConexionBD con = new ConexionBD();
    Connection cnx;
    PreparedStatement ps;
    ResultSet rs;

    int resultado;

    public List mostrar() {
        String sql = "select * from producto";
        List<ProductosM> lista = new ArrayList<>();

        try {
            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ProductosM pro = new ProductosM();
                pro.setIdPro(rs.getInt(1));
                pro.setDni(rs.getString(2));
                pro.setNombres(rs.getString(3));
                pro.setPrec(rs.getDouble(4));
                pro.setStock(rs.getInt(5));
                pro.setEstado(rs.getString(6));

                //Se agrega el objeto a la lista
                lista.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    // Agrega los registros a la tabla empleados
    public int insertar(ProductosM pro) {
        //variable para consulta
        String sql = "insert into producto(dni, nombres, precio, stock, estado) values(?,?,?,?,?)";

        try {
            //Variable para la consulta

            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            ps.setString(1, pro.getDni());
            ps.setString(2, pro.getNombres());
            ps.setDouble(3, pro.getPrec());
            ps.setInt(4, pro.getStock());
            ps.setString(5, pro.getEstado());
            //Ejecuta la sentencia de actualizar
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    //modifica en la base de datos
    public int modificar(ProductosM pro) {
        String sql = "update producto set dni=?, nombres=?, precio=?, stock=?, estado=? where idProducto=?";

        try {
            //Se declara la variable de consulta
            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            
            ps.setString(1, pro.getDni());
            ps.setString(2, pro.getNombres());
            ps.setDouble(3, pro.getPrec());
            ps.setInt(4, pro.getStock());
            ps.setString(5, pro.getEstado());
            ps.setInt(6, pro.getIdPro());
            //Ejecuta la sentencia
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    //Carga datos al formulario
    public ProductosM cargar(int id) {
        ProductosM pro = new ProductosM();
        String sql = "select * from producto where idProducto=" + id;

        try {
            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro.setDni(rs.getString(2));
                pro.setNombres(rs.getString(3));
                pro.setPrec(rs.getDouble(4));
                pro.setStock(rs.getInt(5));
                pro.setEstado(rs.getString(6));

            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }

    // metodo que elimina registro de la bd
    public void eliminar(int id) {
        String sql = "delete from producto where idProducto=" + id;

        try {
            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ProductosM buscar(String dni) {
        ProductosM proM = new ProductosM();
        String sql = "select * from producto where dni=" + dni;
        try {
            cnx = con.ConexionBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                proM.setDni(rs.getString(2));
                proM.setNombres(rs.getString(3));
                proM.setPrec(rs.getDouble(4));
                proM.setStock(rs.getInt(5));
                proM.setEstado(rs.getString(6));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proM;
    }
}
