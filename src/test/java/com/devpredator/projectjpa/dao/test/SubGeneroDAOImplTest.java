/**
 * 
 */
package com.devpredator.projectjpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.devpredator.projectjpa.dao.SubGeneroDAO;
import com.devpredator.projectjpa.dao.impl.SubGeneroDAOImpl;
import com.devpredator.projectjpa.entity.Genero;
import com.devpredator.projectjpa.entity.SubGenero;

/**
 * @author pablo
 * Clase test para comprobar el funcionamiento de los metodos CRUD de subgenero.
 */
class SubGeneroDAOImplTest {
	
	private SubGeneroDAO subGeneroDao = new SubGeneroDAOImpl();

	/**
	 * Test method for {@link com.devpredator.projectjpa.dao.impl.SubGeneroDAOImpl#guardar(com.devpredator.projectjpa.entity.SubGenero)}.
	 */
	@Test
	void testGuardar() {
		SubGenero subgenero = new SubGenero();
		subgenero.setDescripcion("Hard Core");
		subgenero.setFechaCreacion(LocalDateTime.now());
		subgenero.setEstatus(true);
		
		Genero genero = new Genero();
		genero.setDescripcion("Metal");
		genero.setFechaCreacion(LocalDateTime.now());
		genero.setEstatus(true);
		
		subgenero.setGenero(genero);
		
		this.subGeneroDao.guardar(subgenero);
		
	}

	/**
	 * Test method for {@link com.devpredator.projectjpa.dao.impl.SubGeneroDAOImpl#actualizar(com.devpredator.projectjpa.entity.SubGenero)}.
	 */
	@Test
	void testActualizar() {
		SubGenero subGenero = this.subGeneroDao.consultarById(7L);
		
		subGenero.setDescripcion("Trash Metal");
		subGenero.getGenero().setDescripcion("Metal Trash");
		
		this.subGeneroDao.actualizar(subGenero);
	}

	/**
	 * Test method for {@link com.devpredator.projectjpa.dao.impl.SubGeneroDAOImpl#eliminar(java.lang.Long)}.
	 */
	@Test
	void testEliminar() {
		this.subGeneroDao.eliminar(7L);
	}

	/**
	 * Test method for {@link com.devpredator.projectjpa.dao.impl.SubGeneroDAOImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		List<SubGenero> subGeneros = this.subGeneroDao.consultar();
		
		assertTrue(subGeneros.size() > 0);
		
		for(SubGenero subGenero: subGeneros) {
			System.out.println("Subgenero: " + subGenero.getDescripcion());
			System.out.println("Genero: " + subGenero.getGenero().getDescripcion());
		}
	}

	/**
	 * Test method for {@link com.devpredator.projectjpa.dao.impl.SubGeneroDAOImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		fail("Not yet implemented");
	}

}
