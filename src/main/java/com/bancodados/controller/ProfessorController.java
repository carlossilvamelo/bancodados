package com.bancodados.controller;

import java.util.ArrayList;
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
@RequestMapping("/layout-professor")
public class ProfessorController {

	@GetMapping("/index-professor")
	public ModelAndView indexProfessor(){

		ModelAndView mv = new ModelAndView("index-professor");


		return mv;

	}
	@GetMapping("/inicioProfessor")
	public ModelAndView inicioProfessor(HttpSession session){
		Usuario discente = (Docente) session.getAttribute("docente");
		ContatosDao contatosDao = new ContatosDao();
		ModelAndView mv = new ModelAndView("/layout-professor/index-professor");
		ArrayList<Usuario> contatos = contatosDao.buscarContatos(discente);
		mv.addObject("contatos", contatos);
		//ArrayList<Trabalho> trabalhos = consultas.buscarTrabalhos();
		//Discente discente = (Discente) session.getAttribute("discente");
		//	System.out.println(discente.getCpf());
		//Collections.shuffle(trabalhos);
		//mv.addObject("trabalhos", trabalhos);


		return mv;

	}
	@GetMapping("/addContato")
	public ModelAndView addContato(HttpSession session, String cpfContato){

		ContatosDao contatosDao = new ContatosDao();
		ModelAndView mv = new ModelAndView("/layout-professor/gerenciar-contatos");
		Usuario usuario = (Usuario) session.getAttribute("docente");

		if(usuario.getTipo().equals("dis")){
			Discente discenteA = (Discente) session.getAttribute("docente");

			Discente discenteB = new Discente();
			discenteB.setCpf(cpfContato);

			contatosDao.inserirContato(discenteA, discenteB);

			ArrayList<Usuario> usuarios = contatosDao.buscarTodosUsuarios();
			ArrayList<Usuario> contatos = contatosDao.buscarContatos(discenteA);
			mv.addObject("contatos", contatos);
			mv.addObject("usuarios", usuarios);

		}else{
			Docente docenteA = (Docente) session.getAttribute("docente");

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
		ModelAndView mv = new ModelAndView("/layout-professor/gerenciar-contatos");
		Usuario docenteA = (Docente) session.getAttribute("docente");

		Docente docenteB = new Docente();
		docenteB.setCpf(cpfContato);

		contatosDao.excluirContato(docenteA, docenteB);

		ArrayList<Usuario> usuarios = contatosDao.buscarTodosUsuarios();
		ArrayList<Usuario> contatos = contatosDao.buscarContatos(docenteA);
		mv.addObject("contatos", contatos);
		mv.addObject("usuarios", usuarios);
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
	public ModelAndView gerenciarContatos(HttpSession session){
		ContatosDao contatosDao = new ContatosDao();
		ModelAndView mv = new ModelAndView("layout-professor/gerenciar-contatos");
		Docente docente = (Docente) session.getAttribute("docente");
		ArrayList<Usuario> todosUsuarios = contatosDao.buscarTodosUsuarios();
		ArrayList<Usuario> contatos = contatosDao.buscarContatos(docente);
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		for (Usuario usuario : todosUsuarios) {
			if(!usuario.getCpf().equals(docente.getCpf())){
				usuarios.add(usuario);
			}
			for (Usuario contato : contatos) {
				if(usuario.getCpf().equals(contato.getCpf())){
					usuarios.remove(usuario);
				}
			}
			
		}
		mv.addObject("contatos", contatos);
		mv.addObject("usuarios", usuarios);

		return mv;

	}

	@GetMapping("/conversar")
	public ModelAndView conversar(HttpSession session, String cpfDestinatario){
		Docente remetente = (Docente) session.getAttribute("docente");
		ContatosDao contatosDao = new ContatosDao();
		DiscenteDao discenteDao = new DiscenteDao();
		DocenteDao docenteDao = new DocenteDao();
		UsuarioDao usuarioDao = new UsuarioDao();
		ModelAndView mv = null;
		if(usuarioDao.verificarTipoUsuarioPorCpf(cpfDestinatario).equals("dis")){
			Usuario destinatario = discenteDao.buscarDiscentePorCpf(cpfDestinatario);
			MensagemDao mensagemDao = new MensagemDao();
			 mv = new ModelAndView("/layout-professor/index-professor");
			ArrayList<Usuario> contatos = contatosDao.buscarContatos(remetente);
			mv.addObject("contatos", contatos);

			ArrayList<Mensagem> mensagens = mensagemDao.buscarMensagens(remetente, destinatario);
			mv.addObject("mensagens", mensagens);
			mv.addObject("cpfDestinatario", cpfDestinatario);
		}else{
			Usuario destinatario = docenteDao.buscarDocentePorCpf(cpfDestinatario);
			System.out.println(destinatario);
			MensagemDao mensagemDao = new MensagemDao();
			mv = new ModelAndView("/layout-professor/index-professor");
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
			Usuario Discentedestinatario = discenteDao.buscarDiscentePorCpf(destinatario);
			Usuario remetente = (Docente) session.getAttribute("docente");
			ContatosDao contatosDao = new ContatosDao();

			mensagemDao.enviarMensagem(remetente, Discentedestinatario, mensagem);

			 mv = new ModelAndView("/layout-professor/index-professor");
			System.out.println(remetente.getCpf()+" -- "+destinatario+" :"+mensagem);
			ArrayList<Usuario> contatos = contatosDao.buscarContatos(remetente);
			mv.addObject("contatos", contatos);

			ArrayList<Mensagem> mensagens = mensagemDao.buscarMensagens(remetente, Discentedestinatario);
			mv.addObject("mensagens", mensagens);
		}else{
			Usuario Discentedestinatario = docenteDao.buscarDocentePorCpf(destinatario);
			Usuario remetente = (Docente) session.getAttribute("docente");
			ContatosDao contatosDao = new ContatosDao();

			mensagemDao.enviarMensagem(remetente, Discentedestinatario, mensagem);

			 mv = new ModelAndView("/layout-professor/index-professor");
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
		Docente docente = (Docente) session.getAttribute("docente");
		ContatosDao contatosDao = new ContatosDao();
		ModelAndView mv = new ModelAndView("/layout-professor/gerenciar-contatos");
		ArrayList<Usuario> usuarios = contatosDao.buscarTodosUsuarios();
		ArrayList<Usuario> contatos = contatosDao.buscarContatos(docente);
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

	
	@GetMapping("/filtrarUsuarios")
	public ModelAndView filtrarUsuarios(HttpSession session, String filtro){
		Docente docente = (Docente) session.getAttribute("docente");
		ContatosDao contatosDao = new ContatosDao();
		ModelAndView mv = new ModelAndView("/layout-professor/gerenciar-contatos");
		ArrayList<Usuario> usuarios = contatosDao.buscarTodosUsuarios();
		ArrayList<Usuario> contatos = contatosDao.buscarContatos(docente);
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

	@GetMapping("/attNome")
	public ModelAndView atualizarNome(String nome, HttpSession sessao){

		ModelAndView mv = new ModelAndView("/layout-professor/perfil-professor");
		Docente docente = (Docente) sessao.getAttribute("docente");

		docente.setNome(nome);
		DocenteDao docenteDao = new DocenteDao();
		docenteDao.atualizarDocente(docente);


		return mv;

	}
	@GetMapping("/attCpf")
	public ModelAndView atualizarCpf(String cpf, HttpSession sessao){

		ModelAndView mv = new ModelAndView("/layout-professor/perfil-professor");
		Docente docente = (Docente) sessao.getAttribute("docente");

		docente.setCpf(cpf);
		DocenteDao docenteDao = new DocenteDao();
		docenteDao.atualizarDocente(docente);


		return mv;

	}
	@GetMapping("/attLogin")
	public ModelAndView atualizarLogin(String login, HttpSession sessao){

		ModelAndView mv = new ModelAndView("/layout-professor/perfil-professor");
		Docente docente = (Docente) sessao.getAttribute("docente");

		docente.setLogin(login);
		DocenteDao docenteDao = new DocenteDao();
		docenteDao.atualizarDocente(docente);;


		return mv;

	}

	@GetMapping("/attSenha")
	public ModelAndView atualizarSenha(String senha, HttpSession sessao){

		ModelAndView mv = new ModelAndView("/layout-professor/perfil-professor");
		Docente docente = (Docente) sessao.getAttribute("docente");

		docente.setSenha(senha);
		DocenteDao docenteDao = new DocenteDao();
		docenteDao.atualizarDocente(docente);


		return mv;

	}

	@GetMapping("/attEmail")
	public ModelAndView atualizarEmail(String email, HttpSession sessao){

		ModelAndView mv = new ModelAndView("/layout-professor/perfil-professor");
		Docente docente = (Docente) sessao.getAttribute("docente");

		docente.setEmail(email);
		DocenteDao docenteDao = new DocenteDao();
		docenteDao.atualizarDocente(docente);


		return mv;

	}
	@GetMapping("/attSobreNome")
	public ModelAndView atualizarSobreNome(String sobreNome, HttpSession sessao){

		ModelAndView mv = new ModelAndView("/layout-professor/perfil-professor");
		Docente docente = (Docente) sessao.getAttribute("docente");
		docente.setSobreNome(sobreNome);
		DocenteDao docenteDao = new DocenteDao();
		docenteDao.atualizarDocente(docente);


		return mv;

	}


	@GetMapping("/attCurriculo")
	public ModelAndView atualizarCurriculo(String curriculo, HttpSession sessao){

		ModelAndView mv = new ModelAndView("/layout-professor/perfil-professor");
		Docente docente = (Docente) sessao.getAttribute("docente");
		docente.setCurriculo(curriculo);
		DocenteDao docenteDao = new DocenteDao();
		docenteDao.atualizarDocente(docente);


		return mv;

	}
	@GetMapping("/attCep")
	public ModelAndView atualizarCep(String cep, HttpSession sessao){

		ModelAndView mv = new ModelAndView("/layout-professor/perfil-professor");
		Docente docente = (Docente) sessao.getAttribute("docente");
		docente.getEndereco().setCep(cep);
		DocenteDao docenteDao = new DocenteDao();
		docenteDao.atualizarDocente(docente);


		return mv;

	}
	@GetMapping("/attRua")
	public ModelAndView atualizarRua(String rua, HttpSession sessao){

		ModelAndView mv = new ModelAndView("/layout-professor/perfil-professor");
		Docente docente = (Docente) sessao.getAttribute("docente");

		docente.getEndereco().setRua(rua);
		DocenteDao docenteDao = new DocenteDao();
		docenteDao.atualizarDocente(docente);


		return mv;

	}
	@GetMapping("/attNumero")
	public ModelAndView atualizarNumero(String numero, HttpSession sessao){

		ModelAndView mv = new ModelAndView("/layout-professor/perfil-professor");
		Docente docente = (Docente) sessao.getAttribute("docente");

		docente.getEndereco().setNumero(Integer.parseInt(numero));
		DocenteDao docenteDao = new DocenteDao();
		docenteDao.atualizarDocente(docente);

		return mv;

	}

	@GetMapping("/logout")
	public void logout(HttpSession sessao){

		Docente docente = (Docente) sessao.getAttribute("docente");
		docente = null;

	}
	@GetMapping("/curtir")
	public void logout(Integer idTrabalho){



	}




}
