package com.bancodados.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bancodados.DAOs.ConsultasProjetoWeb;
import com.bancodados.dominio.Discente;
import com.bancodados.dominio.Docente;

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
	

	@GetMapping("/attNome")
	public ModelAndView atualizarNome(String nome, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-professor/perfil-professor");
		Docente docente = (Docente) sessao.getAttribute("docente");

		docente.setNome(nome);
		ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		consultas.atualizarDocente(docente);
		
		
		return mv;
		
	}
	@GetMapping("/attCpf")
	public ModelAndView atualizarCpf(String cpf, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-professor/perfil-professor");
		Docente docente = (Docente) sessao.getAttribute("docente");

		docente.setCpf(cpf);
		ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		consultas.atualizarDocente(docente);
		
		
		return mv;
		
	}
	@GetMapping("/attLogin")
	public ModelAndView atualizarLogin(String login, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-professor/perfil-professor");
		Docente docente = (Docente) sessao.getAttribute("docente");

		docente.setLogin(login);
		ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		consultas.atualizarDocente(docente);
		
		
		return mv;
		
	}
	
	@GetMapping("/attSenha")
	public ModelAndView atualizarSenha(String senha, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-professor/perfil-professor");
		Docente docente = (Docente) sessao.getAttribute("docente");

		docente.setSenha(senha);
		ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		consultas.atualizarDocente(docente);
		
		
		return mv;
		
	}
	
	@GetMapping("/attEmail")
	public ModelAndView atualizarEmail(String email, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-professor/perfil-professor");
		Docente docente = (Docente) sessao.getAttribute("docente");

		docente.setEmail(email);
		ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		consultas.atualizarDocente(docente);
		
		
		return mv;
		
	}
	@GetMapping("/attSobreNome")
	public ModelAndView atualizarSobreNome(String sobreNome, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-professor/perfil-professor");
		Docente docente = (Docente) sessao.getAttribute("docente");
		System.out.println(sobreNome);
		docente.setSobreNome(sobreNome);
		ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		consultas.atualizarDocente(docente);
		
		
		return mv;
		
	}
	
	
	@GetMapping("/attCurriculo")
	public ModelAndView atualizarCurriculo(String curriculo, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-professor/perfil-professor");
		Docente docente = (Docente) sessao.getAttribute("docente");
System.out.println(docente.getId());
		docente.setCurriculo(curriculo);
		ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		//consultas.atualizarDocente(docente);
		
		
		return mv;
		
	}
	@GetMapping("/attCep")
	public ModelAndView atualizarCep(String cep, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-professor/perfil-professor");
		Docente docente = (Docente) sessao.getAttribute("docente");
		System.out.println(docente.getId());
		docente.getEndereco().setCep(cep);
		ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		//consultas.atualizarDocente(docente);
		
		
		return mv;
		
	}
	@GetMapping("/attRua")
	public ModelAndView atualizarRua(String rua, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-professor/perfil-professor");
		Docente docente = (Docente) sessao.getAttribute("docente");

		docente.getEndereco().setRua(rua);
		ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		consultas.atualizarDocente(docente);
		
		
		return mv;
		
	}
	@GetMapping("/attNumero")
	public ModelAndView atualizarNumero(String numero, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-professor/perfil-professor");
		Docente docente = (Docente) sessao.getAttribute("docente");

		docente.getEndereco().setNumero(Integer.parseInt(numero));
		ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		consultas.atualizarDocente(docente);
		
		
		return mv;
		
	}
	
	@GetMapping("/logout")
	public void logout(HttpSession sessao){
		
		Docente docente = (Docente) sessao.getAttribute("docente");
		docente = null;
		
	}
	
	
	
	
}
