package com.bancodados.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bancodados.DAOs.ContatosDao;
import com.bancodados.DAOs.DiscenteDao;
import com.bancodados.DAOs.DocenteDao;
import com.bancodados.DAOs.MensagemDao;
import com.bancodados.DAOs.UsuarioDao;
import com.bancodados.dominio.Discente;
import com.bancodados.dominio.Docente;
import com.bancodados.dominio.Mensagem;
import com.bancodados.dominio.Trabalho;
import com.bancodados.dominio.Usuario;


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

		Discente discente = (Discente) session.getAttribute("discente");
		ContatosDao contatosDao = new ContatosDao();
		ModelAndView mv = new ModelAndView("/layout-aluno/index-aluno");
		ArrayList<Usuario> contatos = contatosDao.buscarContatos(discente);
		mv.addObject("contatos", contatos);
		//ArrayList<Trabalho> trabalhos = consultas.buscarTrabalhos();
		//Discente discente = (Discente) session.getAttribute("discente");
		//	System.out.println(discente.getCpf());
		//Collections.shuffle(trabalhos);
		//mv.addObject("trabalhos", trabalhos);


		return mv;

	}

	@GetMapping("/filtrarUsuarios")
	public ModelAndView filtrarUsuarios(HttpSession session, String filtro){
		Discente discente = (Discente) session.getAttribute("discente");
		ContatosDao contatosDao = new ContatosDao();
		ModelAndView mv = new ModelAndView("/layout-aluno/gerenciar-contatos");
		ArrayList<Usuario> usuarios = contatosDao.buscarTodosUsuarios();
		ArrayList<Usuario> contatos = contatosDao.buscarContatos(discente);
		if(!filtro.equals("")){
			ArrayList<Usuario> contatosFiltrados = new ArrayList<Usuario>();
			for (Usuario usuario : usuarios) {
				if(usuario.getNome().contains(filtro)){
					contatosFiltrados.add(usuario);
				}
			}
			mv.addObject("usuarios", contatosFiltrados);
			mv.addObject("contatos", contatos);
		}else{
			mv.addObject("usuarios", usuarios);
			mv.addObject("contatos", contatos);
		}



		return mv;

	}

	@GetMapping("/conversar")
	public ModelAndView conversar(HttpSession session, String cpfDestinatario){
		Discente remetente = (Discente) session.getAttribute("discente");
		ContatosDao contatosDao = new ContatosDao();
		DiscenteDao discenteDao = new DiscenteDao();
		DocenteDao docenteDao = new DocenteDao();
		UsuarioDao usuarioDao = new UsuarioDao();
		ModelAndView mv = null;
		if(usuarioDao.verificarTipoUsuarioPorCpf(cpfDestinatario).equals("dis")){
			Usuario destinatario = discenteDao.buscarDiscentePorCpf(cpfDestinatario);
			MensagemDao mensagemDao = new MensagemDao();
			 mv = new ModelAndView("/layout-aluno/index-aluno");
			ArrayList<Usuario> contatos = contatosDao.buscarContatos(remetente);
			mv.addObject("contatos", contatos);

			ArrayList<Mensagem> mensagens = mensagemDao.buscarMensagens(remetente, destinatario);
			mv.addObject("mensagens", mensagens);
			mv.addObject("cpfDestinatario", cpfDestinatario);
		}else{
			Usuario destinatario = docenteDao.buscarDocentePorCpf(cpfDestinatario);
			System.out.println(destinatario);
			MensagemDao mensagemDao = new MensagemDao();
			mv = new ModelAndView("/layout-aluno/index-aluno");
			ArrayList<Usuario> contatos = contatosDao.buscarContatos(remetente);
			mv.addObject("contatos", contatos);

			ArrayList<Mensagem> mensagens = mensagemDao.buscarMensagens(remetente, destinatario);
			mv.addObject("mensagens", mensagens);
			mv.addObject("cpfDestinatario", cpfDestinatario);
		}

		return mv;

	}


	@GetMapping("/enviarMensagem")
	public ModelAndView enviarMensagem(HttpSession session, String destinatario
			, String mensagem){
		MensagemDao mensagemDao = new MensagemDao();
		DiscenteDao discenteDao = new DiscenteDao();
		UsuarioDao usuarioDao = new UsuarioDao();
		DocenteDao docenteDao = new DocenteDao();
		ModelAndView mv = null;
		if(usuarioDao.verificarTipoUsuarioPorCpf(destinatario).equals("dis")){
			Discente Discentedestinatario = discenteDao.buscarDiscentePorCpf(destinatario);
			Discente remetente = (Discente) session.getAttribute("discente");
			ContatosDao contatosDao = new ContatosDao();

			mensagemDao.enviarMensagem(remetente, Discentedestinatario, mensagem);

			 mv = new ModelAndView("/layout-aluno/index-aluno");
			System.out.println(remetente.getCpf()+" -- "+destinatario+" :"+mensagem);
			ArrayList<Usuario> contatos = contatosDao.buscarContatos(remetente);
			mv.addObject("contatos", contatos);

			ArrayList<Mensagem> mensagens = mensagemDao.buscarMensagens(remetente, Discentedestinatario);
			mv.addObject("mensagens", mensagens);
		}else{
			Usuario Discentedestinatario = docenteDao.buscarDocentePorCpf(destinatario);
			Usuario remetente = (Discente) session.getAttribute("discente");
			ContatosDao contatosDao = new ContatosDao();

			mensagemDao.enviarMensagem(remetente, Discentedestinatario, mensagem);

			 mv = new ModelAndView("/layout-aluno/index-aluno");
			System.out.println(remetente.getCpf()+" -- "+destinatario+" :"+mensagem);
			ArrayList<Usuario> contatos = contatosDao.buscarContatos(remetente);
			mv.addObject("contatos", contatos);

			ArrayList<Mensagem> mensagens = mensagemDao.buscarMensagens(remetente, Discentedestinatario);
			mv.addObject("mensagens", mensagens);
		}
		

		return mv;

	}


	@GetMapping("/filtrarContatos")
	public ModelAndView filtrarContatos(HttpSession session, String filtro){
		Discente discente = (Discente) session.getAttribute("discente");
		ContatosDao contatosDao = new ContatosDao();
		ModelAndView mv = new ModelAndView("/layout-aluno/gerenciar-contatos");
		ArrayList<Usuario> usuarios = contatosDao.buscarTodosUsuarios();
		ArrayList<Usuario> contatos = contatosDao.buscarContatos(discente);
		if(!filtro.equals("")){
			ArrayList<Usuario> contatosFiltrados = new ArrayList<Usuario>();
			for (Usuario usuario : contatos) {
				if(usuario.getNome().contains(filtro)){
					contatosFiltrados.add(usuario);
				}
			}
			mv.addObject("contatos", contatosFiltrados);
			mv.addObject("usuarios", usuarios);
		}else{
			mv.addObject("contatos", contatos);
			mv.addObject("usuarios", usuarios);
		}






		return mv;

	}



	@GetMapping("/trabalhos-aluno")
	public ModelAndView trabalhosAluno(){
		ModelAndView mv = new ModelAndView("/layout-aluno/trabalhos-aluno");


		return mv;

	}

	@GetMapping("/gerenciar-contatos")
	public ModelAndView gerenciarContatos(HttpSession session){
		ContatosDao contatosDao = new ContatosDao();
		ModelAndView mv = new ModelAndView("/layout-aluno/gerenciar-contatos");
		Discente discente = (Discente) session.getAttribute("discente");
		ArrayList<Usuario> usuarios = contatosDao.buscarTodosUsuarios();
		ArrayList<Usuario> contatos = contatosDao.buscarContatos(discente);
		mv.addObject("contatos", contatos);
		mv.addObject("usuarios", usuarios);
		return mv;

	}

	@GetMapping("/addContato")
	public ModelAndView addContato(HttpSession session, String cpfContato){

		ContatosDao contatosDao = new ContatosDao();
		ModelAndView mv = new ModelAndView("/layout-aluno/gerenciar-contatos");
		Usuario usuario = (Usuario) session.getAttribute("discente");

		if(usuario.getTipo().equals("dis")){
			Discente discenteA = (Discente) session.getAttribute("discente");

			Discente discenteB = new Discente();
			discenteB.setCpf(cpfContato);

			contatosDao.inserirContato(discenteA, discenteB);

			ArrayList<Usuario> usuarios = contatosDao.buscarTodosUsuarios();
			ArrayList<Usuario> contatos = contatosDao.buscarContatos(discenteA);
			mv.addObject("contatos", contatos);
			mv.addObject("usuarios", usuarios);

		}else{
			Docente docenteA = (Docente) session.getAttribute("discente");

			Docente docenteB = new Docente();
			docenteB.setCpf(cpfContato);

			contatosDao.inserirContato(docenteA, docenteB);

			ArrayList<Usuario> usuarios = contatosDao.buscarTodosUsuarios();
			ArrayList<Usuario> contatos = contatosDao.buscarContatos(docenteA);
			mv.addObject("contatos", contatos);
			mv.addObject("usuarios", usuarios);

		}


		return mv;

	}

	@GetMapping("/excluirContato")
	public ModelAndView excluirContato(HttpSession session, String cpfContato){

		ContatosDao contatosDao = new ContatosDao();
		ModelAndView mv = new ModelAndView("/layout-aluno/gerenciar-contatos");
		Discente discenteA = (Discente) session.getAttribute("discente");

		Discente discenteB = new Discente();
		discenteB.setCpf(cpfContato);

		contatosDao.excluirContato(discenteA, discenteB);

		ArrayList<Usuario> usuarios = contatosDao.buscarTodosUsuarios();
		ArrayList<Usuario> contatos = contatosDao.buscarContatos(discenteA);
		mv.addObject("contatos", contatos);
		mv.addObject("usuarios", usuarios);
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
	public ModelAndView atualizarSobreNome(String sobreNome, HttpSession sessao){

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
	
	@GetMapping("/attDataNascimento")
	public ModelAndView atualizarNascimento(String dataNascimento, HttpSession sessao){
		ModelAndView mv = new ModelAndView("/layout-aluno/perfil-aluno");

		String[] datas = dataNascimento.split("-");
		int ano = Integer.parseInt(datas[0]);
		int mes = Integer.parseInt(datas[1]);
		int dia = Integer.parseInt(datas[2]);
		Calendar cal = Calendar.getInstance();
		cal.set(cal.YEAR, ano);
		cal.set(cal.MONTH, mes - 1);
		cal.set(cal.DAY_OF_MONTH, dia);
		Date nascimento = new Date(cal.getTimeInMillis());
		
		Discente discente = (Discente) sessao.getAttribute("discente");
		discente.setDataNascimento(nascimento);
		DiscenteDao discenteDao = new DiscenteDao();
		discenteDao.atualizarDiscente(discente);
		
		System.out.println(dataNascimento);
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
