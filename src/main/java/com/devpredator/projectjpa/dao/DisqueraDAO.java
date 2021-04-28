/**
 * 
 */
package com.devpredator.projectjpa.dao;

import java.util.List;

import com.devpredator.projectjpa.entity.Disquera;

/**
 * @author pablo
 * Genera el DAO para las transacciones del CRUD a la tabla de disquera
 */
public interface DisqueraDAO {
	
	void guardar(Disquera disquera);
	
	void actualizar(Disquera disquera);
	
	void eliminar(Long id);
	
	List<Disquera> consultar();
	
	Disquera consultarById(Long id);
	
	Disquera consultarByDescripcionJPQL(String descripcion);
	
	Disquera consultarByDescripcionNative(String descripcion);

}
