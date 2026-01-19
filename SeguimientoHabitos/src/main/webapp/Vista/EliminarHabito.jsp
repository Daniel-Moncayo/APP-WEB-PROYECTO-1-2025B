<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Eliminar Hábito - Habit Tracker</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Vista/Styles/styles.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Boldonse&family=Cal+Sans&family=DM+Sans:ital,opsz,wght@0,9..40,100..1000;1,9..40,100..1000&family=Lexend+Deca:wght@100..900&family=Libre+Baskerville:ital,wght@0,400;0,700;1,400&family=Noto+Sans+Bhaiksuki&family=Space+Grotesk:wght@300..700&display=swap" rel="stylesheet">
</head>
<body>
    <div class="dashboard-container">
        <header class="dashboard-header">
            <div class="header-content">
                <h1>Habit Tracker</h1>
                <div class="user-info">
                    <a href="${pageContext.request.contextPath}/Vista/GestionarHabitos.jsp" class="btn-back">← Volver</a>
                </div>
            </div>
        </header>

        <main class="dashboard-main">
            <div class="form-container">
                <div class="form-header">
                    <h2>Eliminar Hábito</h2>
                    <p>Selecciona el hábito que deseas eliminar de la lista</p>
                </div>

                <c:if test="${not empty mensaje}">
                    <div class="success-message">${mensaje}</div>
                </c:if>

                <c:if test="${not empty error}">
                    <div class="error-message">${error}</div>
                </c:if>

                <c:if test="${not empty habitos}">
                    <div class="habitos-list">
                        <c:forEach var="h" items="${habitos}">
                            <div class="habito-item">
                                <div class="habito-info">
                                    <h3>${h.nombre}</h3>
                                    <p class="habito-meta">Categoría: <strong><c:out value="${h.categoria != null ? h.categoria.nombre : 'Sin categoría'}"/></strong></p>
                                    <p class="habito-meta">Inicio: <c:out value="${h.fechaInicio}"/></p>
                                    <p class="habito-meta">Frecuencia: <strong>${h.frecuencia}</strong></p>
                                </div>
                                <div class="habito-schedule">
                                    <form action="${pageContext.request.contextPath}/EliminarHabitoController" method="post">
                                        <input type="hidden" name="accion" value="seleccionar" />
                                        <button type="submit" name="idHabito" value="${h.idHabito}" class="btn-remove-tarea" title="Eliminar hábito">Eliminar</button>
                                    </form>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </c:if>

                <c:if test="${empty habitos}">
                    <p>No se encontraron hábitos.</p>
                </c:if>

            </div>
        </main>
    </div>
</body>
</html>