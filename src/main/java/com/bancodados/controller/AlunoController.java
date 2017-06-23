package com.bancodados.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bancodados.DAOs.DiscenteDao;
import com.bancodados.dominio.Discente;
import com.bancodados.dominio.Docente;
import com.bancodados.dominio.Trabalho;


@Controller
@RequestMapping("/layout-aluno")
public class AlunoController {

	@GetMapping("/perfil-aluno")
	public ModelAndView perfilAluno(){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");
		
		
		return mv;
		
	}
	@GetMapping("/visualizarTrabalho")
	public ModelAndView visualizarTrabalho(HttpSession session){
		ModelAndView mv = new ModelAndView("/layout-aluno/trabalho");

		return mv;
	}
	
	@GetMapping("/index-aluno")
	public ModelAndView indexAluno(){
		ModelAndView mv = new ModelAndView("/index-aluno");
		
		
		
		return mv;
		
	}
	
	@GetMapping("/inicioAluno")
	public ModelAndView inicioAluno(HttpSession session){
		ModelAndView mv = new ModelAndView("/layout-aluno/index-aluno");
		//ArrayList<Trabalho> trabalhos = consultas.buscarTrabalhos();

		//Collections.shuffle(trabalhos);
		//mv.addObject("trabalhos", trabalhos);
			
		
		return mv;
		
	}
	
	@GetMapping("/trabalhos-aluno")
	public ModelAndView trabalhosAluno(){
		ModelAndView mv = new ModelAndView("/layout-aluno/trabalhos-aluno");
		
		
		return mv;
		
	}
	
	@GetMapping("/gerenciar-contatos")
	public ModelAndView gerenciarContatos(){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/gerenciar-contatos");
		
		return mv;
		
	}
	
	
	
	@GetMapping("/attNome")
	public ModelAndView atualizarNome(String nome, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");
		Discente discente = (Discente) sessao.getAttribute("discente");
		
		discente.setNome(nome);
		DiscenteDao discenteDao = new DiscenteDao();
		discenteDao.atualizarDiscente(discente);
		
		
		return mv;
		
	}
	@GetMapping("/attCpf")
	public ModelAndView atualizarCpf(String cpf, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");
		Discente discente = (Discente) sessao.getAttribute("discente");

		discente.setCpf(cpf);
		DiscenteDao discenteDao = new DiscenteDao();
		discenteDao.atualizarDiscente(discente);
		
		
		return mv;
		
	}
	@GetMapping("/attLogin")
	public ModelAndView atualizarLogin(String login, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");
		Discente discente = (Discente) sessao.getAttribute("discente");

		discente.setLogin(login);
		DiscenteDao discenteDao = new DiscenteDao();
		discenteDao.atualizarDiscente(discente);
		
		
		return mv;
		
	}
	
	@GetMapping("/attSenha")
	public ModelAndView atualizarSenha(String senha, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");
		Discente discente = (Discente) sessao.getAttribute("discente");

		discente.setSenha(senha);
		DiscenteDao discenteDao = new DiscenteDao();
		discenteDao.atualizarDiscente(discente);
		
		
		return mv;
		
	}
	
	@GetMapping("/attEmail")
	public ModelAndView atualizarEmail(String email, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");
		Discente discente = (Discente) sessao.getAttribute("discente");

		discente.setEmail(email);
		DiscenteDao discenteDao = new DiscenteDao();
		discenteDao.atualizarDiscente(discente);
		
		
		return mv;
		
	}
	@GetMapping("/attSobreNome")
	public ModelAndView atualizarSObreNome(String sobreNome, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");
		Discente discente = (Discente) sessao.getAttribute("discente");

		discente.setSobreNome(sobreNome);
		DiscenteDao discenteDao = new DiscenteDao();
		discenteDao.atualizarDiscente(discente);
		
		
		return mv;
		
	}
	
	@GetMapping("/attMatricula")
	public ModelAndView atualizarMatricula(String matricula, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");
		Discente discente = (Discente) sessao.getAttribute("discente");

		discente.setMatricula(matricula);
		DiscenteDao discenteDao = new DiscenteDao();
		discenteDao.atualizarDiscente(discente);
		
		
		return mv;
		
	}
	@GetMapping("/attCurriculo")
	public ModelAndView atualizarCurriculo(String curriculo, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");
		Discente discente = (Discente) sessao.getAttribute("discente");

		discente.setCurriculo(curriculo);
		DiscenteDao discenteDao = new DiscenteDao();
		discenteDao.atualizarDiscente(discente);
		
		
		return mv;
		
	}
	@GetMapping("/attCep")
	public ModelAndView atualizarCep(String cep, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");
		Discente discente = (Discente) sessao.getAttribute("discente");

		discente.getEndereco().setCep(cep);
		DiscenteDao discenteDao = new DiscenteDao();
		discenteDao.atualizarDiscente(discente);
		
		
		return mv;
		
	}
	@GetMapping("/attRua")
	public ModelAndView atualizarRua(String rua, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");
		Discente discente = (Discente) sessao.getAttribute("discente");

		discente.getEndereco().setRua(rua);
		DiscenteDao discenteDao = new DiscenteDao();
		discenteDao.atualizarDiscente(discente);
		
		
		return mv;
		
	}
	@GetMapping("/attNumero")
	public ModelAndView atualizarNumero(String numero, HttpSession sessao){
		
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");
		Discente discente = (Discente) sessao.getAttribute("discente");

		discente.getEndereco().setNumero(Integer.parseInt(numero));
		DiscenteDao discenteDao = new DiscenteDao();
		discenteDao.atualizarDiscente(discente);
		
		
		return mv;
		
	}
	
	@GetMapping("/logout")
	public void logout(HttpSession sessao){

		Discente discente = (Discente) sessao.getAttribute("discente");
		discente = null;

	}
	
}
