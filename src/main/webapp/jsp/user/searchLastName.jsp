<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
</head>
<body>
<div class="container">
    <h2>Buscar Usuario por Apellido</h2>

    <form action="${pageContext.request.contextPath}/user" method="get">
        <input type="hidden" name="action" value="searchByLastName">

        <div class="form-group">
            <label for="apellido">Apellido del Usuario:</label>
            <input type="text" id="apellido" name="apellido" required>
        </div>
        <div class="btn-group">
            <button type="submit" class="btn-primary">Buscar por Apellido</button>
            <a href="${pageContext.request.contextPath}/menu.jsp" class="btn-secondary">Volver al Menú</a>
        </div>
    </form>
</div>
</body>
</html>