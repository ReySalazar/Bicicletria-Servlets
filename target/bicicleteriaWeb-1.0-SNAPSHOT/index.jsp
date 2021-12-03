<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="estilos.css">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
        <title>Bicicleteria</title>
    </head>
    <body>
        <section class="inicio">
            <h1 class="titulo">Bicicleteria</h1>
            <form method="post" action="ControladorLogin">
                <p><label class="label" >Usuario:</label><br><input class="entrada" type="text" name="usuario" placeholder="nombre"></p>
                <p><label class="label" >Contraseña: </label><br><input class="entrada" type="password" name="password" placeholder="contraseña"></p>
                <p><input class="btn btn-primary" type="submit" value="Entrar"></p>
            </form>
        </section>
    </body>
</html>