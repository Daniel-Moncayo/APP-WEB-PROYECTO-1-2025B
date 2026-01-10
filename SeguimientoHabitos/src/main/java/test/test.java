package test;

import Modelo.Entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class test {

	public static void main(String[]args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("persistence");
		EntityManager em = emf.createEntityManager();
		
		//Insertar
		 Usuario jhair = new Usuario( "Jhairoso", "Zambrano", "jhair@ejemplo.com", "12354456");
		
		 em.getTransaction().begin();
		 em.persist(jhair);
		 em.getTransaction().commit();
		 }
}
