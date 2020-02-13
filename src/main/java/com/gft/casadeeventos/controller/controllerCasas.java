package com.gft.casadeeventos.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gft.casadeeventos.model.Casa;
import com.gft.casadeeventos.repository.casas;



@Controller
@RequestMapping("/casadeshow")
public class controllerCasas {

	@Autowired
	private casas cas;
	
	@RequestMapping
	public ModelAndView pesquisacasa() {
		List<Casa> casas =  cas.findAll();
		ModelAndView mv = new ModelAndView("Casas");
		mv.addObject(new Casa());
		mv.addObject("casas", casas);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Casa casaa, Errors errors) {	
		ModelAndView mv = new ModelAndView("Casas");
		
		if(errors.hasErrors()) {
			return "Casas";
			
		}
		
		cas.save(casaa);
		
		mv.addObject("mensagem", "cadastrado com sucesso");
		return "redirect:/casadeshow";
	}
}