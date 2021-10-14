<%-- 
    Document   : Movimientos
    Created on : 15/09/2021, 09:02:48 PM
    Author     : dani0
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" 
              integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    </head>
    <body>
        <div class="card-body">
            <h2>Datos del Cliente</h2>
            <form class="form-horizontal" action="Controlador?menu=Movimiento" method="POST">
                <div class="row">
                    <div class="col">
                        <input type="text" name="codCliente" placeholder="Codigo" value="${cliente.getDni()}" class="form-control">
                    </div>
                    <div class="col">
                        <input type="text"  name="nombreCliente" placeholder="Nombre Cliente" value="${cliente.getNomb()}" class="form-control">
                    </div>
                    <div class="col">
                        <button type="submit" name="accion" value="buscaC" class="btn btn-success">
                            <i class="fas fa-user-tie"></i> Buscar Cliente
                        </button>
                    </div>    
                    <div class="col">
                        <label></label>

                    </div>
                </div>
                </br>
            </form>
            <h2>Productos</h2>
            <form class="form-horizontal" action="Controlador?menu=Movimiento" method="POST">
                <div class="row">
                    <div class="col">
                        <input type="text" placeholder="Codigo" value="${producto.getDni()}" name="codProducto" class="form-control">
                    </div>
                    <div class="col">
                        <input type="text" placeholder="Nombre Producto" value="${producto.getNombres()}" name="nombreProducto" class="form-control">
                    </div>
                    <div class="col">
                        <input type="number" placeholder="Precio" value="${producto.getPrec()}" name="precio" class="form-control">
                    </div>
                    <div class="col">
                        <input type="number" placeholder="Stock" value="${producto.getStock()}" name="cantidad" class="form-control">
                    </div>
                    <div class="col">
                        <input type="text" placeholder="Estado" value="${producto.getEstado()}" name="txtestado" class="form-control">
                    </div>
                    <div class="col">
                        <button type="submit" name="accion" value="buscaP" class="btn btn-success">
                            <i class="fas fa-search"></i> Buscar Producto
                        </button>
                    </div>   
                </div>
                </br>
                <button type="submit" name="accion" value="cargar" class="btn btn-primary">
                    <i class="fas fa-edit"></i> Cargar
                </button>
            </form>
        </div>
    </div>
    <div class="col-sm-12">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Codigo</th>
                    <th>Descripción</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                    <th>Subtotal</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <!--Se define variable em recibe parametros enviados-->
                <c:forEach var="movi" items="${listM}">
                    <tr>
                        <td>${movi.getItem()}</td>
                        <td>${movi.getIdM()}</td>
                        <td>${movi.getDescr()}</td>
                        <td>${movi.getMonto()}</td>
                        <td>${movi.getCant()}</td>
                        <td>${movi.getSubt()}</td>

                        <td>
                            <a class="btn btn-success" >
                                <i class="far fa-edit"></i> Editar
                            </a>
                            <a class="btn btn-dark">
                                <i class="far fa-trash"></i> Borrar
                            </a>    
                        </td>
                    </tr>        
                </c:forEach>
            </tbody>
        </table>
        <div class="form-horizontal">
            <div class="row">
            <div class="col">
            <button type="submit" name="accion" value="modifica" class="btn btn-success btn-block">
                <i class="fas fa-sign-out-alt"></i> Salir
            </button>
            </div>   
            <div class="col">
            <button type="submit" name="accion" value="modifica" class="btn btn-dark btn-block">
                <i class="fas fa-power-off"></i> Cancelar
            </button>
                </div> 
                </div>
        </div>

    </div>

</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>