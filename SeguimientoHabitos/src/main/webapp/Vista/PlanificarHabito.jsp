<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Planificar Hábito - Habit Tracker</title>
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
                    <a href="GestionarHabitos.jsp" class="btn-back">← Volver</a>
                </div>
            </div>
        </header>

        <main class="dashboard-main">
            <div class="form-container">
                <div class="form-header">
                    <h2>Planificar Hábito</h2>
                    <p>Define los días, horarios y tareas para tu hábito</p>
                </div>

                <form method="POST" action="PlanificarHabitoController" class="habit-form" id="planificarForm" novalidate>
                    <!-- Selección de días -->
                    <div class="form-section">
                        <h3>Días de la Semana <span class="required">*</span></h3>
                        <div class="days-grid">
                            <label class="day-checkbox">
                                <input type="checkbox" name="dias" value="lunes">
                                <span class="day-label">Lunes</span>
                            </label>
                            <label class="day-checkbox">
                                <input type="checkbox" name="dias" value="martes">
                                <span class="day-label">Martes</span>
                            </label>
                            <label class="day-checkbox">
                                <input type="checkbox" name="dias" value="miercoles">
                                <span class="day-label">Miércoles</span>
                            </label>
                            <label class="day-checkbox">
                                <input type="checkbox" name="dias" value="jueves">
                                <span class="day-label">Jueves</span>
                            </label>
                            <label class="day-checkbox">
                                <input type="checkbox" name="dias" value="viernes">
                                <span class="day-label">Viernes</span>
                            </label>
                            <label class="day-checkbox">
                                <input type="checkbox" name="dias" value="sabado">
                                <span class="day-label">Sábado</span>
                            </label>
                            <label class="day-checkbox">
                                <input type="checkbox" name="dias" value="domingo">
                                <span class="day-label">Domingo</span>
                            </label>
                        </div>
                    </div>

                    <!-- Hora -->
                    <div class="form-group">
                        <label for="hora">Hora <span class="required">*</span></label>
                        <input type="time" id="hora" name="hora">
                    </div>

                    <!-- Tareas -->
                    <div class="form-section">
                        <h3>Tareas Asociadas <span class="required">*</span></h3>
                        <p class="section-description">Agrega al menos una tarea que realizarás para cumplir este hábito</p>
                        
                        <div id="tareasContainer">
                            <div class="tarea-item">
                                <input type="text" class="tarea-input" placeholder="Ej: Ir al gimnasio">
                                <button type="button" class="btn-remove-tarea" onclick="removeTarea(this)">✕</button>
                            </div>
                        </div>
                        
                        <button type="button" class="btn-add-tarea" onclick="addTarea()">+ Agregar otra tarea</button>
                    </div>

                    <div class="form-actions">
                        <button type="submit" class="btn-submit">Guardar Planificación</button>
                        <a href="GestionarHabitos.jsp" class="btn-cancel">Volver</a>
                    </div>
                </form>
            </div>
        </main>

        <!-- Modal de error -->
        <div class="modal" id="errorModal">
            <div class="modal-content">
                <h2>Campos Incompletos</h2>
                <p id="errorMessage">Por favor, completa todos los campos obligatorios.</p>
                <button class="btn-close" onclick="closeModal()">Entendido</button>
            </div>
        </div>
    </div>

    <script>
        function addTarea() {
            const container = document.getElementById('tareasContainer');
            const tareaItem = document.createElement('div');
            tareaItem.className = 'tarea-item';
            tareaItem.innerHTML = `
                <input type="text" class="tarea-input" placeholder="Ej: Ir al gimnasio">
                <button type="button" class="btn-remove-tarea" onclick="removeTarea(this)">✕</button>
            `;
            container.appendChild(tareaItem);
        }

        function removeTarea(button) {
            const tareasContainer = document.getElementById('tareasContainer');
            if (tareasContainer.children.length > 1) {
                button.parentElement.remove();
            }
        }

        document.getElementById('planificarForm').addEventListener('submit', function(e) {
            e.preventDefault();
            
            // Validar días seleccionados
            const diasCheckboxes = document.querySelectorAll('input[name="dias"]:checked');
            const hora = document.getElementById('hora').value;
            
            // Validar tareas
            const tareasInputs = document.querySelectorAll('.tarea-input');
            const tareas = Array.from(tareasInputs).filter(input => input.value.trim() !== '');
            
            let errorMessage = '';
            
            if (diasCheckboxes.length === 0) {
                errorMessage = 'Por favor, selecciona al menos un día de la semana.';
            } else if (!hora) {
                errorMessage = 'Por favor, selecciona una hora para el hábito.';
            } else if (tareas.length === 0) {
                errorMessage = 'Por favor, agrega al menos una tarea asociada al hábito.';
            }
            
            if (errorMessage) {
                document.getElementById('errorMessage').textContent = errorMessage;
                document.getElementById('errorModal').classList.add('show');
            } else {
                // Guardar y redirigir
                alert('Hábito planificado exitosamente');
                window.location.href = 'pantalla-principal.html';
            }
        });
        
        function closeModal() {
            document.getElementById('errorModal').classList.remove('show');
        }
        
        document.getElementById('errorModal').addEventListener('click', function(e) {
            if (e.target === this) {
                this.classList.remove('show');
            }
        });
    </script>
</body>
</html>