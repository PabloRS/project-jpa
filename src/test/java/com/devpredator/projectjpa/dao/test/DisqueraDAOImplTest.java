/**
 * 
 */
package com.devpredator.projectjpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.devpredator.projectjpa.dao.DisqueraDAO;
import com.devpredator.projectjpa.dao.impl.DisqueraDAOImpl;
import com.devpredator.projectjpa.entity.Disquera;

/**
 * @author pablo
 *
 */
class DisqueraDAOImplTest {
	
	private DisqueraDAO disqueraDao = new DisqueraDAOImpl();

	/**
	 * Test method for {@link com.devpredator.projectjpa.dao.impl.DisqueraDAOImpl#guardar(com.devpredator.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testGuardar() {
		Disquera disquera = new Disquera();
		disquera.setDescripcion("Elektrik");
		disquera.setFechaCreacion(LocalDateTime.now());
		disquera.setEstatus(true);
		
		this.disqueraDao.guardar(disquera);
	}

	/**
	 * Test method for {@link com.devpredator.projectjpa.dao.impl.DisqueraDAOImpl#actualizar(com.devpredator.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testActualizar() {
		Disquera disquera = this.disqueraDao.consultarById(9L);
		
		disquera.setDescripcion("Disquera IronMaiden");
		
		this.disqueraDao.actualizar(disquera);
	}

	/**
	 * Test method for {@link com.devpredator.projectjpa.dao.impl.DisqueraDAOImpl#eliminar(com.devpredator.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testEliminar() {
		Long id = 9L;
		
		this.disqueraDao.eliminar(id);
	}

	/**
	 * Test method for {@link com.devpredator.projectjpa.dao.impl.DisqueraDAOImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		List<Disquera> disqueras = this.disqueraDao.consultar();
		assertTrue(disqueras.size() > 0);
		
		disqueras.forEach(disquera -> System.out.println(disquera.getDescripcion()));
	}

	/**
	 * Test method for {@link com.devpredator.projectjpa.dao.impl.DisqueraDAOImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		Disquera disquera = this.disqueraDao.consultarById(9L);
		System.out.println("Disquera: " + disquera.getDescripcion());
	}

}
