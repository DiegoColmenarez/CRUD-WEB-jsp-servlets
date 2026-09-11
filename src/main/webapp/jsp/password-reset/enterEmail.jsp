<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Recuperar Contraseña</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh; display: flex; justify-content: center;
            align-items: center; padding: 20px;
        }
        .container {
            background: white; border-radius: 20px; padding: 40px;
            max-width: 400px; width: 100%;
            box-shadow: 0 20px 60px rgba(0,0,0,0.3);
        }
        h2 { color: #333; text-align: center; margin-bottom: 30px; }
        .form-group { margin-bottom: 20px; }
        label { display: block; margin-bottom: 5px; color: #555; font-weight: 500; }
        input {
            width: 100%; padding: 12px; border: 2px solid #e0e0e0;
            border-radius: 8px; font-size: 16px;
            transition: border-color 0.3s;
        }
        input:focus { border-color: #667eea; outline: none; }
        .btn-primary {
            width: 100%; padding: 12px;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white; border: none; border-radius: 8px;
            font-size: 16px; cursor: pointer;
            transition: transform 0.3s;
        }
        .btn-primary:hover { transform: translateY(-2px); }
        .btn-secondary {
            display: block; width: 100%; padding: 12px;
            background: #95a5a6; color: white; border-radius: 8px;
            text-align: center; text-decoration: none; margin-top: 10px;
            transition: background 0.3s;
        }
        .btn-secondary:hover { background: #7f8c8d; }
        .error-message {
            background: #ff4757; color: white; padding: 10px;
            border-radius: 5px; margin-bottom: 20px; text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Recuperar Contraseña</h2>

    <c:if test="${not empty errorMessage}">
        <div class="error-message">${errorMessage}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/password-reset" method="post">
        <input type="hidden" name="action" value="sendCode">
        <div class="form-group">
            <label for="email">Correo Electrónico:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <button type="submit" class="btn-primary">Enviar Código</button>
    </form>
    <a href="${pageContext.request.contextPath}/jsp/auth/login.jsp" class="btn-secondary">Volver al Login</a>
</div>
</body>
</html>