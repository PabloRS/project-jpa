package com.devpredator.projectjpa.dao;

import java.util.List;

import com.devpredator.projectjpa.entity.SubGenero;

/**
 * 
 * @author pablo
 * Interfaz que realiza el CRUD para la tabla de subgenero.
 */
public interface SubGeneroDAO {
	
	void guardar(SubGenero subGenero);
	
	void actualizar(SubGenero subGenero);
	
	void eliminar(Long id);
	
	List<SubGenero> consultar();
	
	SubGenero consultarById(Long id);

}
