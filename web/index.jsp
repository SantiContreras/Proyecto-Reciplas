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
    <body  style="background-color: black">
        
        <div class="container mt-4 col-lg-4 ">
     <div class="card col-sm-10">
         <div class="card-body">
             <form class="form-sing" action="Validar" method="POST">
                <div class=" form-group text-center">
                    <h3>Registro</h3>
                    <img src="img\user-2.jpg" alt="">
                    <label>Bienvenidos al sistema</label>

                </div>
                <div class="form-group">
                    <label>Usuario</label>
                    <input type="text" name="txtuser" value="Santi02"class="form-control">

                </div>
                <div class="form-group">
                    <label>Contraseña</label>
                    <input type="password" name="txtpass" value="2525" class="form-control">
                    
                    
                </div>
                <input type="submit" name="accion" value="Ingresar" class="btn btn-primary btn-lg btn-block">
             </form>
         </div>
     </div>
 </div>
    </body>
    </body>
</html>

