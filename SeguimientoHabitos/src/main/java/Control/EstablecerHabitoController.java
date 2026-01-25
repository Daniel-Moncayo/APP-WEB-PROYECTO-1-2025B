package Control;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import Modelo.DAO.CategoriaDAO;
import Modelo.Entities.Categoria;
import Modelo.Entities.Habito;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CrearHabitoController")
public class EstablecerHabitoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		String categoria = req.getParameter("categoria");
		String descripcion = req.getParameter("descripcion");

		this.ruteador(req, resp);

	}

	private void ruteador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ruta = (request.getParameter("ruta") != null) ? request.getParameter("ruta") : "crear";

		switch (ruta) {
		case "crear":
			this.crear(request, response);
			break;

		case "listar":
			this.obtenerTodas(request, response);
			break;

		case "guardar":
			this.guardar(request, response);
			break;

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.ruteador(req, resp);
	}

	private void obtenerTodas(HttpServletRequest req, HttpServletResponse resp) {
		List<Categoria> categoria = CategoriaDAO.obtenerTodas();
		req.setAttribute("categorias", categoria);
		// request.getRequestDispatcher("Vista/NuevoHabito.jsp").forward(request,
	}

	public void crear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("Vista/NuevoHabito.jsp");
		obtenerTodas(req, resp);
	}

	public void guardar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}