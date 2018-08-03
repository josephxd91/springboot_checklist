package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.ITemaElementoDao;
import com.bolsadeideas.springboot.app.models.entity.TemaElemento;
@Service
public class TemaElementoServiceImpl  implements ITemaElementoService {
	
	@Autowired
	private ITemaElementoDao temaElementoDao;
	

	@Override
	public List<TemaElemento> findAll() {
		return (List<TemaElemento>) temaElementoDao.findAll();
	}

	@Override
	@Transactional
	public void save(TemaElemento temaElemento) {
		temaElementoDao.save(temaElemento);
	}

	@Override
	@Transactional(readOnly = true)
	public TemaElemento findOne(Integer id) {
		return temaElementoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TemaElemento> findByTemaElemento(String term) {
		return temaElementoDao.findByNombre(term);
	}

	

	
}
