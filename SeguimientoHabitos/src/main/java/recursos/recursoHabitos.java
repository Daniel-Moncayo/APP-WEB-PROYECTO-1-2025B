package recursos;
import java.util.List;

import Modelo.DAO.HabitoDAO;
import Modelo.Entities.Habito;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.PathParam;

@Path("/habitos")

public class recursoHabitos {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Habito> getHabitos(){
		return HabitoDAO.listarHabitos();
	}
	
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void eliminarHabito(@PathParam("id") int id) {
		HabitoDAO.eliminarHabito(id);
	}
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public void guardarHabito(Habito h) {
		HabitoDAO.guardar(h, h.getCategoria().getIdCategoria());
	}
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public void actualizarHabito(Habito h) {
		HabitoDAO.actualizarHabito(h);
	}

}
