package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.models.entity.TemaElemento;

public interface ITemaElementoDao extends CrudRepository<TemaElemento, Integer> {

	@Query("select te from TemaElemento te where te.temaElemento like %?1%")
	public List<TemaElemento> findByNombre(String term);
}
