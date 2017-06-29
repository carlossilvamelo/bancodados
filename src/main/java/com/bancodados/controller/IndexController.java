package com.bancodados.controller;


import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bancodados.DAOs.ContatosDao;
import com.bancodados.DAOs.DiscenteDao;
import com.bancodados.DAOs.DocenteDao;
import com.bancodados.DAOs.LoginDao;
import com.bancodados.DAOs.UsuarioDao;
import com.bancodados.dominio.Discente;
import com.bancodados.dominio.Docente;
import com.bancodados.dominio.Mensagem;
import com.bancodados.dominio.Trabalho;
import com.bancodados.dominio.Usuario;


@Controller
@RequestMapping("/")
public class IndexController {



	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView index(){


		ModelAndView mv = new ModelAndView("index");

		return mv;
	}

	@GetMapping("/login")
	public ModelAndView login(String cpf,String senha,RedirectAttributes attributes, HttpSession session){

		ModelAndView mv = null;

		DiscenteDao discenteDao = new DiscenteDao();
		UsuarioDao usuarioDao = new UsuarioDao();
		DocenteDao docenteDao = new DocenteDao();
		ContatosDao contatosDao = new ContatosDao();
		if(!cpf.equals("") && !senha.equals("")){
			
			if(usuarioDao.verificarTipoUsuarioPorCpf(cpf) != null){
				//verifica se usuario existe
				
				if(usuarioDao.verificarTipoUsuarioPorCpf(cpf).equals("dis")){
					//verificação do tipo de usuário
					Discente discente = discenteDao.buscarDiscentePorCpf(cpf);
					if(discente.getCpf().equals(cpf) && discente.getSenha().equals(senha)){
						//verificação da identificação
						
						attributes.addFlashAttribute("message","Bem Vindo " + discente.getNome());
						attributes.addFlashAttribute("discente", discente);
						session.setAttribute("discente", discente);
						//ArrayList<Trabalho> trabalhos = consultas.buscarTrabalhos();

						//	Collections.shuffle(trabalhos);
						ArrayList<Usuario> contatos = contatosDao.buscarContatos(discente);
						
						
						
						
						mv = new ModelAndView("/layout-aluno/index-aluno");
						//mv.addObject("trabalhos", trabalhos);
						mv.addObject("contatos", contatos);
						
					}else{
						mv = new ModelAndView("index");
					}
				}else{
						Docente docente = docenteDao.buscarDocentePorCpf(cpf);
					if(docente.getCpf().equals(cpf) && docente.getSenha().equals(senha)){
						attributes.addFlashAttribute("message","Bem Vindo " + docente.getNome());
						attributes.addFlashAttribute("docente", docente);
						session.setAttribute("docente", docente);
					//	ArrayList<Trabalho> trabalhos = consultas.buscarTrabalhos();
						ArrayList<Usuario> contatos = contatosDao.buscarContatos(docente);
					//	Collections.shuffle(trabalhos);
						mv = new ModelAndView("/layout-professor/index-professor");
						mv.addObject("contatos", contatos);
					//	mv.addObject("trabalhos", trabalhos);
					}else{
						mv = new ModelAndView("index");
					}

				}
			}else{
				mv = new ModelAndView("index");
			}

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
	public ModelAndView cadastrar(String nome,String sobreNome, String cpf, String senha, String rTipo){

		ModelAndView mv = new ModelAndView("index");
		DiscenteDao discenteDao = new DiscenteDao();
		DocenteDao docenteDao = new DocenteDao();
		
		if(rTipo.equals("dis")){
			Discente discente = new Discente();
			discente.setNome(nome);
			discente.setSobreNome(sobreNome);
			discente.setCpf(cpf);
			discente.setSenha(senha);
			discente.setTipo(rTipo);

			discenteDao.inserirDiscente(discente);

		}else{
			Docente docente = new Docente();
			docente.setNome(nome);
			docente.setSobreNome(sobreNome);
			docente.setCpf(cpf);
			docente.setSenha(senha);
			docente.setTipo(rTipo);

			docenteDao.inserirDocente(docente);




		}
		return mv;
	}



}

