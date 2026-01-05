package test;

import Modelo.Entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class test{
	
	public static void main(String[]args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("persistencia");
		EntityManager em = emf.createEntityManager();
		
		//Insertar
		 Usuario daniel = new Usuario();
		
		 em.getTransaction().begin();
		 em.persist(daniel);
		 em.getTransaction().commit();
		 
	}
	
}
