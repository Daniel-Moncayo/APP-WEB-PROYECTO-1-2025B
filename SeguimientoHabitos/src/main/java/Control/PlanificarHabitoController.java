package Control;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PlanificarHabitoController")
public class PlanificarHabitoController extends HttpServlet{

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

		String ruta = (request.getParameter("ruta") != null) ? request.getParameter("ruta") : "seleccionar";

		switch (ruta) {
		case "seleccionar":
			this.seleccionarPlanificarHabito(request, response);
			break;
		case "crear":
			this.crear(request, response);
			break;

		case "listar":
			this.obtenerSinPlanificacion(request, response);
			break;

		case "guardar":
			this.guardar(request, response);
			break;

		}
	}


	private void seleccionarPlanificarHabito(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.sendRedirect("Vista/PlanificarHabito.jsp");
	}

	public void crear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO - implement PlanificarHabitoController.crear
		throw new UnsupportedOperationException();
	}

	public void guardar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO - implement PlanificarHabitoController.guardar
		throw new UnsupportedOperationException();
	}
	
	public void obtenerSinPlanificacion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO - implement PlanificarHabitoController.obtenerSinPlanificacion
		throw new UnsupportedOperationException();
	}

}