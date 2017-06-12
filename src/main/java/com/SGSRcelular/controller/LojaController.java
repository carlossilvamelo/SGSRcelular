package com.SGSRcelular.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SGSRcelular.enumeracoes.EnumCores;
import com.SGSRcelular.frameworkPDS.models.Celular;
import com.SGSRcelular.frameworkPDS.models.Cliente;
import com.SGSRcelular.frameworkPDS.models.Loja;
import com.SGSRcelular.frameworkPDS.models.MarcaModelo;
import com.SGSRcelular.frameworkPDS.models.Servico;
import com.SGSRcelular.frameworkPDS.services.CelularService;
import com.SGSRcelular.frameworkPDS.services.ClienteService;
import com.SGSRcelular.frameworkPDS.services.LojaService;
import com.SGSRcelular.frameworkPDS.services.ServicoService;



@Controller
@RequestMapping("/loja")
public class LojaController {
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private LojaService lojaService;
	@Autowired
	private CelularService celularService;
	@Autowired
	private ServicoService servicoService; 
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView loja(Model model, HttpSession session){
		ModelAndView mv = new ModelAndView("loja/loja");
		
		Loja loja = (Loja) session.getAttribute("usuario");
		List<Servico> listaServicos = servicoService.buscarServicosPorPrestadora(loja);
		mv.addObject("listaServicos", listaServicos);
		
		return mv;
	}
	
	
	@GetMapping("/cadastro")
	public ModelAndView formCadastroLoja(){
		ModelAndView mv = new ModelAndView("/loja/cadastro");
		Loja loja = new Loja();
		mv.addObject("loja", loja);
		return mv;
	}
	
	@PostMapping("/cadastro")
	public ModelAndView cadastroLoja(Loja loja, RedirectAttributes attributes){
		ModelAndView mv = new ModelAndView("redirect:/loja/cadastro");
		lojaService.inserir(loja);
		mv.addObject("loja", loja);
		attributes.addFlashAttribute("message", "Loja cadastrada com sucesso!");	
		return mv;
	}
	
	@RequestMapping("/todosServicos")
	public ModelAndView mostrarServicos(HttpSession session){
		
		ModelAndView mv = new ModelAndView("loja/todosServicos");
		//descer para a camada de validação
		Loja temp = (Loja) session.getAttribute("usuario");
		Loja loja = (Loja)lojaService.buscarPorId(temp.getId());
		return mv;
	}
	
	@GetMapping("/novoServico")
	public ModelAndView cadastrarServico(HttpSession session){
		ModelAndView mv = new ModelAndView("loja/novoServico");
		
		return mv;
	}
	
	@PostMapping("/novoServico")
	public ModelAndView cadastrarServico(Servico servico){
		ModelAndView mv = new ModelAndView("loja/novoServico");
		
		return mv;
	}
	
	@GetMapping("/novoCelular")
	public ModelAndView formCelular(@RequestParam(name="id", required=true) String id){
		
		
		ModelAndView mv = new ModelAndView("loja/formCelularLoja");

		Celular celular = new Celular();
		List<String> marcas = celularService.buscarMarcas();
		List<Cliente> clientes = clienteService.buscarTodos();
		
		mv.addObject("cores", EnumCores.values());
		mv.addObject("marcas", marcas);
		mv.addObject("celular", celular);
		mv.addObject("clientes", clientes);
		
		return mv;
	}
	
	@PostMapping("/novoCelular")
	public ModelAndView salvarCelular(Celular celular, HttpSession session){
		
		
		ModelAndView mv = new ModelAndView("loja/formCelularLoja");
		Cliente cliente = clienteService.buscarPorId(celular.getCliente().getId());
		if(cliente != null){
			MarcaModelo marcaModelo = celularService.buscarPorMarcaModelo(celular.getMarcaModelo().getMarca(), celular.getMarcaModelo().getModelo());
			celular.setMarcaModelo(marcaModelo);
			celular.setCliente(cliente);
			cliente.addCelular(celular);
			clienteService.inserir(cliente);
		}
		
		return mv;
	}
	
	@GetMapping("/listarModelos" )
	public  @ResponseBody List<String> listarModelos( String marca){
		
		List<String> modelos = celularService.buscarModelosPorMarca(marca);
		
		return modelos;
		
	}
	
	@GetMapping("/novoCliente")
	public ModelAndView formNovoCliente(){
		ModelAndView mv = new ModelAndView("/loja/formClienteLoja");
		Cliente cliente = new Cliente();
		mv.addObject("cliente", cliente);
		return mv;
	}
	
	@PostMapping("/novoCliente")
	public ModelAndView cadastroClienteLoja(Cliente cliente, HttpSession session){
		ModelAndView mv = new ModelAndView("redirect:/loja/");
		clienteService.inserir(cliente);
		
		return mv;
	}
	
}
