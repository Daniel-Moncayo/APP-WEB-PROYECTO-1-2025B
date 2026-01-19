<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Nuevo Hábito - Habit Tracker</title>
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
                    <h2>Crear Nuevo Hábito</h2>
                    <p>Completa los campos para definir tu nuevo hábito</p>
                </div>

                <form method="POST" action="../CrearHabitoController" class="habit-form" id="habitForm" novalidate>
                    <div class="form-group">
                        <label for="nombre">Nombre del Hábito <span class="required">*</span></label>
                        <input type="text" id="nombre" name="nombre" placeholder="Ej: Hacer ejercicio">
                    </div>

                    <div class="form-group">
                        <label for="categoria">Categoría <span class="required">*</span></label>
                        <select id="categoria" name="categoria">
                            <option value="">Selecciona una categoría</option>
                            <option value="laboral">Laboral</option>
                            <option value="personal">Personal</option>
                            <option value="educativo">Educativo</option>
                            <option value="otros">Otros</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="descripcion">Descripción (Opcional)</label>
                        <textarea id="descripcion" name="descripcion" rows="4" placeholder="Describe tu hábito..."></textarea>
                    </div>

                    <div class="form-actions">
                        <button type="submit" class="btn-submit">Crear Hábito</button>
                        <!-- 
                        <a href="../index.jsp" class="btn-cancel">Cancelar</a>
                         -->
                    </div>
                </form>
            </div>
        </main>

        <!-- Modal de error -->
        <div class="modal" id="errorModal">
            <div class="modal-content">
                <h2>Campos Incompletos</h2>
                <p>Por favor, completa todos los campos obligatorios (Nombre y Categoría) antes de continuar.</p>
                <button class="btn-close" onclick="closeModal()">Entendido</button>
            </div>
        </div>
    </div>

    <script>
        document.getElementById('habitForm').addEventListener('submit', function(e) {
            e.preventDefault();
            
            const nombre = document.getElementById('nombre').value.trim();
            const categoria = document.getElementById('categoria').value;
            
            if (!nombre || !categoria) {
                document.getElementById('errorModal').classList.add('show');
            } else {
                // Redirigir a planificar hábito
                window.location.href = 'PlanificarHabito.jsp';
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
