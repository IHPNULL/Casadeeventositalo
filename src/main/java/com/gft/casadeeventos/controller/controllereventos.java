package com.gft.casadeeventos.controller;

import java.math.BigDecimal;
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
import com.gft.casadeeventos.model.Evento;
import com.gft.casadeeventos.repository.casas;
import com.gft.casadeeventos.repository.eventos;


@Controller
@RequestMapping("/eventos")
public class controllereventos {
	
	@Autowired
	private eventos event;
	
	@Autowired
	private casas cas;
	
	@RequestMapping
	public ModelAndView pesquisaevento() {
		List<Evento> eventos =  event.findAll();
		ModelAndView mv = new ModelAndView("Eventos");
		mv.addObject(new Evento());
		mv.addObject("eventos", eventos);
		List<Casa> casas =  cas.findAll();
		mv.addObject("casas", casas);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Evento evento, Errors errors) {
		ModelAndView mv = new ModelAndView("Eventos");
		
		if(errors.hasErrors()) {
			return "/eventos";
		}
		
		if(evento.getPreco() == null || (evento.getPreco().compareTo(BigDecimal.ZERO) == 0) )
		{
			System.out.println(evento.getPreco());
			evento.setGrat(false);			
		}
		
		evento.setIngressosd(evento.getIngressos());

		event.save(evento);
	
		
		mv.addObject("mensagem", "cadastrado com sucesso");
		return "redirect:/eventos";
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView edicao(@PathVariable("id") Evento eve)
	{
		ModelAndView mv = new ModelAndView("Eventosedit");
		List<Casa> casas =  cas.findAll();
		mv.addObject("casas", casas);
		mv.addObject(eve);
		return mv;
	}
	
	@RequestMapping(value ="{id}", method = RequestMethod.GET)
	public String excluir(@PathVariable Long id){
		event.deleteById(id);
		return "redirect:/eventos";
	}	
}