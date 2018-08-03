package com.bolsadeideas.springboot.app.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bolsadeideas.springboot.app.models.entity.TemaElemento;
import com.bolsadeideas.springboot.app.models.entity.TemaHerramienta;
import com.bolsadeideas.springboot.app.models.service.TemaElementoServiceImpl;
import com.bolsadeideas.springboot.app.models.service.TemaHerramientaServiceImpl;


@Controller
public class IndexController {
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private TemaElementoServiceImpl temaElementoService;
	
	@Autowired
	private TemaHerramientaServiceImpl temaHerramientaService;

	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = {"/content_sections"}, method = RequestMethod.GET)
	public String content_sections(Model model) {
		
		if(temaElementoService.findAll()!=null) {
			List<TemaElemento> temaElementos = temaElementoService.findAll();
			for(TemaElemento temaElemento : temaElementos) {
				logger.info("ELEMENTOS : ".concat(temaElemento.toString()));
			}
			TemaHerramienta temaHerramienta =   temaHerramientaService.findOne(new Integer(1));
			logger.info("ELEMENTOS - HERRAMIENTA 1 : ".concat(""+temaHerramienta.getTemaElementoList().size()));
		}
		model.addAttribute("herramientas",temaHerramientaService.findAll());
		return "/validacion/content_sections";
	}
	
	
	@RequestMapping(value= {"/content_sections/section/{level}/{id}"}, method=RequestMethod.GET )
	public String section(@PathVariable(value= "level") Integer level,@PathVariable(value= "id") Integer id,Model model ) {
		
		TemaHerramienta temaHerramienta;
		TemaElemento temaElemento;
		if(level==0) {
			temaHerramienta = temaHerramientaService.findOne(id);
			model.addAttribute("herramienta",temaHerramienta );
		}else {
			temaElemento = temaElementoService.findOne(id);
			model.addAttribute("elemento",temaElemento );
		}
		
		
		logger.info("ELEMENTOS : ".concat(""+id.intValue()));
		return "/validacion/section";
	}
}
