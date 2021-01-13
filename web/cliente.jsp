
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
        
         <link href="https://fonts.googleapis.com/css2?family=Yusei+Magic&display=swap" rel="stylesheet"> 
        <title>cliente</title>
    </head>


    <body>

        <div class="d-flex">
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <form action="Controlador?menu=Cliente" method="post">
                            <div class="form-group">
                                <label>Dni :</label>
                                <input type="text" value="${clientes.getDni()}" name="txtdni" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Nombre :</label>
                                <input type="text" value="${clientes.getNom()}" name="txtnombre" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Direccion :</label>
                                <input type="text" value="${clientes.getDir()}" name="txtdireccion" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Tel :</label>
                                <input type="text" value="${clientes.getTel()}" name="txttelefono" class="form-control">
                            </div>

                            <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                            <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                        </form>
                    </div>
                </div>
            </div>

            <div class="col-sm-10">
                <div class="card">
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>id</th>
                                    <th>dni</th>
                                    <th>nombre</th>
                                    <th>direccion</th>
                                    <th>telefono</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="cli" items="${cliente}">
                                    <tr>
                                        <td>${cli.getId_cliente()}</td>
                                        <td>${cli.getDni()}</td>
                                        <td>${cli.getNom()}</td>
                                        <td>${cli.getDir()}</td>
                                        <td>${cli.getTel()}</td>
                                        <td>
                                            <a class="btn btn-warning" href="Controlador?menu=Cliente&accion=Editar&id=${cli.getId_cliente()}">Editar</a>
                                            <a class="btn btn-danger" href="Controlador?menu=Cliente&accion=Eliminar&id=${cli.getId_cliente()}">Eliminar</a>
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
