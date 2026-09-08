<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Eliminar Usuario</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 500px;
            margin: 40px auto;
            background: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        h2 {
            color: #dc3545;
            margin-bottom: 25px;
            text-align: center;
        }
        .warning {
            background-color: #fff3cd;
            color: #856404;
            padding: 15px;
            border-radius: 4px;
            margin-bottom: 20px;
            text-align: center;
        }
        .user-info {
            background-color: #f8f9fa;
            padding: 15px;
            border-radius: 4px;
            margin-bottom: 25px;
        }
        .user-info p {
            margin: 8px 0;
            color: #495057;
        }
        .user-info strong {
            color: #333;
        }
        .btn-delete {
            padding: 12px 24px;
            background-color: #dc3545;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            font-weight: bold;
            margin-right: 10px;
        }
        .btn-cancel {
            display: inline-block;
            padding: 12px 24px;
            background-color: #6c757d;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            font-size: 16px;
        }
        .error-message {
            background-color: #f8d7da;
            color: #721c24;
            padding: 10px;
            border-radius: 4px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Confirmar Eliminación</h2>

    <c:if test="${not empty errorMessage}">
        <div class="error-message">
                ${errorMessage}
        </div>
    </c:if>

    <div class="warning">
        <strong>¿Estás seguro de que deseas eliminar este usuario?</strong>
    </div>

    <div class="user-info">
        <p><strong>ID:</strong> ${user.id.value}</p>
        <p><strong>Nombre:</strong> ${user.firstName.value} ${user.lastName.value}</p>
        <p><strong>Email:</strong> ${user.email.value}</p>
    </div>

    <div style="text-align: center;">
        <form action="${pageContext.request.contextPath}/user" method="post" style="display: inline;">
            <input type="hidden" name="action" value="delete">
            <input type="hidden" name="id" value="${user.id.value}">
            <button type="submit" class="btn-delete">Confirmar Eliminación</button>
        </form>
        <a href="${pageContext.request.contextPath}/menu.jsp" class="btn-cancel">Cancelar</a>
    </div>
</div>
</body>
</html>