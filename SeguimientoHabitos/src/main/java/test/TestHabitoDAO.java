package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import Modelo.Entities.Categoria;
import Modelo.Entities.Habito;

public class TestHabitoDAO {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager em = emf.createEntityManager();
		
		try {
			// Primero obtenemos una categoría existente
			TypedQuery<Categoria> queryCategoria = em.createQuery("SELECT c FROM Categoria c WHERE c.nombre = :nombre", Categoria.class);
			queryCategoria.setParameter("nombre", "Deporte");
			Categoria categoriaDeporte = queryCategoria.getSingleResult();
			
			// Crear fechas para los hábitos
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
			
			// Hábito 1: Correr - Planificado
			Habito correr = new Habito();
			correr.setNombre("Correr");
			correr.setCategoria(categoriaDeporte);
			correr.setFechaInicio(sdf.parse("2026-01-01"));
			correr.setFrecuencia(3); // 3 veces por semana
			correr.setDia("Lunes, Miércoles, Viernes");
			correr.setHorario(sdfTime.parse("07:00:00"));
			
			// Hábito 2: Gimnasio - Sin planificar
			Habito gimnasio = new Habito();
			gimnasio.setNombre("Ir al gimnasio");
			gimnasio.setCategoria(categoriaDeporte);
			gimnasio.setFechaInicio(sdf.parse("2026-01-05"));
			// Sin frecuencia, día ni horario (no planificado)
			
			// Hábito 3: Yoga - Planificado
			TypedQuery<Categoria> querySalud = em.createQuery("SELECT c FROM Categoria c WHERE c.nombre = :nombre", Categoria.class);
			querySalud.setParameter("nombre", "Salud");
			Categoria categoriaSalud = querySalud.getSingleResult();
			
			Habito yoga = new Habito();
			yoga.setNombre("Practicar yoga");
			yoga.setCategoria(categoriaSalud);
			yoga.setFechaInicio(sdf.parse("2026-01-10"));
			yoga.setFrecuencia(2);
			yoga.setDia("Martes, Jueves");
			yoga.setHorario(sdfTime.parse("18:30:00"));
			
			// Insertar los hábitos
			em.getTransaction().begin();
			em.persist(correr);
			em.persist(gimnasio);
			em.persist(yoga);
			em.getTransaction().commit();
			
			System.out.println("✓ Hábitos insertados correctamente");
			System.out.println("  - Correr (Planificado)");
			System.out.println("  - Ir al gimnasio (Sin planificar)");
			System.out.println("  - Practicar yoga (Planificado)");
			
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			System.err.println("Error al insertar hábitos:");
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}