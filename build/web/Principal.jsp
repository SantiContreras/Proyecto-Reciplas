<%-- 
    Document   : Principal
    Created on : 13/10/2020, 19:22:59
    Author     : santi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="Assets/css/style.css">
        <link href="https://unpkg.com/ionicons@4.5.10-0/dist/css/ionicons.min.css" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Yusei+Magic&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <title>Panel de pedidos</title>

    </head>
    <body>
        <div class="d-flex ">
            <div id="sidebar-container" class="bg-gral">
                <div class="logo">
                    <h4 class="text-ligth">Reciplas</h4>
                </div>
                <div class="menu">
                    <a href="Controlador?menu=Cliente&accion=Listar" class="d-block text-ligth p-3" target="myframe"><i class="icon ion-md-contacts mr-2 lead"></i></i>Clientes</a>
                    <a href="Controlador?menu=Empleado&accion=Listar" class="d-block text-ligth p-3" target="myframe"><i class="icon ion-md-person  mr-2 lead"></i></i>Empleados</a>
                    <a href="Controlador?menu=Producto&accion=Listar" class="d-block text-ligth p-3" target="myframe"> <i class="fa fa-product-hunt" aria-hidden="true"></i> Productos</a>
                    <a href="Controlador?menu=NuevoPedido&accion=default" class="d-block text-ligth p-3" target="myframe"> <i class="fa fa-plus-circle mr-2" aria-hidden="true"></i>Nuevo Pedido</a>
                </div>
            </div>

            <!-- Comienzo del NAVBAR-->
            <div class="w-100">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">

                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="search" placeholder="Buscar" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
                    </form>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ml-auto">


                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <img src="Assets/img/user1.jpg" class="img-fluid rounded-circle mr-2 avatar">
                                    ${usuario_logueado.getNom()}
                                </a>
                                <div class="dropdown-menu bg-purple" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item " href="#"><label>usuario: </label>${usuario_logueado.getUser()}</a>
                                    <a class="dropdown-item " href="#"> <label>Correo: </label> ${usuario_logueado.getEmail()}</a>
                                    <div class="dropdown-divider"></div>
                                    <form action="Validar" method="Post">
                                        <button name="accion" value="salir" class="dropdown-item" class="btn-outline-success">Salir</button>
                                    </form>
                                </div>
                            </li>

                        </ul>

                    </div>
                </nav>

                <div class="m-3 " style="height: 700px;">
                    <iframe src="" name="myframe"  ></iframe>   
                </div>


            </div>
            <!-- FIN NAVBAR-->



        </div>



        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
