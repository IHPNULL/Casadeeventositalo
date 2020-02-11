package com.gft.casadeeventos.controller;

import java.util.List;

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
	public ModelAndView pesquisaevento() {
		List<Evento> eventos =  event.findAll();
		ModelAndView mv = new ModelAndView("Eventos");
		mv.addObject(new Evento());
		mv.addObject("eventos", eventos);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Evento evento, Errors errors) {
		ModelAndView mv = new ModelAndView("Eventos");
		if(errors.hasErrors()) {
			return "/eventos";
			
		}
		
		event.save(evento);
		
		mv.addObject("mensagem", "cadastrado com sucesso");
		return "redirect:/eventos";
	}
}