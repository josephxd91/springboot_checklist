package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.app.models.dao.ITemaHerramientaDao;
import com.bolsadeideas.springboot.app.models.entity.TemaHerramienta;

@Service
public class TemaHerramientaServiceImpl implements ITemaHerramientaService{
	
	
	@Autowired
	private ITemaHerramientaDao temaHerramientaDao;

	@Override
	public List<TemaHerramienta> findAll() {
		return (List<TemaHerramienta>) temaHerramientaDao.findAll();
	}

	@Override
	public void save(TemaHerramienta temaElemento) {
		// TODO Auto-generated method stub
		temaHerramientaDao.save(temaElemento);
	}

	@Override
	public TemaHerramienta findOne(Integer id) {
		return temaHerramientaDao.findById(id).orElse(null);
	}

	@Override
	public List<TemaHerramienta> findByTemaHerramienta(String term) {
		// TODO Auto-generated method stub
		return null;
	}

}
