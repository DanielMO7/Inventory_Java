/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ClienteDAO;
import modelo.ClientesM;
import modelo.EmpleadoDAO;
import modelo.EmpleadoM;
import modelo.Movimiento;
import modelo.ProductoDAO;
import modelo.ProductosM;

/**
 *
 * @author Usuario
 */
public class Controlador extends HttpServlet {

    EmpleadoM emp = new EmpleadoM();
    EmpleadoDAO empDao = new EmpleadoDAO();
    int idEmp;

    ProductosM pro = new ProductosM();
    ProductoDAO proDao = new ProductoDAO();
    int idPro;

    ClientesM cli = new ClientesM();
    ClienteDAO cliDao = new ClienteDAO();
    int idCli;

    Movimiento mov = new Movimiento();
    // se crea un array para guardar los datos
    List<Movimiento> ListaM = new ArrayList<>();

    int item, cod, cant;
    String descrip;
    double precio;
    double subt;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String opc = request.getParameter("accion");

        if (menu.equals("MenuPrincipal")) {
            request.getRequestDispatcher("Ppal.jsp").forward(request, response);
        }
        if (menu.equals("Empleado")) {
            switch (opc) {
                case "mostrar":
                    //se crea el objeto (es un array)
                    List lista = empDao.mostrar();
                    request.setAttribute("empleados", lista);
                    break;
                case "insertar":
                    // se define las variables que recibe los valores de los campos de empleado
                    String dni = request.getParameter("txtdni");
                    String nom = request.getParameter("txtnom");
                    String tel = request.getParameter("txttel");
                    String esta = request.getParameter("txtestado");
                    String usr = request.getParameter("txtusua");

                    // agregar los valores al objeto emp
                    emp.setDni(dni);
                    emp.setNombres(nom);
                    emp.setTel(tel);
                    emp.setEstado(esta);
                    emp.setUsua(usr);

                    // llamar el metodo insertar de empleadoDao y enviar como parametro emp
                    empDao.insertar(emp);

                    // Recargar la pagina 
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=mostrar").forward(request, response);
                    break;
                case "carga":
                    //se recibe como parametro la variable id al oprimir el botón editar
                    idEmp = Integer.parseInt(request.getParameter("id"));
                    EmpleadoM em = empDao.cargar(idEmp);
                    //se envia los valores cargados del metodo cargar, al formulario empleado.jsp
                    request.setAttribute("empleado", em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=mostrar").forward(request, response);
                    break;
                case "modifica":
                    // se define las variables que recibe los valores de los campos de empleado
                    String dni_ = request.getParameter("txtdni");
                    String nom_ = request.getParameter("txtnom");
                    String tel_ = request.getParameter("txttel");
                    String esta_ = request.getParameter("txtestado");
                    String usr_ = request.getParameter("txtusua");

                    // agregar los valores al objeto emp
                    emp.setDni(dni_);
                    emp.setNombres(nom_);
                    emp.setTel(tel_);
                    emp.setEstado(esta_);
                    emp.setUsua(usr_);

                    // llamar el metodo modificar de empleadoDao y enviar como parametro emp
                    emp.setId(idEmp);
                    empDao.modificar(emp);

                    // Recargar la pagina 
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=mostrar").forward(request, response);
                    break;
                case "elimina":
                    // se recibe como parametro la variable id al oprimir el boton eliminar
                    idEmp = Integer.parseInt(request.getParameter("id"));
                    // se llama el metodo eliminar de empleado
                    empDao.eliminar(idEmp);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=mostrar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleados.jsp").forward(request, response);
        }
        if (menu.equals("Cliente")) {
            switch (opc) {
                case "mostrar":
                    //se crea el objeto (es un array)
                    List lista = cliDao.mostrar();
                    request.setAttribute("clientes", lista);
                    break;

                case "insertar":
                    // se define las variables que recibe los valores de los campos de producto
                    String dni = request.getParameter("txtdni");
                    String nomb = request.getParameter("txtnom");
                    String dir = request.getParameter("txtdir");
                    String tel = request.getParameter("txttel");
                    String estado = request.getParameter("txtesta");

                    // agregar los valores al objeto pro
                    cli.setDni(dni);
                    cli.setNomb(nomb);
                    cli.setDir(dir);
                    cli.setTel(tel);
                    cli.setEstado(estado);

                    // llamar el metodo insertar de empleadoDao y enviar como parametro emp
                    cliDao.insertar(cli);

                    // Recargar la pagina 
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=mostrar").forward(request, response);
                    break;
                case "carga":
                    // se recibe como parametros la variable id al oprimir editar
                    idCli = Integer.parseInt(request.getParameter("id"));
                    ClientesM cl = cliDao.cargar(idCli);
                    // se envia los valores cargados del metodo cargar al formulario empleado
                    request.setAttribute("cliente", cl);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=mostrar").forward(request, response);
                    break;
                case "modifica":
                    // se define las variables que recibe los valores de los campos de empleado
                    String dni_ = request.getParameter("txtdni");
                    String nom_ = request.getParameter("txtnom");
                    String dir_ = request.getParameter("txtdir");
                    String tel_ = request.getParameter("txttel");
                    String est_ = request.getParameter("txtesta");

                    // agregar los valores al objeto emp
                    cli.setDni(dni_);
                    cli.setNomb(nom_);
                    cli.setDir(dir_);
                    cli.setTel(tel_);
                    cli.setEstado(est_);

                    // llamar el metodo modificar de empleadoDao y enviar como parametro emp
                    cli.setIdCli(idCli);
                    cliDao.modificar(cli);

                    // Recargar la pagina 
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=mostrar").forward(request, response);
                    break;
                case "elimina":
                    // se recibe como parametro la variable id al oprimir el boton eliminar
                    idCli = Integer.parseInt(request.getParameter("id"));
                    // se llama el metodo eliminar de empleado
                    cliDao.eliminar(idCli);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=mostrar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        if (menu.equals("Producto")) {
            switch (opc) {
                case "mostrar":
                    //se crea el objeto (es un array)
                    List lista = proDao.mostrar();
                    request.setAttribute("producto", lista);
                    break;

                case "insertar":
                    // se define las variables que recibe los valores de los campos de producto
                    String dni = request.getParameter("txtdni");
                    String nom = request.getParameter("txtnom");
                    String precios = request.getParameter("txtpre");
                    String stock = request.getParameter("stock");
                    String estado = request.getParameter("txtestado");

                    double prec = Double.parseDouble(precios);
                    int sto = Integer.parseInt(stock);

                    // agregar los valores al objeto pro
                    pro.setDni(dni);
                    pro.setNombres(nom);
                    pro.setPrec(prec);
                    pro.setStock(sto);
                    pro.setEstado(estado);

                    // llamar el metodo insertar de empleadoDao y enviar como parametro emp
                    proDao.insertar(pro);

                    // Recargar la pagina 
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=mostrar").forward(request, response);
                    break;
                case "carga":
                    // se recibe como parametros la variable id al oprimir editar
                    idPro = Integer.parseInt(request.getParameter("id"));
                    ProductosM pr = proDao.cargar(idPro);
                    // se envia los valores cargados del metodo cargar al formulario empleado
                    request.setAttribute("productos", pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=mostrar").forward(request, response);
                    break;
                case "modifica":
                    // se define las variables que recibe los valores de los campos de empleado
                    String dni_ = request.getParameter("txtdni");
                    String nom_ = request.getParameter("txtnom");
                    String pre_ = request.getParameter("txtpre");
                    String sto_ = request.getParameter("stock");
                    String est_ = request.getParameter("txtestado");
                    
                    double prec_ = Double.parseDouble(pre_);
                    int stoc_ = Integer.parseInt(sto_);

                    // agregar los valores al objeto emp
                    pro.setDni(dni_);
                    pro.setNombres(nom_);
                    pro.setPrec(prec_);
                    pro.setStock(stoc_);
                    pro.setEstado(est_);

                    // llamar el metodo modificar de empleadoDao y enviar como parametro emp
                    pro.setIdPro(idPro);
                    proDao.modificar(pro);

                    // Recargar la pagina 
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=mostrar").forward(request, response);
                    break;
                case "elimina":
                    // se recibe como parametro la variable id al oprimir el boton eliminar
                    idPro = Integer.parseInt(request.getParameter("id"));
                    // se llama el metodo eliminar de empleado
                    proDao.eliminar(idPro);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=mostrar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Productos.jsp").forward(request, response);
        }
        if (menu.equals("Movimiento")) {
            switch (opc) {
                case "buscaC":
                    String dniC = request.getParameter("codCliente");
                    cli.setDni(dniC);
                    cli = cliDao.buscar(dniC);

                    request.setAttribute("cliente", cli);
                    break;
                case "buscaP":
                    String dniP = request.getParameter("codProducto");
                    pro.setDni(dniP);
                    pro = proDao.buscar(dniP);

                    request.setAttribute("producto", pro);
                    //se carga la lista de movimiento
                    request.setAttribute("listM", ListaM);
                    break;

                case "cargar":
                    item = item + 1;
                    cod = pro.getIdPro();
                    descrip = request.getParameter("nombreProducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cantidad"));
                    subt = precio * cant;

                    mov = new Movimiento();
                    mov.setItem(item);
                    mov.setIdM(idEmp);
                    mov.setDescr(descrip);
                    mov.setMonto(precio);
                    mov.setCant(cant);
                    mov.setSubt(subt);

                    ListaM.add(mov);
                    request.setAttribute("listM", ListaM);

                default:
                    request.getRequestDispatcher("Movimientos.jsp").forward(request, response);
            }
            request.getRequestDispatcher("Movimientos.jsp").forward(request, response);
        }

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
