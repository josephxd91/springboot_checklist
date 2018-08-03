package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.TemaHerramienta;

public interface ITemaHerramientaService {
	public List<TemaHerramienta> findAll();
	public void save(TemaHerramienta temaElemento);
	public TemaHerramienta findOne(Integer id);
	public List<TemaHerramienta> findByTemaHerramienta(String term);
}
