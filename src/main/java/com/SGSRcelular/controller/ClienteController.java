package com.SGSRcelular.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SGSRcelular.enumeracoes.EnumCores;
import com.SGSRcelular.enumeracoes.EnumMarcasModelos;
import com.SGSRcelular.frameworkPDS.models.Celular;
import com.SGSRcelular.frameworkPDS.models.Cliente;
import com.SGSRcelular.frameworkPDS.models.MarcaModelo;
import com.SGSRcelular.frameworkPDS.models.Servico;
import com.SGSRcelular.frameworkPDS.services.CelularService;
import com.SGSRcelular.frameworkPDS.services.ClienteService;
import com.SGSRcelular.frameworkPDS.services.MarcaModeloService;
import com.SGSRcelular.frameworkPDS.services.ServicoService;

import ch.qos.logback.core.net.SyslogOutputStream;





@Controller
@RequestMapping("/cliente")
public class ClienteController {


	@Autowired
	private ClienteService clienteService;
	@Autowired
	private CelularService celularService;
	@Autowired
	private ServicoService servicoService;
	@Autowired
	private MarcaModeloService marcaModeloService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView cliente(HttpSession session){
		
		ModelAndView mv = new ModelAndView("cliente/cliente");
		//buscar cliente pelo id
		Cliente cliente = (Cliente) session.getAttribute("usuario");
		List<Servico> listaServicos = servicoService.buscarServicosPorContratante(cliente);
		mv.addObject("listaServicos",listaServicos);
		
		return mv;
		
	}
	
	@GetMapping("/novo")
	public ModelAndView formCliente(){
		ModelAndView mv = new ModelAndView("cliente/form");
		Cliente cliente = new Cliente();
		mv.addObject("cliente", cliente);
		return mv;
		
	}
	
	@PostMapping("/novo")
	public ModelAndView salvarCliente(Cliente cliente, RedirectAttributes attributes){
		
		boolean cpfValido = true;
		ModelAndView mv = new ModelAndView("cliente/form");
		
		clienteService.inserir(cliente);
		
		/*ValidacoesService validacaoCpf = ValidacoesService.getInstance();
		try {
			
			validacaoCpf.validarCpf(cliente.getId());
			clienteService.inserir(cliente);
		} catch (CamadaServicoException e) {
			cpfValido = false;
		}*/
		mv.addObject("cpfValido", cpfValido);
		attributes.addFlashAttribute("message", "O cliente foi cadastrado!");
		return mv;
		
	}
	
	@GetMapping("/novoCelular")
	public ModelAndView formCelula(@RequestParam(name="id", required=true) String id){
		
		
		ModelAndView mv = new ModelAndView("cliente/formCelular");

		Celular celular = new Celular();
		List<String> marcas = EnumMarcasModelos.listaMarcas();
		List<String> cores = EnumCores.getCores();
	
		mv.addObject("cores", cores);
		mv.addObject("marcas", marcas);
		mv.addObject("celular", celular);
		
		return mv;
	}
	
	@PostMapping("/novoCelular")
	public ModelAndView salvarCelula(Celular celular, HttpSession session){
		
		ModelAndView mv = new ModelAndView("cliente/formCelular");
		
		Cliente cliente = (Cliente) session.getAttribute("usuario");
		
		MarcaModelo m = marcaModeloService.buscarPorMarcaModelo(celular.getMarcaModelo().getMarca(), celular.getMarcaModelo().getModelo());
		
		celular.setMarcaModelo(m);
		celular.setCliente(cliente);
		cliente.addCelular(celular);
		System.out.println(celular.getId());
		clienteService.inserir(cliente);
		mv.addObject("message", "Celular adicionado!");
		
		return mv;
	}
	
	@RequestMapping("/meusCelulares")
	public ModelAndView cadastrarVeiculo(HttpSession session){
		
		ModelAndView mv = new ModelAndView("cliente/meusCelulares");
		
		Cliente temp = (Cliente) session.getAttribute("usuario");
		Cliente cliente = (Cliente)clienteService.buscarPorId(temp.getId());
		
		
		/*
		for(Veiculo veiculo : cliente.getVeiculo()){
			
			for(Alerta alerta : veiculo.getAlertas()){
				
				System.out.println(alerta.getTipo());
			}
		}*/
		
		mv.addObject("cliente", cliente);
		return mv;
		
	}
	/*
	@GetMapping("/addInfoExtraVeiculo")
	public ModelAndView formInfoExtraVeiculo(@RequestParam(name="id", required=true) String id){

		ModelAndView mv = new ModelAndView("cliente/formInfoExtra");
		
	//	InfoExtraVeiculo infoExtraVeiculo = new InfoExtraVeiculo();
	//	Veiculo veiculo = (Veiculo)celularService.buscarPorId(id);
		
	//	mv.addObject("veiculo", veiculo);
		//mv.addObject("infoExtraVeiculo", infoExtraVeiculo);
		
		return mv;
	}
	
	@PostMapping("/addInfoExtraVeiculo")
	public ModelAndView saveInfoExtraVeiculo(InfoExtraVeiculo infoExtraVeiculo){
	
		ModelAndView mv = new ModelAndView("redirect:meusVeiculos");
		
		celularService.adicionarInfoExtra(infoExtraVeiculo);
		
		return mv;
	}
	
	@PostMapping("/removerVeiculo")
	public @ResponseBody String removerVeiculo(String id){
	
		String result = "";
		System.out.println("Remover");
		System.out.println(id);
		
		try{
			
			servicoService.deletarTodos(celularService.buscarPorId(id));
			//veiculoService.deleteAlertasVeiculo(veiculoService.buscarPorId(id));
			celularService.deletePorId(id);
			result = "Success!";
			
		}catch(DataAccessException e){
			result = "Failed!";
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
	
	*/
	@GetMapping("/listarModelos" )
	public  @ResponseBody List<String> listarModelos( String marca){
		
		
		List<String> modelos = marcaModeloService.buscarModelosPorMarca(marca);
		
		return modelos;
		
		//return null;
		
	}
	
	
}
