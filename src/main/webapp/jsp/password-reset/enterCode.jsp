<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty sessionScope.resetEmail}">
    <c:redirect url="/password-reset?action=showEmailForm"/>
</c:if>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Ingresar Código</title>
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
        h2 { color: #333; text-align: center; margin-bottom: 20px; }
        .info {
            text-align: center; color: #666; margin-bottom: 25px;
            font-size: 14px;
        }
        .info strong { color: #667eea; }
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
        .success-message {
            background: #2ecc71; color: white; padding: 10px;
            border-radius: 5px; margin-bottom: 20px; text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Ingresar Código</h2>

    <c:if test="${not empty errorMessage}">
        <div class="error-message">${errorMessage}</div>
    </c:if>
    <c:if test="${not empty successMessage}">
        <div class="success-message">${successMessage}</div>
    </c:if>

    <p class="info">
        Código enviado a <strong>${sessionScope.resetEmail}</strong>
    </p>

    <form action="${pageContext.request.contextPath}/password-reset" method="post">
        <input type="hidden" name="action" value="verifyCode">
        <div class="form-group">
            <label for="code">Código de 6 dígitos:</label>
            <input type="text" id="code" name="code" pattern="\d{6}" maxlength="6" required>
        </div>
        <button type="submit" class="btn-primary">Verificar Código</button>
    </form>
</div>
</body>
</html>