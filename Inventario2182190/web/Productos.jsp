<%-- 
    Document   : Productos
    Created on : 15/09/2021, 09:02:15 PM
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
                    <form class="form-horizontal" action="Controlador?menu=Producto" method="POST">
                        <div class="row">
                            <div class="col">
                                <label>DNI</label>
                                <input type="text" value="${productos.getDni()}" name="txtdni" class="form-control">
                            </div>
                            <div class="col">
                            <label>NOMBRES</label>
                            <input type="text"  value="${productos.getNombres()}" name="txtnom" class="form-control">
                            </div>
                            
                        <div class="col">
                            <label>PRECIO</label>
                            <input type="text" value="${productos.getPrec()}" name="txtpre" class="form-control">
                        </div>
                        <div class="col">
                            <label>STOCK</label>
                            <input type="text" value="${productos.getStock()}" name="stock" class="form-control">
                        </div>
                        <div class="col">
                            <label>ESTADO</label>
                            <input type="text" value="${productos.getEstado()}" name="txtestado" class="form-control">
                        </div>
                        </div>
                        </br>
                        <button type="submit" name="accion" value="insertar" class="btn btn-primary">
                            <i class="fas fa-user-plus"></i> Agregar
                        </button>
                        <button type="submit" name="accion" value="modifica" class="btn btn-warning">
                            <i class="fas fa-edit"></i> Actualizar
                        </button>
                        
                    </form>
                </div>
            <div class="col-sm-12">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>IDPRODUCTO</th>
                            <th>DNI</th>
                            <th>NOMBRES</th>
                            <th>PRECIO</th>
                            <th>STOCK</th>
                            <th>ESTADO</th>
                            <th>ACCION</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!--Se define variable em recibe parametros enviados-->
                        <c:forEach var="pr" items="${producto}">
                            <tr>
                                <td>${pr.getIdPro()}</td>
                                <td>${pr.getDni()}</td>
                                <td>${pr.getNombres()}</td>
                                <td>${pr.getPrec()}</td>
                                <td>${pr.getStock()}</td>
                                <td>${pr.getEstado()}</td>

                                <td>
                                    <a class="btn btn-success" href="Controlador?menu=Producto&accion=carga&id=${pr.getIdPro()}">
                                        <i class="far fa-edit"></i> Editar
                                    </a>
                                    <a class="btn btn-dark" href="Controlador?menu=Producto&accion=elimina&id=${pr.getIdPro()}">
                                        <i class="far fa-trash"></i> Borrar
                                    </a>    
                                </td>
                            </tr>        
                        </c:forEach>
                        </tbody>
                </table>
            </div>
        </div>
        

        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
