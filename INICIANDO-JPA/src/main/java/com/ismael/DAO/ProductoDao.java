package com.ismael.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ismael.model.Productos1;

public class ProductoDao {

	public List<Productos1> productoLista (){
		List<Productos1> listapr = new ArrayList<>();
		
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("INICIANDO-JPA");
		em = emf.createEntityManager();
		
		 try {
			em.getTransaction().begin();
			listapr = em.createQuery("from Productos1").getResultList();
			em.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		
		return listapr;
	}
	public void agregardatos(Productos1 pr) {
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("INICIANDO-JPA");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(pr);
		em.flush();
		em.getTransaction().commit();
		
	}
	public void actualizarDatos(Productos1 pr) {
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("INICIANDO-JPA");
		em = emf.createEntityManager(); 
		pr.getId(); 
		pr.getCantidad_Producto();
		pr.getNombre_Producto();
		pr.getPrecio_Producto();
		pr.getTotal_Producto();
		em.getTransaction().begin();
		em.merge(pr);
			em.flush();
			em.getTransaction().commit();
	}
	public void eliminarDatos(Productos1 pr) {
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("INICIANDO-JPA");
		em = emf.createEntityManager(); 
		em.getTransaction().begin();		
		pr=em.getReference(Productos1.class, pr.getId());
		em.remove(pr);
		em.flush();
		em.getTransaction().commit();
		 
	}
}
