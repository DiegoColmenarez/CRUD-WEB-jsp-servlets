<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menú Principal</title>
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
            max-width: 600px;
            width: 100%;
        }
        h1 {
            color: #333;
            margin-bottom: 10px;
            text-align: center;
        }
        .welcome {
            text-align: center;
            color: #666;
            margin-bottom: 30px;
            font-size: 18px;
        }
        .welcome span {
            color: #667eea;
            font-weight: bold;
        }
        .menu-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 15px;
            margin-bottom: 30px;
        }
        .menu-item {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 20px;
            border-radius: 15px;
            text-decoration: none;
            text-align: center;
            transition: transform 0.3s, box-shadow 0.3s;
            font-weight: 500;
        }
        .menu-item:hover {
            transform: translateY(-5px);
            box-shadow: 0 10px 25px rgba(102, 126, 234, 0.4);
        }
        .logout-btn {
            display: block;
            width: 100%;
            padding: 12px;
            background: #ff4757;
            color: white;
            border: none;
            border-radius: 10px;
            cursor: pointer;
            font-size: 16px;
            text-align: center;
            text-decoration: none;
            transition: background 0.3s;
        }
        .logout-btn:hover {
            background: #ee2d3a;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Sistema de Gestión de Usuarios</h1>
    <div class="welcome">
        Bienvenido, <span>${sessionScope.user.name.value} ${sessionScope.user.lastName.value}</span>
    </div>

    <div class="menu-grid">
        <a href="${pageContext.request.contextPath}/user?action=list" class="menu-item">Listar Usuarios</a>
        <a href="${pageContext.request.contextPath}/user?action=add" class="menu-item">Agregar Usuario</a>
        <a href="${pageContext.request.contextPath}/jsp/user/searchModify.jsp" class="menu-item">Modificar Usuario</a>
        <a href="${pageContext.request.contextPath}/jsp/user/searchDelete.jsp" class="menu-item">Eliminar Usuario</a>
        <a href="${pageContext.request.contextPath}/user?action=edit&id=${sessionScope.user.id.value}" class="menu-item">Modificar Mis Datos</a>
    </div>

    <a href="${pageContext.request.contextPath}/auth?action=logout" class="logout-btn">Cerrar Sesión</a>
</div>
</body>
</html>