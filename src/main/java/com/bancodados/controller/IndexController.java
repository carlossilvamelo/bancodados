package com.bancodados.controller;


import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bancodados.DAOs.ConsultasProjetoWeb;
import com.bancodados.DAOs.DiscenteDao;
import com.bancodados.DAOs.DocenteDao;
import com.bancodados.DAOs.LoginDao;
import com.bancodados.dominio.Discente;
import com.bancodados.dominio.Docente;


@Controller
@RequestMapping("/")
public class IndexController {



	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView index(){


		ModelAndView mv = new ModelAndView("index");


		return mv;
	}

	@GetMapping("/login")
	public ModelAndView login(String email,String senha,RedirectAttributes attributes, HttpSession session){

		ModelAndView mv = null;
		ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		

		if(consultas.verificarTipoPorEmail(email) != null){

			if(consultas.verificarTipoPorEmail(email).equals("dis")){

				
				Discente discente = consultas.buscarDiscentePorEmailSenha(email, senha);
				attributes.addFlashAttribute("message","Bem Vindo " + discente.getNome());
				attributes.addFlashAttribute("discente", discente);
				session.setAttribute("discente", discente);
				mv = new ModelAndView("/layout-aluno/index-aluno");
			}else{
				Docente docente = consultas.buscarDocentePorEmailSenha(email, senha);
				attributes.addFlashAttribute("message","Bem Vindo " + docente.getNome());
				attributes.addFlashAttribute("docente", docente);
				System.err.println(docente.getId());
				session.setAttribute("docente", docente);
				mv = new ModelAndView("/layout-professor/index-professor");
			}
		}


		return mv;
	}


	@GetMapping("/cadastro")
	public ModelAndView layoutCadastro(){

		ModelAndView mv = new ModelAndView("cadastro");

		return mv;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(String nome,String sobreNome, String email
			, String senha, String rTipo){

		ModelAndView mv = new ModelAndView("index");
		ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		if(rTipo == "dis"){
			Discente discente = new Discente();
			discente.setNome(nome);
			discente.setSobreNome(sobreNome);
			discente.setEmail(email);
			discente.setSenha(senha);
			discente.setTipo(rTipo);
			consultas.inserirDiscente(discente);

		}else{
			Docente docente = new Docente();
			docente.setNome(nome);
			docente.setSobreNome(sobreNome);
			docente.setEmail(email);
			docente.setSenha(senha);
			docente.setTipo(rTipo);

			consultas.inserirDocente(docente);




		}
		return mv;


	}
}

