package Control;

import java.io.IOException;

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
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	public void eliminarHabito(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//		1. Obtener parámetros
//		2. Hablar con modelo
//		3. Llamar a la vista
		
	}

	public void seleccionarHabito(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	}

}