<%-- 
    Document   : Producto
    Created on : 16/10/2020, 10:33:56
    Author     : santi
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="Assets/css/style.css">
        <link href="https://unpkg.com/ionicons@4.5.10-0/dist/css/ionicons.min.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Raleway&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:wght@500&family=Staatliches&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Yusei+Magic&display=swap" rel="stylesheet"> 
        <title>Registro de pedido</title>
    </head>


    <body>

        <div class="d-flex">
            <!-- Esta es la columna donde se van a completar los datos del empleado-->
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <form action="Controlador?menu=Empleado" method="post">
                            <div class="form-group">
                                <label> dni</label>
                                <input type="text" value="${empleado.getDni()}" name="txtdni" class="form-control" placeholder="15147889">


                            </div>
                            <div class="form-group">
                                <label> nombre</label>
                                <input type="text" value="${empleado.getNom()}" name="txtnombre" class="form-control" placeholder="Maria marta suarez">


                            </div>
                            <div class="form-group">
                                <label> nick usuario</label>
                                <input type="text" value="${empleado.getUser()}" name="txtusuario" class="form-control" placeholder="Marta014">


                            </div>
                            <div class="form-group">
                                <label> correo electronico</label>
                                <input type="text" value="${empleado.getEmail()}" name="txtcorreo" class="form-control" placeholder="Marta@gmail.com">


                            </div>
                            <div class="form-group">
                                <label> estado</label>
                                <input type="text" value="${empleado.getEs()}" name="txtestado" class="form-control">


                            </div>
                            <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                            <input type="submit" name="accion" value="Actualizar" class="btn btn-warning">
                        </form>
                    </div>

                </div>
            </div>

            <div class="col-sm-12">
                <div class="card">
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>id</th>
                                    <th>nombre</th>
                                    <th>dni</th>
                                    <th>usuario</th>
                                    <th>correo</th>
                                    <th>estado</th>
                                    <th>acciones</th>


                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="em" items="${empleados}">
                                    <tr>
                                        <td>${em.getId_empleado()}</td>
                                        <td>${em.getNom()}</td>
                                        <td>${em.getDni()}</td>
                                        <td>${em.getUser()}</td>
                                        <td>${em.getEmail()}</td>
                                        <td>${em.getEs()}</td>
                                        <td>
                                            <a class="btn btn-warning" href="Controlador?menu=Empleado&accion=Editar&id=${em.getId_empleado()}">Editar</a>
                                            <a class="btn btn-danger" href="Controlador?menu=Empleado&accion=Eliminar&id=${em.getId_empleado()}">Eliminar</a>
                                        </td>

                                    </tr>

                                </c:forEach>  
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>

        </div>


        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
