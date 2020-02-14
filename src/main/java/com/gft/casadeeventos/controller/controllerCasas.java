package com.gft.casadeeventos.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping("/editar/{id}")
	public ModelAndView edicao(@PathVariable("id") Casa casaa)
	{
		ModelAndView mv = new ModelAndView("CasasEdit");
		List<Casa> casas =  cas.findAll();
		mv.addObject("casas", casas);
		mv.addObject(casaa);
		return mv;
	}
	
	@RequestMapping(value ="{id}", method = RequestMethod.GET)
	public String excluir(@PathVariable Long id){
		cas.deleteById(id);
		return "redirect:/casadeshow";
	}	
}