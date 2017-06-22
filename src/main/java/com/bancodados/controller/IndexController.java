package com.bancodados.controller;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bancodados.DAOs.DiscenteDao;
import com.bancodados.DAOs.DocenteDao;
import com.bancodados.DAOs.LoginDao;
import com.bancodados.dominio.Discente;
import com.bancodados.dominio.Docente;
import com.bancodados.dominio.Trabalho;


@Controller
@RequestMapping("/")
public class IndexController {



	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView index(){


		ModelAndView mv = new ModelAndView("index");
		DiscenteDao discenteDao = new DiscenteDao();
		Discente discente = discenteDao.buscarDiscentePorCpf("09566369000");
		
		System.out.println(discente.getNome());
		System.out.println(discente.getEndereco().getCep());
		System.out.println(discente.getEmail());
		
		
		
		
		return mv;
	}

	@GetMapping("/login")
	public ModelAndView login(String cpf,String senha,RedirectAttributes attributes, HttpSession session){

		ModelAndView mv = null;
	//	ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		
		if(!cpf.equals("")){
			/*
			if(consultas.verificarTipoPorEmail(email) != null){

				if(consultas.verificarTipoPorEmail(email).equals("dis")){


					Discente discente = consultas.buscarDiscentePorEmailSenha(email, senha);
					if(discente != null){
						attributes.addFlashAttribute("message","Bem Vindo " + discente.getNome());
						attributes.addFlashAttribute("discente", discente);
						session.setAttribute("discente", discente);
						ArrayList<Trabalho> trabalhos = consultas.buscarTrabalhos();

						Collections.shuffle(trabalhos);


						mv = new ModelAndView("/layout-aluno/index-aluno");
						mv.addObject("trabalhos", trabalhos);
					}else{
						mv = new ModelAndView("index");
					}
				}else{
					Docente docente = consultas.buscarDocentePorEmailSenha(email, senha);
					if(docente != null){
						attributes.addFlashAttribute("message","Bem Vindo " + docente.getNome());
						attributes.addFlashAttribute("docente", docente);

						session.setAttribute("docente", docente);
						ArrayList<Trabalho> trabalhos = consultas.buscarTrabalhos();

						Collections.shuffle(trabalhos);
						mv = new ModelAndView("/layout-professor/index-professor");
						mv.addObject("trabalhos", trabalhos);
					}else{
						mv = new ModelAndView("index");
					}

				}
			}
*/
		}else{
			mv = new ModelAndView("index");
		}
		return mv;
	}


	@GetMapping("/cadastro")
	public ModelAndView layoutCadastro(){

		ModelAndView mv = new ModelAndView("cadastro");

		return mv;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(String nome,String sobreNome, String cpf
			, String senha, String rTipo){

		ModelAndView mv = new ModelAndView("index");
	//	ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		if(rTipo == "dis"){
			Discente discente = new Discente();
			discente.setNome(nome);
			discente.setSobreNome(sobreNome);
			discente.setEmail(cpf);
			discente.setSenha(senha);
			discente.setTipo(rTipo);
		//	consultas.inserirDiscente(discente);

		}else{
			Docente docente = new Docente();
			docente.setNome(nome);
			docente.setSobreNome(sobreNome);
			docente.setEmail(cpf);
			docente.setSenha(senha);
			docente.setTipo(rTipo);

		//	consultas.inserirDocente(docente);




		}
		return mv;
	}
	
	
	
}

