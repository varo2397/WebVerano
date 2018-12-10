<%-- 
    Document   : registro
    Created on : 6/12/2018, 02:52:15 PM
    Author     : alv-c
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%HttpSession sesion = request.getSession();%> 

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
        <link rel="icon" type="image/png" href="../assets/img/favicon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>
            Now UI Dashboard by Creative Tim
        </title>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
        <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
        <!-- CSS Files -->
        <link href="./assets/css/bootstrap.min.css" rel="stylesheet" />
        <link href="./assets/css/now-ui-dashboard.css?v=1.1.0" rel="stylesheet" />
        <!-- CSS Just for demo purpose, don't include it in your project -->
        <link href="./assets/demo/demo.css" rel="stylesheet" />
    </head>
    <body>
        <div class="col-md-12">
            <form action="registro" method="post">
                <div class="row">
                    
                    <div class="col-md-3">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input class="form-control" name="nombre">
                        </div>
                    </div>
                    
                    <div class="col-md-3">
                        <div class="form-group">
                            <label>Nombre de usuario</label>
                            <input class="form-control" name="nombreUsuario">
                        </div>
                    </div>
                    
                    <div class="col-md-3">
                        <div class="form-group">
                            <label>Contraseña</label>
                            <input class="form-control" name="contrasena" type="password">
                        </div>
                    </div>
                    
                    <div class="col-md-3">
                        <div class="form-group">
                            <label>Confirmar contraseña</label>
                            <input class="form-control" name="confirmarContrasena" type="password">
                        </div>
                    </div>
                </div>
                <div class="text-danger">
                    <%=sesion.getAttribute("errorContraseña")== null ? "" : sesion.getAttribute("errorContraseña") %>
                </div>
                <button class="btn btn-primary" type="submit" name="inicioSesion">Registrar</button>
                
                
                
            </form>
            
        </div>
        
        <script src="./assets/js/core/jquery.min.js"></script>
        <script src="./assets/js/core/popper.min.js"></script>
        <script src="./assets/js/core/bootstrap.min.js"></script>
        <script src="./assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
        <!-- Chart JS -->
        <script src="./assets/js/plugins/chartjs.min.js"></script>
        <!--  Notifications Plugin    -->
        <script src="./assets/js/plugins/bootstrap-notify.js"></script>
        <!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
        <script src="./assets/js/now-ui-dashboard.min.js?v=1.1.0" type="text/javascript"></script>
        <!-- Now Ui Dashboard DEMO methods, don't include it in your project! -->
        <script src="./assets/demo/demo.js"></script>
    </body>
</html>
