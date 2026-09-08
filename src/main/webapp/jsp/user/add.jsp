<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Usuario</title>
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
            color: #333;
            margin-bottom: 25px;
            text-align: center;
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
            font-weight: bold;
        }
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input:focus {
            outline: none;
            border-color: #007bff;
            box-shadow: 0 0 5px rgba(0,123,255,0.3);
        }
        .btn-submit {
            width: 100%;
            padding: 12px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            font-weight: bold;
        }
        .btn-submit:hover {
            background-color: #218838;
        }
        .btn-cancel {
            display: block;
            text-align: center;
            margin-top: 10px;
            padding: 10px;
            background-color: #6c757d;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }
        .btn-cancel:hover {
            background-color: #5a6268;
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
    <h2>Agregar Nuevo Usuario</h2>

    <% if (request.getAttribute("errorMessage") != null) { %>
    <div class="error-message">
        <%= request.getAttribute("errorMessage") %>
    </div>
    <% } %>

    <form action="${pageContext.request.contextPath}/user" method="post">
        <input type="hidden" name="action" value="insert">

        <div class="form-group">
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre"
                   value="<%= request.getParameter("nombre") != null ? request.getParameter("nombre") : "" %>"
                   required>
        </div>

        <div class="form-group">
            <label for="apellido">Apellido:</label>
            <input type="text" id="apellido" name="apellido"
                   value="<%= request.getParameter("apellido") != null ? request.getParameter("apellido") : "" %>"
                   required>
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email"
                   value="<%= request.getParameter("email") != null ? request.getParameter("email") : "" %>"
                   required>
        </div>

        <div class="form-group">
            <label for="password">Contraseña:</label>
            <input type="password" id="password" name="password" required>
        </div>

        <button type="submit" class="btn-submit">Guardar Usuario</button>
        <a href="${pageContext.request.contextPath}/user?action=list" class="btn-cancel">Cancelar</a>
    </form>
</div>
</body>
</html>