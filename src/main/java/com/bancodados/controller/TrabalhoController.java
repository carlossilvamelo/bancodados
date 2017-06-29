package com.bancodados.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bancodados.DAOs.ContatosDao;
import com.bancodados.DAOs.DiscenteDao;
import com.bancodados.DAOs.DocenteDao;
import com.bancodados.DAOs.TrabalhoDao;
import com.bancodados.DAOs.UsuarioDao;
import com.bancodados.dominio.Discente;
import com.bancodados.dominio.Trabalho;
import com.bancodados.dominio.Usuario;

@Controller
@RequestMapping("/trabalho")
public class TrabalhoController {

	
	@GetMapping("/novoTrabalho")
	public ModelAndView novoTrabalho(HttpSession session, String titulo, String resumo, String palavraChave){
		
		ContatosDao contatosDao = new ContatosDao();
		TrabalhoDao trabalhoDao = new TrabalhoDao();
		Trabalho trabalho = new Trabalho();
		
		ModelAndView mv = new ModelAndView("/layout-aluno/index-aluno");
		
		Discente discente = (Discente) session.getAttribute("discente");
		ArrayList<Usuario> contatos = contatosDao.buscarContatos(discente);
		
		trabalho.setTitulo(titulo);
		trabalho.setResumo(resumo);
		String[] listaPalavras = palavraChave.trim().split(";");
		
		for(String palavra : listaPalavras){
			trabalho.adicionarPalavraChave(palavra);
			System.out.println("A palavra-chave é: " +  palavra);
		}
		
		
		trabalhoDao.inserirTrabalho(trabalho, discente);
		
		mv.addObject("contatos", contatos);
		return mv;

	}
	
	@GetMapping("/gerenciar")
	public ModelAndView gerenciar(HttpSession session, String idTrabalho){
		
		TrabalhoDao trabalhoDao = new TrabalhoDao();
		
		
		ModelAndView mv = new ModelAndView("/layout-aluno/trabalho");
		
		//Trabalho trabalho = trabalhoDao.buscarTrabalhoPorTitulo(titulo);
		System.out.println(idTrabalho);
		//mv.addObject("trabalho", trabalho);
		return mv;

	}
	
	@GetMapping("/filtrar")
	public ModelAndView filtrar(HttpSession session, String filtro){
		
		
		
		ModelAndView mv = new ModelAndView("/layout-aluno/index-aluno");
		
		
		return null;

	}
	
}
