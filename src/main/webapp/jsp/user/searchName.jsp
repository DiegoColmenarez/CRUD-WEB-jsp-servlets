<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
</head>
<body>
<div class="container">
    <h2>Buscar Usuario por Nombre</h2>
    <form action="${pageContext.request.contextPath}/user" method="get">
        <input type="hidden" name="action" value="searchByName">

        <div class="form-group">
            <label for="nombre">Nombre del Usuario:</label>
            <input type="text" id="nombre" name="nombre" required>
        </div>
        <div class="btn-group">
            <button type="submit" class="btn-primary">Buscar por Nombre</button>
            <a href="${pageContext.request.contextPath}/menu.jsp" class="btn-secondary">Volver al Menú</a>
        </div>
    </form>
</div>
</body>
</html>