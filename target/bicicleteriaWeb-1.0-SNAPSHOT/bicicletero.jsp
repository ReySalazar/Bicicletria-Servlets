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
        <h1>Bicicletero</h1>
        <p>
        <h2>Hola ${nombre}!</h2>
    </p>
    <h3>Armar Bicicleta (se necesita 6 ítems)</h3>
    <form method="post" action="ControladorStockPiezas">
        <h4>Cod Nombre</h4>
        <input type="hidden" name="instruccion" value="alta">
        <select name="multiple" size="6"  multiple="multiple">
            <c:forEach var="pieza" items="${recursos}">
                <option value="${pieza.codigo}">${pieza}</option>
            </c:forEach>
        </select>
        <p><input type="submit" value="Alta Bicicleta"></p>
    </form>
    <br>
    <div id="ContenedorBoton">
        <input type="button" value="SALIR" onclick="window.location.href = 'index.jsp'"/>
    </div>
</body>
</html>
