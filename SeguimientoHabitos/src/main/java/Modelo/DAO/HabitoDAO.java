package Modelo.DAO;

import java.util.List;

import Modelo.Entities.Categoria;
import Modelo.Entities.Habito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class HabitoDAO {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
	private static EntityManager em;

	public HabitoDAO() {}

	private void inicializarHabitos() {
		try {
			TypedQuery<Long> query = em.createQuery("SELECT COUNT(h) FROM Habito h", Long.class);
			Long count = query.getSingleResult();
			
			if (count == 0) {
				System.out.println("No hay habitos, se iniciaran datos por defecto...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Guarda un hábito deseado
	 * @param habito
	 */
	public static void guardar(Habito habito, int idCategoria) {
        // Creamos un EntityManager nuevo para cada operación (Más seguro para web)
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            
            // Buscamos la categoría
            Categoria cat = em.find(Categoria.class, idCategoria);
            
            if (cat != null) {
                habito.setCategoria(cat);
                em.persist(habito);
                em.getTransaction().commit();
                System.out.println("Hábito guardado con éxito.");
            } else {
                System.err.println("ERROR: No existe la categoría con ID " + idCategoria);
            }
            
        } catch (Exception e) {
            System.err.println("ERROR AL GUARDAR EN BD:");
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            // Cerramos el gestor
            em.close();
        }
    }
	
	/**
	 * Obtiene habitos que no han sido planificados
	 * @param planificado
	 */
	public void obtenerSinPlanificacion() {
		List<Habito> habitos = listarHabitos();

		// Filtrar hábitos NO planificados
		for (Habito habito : habitos) {
		    if (habito.getFrecuencia() <= 0 || habito.getDia() == null || habito.getHorario() == null) {
		        // Hábito NO está planificado
		        System.out.println("Hábito NO planificado: " + habito.getNombre());
		    }
		}
	}

	/**
	 * Lista todos los hábitos
	 * @return una lista de hábitos creados
	 */
	public List<Habito> listarHabitos() {
		return em.createQuery("SELECT h FROM Habito h", Habito.class).getResultList();
	}

	public void actualizarHabito(Habito habito) {
		try {
			em.getTransaction().begin();
			em.merge(habito);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	/**
	 * Eliminar habitos por su id
	 * @param id del hábito
	 * @return true si se eliminó, false si no se encontró
	 */
	public boolean eliminarHabito(int id) {
		try {
			Habito h = em.find(Habito.class, id);
			if (h != null) {
				em.getTransaction().begin();
				em.remove(h);
				em.getTransaction().commit();
				return true;
			}
			return false;
		} catch (Exception e) {
			try { em.getTransaction().rollback(); } catch (Exception ex) { }
			return false;
		}
	}

}