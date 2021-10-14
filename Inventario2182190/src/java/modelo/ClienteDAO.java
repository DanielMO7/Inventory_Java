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
public class ClienteDAO {
    //instanciamos la clase ConexionBD del paquete conexionBD

    ConexionBD con = new ConexionBD();
    Connection cnx;
    PreparedStatement ps;
    ResultSet rs;

    int resultado;
    //crud
    // carga los datos de la tabla de empleado
    public List mostrar() {
        String sql = "select * from cliente";
        List<ClientesM> lista = new ArrayList<>();

        try {
            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ClientesM cli = new ClientesM();
                cli.setIdCli(rs.getInt(1));
                cli.setDni(rs.getString(2));
                cli.setNomb(rs.getString(3));
                cli.setDir(rs.getString(4));
                cli.setTel(rs.getString(5));
                cli.setEstado(rs.getString(6));

                //Se agrega el objeto a la lista
                lista.add(cli);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    // Agrega los registros a la tabla empleados
    public int insertar(ClientesM cli) {
        //variable para consulta
        String sql = "insert into cliente(dni, nombres, direccion, telefono, estado) values(?,?,?,?,?)";

        try {
            //Variable para la consulta

            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getNomb());
            ps.setString(3, cli.getDir());
            ps.setString(4, cli.getTel());
            ps.setString(5, cli.getEstado());
            //Ejecuta la sentencia de actualizar
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    //modifica en la base de datos
    public int modificar(ClientesM cli)
    {
        String sql = "update cliente set dni=?, nombres=?, direccion=?, telefono=?, estado=? where idCliente=?";
            
        try {
            //Se declara la variable de consulta
            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getNomb());
            ps.setString(3, cli.getDir());
            ps.setString(4, cli.getTel());
            ps.setString(5, cli.getEstado());
            ps.setInt(6, cli.getIdCli());
            //Ejecuta la sentencia
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    //Carga datos al formulario
    public ClientesM cargar(int id)
    {
        ClientesM cli = new ClientesM();
        String sql = "select * from cliente where idCliente="+id;
        
        try {
            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                cli.setDni(rs.getString(2));
                cli.setNomb(rs.getString(3));
                cli.setDir(rs.getString(4));
                cli.setTel(rs.getString(5));
                cli.setEstado(rs.getString(6));
            }} catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return cli;
    }
    
    // metodo que elimina registro de la bd

    public void eliminar(int id)
    {
        String sql = "delete from cliente where idCliente="+id;
           
        try {
            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ClientesM buscar(String dni)
    {
        ClientesM cliM = new ClientesM();
        String sql = "select * from cliente where dni="+dni;
            try {
                cnx = con.ConexionBD();
                ps = cnx.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next())
                {
                    cliM.setIdCli(rs.getInt(1));
                    cliM.setDni(rs.getString(2));
                    cliM.setNomb(rs.getString(3));
                    cliM.setDir(rs.getString(4)); 
                    cliM.setTel(rs.getString(5));
                    cliM.setEstado(rs.getString(6));
                }

            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
       return cliM;
    }
}
