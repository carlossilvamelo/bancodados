package com.bancodados.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/layout-professor")
public class ProfessorController {

	@GetMapping("/indexProfessor")
	public ModelAndView indexProfessor(){
		
		ModelAndView mv = new ModelAndView("index-professor");
		
		
		return mv;
		
	}
	
	@GetMapping("/perfil")
	public ModelAndView perfilAluno(){
		
		ModelAndView mv = new ModelAndView("perfil-aluno");
		
		
		return mv;
		
	}
	@GetMapping("/galeriaTrabalhos")
	public ModelAndView galeriaTrabalhos(){
		
		ModelAndView mv = new ModelAndView("galeria-trabalhos");
		
		
		return mv;
		
	}
	
	@GetMapping("/gerenciarContatos")
	public ModelAndView gerenciarContatos(){
		
		ModelAndView mv = new ModelAndView("gerenciar-contatos");
		
		
		return mv;
		
	}
	
}
