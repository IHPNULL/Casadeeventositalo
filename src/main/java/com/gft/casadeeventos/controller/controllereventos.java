package com.gft.casadeeventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gft.casadeeventos.model.Evento;
import com.gft.casadeeventos.repository.eventos;


@Controller
@RequestMapping("/eventos")
public class controllereventos {
	
	@Autowired
	private eventos event;
	
	@RequestMapping
	public ModelAndView Eventos(){
		ModelAndView mv = new ModelAndView("Eventos");
		
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Evento evento, Errors errors) {	
		ModelAndView mv = new ModelAndView("CadastroEvento");
		
		if(errors.hasErrors()) {
			return mv;
			
		}
		mv.addObject(new Evento());
		
		event.save(evento);
		
		mv.addObject("mensagem", "cadastrado com sucesso");
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroEvento");
		
		return mv;
	}
}