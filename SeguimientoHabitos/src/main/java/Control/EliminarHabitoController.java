package Control;

import java.io.IOException;
import java.util.List;

import Modelo.DAO.HabitoDAO;
import Modelo.Entities.Habito;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EliminarHabitoController")
public class EliminarHabitoController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.ruteador(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.ruteador(req, resp);
	}

	private void ruteador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = (request.getParameter("accion") != null) ? request.getParameter("accion") : "listar";
		switch (accion) {
			case "listar":
				this.eliminarHabito(request, response);
				break;
			case "seleccionar":
				this.seleccionarHabito(request, response);
				break;
			default:
				this.eliminarHabito(request, response);
				break;
		}
	}

	public void eliminarHabito(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//		1. Obtener parámetros (idUsuario)
//		2. Hablar con modelo (listarHabitos por idUsuario)
//		3. Llamar a la vista (Mostrar lista de hábitos)
		String idUsuarioStr = req.getParameter("idUsuario");
		HabitoDAO dao = new HabitoDAO();
		List<Habito> habitos = null;
		try {
			// Si tuvieramos el id de usuario, filtraríamos aquí. Como aún no está implementado, listamos todos.
			// if (idUsuarioStr != null) {
			//     int idUsuario = Integer.parseInt(idUsuarioStr);
			//     habitos = dao.listarPorUsuario(idUsuario);
			// } else {
				habitos = dao.listarHabitos();
			// }
			req.setAttribute("habitos", habitos);
			// Forward a la vista que mostrará la lista y permitirá seleccionar uno para eliminar
			requestDispatcherForward(req, resp, "/Vista/EliminarHabito.jsp");
		} catch (Exception e) {
			req.setAttribute("error", "No se pudieron obtener los hábitos.");
			requestDispatcherForward(req, resp, "/Vista/MensajeError.jsp");
		}
		
	}

	public void seleccionarHabito(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String idHabitoStr = req.getParameter("idHabito");
		HabitoDAO dao = new HabitoDAO();
		if (idHabitoStr == null || idHabitoStr.isEmpty()) {
			req.setAttribute("error", "No se indicó el hábito a eliminar.");
			requestDispatcherForward(req, resp, "/Vista/MensajeError.jsp");
			return;
		}

		try {
			int idHabito = Integer.parseInt(idHabitoStr);
			// Intentar eliminar
			boolean eliminado = dao.eliminarHabito(idHabito);

			if (eliminado) {
				// Volver a listar hábitos para mostrar la lista actualizada
				List<Habito> habitosActualizados = dao.listarHabitos();
				req.setAttribute("habitos", habitosActualizados);
				req.setAttribute("mensaje", "El hábito fue eliminado correctamente.");
				requestDispatcherForward(req, resp, "/Vista/MensajeEliminado.jsp");
			} else {
				req.setAttribute("error", "No se encontró el hábito a eliminar o no se pudo eliminar.");
				requestDispatcherForward(req, resp, "/Vista/MensajeError.jsp");
			}
		} catch (NumberFormatException nfe) {
			req.setAttribute("error", "Id de hábito inválido.");
			requestDispatcherForward(req, resp, "/Vista/MensajeError.jsp");
		} catch (Exception e) {
			req.setAttribute("error", "Ocurrió un error al eliminar el hábito.");
			requestDispatcherForward(req, resp, "/Vista/MensajeError.jsp");
		}
	}

	// Small helper to keep forwarding code concise
	private void requestDispatcherForward(HttpServletRequest req, HttpServletResponse resp, String vista) throws ServletException, IOException {
		req.getRequestDispatcher(vista).forward(req, resp);
	}

}