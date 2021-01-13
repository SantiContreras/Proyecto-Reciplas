<%-- 
    Document   : RegistrarPedido
    Created on : 13/10/2020, 19:24:40
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
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap" rel="stylesheet">
        <link rel="stylysheet" href="Assets/alertifyjs/alertify.js" > 
        <link rel="stylesheet" href="Assets/alertifyjs/css/alertify.min.css" >
        <link rel="stylesheet" href="Assets/alertifyjs/css/themes/semantic.min.css">
        <script  src="Assets/alertifyjs/alertify.min.js" ></script>
        <link rel="stylesheet" type="text/css" href="Assets/css/style2.css">
        <style>
            @media print{
                .parte01,img, .btn, .accion  {
                    display: none;
                }
            }
        </style>


        <title>Registro de pedido</title>
    </head>


    <body >

        <div class="d-flex">
            <div class="col-sm-4 parte01">
                <div class="card border-dark">
                    <form action="Controlador?menu=NuevoPedido" method="POST">
                        <div class="card-body">
                            <!-- Datos del cliente-->
                            <div class="form-group">

                                <label class="font-weight-bold">Datos del cliente</label>
                            </div>


                            <div class="form-group d-flex">
                                <div class="col-sm-9 d-flex">

                                    <input type="text" name="dnicliente" value="${cli.getDni()}" class="form-control" placeholder="ingrese dni">
                                    <button type="text" name="accion" value="BuscarCliente" class="btn btn-outline-info">Buscar</button>
                                </div>

                            </div>

                            <div class="col-sm-12">
                                <label class=" mr-3" >Nombre:</label>
                                <input type="text" name="NombreCliente" value="${cli.getNom()}" placeholder="" class="form-control text-muted">
                            </div><br>
                            <!-- Datos del producto-->
                            <div class="form-group ">
                                <label class="font-weight-bold">Datos del producto</label>

                            </div>

                            <div class="form-group d-flex">

                                <div class="col-sm-9 d-flex">                                 
                                    <input type="text" name="cod_pro" value="${pro.getId_producto()}" class="form-control" placeholder="ingrese codigo"> 
                                    <button type="text" name="accion" value="BuscarProducto" class="btn btn-outline-info">Buscar</button>

                                </div> 

                            </div>


                            <div class="col-sm-12">
                                <label class=" mr-2 " >Nombre:</label>
                                <input type="text" name="NombreProducto" value="${pro.getNombre()}" placeholder="" class="form-control font-weight-bold text-muted">
                            </div> <br>  

                            <div class="col-sm-12">
                                <label class=" mr-2 form-group ">Precio:</label>
                            </div>

                            <div class="form-group d-flex">
                                <div class="col-sm-12 d-flex">                                  
                                    <input type="text" name="precio" value="${pro.getPrecio()}" placeholder="" class="form-control font-weight-bold">
                                </div>
                            </div>

                            <div class="col-sm-12">
                                <label class=" mr-2"  >Cantidad:</label>
                                <input type="number" name="cantidad" value="1" placeholder="" class="form-control font-weight-bold">
                            </div> <br>
                            <div class="col-sm-12">
                                <label class=" mr-2"  >Stock:</label>
                                <input type="text" name="stock" value="${pro.getStock()}" placeholder="" class="form-control font-weight-bold">
                            </div> <br>
                            <div class="form-group">
                                <div col-sm>
                                    <button type="submit" name="accion" value="Agregar" class="btn btn-info">Agregar</button>
                                </div>
                            </div>
                        </div> 
                    </form>

                </div>


            </div> 

            <div class="col-sm-9">
                <div class="card parte02">
                    <div class="card-body">

                        <div class="d-flex ml-auto col-sm-9">
                            <label class="text-left mt-2 col-sm-6">FECHA</label>
                            <input  type="text" name="fecha" class="form-control text-center" value="${fecha}" style="font-weight-bold">

                        </div>
                        <div class="d-flex ml-auto col-sm-9">
                            <label class="text-rigth mt-2 col-sm-6">NRO PEDIDO</label>
                            <input type="text" name="numeropedido" class="form-control text-center" value="${numeropedido}" style="font-weight: bold;font-size: 18px;">

                        </div> <br>

                        <table class="table table-hover table-dark ">
                            <thead>
                                <tr class="text-center ">
                                    <th>Nro</th>
                                    <th>id</th>
                                    <th>Producto</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Subtotal</th>
                                    <th class="accion">Accion</th>
                                </tr>

                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">

                                    <tr class="text-center">
                                        <td>${list.getItem()}</td>
                                        <td>${list.getIdpro()}</td>
                                        <td>${list.getDescripcion()}</td>
                                        <td>${list.getPrecio()}</td>
                                        <td>${list.getCantidad()}</td>
                                        <td>${list.getSubtotal()}</td>
                                        <td class="d-flex">
                                            <a href="#" class="btn btn-warning btn-sm">Editar</a>
                                            <a href="#" class="btn btn-danger btn-sm">Eliminar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>

                        </table>

                    </div>

                    <div class="card-footer">
                        <div class="row">
                            <div class="col-sm-6 ">
                                <a href="Controlador?menu=NuevoPedido&accion=GenerarPedido" class="btn btn-info"  onclick="print()"> Generar Pedido</a>
                                <input type="submit" name="accion" value="cancelar" class="btn btn-danger">
                            </div>

                            <div class="col-sm-6 ml-auto d-flex">
                                <label class="col-sm-6 text-rigth mt-2">total a pagar</label>
                                <input type="text" name="txtTotal" value="${totalpagar}0" class="form-control 
                                       text-center font-weight-bold" style="font-size: 18px;">
                            </div>
                        </div>
                    </div>                 

                </div>
            </div>

        </div>

        <div class="d-flex my-2 parte03">
            <div class=" col-sm-4"> 
                <div class=" card  border-dark">
                    <div class="card-body ">
                        <div class="form-group d-flex d-block">
                            <div class=" col-sm-6">
                                <label class="font-weight-bold">
                                    Forma de pago
                                </label>
                            </div>
                            <div class="form-check ">
                                <input class="form-check-input" type="radio" name="txtpago" id="exampleRadios1" value="option1" checked>
                                <label class="form-check-label" for="exampleRadios1">
                                    Efectivo
                                </label>
                            </div>
                            <div class="form-check ml-auto ">
                                <input class="form-check-input" type="radio" name="txtpago" id="exampleRadios2" value="option2">
                                <label class="form-check-label" for="exampleRadios2">
                                    Credito
                                </label>
                            </div>





                        </div>

                    </div>
                </div>

            </div>
        </div>


        <script type="text/javascript">
            function mensaje() {
                alertify.alert("Estimado empleado", "Se agrego un registro nuevo", "OK");

            }
        </script>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
