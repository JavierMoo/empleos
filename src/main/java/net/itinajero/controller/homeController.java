package net.itinajero.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import net.itinajero.model.Vacante;
import net.itinajero.service.IVacantesService;

@Controller
public class homeController {
	
	@Autowired
	private IVacantesService serviceVacantes;
	
	@GetMapping("/tabla")
	public String mostrarTablas(Model model) {
		List<Vacante> lista = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);
		 
		
		return "tabla";
	}
	
	@GetMapping("/detalle")
	public String mostrarDetalles(Model model) {
		Vacante vacante = new Vacante();
		vacante.setNombre("Influenser");
		vacante.setDescripcion("Se solicita influencer para pagar con historias de IG");
		vacante.setFecha(new Date());
		vacante.setSalario(0.0);
		
		model.addAttribute("vacante", vacante);
		
		return "detalle";
	}

	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("Influenser");
		lista.add("Profesor de Filosofia");
		lista.add("Streamer");
		lista.add("Tiktoker");
		
		model.addAttribute("empleos", lista);
		
		return "listado";
	}
	
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		
		List<Vacante> lista = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);
		
		return "home";
		
	}
	
}
