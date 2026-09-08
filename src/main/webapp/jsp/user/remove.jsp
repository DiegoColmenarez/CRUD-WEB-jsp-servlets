<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Eliminar Usuario</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }
        .container {
            background: white;
            border-radius: 20px;
            box-shadow: 0 20px 60px rgba(0,0,0,0.3);
            padding: 40px;
            max-width: 400px;
            width: 100%;
        }
        h2 {
            color: #333;
            text-align: center;
            margin-bottom: 30px;
        }
        .user-info {
            background: #f8f9fa;
            padding: 20px;
            border-radius: 10px;
            margin-bottom: 30px;
        }
        .user-info p {
            margin-bottom: 10px;
            color: #555;
        }
        .user-info strong {
            color: #333;
        }
        .warning {
            color: #ff4757;
            text-align: center;
            margin-bottom: 20px;
            font-weight: 500;
        }
        .btn-danger {
            width: 100%;
            padding: 12px;
            background: #ff4757;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
            transition: background 0.3s;
        }
        .btn-danger:hover {
            background: #ee2d3a;
        }
        .btn-secondary {
            display: block;
            width: 100%;
            padding: 12px;
            background: #95a5a6;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            margin-top: 10px;
            transition: background 0.3s;
        }
        .btn-secondary:hover {
            background: #7f8c8d;
        }
        .error-message {
            background: #ff4757;
            color: white;
            padding: 10px;
            border-radius: 5px;
            margin-bottom: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Confirmar Eliminación</h2>

    <c:if test="${not empty errorMessage}">
        <div class="error-message">${errorMessage}</div>
    </c:if>

    <div class="user-info">
        <p><strong>ID:</strong> ${user.id.value}</p>
        <p><strong>Nombre:</strong> ${user.name.value}</p>
        <p><strong>Apellido:</strong> ${user.lastName.value}</p>
        <p><strong>Email:</strong> ${user.email.value}</p>
    </div>

    <p class="warning">¿Está seguro que desea eliminar este usuario?</p>

    <form action="${pageContext.request.contextPath}/user" method="post">
        <input type="hidden" name="action" value="delete">
        <input type="hidden" name="id" value="${user.id.value}">
        <button type="submit" class="btn-danger">Eliminar Usuario</button>
    </form>
    <a href="${pageContext.request.contextPath}/menu.jsp" class="btn-secondary">Cancelar</a>
</div>
</body>
</html>