<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Buscar Usuario</title>
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
        .form-group {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
            font-weight: 500;
        }
        input[type="number"],
        select {
            width: 100%;
            padding: 12px;
            border: 2px solid #e0e0e0;
            border-radius: 8px;
            font-size: 16px;
            transition: border-color 0.3s;
        }
        input:focus,
        select:focus {
            border-color: #667eea;
            outline: none;
        }
        .btn-group {
            display: flex;
            gap: 10px;
            flex-direction: column;
        }
        .btn-primary {
            width: 100%;
            padding: 12px;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            transition: transform 0.3s;
        }
        .btn-primary:hover {
            transform: translateY(-2px);
        }
        .btn-secondary {
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
            transition: background 0.3s;
        }
        .btn-secondary:hover {
            background: #7f8c8d;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Buscar Usuario por ID</h2>
    <form id="searchForm">
        <div class="form-group">
            <label for="id">ID del Usuario:</label>
            <input type="number" id="id" name="id" required>
        </div>
        <div class="form-group">
            <label for="action">Acción:</label>
            <select id="action" name="action">
                <option value="edit">Modificar</option>
                <option value="delete">Eliminar</option>
            </select>
        </div>
        <div class="btn-group">
            <button type="submit" class="btn-primary">Continuar</button>
            <a href="${pageContext.request.contextPath}/menu.jsp" class="btn-secondary">Volver al Menú</a>
        </div>
    </form>
</div>

<script>
    document.getElementById('searchForm').addEventListener('submit', function(e) {
        e.preventDefault();
        const id = document.getElementById('id').value;
        const action = document.getElementById('action').value;
        const contextPath = '${pageContext.request.contextPath}';
        window.location.href = contextPath + '/user?action=' + action + '&id=' + id;
    });
</script>
</body>
</html>
