<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error - Habit Tracker</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Vista/Styles/styles.css">
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
                    <h2>Ocurrió un error</h2>
                    <p>Lo sentimos, hubo un problema al procesar tu solicitud.</p>
                </div>

                <div class="habit-stat-card">
                    <p style="color:#7f1d1d; font-weight:600; margin-bottom:12px;">${error}</p>
                    <div style="display:flex; gap:12px;">
                        <a href="${pageContext.request.contextPath}/Vista/EliminarHabito.jsp" class="module-btn">Volver</a>
                        <a href="${pageContext.request.contextPath}/Vista/GestionarHabitos.jsp" class="btn-cancel">Ir al Dashboard</a>
                    </div>
                </div>

            </div>
        </main>
    </div>
</body>
</html>