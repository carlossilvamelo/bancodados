package com.bancodados.controller;


import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bancodados.DAOs.ConnectionManager;
import com.bancodados.DAOs.DocenteDao;
import com.bancodados.DAOs.EnderecoDao;
import com.bancodados.dominio.Discente;
import com.bancodados.dominio.Docente;
import com.bancodados.dominio.Endereco;

import ch.qos.logback.core.net.SyslogOutputStream;


@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	
	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView index(){
		
		
		ModelAndView mv = new ModelAndView("index");
		
		/*try {
			Connection con = ConnectionManager.getConnection();
			if(con != null){
				System.out.println("conectado");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	
		
		
		return mv;
	}
	
	@GetMapping("/login")
	public ModelAndView login(String email,String senha){
		
		System.out.println(email);
		System.out.println(senha);
		
		ModelAndView mv = new ModelAndView("index");
		
		
		
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
		
		if(rTipo == "dis"){
			Discente discente = new Discente();
			discente.setNome(nome);
			discente.setSobreNome(sobreNome);
			discente.setEmail(email);
			discente.setSenha(senha);
			discente.setTipo(rTipo);
			
			
		}else{
			Docente docente = new Docente();
			docente.setNome(nome);
			docente.setSobreNome(sobreNome);
			docente.setEmail(email);
			docente.setSenha(senha);
			docente.setTipo(rTipo);
			
			DocenteDao docenteDao = new DocenteDao();
			try {
				docenteDao.inserirDocente(docente);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return null;
	}


	
}

