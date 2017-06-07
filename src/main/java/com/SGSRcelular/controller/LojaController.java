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

import com.SGSRcelular.frameworkPDS.models.Celular;
import com.SGSRcelular.frameworkPDS.models.Cliente;
import com.SGSRcelular.frameworkPDS.models.Loja;
import com.SGSRcelular.frameworkPDS.models.Servico;
import com.SGSRcelular.frameworkPDS.services.CelularService;
import com.SGSRcelular.frameworkPDS.services.ClienteService;
import com.SGSRcelular.frameworkPDS.services.LojaService;
import com.SGSRcelular.frameworkPDS.services.ServicoService;



@Controller
@RequestMapping("/oficina")
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
	public ModelAndView oficina(Model model, HttpSession session){
		ModelAndView mv = new ModelAndView("oficina/oficina");
		
		Loja oficina = (Loja) session.getAttribute("usuario");
		List<Servico> listaServicos = servicoService.buscarServicosPorPrestadora(oficina);
		mv.addObject("listaServicos", listaServicos);
		
		return mv;
	}
	
	
	@GetMapping("/cadastro")
	public ModelAndView formCadastroOficina(){
		ModelAndView mv = new ModelAndView("/oficina/cadastro");
		Loja oficina = new Loja();
		mv.addObject("oficina", oficina);
		return mv;
	}
	
	@PostMapping("/cadastro")
	public ModelAndView cadastroOficina(Loja loja, RedirectAttributes attributes){
		ModelAndView mv = new ModelAndView("redirect:/oficina/cadastro");
		lojaService.inserir(loja);
		mv.addObject("oficina", loja);
		attributes.addFlashAttribute("message", "Oficina cadastrada com sucesso!");	
		return mv;
	}
	
	@RequestMapping("/todosServicos")
	public ModelAndView mostrarServicos(HttpSession session){
		
		ModelAndView mv = new ModelAndView("oficina/todosServicos");
		//descer para a camada de validação
		Loja temp = (Loja) session.getAttribute("usuario");
		Loja loja = (Loja)lojaService.buscarPorId(temp.getId());
		return mv;
	}
	
	@GetMapping("/novoServico")
	public ModelAndView cadastrarServico(HttpSession session){
		ModelAndView mv = new ModelAndView("oficina/novoServico");
		
		return mv;
	}
	
	@PostMapping("/novoServico")
	public ModelAndView cadastrarServico(Servico servico){
		ModelAndView mv = new ModelAndView("oficina/novoServico");
		
		return mv;
	}
	
	@GetMapping("/novoVeiculo")
	public ModelAndView formVeiculo(@RequestParam(name="id", required=true) String id){
		
		
		ModelAndView mv = new ModelAndView("oficina/formVeiculoOficina");

		Celular celular = new Celular();
		//List<String> marcas = veiculoService.listarMarcas();
		//mv.addObject("cores", EnumCores.values());
		//mv.addObject("marcas", marcas);
		mv.addObject("veiculo", celular);
		
		return mv;
	}
	
	@GetMapping("/listarModelos" )
	public  @ResponseBody List<String> listarModelos( String marca){
		
		//List<String> modelos = veiculoService.listarMarcaModelo(marca);
		
		//return modelos;
		return null;
		
	}
	
	@PostMapping("/novoVeiculo")
	public ModelAndView salvarVeiculo(Celular celular, HttpSession session){
		
		
		ModelAndView mv = new ModelAndView("oficina/formVeiculoOficina");
		
		//MarcaModelo m = veiculoService.listarMarcaModelo(veiculo.getMarcaModelo().getMarca(), veiculo.getMarcaModelo().getModelo());
		
		//veiculo.setMarcaModelo(m);
		
		//veiculo.setCliente(cliente);
		//cliente.addVeiculo(veiculo);
		
		//clienteService.inserir(cliente);
		
		return mv;
	}
	
	@GetMapping("/novoCliente")
	public ModelAndView formNovoCliente(){
		ModelAndView mv = new ModelAndView("/oficina/formClienteOficina");
		Cliente cliente = new Cliente();
		mv.addObject("cliente", cliente);
		return mv;
	}
	
	@PostMapping("/novoCliente")
	public ModelAndView cadastroClienteOficina(Cliente cliente, HttpSession session){
		ModelAndView mv = new ModelAndView("redirect:/oficina/");
		clienteService.inserir(cliente);
		
		return mv;
	}
	
}
