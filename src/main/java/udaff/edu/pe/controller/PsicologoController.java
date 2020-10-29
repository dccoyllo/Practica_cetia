package udaff.edu.pe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/psicologo")
public class PsicologoController {

	@GetMapping("/perfil")
	public String pagePerfil() {
		
		return "private/psicologo/perfil";
	}
}
