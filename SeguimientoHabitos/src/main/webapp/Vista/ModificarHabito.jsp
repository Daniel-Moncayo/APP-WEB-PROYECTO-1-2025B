<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Planificar Hábitos - Habit Tracker</title>
    <link rel="stylesheet" href="Styles/styles.css">
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
                	<!-- 
                    <span>demo@mail.com</span>
                	 -->
                    <a href="../GestionarHabitoController" class="btn-back">← Volver</a>
                </div>
            </div>
        </header>

        <main class="dashboard-main">
            <div class="form-container">
                <div class="form-header">
                    <h2>Planificar Hábitos</h2>
                    <p>Selecciona un hábito para modificar su planificación</p>
                </div>

                <!-- Lista de Hábitos -->
                <div class="habitos-list">
                    <div class="habito-item" onclick="editarHabito(1)">
                        <div class="habito-info">
                            <h3>Hacer Ejercicio</h3>
                            <span class="habito-badge">Personal</span>
                        </div>
                        <div class="habito-schedule">
                            <p>📅 Lun, Mié, Vie</p>
                            <p>⏰ 06:00 AM</p>
                        </div>
                        <button class="btn-edit">Editar →</button>
                    </div>

                    <div class="habito-item" onclick="editarHabito(2)">
                        <div class="habito-info">
                            <h3>Leer 30 minutos</h3>
                            <span class="habito-badge">Educativo</span>
                        </div>
                        <div class="habito-schedule">
                            <p>📅 Todos los días</p>
                            <p>⏰ 08:00 PM</p>
                        </div>
                        <button class="btn-edit">Editar →</button>
                    </div>

                    <div class="habito-item" onclick="editarHabito(3)">
                        <div class="habito-info">
                            <h3>Meditar</h3>
                            <span class="habito-badge">Personal</span>
                        </div>
                        <div class="habito-schedule">
                            <p>📅 Lun a Vie</p>
                            <p>⏰ 07:00 AM</p>
                        </div>
                        <button class="btn-edit">Editar →</button>
                    </div>
                </div>
            </div>
        </main>

        <!-- Modal cuando no hay hábitos -->
        <div class="modal" id="noHabitsModal">
            <div class="modal-content">
                <h2>Sin Hábitos Creados</h2>
                <p>Todavía no has creado ningún hábito. Empieza creando uno desde el menú principal.</p>
                <button class="btn-close" onclick="redirectToMain()">Ir al Menú Principal</button>
            </div>
        </div>
    </div>

    <script>
        // Simular si hay hábitos (cambiar a false para mostrar el modal)
        const tieneHabitos = true;

        window.addEventListener('DOMContentLoaded', function() {
            if (!tieneHabitos) {
                document.getElementById('noHabitsModal').classList.add('show');
            }
        });

        function editarHabito(habitoId) {
            // Guardar el ID del hábito para editar
            localStorage.setItem('habitoEditarId', habitoId);
            window.location.href = 'ModificarHabito.jsp';
        }

        function redirectToMain() {
            window.location.href = 'GestionarHabito.jsp';
        }
    </script>
</body>
</html>
