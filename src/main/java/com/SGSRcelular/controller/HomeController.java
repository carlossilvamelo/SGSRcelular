package com.SGSRcelular.controller;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SGSRcelular.enumeracoes.EnumMarcasModelos;
import com.SGSRcelular.frameworkPDS.models.CheckIn;
import com.SGSRcelular.frameworkPDS.models.Cliente;
import com.SGSRcelular.frameworkPDS.models.Loja;
import com.SGSRcelular.frameworkPDS.models.MarcaModelo;
import com.SGSRcelular.frameworkPDS.repository.MarcaModeloRepository;
import com.SGSRcelular.frameworkPDS.services.CheckInService;
import com.SGSRcelular.frameworkPDS.services.ClienteService;
import com.SGSRcelular.frameworkPDS.services.LojaService;



@Controller
@RequestMapping("/")
public class HomeController {
	

	
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private LojaService lojaService;
	@Autowired
	private CheckInService checkInService;
	@Autowired
	private MarcaModeloRepository mmRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(){
		
		ModelAndView mv = new ModelAndView("index");
		
		ArrayList<CheckIn> lista = (ArrayList<CheckIn>) checkInService.buscarCheckInPorId(321321);
		for (CheckIn checkIn : lista) {
			System.out.println(checkIn.getDataHora()+"  "+checkIn.getAcao());
		}
		
		MarcaModelo mm;
		
		if(mmRepository.findAll().size() == 0){
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 10; j++) {
					mm = new MarcaModelo();
					mm.setMarca(EnumMarcasModelos.getMarcaById(i).toString());
					mm.setModelo(EnumMarcasModelos.getMarcaById(i).getModeloById(j));
					mmRepository.save(mm);
				}
			}
		}
		
        return mv;
	}
	
	
	@GetMapping("/login")
	public ModelAndView login(String login, String senha){
		
		ModelAndView mv = new ModelAndView("login");
		
		return mv;
	}
	
	@GetMapping("/teste")
	public ModelAndView teste(){
		
		ModelAndView mv = new ModelAndView("teste");
		
		return mv;
	}
	
	@PostMapping("/login")
	public ModelAndView logar(String login, String senha,RedirectAttributes attributes, HttpSession session){
		
		ModelAndView mv;
		
		Cliente cliente = clienteService.buscarPorId(login);
		
		if(cliente != null){
			attributes.addFlashAttribute("message","Bem Vindo " + cliente.getNome());
			attributes.addFlashAttribute("cliente", cliente);
			session.setAttribute("usuario", cliente);
			mv = new ModelAndView("redirect:cliente");
		}
		else{
			Loja loja = lojaService.buscarPorId(login);
			
			if(loja != null){
				attributes.addFlashAttribute("message","Bem Vindo " + loja.getNome());
				attributes.addFlashAttribute("loja", loja);
				session.setAttribute("usuario", loja);
				mv = new ModelAndView("redirect:loja");
			}
			
			else{
				mv = new ModelAndView("redirect:login");
				attributes.addFlashAttribute("message","Login incorreto ou não existe!");
			}
		}
		
		return mv;
	}
	
	
}
