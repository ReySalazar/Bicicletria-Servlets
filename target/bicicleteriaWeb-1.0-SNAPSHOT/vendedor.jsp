<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="estilos.css">
        <title>Bicicleteria</title>
    </head>
    <body>
        <img id="imagen" src="img/bici.png" height="500px" width="500px">
        <h1>Vendedor</h1>
        <h2>Hola ${nombre}!</h2>
        <h3 style="text-align:left">Lista de Bicicletas</h3>
        <form method="post" action="ControladorStockPiezas">
            <input type="hidden" name="instruccion" value="eliminar">
            <table>
                <tr>
                    <td class="cabecera">Bicicletas Disponibles</td>                  
                </tr>
                <c:forEach var="pieza" items="${recursos}">
                    <tr>                  
                        <td class="filas" value="${pieza}">${pieza}</td>                       
                    </tr>
                </c:forEach>
            </table>
            <br>
            <div>													      <!-- se envian al controlador. Ademas mandamos una instruccion oculta para que cuando  -->
                <p<label>código</label><br><input type="text" name="codigo"></p>
                <input type="submit" value="Vender" >
            </div>
        </form>
        <br>
        <!--<form method="post" action="ControladorLogout">
            <input type="submit" value="Salir">
        </form>-->
        <div id="ContenedorBoton">
		<input type="button" value="SALIR" onclick="window.location.href='index.jsp'"/>
	</div>
    </body>
</html>

