package Modelo.DAO;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import Modelo.Entities.Categoria;

public class CategoriaDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public CategoriaDAO() {
		emf = Persistence.createEntityManagerFactory("persistencia");
		em = emf.createEntityManager();
		inicializarCategorias();
	}
	
	private void inicializarCategorias() {
		try {
			TypedQuery<Long> query = em.createQuery("SELECT COUNT(c) FROM Categoria c", Long.class);
			Long count = query.getSingleResult();
			
			if (count == 0) {
				em.getTransaction().begin();
				
				Categoria deporte = new Categoria();
				deporte.setNombre("Deporte");
				em.persist(deporte);
				
				Categoria salud = new Categoria();
				salud.setNombre("Salud");
				em.persist(salud);
				
				Categoria estiloVida = new Categoria();
				estiloVida.setNombre("Estilo de vida");
				em.persist(estiloVida);
				
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Categoria> obtenerTodas() {
		TypedQuery<Categoria> query = em.createQuery("SELECT c FROM Categoria c", Categoria.class);
		return query.getResultList();
	}
}