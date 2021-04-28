/**
 * 
 */
package com.devpredator.projectjpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.devpredator.projectjpa.dao.SubGeneroDAO;
import com.devpredator.projectjpa.entity.SubGenero;

/**
 * @author pablo
 * Clase que implementa el CRUD para las transacciones a la tabla de subgenero.
 */
public class SubGeneroDAOImpl implements SubGeneroDAO{
	
	private static final EntityManagerFactory ENTITY_MANAGER = Persistence.createEntityManagerFactory("persistenceDev");

	@Override
	public void guardar(SubGenero subGenero) {
		EntityManager em = ENTITY_MANAGER.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			em.persist(subGenero);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
		} finally {
			em.close();
		}
	}

	@Override
	public void actualizar(SubGenero subGenero) {
		
		EntityManager em = ENTITY_MANAGER.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			em.merge(subGenero);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
		} finally {
			em.close();
		}
		
	}

	@Override
	public void eliminar(Long id) {
		
		EntityManager em = ENTITY_MANAGER.createEntityManager();
		
		SubGenero subGenero = em.find(SubGenero.class, id);
		
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			em.remove(subGenero);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
		} finally {
			em.close();
		}
		
	}

	@Override
	public List<SubGenero> consultar() {
		EntityManager em = ENTITY_MANAGER.createEntityManager();
		
		TypedQuery<SubGenero> query = (TypedQuery<SubGenero>) em.createQuery("FROM SubGenero ORDER BY descripcion");
		
		return query.getResultList();
	}

	@Override
	public SubGenero consultarById(Long id) {
		EntityManager em = ENTITY_MANAGER.createEntityManager();
		return em.find(SubGenero.class, id);
	}

}
