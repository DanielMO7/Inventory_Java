/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import conexionBD.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Usuario
 */
public class EmpleadoDAO {
     //instanciamos la clase ConexionBD del paquete conexionBD
    ConexionBD con = new ConexionBD();
    Connection cnx;
    PreparedStatement ps;
    ResultSet rs;
    
    int resultado;
    
    public EmpleadoM valida(String usr, String dni)
    {
        
            //instanciamos la clase que contiene las variables
            EmpleadoM emp = new EmpleadoM();
            //se crea la sentencia sql
            String sql = "Select * from empleado where usuario=? and dni=?";
        try {    
            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            ps.setString(1, usr);
            ps.setString(2, dni);
            //ejecuta la sentencia
            rs=ps.executeQuery();
            
            //recorre los registros de la tabla
            while(rs.next())
            {
              
                emp.setDni(rs.getString("dni"));
                emp.setUsua(rs.getString("usuario"));
                emp.setNombres(rs.getString("nombres"));
                
                
            }
            
        } catch (Exception ex) {
            
        }
        
        //retorna la consulta
        return emp;
    }
    
    //crud
    //carga datos en la tabla de empleados
    public List mostrar()
    {
        String sql = "select * from empleado";
        //se crea arreglo para guardar todos los registros de la consulta
        List<EmpleadoM> lista = new ArrayList<>();
        try {
            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                //se traen los registros de la tabla
                EmpleadoM emp= new EmpleadoM();
                emp.setId(rs.getInt(1));
                emp.setDni(rs.getString(2));
                emp.setNombres(rs.getString(3));
                emp.setTel(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUsua(rs.getString(6));
                
                //se agrega el objeto emp a la lista
                lista.add(emp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
          
    }
    //agrega los registros a la tabla empleados
    public int insertar(EmpleadoM emp)
    {
         //variable para la consulta
            String sql = "insert into empleado(Dni,Nombres,Telefono,Estado,Usuario)values(?,?,?,?,?)";
           try {
            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            ps.setString(1, emp.getDni());
            ps.setString(2, emp.getNombres());
            ps.setString(3, emp.getTel());
            ps.setString(4, emp.getEstado());
            ps.setString(5, emp.getUsua());
            //ejecuta la sentencia de actualizar
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return resultado;
    }
    //carga datos al formulario
    public EmpleadoM cargar(int id)
    {
        EmpleadoM emp = new EmpleadoM();
        String sql = "select * from empleado where idEmpleado="+id;
        try {
                cnx = con.ConexionBD();
                //prepara la sentencia sql
                ps = cnx.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next())
                {
                    emp.setDni(rs.getString(2));
                    emp.setNombres(rs.getString(3));
                    emp.setTel(rs.getString(4));
                    emp.setEstado(rs.getString(5));
                    emp.setUsua(rs.getString(6));
            }} catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return emp;
    }
    
    //modifica registros de la bd
    public int modificar(EmpleadoM emp)
    {
        //se declara la variable de consulta
        String sql = "update empleado set Dni=?, Nombres=?, Telefono=?, Estado=?, Usuario=? where idEmpleado=?";
        try {
            cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            ps.setString(1, emp.getDni());
            ps.setString(2, emp.getNombres());
            ps.setString(3, emp.getTel());
            ps.setString(4, emp.getEstado());
            ps.setString(5, emp.getUsua());
            ps.setInt(6, emp.getId());
            //ejecuta la sentencia
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
    //metodo que elimina registros de la bd
    public void eliminar(int id)
    {  
        String sql = "delete from empleado where IdEmpleado="+id;
        try {
           cnx = con.ConexionBD();
            //prepara la sentencia sql
            ps = cnx.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
