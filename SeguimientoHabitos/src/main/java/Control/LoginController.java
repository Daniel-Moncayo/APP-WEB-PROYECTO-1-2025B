package Control;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Modelo.DAO.UsuarioDAO;
import Modelo.Entities.Usuario;

import java.io.IOException;

public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO;

    public LoginController() {
        super();
        this.usuarioDAO = new UsuarioDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Redirigir a la página de login
        request.getRequestDispatcher("/Vista/Login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String correoElectronico = request.getParameter("correoElectronico");
        String password = request.getParameter("password");

        // Validar que los campos no estén vacíos
        if (correoElectronico == null || correoElectronico.trim().isEmpty() || 
            password == null || password.trim().isEmpty()) {
            request.setAttribute("error", "Por favor, complete todos los campos");
            request.getRequestDispatcher("/Vista/Login.jsp").forward(request, response);
            return;
        }

        // Autenticar usuario
        Usuario usuario = usuarioDAO.autenticar(correoElectronico.trim(), password);

        if (usuario != null) {
            // Crear sesión
            HttpSession session = request.getSession(true);
            session.setAttribute("usuarioId", usuario.getIdUsuario());
            session.setAttribute("usuarioNombre", usuario.getNombre());
            session.setAttribute("usuarioApellido", usuario.getApellido());
            session.setAttribute("usuarioCorreo", usuario.getCorreoElectronico());
            session.setAttribute("usuarioRol", usuario.getRol());

            // Redirigir según el rol
            if ("admin".equalsIgnoreCase(usuario.getRol())) {
                response.sendRedirect(request.getContextPath() + "/Vista/DashboardAdmin.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/Vista/GestionarHabitos.jsp");
            }
        } else {
            // Credenciales incorrectas
            request.setAttribute("error", "Correo electrónico o contraseña incorrectos");
            request.getRequestDispatcher("/Vista/Login.jsp").forward(request, response);
        }
    }
}
