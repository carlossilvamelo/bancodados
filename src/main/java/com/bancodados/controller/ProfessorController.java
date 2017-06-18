package com.bancodados.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/layout-professor")
public class ProfessorController {

	@GetMapping("/index-professor")
	public ModelAndView indexProfessor(){
		
		ModelAndView mv = new ModelAndView("index-professor");
		
		
		return mv;
		
	}
	
	@GetMapping("/perfil-professor")
	public ModelAndView perfilAluno(){
		
		ModelAndView mv = new ModelAndView("/layout-professor/perfil-professor");
		
		
		return mv;
		
	}
	@GetMapping("/galeria-trabalhos")
	public ModelAndView galeriaTrabalhos(){
		
		ModelAndView mv = new ModelAndView("/layout-professor/galeria-trabalhos");
		
		
		return mv;
		
	}
	
	@GetMapping("/gerenciar-contatos")
	public ModelAndView gerenciarContatos(){
		
		ModelAndView mv = new ModelAndView("layout-professor/gerenciar-contatos");
		
		
		return mv;
		
	}
	
}
