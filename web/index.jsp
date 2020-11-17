<%-- 
    Document   : index
    Created on : 12 ago. 2020, 10:46:42
    Author     : santi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro sistema de ventas</title>

        <!--JQUERY-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <!-- FRAMEWORK BOOTSTRAP para el estilo de la pagina-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

        <!-- Los iconos tipo Solid de Fontawesome-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
        <script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>

        <!-- Nuestro css-->
        <link rel="stylesheet" type="text/css" href="" th:href="@{/css/index.css}">
    </head>
    <body  style="background-color: #90ff96 ;background-image: url('Assets/img/Eco1.png');">

        <div class="container mt-4 col-lg-4" style="opacity: 0.75; ">
            <div class="card col-sm-10 ">
                <div class="card-body">
                    <form class="form-sing" action="Validar" method="POST">
                        <div class=" form-group text-center">
                            <h3 class="font-weight-bold text-muted text-success">Reciplas</h3>
                            <img src="Assets\img\user-2.jpg" alt="">
                            <label class="text-muted">Acceda al sistema</label>

                        </div>
                        <div class="form-group">
                            <label class="font-weight-bold">Usuario</label>
                            <input type="text" name="txtuser" value="Salvador01"class="form-control">

                        </div>
                        <div class="form-group">
                            <label class="font-weight-bold">Contraseña</label>
                            <input type="password" name="txtpass" value="12345" class="form-control">


                        </div>
                        <input type="submit" name="accion" value="Ingresar" class="btn btn-success btn-lg btn-block">
                    </form>
                </div>
            </div>
        </div>
    </body>
</body>
</html>

