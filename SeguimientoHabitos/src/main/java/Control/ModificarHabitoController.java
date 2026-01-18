package Control;

import java.io.IOException;
import java.util.List;

import Modelo.Entities.Habito;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ModificarHabitoController")
public class ModificarHabitoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	public boolean actualizarHabito(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		throw new UnsupportedOperationException();
	}

	public List<Habito> listarHabitos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO - implement ModificarHabitoController.listarHabitos
		throw new UnsupportedOperationException();
	}

	public boolean validarDatosModificados(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO - implement ModificarHabitoController.validarDatosModificados
		throw new UnsupportedOperationException();
	}

	public boolean modificarCamposFormulario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO - implement ModificarHabitoController.modificarCamposFormulario
		throw new UnsupportedOperationException();
	}

}