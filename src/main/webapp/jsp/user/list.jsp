<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Usuarios</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 900px;
            margin: 40px auto;
            background: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 25px;
        }
        h2 {
            color: #333;
            margin: 0;
        }
        .btn-add {
            padding: 10px 20px;
            background-color: #28a745;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            font-weight: bold;
        }
        .btn-back {
            padding: 10px 20px;
            background-color: #6c757d;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            font-weight: bold;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f8f9fa;
            color: #333;
            font-weight: bold;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        .btn-edit {
            padding: 6px 12px;
            background-color: #ffc107;
            color: #333;
            text-decoration: none;
            border-radius: 3px;
            font-size: 14px;
            margin-right: 5px;
        }
        .btn-delete {
            padding: 6px 12px;
            background-color: #dc3545;
            color: white;
            text-decoration: none;
            border-radius: 3px;
            font-size: 14px;
        }
        .empty-message {
            text-align: center;
            padding: 40px;
            color: #666;
            font-size: 18px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h2>Lista de Usuarios</h2>
        <div>
            <a href="${pageContext.request.contextPath}/user?action=add" class="btn-add">Nuevo Usuario</a>
            <a href="${pageContext.request.contextPath}/menu.jsp" class="btn-back">Volver al Menú</a>
        </div>
    </div>

    <c:choose>
        <c:when test="${not empty users}">
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Email</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.id.value}</td>
                        <td>${user.firstName.value}</td>
                        <td>${user.lastName.value}</td>
                        <td>${user.email.value}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/user?action=edit&id=${user.id.value}"
                               class="btn-edit">Editar</a>
                            <a href="${pageContext.request.contextPath}/user?action=delete&id=${user.id.value}"
                               class="btn-delete">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div class="empty-message">
                No hay usuarios registrados
            </div>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>