<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar Computadora</title>
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
            max-width: 700px;
            width: 100%;
        }
        h2 {
            color: #333;
            text-align: center;
            margin-bottom: 30px;
        }
        .form-grid {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 15px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group.full-width {
            grid-column: span 2;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
            font-weight: 500;
        }
        input, select {
            width: 100%;
            padding: 12px;
            border: 2px solid #e0e0e0;
            border-radius: 8px;
            font-size: 16px;
            transition: border-color 0.3s;
        }
        input:focus, select:focus {
            border-color: #667eea;
            outline: none;
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
            transition: transform 0.3s;
            margin-top: 10px;
        }
        .btn-primary:hover {
            transform: translateY(-2px);
        }
        .btn-secondary {
            display: block;
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
            margin-top: 10px;
            transition: background 0.3s;
        }
        .btn-secondary:hover {
            background: #7f8c8d;
        }
        .error-message {
            background: #ff4757;
            color: white;
            padding: 10px;
            border-radius: 5px;
            margin-bottom: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Modificar Computadora</h2>

    <c:if test="${not empty errorMessage}">
        <div class="error-message">${errorMessage}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/computer" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${computer.id.value}">
        <div class="form-grid">
            <div class="form-group">
                <label for="marca">Marca:</label>
                <input type="text" id="marca" name="marca" value="${computer.brand.value}" required>
            </div>
            <div class="form-group">
                <label for="categoria">Categoría:</label>
                <select id="categoria" name="categoria" required>
                    <option value="GAMING" ${computer.category.value == 'GAMING' ? 'selected' : ''}>GAMING</option>
                    <option value="OFFICE" ${computer.category.value == 'OFFICE' ? 'selected' : ''}>OFFICE</option>
                    <option value="WORKSTATION" ${computer.category.value == 'WORKSTATION' ? 'selected' : ''}>WORKSTATION</option>
                    <option value="ULTRABOOK" ${computer.category.value == 'ULTRABOOK' ? 'selected' : ''}>ULTRABOOK</option>
                    <option value="ALL_IN_ONE" ${computer.category.value == 'ALL_IN_ONE' ? 'selected' : ''}>ALL_IN_ONE</option>
                </select>
            </div>
            <div class="form-group">
                <label for="marcaCpu">Marca CPU:</label>
                <input type="text" id="marcaCpu" name="marcaCpu" value="${computer.processor.cpuBrand}" required>
            </div>
            <div class="form-group">
                <label for="velocidadCpu">Velocidad CPU:</label>
                <input type="text" id="velocidadCpu" name="velocidadCpu" value="${computer.processor.cpuSpeed}" required>
            </div>
            <div class="form-group">
                <label for="tecnologiaRam">Tecnología RAM:</label>
                <select id="tecnologiaRam" name="tecnologiaRam" required>
                    <option value="DDR3" ${computer.memory.ramTechnology == 'DDR3' ? 'selected' : ''}>DDR3</option>
                    <option value="DDR4" ${computer.memory.ramTechnology == 'DDR4' ? 'selected' : ''}>DDR4</option>
                    <option value="DDR5" ${computer.memory.ramTechnology == 'DDR5' ? 'selected' : ''}>DDR5</option>
                </select>
            </div>
            <div class="form-group">
                <label for="capacidadRam">Capacidad RAM:</label>
                <input type="text" id="capacidadRam" name="capacidadRam" value="${computer.memory.ramCapacity}" required>
            </div>
            <div class="form-group">
                <label for="tecnologiaDisco">Tecnología Disco:</label>
                <select id="tecnologiaDisco" name="tecnologiaDisco" required>
                    <option value="SSD" ${computer.storage.diskTechnology == 'SSD' ? 'selected' : ''}>SSD</option>
                    <option value="HDD" ${computer.storage.diskTechnology == 'HDD' ? 'selected' : ''}>HDD</option>
                    <option value="NVME" ${computer.storage.diskTechnology == 'NVME' ? 'selected' : ''}>NVME</option>
                </select>
            </div>
            <div class="form-group">
                <label for="capacidadDisco">Capacidad Disco:</label>
                <input type="text" id="capacidadDisco" name="capacidadDisco" value="${computer.storage.diskCapacity}" required>
            </div>
            <div class="form-group">
                <label for="numPuertosUsb">Puertos USB:</label>
                <input type="number" id="numPuertosUsb" name="numPuertosUsb" value="${computer.ports.usbPorts}" min="0" required>
            </div>
            <div class="form-group">
                <label for="numPuertosHdmi">Puertos HDMI:</label>
                <input type="number" id="numPuertosHdmi" name="numPuertosHdmi" value="${computer.ports.hdmiPorts}" min="0" required>
            </div>
            <div class="form-group">
                <label for="marcaMonitor">Marca Monitor:</label>
                <input type="text" id="marcaMonitor" name="marcaMonitor" value="${computer.display.monitorBrand}" required>
            </div>
            <div class="form-group">
                <label for="pulgadas">Pulgadas:</label>
                <input type="number" id="pulgadas" name="pulgadas" step="0.01" min="0.01" value="${computer.display.inches}" required>
            </div>
            <div class="form-group full-width">
                <label for="precio">Precio:</label>
                <input type="number" id="precio" name="precio" step="0.01" min="0.01" value="${computer.price.value}" required>
            </div>
        </div>
        <button type="submit" class="btn-primary">Guardar Cambios</button>
    </form>
    <a href="${pageContext.request.contextPath}/menu.jsp" class="btn-secondary">Volver al Menú</a>
</div>
</body>
</html>