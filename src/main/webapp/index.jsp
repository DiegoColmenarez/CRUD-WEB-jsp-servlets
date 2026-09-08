<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Sistema de Usuarios</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container {
            background: white;
            border-radius: 10px;
            box-shadow: 0 10px 40px rgba(0,0,0,0.2);
            padding: 40px;
            width: 90%;
            max-width: 400px;
            text-align: center;
        }

        .icon {
            font-size: 4em;
            margin-bottom: 20px;
        }

        h1 {
            color: #333;
            margin-bottom: 10px;
            font-size: 2em;
        }

        .subtitle {
            color: #666;
            margin-bottom: 30px;
        }

        .button {
            display: block;
            width: 100%;
            padding: 15px;
            margin: 10px 0;
            background-color: #667eea;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-weight: bold;
            font-size: 1.1em;
            transition: all 0.3s;
        }

        .button:hover {
            background-color: #764ba2;
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(0,0,0,0.3);
        }

        .button-secondary {
            background-color: #4CAF50;
        }

        .button-secondary:hover {
            background-color: #45a049;
        }

        .footer {
            margin-top: 30px;
            color: #999;
            font-size: 0.9em;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="icon">🔐</div>
    <h1>Sistema de Usuarios</h1>
    <p class="subtitle">Gestión y administración de usuarios</p>

    <a href="${pageContext.request.contextPath}/auth?action=login" class="button">
        Iniciar Sesión
    </a>

    <a href="${pageContext.request.contextPath}/auth?action=register" class="button button-secondary">
        Registrarse
    </a>

    <div class="footer">
        Sistema CRUD | Java EE + JSP + PostgreSQL
    </div>
</div>
</body>
</html>