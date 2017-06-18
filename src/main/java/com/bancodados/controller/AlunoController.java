package com.bancodados.controller;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bancodados.DAOs.ConsultasProjetoWeb;
import com.bancodados.dominio.Discente;


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
	
	
	
	@GetMapping("/attNome")
	public ModelAndView atualizarNome(String nome, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");
		Discente discente = (Discente) sessao.getAttribute("discente");

		discente.setNome(nome);
		ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		consultas.atualizarDiscente(discente);
		
		
		return mv;
		
	}
	@GetMapping("/attCpf")
	public ModelAndView atualizarCpf(String cpf, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");
		Discente discente = (Discente) sessao.getAttribute("discente");

		discente.setCpf(cpf);
		ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		consultas.atualizarDiscente(discente);
		
		
		return mv;
		
	}
	@GetMapping("/attLogin")
	public ModelAndView atualizarLogin(String login, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");
		Discente discente = (Discente) sessao.getAttribute("discente");

		discente.setLogin(login);
		ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		consultas.atualizarDiscente(discente);
		
		
		return mv;
		
	}
	
	@GetMapping("/attSenha")
	public ModelAndView atualizarSenha(String senha, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");
		Discente discente = (Discente) sessao.getAttribute("discente");

		discente.setSenha(senha);
		ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		consultas.atualizarDiscente(discente);
		
		
		return mv;
		
	}
	
	@GetMapping("/attEmail")
	public ModelAndView atualizarEmail(String email, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");
		Discente discente = (Discente) sessao.getAttribute("discente");

		discente.setEmail(email);
		ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		consultas.atualizarDiscente(discente);
		
		
		return mv;
		
	}
	@GetMapping("/attSobreNome")
	public ModelAndView atualizarSObreNome(String sobreNome, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");
		Discente discente = (Discente) sessao.getAttribute("discente");

		discente.setSobreNome(sobreNome);
		ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		consultas.atualizarDiscente(discente);
		
		
		return mv;
		
	}
	
	@GetMapping("/attMatricula")
	public ModelAndView atualizarMatricula(String matricula, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");
		Discente discente = (Discente) sessao.getAttribute("discente");

		discente.setMatricula(matricula);
		ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		consultas.atualizarDiscente(discente);
		
		
		return mv;
		
	}
	@GetMapping("/attCurriculo")
	public ModelAndView atualizarCurriculo(String curriculo, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");
		Discente discente = (Discente) sessao.getAttribute("discente");

		discente.setCurriculo(curriculo);
		ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		consultas.atualizarDiscente(discente);
		
		
		return mv;
		
	}
	@GetMapping("/attCep")
	public ModelAndView atualizarCep(String cep, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");
		Discente discente = (Discente) sessao.getAttribute("discente");

		discente.getEndereco().setCep(cep);
		ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		consultas.atualizarDiscente(discente);
		
		
		return mv;
		
	}
	@GetMapping("/attRua")
	public ModelAndView atualizarRua(String rua, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");
		Discente discente = (Discente) sessao.getAttribute("discente");

		discente.getEndereco().setRua(rua);
		ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		consultas.atualizarDiscente(discente);
		
		
		return mv;
		
	}
	@GetMapping("/attNumero")
	public ModelAndView atualizarNumero(String numero, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");
		Discente discente = (Discente) sessao.getAttribute("discente");

		discente.getEndereco().setNumero(Integer.parseInt(numero));
		ConsultasProjetoWeb consultas = new ConsultasProjetoWeb();
		consultas.atualizarDiscente(discente);
		
		
		return mv;
		
	}
	
	
	
}
