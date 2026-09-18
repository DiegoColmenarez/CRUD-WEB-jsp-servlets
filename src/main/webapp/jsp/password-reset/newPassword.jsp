<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty sessionScope.resetCode}">
    <c:redirect url="/password-reset?action=showEmailForm"/>
</c:if>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Nueva Contraseña</title>
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
        .error-message {
            background: #ff4757; color: white; padding: 10px;
            border-radius: 5px; margin-bottom: 20px; text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Nueva Contraseña</h2>

    <c:if test="${not empty errorMessage}">
        <div class="error-message">${errorMessage}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/password-reset" method="post">
        <input type="hidden" name="action" value="updatePassword">
        <div class="form-group">
            <label for="password">Nueva Contraseña:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class="form-group">
            <label for="confirmPassword">Confirmar Contraseña:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>
        </div>
        <button type="submit" class="btn-primary">Actualizar Contraseña</button>
    </form>
</div>
</body>
</html>