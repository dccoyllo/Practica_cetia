package udaff.edu.pe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/u")
public class UsuarioController {

	@GetMapping("/perfil")
	public String pagePerfil() {
		
		return "private/user/perfil";
	}
	
	@PostMapping("/perfil")
	public String updatePerfil() {
		
		return "redirect:/u/perfil";
	}
}
