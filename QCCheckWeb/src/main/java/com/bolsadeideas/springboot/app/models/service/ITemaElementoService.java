package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.TemaElemento;

public interface ITemaElementoService {
	public List<TemaElemento> findAll();
	
	public void save(TemaElemento temaElemento);
	
	public TemaElemento findOne(Integer id);
	
	public List<TemaElemento> findByTemaElemento(String term);
	
	
	
}
