package Control;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import Modelo.Entities.Habito;
import Modelo.Entities.Categoria;
import Modelo.DAO.HabitoDAO;
import Modelo.DAO.CategoriaDAO;

/**
 * REST API Controller for Habit Management
 * Base Path: /api/habitos
 * 
 * Example URLs:
 * - GET  /api/habitos                 -> List all habits
 * - GET  /api/habitos/1               -> Get habit by ID
 * - POST /api/habitos                 -> Create new habit
 * - PUT  /api/habitos/1               -> Update habit
 * - DELETE /api/habitos/1             -> Delete habit
 */
@Path("/habitos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HabitoRestController {
    
    private HabitoDAO habitoDAO = new HabitoDAO();
    private CategoriaDAO categoriaDAO = new CategoriaDAO();
    
    /**
     * GET all habits
     * @return List of all habits
     */
    @GET
    public Response obtenerTodos() {
        try {
            List<Habito> habitos = habitoDAO.obtenerTodos();
            return Response.ok(habitos).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\": \"" + e.getMessage() + "\"}")
                    .build();
        }
    }
    
    /**
     * GET habit by ID
     * @param id The habit ID
     * @return Habit object
     */
    @GET
    @Path("/{id}")
    public Response obtenerPorId(@PathParam("id") int id) {
        try {
            Habito habito = habitoDAO.obtenerPorId(id);
            if (habito != null) {
                return Response.ok(habito).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("{\"error\": \"Habit not found\"}")
                        .build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\": \"" + e.getMessage() + "\"}")
                    .build();
        }
    }
    
    /**
     * POST - Create a new habit
     * @param habito Habit object from JSON body
     * @return Created habit with ID
     */
    @POST
    public Response crear(Habito habito) {
        try {
            habitoDAO.crear(habito);
            return Response.status(Response.Status.CREATED)
                    .entity(habito)
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"" + e.getMessage() + "\"}")
                    .build();
        }
    }
    
    /**
     * PUT - Update an existing habit
     * @param id The habit ID
     * @param habito Updated habit object
     * @return Updated habit
     */
    @PUT
    @Path("/{id}")
    public Response actualizar(@PathParam("id") int id, Habito habito) {
        try {
            Habito existente = habitoDAO.obtenerPorId(id);
            if (existente != null) {
                habito.setIdHabito(id);
                habitoDAO.actualizar(habito);
                return Response.ok(habito).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("{\"error\": \"Habit not found\"}")
                        .build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"" + e.getMessage() + "\"}")
                    .build();
        }
    }
    
    /**
     * DELETE - Delete a habit
     * @param id The habit ID
     * @return No content response
     */
    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id) {
        try {
            Habito habito = habitoDAO.obtenerPorId(id);
            if (habito != null) {
                habitoDAO.eliminar(id);
                return Response.noContent().build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("{\"error\": \"Habit not found\"}")
                        .build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\": \"" + e.getMessage() + "\"}")
                    .build();
        }
    }
    
    /**
     * GET habits by category
     * @param categoryId The category ID
     * @return List of habits in the category
     */
    @GET
    @Path("/categoria/{categoryId}")
    public Response obtenerPorCategoria(@PathParam("categoryId") int categoryId) {
        try {
            List<Habito> habitos = habitoDAO.obtenerPorCategoria(categoryId);
            return Response.ok(habitos).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\": \"" + e.getMessage() + "\"}")
                    .build();
        }
    }
}
