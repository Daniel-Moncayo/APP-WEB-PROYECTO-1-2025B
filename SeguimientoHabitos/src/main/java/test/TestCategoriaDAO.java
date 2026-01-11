package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import Modelo.Entities.Categoria;

public class TestCategoriaDAO {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager em = emf.createEntityManager();
		
		// Insertar categorías
		Categoria deporte = new Categoria();
		deporte.setNombre("Deporte");
		
		Categoria salud = new Categoria();
		salud.setNombre("Salud");
		
		Categoria estiloVida = new Categoria();
		estiloVida.setNombre("Estilo de vida");
		
		em.getTransaction().begin();
		em.persist(deporte);
		em.persist(salud);
		em.persist(estiloVida);
		em.getTransaction().commit();
		
		System.out.println("Categorías insertadas correctamente");
	}
}