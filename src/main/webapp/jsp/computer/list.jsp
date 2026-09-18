<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Computadoras</title>
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
            padding: 20px;
        }
        .container {
            background: white;
            border-radius: 20px;
            box-shadow: 0 20px 60px rgba(0,0,0,0.3);
            padding: 30px;
            max-width: 1400px;
            margin: 0 auto;
        }
        h2 {
            color: #333;
            text-align: center;
            margin-bottom: 30px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 30px;
            font-size: 14px;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background: #f8f9fa;
            color: #333;
            font-weight: 600;
        }
        tr:hover {
            background: #f8f9fa;
        }
        .btn-secondary {
            display: block;
            width: 200px;
            margin: 0 auto;
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
    <h2>Lista de Computadoras</h2>

    <c:choose>
        <c:when test="${not empty computers}">
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Marca</th>
                    <th>Categoría</th>
                    <th>CPU</th>
                    <th>Velocidad</th>
                    <th>RAM</th>
                    <th>Cap. RAM</th>
                    <th>Disco</th>
                    <th>Cap. Disco</th>
                    <th>USB</th>
                    <th>HDMI</th>
                    <th>Monitor</th>
                    <th>Pulgadas</th>
                    <th>Precio</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="computer" items="${computers}">
                    <tr>
                        <td>${computer.id.value}</td>
                        <td>${computer.brand.value}</td>
                        <td>${computer.category.value}</td>
                        <td>${computer.processor.cpuBrand}</td>
                        <td>${computer.processor.cpuSpeed}</td>
                        <td>${computer.memory.ramTechnology}</td>
                        <td>${computer.memory.ramCapacity}</td>
                        <td>${computer.storage.diskTechnology}</td>
                        <td>${computer.storage.diskCapacity}</td>
                        <td>${computer.ports.usbPorts}</td>
                        <td>${computer.ports.hdmiPorts}</td>
                        <td>${computer.display.monitorBrand}</td>
                        <td>${computer.display.inches}</td>
                        <td>${computer.price.value}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p style="text-align: center; color: #666; margin-bottom: 30px;">No hay computadoras registradas.</p>
        </c:otherwise>
    </c:choose>

    <a href="${pageContext.request.contextPath}/menu.jsp" class="btn-secondary">Volver al Menú</a>
</div>
</body>
</html>