package com.bancodados.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/layout-aluno")
public class AlunoController {

	@GetMapping("/perfil-aluno")
	public ModelAndView perfilAluno(){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");
		
		
		return mv;
		
	}
	@GetMapping("/index-aluno")
	public ModelAndView indexAluno(){
		
		ModelAndView mv = new ModelAndView("index-aluno");
		
		
		return mv;
		
	}
	
	@GetMapping("/trabalhos-aluno")
	public ModelAndView trabalhosAluno(){
		System.err.println("trabalhos-aluno");
		ModelAndView mv = new ModelAndView("/layout-aluno/trabalhos-aluno");
		
		
		return mv;
		
	}
	
	@GetMapping("/gerenciar-contatos")
	public ModelAndView gerenciarContatos(){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/gerenciar-contatos");
		
		System.out.println("gerenciar contatos");
		return mv;
		
	}
}
