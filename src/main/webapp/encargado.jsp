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
        <h1>Encargado</h1>
        <p>
        <h2>Hola ${nombre}!</h2>
    </p>
    <h3>Cargar Pieza</h3>
    <form method="post" action="ControladorStockPiezas">
        <input type="hidden" name="instruccion" value="carga">
        <select name="nuevaPieza">
            <c:forEach var="pieza" items="${recursos}">
                <option value="${pieza}">${pieza}</option>
            </c:forEach>
        </select>
        <p><label>código</label><br><input type="text" name="codigo"></p>
        <input type="submit" value="Alta">
    </form>
    <br>
    <div id="ContenedorBoton">
        <input type="button" value="SALIR" onclick="window.location.href = 'index.jsp'"/>
    </div>
</body>
</html>
